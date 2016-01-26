package com.example.zane.githubquery.model.bean.data.remote;

import android.content.Context;

import com.example.zane.githubquery.inject.qualifier.ContextType;

import javax.inject.Inject;

/**
 * Created by Zane on 16/1/26.
 */
public class DataManager {

    private GithubApiService githubApiService;
    private Context mContext;

    @Inject
    public DataManager(@ContextType("MyApplication")Context context, GithubApiService githubApiService){
        this.githubApiService = githubApiService;
        mContext = context;
    }

}
