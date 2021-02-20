package cn.ch.lambda.demo4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname Test04
 * @Description
 * @create 2021/2/19
 * @Author random
 */
public class Test04 {

    public static void main(String[] args) {
        //存储多个账号的列表
        List<String> accouts = new ArrayList<>();
        accouts.add("ame");
        accouts.add("maybe");
        accouts.add("chlice");
        accouts.add("fy");
        accouts.add("black");

        //业务要求：长度大于等于5的有效账号
        //1.1 for循环
        for (String accout : accouts) {
            if (accout.length() >= 5){
                System.out.println("有效账号：" + accout);
            }
        }
        //1.2 迭代方式
        Iterator<String> it = accouts.iterator();
        while (it.hasNext()){
            String accout = it.next();
            if (accout.length() >= 5){
                System.out.println("有效账号："+accout);
            }
        }
        //1.3 Stream结合lambda表达式，完成业务处理
        List validAccouts = accouts.stream().filter(s -> s.length()>=5).collect(Collectors.toList());
        System.out.println(validAccouts);
    }
}
