package cn.ch.lambda;

/**
 * @Classname Demo01
 * @Description
 * @create 2021/2/18
 * @Author random
 */
public class Demo01 {

    public static void main(String[] args) {

        //传统模式下，新线程的创建
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threading..."+Thread.currentThread().getId());
            }
        }).start();

        //Lambda表达式优化线程模式
        new Thread(()->{
            System.out.println("lambda threading..."+Thread.currentThread().getId());
        }).start();

    }


}
