package com.zyx.backendserviceclient.service;


import com.zyx.backendmodel.model.entity.Question;
import com.zyx.backendmodel.model.entity.QuestionSubmit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 24088
 * @description 针对表【question(题目)】的数据库操作Service
 * @createDate 2024-01-03 16:01:08
 */
@FeignClient(name = "xianOJ-backend-question-service", path = "/api/question/inner  ")
public interface QuestionFeignClient {

    @GetMapping("/get/id")
    Question getQuestionById(@RequestParam("questionId") long questionId);

    @GetMapping("/question_submit/get/id")
    QuestionSubmit getQuestionSubmitById(@RequestParam("questionId") long questionId);


    @PostMapping("/question_submit/update")
    Boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmit);

    @PostMapping("/question/update")
    Boolean updateQuestionById(@RequestBody Question question);
}
