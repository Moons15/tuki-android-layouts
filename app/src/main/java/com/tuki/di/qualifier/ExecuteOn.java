package com.tuki.di.qualifier;

import com.tuki.di.ThreadTask;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Qualifier
@Documented
@Retention(RUNTIME)
public @interface ExecuteOn {
    ThreadTask value() default ThreadTask.GUI;
}
