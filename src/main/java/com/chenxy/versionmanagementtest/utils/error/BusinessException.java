package com.chenxy.versionmanagementtest.utils.error;

public class BusinessException extends Exception implements CommonError{
    private CommonError commonError;

    /**
     * 接受EmBusinessError传参构造业务异常
     * @param commonError
     */
    public BusinessException(CommonError commonError){
        super();
        this.commonError = commonError;
    }

    /**
     * 接受EmBusinessError传参构造业务异常,可自定义错误信息
     * @param commonError
     * @param errMsg
     */
    public BusinessException(CommonError commonError,String errMsg){
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }

    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }
}
