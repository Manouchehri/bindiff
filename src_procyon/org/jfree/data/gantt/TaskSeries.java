package org.jfree.data.gantt;

import org.jfree.data.general.*;
import java.util.*;

public class TaskSeries extends Series
{
    private List tasks;
    
    public TaskSeries(final String s) {
        super(s);
        this.tasks = new ArrayList();
    }
    
    public void add(final Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Null 'task' argument.");
        }
        this.tasks.add(task);
        this.fireSeriesChanged();
    }
    
    public void remove(final Task task) {
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
    
    public Task get(final int n) {
        return this.tasks.get(n);
    }
    
    public Task get(final String s) {
        Task task = null;
        for (int size = this.tasks.size(), i = 0; i < size; ++i) {
            final Task task2 = this.tasks.get(i);
            if (task2.getDescription().equals(s)) {
                task = task2;
                break;
            }
        }
        return task;
    }
    
    public List getTasks() {
        return Collections.unmodifiableList((List<?>)this.tasks);
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof TaskSeries && super.equals(o) && this.tasks.equals(((TaskSeries)o).tasks));
    }
}
