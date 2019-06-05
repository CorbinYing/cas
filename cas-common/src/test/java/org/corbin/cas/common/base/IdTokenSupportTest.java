package org.corbin.cas.common.base;

import com.alibaba.fastjson.JSON;
import org.corbin.cas.common.domain.Auth.AuthenticationInfo;
import org.corbin.cas.common.domain.token.IdToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;
import java.util.function.Supplier;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class IdTokenSupportTest {
    @Autowired
    IdTokenSupport idTokenSupport;
    @Autowired
    private AbstractRedisHelper abstractRedisHelper;

    @Test
    public void authenticateStatus() {
     System.out.println( idTokenSupport.authenticateStatus("a33952463524489fb3ff2a79790f1705"));
    }

    @Test
    public void findAuthenticateInfo() {
        System.out.println( idTokenSupport.findAuthenticateInfo("a4dcc81e340d466cb6cdad163a217116"));
    }

    @Test
    public void findAllAuthenticateInfo() {
        System.out.println( idTokenSupport.findAllAuthenticateInfo());
    }

    @Test
    public void insertAuthentication() {

        AuthenticationInfo authenticationInfo=AuthenticationInfo.builder().openId("1234").openName("李四").authenticationTime(new Date()).build();
//        if (authenticationInfo.getAuthenticationTime() == null) {
//            authenticationInfo.setAuthenticationTime(new Date());
//        }
//        String idTicket = UUID.randomUUID().toString().replaceAll("-", "");
//        Supplier<IdToken> idTokenSupplier = IdToken::new;
//        IdToken idToken = idTokenSupplier.get()
//                .setAuthenticationInfo(authenticationInfo)
//                .setTicket(idTicket);
//        Date date = new Date();
//        idToken.setCreateTime(date);
//        idToken.setUpdateTime(date);
//
//        abstractRedisHelper.putOne(idTicket,idToken);

        IdToken idToken=idTokenSupport.insertAuthentication(authenticationInfo);
        System.out.println(idToken);
    }

    @Test
    public void removeAuthentication() {
    }

    @Test
    public void removeAuthenticationBatch() {
    }
}