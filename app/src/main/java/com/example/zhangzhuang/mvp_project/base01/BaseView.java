package com.example.zhangzhuang.mvp_project.base01;

import android.content.Context;

public interface BaseView {
    void showLoading();
    void hideLoading();
    void showToast(String msg);
    void showErr();
    Context getContext();
}
