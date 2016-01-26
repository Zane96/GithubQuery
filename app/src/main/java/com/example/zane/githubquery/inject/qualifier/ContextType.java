package com.example.zane.githubquery.inject.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by Zane on 16/1/26.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ContextType {
    String value()default "MyApplication";
}
