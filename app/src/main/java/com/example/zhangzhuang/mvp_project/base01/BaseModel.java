package com.example.zhangzhuang.mvp_project.base01;

import java.util.Map;

public abstract class BaseModel<T> {

    //数据请求参数
    protected String[] mParams;

    /**
     * 设置数据请求参数
     * @param args 参数数组
     */
    public BaseModel params(String... args){
        mParams = args;
        return this;
    }

    //添加callback并执行数据请求
    //具体的数据请求由子类实现
    public abstract void execute(Callback<T> callback);

    //执行get网络请求，此类需求有自己选择写不写
    protected void requestGetAPI(String url,Callback<T> callback){
        //这里写具体的网络请求
    }

    //执行post网络请求，此类需求有自己选择写不写
    protected void requestPostAPI(String url, Map params,Callback<T> callback){
        //这里写具体的网络请求
    }

}
