package dev._2lstudios.libtask;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.Plugin;

public class TaskChain {
    private Plugin plugin;
    private List<TaskHandler> tasks;
    private long delay;

    private int currentIndex;

    public TaskChain(Plugin plugin) {
        this.plugin = plugin;
        this.tasks = new ArrayList<>();
        this.delay = 0;
    }

    public TaskChain waitTicks(long ticks) {
        this.delay = ticks;
        return this;
    }

    public TaskChain waitSeconds(int seconds) {
        return this.waitTicks(seconds * 20);
    }

    public TaskChain then(Task task) {
        this.tasks.add(new TaskHandler(this.plugin, task, false, this.delay));
        if (this.delay > 0) {
            this.delay = 0;
        }
        return this;
    }

    public TaskChain async(Task task) {
        this.tasks.add(new TaskHandler(this.plugin, task, true, this.delay));
        if (this.delay > 0) {
            this.delay = 0;
        }
        return this;
    }

    public TaskChain reset() {
        this.currentIndex = 0;
        return this;
    }

    public TaskHandler nextTask() {
        if (this.currentIndex >= this.tasks.size()) {
            return null;
        }

        TaskHandler task = this.tasks.get(this.currentIndex);
        this.currentIndex += 1;
        return task;
    }

    public TaskHandler runNextTask(Runnable callback) {
        TaskHandler task = this.nextTask();
        if (task != null) {
            task.run(callback);
        }
        return task;
    }

    public TaskChain run() {
        this.runNextTask(() -> {
            this.run();
        });
        return this;
    }
}
