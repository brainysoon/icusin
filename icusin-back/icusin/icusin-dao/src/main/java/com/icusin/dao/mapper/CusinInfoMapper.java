package com.icusin.dao.mapper;

import com.icusin.dao.po.CusinInfoPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 表亲信息
 *
 * @author brainy
 * @date 2017-12-20 14:22
 */
@Repository
public interface CusinInfoMapper {


    /**
     * 普通插入表亲记录
     *
     * @param cusinInfoPO 持久化信息
     * @return 插入结果
     */
    int insert(CusinInfoPO cusinInfoPO);

    /**
     * 选择不为空的插入表亲记录
     *
     * @param cusinInfoPO 持久化信息
     * @return 插入结果
     */
    int insertSelective(CusinInfoPO cusinInfoPO);

    /**
     * 根据id查找表亲信息
     *
     * @param id 唯一键
     * @return 表亲信息
     */
    CusinInfoPO selectByPrimaryKey(Integer id);

    /**
     * 更新不为空的信息
     *
     * @param cusinInfoPO 持久化信息
     * @return 更新结果
     */
    int updateByPrimaryKeySelective(CusinInfoPO cusinInfoPO);

    /**
     * 普通更新
     *
     * @param cusinInfoPO 持久化信息
     * @return 更新结果
     */
    int updateByPrimaryKey(CusinInfoPO cusinInfoPO);

    /**
     * 列举出改用户的所有表亲
     *
     * @param userInfoId 用户id
     * @return 表亲信息列表
     */
    List<CusinInfoPO> selectByUserInfoId(Integer userInfoId);
}