package org.corbin.cas.common.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class IdTokenSupportTest {
    @Autowired
    IdTokenSupport idTokenSupport;

    @Test
    public void authenticateStatus() {
    }

    @Test
    public void findAuthenticateInfo() {

        System.out.println(idTokenSupport.authenticateStatus(null));
        ;
    }

    @Test
    public void findAllAuthenticateInfo() {
    }

    @Test
    public void insertAuthentication() {
    }

    @Test
    public void removeAuthentication() {
    }

    @Test
    public void removeAuthenticationBatch() {
    }
}