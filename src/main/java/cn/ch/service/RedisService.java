package cn.ch.service;

import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;

/**
 * @Interfacename redisService
 * @Description
 * @create 2021/2/7
 * @Author random
 */
public interface RedisService{

    Set<ZSetOperations.TypedTuple<String>> getTop100();

    long getPerson(String value);

}
