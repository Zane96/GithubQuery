package com.example.zane.githubquery.presenters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.zane.easymvp.presenter.BaseActivityPresenter;
import com.example.zane.githubquery.app.MyApplication;
import com.example.zane.githubquery.inject.component.DaggerActivityComponent;
import com.example.zane.githubquery.inject.module.ActivityModule;
import com.example.zane.githubquery.inject.qualifier.ContextType;
import com.example.zane.githubquery.model.bean.Repos;
import com.example.zane.githubquery.model.bean.data.remote.DataManager;
import com.example.zane.githubquery.view.ReposView;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Zane on 16/1/27.
 */
public class ReposActivity extends BaseActivityPresenter<ReposView>{

    private LinearLayoutManager manager;
    private ReposListAdapter adapter;
    private List<Repos> datas;
    private String userName;

    @Inject
    DataManager dataManager;

    @Inject
    @ContextType("MyApplication")
    Context mContext;

    @Override
    public Class<ReposView> getRootViewClass() {
        return ReposView.class;
    }

    @Override
    public void inCreat() {
        initInject();
        manager = new LinearLayoutManager(this);
        userName = getIntent().getStringExtra(MainActivity.USERNAME);

        getDatas();
    }

    public void getDatas(){
        v.seeProgressbar();
        dataManager.getReposInfo(userName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Repos>>() {
                    @Override
                    public void onCompleted() {
                        v.hideProgressbar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        v.hideProgressbar();
                    }

                    @Override
                    public void onNext(List<Repos> reposes) {
                        Log.i("ReposActivity", String.valueOf(reposes));
                        adapter = new ReposListAdapter(mContext, reposes);
                        v.initRecycleView(manager, adapter);
                    }
                });
    }

    public void initInject(){
        MyApplication application = (MyApplication) getApplication();
        DaggerActivityComponent
                .builder()
                .applicationComponent(application.getAppComponent())
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void inDestory() {

    }
}
