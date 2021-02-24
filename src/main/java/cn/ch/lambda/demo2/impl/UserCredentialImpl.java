package cn.ch.lambda.demo2.impl;

import cn.ch.lambda.demo2.IUserCredential;
import org.springframework.util.StringUtils;

/**
 * @Classname UserCredentialImpl
 * @Description
 * @create 2021/2/18
 * @Author random
 */
public class UserCredentialImpl implements IUserCredential {

    @Override
    public String verifyUser(String username) {
        if (StringUtils.pathEquals(username,"admin")){
            return "系统管理员";
        }else if (StringUtils.pathEquals(username,"userAdmin")){
            return "普通管理员";
        }else {
            return "普通用户";
        }
    }
}
