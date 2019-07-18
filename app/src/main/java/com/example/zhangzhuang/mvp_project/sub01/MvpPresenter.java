package com.example.zhangzhuang.mvp_project.sub01;

import com.example.zhangzhuang.mvp_project.base01.BasePresenter;
import com.example.zhangzhuang.mvp_project.base01.Callback;

public class MvpPresenter extends BasePresenter<MvpView>{

    public void getData(String params){
        if (!isViewAttached()){
            return;
        }


        getMvpView().showLoading();

        MvpModel.getNettData(params, new Callback<String>() {
            @Override
            public void onSuccess(String data) {
                if (isViewAttached()){
                    getMvpView().showData(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                if (isViewAttached()){
                    getMvpView().showToast(msg);
                }
            }

            @Override
            public void onError() {
                if (isViewAttached()){
                    getMvpView().showErr();
                }
            }

            @Override
            public void onComplete() {
                if (isViewAttached()){
                    getMvpView().hideLoading();
                }
            }
        });


    }


}
