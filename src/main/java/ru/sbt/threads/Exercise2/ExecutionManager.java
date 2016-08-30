package ru.sbt.threads.Exercise2;


public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}

