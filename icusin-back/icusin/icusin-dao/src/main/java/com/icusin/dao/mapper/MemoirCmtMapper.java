package com.icusin.dao.mapper;

import com.icusin.dao.po.MemoirCmtPO;
import org.springframework.stereotype.Repository;

/**
 * 回忆录评论
 *
 * @author brainy
 * @date 2017-12-20 19:54
 */
@Repository
public interface MemoirCmtMapper {

    /**
     * 普通插入
     *
     * @param memoirCmtPO 持久化信息
     * @return 插入结果
     */
    int insert(MemoirCmtPO memoirCmtPO);

    /**
     * 选择不为空的插入
     *
     * @param memoirCmtPO 持久化信息
     * @return 插入结果
     */
    int insertSelective(MemoirCmtPO memoirCmtPO);

    /**
     * 根据id插叙评论
     *
     * @param id 记录标识
     * @return 评论信息
     */
    MemoirCmtPO selectByPrimaryKey(Integer id);

    /**
     * 选择不为空的更新
     *
     * @param memoirCmtPO 持久化信息
     * @return 更新结果
     */
    int updateByPrimaryKeySelective(MemoirCmtPO memoirCmtPO);

    /**
     * 普通更新
     *
     * @param memoirCmtPO 持久化信息
     * @return 更新结果
     */
    int updateByPrimaryKey(MemoirCmtPO memoirCmtPO);
}