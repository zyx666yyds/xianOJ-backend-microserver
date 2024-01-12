package com.zyx.backendjudgeservice.judge.codesandbox;


import com.zyx.backendmodel.model.codesandbox.ExecuteCodeRequest;
import com.zyx.backendmodel.model.codesandbox.ExecuteCodeResponse;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/7 007 17:22
 */
public interface CodeSandbox {

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
