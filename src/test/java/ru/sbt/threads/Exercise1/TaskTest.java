package ru.sbt.threads.Exercise1;

import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


public class TaskTest {

    @Test
    public void callableTest() throws Exception {
        Task mockTask = mock(Task.class);
        assertEquals(mockTask.get(), null);
    }
}