package com.example.zhangzhuang.mvp_project.base01;

public interface Callback<T> {
    void onSuccess(T data);
    void onFailure(String msg);
    void onError();
    void onComplete();
}
