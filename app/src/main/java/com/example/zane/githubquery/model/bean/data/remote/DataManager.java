package com.example.zane.githubquery.model.bean.data.remote;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.zane.githubquery.inject.qualifier.ContextType;
import com.example.zane.githubquery.model.bean.Repos;
import com.example.zane.githubquery.model.bean.Users;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Zane on 16/1/26.
 */
@Singleton
public class DataManager {

    private GithubApiService githubApiService;
    private Context mContext;

    @Inject
    public DataManager(@ContextType("MyApplication")Context context, GithubApiService githubApiService){
        this.githubApiService = githubApiService;
        mContext = context;
    }

    //对用户信息进行一层过滤,然后在presenter中去调用这个方法.
    public Observable<Users> getUserInfo(String userName){

        return githubApiService.getUserInfo(userName);

    }

    //对库的信息进行一层过滤
    public Observable<List<Repos>> getReposInfo(String userName){
        return githubApiService.getReposInfo(userName);
    }

}
