package com.icusin.service.bo;

import com.icusin.dao.entity.dto.CusinRelDTO;
import lombok.Data;

import java.util.List;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-10-06 下午8:12
 */
@Data
public class CusinRelBO extends CusinRelDTO {

    /* 数据传输对象*/
    private CusinRelDTO base;

    /* 数据接收　*/
    private List<CusinRelDTO> bases;
}
