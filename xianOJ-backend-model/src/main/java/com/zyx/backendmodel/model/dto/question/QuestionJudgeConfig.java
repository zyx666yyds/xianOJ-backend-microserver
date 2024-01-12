package com.zyx.backendmodel.model.dto.question;

import lombok.Data;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/3 003 16:40
 * 判断配置
 */
@Data
public class QuestionJudgeConfig {
    /**
     * 时间限制（ms）
     */
    private Long timeLimit;

    /**
     * 内存限制（kb）
     */
    private Long memoryLimit;

    /**
     * 堆栈限制（kb）
     */
    private Long stackLimit;


}
