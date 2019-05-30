package org.corbin.cas.common.util;

import jdk.nashorn.internal.parser.Token;
import org.springframework.lang.Nullable;

import java.util.Collection;
import java.util.Map;

/**
 * @author yin
 * @date 2019/05/30
 */
public class ParamUtil {
    /**
     * * 判断字符串是否为空,
     * * 字符串为空或==“”返回true，
     * * 返回false
     *
     * @param arg
     * @author yin
     * @date 2019/05/30
     */
    public static boolean isStringNull(@Nullable String arg) {
        return (arg == null || "".equals(arg));
    }

    /**
     * * 判断字符串是否非空,
     * * 字符串非空或==“”返回true，
     * * 返回false
     *
     * @param arg
     * @author yin
     * @date 2019/05/30
     */
    public static final boolean isStringNotNull(@Nullable String arg) {
        return !isStringNull(arg);
    }

    /**
     * * * 判断一个集合是否为空
     * * * 为空返回true，
     * * * 非空返回false
     *
     * @param collection
     * @author yin
     * @date 2019/05/30
     */
    public   static  boolean  isCollectionNull(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * * * 判断一个集合是否为空
     * * * * 非空返回true，
     * * * * 空返回false
     *
     * @param collection
     * @author yin
     * @date 2019/05/30
     */

    public static boolean isCollectionNotNull(Collection<?> collection) {
        return !isCollectionNull(collection);
    }

    /**
     * * 判断一个map是否为空，
     * * 为空返回true，非空返回false
     *
     * @param map
     * @author yin
     * @date 2019/05/30
     */
    public static boolean isMapNull(Map map) {
        return map == null || map.isEmpty();
    }


    /**
     * * 判断一个map是否为空，
     * * 非空返回true，空返回false
     *
     * @param map
     * @author yin
     * @date 2019/05/30
     */
    public static boolean isMapNotNull(Map map) {
        return map == null || map.isEmpty();
    }
}
