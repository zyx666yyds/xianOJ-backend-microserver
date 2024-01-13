package com.zyx.backendjudgeservice.controller.inner;

import com.zyx.backendjudgeservice.judge.JudgeService;
import com.zyx.backendmodel.model.entity.QuestionSubmit;
import com.zyx.backendserviceclient.service.JudgeFeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/13 013 8:48
 */
@RestController
@RequestMapping("/inner")

public class JudgeInnerController implements JudgeFeignClient {

    @Resource
    private JudgeService judgeService;

    /**
     * 判题
     *
     * @param questionSubmitId
     * @return
     */
    @Override
    @PostMapping("/do")
    public QuestionSubmit doJudge(@RequestParam("questionSubmitId") long questionSubmitId) {
        return judgeService.doJudge(questionSubmitId);
    }
}
