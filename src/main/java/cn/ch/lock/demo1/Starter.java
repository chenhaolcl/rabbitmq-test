package cn.ch.lock.demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname Starter
 * @Description
 * @create 2021/2/22
 * @Author random
 */
public class Starter {
    public static void main(String[] args) {
        Cabinet cabinet = new Cabinet();
        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++){
            final int num = i;
            es.execute(()->{
                User user = new User(cabinet,num);
                user.useCabinet();
                System.out.println("我是用户"+num+",我存储的数字是："+cabinet.getStoreNumber());
            });
        }
        es.shutdown();
    }
}
