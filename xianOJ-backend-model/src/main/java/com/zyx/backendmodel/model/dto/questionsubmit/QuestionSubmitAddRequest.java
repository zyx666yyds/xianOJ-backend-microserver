package com.zyx.backendmodel.model.dto.questionsubmit;

import lombok.Data;

import java.io.Serializable;

/**
 * 增加提交请求
 * @author zyx
 */
@Data
public class QuestionSubmitAddRequest implements Serializable {

    /**
     * 编程语言
     */
    private String language;

    /**
     * 用户代码
     */
    private String code;


    /**
     * 题目 id
     */
    private Long questionId;

    /**
     * 创建用户 id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;

}