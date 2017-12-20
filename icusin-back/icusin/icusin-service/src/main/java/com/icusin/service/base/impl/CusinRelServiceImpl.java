package com.icusin.service.base.impl;

import com.icusin.service.base.CusinRelService;
import com.icusin.service.bo.CusinRelBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-10-06 下午8:12
 */
@Service
public class CusinRelServiceImpl implements CusinRelService {

    @Autowired
    private CusinRelDTOMapper cusinRelDTOMapper;

    @Override
    public CusinRelBO listCusinRelByUserInfoId(Integer userInfoId) {

        CusinRelBO cusinRelBO = new CusinRelBO();
        cusinRelBO.setBases(cusinRelDTOMapper.listCusinRelByUserInfoId(userInfoId));

        return cusinRelBO;
    }
}
