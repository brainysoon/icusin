package com.icusin.dao.mapper;

import com.icusin.dao.po.MemoirCatgPO;
import org.springframework.stereotype.Repository;

/**
 * @author brainy
 * @date 2017-12-20 19:17
 */
@Repository
public interface MemoirCatgMapper {

    /**
     * 普通插入
     *
     * @param memoirCatgPO 持久化信息
     * @return 插入结果
     */
    int insert(MemoirCatgPO memoirCatgPO);

    /**
     * 选择不为空的插入
     *
     * @param memoirCatgPO 持久化信息
     * @return 插入结果
     */
    int insertSelective(MemoirCatgPO memoirCatgPO);

    /**
     * 根据id查询分类
     *
     * @param id 记录标识
     * @return 回忆录分类信息
     */
    MemoirCatgPO selectByPrimaryKey(Integer id);

    /**
     * 选择不为空的更新
     *
     * @param memoirCatgPO 持久化信息
     * @return 更新结果
     */
    int updateByPrimaryKeySelective(MemoirCatgPO memoirCatgPO);

    /**
     * 普通更新
     *
     * @param memoirCatgPO 持久化信息
     * @return 更新结果
     */
    int updateByPrimaryKey(MemoirCatgPO memoirCatgPO);
}