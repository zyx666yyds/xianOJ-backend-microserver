package com.zyx.backendmodel.model.dto.question;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 更新请求
 *
 * @author 2408
 * @from a
 */
@Data
public class QuestionUpdateRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表（json 数组）
     */
    private List<String> tags;

    /**
     * 题目答案
     */
    private String answer;

    /**
     * 题目提交数
     */
    private Integer submitNum;

    /**
     * 题目通过数
     */
    private Integer acceptedNum;

    /**
     * 判题用例(json数组)
     */
    private List<QuestionJudgeCase> judgeCase;

    /**
     * 判题配置(json)
     */
    private QuestionJudgeConfig judgeConfig;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}