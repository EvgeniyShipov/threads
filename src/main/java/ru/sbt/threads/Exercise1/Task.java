package ru.sbt.threads.Exercise1;

import java.util.concurrent.Callable;


public class Task<T> {
    private final Callable<? extends T> callable;
    private volatile T object = null;
    Object mutex = new Object();

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() {
        if (object != null) {
            return object;
        }
        synchronized (mutex) {
            try {
                object = callable.call();
            } catch (Exception e) {
                throw new CallableException(e);
            }
        }
        return object;
    }
}

