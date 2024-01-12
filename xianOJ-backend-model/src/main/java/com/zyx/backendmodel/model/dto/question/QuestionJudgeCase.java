package com.zyx.backendmodel.model.dto.question;

import lombok.Data;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/3 003 16:40
 * 判断用例
 */
@Data
public class QuestionJudgeCase {
    /**
     * 输入用例
     */
    private String input;

    /**
     * 输出用例
     */
    private String output;

}
