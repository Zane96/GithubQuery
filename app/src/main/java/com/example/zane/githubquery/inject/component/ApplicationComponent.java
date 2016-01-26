package com.example.zane.githubquery.inject.component;

import android.content.Context;

import com.example.zane.githubquery.app.MyApplication;
import com.example.zane.githubquery.inject.module.ApplicationModule;
import com.example.zane.githubquery.inject.module.GithubApiModule;
import com.example.zane.githubquery.model.bean.data.remote.GithubApiService;

import dagger.Component;

/**
 * Created by Zane on 16/1/26.
 */
@Component(modules = {ApplicationModule.class, GithubApiModule.class})
public interface ApplicationComponent {

    MyApplication myApplication();

    Context context();

    GithubApiService githubApiService();

}
