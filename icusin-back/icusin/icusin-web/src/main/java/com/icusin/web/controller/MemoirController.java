package com.icusin.web.controller;

import com.icusin.service.base.CusinInfoService;
import com.icusin.service.base.MemoirContentService;
import com.icusin.service.base.MemoirInfoService;
import com.icusin.service.bo.MemoirInfoBO;
import com.icusin.service.bo.UserInfoBO;
import com.icusin.service.params.AddMemoirParam;
import com.icusin.web.constant.*;
import com.icusin.web.controller.base.BaseController;
import com.icusin.web.util.SecurityUtils;
import com.icusin.web.vo.AddMemoirVO;
import com.icusin.web.vo.HintInfoVO;
import com.icusin.web.vo.MemoirContentVO;
import com.icusin.web.vo.MemoirDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * copyright icusin.com
 *
 * @author brainysoon
 * @create 2017-09-23 上午11:03
 */
@Controller
@RequestMapping(value = UriConstant.ICUSIN_MEMOIR_INFO_PREFIX_URI)
public class MemoirController extends BaseController {

    @Autowired
    private CusinInfoService cusinInfoService;

    @Autowired
    private MemoirInfoService memoirInfoService;

    @Autowired
    private MemoirContentService memoirContentService;

    /**
     * 添加页面展示
     *
     * @return 返回添加页面
     */
    @RequestMapping(value = UriConstant.ICUSIN_MEMOIR_ADD_URI, method = RequestMethod.GET)
    public ModelAndView addShow() {

        // 当前登录用户信息
        UserInfoBO userInfoBO = SecurityUtils.getUserInfoFromSecurityContext();

        // 当前用户的所有表亲
        AddMemoirVO addMemoirVO = new AddMemoirVO();
        addMemoirVO.setMyCusins(cusinInfoService.listCusinInfoByUserInfoId(userInfoBO.getId()));


        // 视图渲染
        ModelAndView modelAndView = new ModelAndView(ViewConstant.ICUSIN_VIEW_MEMOIR_ADD);
        modelAndView.addObject(AttrConstant.ICUSIN_ATTR_ADD_MEMOIR, addMemoirVO);
        return modelAndView;
    }

    /**
     * 添加提交
     *
     * @return 提示信息
     */
    @RequestMapping(value = UriConstant.ICUSIN_MEMOIR_ADD_URI, method = RequestMethod.POST)
    public ModelAndView addSubmit(AddMemoirParam addMemoirParam) {

        // 添加
        Integer id = memoirInfoService.saveMemoirByAddMemoirParam(addMemoirParam);

        // 提示信息
        HintInfoVO hintInfoVO = new HintInfoVO();
        hintInfoVO.setHint(TextConstant.ICUSIN_TEXT_MEMOIR_ADD_SUCCESS);
        hintInfoVO.setHintIcon(IconConstant.ICUSIN_ICON_CHECK);
        hintInfoVO.setBackTitle(TextConstant.ICUSIN_TEXT_BACK_TO_USER_MEMOIR);
        hintInfoVO.setBackLink(UriConstant.ICUSIN_USER_INFO_PREFIX_URI +
                UriConstant.ICUSIN_USER_MEMOIR_URI);

        ModelAndView modelAndView = new ModelAndView(ViewConstant.ICUSIN_VIEW_HINT);
        modelAndView.addObject(AttrConstant.ICUSIN_ATTR_HINT, hintInfoVO);
        return modelAndView;
    }

    @RequestMapping(value = UriConstant.ICUSIN_MEMOIR_CONTENT_URI)
    public ModelAndView contentShow(@PathVariable Integer id) {

        // 查找指定的文章内容
        MemoirContentVO memoirContentVO = new MemoirContentVO();
        memoirContentVO.setMemoirContentBO(memoirContentService.getMemoirContentById(id));

        // 视图内容
        ModelAndView modelAndView = new ModelAndView(ViewConstant.ICUSIN_VIEW_MEMOIR_CONTENT);
        modelAndView.addObject(AttrConstant.ICUSIN_ATTR_CONTENT, memoirContentVO);
        return modelAndView;
    }

    @RequestMapping(value = UriConstant.ICUSIN_MEMOIR_DETAIL_URI)
    public ModelAndView detailShow(@PathVariable Integer id) {

        // 拿取到回忆录
        MemoirInfoBO memoirInfoBO = memoirInfoService.getMemoirDetailById(id);

        // 模型
        MemoirDetailVO memoirDetailVO = new MemoirDetailVO();
        memoirDetailVO.setMemoir(memoirInfoBO);

        // 视图
        ModelAndView modelAndView = new ModelAndView(ViewConstant.ICUSIN_VIEW_MEMOIR_DETAIL);
        modelAndView.addObject(AttrConstant.ICUSIN_ATTR_MEMOIR_DETAIL, memoirDetailVO);

        return modelAndView;
    }
}
