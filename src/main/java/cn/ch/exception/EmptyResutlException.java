package cn.ch.exception;

import cn.ch.enums.CodeEnum;
import lombok.Data;

/**
 * @Classname EmptyResutlException
 * @Description
 * @create 2021/2/2
 * @Author random
 */
@Data
public class EmptyResutlException extends RuntimeException{

    private static final long serialVersionUID = -8839210969758687047L;

    private int code;
    private String msg;

    public EmptyResutlException(CodeEnum codeEnum){
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
    }
}
