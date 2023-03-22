package dev._2lstudios.libtask;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public class TaskHandler {
    private Plugin plugin;
    private Task task;
    private boolean async;
    private long delay;

    public TaskHandler(Plugin plugin, Task task, boolean async, long delay) {
        this.plugin = plugin;
        this.task = task;
        this.async = async;
        this.delay = delay;
    }

    public TaskHandler(Plugin plugin, Task task) {
        this(plugin, task, false, 0);
    }

    public void run(Runnable callback) {
        BukkitScheduler scheduler = this.plugin.getServer().getScheduler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                task.run();
                if (callback != null) {
                    callback.run();
                }
            }
        };

        // Async with delay
        if (this.async && this.delay > 0) {
            scheduler.runTaskLaterAsynchronously(this.plugin, runnable, this.delay);
        }

        // Async without delay
        else if (this.async && this.delay == 0) {
            scheduler.runTaskAsynchronously(this.plugin, runnable);
        }

        // Sync with delay
        else if (!this.async && this.delay > 0) {
            scheduler.runTaskLater(this.plugin, runnable, this.delay);
        }

        // Sync without delay
        else if (!this.async && this.delay == 0) {
            scheduler.runTask(this.plugin, runnable);
        }
    }
}
