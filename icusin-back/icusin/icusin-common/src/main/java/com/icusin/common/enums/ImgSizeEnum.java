package com.icusin.common.enums;

import lombok.Getter;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-22 下午9:41
 */
@Getter
public enum ImgSizeEnum {

    IMG_SIZE_350X220(350, 220),
    IMG_SIZE_720x720(720, 720);

    /* 宽 */
    private Integer width;

    /* 高 */
    private Integer height;

    ImgSizeEnum(Integer width, Integer height) {

        this.width = width;
        this.height = height;
    }
}
