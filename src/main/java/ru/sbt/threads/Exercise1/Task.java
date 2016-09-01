package ru.sbt.threads.Exercise1;

import java.util.concurrent.Callable;


public class Task<T> {
    private final Callable<? extends T> callable;
    private final Object lock = new Object();
    private volatile boolean isCallable = false;
    private T object = null;
    private CallableException exception = null;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() {
        if (!isCallable) {
            synchronized (lock) {
                if (!isCallable) {
                    try {
                        object = callable.call();
                        isCallable = true;
                    } catch (Exception e) {
                        exception = new CallableException(e);
                        throw exception;
                    }
                }
            }
        }

        if (exception != null) throw exception;

        return object;
    }
}

