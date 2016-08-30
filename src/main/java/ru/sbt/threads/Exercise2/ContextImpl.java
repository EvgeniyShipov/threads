package ru.sbt.threads.Exercise2;


public class ContextImpl implements Context {

    private volatile int wellDoneTask = 0;
    private volatile int failedTask = 0;
    private volatile int interruptedTask = 0;
    private volatile boolean isFinish = false;
    private volatile boolean isInterrupt = false;

    public int getCompletedTaskCount() {
        return wellDoneTask;
    }

    public int getFailedTaskCount() {
        return failedTask;
    }

    public int getInterruptedTaskCount() {
        return interruptedTask;
    }

    public void interrupt() {
        isInterrupt = true;
    }

    public boolean isFinished() {
        return isFinish;
    }

    public void addWellDoneTask() {
        wellDoneTask++;
    }

    public void addFailedTask() {
        failedTask++;
    }

    public void addInterruptedTask() {
        interruptedTask++;
    }

    public void finish() {
        isFinish = true;
    }

    public boolean isInterrupt() {
        return isInterrupt;
    }
}
