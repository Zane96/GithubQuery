package com.example.zane.githubquery.utils;

import android.content.Context;
import android.os.Environment;

import com.example.zane.githubquery.app.MyApplication;
import com.example.zane.githubquery.inject.qualifier.ContextType;

import java.io.File;

import javax.inject.Inject;

/**
 * Created by Zane on 16/1/26.
 */
public class FileUtils2 {

    static Context mApplicationContext = MyApplication.getApplicationContext2();

    public static File getDiskCacheDir(String uniqueName) {

        String cachePath;
        if(!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
            cachePath = mApplicationContext.getCacheDir().getPath();
        } else {
            cachePath = mApplicationContext.getExternalCacheDir().getPath();
        }

        return new File(cachePath + File.separator + uniqueName);
    }
}
