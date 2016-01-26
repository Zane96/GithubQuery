package com.example.zane.githubquery.inject.component;

import com.example.zane.githubquery.inject.module.ActivityModule;

import dagger.Component;

/**
 * Created by Zane on 16/1/26.
 */
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {

    // TODO: 16/1/26 添加各种活动的针头

}
