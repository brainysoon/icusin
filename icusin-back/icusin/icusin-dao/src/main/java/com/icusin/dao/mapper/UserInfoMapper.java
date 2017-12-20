package com.icusin.dao.mapper;

import com.icusin.dao.po.UserInfoPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户信息
 *
 * @author brainy
 */
@Repository
public interface UserInfoMapper {

    /**
     * 普通插入用户信息
     *
     * @param userInfoPO 用户持久化信息
     * @return 插入结果
     */
    int insert(UserInfoPO userInfoPO);

    /**
     * 选择不为空的插入用户信息
     *
     * @param userInfoPO 用户持久化信息
     * @return 插入结果
     */
    int insertSelective(UserInfoPO userInfoPO);

    /**
     * 选择不为空的更新
     *
     * @param userInfoPO 用户持久化信息
     * @return 更新结果
     */
    int updateByPrimaryKeySelective(UserInfoPO userInfoPO);

    /**
     * 普通更新
     *
     * @param userInfoPO 用户持久化信息
     * @return 更新结果
     */
    int updateByPrimaryKey(UserInfoPO userInfoPO);

    /**
     * 通过用户标识符查找用户
     *
     * @param identifier 用户标识符，可能是(用户名,手机号,邮箱)
     * @return 用户信息
     */
    UserInfoPO selectByIdentifier(@Param("identifier") String identifier);

    /**
     * 通过用户名查找用户
     *
     * @param userAccount 用户账户
     * @return 用户信息
     */
    UserInfoPO selectByUserAccount(@Param("userAccount") String userAccount);

    /**
     * 软删除（标记0）
     *
     * @param id 记录标识
     * @return 删除结果
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 真删除（不推荐）
     *
     * @param id 记录标识
     * @return 删除结果
     */
    @SuppressWarnings("这个方法真的会删除数据哦，谨慎对待！！！")
    int deleteByPrimaryKeyDangerously(Integer id);
}