package com.example.zane.githubquery.presenters;

import android.support.v7.widget.LinearLayoutManager;

import com.example.zane.easymvp.presenter.BaseActivityPresenter;
import com.example.zane.githubquery.view.ReposView;

/**
 * Created by Zane on 16/1/27.
 */
public class ReposActivity extends BaseActivityPresenter<ReposView>{

    private LinearLayoutManager manager;
    private ReposListAdapter adapter;

    @Override
    public Class<ReposView> getRootViewClass() {
        return ReposView.class;
    }

    @Override
    public void inCreat() {
        manager = new LinearLayoutManager(this);

    }

    @Override
    public void inDestory() {

    }
}
