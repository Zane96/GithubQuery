package com.example.zane.githubquery.app;

import android.app.Application;

import com.example.zane.githubquery.inject.component.ApplicationComponent;
import com.example.zane.githubquery.inject.module.ApplicationModule;
import com.example.zane.githubquery.inject.module.GithubApiModule;
import com.kermit.exutils.utils.ExUtils;

import javax.inject.Inject;

/**
 * Created by Zane on 16/1/26.
 */
public class MyApplication extends Application{


    @Override
    public void onCreate() {
        super.onCreate();
        ExUtils.initialize(this);
    }

    public ApplicationComponent getAppComponent(){
        return DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .githubApiModule(new GithubApiModule())
                .build();
    }

}
