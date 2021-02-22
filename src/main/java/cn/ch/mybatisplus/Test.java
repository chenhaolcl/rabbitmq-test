package cn.ch.mybatisplus;

import cn.ch.mybatisplus.mapper.UserMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Wrapper;
import java.util.List;

/**
 * @Classname Test
 * @Description
 * @create 2021/2/20
 * @Author random
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private UserMapper userMapper;

    @org.junit.Test
    public void testSelect(){
        List<User> userList = userMapper.selectList(null);
        User user = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getName,"jack"));
        userList.forEach(s-> System.out.println(s.getName()));
        System.out.println(user);
    }

}
