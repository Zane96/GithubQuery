package com.example.zane.githubquery.utils;

import android.os.Environment;

import com.example.zane.githubquery.app.MyApplication;

import java.io.File;

import javax.inject.Inject;

/**
 * Created by Zane on 16/1/26.
 */
public class FileUtils2 {

    private static MyApplication mApplicationContext = MyApplication.getApplication();

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
