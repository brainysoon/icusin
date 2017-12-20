package com.icusin.web.vo;

import com.icusin.service.bo.CusinInfoBO;
import lombok.Data;

import java.util.List;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-23 上午8:18
 */
@Data
public class MyCusinVO {

    /* 我的所有表亲 */
    private List<CusinInfoBO> myCusins;
}
