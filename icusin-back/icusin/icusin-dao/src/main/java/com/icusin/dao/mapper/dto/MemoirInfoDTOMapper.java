package com.icusin.dao.mapper.dto;

import com.icusin.dao.entity.dto.MemoirInfoDTO;
import com.icusin.dao.mapper.MemoirInfoDOMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-23 下午12:09
 */
public interface MemoirInfoDTOMapper extends MemoirInfoDOMapper {

    List<MemoirInfoDTO> listMemoirInfoByUserInfoId(@Param("userInfoId") Integer userInfoId);

    /**
     * 拿取回忆录详细信息
     *
     * @param id 　对应的回忆录
     * @return 返回回忆录详细信息
     */
    MemoirInfoDTO getMemoirDetailById(@Param("id") Integer id);
}
