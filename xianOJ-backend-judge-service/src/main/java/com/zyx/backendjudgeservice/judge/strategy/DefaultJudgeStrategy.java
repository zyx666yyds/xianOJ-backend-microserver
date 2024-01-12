package com.zyx.backendjudgeservice.judge.strategy;

import cn.hutool.json.JSONUtil;
import com.zyx.backendmodel.model.codesandbox.JudgeInfo;
import com.zyx.backendmodel.model.dto.question.QuestionJudgeCase;
import com.zyx.backendmodel.model.dto.question.QuestionJudgeConfig;
import com.zyx.backendmodel.model.entity.Question;
import com.zyx.backendmodel.model.enums.JudgeInfoMessageEnum;


import java.util.List;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/8 008 10:56
 */
public class DefaultJudgeStrategy implements JudgeStrategy {
    @Override
    public JudgeInfo doJudge(JudgeContext judgeContext) {


        JudgeInfo judgeInfo = judgeContext.getJudgeInfo();
        Long memory = judgeInfo.getMemory();
        Long time = judgeInfo.getTime();
        List<String> inputList = judgeContext.getInputList();
        List<String> outputList = judgeContext.getOutputList();
        Question question = judgeContext.getQuestion();
        List<QuestionJudgeCase> judgeCaseList = judgeContext.getJudgeCaseList();
        JudgeInfo judgeInfoResponse = new JudgeInfo();
        JudgeInfoMessageEnum judgeInfoMessageEnum = JudgeInfoMessageEnum.ACCEPTED;

        judgeInfoResponse.setTime(time);
        judgeInfoResponse.setMemory(memory);


        if (outputList.size() != inputList.size()) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }
        for (int i = 0; i < judgeCaseList.size(); i++) {
            QuestionJudgeCase questionJudgeCase = judgeCaseList.get(i);
            if (!questionJudgeCase.getOutput().equals(outputList.get(i))) {
                judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
                judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
                return judgeInfoResponse;
            }
        }

        // 判断题目限制
        String judgeConfigStr = question.getJudgeConfig();
        QuestionJudgeConfig questionJudgeConfig = JSONUtil.toBean(judgeConfigStr, QuestionJudgeConfig.class);
        Long memoryLimit = questionJudgeConfig.getMemoryLimit();
        Long timeLimit = questionJudgeConfig.getTimeLimit();
        if (memory > memoryLimit) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.MEMORY_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }
        if (time > timeLimit) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.TIME_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }
        judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
        return judgeInfoResponse;
    }
}
