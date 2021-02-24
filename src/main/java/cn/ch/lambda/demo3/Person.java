package cn.ch.lambda.demo3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname Person
 * @Description
 * @create 2021/2/19
 * @Author random
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private Integer age;
    private String sex;

    public static int compareByAge(Person p1, Person p2){
        return p1.getAge() - p2.getAge();
    }
}
