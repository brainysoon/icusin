package com.icusin.dao.mapper;

import com.icusin.dao.po.UserCusinRelPO;
import org.springframework.stereotype.Repository;

/**
 * @author brainy
 * @date 2017-12-20 19:58
 */
@Repository
public interface UserCusinRelMapper {

    /**
     * 普通插入
     *
     * @param userCusinRelPO 持久化信息
     * @return 插入结果
     */
    int insert(UserCusinRelPO userCusinRelPO);

    /**
     * 选择不为空的插入
     *
     * @param userCusinRelPO 持久化信息
     * @return 插入结果
     */
    int insertSelective(UserCusinRelPO userCusinRelPO);

    /**
     * 根据id查询
     *
     * @param id 记录标识
     * @return 用户关系
     */
    UserCusinRelPO selectByPrimaryKey(Integer id);

    /**
     * 选择不为空的更新
     *
     * @param userCusinRelPO 持久化信息
     * @return 更新结果
     */
    int updateByPrimaryKeySelective(UserCusinRelPO userCusinRelPO);

    /**
     * 普通更新
     *
     * @param userCusinRelPO 持久化信息
     * @return 更新结果
     */
    int updateByPrimaryKey(UserCusinRelPO userCusinRelPO);
}