package dev._2lstudios.libtask.scheduler;

public interface Scheduler {
    public void runTaskLaterAsynchronously(Object plugin, Runnable runnable, long delay);

    public void runTaskAsynchronously(Object plugin, Runnable runnable);

    public void runTaskLater(Object plugin, Runnable runable, long delay);

    public void runTask(Object plugin, Runnable runnable);
}
