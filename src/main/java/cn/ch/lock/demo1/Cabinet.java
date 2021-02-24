package cn.ch.lock.demo1;

/**
 * @Classname Cabinet
 * @Description
 * @create 2021/2/22
 * @Author random
 */
public class Cabinet {

    //柜子中存储的数字
    private int storeNumber;

    public synchronized void setStoreNumber(int storeNumber){
        this.storeNumber = storeNumber;
    }

    public int getStoreNumber(){
        return this.storeNumber;
    }
}
