package com.icusin.common.enums;

import lombok.Getter;

/**
 * 错误枚举类
 * <p>
 * 错误码的定义是为了便于在多系统情况下出现问题时能够快速定位到某个系统的某个模块,在定位问题时更加方便地追根溯源.
 * 目前错误码总共分为8位,第1位为平台码,第2-3位系统码,第4位为异常等级码,第5-8位为具体异常定义码.
 * 第1位：0-代表公共异常; 1-电商系统; 2-ERP系统; 3-CRM系统
 * 第2-3位：00-代表legend项目; 01-代表engine项目
 * 第4位：1-校验（校验错误）; 2-警告（会出现潜在的情形）; 3-错误（错误事件发生，但仍然不影响系统继续运行）; 4-严重（错误事件将会导致应用程序退出）;
 *
 * @author xujiangjun
 * @date 2017-04-01 15:47
 */
@Getter
public enum ErrorEnum {
    PARAM_IS_NULL("1001", "参数不允许为空"),
    PARAM_CHECK_FAIL("1002", "参数不规范"),
    CHECK_FAIL("1003", "校验不通过"),
    NOT_EXISTS("1004", "数据不存在"),
    INTERNAL_SERVER_ERROR("1005", "服务器内部错误"),
    UPDATE_FAIL("1006", "更新数据项失败"),

    /* 用户激活的时候没有该用户 */
    USER_NOT_EXIST("1007", "该用户不存在"),
    /* 验证失败 */
    AUTHENTICATION_FAILED("1008", "验证失败"),
    /* 邮件发送失败 */
    EMAIL_SEND_FAILURE("1009", "邮件发送失败"),
    /* 不要重复操作 */
    DUPLICATE_OPERATION("1010", "重复操作"),
    UNSUPPORT_FILE_TYPE("1011", "文件类型不支持"),
    FILE_UPLOAD_FAILED("1012", "文件上传失败"),
    FILE_TRANSFORM_FAILED("1013", "文件转换失败");

    private String code;

    private String message;

    ErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
