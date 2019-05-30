package org.corbin.cas.common.domain.token;

import lombok.*;
import lombok.experimental.Accessors;
import org.corbin.cas.common.domain.Auth.AuthenticationInfo;

/**
 * 用户的登录令牌信息类，
 * 只记录用户的登录状态，
 * 不做授权之用
 *
 * @author yin
 * @date 2019/05/29
 */
@Accessors(chain = true)
@Getter
@Setter
public class IdToken extends AbstractToken {



    /**
     * 用户登录时生成的唯一的ticket
     * 全局唯一，是用户是否登录的唯一凭证，
     * 但具有时效性
     */
    protected String ticket;

    /**
     * 认证信息
     */
    private AuthenticationInfo authenticationInfo;

}
