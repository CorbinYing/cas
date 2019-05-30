package org.corbin.cas.common.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AbstractRedisHelperTest {

    @Autowired
    private RedisHelper abstractRedisHelper;
    @Test
    public void putOne() {
        abstractRedisHelper.putOne("test","123");
      //  System.out.println(abstractRedisHelper.validTime);
      //  System.out.println(abstractRedisHelper.tokenValidTime);
    }
}