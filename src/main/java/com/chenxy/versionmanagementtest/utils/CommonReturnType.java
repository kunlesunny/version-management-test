package com.chenxy.versionmanagementtest.utils;

public class CommonReturnType {
    /**
     * 代表返回结果的状态 success 和 fail
     */
    private String status;

    /**
     * 如果status为success ，则data为前端需要的json数据
     * 如果status为fail，则data为通用的错误码格式
     */
    private Object data;

    public CommonReturnType(){

    }

    public CommonReturnType(String status, Object data) {
        this.status = status;
        this.data = data;
    }

    public static CommonReturnType create(Object data){
        return create("success",data);
    }

    public static CommonReturnType create(String status,Object data){
        CommonReturnType commonReturnType = new CommonReturnType(status,data);
        return commonReturnType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
