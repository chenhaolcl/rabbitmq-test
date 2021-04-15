package cn.ch.lock.demo1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname Starter
 * @Description
 * @create 2021/2/22
 * @Author random
 */
public class Starter {

    private int num= 0;

    public static void main(String[] args) {
        Cabinet cabinet = new Cabinet();
        ExecutorService es = Executors.newFixedThreadPool(50);
        //闭锁
        CountDownLatch cdl = new CountDownLatch(5000);
        Starter starter = new Starter();
        for (int i = 0; i < 5000; i++){
            es.execute(()->{
//                User user = new User(cabinet,num);
//                user.useCabinet();
                starter.num++;
                cdl.countDown();
//                System.out.println("我是用户"+num+",我存储的数字是："+cabinet.getStoreNumber());
            });
        }
        es.shutdown();
        try {
            cdl.await();
            System.out.println(starter.num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
