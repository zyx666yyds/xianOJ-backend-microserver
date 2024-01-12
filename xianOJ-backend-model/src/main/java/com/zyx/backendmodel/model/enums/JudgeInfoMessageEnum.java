package com.zyx.backendmodel.model.enums;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 题目提交枚举
 *
 * @author zyx
 * @version 1.0
 * @date 2024/1/4 004 16:44
 */
public enum JudgeInfoMessageEnum {
    ACCEPTED("成功", "Accepted"),
    WAITING("等待中", "Waiting"),
    COMPILE_ERROR("编译错误 Error", "Compile Error"),
    TIME_LIMIT_EXCEEDED("超时", "Time Limit Exceeded"),
    MEMORY_LIMIT_EXCEEDED("内存溢出", "Memory Limit Exceeded"),
    RUNTIME_ERROR("运行错误", "Runtime Error"),
    SYSTEM_ERROR("系统错误", "System Error"),
    WRONG_ANSWER("错误回答", "Wrong Answer"),
    PRESENTATION_ERROR("展示错误", "展示错误"),
    OUTPUT_LIMIT_EXCEEDED("输出限制异常", "Output Limit Exceeded"),
    DANGEROUS_OPERATION("危险操作", "Dangerous Operation"),
    UNKNOWN("未知错误", "Unknown Error")
    ;


    private final String text;
    private final String value;

    JudgeInfoMessageEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 获取值列表
     *
     * @return
     */
    public static List<String> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    /**
     * 根据 value 获取枚举
     *
     * @param value
     * @return
     */
    public static JudgeInfoMessageEnum getEnumByValue(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (JudgeInfoMessageEnum anEnum : JudgeInfoMessageEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
