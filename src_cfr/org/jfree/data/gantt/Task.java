/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.gantt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.data.time.TimePeriod;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class Task
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = 1094303785346988894L;
    private String description;
    private TimePeriod duration;
    private Double percentComplete;
    private List subtasks;

    public Task(String string, TimePeriod timePeriod) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'description' argument.");
        }
        this.description = string;
        this.duration = timePeriod;
        this.percentComplete = null;
        this.subtasks = new ArrayList();
    }

    public Task(String string, Date date, Date date2) {
        this(string, new SimpleTimePeriod(date, date2));
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'description' argument.");
        }
        this.description = string;
    }

    public TimePeriod getDuration() {
        return this.duration;
    }

    public void setDuration(TimePeriod timePeriod) {
        this.duration = timePeriod;
    }

    public Double getPercentComplete() {
        return this.percentComplete;
    }

    public void setPercentComplete(Double d2) {
        this.percentComplete = d2;
    }

    public void setPercentComplete(double d2) {
        this.setPercentComplete(new Double(d2));
    }

    public void addSubtask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Null 'subtask' argument.");
        }
        this.subtasks.add(task);
    }

    public void removeSubtask(Task task) {
        this.subtasks.remove(task);
    }

    public int getSubtaskCount() {
        return this.subtasks.size();
    }

    public Task getSubtask(int n2) {
        return (Task)this.subtasks.get(n2);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Task)) {
            return false;
        }
        Task task = (Task)object;
        if (!ObjectUtilities.equal(this.description, task.description)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.duration, task.duration)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.percentComplete, task.percentComplete)) {
            return false;
        }
        if (ObjectUtilities.equal(this.subtasks, task.subtasks)) return true;
        return false;
    }

    @Override
    public Object clone() {
        return (Task)super.clone();
    }
}

