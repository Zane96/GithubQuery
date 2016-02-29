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
import rx.Subscriber;
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

    //对用户信息进行一层过滤或者操作,然后在presenter中去调用这个方法.
    //当然我在这里做的操作毫无意义，但是如果有需要还是会减少activity活着fragment中的代码量。
    //presenter只负责调用。然后获得数据而不管代码的实现
    public Observable<Users> getUserInfo(String userName){

        return githubApiService.getUserInfo(userName)
                .map(new Func1<Users, Users>() {
                    @Override
                    public Users call(Users users) {
                        String name = users.getName();
                        users.setName(name + " datamanager");
                        return users;
                    }
                })
                .flatMap(new Func1<Users, Observable<Users>>() {
                    @Override
                    public Observable<Users> call(final Users users) {
                        return Observable.create(new Observable.OnSubscribe<Users>() {
                            @Override
                            public void call(Subscriber<? super Users> subscriber) {
                                subscriber.onNext(users);
                            }
                        });
                    }
                });

    }

    //对库的信息进行一层过滤
    public Observable<List<Repos>> getReposInfo(String userName){
        return githubApiService.getReposInfo(userName);
    }

}
