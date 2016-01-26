package com.example.zane.githubquery.inject.module;

import android.app.Activity;
import android.content.Context;

import com.example.zane.githubquery.inject.qualifier.ContextType;
import com.example.zane.githubquery.inject.scope.ActivityLife;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Zane on 16/1/26.
 */
@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity){
        this.activity = activity;
    }

    @Provides
    @ActivityLife
    Activity providesActivity(){
        return activity;
    }

    @Provides
    @ActivityLife
    @ContextType("Activity")
    Context providesContext(){
        return activity;
    }

}
