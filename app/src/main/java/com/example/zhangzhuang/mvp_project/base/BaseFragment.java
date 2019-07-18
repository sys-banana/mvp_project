package com.example.zhangzhuang.mvp_project.base;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhangzhuang.mvp_project.sub01.MainActivity;

public abstract class BaseFragment extends Fragment implements BaseView {


    public abstract int getContentViewId();

    protected abstract void initAllMembersView(Bundle savedInstanceState);

    protected Context mContext;
    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getContentViewId(),container,false);
        this.mContext = getActivity();
        initAllMembersView(savedInstanceState);
        return mRootView;
    }

    @Override
    public void showLoading() {
        checkActivityAttached();
        ((MainActivity)mContext).showLoading();
    }

    @Override
    public void hideLoading() {
        checkActivityAttached();
        ((MainActivity)mContext).hideLoading();
    }

    @Override
    public void showToast(String msg) {
        checkActivityAttached();
        ((MainActivity)mContext).showToast(msg);
    }

    @Override
    public void showErr() {
        checkActivityAttached();
        ((MainActivity)mContext).showErr();
    }

    protected boolean isAttachedContext(){
        return getActivity()!=null;
    }

    /**
     * 检查activity连接情况
     */
    public void checkActivityAttached(){
        if (getActivity()==null){
            throw new ActivityNotAttachedException();
        }
    }

    public static class ActivityNotAttachedException extends RuntimeException{
        public ActivityNotAttachedException(){
            super("Fragment has disconnected from Activity ! - -.");
        }
    }
}
