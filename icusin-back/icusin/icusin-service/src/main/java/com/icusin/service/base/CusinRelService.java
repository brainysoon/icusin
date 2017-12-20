package com.icusin.service.base;

import com.icusin.service.bo.CusinRelBO;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-10-06 下午8:11
 */
public interface CusinRelService {

    /**
     * 列出所有默认的关系和自己自定义的关系
     *
     * @param userInfoId 　用户ｉｄ
     * @return 返回关系列表相关信息
     */
    CusinRelBO listCusinRelByUserInfoId(Integer userInfoId);
}
