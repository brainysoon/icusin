package com.icusin.dao.mapper.dto;

import com.icusin.dao.entity.dto.CusinInfoDTO;
import com.icusin.dao.mapper.CusinInfoDOMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-22 下午2:03
 */
public interface CusinInfoDTOMapper extends CusinInfoDOMapper {

    List<CusinInfoDTO> listCusinInfoByUserInfoId(@Param("userInfoId") Integer userInfoId);
}
