package com.icusin.service.base;

import com.icusin.dao.entity.dto.MemoirInfoDTO;
import com.icusin.service.bo.MemoirInfoBO;
import com.icusin.service.params.AddMemoirParam;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-23 下午12:01
 */
public interface MemoirInfoService {

    /**
     * 添加自传
     *
     * @param addMemoirParam 添加参数
     * @return 返回添加的id
     */
    Integer saveMemoirByAddMemoirParam(AddMemoirParam addMemoirParam);

    /**
     * 查询当前用户添加的所有自传
     *
     * @param userInfoId 用户id
     * @return 匹配到的自传信息
     */
    MemoirInfoBO listMemoirByUserInfoId(Integer userInfoId);

    /**
     * 获取回忆录详细信息
     *
     * @param id 　对应的ｉｄ
     * @return 回忆录信息
     */
    MemoirInfoBO getMemoirDetailById(Integer id);
}
