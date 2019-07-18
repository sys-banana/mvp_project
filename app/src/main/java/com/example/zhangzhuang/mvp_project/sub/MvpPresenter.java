package com.example.zhangzhuang.mvp_project.sub;

import com.example.zhangzhuang.mvp_project.base.BasePresenter;

public class MvpPresenter extends BasePresenter<MvpView> {


    /**
     * 获取网络数据
     *
     * @param params
     */
    public void getDate(String params) {

        if (!isViewAttached()){
            //如果没有View引用就不加载数据
            return;
        }

        //显示正在加载进度条
        getView().showLoading();
        MvpModel.getNetData(params, new MvpCallback() {
            @Override
            public void onSuccess(String data) {
                //调用view接口显示数据
                if (isViewAttached()) {
                    getView().showData(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                //调用view接口提示失败信息
                if (isViewAttached()) {
                    getView().showToast(msg);
                }
            }

            @Override
            public void onError() {
                //调用view接口提示请求异常
                if (isViewAttached()) {
                    getView().showErr();
                }
            }

            @Override
            public void onComplete() {
                // 隐藏正在加载进度条
                if (isViewAttached()) {
                    getView().hideLoading();
                }
            }
        });
    }
}
