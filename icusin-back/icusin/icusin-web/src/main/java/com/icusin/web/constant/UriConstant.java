package com.icusin.web.constant;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-20 下午1:23
 */
public interface UriConstant {

    // 跟
    String ICUSIN_ROOT_URI = "/";

    // 首页
    String ICUSIN_INDEX_URI = "/index";

    // 登录
    String ICUSIN_LOGIN_URI = "/login";

    // 退出登录
    String ICUSIN_LOGOUT_URI = "/logout";

    // 注册
    String ICUSIN_USER_REGISTER_URI = "/register";

    // 用户信息前缀
    String ICUSIN_USER_INFO_PREFIX_URI = "/user";

    // 用户激活
    String ICUSIN_USER_ACTIVATE_URI = "/activate/{userAccount}";

    // 错误提示页面
    String ICUSIN_ERROR_URI = "/error";

    // 重新发送邮件
    String ICUSIN_USER_RESEND_EMAIL_URI = "/resend/email/{userAccount}";

    // 信息提示页面
    String ICUSIN_HINT_URI = "/hint";

    // 个人中心
    String ICUSIN_USER_PROFILE_URI = "/profile";

    // 表亲列表
    String ICUSIN_USER_CUSIN_URI = "/cusin";

    // 表亲前缀
    String ICUSIN_CUSIN_INFO_PREFIX_URI = "/cusin";

    // 回忆录
    String ICUSIN_USER_MEMOIR_URI = "/memoir";

    // 添加表亲
    String ICUSIN_CUSIN_ADD_URI = "/add";

    // 上传图片
    String ICUSIN_UPLOAD_IMG = "/upload/img";

    // 自传前缀
    String ICUSIN_MEMOIR_INFO_PREFIX_URI = "/memoir";

    // 添加自传
    String ICUSIN_MEMOIR_ADD_URI = "/add";

    // 自传内容
    String ICUSIN_MEMOIR_CONTENT_URI = "/content/{id}";

    // 自传详情
    String ICUSIN_MEMOIR_DETAIL_URI = "/detail/{id}";
}
