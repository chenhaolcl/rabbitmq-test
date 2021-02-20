package cn.ch.lambda.demo3;

/**
 * @Classname PersonUtil
 * @Description
 * @create 2021/2/19
 * @Author random
 */
public class PersonUtil {

    public int compareByName(Person p1, Person p2){
        return p1.getName().hashCode() - p2.getName().hashCode();
    }

}
