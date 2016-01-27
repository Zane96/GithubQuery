package com.example.zane.githubquery.presenters;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.zane.easymvp.presenter.BaseActivityPresenter;
import com.example.zane.githubquery.R;
import com.example.zane.githubquery.view.MainView;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivityPresenter<MainView> {



    @Override
    public Class<MainView> getRootViewClass() {
        return MainView.class;
    }

    @Override
    public void inCreat() {

    }

    @Override
    public void inDestory() {

    }
}
