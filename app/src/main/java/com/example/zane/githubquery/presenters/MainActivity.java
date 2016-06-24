package com.example.zane.githubquery.presenters;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.zane.easymvp.presenter.BaseActivityPresenter;
import com.example.zane.githubquery.R;
import com.example.zane.githubquery.view.MainView;

public class MainActivity extends BaseActivityPresenter<MainView> {

    public static final String USERNAME = "USERNAME";
    private String userName;

    @Override
    public Class<MainView> getRootViewClass() {
        return MainView.class;
    }

    @Override
    public void inCreat(Bundle bundle) {



        v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v2) {
                userName = v.getEditText();
                Intent intent = new Intent(MainActivity.this, UserInfoActivity.class);
                Log.i("MainActivity", userName+"heheh");
                intent.putExtra(USERNAME, userName);
                startActivity(intent);
            }
        }, R.id.button_query);


    }

    @Override
    public void inDestory() {
        userName = null;
    }
}
