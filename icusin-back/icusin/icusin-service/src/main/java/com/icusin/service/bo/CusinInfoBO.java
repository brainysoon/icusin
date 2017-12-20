package com.icusin.service.bo;

import com.icusin.dao.entity.dto.CusinInfoDTO;
import lombok.Data;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-22 下午10:46
 */
@Data
public class CusinInfoBO extends CusinInfoDTO {

    /* 参照数据传输对象 */
    private CusinInfoDTO base;
}
