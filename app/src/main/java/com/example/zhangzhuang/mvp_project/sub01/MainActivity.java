package com.example.zhangzhuang.mvp_project.sub01;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.zhangzhuang.mvp_project.R;
import com.example.zhangzhuang.mvp_project.base01.BaseActivity;

public class MainActivity extends BaseActivity implements MvpView {

    TextView textView;
    MvpPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MvpPresenter();
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showData(String data) {
        textView.setText(data);
    }

    public void getData(View view){
        presenter.getData("failure");
    }

    public void getDataForFailure(View view){
        presenter.getData("error");
    }

    public void getDataForError(View view){
        presenter.getData("error");
    }
}
