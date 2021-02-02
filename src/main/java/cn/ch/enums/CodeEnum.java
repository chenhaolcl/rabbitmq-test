package cn.ch.enums;

import lombok.Getter;

/**
 * @Enumname CodeEnum
 * @Description
 * @create 2021/2/1
 * @Author random
 */
@Getter
public enum CodeEnum {
    SUCCESS(0,"请求成功"),
    ERROR(500,"未知异常"),
    ERROR_EMPTY_RESULT(1001,"查询结果为空"),
    ERROR_INCOMPLETE_RESULT(1002,"请求参数不全");

    private int code;
    private String msg;

    CodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
