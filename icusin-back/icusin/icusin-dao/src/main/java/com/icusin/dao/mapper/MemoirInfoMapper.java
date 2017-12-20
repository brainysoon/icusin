package com.icusin.dao.mapper;

import com.icusin.dao.dto.MemoirInfoDTO;
import com.icusin.dao.po.MemoirInfoPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author brainy
 * @date 2017-12-20 14:41
 */
@Repository
public interface MemoirInfoMapper {

    /**
     * 普通插入
     *
     * @param memoirInfoPO 持久化信息
     * @return 插入结果
     */
    int insert(MemoirInfoPO memoirInfoPO);

    /**
     * 选择不为空的插入
     *
     * @param memoirInfoPO 持久化信息
     * @return 插入结果
     */
    int insertSelective(MemoirInfoPO memoirInfoPO);

    /**
     * 通过id查找回忆录信息
     *
     * @param id 记录标识
     * @return 回忆录信息
     */
    MemoirInfoPO selectByPrimaryKey(Integer id);

    /**
     * 选择不为空的更新
     *
     * @param memoirInfoPO 持久化信息
     * @return 更新结果
     */
    int updateByPrimaryKeySelective(MemoirInfoPO memoirInfoPO);

    /**
     * 全部更新
     *
     * @param memoirInfoPO 持久化信息
     * @return 更新结果
     */
    int updateByPrimaryKey(MemoirInfoPO memoirInfoPO);

    /**
     * 根据用户id查询用户所有表亲的回忆录
     *
     * @param userInfoId 用户id
     * @return 表亲回忆录信息列表
     */
    List<MemoirInfoDTO> selectByUserInfoId(Integer userInfoId);
}