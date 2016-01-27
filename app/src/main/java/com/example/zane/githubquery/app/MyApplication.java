package com.example.zane.githubquery.app;

import android.app.Application;

import com.example.zane.githubquery.inject.component.ApplicationComponent;
import com.example.zane.githubquery.inject.component.DaggerApplicationComponent;
import com.example.zane.githubquery.inject.module.ApplicationModule;
import com.example.zane.githubquery.inject.module.GithubApiModule;
import com.kermit.exutils.utils.ExUtils;

/**
 * Created by Zane on 16/1/26.
 */
public class MyApplication extends Application{

    private static MyApplication application;


    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        ExUtils.initialize(this);
    }

    public ApplicationComponent getAppComponent(){
        return DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .githubApiModule(new GithubApiModule())
                .build();
    }

    public static MyApplication getApplicationContext2(){
        return application;
    }

}
