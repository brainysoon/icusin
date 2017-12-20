package com.icusin.web.controller;

import com.icusin.service.base.CusinInfoService;
import com.icusin.service.base.CusinRelService;
import com.icusin.service.bo.CusinRelBO;
import com.icusin.service.bo.UserInfoBO;
import com.icusin.service.params.CusinAddParam;
import com.icusin.web.constant.*;
import com.icusin.web.util.SecurityUtils;
import com.icusin.web.vo.AddCusinVO;
import com.icusin.web.vo.HintInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-21 下午11:29
 */
@Controller
@RequestMapping(value = UriConstant.ICUSIN_CUSIN_INFO_PREFIX_URI)
public class CusinController {

    @Autowired
    private CusinInfoService cusinInfoService;

    @Autowired
    private CusinRelService cusinRelService;

    /**
     * 添加页面
     *
     * @return 展示添加页面
     */
    @RequestMapping(value = UriConstant.ICUSIN_CUSIN_ADD_URI, method = RequestMethod.GET)
    public ModelAndView addShow() {

        // 拿到用户信息
        UserInfoBO userInfoBO = SecurityUtils.getUserInfoFromSecurityContext();

        // 所有关系
        CusinRelBO cusinRelBO = cusinRelService.listCusinRelByUserInfoId(userInfoBO.getId());

        // 视图
        AddCusinVO addCusinVO = new AddCusinVO();
        addCusinVO.setCusinRelBO(cusinRelBO);
        ModelAndView modelAndView = new ModelAndView(ViewConstant.ICUSIN_VIEW_CUSIN_ADD);
        modelAndView.addObject(AttrConstant.ICUSIN_ATTR_ADD_CUSIN, addCusinVO);
        return modelAndView;
    }

    /**
     * 提交添加请求
     *
     * @return 提示页面
     */
    @RequestMapping(value = UriConstant.ICUSIN_CUSIN_ADD_URI, method = RequestMethod.POST)
    public ModelAndView addSubmit(CusinAddParam cusinAddParam) {

        // 补充用户信息
        UserInfoBO userInfoBO = SecurityUtils.getUserInfoFromSecurityContext();
        cusinAddParam.setUserRefId(userInfoBO.getId());

        Integer id = cusinInfoService.saveCusinInfoByCusinAddParam(cusinAddParam);

        // 提示添加成功
        HintInfoVO hintInfoVO = new HintInfoVO();
        hintInfoVO.setHint(TextConstant.ICUSIN_TEXT_CUSIN_ADD_SUCCESS);
        hintInfoVO.setHintIcon(IconConstant.ICUSIN_ICON_CHECK);
        hintInfoVO.setBackTitle(TextConstant.ICUSIN_TEXT_BACK_TO_USER_CUSIN);
        hintInfoVO.setBackLink(UriConstant.ICUSIN_USER_INFO_PREFIX_URI +
                UriConstant.ICUSIN_USER_CUSIN_URI);

        ModelAndView modelAndView = new ModelAndView(ViewConstant.ICUSIN_VIEW_HINT);
        modelAndView.addObject(AttrConstant.ICUSIN_ATTR_HINT, hintInfoVO);
        return modelAndView;
    }
}
