package com.icusin.dao.mapper.dto;

import com.icusin.dao.entity.dto.CusinRelDTO;
import com.icusin.dao.mapper.CusinRelDOMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-10-06 下午8:06
 */
public interface CusinRelDTOMapper extends CusinRelDOMapper {

    /**
     * 列出所有的默认关系和用户自定义关系
     *
     * @param userInfoId 　用户ｉｄ
     * @return 关系列表
     */
    List<CusinRelDTO> listCusinRelByUserInfoId(@Param("userInfoId") Integer userInfoId);
}
