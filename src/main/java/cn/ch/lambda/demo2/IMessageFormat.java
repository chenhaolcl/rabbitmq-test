package cn.ch.lambda.demo2;

import org.springframework.util.StringUtils;

/**
 * @Interfacename IMessageFormat
 * @Description 消息传输格式化转换接口
 * @create 2021/2/18
 * @Author random
 */
@FunctionalInterface
public interface IMessageFormat {

    /**
     * 消息转换方法
     * @param message 要转换的消息
     * @param format  转换的格式[xml/json..]
     * @return 返回转换后的数据
     */
    String format(String message, String format);

    static boolean isSuccess(String message){
        if (!StringUtils.isEmpty(message)){
            return true;
        }
        return false;
    }
}
