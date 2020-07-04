package com.chenxy.versionmanagementtest.utils.error;

public enum EmBusinessError implements CommonError{
    //通用参数请求错误
    UNKNOWN_ERROR(100000,"未知错误"),
    PARAMETER_VALIDATION_ERROR(100001,"参数不合法"),


    //错误码不同的开头串可表示不同的服务模块的错误,假设用户模块为1开头
    USER_NOT_EXIST(200001,"用户不存在")

    ;

    private EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private int errCode;
    private String errMsg;

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
