package org.corbin.cas.common.controller;

import com.alibaba.fastjson.JSON;
import org.corbin.cas.common.base.IdTokenSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yin
 * @date 2019/06/05
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private IdTokenSupport idTokenSupport;


    @GetMapping("/t")
    public String test(){
        return JSON.toJSONString(idTokenSupport.findAuthenticateInfo("test"));
    }

}
