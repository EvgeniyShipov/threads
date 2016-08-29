package ru.sbt.threads.Exercise1;


public class CallableException extends RuntimeException {
    public CallableException(Exception e) {
        super(e);
        System.out.println("Произошла ошибка. Попробуйте позже.");
    }
}
