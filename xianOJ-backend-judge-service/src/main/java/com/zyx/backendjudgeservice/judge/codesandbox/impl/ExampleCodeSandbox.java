package com.zyx.backendjudgeservice.judge.codesandbox.impl;



import com.zyx.backendjudgeservice.judge.codesandbox.CodeSandbox;
import com.zyx.backendmodel.model.codesandbox.ExecuteCodeRequest;
import com.zyx.backendmodel.model.codesandbox.ExecuteCodeResponse;
import com.zyx.backendmodel.model.codesandbox.JudgeInfo;
import com.zyx.backendmodel.model.enums.JudgeInfoMessageEnum;
import com.zyx.backendmodel.model.enums.QuestionSubmitStatusEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 实例代码沙箱（仅为了跑通业务流程）
 *
 * @author zyx
 * @version 1.0
 * @date 2024/1/7 007 17:22
 */
@Slf4j
public class ExampleCodeSandbox implements CodeSandbox {

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();

        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setTime(100L);
        judgeInfo.setMemory(100L);

        executeCodeResponse.setJudgeInfo(judgeInfo);

        return executeCodeResponse;
    }
}
