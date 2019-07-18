package com.example.zhangzhuang.mvp_project.sub;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.zhangzhuang.mvp_project.R;
import com.example.zhangzhuang.mvp_project.base.BaseActivity;

public class MainActivity extends BaseActivity implements MvpView {

    TextView textView;

    MvpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);


        //初始化Presenter
        presenter = new MvpPresenter();
        presenter.attachView(this);
    }

    // button 点击事件调用方法
    public void getData(View view){
        presenter.getDate("normal");
    }
    // button 点击事件调用方法
    public void getDataForFailure(View view){
        presenter.getDate("failure");
    }
    // button 点击事件调用方法
    public void getDataForError(View view){
        presenter.getDate("error");
    }



    @Override
    public void showData(String data) {
        textView.setText(data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //断开View引用
        presenter.detachView();
    }
}
