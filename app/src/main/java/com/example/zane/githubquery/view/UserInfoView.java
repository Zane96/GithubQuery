package com.example.zane.githubquery.view;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zane.easymvp.view.BaseViewImpl;
import com.example.zane.githubquery.R;

import butterknife.Bind;

/**
 * Created by Zane on 16/1/27.
 */
public class UserInfoView extends BaseViewImpl {

    @Bind(R.id.imageview_avatar)
    ImageView imageviewAvatar;
    @Bind(R.id.textview_loginname)
    TextView textviewLoginname;
    @Bind(R.id.textview_name)
    TextView textviewName;
    @Bind(R.id.textview_followersname)
    TextView textviewFollowersname;
    @Bind(R.id.textview_followingname)
    TextView textviewFollowingname;
    @Bind(R.id.textview_location)
    TextView textviewLocation;
    @Bind(R.id.repos_query)
    Button reposQuery;
    @Bind(R.id.userinfo_activity_progressbar)
    ProgressBar userinfoActivityProgressbar;

    @Override
    public int getRootViewId() {
        return R.layout.activity_userinfo_layout;
    }

    public ImageView getImageviewAvatar() {
        return imageviewAvatar;
    }

    public void setLoginName(String loginName) {
        textviewLoginname.setText(loginName);
    }

    public void setTextviewName(String name) {
        textviewName.setText(name);
    }

    public void setTextviewFollowersname(int followersNum) {
        textviewFollowersname.setText(String.valueOf(followersNum));
    }

    public void setTextviewFollowingname(int followingNum) {
        textviewFollowingname.setText(String.valueOf(followingNum));
    }

    public void setTextviewLocation(String location) {
        textviewLocation.setText(location);
    }
    public void hideProgressbar(){
        userinfoActivityProgressbar.setVisibility(View.INVISIBLE);
    }
    public void seeProgressBar(){
        userinfoActivityProgressbar.setVisibility(View.VISIBLE);
    }

}
