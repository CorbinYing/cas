package org.corbin.cas.common.domain.Auth;

import lombok.*;

import java.util.Date;

/**
 * 认证信息，记录登录用户的信息
 *
 * @author yin
 * @date 2019/05/30
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationInfo {

    /**
     * 认证用户（或第三方）的全局唯一标识
     * 用户信息的唯一凭证
     */
    protected String openId;

    /**
     * 认证用户名
     */
    private String openName;

    /**
     * 认证时间,默认使用当前时间
     */
    private Date authenticationTime;
}
