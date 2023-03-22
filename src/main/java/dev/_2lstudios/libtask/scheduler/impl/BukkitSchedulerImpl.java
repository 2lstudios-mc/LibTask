package dev._2lstudios.libtask.scheduler.impl;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

import dev._2lstudios.libtask.scheduler.Scheduler;

public class BukkitSchedulerImpl implements Scheduler {
    private BukkitScheduler scheduler;

    public BukkitSchedulerImpl() {
        this.scheduler = Bukkit.getScheduler();
    }

    @Override
    public void runTaskLaterAsynchronously(Object plugin, Runnable runnable, long delay) {
        Plugin plugin = (Plugin) plugin;
        throw new UnsupportedOperationException("Unimplemented method 'runTaskLaterAsynchronously'");
    }

    @Override
    public void runTaskAsynchronously(Object plugin, Runnable runnable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'runTaskAsynchronously'");
    }

    @Override
    public void runTaskLater(Object plugin, Runnable runable, long delay) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'runTaskLater'");
    }

    @Override
    public void runTask(Object plugin, Runnable runnable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'runTask'");
    }

}
