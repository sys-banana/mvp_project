package com.example.zhangzhuang.mvp_project.sub01;

import com.example.zhangzhuang.mvp_project.base01.BasePresenter;
import com.example.zhangzhuang.mvp_project.base01.Callback;

public class MvpPresenter extends BasePresenter<MvpView>{

    public void getData(String params){
        if (!isViewAttached()){
            return;
        }


        getMvpView().showLoading();

//        MvpModel.getNettData(params, new Callback<String>() {
//            @Override
//            public void onSuccess(String data) {
//                if (isViewAttached()){
//                    getMvpView().showData(data);
//                }
//            }
//
//            @Override
//            public void onFailure(String msg) {
//                if (isViewAttached()){
//                    getMvpView().showToast(msg);
//                }
//            }
//
//            @Override
//            public void onError() {
//                if (isViewAttached()){
//                    getMvpView().showErr();
//                }
//            }
//
//            @Override
//            public void onComplete() {
//                if (isViewAttached()){
//                    getMvpView().hideLoading();
//                }
//            }
//        });


        DataModel
                // 设置请求标识token
                .request(Token.API_USER_DATA)
                // 添加请求参数，没有则不添加
                .params("000000")
                // 注册监听回调
                .execute(new Callback<String>() {

                    @Override
                    public void onSuccess(String data) {
                        //调用view接口显示数据
                        getMvpView().showData(data);
                    }

                    @Override
                    public void onFailure(String msg) {
                        //调用view接口提示失败信息
                        getMvpView().showToast(msg);
                    }

                    @Override
                    public void onError() {
                        //调用view接口提示请求异常
                        getMvpView().showErr();
                    }

                    @Override
                    public void onComplete() {
                        // 隐藏正在加载进度条
                        getMvpView().hideLoading();
                    }
                });

    }


}
