package cn.ch.lambda.demo2;

import cn.ch.lambda.demo2.impl.MessageFormatImpl;
import cn.ch.lambda.demo2.impl.UserCredentialImpl;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.UUID;
import java.util.function.*;

/**
 * @Classname Test
 * @Description
 * @create 2021/2/18
 * @Author random
 */
public class Test {

    public static void main(String[] args) {
//        IUserCredential uc = new UserCredentialImpl();
//        System.out.println(uc.verifyUser("admin"));
//        System.out.println(uc.getVerifyUser("admin"));
//        //匿名内部类
//        IUserCredential ic1 = new IUserCredential() {
//            @Override
//            public String verifyUser(String username) {
//                return "admin".equals(username) ? "管理员" : "用户";
//            }
//        };
//        System.out.println(ic1.verifyUser("admin"));
//        //lambda表达式
//        IUserCredential ic2 = (String username)->{
//            return "admin".equals(username) ? "lambda管理员" : "lambda用户";
//        };
//        System.out.println(ic2.verifyUser("admin"));
//
//        String message = "hello";
//        if (IMessageFormat.isSuccess(message)) {
//            IMessageFormat im = new MessageFormatImpl();
//            im.format(message, "json");
//        }
//
//        /*
//            java.util.function提供了大量的函数式接口
//            Predicate 接收参数T对象，返回一个boolean类型结果
//            Consumer 接收参数T对象，没有返回值
//            Function 接收参数T对象，返回R对象
//            Supplier 不接收任何参数，直接通过get()获取指定类型的对象
//            UnaryOperator 接收参数T对象，执行业务处理后，返回更新后的T对象
//            BinaryOperator 接口接受两个T对象，执行业务处理后，返回一个T对象
//         */
//        Predicate<String> predicate = (String msg) -> {
//            return StringUtils.isEmpty(msg);
//        };
//        Consumer<String> consumer = (String msg) -> {
//            System.out.println(msg);
//        };
//        Function<String,Integer> function = (String username) -> {
//            if (StringUtils.pathEquals(username,"admin")){
//                return 0;
//            }
//            return 1;
//        };
//        Supplier<String> supplier = () -> {
//            return UUID.randomUUID().toString();
//        };
//        UnaryOperator<String> unaryOperator = (String msg) ->{
//            return msg + "a";
//        };
//        BinaryOperator<String> binaryOperator = (String msg1, String msg2)->{
//            return msg1 + msg2;
//        };
//        Runnable runnable = ()->{
//            System.out.println(1);
//        };

        System.out.println(System.currentTimeMillis());

    }
}
