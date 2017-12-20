package com.icusin.dao.mapper.dto;

import com.icusin.dao.entity.dto.MemoirContentDTO;
import com.icusin.dao.mapper.MemoirContentDOMapper;
import org.apache.ibatis.annotations.Param;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-23 下午12:09
 */
public interface MemoirContentDTOMapper extends MemoirContentDOMapper {

    /**
     * 通过id 获取对象
     *
     * @param id 记录id
     * @return 文章内容
     */
    MemoirContentDTO getMemoirContentById(@Param("id") Integer id);
}
