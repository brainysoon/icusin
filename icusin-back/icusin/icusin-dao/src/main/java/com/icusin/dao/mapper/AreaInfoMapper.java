package com.icusin.dao.mapper;

import com.icusin.dao.po.AreaInfoPO;
import org.springframework.stereotype.Repository;

/**
 * 区域信息
 *
 * @author brainy
 * @date 2017-12-20 16:29
 */
@Repository
public interface AreaInfoMapper {

    /**
     * 普通插入
     *
     * @param areaInfoPO 持久化信息
     * @return 插入结果
     */
    int insert(AreaInfoPO areaInfoPO);

    /**
     * 选择不为空的插入
     *
     * @param areaInfoPO 持久化信息
     * @return 插入结果
     */
    int insertSelective(AreaInfoPO areaInfoPO);

    /**
     * 根据id查询
     *
     * @param id 记录标识
     * @return 查询结果
     */
    AreaInfoPO selectByPrimaryKey(Integer id);

    /**
     * 选择不为空的更新
     *
     * @param areaInfoPO 持久化信息
     * @return 更新结果
     */
    int updateByPrimaryKeySelective(AreaInfoPO areaInfoPO);

    /**
     * 普通更新
     *
     * @param areaInfoPO 持久化信息
     * @return 更新结果
     */
    int updateByPrimaryKey(AreaInfoPO areaInfoPO);
}