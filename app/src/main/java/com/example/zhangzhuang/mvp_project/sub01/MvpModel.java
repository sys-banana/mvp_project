package com.example.zhangzhuang.mvp_project.sub01;

import android.os.Handler;

import com.example.zhangzhuang.mvp_project.base01.Callback;

public class MvpModel {

    public static void getNettData(final String param, final Callback<String> callback){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (param){
                    case "normal":
                        callback.onSuccess("根据参数"+param+"的请求网络数据成功");
                        break;
                    case "failure":
                        callback.onFailure("请求失败：参数有误");
                        break;
                    case "error":
                        callback.onError();
                        break;
                }
                callback.onComplete();
            }
        },2000);
    }
}
