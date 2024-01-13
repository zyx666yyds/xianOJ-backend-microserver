package com.zyx.backendquestion.controller.inner;

import com.zyx.backendmodel.model.entity.Question;
import com.zyx.backendmodel.model.entity.QuestionSubmit;
import com.zyx.backendquestion.service.QuestionService;
import com.zyx.backendquestion.service.QuestionSubmitService;
import com.zyx.backendserviceclient.service.QuestionFeignClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/13 013 8:41
 */
@RestController
@RequestMapping("/inner")
public class QuestionInnerController implements QuestionFeignClient {

    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Override
    @GetMapping("/get/id")
    public Question getQuestionById(@RequestParam("questionId") long questionId) {
        return questionService.getById(questionId);
    }

    @Override
    @GetMapping("/question_submit/get/id")
    public QuestionSubmit getQuestionSubmitById(@RequestParam("questionId") long questionId) {
        return questionSubmitService.getById(questionId);
    }


    @Override
    @PostMapping("/question_submit/update")
    public Boolean updateQuestionSubmitBiId(@RequestBody QuestionSubmit questionSubmit) {
        return questionSubmitService.updateById(questionSubmit);
    }
}
