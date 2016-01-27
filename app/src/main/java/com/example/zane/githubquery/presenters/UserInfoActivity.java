package com.example.zane.githubquery.presenters;

import com.example.zane.easymvp.presenter.BaseActivityPresenter;
import com.example.zane.githubquery.view.UserInfoView;

/**
 * Created by Zane on 16/1/27.
 */
public class UserInfoActivity extends BaseActivityPresenter<UserInfoView>{

    @Override
    public Class<UserInfoView> getRootViewClass() {
        return UserInfoView.class;
    }

    @Override
    public void inCreat() {
        
    }

    @Override
    public void inDestory() {

    }
}
