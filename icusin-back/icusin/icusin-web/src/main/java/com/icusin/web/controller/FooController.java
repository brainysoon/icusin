package com.icusin.web.controller;

import com.icusin.common.domain.Result;
import com.icusin.common.enums.ErrorEnum;
import com.icusin.common.enums.ImgSizeEnum;
import com.icusin.common.exception.BusinessException;
import com.icusin.common.exception.BusinessJSONException;
import com.icusin.web.constant.AttrConstant;
import com.icusin.web.constant.ParamFixConstant;
import com.icusin.web.constant.UriConstant;
import com.icusin.web.constant.ViewConstant;
import com.icusin.web.controller.base.BaseController;
import com.icusin.web.support.OSSHelper;
import com.icusin.web.vo.ErrorInfoVO;
import com.icusin.web.vo.HintInfoVO;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

/**
 * copyright icusin.com 这个控制器放置很多杂糅在一起的东西
 *
 * @author brainysoon
 * @create 2017-09-20 下午1:18
 */
@Controller
public class FooController extends BaseController {

    /**
     * 首页
     *
     * @return 首页视图名
     */
    @RequestMapping(value = {UriConstant.ICUSIN_ROOT_URI, UriConstant.ICUSIN_INDEX_URI}, method = RequestMethod.GET)
    public String indexShow() {

        // 没有业务逻辑,直接返回视图
        return ViewConstant.ICUSIN_VIEW_INDEX;
    }

    /**
     * 登录
     *
     * @return 登录视图名
     */
    @RequestMapping(value = UriConstant.ICUSIN_LOGIN_URI, method = RequestMethod.GET)
    public String loginShow() {

        // 暂时没有业务逻辑,直接返回视图名
        return ViewConstant.ICUSIN_VIEW_LOGIN;
    }

    /**
     * 用户重定向到错误页面
     *
     * @param errorInfoParam 错误信息参数
     * @return
     */
    @RequestMapping(value = UriConstant.ICUSIN_ERROR_URI)
    public ModelAndView errorShow(ErrorInfoVO errorInfoParam) {

        ModelAndView modelAndView = new ModelAndView(ViewConstant.ICUSIN_VIEW_ERROR);

        // 处理错误参数
        modelAndView.addObject(AttrConstant.ICUSIN_ATTR_ERROR, errorInfoParam);

        return modelAndView;
    }

    /**
     * 用于接受重定向到信息提示页面
     *
     * @param hintInfoParam 提示信息
     * @return
     */
    @RequestMapping(value = UriConstant.ICUSIN_HINT_URI)
    public ModelAndView hintShow(HintInfoVO hintInfoParam) {

        ModelAndView modelAndView = new ModelAndView(ViewConstant.ICUSIN_VIEW_HINT);

        // 处理提示信息
        modelAndView.addObject(AttrConstant.ICUSIN_ATTR_HINT, hintInfoParam);

        return modelAndView;
    }

    @RequestMapping(value = UriConstant.ICUSIN_UPLOAD_IMG, method = RequestMethod.POST)
    @ResponseBody
    public Object fileUpload(MultipartFile fileData) {

        // 检查文件类型
        if (!OSSHelper.checkFile(fileData, ParamFixConstant.ICUSIN_UPLOAD_FILE_IMG_TYPE_LIMIT))
            throw new BusinessException(ErrorEnum.UNSUPPORT_FILE_TYPE);

        // 上传文件 随机生成文件名 补上文件类型
        String randomFileName = Long.toHexString(UUID.randomUUID().getMostSignificantBits()).toUpperCase();

        // 将所有的其他类型全部转换为 固定类型 固定大小 缓存到本地
        try {
            ImgSizeEnum imgSizeEnum = ImgSizeEnum.IMG_SIZE_720x720;
            Thumbnails.of(fileData.getInputStream())
                    .size(imgSizeEnum.getWidth(), imgSizeEnum.getHeight())
                    .outputFormat(OSSHelper.BUCKET_ICUSIN_IMG_UPLOAD_TYPE)
                    .toFile(OSSHelper.BUFFERED_DIR + randomFileName);

        } catch (Exception ex) {

            ex.printStackTrace();
            throw new BusinessJSONException(ErrorEnum.FILE_TRANSFORM_FAILED);
        }

        // 然后再将图片上传到阿里云 oss
        boolean result = false;
        try {
            File cashedImgFile = new File(OSSHelper.BUFFERED_DIR +
                    randomFileName + OSSHelper.BUCKET_ICUSIN_IMG_TYPE_EXTRA);
            result = OSSHelper.fileUpload(OSSHelper.BUCKET_ICUSIN_IMG,
                    randomFileName + OSSHelper.BUCKET_ICUSIN_IMG_TYPE_EXTRA,
                    new FileInputStream(cashedImgFile));
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new BusinessJSONException(ErrorEnum.FILE_UPLOAD_FAILED);
        }
        if (result) {
            return Result.wrapSuccessfulResult(randomFileName);
        } else {
            return Result.wrapFailureResult(ErrorEnum.FILE_UPLOAD_FAILED);
        }
    }
}
