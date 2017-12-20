package com.icusin.web.controller;

import com.icusin.common.enums.ErrorEnum;
import com.icusin.common.util.MailUtils;
import com.icusin.service.base.CusinInfoService;
import com.icusin.service.base.MemoirInfoService;
import com.icusin.service.base.UserInfoService;
import com.icusin.service.bo.CusinInfoBO;
import com.icusin.service.bo.UserInfoBO;
import com.icusin.service.params.ActivateQueryParam;
import com.icusin.service.params.RegisterQueryParam;
import com.icusin.web.constant.*;
import com.icusin.web.controller.base.BaseController;
import com.icusin.web.util.CommonUtils;
import com.icusin.web.util.SecurityUtils;
import com.icusin.web.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-20 下午8:50
 */
@Controller
@RequestMapping(value = UriConstant.ICUSIN_USER_INFO_PREFIX_URI)
public class UserController extends BaseController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private CusinInfoService cusinInfoService;

    @Autowired
    private MemoirInfoService memoirInfoService;

    /**
     * 注册页面展示
     *
     * @return 注册视图名
     */
    @RequestMapping(value = UriConstant.ICUSIN_USER_REGISTER_URI, method = RequestMethod.GET)
    public String registerShow() {

        //暂时也没有业务逻辑,直接返回视图名
        return ViewConstant.ICUSIN_VIEW_REGISTER;
    }

    /**
     * 注册提交
     *
     * @param registerQueryParam 提交参数
     * @return 邮件发送成功提示页面
     */
    @RequestMapping(value = UriConstant.ICUSIN_USER_REGISTER_URI, method = RequestMethod.POST)
    public ModelAndView registerSubmit(RegisterQueryParam registerQueryParam) {

        // 先将传入进来的明文密码加密
        registerQueryParam.setUserShadow(bCryptPasswordEncoder
                .encode(registerQueryParam.getUserShadow()));

        // 先插入用户记录
        Integer id = userInfoService.saveUserInfoByRegisterQueryParam(registerQueryParam);

        // 然后发送邮件,逻辑是这样的(把邮箱加密了,然后补上账户名,最后通过账户名查到用户然后验证邮箱地址)
        String code = bCryptPasswordEncoder.encode(registerQueryParam.getUserEmail());
        try {

            MailUtils.sendActivateMail(registerQueryParam.getUserEmail(),
                    registerQueryParam.getUserAccount(), code);
        } catch (Exception ex) {

            // 邮件发送失败
            ex.printStackTrace();
            ErrorEnum errorEnum = ErrorEnum.EMAIL_SEND_FAILURE;

            ErrorInfoVO errorInfoVO = new ErrorInfoVO();
            errorInfoVO.setCode(errorEnum.getCode());
            errorInfoVO.setMessage(errorEnum.getMessage());
            errorInfoVO.setRecoverLink(UriConstant.ICUSIN_USER_INFO_PREFIX_URI +
                    UriConstant.ICUSIN_USER_RESEND_EMAIL_URI +
                    registerQueryParam.getUserAccount() +
                    ParamFixConstant.ICUSIN_PARAM_FIX +
                    ParamFixConstant.ICUSIN_USER_EMAIL_PARAM_FIX +
                    registerQueryParam.getUserEmail() +
                    ParamFixConstant.ICUSIN_CODE_PARAM_FIX + code);
            errorInfoVO.setRecoverTitle(TextConstant.ICUSIN_TEXT_RESEND_EMAIL);

            ModelAndView modelAndView = new ModelAndView(ViewConstant.ICUSIN_VIEW_ERROR);
            modelAndView.addObject(AttrConstant.ICUSIN_ATTR_ERROR, errorInfoVO);

            return modelAndView;
        }

        // 提示邮件发送成功
        HintInfoVO hintInfoVO = new HintInfoVO();
        hintInfoVO.setHint(TextConstant.ICUSIN_TEXT_EMAIL_SEND_SUCCESS);
        hintInfoVO.setHintIcon(IconConstant.ICUSIN_ICON_CHECK);
        hintInfoVO.setBackLink(MailUtils.getMailLoginAdd(registerQueryParam.getUserEmail()));
        hintInfoVO.setBackTitle(TextConstant.ICUSIN_TEXT_CHECK_EMAIL);

        ModelAndView modelAndView = new ModelAndView(ViewConstant.ICUSIN_VIEW_HINT);
        modelAndView.addObject(AttrConstant.ICUSIN_ATTR_HINT, hintInfoVO);
        return modelAndView;
    }

    /**
     * 用户通过邮箱链接激活用户
     *
     * @param activateQueryParam 加密过后的链接参数
     * @return
     */
    @RequestMapping(value = UriConstant.ICUSIN_USER_ACTIVATE_URI)
    public ModelAndView activeSubmit(ActivateQueryParam activateQueryParam) {

        // 首先激活用户
        userInfoService.activateUserByActivateQueryParam(activateQueryParam);

        // 然后返回提示
        HintInfoVO hintInfoVO = new HintInfoVO();
        hintInfoVO.setHint(TextConstant.ICUSIN_TEXT_USER_ACTIVATE_SUCCESS);
        hintInfoVO.setHintIcon(IconConstant.ICUSIN_ICON_CHECK);
        hintInfoVO.setBackLink(UriConstant.ICUSIN_LOGIN_URI);
        hintInfoVO.setBackTitle(TextConstant.ICUSIN_TEXT_LOGIN);

        ModelAndView modelAndView = new ModelAndView(ViewConstant.ICUSIN_VIEW_HINT);
        modelAndView.addObject(AttrConstant.ICUSIN_ATTR_HINT, hintInfoVO);
        return modelAndView;
    }

    @RequestMapping(value = UriConstant.ICUSIN_USER_RESEND_EMAIL_URI)
    public ModelAndView resendEmailSubmit(HttpServletRequest request,
                                          ResendEmailVO resendEmailParam) {

        try {

            // 重新发送邮件
            MailUtils.sendActivateMail(resendEmailParam.getUserEmail(), resendEmailParam.getUserAccount(),
                    bCryptPasswordEncoder.encode(resendEmailParam.getUserEmail()));

        } catch (Exception ex) {

            // 发送失败
            ex.printStackTrace();
            ErrorEnum errorEnum = ErrorEnum.EMAIL_SEND_FAILURE;

            ErrorInfoVO errorInfoVO = new ErrorInfoVO();
            errorInfoVO.setCode(errorEnum.getCode());
            errorInfoVO.setMessage(errorEnum.getMessage());
            errorInfoVO.setRecoverLink(request.getRequestURI());
            errorInfoVO.setRecoverTitle(TextConstant.ICUSIN_TEXT_RESEND_EMAIL);

            ModelAndView modelAndView = new ModelAndView(ViewConstant.ICUSIN_VIEW_ERROR);
            modelAndView.addObject(AttrConstant.ICUSIN_ATTR_ERROR, errorInfoVO);
            return modelAndView;
        }

        // 然后返回提示
        HintInfoVO hintInfoVO = new HintInfoVO();
        hintInfoVO.setHint(TextConstant.ICUSIN_TEXT_EMAIL_SEND_SUCCESS);
        hintInfoVO.setHintIcon(IconConstant.ICUSIN_ICON_CHECK);
        hintInfoVO.setBackLink(MailUtils.getMailLoginAdd(resendEmailParam.getUserEmail()));
        hintInfoVO.setBackTitle(TextConstant.ICUSIN_TEXT_CHECK_EMAIL);

        ModelAndView modelAndView = new ModelAndView(ViewConstant.ICUSIN_VIEW_HINT);
        modelAndView.addObject(AttrConstant.ICUSIN_ATTR_HINT, hintInfoVO);
        return modelAndView;
    }

    /**
     * 个人信息页面
     *
     * @return 展示个人信息页面
     */
    @RequestMapping(value = UriConstant.ICUSIN_USER_PROFILE_URI)
    public ModelAndView userProfileShow(HttpServletRequest request) {

        // 处理菜单信息
        MenuInfoVO menuInfoVO = new MenuInfoVO();
        menuInfoVO.setCurrentMenuName(TextConstant.ICUSIN_TEXT_MENU_NAME_PROFILE);
        CommonUtils.handleMenuInfo(request, menuInfoVO);

        ModelAndView modelAndView = new ModelAndView(ViewConstant.ICUSIN_VIEW_USER_PROFILE);
        return modelAndView;
    }


    /**
     * 用户表亲展示
     *
     * @return 展示该用户表亲页面
     */
    @RequestMapping(value = UriConstant.ICUSIN_USER_CUSIN_URI)
    public ModelAndView userCusinShow(HttpServletRequest request) {

        // 首先拿到登录用户信息 然后处理用户信息
        UserInfoBO userInfoBO = SecurityUtils.getUserInfoFromSecurityContext();

        // 处理菜单信息
        MenuInfoVO menuInfoVO = new MenuInfoVO();
        menuInfoVO.setCurrentMenuName(TextConstant.ICUSIN_TEXT_MENU_NAME_CUSIN);
        CommonUtils.handleMenuInfo(request, menuInfoVO);

        // 我的所有表亲
        List<CusinInfoBO> cusinInfoBOS = cusinInfoService.listCusinInfoByUserInfoId(userInfoBO.getId());
        MyCusinVO myCusinVO = new MyCusinVO();
        myCusinVO.setMyCusins(cusinInfoBOS);

        ModelAndView modelAndView = new ModelAndView(ViewConstant.ICUSIN_VIEW_USER_CUSIN);
        modelAndView.addObject(AttrConstant.ICUSIN_ATTR_CUSINS, myCusinVO);
        return modelAndView;
    }

    /**
     * 用户回忆录
     *
     * @return 展示用户回忆录页面
     */
    @RequestMapping(value = UriConstant.ICUSIN_USER_MEMOIR_URI)
    public ModelAndView userMemoirShow(HttpServletRequest request) {

        // 首先拿到登录用户信息 然后处理用户信息
        UserInfoBO userInfoBO = SecurityUtils.getUserInfoFromSecurityContext();

        // 处理菜单信息
        MenuInfoVO menuInfoVO = new MenuInfoVO();
        menuInfoVO.setCurrentMenuName(TextConstant.ICUSIN_TEXT_MENU_NAME_MEMOIR);
        CommonUtils.handleMenuInfo(request, menuInfoVO);

        // 拿到所有的自传信息
        MyMemoirVO myMemoirVO = new MyMemoirVO();
        myMemoirVO.setMemoirInfoBO(memoirInfoService.listMemoirByUserInfoId(userInfoBO.getId()));

        // 封装视图
        ModelAndView modelAndView = new ModelAndView(ViewConstant.ICUSIN_VIEW_USER_MEMOIR);
        modelAndView.addObject(AttrConstant.ICUSIN_ATTR_MEMOIRS, myMemoirVO);
        return modelAndView;
    }
}
