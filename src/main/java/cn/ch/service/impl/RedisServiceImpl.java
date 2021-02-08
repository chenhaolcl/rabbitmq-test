package cn.ch.service.impl;

import cn.ch.service.BaseService;
import cn.ch.service.RedisService;
import cn.ch.utils.RedisOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Classname redisServiceImpl
 * @Description
 * @create 2021/2/7
 * @Author random
 */
@Service
@Slf4j
public class RedisServiceImpl extends BaseService implements RedisService {

    @Autowired
    private RedisOperator redisOperator;

    @Override
    public Set<ZSetOperations.TypedTuple<String>> getTop100() {
        return redisOperator.zrevRangeWithScore(REDIS_KEY,0,99);
    }

    @Override
    public long getPerson(String value) {
        return redisOperator.zrecRank(REDIS_KEY,value);
    }
}
