package cn.ch.lambda.demo2.impl;

import cn.ch.lambda.demo2.IMessageFormat;

/**
 * @Classname MessageFormatImpl
 * @Description
 * @create 2021/2/18
 * @Author random
 */
public class MessageFormatImpl implements IMessageFormat {

    @Override
    public String format(String message, String format) {
        System.out.println(message + "消息转换"+format);
        return message;
    }
}
