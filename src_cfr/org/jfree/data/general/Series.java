/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.general;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.EventListener;
import javax.swing.event.EventListenerList;
import org.jfree.data.general.SeriesChangeEvent;
import org.jfree.data.general.SeriesChangeListener;
import org.jfree.util.ObjectUtilities;

public abstract class Series
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -6906561437538683581L;
    private Comparable key;
    private String description;
    private EventListenerList listeners;
    private PropertyChangeSupport propertyChangeSupport;
    private boolean notify;
    static Class class$org$jfree$data$general$SeriesChangeListener;

    protected Series(Comparable comparable) {
        this(comparable, null);
    }

    protected Series(Comparable comparable, String string) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        this.key = comparable;
        this.description = string;
        this.listeners = new EventListenerList();
        this.propertyChangeSupport = new PropertyChangeSupport(this);
        this.notify = true;
    }

    public Comparable getKey() {
        return this.key;
    }

    public void setKey(Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        Comparable comparable2 = this.key;
        this.key = comparable;
        this.propertyChangeSupport.firePropertyChange("Key", comparable2, comparable);
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String string) {
        String string2 = this.description;
        this.description = string;
        this.propertyChangeSupport.firePropertyChange("Description", string2, string);
    }

    public boolean getNotify() {
        return this.notify;
    }

    public void setNotify(boolean bl2) {
        if (this.notify == bl2) return;
        this.notify = bl2;
        this.fireSeriesChanged();
    }

    public Object clone() {
        Series series = (Series)super.clone();
        series.listeners = new EventListenerList();
        series.propertyChangeSupport = new PropertyChangeSupport(series);
        return series;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Series)) {
            return false;
        }
        Series series = (Series)object;
        if (!this.getKey().equals(series.getKey())) {
            return false;
        }
        if (ObjectUtilities.equal(this.getDescription(), series.getDescription())) return true;
        return false;
    }

    public int hashCode() {
        int n2 = this.key.hashCode();
        return 29 * n2 + (this.description != null ? this.description.hashCode() : 0);
    }

    public void addChangeListener(SeriesChangeListener seriesChangeListener) {
        Class class_ = class$org$jfree$data$general$SeriesChangeListener == null ? (Series.class$org$jfree$data$general$SeriesChangeListener = Series.class$("org.jfree.data.general.SeriesChangeListener")) : class$org$jfree$data$general$SeriesChangeListener;
        this.listeners.add(class_, seriesChangeListener);
    }

    public void removeChangeListener(SeriesChangeListener seriesChangeListener) {
        Class class_ = class$org$jfree$data$general$SeriesChangeListener == null ? (Series.class$org$jfree$data$general$SeriesChangeListener = Series.class$("org.jfree.data.general.SeriesChangeListener")) : class$org$jfree$data$general$SeriesChangeListener;
        this.listeners.remove(class_, seriesChangeListener);
    }

    public void fireSeriesChanged() {
        if (!this.notify) return;
        this.notifyListeners(new SeriesChangeEvent(this));
    }

    protected void notifyListeners(SeriesChangeEvent seriesChangeEvent) {
        Object[] arrobject = this.listeners.getListenerList();
        int n2 = arrobject.length - 2;
        while (n2 >= 0) {
            if (arrobject[n2] == (class$org$jfree$data$general$SeriesChangeListener == null ? Series.class$("org.jfree.data.general.SeriesChangeListener") : class$org$jfree$data$general$SeriesChangeListener)) {
                ((SeriesChangeListener)arrobject[n2 + 1]).seriesChanged(seriesChangeEvent);
            }
            n2 -= 2;
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
    }

    protected void firePropertyChange(String string, Object object, Object object2) {
        this.propertyChangeSupport.firePropertyChange(string, object, object2);
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

