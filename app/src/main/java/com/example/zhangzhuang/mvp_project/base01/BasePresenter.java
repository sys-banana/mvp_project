package com.example.zhangzhuang.mvp_project.base01;

public class BasePresenter<V extends BaseView> {
    private V mvpView;

    public void attachView(V mvpView){
        this.mvpView = mvpView;
    }

    public void detachView(){
        this.mvpView = null;
    }

    public boolean isViewAttached(){
        return mvpView!=null;
    }

    public V getMvpView(){
        return mvpView;
    }
}
