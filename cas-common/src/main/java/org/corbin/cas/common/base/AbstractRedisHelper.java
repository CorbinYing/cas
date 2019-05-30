package org.corbin.cas.common.base;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 存取redis中数据的封装类，
 * 提供增删改查的功能
 *
 * @author yin
 * @date 2019/05/27
 */
@Configuration
public abstract class AbstractRedisHelper<T> {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 数据有效时长，单位:分钟
     */
    protected Integer validTime ;

    /**
     * 删除指定键值对
     *
     * @param key
     * @author yin
     * @date 2019/05/28
     */
    @SuppressWarnings("unchecked")
    protected void removeOne(@NonNull String key) {
        redisTemplate.delete(key);
    }

    /**
     * 根据keyList批量删除
     *
     * @param keyList
     */
    protected void removeBatch(@NonNull List<String> keyList) {
        keyList.forEach(key -> removeOne(key));
    }

    /**
     * 根据键得到值
     *
     * @param key
     * @author yin
     * @date 2019/05/28
     */
    @SuppressWarnings("unchecked")
    protected T getOne(@NonNull String key) {
        return (T) redisTemplate.opsForValue().get(key);

    }

    /**
     * 根据keyList获取对应的map值
     *
     * @param keyList
     * @return
     */
    protected Map<String, T> getBatch(List<String> keyList) {
        Assert.notNull(keyList, "key source can not be null");

        Map<String, T> map = Maps.newHashMap();
        keyList.forEach(key -> map.put(key, getOne(key)));

        return map;
    }

    /**
     * 添加一组key-value 值
     *
     * @param key
     * @param value
     */
    @SuppressWarnings("unchecked")
    protected void putOne(String key, T value) {
        System.out.println(resetValidTime());
        redisTemplate.opsForValue().set(key, value, resetValidTime() == null ? validTime : resetValidTime(), TimeUnit.MINUTES);

    }


    /**
     * 添加多个key-value键值对
     *
     * @param map
     */
    protected void putBatch(Map<String, T> map) {
        Assert.notNull(map, "source can not be null");
        map.entrySet().forEach((entry) -> putOne(entry.getKey(), entry.getValue()));
    }

    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    protected boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 重置最长数据有效时长，单位:分钟
     *
     * @return
     */
    protected abstract Integer resetValidTime();

    /**
     * 获取所有key
     *
     * @author yin
     * @date 2019/05/29
     */
    protected List<String> getAllKeysWithPattern(String pattern) {
        Set<String> keySet = redisTemplate.keys(pattern);
        return keySet == null || keySet.size() == 0 ? null : Lists.newArrayList(keySet);
    }

}
