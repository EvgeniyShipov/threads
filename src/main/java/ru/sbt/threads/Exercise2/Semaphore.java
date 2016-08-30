package ru.sbt.threads.Exercise2;


public class Semaphore {
    private final Object lock = new Object();
    private final int maxThreadCount;
    private int current;

    public Semaphore(int maxThreadCount) {
        this.maxThreadCount = maxThreadCount;
    }

    public void enter() {
        synchronized (lock) {
            while (current > maxThreadCount) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            ++current;
        }
    }

    public void exit() {
        synchronized (lock) {
            --current;
            notify();
        }
    }
}
