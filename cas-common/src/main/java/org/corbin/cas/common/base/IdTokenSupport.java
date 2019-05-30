package org.corbin.cas.common.base;

import com.google.common.collect.Lists;
import lombok.NoArgsConstructor;
import org.corbin.cas.common.domain.Auth.AuthenticationInfo;
import org.corbin.cas.common.domain.token.IdToken;
import org.corbin.cas.common.util.ParamUtil;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;

/**
 * idtoken support提供idtoken相关方法支持，
 * 用于用户的登录状态检查、注销、登录等相关操作的支持
 *
 * @author yin
 * @date 2019/05/29
 */
@Component
@NoArgsConstructor
public class IdTokenSupport extends RedisHelper<IdToken> {
    private static final String ID_TOKEN_PREFIX = "ID_TOKEN_";

    /**
     * 根据idTicket验证idToken是否存在，
     * 判断用户是否认证登录
     * true->已认证
     * false->未认证
     *
     * @param idTicket
     * @return
     */
    public boolean authenticateStatus(@NonNull String idTicket) {
        return hasKey(ID_TOKEN_PREFIX + idTicket);
    }


    /**
     * 查找指定的认证信息
     *
     * @param idTicket
     * @return
     */
    public IdToken findAuthenticateInfo(@NonNull String idTicket) {
        return getOne(ID_TOKEN_PREFIX + idTicket);
    }

    /**
     * 查找所有认证用户的信息
     *
     * @author yin
     * @date 2019/05/30
     */
    public List<IdToken> findAllAuthenticateInfo() {
        List<String> keys = getAllKeysWithPattern(ID_TOKEN_PREFIX + "*");
        if (ParamUtil.isCollectionNull(keys)) {
            return null;
        }

        Map<String, IdToken> map = getBatch(keys);
        List<IdToken> idTokenList = Lists.newArrayList();

        if (ParamUtil.isMapNull(map)) {
            return null;
        }

        map.entrySet().forEach(entry -> idTokenList.add(entry.getValue()));
        return idTokenList;
    }


    /**
     * 新增认证信息（用户）
     *
     * @return
     */
    public IdToken insertAuthentication(@NonNull AuthenticationInfo authenticationInfo) {
        if (authenticationInfo.getAuthenticationTime() == null) {
            authenticationInfo.setAuthenticationTime(new Date());
        }
        String idTicket = UUID.randomUUID().toString().replaceAll("-", "");
        Supplier<IdToken> idTokenSupplier = IdToken::new;
        IdToken idToken = idTokenSupplier.get()
                .setAuthenticationInfo(authenticationInfo)
                .setTicket(idTicket);
        Date date = new Date();
        idToken.setCreateTime(date);
        idToken.setUpdateTime(date);

        putOne(ID_TOKEN_PREFIX + idTicket, idToken);
        return idToken;
    }

    /**
     * 删除单个认证idtoken
     *
     * @param idTicket
     */
    public void removeAuthentication(@NonNull String idTicket) {
        removeOne(ID_TOKEN_PREFIX + idTicket);
    }

/**
* @author yin
* @date 2019/05/30 
* @param idTicketList
*/
    public void removeAuthenticationBatch(@NonNull List<String> idTicketList) {
        if (ParamUtil.isCollectionNotNull(idTicketList)) {
            idTicketList.forEach(key -> removeAuthentication(key));
        }
    }


}
