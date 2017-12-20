package com.icusin.service.base.impl;

import com.icusin.dao.entity.CusinInfoDO;
import com.icusin.dao.entity.dto.CusinInfoDTO;
import com.icusin.dao.mapper.dto.CusinInfoDTOMapper;
import com.icusin.service.base.CusinInfoService;
import com.icusin.service.bo.CusinInfoBO;
import com.icusin.service.constant.CusinInfoConstant;
import com.icusin.service.params.CusinAddParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-22 下午2:00
 */
@Service
public class CusinInfoServiceImpl implements CusinInfoService {

    @Autowired
    private CusinInfoDTOMapper cusinInfoDTOMapper;

    @Override
    public Integer saveCusinInfoByCusinAddParam(CusinAddParam cusinAddParam) {

        // 业务逻辑 (暂时没有)

        // 添加 暂时没有处理逻辑 直接上转型
        CusinInfoDO cusinInfoDO = cusinAddParam;

        cusinInfoDO.setGmtCreate(new Date());
        cusinInfoDO.setGmtModified(cusinInfoDO.getGmtCreate());
        cusinInfoDO.setStatus(CusinInfoConstant.CUSIN_INFO_STATUS_ENABLE);

        return cusinInfoDTOMapper.insertSelective(cusinInfoDO);
    }

    @Override
    public List<CusinInfoBO> listCusinInfoByUserInfoId(Integer userInfoId) {

        List<CusinInfoDTO> cusinInfoDTOS = cusinInfoDTOMapper.listCusinInfoByUserInfoId(userInfoId);

        // 业务逻辑
        List<CusinInfoBO> cusinInfoBOS = new ArrayList<>();
        for (CusinInfoDTO cusinInfoDTO : cusinInfoDTOS) {

            CusinInfoBO cusinInfoBO = new CusinInfoBO();
            cusinInfoBO.setBase(cusinInfoDTO);
            cusinInfoBOS.add(cusinInfoBO);
        }

        return cusinInfoBOS;
    }
}
