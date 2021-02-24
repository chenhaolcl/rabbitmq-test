package cn.ch.lambda.demo3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname Test03
 * @Description
 * @create 2021/2/19
 * @Author random
 */
public class Test03 {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("jack",15,"男"));
        personList.add(new Person("jams",21,"女"));
        personList.add(new Person("ame",23,"男"));
        personList.add(new Person("maybe",25,"男"));
        personList.add(new Person("black",42,"男"));

        //1.匿名内部类实现方式
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        //2.lambda表达式
        Collections.sort(personList,(p1,p2)->{return p1.getAge() - p2.getAge();});

        //3.静态方法引用实现
        Collections.sort(personList,Person::compareByAge);

        //4.实例方法引用实现
        PersonUtil pu = new PersonUtil();
        Collections.sort(personList, pu::compareByName);

        //5.构造方法引用:绑定函数式接口
        IPerson ip = Person::new;
        Person person = ip.initPerson("zs",18,"男");
        System.out.println(person);
        System.out.println(personList);
    }
}
