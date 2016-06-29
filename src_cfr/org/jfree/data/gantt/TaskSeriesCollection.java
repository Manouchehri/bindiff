/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.gantt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.jfree.data.gantt.GanttCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.general.AbstractSeriesDataset;
import org.jfree.data.general.SeriesChangeEvent;
import org.jfree.data.general.SeriesChangeListener;
import org.jfree.data.time.TimePeriod;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class TaskSeriesCollection
extends AbstractSeriesDataset
implements Serializable,
Cloneable,
GanttCategoryDataset,
PublicCloneable {
    private static final long serialVersionUID = -2065799050738449903L;
    private List keys = new ArrayList();
    private List data = new ArrayList();

    public TaskSeries getSeries(Comparable comparable) {
        if (comparable == null) {
            throw new NullPointerException("Null 'key' argument.");
        }
        TaskSeries taskSeries = null;
        int n2 = this.getRowIndex(comparable);
        if (n2 < 0) return taskSeries;
        return this.getSeries(n2);
    }

    public TaskSeries getSeries(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("Series index out of bounds");
        if (n2 < this.getSeriesCount()) return (TaskSeries)this.data.get(n2);
        throw new IllegalArgumentException("Series index out of bounds");
    }

    @Override
    public int getSeriesCount() {
        return this.getRowCount();
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        TaskSeries taskSeries = (TaskSeries)this.data.get(n2);
        return taskSeries.getKey();
    }

    @Override
    public int getRowCount() {
        return this.data.size();
    }

    @Override
    public List getRowKeys() {
        return this.data;
    }

    @Override
    public int getColumnCount() {
        return this.keys.size();
    }

    @Override
    public List getColumnKeys() {
        return this.keys;
    }

    @Override
    public Comparable getColumnKey(int n2) {
        return (Comparable)this.keys.get(n2);
    }

    @Override
    public int getColumnIndex(Comparable comparable) {
        return this.keys.indexOf(comparable);
    }

    @Override
    public int getRowIndex(Comparable comparable) {
        int n2 = -1;
        int n3 = this.data.size();
        int n4 = 0;
        while (n4 < n3) {
            TaskSeries taskSeries = (TaskSeries)this.data.get(n4);
            if (taskSeries.getKey().equals(comparable)) {
                return n4;
            }
            ++n4;
        }
        return n2;
    }

    @Override
    public Comparable getRowKey(int n2) {
        TaskSeries taskSeries = (TaskSeries)this.data.get(n2);
        return taskSeries.getKey();
    }

    public void add(TaskSeries taskSeries) {
        if (taskSeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        this.data.add(taskSeries);
        taskSeries.addChangeListener(this);
        Iterator iterator = taskSeries.getTasks().iterator();
        do {
            if (!iterator.hasNext()) {
                this.fireDatasetChanged();
                return;
            }
            Task task = (Task)iterator.next();
            String string = task.getDescription();
            int n2 = this.keys.indexOf(string);
            if (n2 >= 0) continue;
            this.keys.add(string);
        } while (true);
    }

    public void remove(TaskSeries taskSeries) {
        if (taskSeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        if (!this.data.contains(taskSeries)) return;
        taskSeries.removeChangeListener(this);
        this.data.remove(taskSeries);
        this.fireDatasetChanged();
    }

    public void remove(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("TaskSeriesCollection.remove(): index outside valid range.");
        if (n2 >= this.getSeriesCount()) {
            throw new IllegalArgumentException("TaskSeriesCollection.remove(): index outside valid range.");
        }
        TaskSeries taskSeries = (TaskSeries)this.data.get(n2);
        taskSeries.removeChangeListener(this);
        this.data.remove(n2);
        this.fireDatasetChanged();
    }

    public void removeAll() {
        Iterator iterator = this.data.iterator();
        do {
            if (!iterator.hasNext()) {
                this.data.clear();
                this.fireDatasetChanged();
                return;
            }
            TaskSeries taskSeries = (TaskSeries)iterator.next();
            taskSeries.removeChangeListener(this);
        } while (true);
    }

    @Override
    public Number getValue(Comparable comparable, Comparable comparable2) {
        return this.getStartValue(comparable, comparable2);
    }

    @Override
    public Number getValue(int n2, int n3) {
        return this.getStartValue(n2, n3);
    }

    @Override
    public Number getStartValue(Comparable comparable, Comparable comparable2) {
        Long l2 = null;
        int n2 = this.getRowIndex(comparable);
        TaskSeries taskSeries = (TaskSeries)this.data.get(n2);
        Task task = taskSeries.get(comparable2.toString());
        if (task == null) return l2;
        TimePeriod timePeriod = task.getDuration();
        if (timePeriod == null) return l2;
        return new Long(timePeriod.getStart().getTime());
    }

    @Override
    public Number getStartValue(int n2, int n3) {
        Comparable comparable = this.getRowKey(n2);
        Comparable comparable2 = this.getColumnKey(n3);
        return this.getStartValue(comparable, comparable2);
    }

    @Override
    public Number getEndValue(Comparable comparable, Comparable comparable2) {
        Long l2 = null;
        int n2 = this.getRowIndex(comparable);
        TaskSeries taskSeries = (TaskSeries)this.data.get(n2);
        Task task = taskSeries.get(comparable2.toString());
        if (task == null) return l2;
        TimePeriod timePeriod = task.getDuration();
        if (timePeriod == null) return l2;
        return new Long(timePeriod.getEnd().getTime());
    }

    @Override
    public Number getEndValue(int n2, int n3) {
        Comparable comparable = this.getRowKey(n2);
        Comparable comparable2 = this.getColumnKey(n3);
        return this.getEndValue(comparable, comparable2);
    }

    @Override
    public Number getPercentComplete(int n2, int n3) {
        Comparable comparable = this.getRowKey(n2);
        Comparable comparable2 = this.getColumnKey(n3);
        return this.getPercentComplete(comparable, comparable2);
    }

    @Override
    public Number getPercentComplete(Comparable comparable, Comparable comparable2) {
        Double d2 = null;
        int n2 = this.getRowIndex(comparable);
        TaskSeries taskSeries = (TaskSeries)this.data.get(n2);
        Task task = taskSeries.get(comparable2.toString());
        if (task == null) return d2;
        return task.getPercentComplete();
    }

    @Override
    public int getSubIntervalCount(int n2, int n3) {
        Comparable comparable = this.getRowKey(n2);
        Comparable comparable2 = this.getColumnKey(n3);
        return this.getSubIntervalCount(comparable, comparable2);
    }

    @Override
    public int getSubIntervalCount(Comparable comparable, Comparable comparable2) {
        int n2 = 0;
        int n3 = this.getRowIndex(comparable);
        TaskSeries taskSeries = (TaskSeries)this.data.get(n3);
        Task task = taskSeries.get(comparable2.toString());
        if (task == null) return n2;
        return task.getSubtaskCount();
    }

    @Override
    public Number getStartValue(int n2, int n3, int n4) {
        Comparable comparable = this.getRowKey(n2);
        Comparable comparable2 = this.getColumnKey(n3);
        return this.getStartValue(comparable, comparable2, n4);
    }

    @Override
    public Number getStartValue(Comparable comparable, Comparable comparable2, int n2) {
        Long l2 = null;
        int n3 = this.getRowIndex(comparable);
        TaskSeries taskSeries = (TaskSeries)this.data.get(n3);
        Task task = taskSeries.get(comparable2.toString());
        if (task == null) return l2;
        Task task2 = task.getSubtask(n2);
        if (task2 == null) return l2;
        TimePeriod timePeriod = task2.getDuration();
        return new Long(timePeriod.getStart().getTime());
    }

    @Override
    public Number getEndValue(int n2, int n3, int n4) {
        Comparable comparable = this.getRowKey(n2);
        Comparable comparable2 = this.getColumnKey(n3);
        return this.getEndValue(comparable, comparable2, n4);
    }

    @Override
    public Number getEndValue(Comparable comparable, Comparable comparable2, int n2) {
        Long l2 = null;
        int n3 = this.getRowIndex(comparable);
        TaskSeries taskSeries = (TaskSeries)this.data.get(n3);
        Task task = taskSeries.get(comparable2.toString());
        if (task == null) return l2;
        Task task2 = task.getSubtask(n2);
        if (task2 == null) return l2;
        TimePeriod timePeriod = task2.getDuration();
        return new Long(timePeriod.getEnd().getTime());
    }

    @Override
    public Number getPercentComplete(int n2, int n3, int n4) {
        Comparable comparable = this.getRowKey(n2);
        Comparable comparable2 = this.getColumnKey(n3);
        return this.getPercentComplete(comparable, comparable2, n4);
    }

    @Override
    public Number getPercentComplete(Comparable comparable, Comparable comparable2, int n2) {
        Double d2 = null;
        int n3 = this.getRowIndex(comparable);
        TaskSeries taskSeries = (TaskSeries)this.data.get(n3);
        Task task = taskSeries.get(comparable2.toString());
        if (task == null) return d2;
        Task task2 = task.getSubtask(n2);
        if (task2 == null) return d2;
        return task2.getPercentComplete();
    }

    @Override
    public void seriesChanged(SeriesChangeEvent seriesChangeEvent) {
        this.refreshKeys();
        this.fireDatasetChanged();
    }

    private void refreshKeys() {
        this.keys.clear();
        int n2 = 0;
        while (n2 < this.getSeriesCount()) {
            TaskSeries taskSeries = (TaskSeries)this.data.get(n2);
            for (Task task : taskSeries.getTasks()) {
                String string = task.getDescription();
                int n3 = this.keys.indexOf(string);
                if (n3 >= 0) continue;
                this.keys.add(string);
            }
            ++n2;
        }
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof TaskSeriesCollection)) {
            return false;
        }
        TaskSeriesCollection taskSeriesCollection = (TaskSeriesCollection)object;
        if (ObjectUtilities.equal(this.data, taskSeriesCollection.data)) return true;
        return false;
    }
}

