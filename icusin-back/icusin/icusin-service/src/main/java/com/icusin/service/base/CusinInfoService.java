package com.icusin.service.base;

import com.icusin.service.bo.CusinInfoBO;
import com.icusin.service.params.CusinAddParam;

import java.util.List;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-22 下午1:59
 */
public interface CusinInfoService {

    /**
     * 添加表亲
     *
     * @param cusinAddParam 添加提交的参数
     * @return 返回记录主键
     */
    Integer saveCusinInfoByCusinAddParam(CusinAddParam cusinAddParam);

    /**
     * 通过用户id 查询用户的表亲
     *
     * @param userInfoId 用户id
     * @return 所有关联的表亲
     */
    List<CusinInfoBO> listCusinInfoByUserInfoId(Integer userInfoId);
}
