package com.icusin.dao.mapper;

import com.icusin.dao.po.UserLogPO;
import org.springframework.stereotype.Repository;

/**
 * @author brainy
 * @date 2017-12-20 19:51
 */
@Repository
public interface UserLogMapper {

    /**
     * 普通插入
     *
     * @param userLogPO 持久化信息
     * @return 插入结果
     */
    int insert(UserLogPO userLogPO);

    /**
     * 选择不为空的插入
     *
     * @param userLogPO 持久化信息
     * @return 插入结果
     */
    int insertSelective(UserLogPO userLogPO);

    /**
     * 根据id查询用户日志
     *
     * @param id 记录标识
     * @return 用户日志
     */
    UserLogPO selectByPrimaryKey(Integer id);

    /**
     * 选择不为空的更新
     *
     * @param userLogPO 持久化信息
     * @return 更新结果
     */
    int updateByPrimaryKeySelective(UserLogPO userLogPO);

    /**
     * 普通更新
     *
     * @param userLogPO 持久化信息
     * @return 更新结果
     */
    int updateByPrimaryKey(UserLogPO userLogPO);
}