package com.tuki.common;

import io.reactivex.Scheduler;

public interface ExecutionThread {

    Scheduler get();
}
