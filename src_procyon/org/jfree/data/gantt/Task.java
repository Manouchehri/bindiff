package org.jfree.data.gantt;

import java.io.*;
import java.util.*;
import org.jfree.data.time.*;
import org.jfree.util.*;

public class Task implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = 1094303785346988894L;
    private String description;
    private TimePeriod duration;
    private Double percentComplete;
    private List subtasks;
    
    public Task(final String description, final TimePeriod duration) {
        if (description == null) {
            throw new IllegalArgumentException("Null 'description' argument.");
        }
        this.description = description;
        this.duration = duration;
        this.percentComplete = null;
        this.subtasks = new ArrayList();
    }
    
    public Task(final String s, final Date date, final Date date2) {
        this(s, new SimpleTimePeriod(date, date2));
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(final String description) {
        if (description == null) {
            throw new IllegalArgumentException("Null 'description' argument.");
        }
        this.description = description;
    }
    
    public TimePeriod getDuration() {
        return this.duration;
    }
    
    public void setDuration(final TimePeriod duration) {
        this.duration = duration;
    }
    
    public Double getPercentComplete() {
        return this.percentComplete;
    }
    
    public void setPercentComplete(final Double percentComplete) {
        this.percentComplete = percentComplete;
    }
    
    public void setPercentComplete(final double n) {
        this.setPercentComplete(new Double(n));
    }
    
    public void addSubtask(final Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Null 'subtask' argument.");
        }
        this.subtasks.add(task);
    }
    
    public void removeSubtask(final Task task) {
        this.subtasks.remove(task);
    }
    
    public int getSubtaskCount() {
        return this.subtasks.size();
    }
    
    public Task getSubtask(final int n) {
        return this.subtasks.get(n);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Task)) {
            return false;
        }
        final Task task = (Task)o;
        return ObjectUtilities.equal(this.description, task.description) && ObjectUtilities.equal(this.duration, task.duration) && ObjectUtilities.equal(this.percentComplete, task.percentComplete) && ObjectUtilities.equal(this.subtasks, task.subtasks);
    }
    
    public Object clone() {
        return super.clone();
    }
}
