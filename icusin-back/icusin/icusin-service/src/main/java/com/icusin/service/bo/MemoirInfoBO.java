package com.icusin.service.bo;

import com.icusin.dao.entity.dto.MemoirInfoDTO;
import lombok.Data;

import java.util.List;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-23 下午12:48
 */
@Data
public class MemoirInfoBO {

    /* 自传信息 */
    private MemoirInfoDTO base;

    /* 自传信息复数 */
    private List<MemoirInfoDTO> bases;
}
