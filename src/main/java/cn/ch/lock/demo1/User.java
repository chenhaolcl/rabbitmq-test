package cn.ch.lock.demo1;

/**
 * @Classname User
 * @Description
 * @create 2021/2/22
 * @Author random
 */
public class User {
    //柜子
    private Cabinet cabinet;
    //存储的数字
    private int storeNumber;

    public User(Cabinet cabinet,int storeNumber){
        this.cabinet = cabinet;
        this.storeNumber = storeNumber;
    }

    //使用柜子
    public void useCabinet(){
        cabinet.setStoreNumber(storeNumber);
    }
}
