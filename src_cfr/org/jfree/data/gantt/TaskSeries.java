/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.gantt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jfree.data.gantt.Task;
import org.jfree.data.general.Series;

public class TaskSeries
extends Series {
    private List tasks = new ArrayList();

    public TaskSeries(String string) {
        super((Comparable)((Object)string));
    }

    public void add(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Null 'task' argument.");
        }
        this.tasks.add(task);
        this.fireSeriesChanged();
    }

    public void remove(Task task) {
        this.tasks.remove(task);
        this.fireSeriesChanged();
    }

    public void removeAll() {
        this.tasks.clear();
        this.fireSeriesChanged();
    }

    public int getItemCount() {
        return this.tasks.size();
    }

    public Task get(int n2) {
        return (Task)this.tasks.get(n2);
    }

    public Task get(String string) {
        Task task = null;
        int n2 = this.tasks.size();
        int n3 = 0;
        while (n3 < n2) {
            Task task2 = (Task)this.tasks.get(n3);
            if (task2.getDescription().equals(string)) {
                return task2;
            }
            ++n3;
        }
        return task;
    }

    public List getTasks() {
        return Collections.unmodifiableList(this.tasks);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof TaskSeries)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        TaskSeries taskSeries = (TaskSeries)object;
        if (this.tasks.equals(taskSeries.tasks)) return true;
        return false;
    }
}

