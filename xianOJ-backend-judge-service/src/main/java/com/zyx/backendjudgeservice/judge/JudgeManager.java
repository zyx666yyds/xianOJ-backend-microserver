package com.zyx.backendjudgeservice.judge;


import com.zyx.backendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.zyx.backendjudgeservice.judge.strategy.JavaJudgeStrategy;
import com.zyx.backendjudgeservice.judge.strategy.JudgeContext;
import com.zyx.backendjudgeservice.judge.strategy.JudgeStrategy;
import com.zyx.backendmodel.model.codesandbox.JudgeInfo;
import com.zyx.backendmodel.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

import static com.zyx.backendmodel.model.enums.QuestionSubmitLanguageEnum.JAVA;


/**
 * 尽量简化对判题功能的调用
 *
 * @author zyx
 * @version 1.0
 * @date 2024/1/8 008 11:24
 */
@Service
public class JudgeManager {

    public JudgeInfo doJudge(JudgeContext judgeContext) {
        // 判题策略
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if (JAVA.getValue().equals(language)) {
            judgeStrategy = new JavaJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
