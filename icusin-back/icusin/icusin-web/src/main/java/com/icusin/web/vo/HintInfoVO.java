package com.icusin.web.vo;

import lombok.Data;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-21 下午7:53
 */
@Data
public class HintInfoVO {

    /* 提示信息 */
    private String hint;

    /* 提示图标 */
    private String hintIcon;

    /* 返回链接 */
    private String backLink;

    /* 返回链接标题 */
    private String backTitle;
}
