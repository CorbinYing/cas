package org.corbin.cas.common.domain.token;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 基础token
 *
 * @author yin
 * @date 2019/05/30
 */
@Getter
@Setter
public abstract class AbstractToken {

    /**
     * token创建时间
     */
    protected Date createTime;

    /**
     * token最近更新时间
     */
    protected Date updateTime;


}
