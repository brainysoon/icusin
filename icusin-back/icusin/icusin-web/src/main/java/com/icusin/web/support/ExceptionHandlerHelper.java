package com.icusin.web.support;

import com.icusin.common.domain.Result;
import com.icusin.common.enums.ErrorEnum;
import com.icusin.common.exception.BusinessException;
import com.icusin.common.exception.BusinessJSONException;
import com.icusin.common.exception.CheckFailException;
import com.icusin.web.constant.AttrConstant;
import com.icusin.web.constant.TextConstant;
import com.icusin.web.constant.UriConstant;
import com.icusin.web.constant.ViewConstant;
import com.icusin.web.vo.ErrorInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller 异常处理
 *
 * @author xujiangjun
 * @date 2017-04-01 15:32
 */
@Slf4j
@ControllerAdvice(annotations = {Controller.class, RestController.class})
public class ExceptionHandlerHelper {

    @ExceptionHandler(BusinessJSONException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result exceptionJSONHandler(Exception e, HttpServletRequest request) {
        if (e instanceof CheckFailException) {
            CheckFailException exception = (CheckFailException) e;
            return Result.wrapFailureResult(exception.getCode(), exception.getMessage());
        } else if (e instanceof BusinessException) {
            BusinessException exception = (BusinessException) e;
            return Result.wrapFailureResult(exception.getCode(), exception.getMessage());
        } else {
            log.error("服务器内部发生非自定义异常，msg:", e);
            return Result.wrapFailureResult(ErrorEnum.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus
    public ModelAndView exceptionHandler(Exception e, HttpServletRequest request) {

        // 处理异常的视图
        ErrorInfoVO errorInfoVO = new ErrorInfoVO();

        if (e instanceof CheckFailException) {
            CheckFailException exception = (CheckFailException) e;
            errorInfoVO.setCode(exception.getCode());
            errorInfoVO.setMessage(exception.getMessage());
        } else if (e instanceof BusinessException) {
            BusinessException exception = (BusinessException) e;
            errorInfoVO.setCode(exception.getCode());
            errorInfoVO.setMessage(exception.getMessage());
        } else {
            log.error("服务器内部发生非自定义异常，msg:", e);
            ErrorEnum errorEnum = ErrorEnum.INTERNAL_SERVER_ERROR;
            errorInfoVO.setCode(errorEnum.getCode());
            errorInfoVO.setMessage(errorEnum.getMessage());
        }

        errorInfoVO.setRecoverTitle(TextConstant.ICUSIN_TEXT_BACK_TO_INDEX);
        errorInfoVO.setRecoverLink(UriConstant.ICUSIN_INDEX_URI);

        ModelAndView modelAndView = new ModelAndView(ViewConstant.ICUSIN_VIEW_ERROR);
        modelAndView.addObject(AttrConstant.ICUSIN_ATTR_ERROR, errorInfoVO);
        return modelAndView;
    }
}
