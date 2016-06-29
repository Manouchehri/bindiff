package org.jfree.data.general;

import java.io.*;
import javax.swing.event.*;
import org.jfree.util.*;
import java.beans.*;

public abstract class Series implements Serializable, Cloneable
{
    private static final long serialVersionUID = -6906561437538683581L;
    private Comparable key;
    private String description;
    private EventListenerList listeners;
    private PropertyChangeSupport propertyChangeSupport;
    private boolean notify;
    static Class class$org$jfree$data$general$SeriesChangeListener;
    
    protected Series(final Comparable comparable) {
        this(comparable, null);
    }
    
    protected Series(final Comparable key, final String description) {
        if (key == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        this.key = key;
        this.description = description;
        this.listeners = new EventListenerList();
        this.propertyChangeSupport = new PropertyChangeSupport(this);
        this.notify = true;
    }
    
    public Comparable getKey() {
        return this.key;
    }
    
    public void setKey(final Comparable key) {
        if (key == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        final Comparable key2 = this.key;
        this.key = key;
        this.propertyChangeSupport.firePropertyChange("Key", key2, key);
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(final String description) {
        final String description2 = this.description;
        this.description = description;
        this.propertyChangeSupport.firePropertyChange("Description", description2, description);
    }
    
    public boolean getNotify() {
        return this.notify;
    }
    
    public void setNotify(final boolean notify) {
        if (this.notify != notify) {
            this.notify = notify;
            this.fireSeriesChanged();
        }
    }
    
    public Object clone() {
        final Series series = (Series)super.clone();
        series.listeners = new EventListenerList();
        series.propertyChangeSupport = new PropertyChangeSupport(series);
        return series;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Series)) {
            return false;
        }
        final Series series = (Series)o;
        return this.getKey().equals(series.getKey()) && ObjectUtilities.equal(this.getDescription(), series.getDescription());
    }
    
    public int hashCode() {
        return 29 * this.key.hashCode() + ((this.description != null) ? this.description.hashCode() : 0);
    }
    
    public void addChangeListener(final SeriesChangeListener seriesChangeListener) {
        this.listeners.add((Series.class$org$jfree$data$general$SeriesChangeListener == null) ? (Series.class$org$jfree$data$general$SeriesChangeListener = class$("org.jfree.data.general.SeriesChangeListener")) : Series.class$org$jfree$data$general$SeriesChangeListener, seriesChangeListener);
    }
    
    public void removeChangeListener(final SeriesChangeListener seriesChangeListener) {
        this.listeners.remove((Series.class$org$jfree$data$general$SeriesChangeListener == null) ? (Series.class$org$jfree$data$general$SeriesChangeListener = class$("org.jfree.data.general.SeriesChangeListener")) : Series.class$org$jfree$data$general$SeriesChangeListener, seriesChangeListener);
    }
    
    public void fireSeriesChanged() {
        if (this.notify) {
            this.notifyListeners(new SeriesChangeEvent(this));
        }
    }
    
    protected void notifyListeners(final SeriesChangeEvent seriesChangeEvent) {
        final Object[] listenerList = this.listeners.getListenerList();
        for (int i = listenerList.length - 2; i >= 0; i -= 2) {
            if (listenerList[i] == ((Series.class$org$jfree$data$general$SeriesChangeListener == null) ? (Series.class$org$jfree$data$general$SeriesChangeListener = class$("org.jfree.data.general.SeriesChangeListener")) : Series.class$org$jfree$data$general$SeriesChangeListener)) {
                ((SeriesChangeListener)listenerList[i + 1]).seriesChanged(seriesChangeEvent);
            }
        }
    }
    
    public void addPropertyChangeListener(final PropertyChangeListener propertyChangeListener) {
        this.propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }
    
    public void removePropertyChangeListener(final PropertyChangeListener propertyChangeListener) {
        this.propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
    }
    
    protected void firePropertyChange(final String s, final Object o, final Object o2) {
        this.propertyChangeSupport.firePropertyChange(s, o, o2);
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
}
