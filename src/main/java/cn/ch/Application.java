package cn.ch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @Classname Application
 * @Description
 * @create 2021/1/25
 * @Author random
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//        new SpringApplicationBuilder(Application.class)
//                .web(WebApplicationType.SERVLET)
//                .run(args);
        SpringApplication.run(Application.class, args);
    }

}
