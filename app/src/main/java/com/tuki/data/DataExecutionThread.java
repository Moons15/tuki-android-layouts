package com.tuki.data;


import com.tuki.common.ExecutionThread;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class DataExecutionThread implements ExecutionThread {

    @Override
    public Scheduler get() {
        return Schedulers.io();
    }
}
