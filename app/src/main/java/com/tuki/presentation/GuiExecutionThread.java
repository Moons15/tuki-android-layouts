package com.tuki.presentation;


import com.tuki.common.ExecutionThread;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class GuiExecutionThread implements ExecutionThread {

    @Override
    public Scheduler get() {
        return AndroidSchedulers.mainThread();
    }
}
