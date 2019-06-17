package org.corbin.jpa.common.dao;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yin
 * @date 2019/06/06
 */
public interface BaseDao<T,ID>extends JpaRepository<T,ID> {
}
