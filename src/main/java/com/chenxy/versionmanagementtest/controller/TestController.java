package com.chenxy.versionmanagementtest.controller;

import com.chenxy.versionmanagementtest.dataObject.User;
import com.chenxy.versionmanagementtest.utils.CommonReturnType;
import com.chenxy.versionmanagementtest.utils.error.BusinessException;
import com.chenxy.versionmanagementtest.utils.error.EmBusinessError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    public CommonReturnType test() throws BusinessException {
        Map res = new HashMap();
        res.put("id","1");
        res.put("name","kunle");
        res.put("age","18");
        if("1".equals(res.get("id"))){
            //throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"自定义参数不合法错误");
            /*User user = new User();
            user = null;
            user.setId(1);*/
        }


        return CommonReturnType.create(res);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CommonReturnType handlerException(HttpServletRequest request,Exception exception){
        Map map = new HashMap();
        if(exception instanceof BusinessException){
            BusinessException businessException = (BusinessException) exception;
            map.put("errCode",businessException.getErrCode());
            map.put("errMsg",businessException.getErrMsg());
        }else {
            map.put("errCode",EmBusinessError.UNKNOWN_ERROR.getErrCode());
            map.put("errMsg",EmBusinessError.UNKNOWN_ERROR.getErrMsg());
        }
        return CommonReturnType.create("fail", map);
    }
}
