package com.zyx.backendmodel.model.codesandbox;

import lombok.Data;

/**
 * @author zyx
 * @version 1.0
 * @date 2024/1/3 003 19:51
 * 判题信息
 */
@Data
public class JudgeInfo {

    /**
     * 程序执行信息
     */
    private String message;

    /**
     * 执行时间（ms）
     */
    private Long time;

    /**
     * 消耗内存（kb）
     */
    private Long memory;
}
