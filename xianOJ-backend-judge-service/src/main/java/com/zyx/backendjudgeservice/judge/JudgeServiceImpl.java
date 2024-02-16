package com.zyx.backendjudgeservice.judge;

import cn.hutool.json.JSONUtil;
import com.zyx.backendcommon.common.ErrorCode;
import com.zyx.backendcommon.exception.BusinessException;
import com.zyx.backendjudgeservice.judge.codesandbox.CodeSandbox;
import com.zyx.backendjudgeservice.judge.codesandbox.CodeSandboxFactory;
import com.zyx.backendjudgeservice.judge.codesandbox.CodeSandboxProxy;
import com.zyx.backendjudgeservice.judge.strategy.JudgeContext;
import com.zyx.backendmodel.model.codesandbox.ExecuteCodeRequest;
import com.zyx.backendmodel.model.codesandbox.ExecuteCodeResponse;
import com.zyx.backendmodel.model.codesandbox.JudgeInfo;
import com.zyx.backendmodel.model.dto.question.QuestionJudgeCase;
import com.zyx.backendmodel.model.entity.Question;
import com.zyx.backendmodel.model.entity.QuestionSubmit;
import com.zyx.backendmodel.model.enums.QuestionSubmitStatusEnum;
import com.zyx.backendserviceclient.service.QuestionFeignClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/8 008 9:59
 */
@Service
public class JudgeServiceImpl implements JudgeService {

    @Value("${codesandbox.type}")
    private String type;

    @Resource
    private QuestionFeignClient questionFeignClient;

    @Resource
    private JudgeManager judgeManager;



    @Override
    public QuestionSubmit doJudge(long questionSubmitId) {
        // 1.传入题目提交的id，查询题目提交记录
        QuestionSubmit questionSubmit = questionFeignClient.getQuestionSubmitById(questionSubmitId);
        if (questionSubmit == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "题目提交不存在");
        }

        Long questionId = questionSubmit.getQuestionId();
        Question question = questionFeignClient.getQuestionById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "题目不存在");
        }
        // 2.如果不为等待状态
        if (!questionSubmit.getStatus().equals(QuestionSubmitStatusEnum.WAITING.getValue())) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "题目正在判题");
        }
        // 3.更新题目提交状态
        QuestionSubmit questionSubmitUpdate = new QuestionSubmit();
        questionSubmitUpdate.setId(questionSubmitId);
        questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.RUNNING.getValue());
        boolean updateById = questionFeignClient.updateQuestionSubmitById(questionSubmitUpdate);
        if (!updateById) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "更新题目提交状态失败");
        }
        // 4.调用沙箱，获取到执行结果
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        String language = questionSubmit.getLanguage();
        String code = questionSubmit.getCode();
        //获取输入用例
        String judgeCase = question.getJudgeCase();
        List<QuestionJudgeCase> judgeCaseList = JSONUtil.toList(judgeCase, QuestionJudgeCase.class);
        List<String> inputList = judgeCaseList.stream().map(QuestionJudgeCase::getInput).collect(Collectors.toList());

        ExecuteCodeRequest builder = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(builder);
        List<String> outputList = executeCodeResponse.getOutputList();
        // 5.根据沙箱执行结果，设置题目的判题状态和信息
        JudgeContext judgeContext = new JudgeContext();
        judgeContext.setJudgeInfo(executeCodeResponse.getJudgeInfo());
        judgeContext.setInputList(inputList);
        judgeContext.setOutputList(outputList);
        judgeContext.setJudgeCaseList(judgeCaseList);
        judgeContext.setQuestion(question);
        judgeContext.setQuestionSubmit(questionSubmit);


        JudgeInfo judgeInfo = judgeManager.doJudge(judgeContext);

        // 6.修改数据库中的判题结果
        questionSubmitUpdate = new QuestionSubmit();
        questionSubmitUpdate.setId(questionSubmitId);
        questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        if (questionSubmitUpdate.getStatus() == 2){
            question.setAcceptedNum(question.getAcceptedNum() + 1);
            questionFeignClient.updateQuestionById(question);
        }

        questionSubmitUpdate.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo));
        updateById = questionFeignClient.updateQuestionSubmitById(questionSubmitUpdate);
        if (!updateById) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "更新题目提交状态失败");
        }


        return questionFeignClient.getQuestionSubmitById(questionId);
    }
}
