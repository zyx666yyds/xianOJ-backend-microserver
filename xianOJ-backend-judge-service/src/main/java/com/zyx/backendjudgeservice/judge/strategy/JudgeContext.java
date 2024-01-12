package com.zyx.backendjudgeservice.judge.strategy;


import com.zyx.backendmodel.model.codesandbox.JudgeInfo;
import com.zyx.backendmodel.model.dto.question.QuestionJudgeCase;
import com.zyx.backendmodel.model.entity.Question;
import com.zyx.backendmodel.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 上下文（用于定义在策略中传递的参数）
 * @author zyx
 * @version 1.0
 * @date 2024/1/8 008 10:53
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<QuestionJudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;
}
