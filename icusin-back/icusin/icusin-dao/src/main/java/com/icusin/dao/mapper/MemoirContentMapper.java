package com.icusin.dao.mapper;

import com.icusin.dao.po.MemoirContentPO;
import org.springframework.stereotype.Repository;

/**
 * 回忆录内容
 *
 * @author brainy
 * @date 2017-12-20 14:33
 */
@Repository
public interface MemoirContentMapper {

    /**
     * 普通插入回忆录内容
     *
     * @param memoirContentPO 持久化信息
     * @return 插入结果
     */
    int insert(MemoirContentPO memoirContentPO);

    /**
     * 选择不为空的内容插入
     *
     * @param memoirContentPO 持久化信息
     * @return 插入结果
     */
    int insertSelective(MemoirContentPO memoirContentPO);

    /**
     * 根据id查询内容信息
     *
     * @param id 记录标识
     * @return 回忆录内容信息
     */
    MemoirContentPO selectByPrimaryKey(Integer id);

    /**
     * 选择不为空的更新
     *
     * @param memoirContentPO 更新信息
     * @return 更新结果
     */
    int updateByPrimaryKeySelective(MemoirContentPO memoirContentPO);

    /**
     * 直接更新所有信息
     *
     * @param memoirContentPO 更新信息
     * @return 更新结果
     */
    int updateByPrimaryKeyWithBLOBs(MemoirContentPO memoirContentPO);

    /**
     * 直接更新初内容外的其他信息
     *
     * @param memoirContentPO 更新信息
     * @return 更新结果
     */
    int updateByPrimaryKey(MemoirContentPO memoirContentPO);
}