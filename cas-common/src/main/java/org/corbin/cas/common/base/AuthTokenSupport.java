package org.corbin.cas.common.base;

import org.corbin.cas.common.domain.Auth.AuthenticationInfo;
import org.springframework.context.annotation.Configuration;

/**
 * @author yin
 * @date 2019/06/05
 */
@Configuration
public class AuthTokenSupport extends RedisHelper<AuthenticationInfo> {
}
