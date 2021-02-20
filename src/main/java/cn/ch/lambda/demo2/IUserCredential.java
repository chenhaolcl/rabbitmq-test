package cn.ch.lambda.demo2;

import org.springframework.util.StringUtils;

/**
 * @Interfacename IUserCredential
 * @Description 用户身份认证标记接口
 * @create 2021/2/18
 * @Author random
 */
@FunctionalInterface
public interface IUserCredential {

    /**
     * 通过用户名验证用户身份
     * @param username
     * @return  返回身份信息[系统管理员、普通管理员、普通用户]
     */
    String verifyUser(String username);

    default String getVerifyUser(String username){
        if (StringUtils.pathEquals(username,"admin")){
            return  username + "系统管理员";
        }else if (StringUtils.pathEquals(username,"userAdmin")){
            return  username +"普通管理员";
        }else {
            return  username +"普通用户";
        }
    }
}
