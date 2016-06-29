package org.jfree.data.general;

import javax.swing.event.*;
import java.util.*;
import java.io.*;

public abstract class AbstractDataset implements ObjectInputValidation, Serializable, Cloneable, Dataset
{
    private static final long serialVersionUID = 1918768939869230744L;
    private DatasetGroup group;
    private transient EventListenerList listenerList;
    static Class class$org$jfree$data$general$DatasetChangeListener;
    
    protected AbstractDataset() {
        this.group = new DatasetGroup();
        this.listenerList = new EventListenerList();
    }
    
    public DatasetGroup getGroup() {
        return this.group;
    }
    
    public void setGroup(final DatasetGroup group) {
        if (group == null) {
            throw new IllegalArgumentException("Null 'group' argument.");
        }
        this.group = group;
    }
    
    public void addChangeListener(final DatasetChangeListener datasetChangeListener) {
        this.listenerList.add((AbstractDataset.class$org$jfree$data$general$DatasetChangeListener == null) ? (AbstractDataset.class$org$jfree$data$general$DatasetChangeListener = class$("org.jfree.data.general.DatasetChangeListener")) : AbstractDataset.class$org$jfree$data$general$DatasetChangeListener, datasetChangeListener);
    }
    
    public void removeChangeListener(final DatasetChangeListener datasetChangeListener) {
        this.listenerList.remove((AbstractDataset.class$org$jfree$data$general$DatasetChangeListener == null) ? (AbstractDataset.class$org$jfree$data$general$DatasetChangeListener = class$("org.jfree.data.general.DatasetChangeListener")) : AbstractDataset.class$org$jfree$data$general$DatasetChangeListener, datasetChangeListener);
    }
    
    public boolean hasListener(final EventListener eventListener) {
        return Arrays.asList(this.listenerList.getListenerList()).contains(eventListener);
    }
    
    protected void fireDatasetChanged() {
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }
    
    protected void notifyListeners(final DatasetChangeEvent datasetChangeEvent) {
        final Object[] listenerList = this.listenerList.getListenerList();
        for (int i = listenerList.length - 2; i >= 0; i -= 2) {
            if (listenerList[i] == ((AbstractDataset.class$org$jfree$data$general$DatasetChangeListener == null) ? (AbstractDataset.class$org$jfree$data$general$DatasetChangeListener = class$("org.jfree.data.general.DatasetChangeListener")) : AbstractDataset.class$org$jfree$data$general$DatasetChangeListener)) {
                ((DatasetChangeListener)listenerList[i + 1]).datasetChanged(datasetChangeEvent);
            }
        }
    }
    
    public Object clone() {
        final AbstractDataset abstractDataset = (AbstractDataset)super.clone();
        abstractDataset.listenerList = new EventListenerList();
        return abstractDataset;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.listenerList = new EventListenerList();
        objectInputStream.registerValidation(this, 10);
    }
    
    public void validateObject() {
        this.fireDatasetChanged();
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
