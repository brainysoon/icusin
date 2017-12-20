package com.icusin.dao.mapper;

import com.icusin.dao.po.CusinRelPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author brainy
 * @date 2017-12-20 16:32
 */
@Repository
public interface CusinRelMapper {

    /**
     * 普通插入
     *
     * @param cusinRelPO 持久化信息
     * @return 插入结果
     */
    int insert(CusinRelPO cusinRelPO);

    /**
     * 选择不为空的插入
     *
     * @param cusinRelPO 持久化信息
     * @return 插入成功
     */
    int insertSelective(CusinRelPO cusinRelPO);

    /**
     * 根据id查询
     *
     * @param id 记录标识
     * @return 表亲关系信息
     */
    CusinRelPO selectByPrimaryKey(Integer id);

    /**
     * 选择不为空的更新
     *
     * @param cusinRelPO 持久化信息
     * @return 更新结果
     */
    int updateByPrimaryKeySelective(CusinRelPO cusinRelPO);

    /**
     * 普通更新
     *
     * @param cusinRelPO 持久化信息
     * @return 更新结果
     */
    int updateByPrimaryKey(CusinRelPO cusinRelPO);

    /**
     * 列出所有的默认关系和用户自定义关系
     *
     * @param userInfoId 　用户id
     * @return 关系列表
     */
    List<CusinRelPO> selectByUserInfoId(Integer userInfoId);
}