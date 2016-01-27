package com.example.zane.githubquery.inject.component;

import com.example.zane.githubquery.inject.module.ActivityModule;
import com.example.zane.githubquery.inject.scope.ActivityLife;
import com.example.zane.githubquery.presenters.MainActivity;
import com.example.zane.githubquery.presenters.ReposActivity;
import com.example.zane.githubquery.presenters.UserInfoActivity;

import dagger.Component;

/**
 * Created by Zane on 16/1/26.
 */
@ActivityLife
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(UserInfoActivity activity);

    void inject(ReposActivity activity);

}
