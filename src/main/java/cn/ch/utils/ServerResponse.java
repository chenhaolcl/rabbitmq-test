package cn.ch.utils;

import lombok.Data;

/**
 * @Classname ServerResponse
 * @Description
 * @create 2021/2/2
 * @Author random
 */
@Data
public class ServerResponse {

    private Integer status;

    private String msg;

    private Object data;

    public ServerResponse(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ServerResponse(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public static ServerResponse success(){return new ServerResponse(200,"success");}

    public static ServerResponse success(Object data){
        return new ServerResponse(200, "success", data);
    }

    public static ServerResponse error(String msg){
        return new ServerResponse(500, msg);
    }

    public static ServerResponse error(Integer status, String msg){
        return new ServerResponse(status, msg);
    }
}
