package org.corbin.cas.common.base;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * redis存取数据的扩展类
 *
 * @author yin
 * @date 2019/05/28
 */

/**
 *
 * @param <T>
 *@ Configuration 此处不添加注解，
 * 否则由于继承会有多个相同类型的bean
 * 此时依然可以读取配置文件
 */
@NoArgsConstructor
@ConfigurationProperties(prefix = "token")
@PropertySource(value = { "classpath:token-config.yml" })
public  class RedisHelper<T> extends AbstractRedisHelper<T>{

    /**
     * 从配置文件读取token的存活时间,
     * 未读取到时，默认30
     */
    @Value("${token.valid-time:30}")
    protected  Integer tokenValidTime;
//    private AbstractRedisHelper abstractRedisHelper;
//
//    public RedisHelper(AbstractRedisHelper abstractRedisHelper){
//        super();
//        this.abstractRedisHelper=abstractRedisHelper;
//    }

    @Override
    protected  Integer resetValidTime() {
        return this.tokenValidTime;
    }
}
