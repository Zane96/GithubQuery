package com.example.zane.githubquery.inject.module;

import android.text.TextUtils;

import com.example.zane.githubquery.config.GithubApi;
import com.example.zane.githubquery.inject.qualifier.GithubServiceType;
import com.example.zane.githubquery.model.bean.data.remote.GithubApiService;
import com.example.zane.githubquery.utils.FileUtils2;
import com.kermit.exutils.utils.ExUtils;
import com.kermit.exutils.utils.FileUtils;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;


/**
 * Created by Zane on 16/1/26.
 */
@Module
public class GithubApiModule {

    @Provides
    Interceptor providesIntercepter(){
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);

                String chainControl = request.cacheControl().toString();
                if(TextUtils.isEmpty(chainControl)){
                    chainControl = "public, max-age=60, max-stale=240000";
                }

                return response.newBuilder()
                        .addHeader("Chain-Control", chainControl)
                        .removeHeader("Pragma")
                        .build();
            }
        };
    }

    @Provides
    Cache providesCache(){
        File httpCacheFile = FileUtils2.getDiskCacheDir("response");
        return new Cache(httpCacheFile, 1024 * 10 * 1024);
    }

    @Provides
    @GithubServiceType("userinfo")
    GithubApiService providesGithubApiService(Interceptor interceptor, Cache cache){

        OkHttpClient client = new OkHttpClient();
        client.networkInterceptors().add(interceptor);
        client.setCache(cache);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GithubApi.githubApi)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(GithubApiService.class);

    }

    @Provides
    @GithubServiceType("avatar")
    GithubApiService providesGithubApiService(){

        Retrofit retrofit = new Retrofit.Builder()
                                    .baseUrl(GithubApi.avatarApi)
                                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                                    .build();

        return retrofit.create(GithubApiService.class);

    }
}
