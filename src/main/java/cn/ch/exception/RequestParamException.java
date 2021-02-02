package cn.ch.exception;

import cn.ch.enums.CodeEnum;
import lombok.Data;

/**
 * @Classname RequestParamException
 * @Description
 * @create 2021/2/2
 * @Author random
 */
@Data
public class RequestParamException extends RuntimeException {

    private static final long serialVersionUID = 4748844811214637041L;

    private Integer code;

    private String msg;

    public RequestParamException(CodeEnum codeEnum){
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
    }
}
