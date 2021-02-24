package cn.ch.lambda.demo5;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname Test05
 * @Description
 * @create 2021/2/19
 * @Author random
 */
public class Test05 {
    public static void main(String[] args) {
        //1.获取Stream对象
        //多个数据
        Stream stream01 = Stream.of("admin","ame","maybe");
        //数组
        String[] array = new String[]{"admin","ame","maybe"};
        Stream stream02 = Arrays.stream(array);

        //列表
        List<String> list = new ArrayList<>();
        list.add("ame");
        list.add("black");
        list.add("maybe");
        Stream stream03 = list.stream();
        //集合
        Set<String> set = new HashSet<>();
        set.add("hao");
        set.add("mu");
        set.add("xiao8");
        Stream stream04 = set.stream();
        //Map
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"ig");
        map.put(4,"newbee");
        map.put(6,"wings");
        Stream stream05 = map.entrySet().stream();

        //2.Stream流转换为
        //数组
        Object[] arrays = stream02.toArray(String[]::new);
        //字符串
        String str = stream01.collect(Collectors.joining()).toString();
        //列表
        List<String> list1 = (List<String>) stream03.collect(Collectors.toList());
        //集合
        Set<String> set1 = (Set<String>) stream04.collect(Collectors.toSet());
        //Map
        Map<Integer,String> map1 = (Map<Integer, String>) stream05.collect(Collectors.toMap(x->x,y->y));
        System.out.println(map);
        System.out.println(map1);
    }
}
