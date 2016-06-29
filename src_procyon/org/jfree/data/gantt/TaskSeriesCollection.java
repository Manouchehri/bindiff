package org.jfree.data.gantt;

import java.io.*;
import java.util.*;
import org.jfree.data.time.*;
import org.jfree.data.general.*;
import org.jfree.util.*;

public class TaskSeriesCollection extends AbstractSeriesDataset implements Serializable, Cloneable, GanttCategoryDataset, PublicCloneable
{
    private static final long serialVersionUID = -2065799050738449903L;
    private List keys;
    private List data;
    
    public TaskSeriesCollection() {
        this.keys = new ArrayList();
        this.data = new ArrayList();
    }
    
    public TaskSeries getSeries(final Comparable comparable) {
        if (comparable == null) {
            throw new NullPointerException("Null 'key' argument.");
        }
        TaskSeries series = null;
        final int rowIndex = this.getRowIndex(comparable);
        if (rowIndex >= 0) {
            series = this.getSeries(rowIndex);
        }
        return series;
    }
    
    public TaskSeries getSeries(final int n) {
        if (n < 0 || n >= this.getSeriesCount()) {
            throw new IllegalArgumentException("Series index out of bounds");
        }
        return this.data.get(n);
    }
    
    public int getSeriesCount() {
        return this.getRowCount();
    }
    
    public Comparable getSeriesKey(final int n) {
        return this.data.get(n).getKey();
    }
    
    public int getRowCount() {
        return this.data.size();
    }
    
    public List getRowKeys() {
        return this.data;
    }
    
    public int getColumnCount() {
        return this.keys.size();
    }
    
    public List getColumnKeys() {
        return this.keys;
    }
    
    public Comparable getColumnKey(final int n) {
        return this.keys.get(n);
    }
    
    public int getColumnIndex(final Comparable comparable) {
        return this.keys.indexOf(comparable);
    }
    
    public int getRowIndex(final Comparable comparable) {
        int n = -1;
        for (int size = this.data.size(), i = 0; i < size; ++i) {
            if (((TaskSeries)this.data.get(i)).getKey().equals(comparable)) {
                n = i;
                break;
            }
        }
        return n;
    }
    
    public Comparable getRowKey(final int n) {
        return this.data.get(n).getKey();
    }
    
    public void add(final TaskSeries taskSeries) {
        if (taskSeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        this.data.add(taskSeries);
        taskSeries.addChangeListener(this);
        final Iterator<Task> iterator = taskSeries.getTasks().iterator();
        while (iterator.hasNext()) {
            final String description = iterator.next().getDescription();
            if (this.keys.indexOf(description) < 0) {
                this.keys.add(description);
            }
        }
        this.fireDatasetChanged();
    }
    
    public void remove(final TaskSeries taskSeries) {
        if (taskSeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        if (this.data.contains(taskSeries)) {
            taskSeries.removeChangeListener(this);
            this.data.remove(taskSeries);
            this.fireDatasetChanged();
        }
    }
    
    public void remove(final int n) {
        if (n < 0 || n >= this.getSeriesCount()) {
            throw new IllegalArgumentException("TaskSeriesCollection.remove(): index outside valid range.");
        }
        this.data.get(n).removeChangeListener(this);
        this.data.remove(n);
        this.fireDatasetChanged();
    }
    
    public void removeAll() {
        final Iterator<TaskSeries> iterator = this.data.iterator();
        while (iterator.hasNext()) {
            iterator.next().removeChangeListener(this);
        }
        this.data.clear();
        this.fireDatasetChanged();
    }
    
    public Number getValue(final Comparable comparable, final Comparable comparable2) {
        return this.getStartValue(comparable, comparable2);
    }
    
    public Number getValue(final int n, final int n2) {
        return this.getStartValue(n, n2);
    }
    
    public Number getStartValue(final Comparable comparable, final Comparable comparable2) {
        Number n = null;
        final Task value = this.data.get(this.getRowIndex(comparable)).get(comparable2.toString());
        if (value != null) {
            final TimePeriod duration = value.getDuration();
            if (duration != null) {
                n = new Long(duration.getStart().getTime());
            }
        }
        return n;
    }
    
    public Number getStartValue(final int n, final int n2) {
        return this.getStartValue(this.getRowKey(n), this.getColumnKey(n2));
    }
    
    public Number getEndValue(final Comparable comparable, final Comparable comparable2) {
        Number n = null;
        final Task value = this.data.get(this.getRowIndex(comparable)).get(comparable2.toString());
        if (value != null) {
            final TimePeriod duration = value.getDuration();
            if (duration != null) {
                n = new Long(duration.getEnd().getTime());
            }
        }
        return n;
    }
    
    public Number getEndValue(final int n, final int n2) {
        return this.getEndValue(this.getRowKey(n), this.getColumnKey(n2));
    }
    
    public Number getPercentComplete(final int n, final int n2) {
        return this.getPercentComplete(this.getRowKey(n), this.getColumnKey(n2));
    }
    
    public Number getPercentComplete(final Comparable comparable, final Comparable comparable2) {
        Number percentComplete = null;
        final Task value = this.data.get(this.getRowIndex(comparable)).get(comparable2.toString());
        if (value != null) {
            percentComplete = value.getPercentComplete();
        }
        return percentComplete;
    }
    
    public int getSubIntervalCount(final int n, final int n2) {
        return this.getSubIntervalCount(this.getRowKey(n), this.getColumnKey(n2));
    }
    
    public int getSubIntervalCount(final Comparable comparable, final Comparable comparable2) {
        int subtaskCount = 0;
        final Task value = this.data.get(this.getRowIndex(comparable)).get(comparable2.toString());
        if (value != null) {
            subtaskCount = value.getSubtaskCount();
        }
        return subtaskCount;
    }
    
    public Number getStartValue(final int n, final int n2, final int n3) {
        return this.getStartValue(this.getRowKey(n), this.getColumnKey(n2), n3);
    }
    
    public Number getStartValue(final Comparable comparable, final Comparable comparable2, final int n) {
        Number n2 = null;
        final Task value = this.data.get(this.getRowIndex(comparable)).get(comparable2.toString());
        if (value != null) {
            final Task subtask = value.getSubtask(n);
            if (subtask != null) {
                n2 = new Long(subtask.getDuration().getStart().getTime());
            }
        }
        return n2;
    }
    
    public Number getEndValue(final int n, final int n2, final int n3) {
        return this.getEndValue(this.getRowKey(n), this.getColumnKey(n2), n3);
    }
    
    public Number getEndValue(final Comparable comparable, final Comparable comparable2, final int n) {
        Number n2 = null;
        final Task value = this.data.get(this.getRowIndex(comparable)).get(comparable2.toString());
        if (value != null) {
            final Task subtask = value.getSubtask(n);
            if (subtask != null) {
                n2 = new Long(subtask.getDuration().getEnd().getTime());
            }
        }
        return n2;
    }
    
    public Number getPercentComplete(final int n, final int n2, final int n3) {
        return this.getPercentComplete(this.getRowKey(n), this.getColumnKey(n2), n3);
    }
    
    public Number getPercentComplete(final Comparable comparable, final Comparable comparable2, final int n) {
        Number percentComplete = null;
        final Task value = this.data.get(this.getRowIndex(comparable)).get(comparable2.toString());
        if (value != null) {
            final Task subtask = value.getSubtask(n);
            if (subtask != null) {
                percentComplete = subtask.getPercentComplete();
            }
        }
        return percentComplete;
    }
    
    public void seriesChanged(final SeriesChangeEvent seriesChangeEvent) {
        this.refreshKeys();
        this.fireDatasetChanged();
    }
    
    private void refreshKeys() {
        this.keys.clear();
        for (int i = 0; i < this.getSeriesCount(); ++i) {
            final Iterator iterator = this.data.get(i).getTasks().iterator();
            while (iterator.hasNext()) {
                final String description = iterator.next().getDescription();
                if (this.keys.indexOf(description) < 0) {
                    this.keys.add(description);
                }
            }
        }
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof TaskSeriesCollection && ObjectUtilities.equal(this.data, ((TaskSeriesCollection)o).data));
    }
}
