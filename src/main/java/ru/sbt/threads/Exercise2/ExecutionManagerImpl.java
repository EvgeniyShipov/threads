package ru.sbt.threads.Exercise2;


public class ExecutionManagerImpl implements ExecutionManager {
    private final ContextImpl context = new ContextImpl();
    private final Semaphore semaphore;

    public ExecutionManagerImpl(int maximumTreads) {
        semaphore = new Semaphore(maximumTreads);
    }

    public Context execute(Runnable callback, Runnable... tasks) {
        try {
            for (Runnable r : tasks) {
                Thread thread = new Thread(new taskWrapper(r));
                thread.start();
            }
        } finally {
            Thread callbackThread = new Thread(callback);
            callbackThread.start();
            context.finish();
        }

        return context;
    }

    private class taskWrapper implements Runnable {
        private Runnable task;

        private taskWrapper(Runnable task) {
            this.task = task;
        }

        public void run() {
            semaphore.enter();
            if (!context.isInterrupt()) {
                try {
                    task.run();
                } catch (Exception e) {
                    context.addFailedTask();
                    throw new RuntimeException(e);
                } finally {
                    context.addWellDoneTask();
                    semaphore.exit();
                }
            } else context.addInterruptedTask();
        }
    }
}
