package com.zyx.backendjudgeservice.judge.codesandbox;


import com.zyx.backendjudgeservice.judge.codesandbox.impl.ExampleCodeSandbox;
import com.zyx.backendjudgeservice.judge.codesandbox.impl.RemoteCodeSandbox;
import com.zyx.backendjudgeservice.judge.codesandbox.impl.ThirdPartyCodeSandbox;

/**
 * 代码沙箱工厂（根据字符串创建指定的代码沙箱）
 * @author zyx
 * @version 1.0
 * @date 2024/1/7 007 20:33
 */
public class CodeSandboxFactory {

    /**
     * 创建代码沙箱实例
     * @param type 代码沙箱类型
     * @return
     */
    public static CodeSandbox newInstance(String type) {
        switch(type) {
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }
    }
}
