package ru.sbt.threads.Exercise2;


public interface Context {
    int getCompletedTaskCount();

    int getFailedTaskCount();

    int getInterruptedTaskCount();

    void interrupt();

    boolean isFinished();
}
