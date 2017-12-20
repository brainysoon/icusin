package com.icusin.web.vo;

import com.icusin.service.bo.CusinInfoBO;
import lombok.Data;

import java.util.List;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-23 上午11:23
 */
@Data
public class AddMemoirVO {

    /* 我的表亲 */
    private List<CusinInfoBO> myCusins;
}
