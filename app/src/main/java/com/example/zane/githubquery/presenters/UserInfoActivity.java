package com.example.zane.githubquery.presenters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.zane.easymvp.presenter.BaseActivityPresenter;
import com.example.zane.githubquery.R;
import com.example.zane.githubquery.app.MyApplication;
import com.example.zane.githubquery.inject.component.DaggerActivityComponent;
import com.example.zane.githubquery.inject.module.ActivityModule;
import com.example.zane.githubquery.inject.qualifier.ContextType;
import com.example.zane.githubquery.model.bean.Users;
import com.example.zane.githubquery.model.bean.data.remote.DataManager;
import com.example.zane.githubquery.view.UserInfoView;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Zane on 16/1/27.
 */
public class UserInfoActivity extends BaseActivityPresenter<UserInfoView>{

    @Inject
    DataManager dataManager;
    @Inject
    @ContextType("MyApplication")
    Context mContext;

    private String userName;

    @Override
    public Class<UserInfoView> getRootViewClass() {
        return UserInfoView.class;
    }

    @Override
    public void inCreat() {

        initInject();

        userName = getIntent().getStringExtra(MainActivity.USERNAME);
        queryUserInfo();

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInfoActivity.this, ReposActivity.class);
                intent.putExtra(MainActivity.USERNAME, userName);
                startActivity(intent);
            }
        }, R.id.repos_query);
    }

    public void initInject(){
        MyApplication app = (MyApplication)getApplication();
        DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(app.getAppComponent())
                .build()
                .inject(this);
    }

    public void queryUserInfo(){
        v.seeProgressBar();
        Log.i("UserInfoActivity", "3");
        dataManager
                .getUserInfo(userName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Users>() {
                    @Override
                    public void onCompleted() {
                        v.hideProgressbar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        v.hideProgressbar();
                        Log.i("UserInfoActivity", String.valueOf(e));
                    }

                    @Override
                    public void onNext(Users users) {
                        Glide.with(mContext).load(users.getAvatar_url()).into(v.getImageviewAvatar());
                        v.hideProgressbar();
                        v.setLoginName(users.getLogin());
                        v.setTextviewName(users.getName());
                        v.setTextviewLocation(users.getLocation());
                        v.setTextviewFollowingname(users.getFollowing());
                        v.setTextviewFollowersname(users.getFollowers());
                    }
                });
    }



    @Override
    public void inDestory() {

    }
}
