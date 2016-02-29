package com.example.zane.githubquery.inject.module;

import android.app.Application;
import android.content.Context;

import com.example.zane.githubquery.app.MyApplication;
import com.example.zane.githubquery.inject.qualifier.ContextType;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Zane on 16/1/26.
 */
@Module
public class ApplicationModule {

    private MyApplication mApplication;

    public ApplicationModule(MyApplication application){
        mApplication = application;
    }

    @Provides
    @Singleton
    MyApplication providesApplication(){
        return mApplication;
    }

    @Provides
    @Singleton
    @ContextType("MyApplication")
    Context providesContext(MyApplication application){
        return application.getApplicationContext();
    }
}
