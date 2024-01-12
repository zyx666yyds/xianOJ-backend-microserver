package com.zyx.backendserviceclient.service;


import com.zyx.backendmodel.model.entity.QuestionSubmit;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/8 008 9:50
 */
public interface JudgeService {

    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
