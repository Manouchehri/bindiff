/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.general;

import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.EventListener;
import java.util.List;
import javax.swing.event.EventListenerList;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;

public abstract class AbstractDataset
implements ObjectInputValidation,
Serializable,
Cloneable,
Dataset {
    private static final long serialVersionUID = 1918768939869230744L;
    private DatasetGroup group = new DatasetGroup();
    private transient EventListenerList listenerList = new EventListenerList();
    static Class class$org$jfree$data$general$DatasetChangeListener;

    protected AbstractDataset() {
    }

    @Override
    public DatasetGroup getGroup() {
        return this.group;
    }

    @Override
    public void setGroup(DatasetGroup datasetGroup) {
        if (datasetGroup == null) {
            throw new IllegalArgumentException("Null 'group' argument.");
        }
        this.group = datasetGroup;
    }

    @Override
    public void addChangeListener(DatasetChangeListener datasetChangeListener) {
        Class class_ = class$org$jfree$data$general$DatasetChangeListener == null ? (AbstractDataset.class$org$jfree$data$general$DatasetChangeListener = AbstractDataset.class$("org.jfree.data.general.DatasetChangeListener")) : class$org$jfree$data$general$DatasetChangeListener;
        this.listenerList.add(class_, datasetChangeListener);
    }

    @Override
    public void removeChangeListener(DatasetChangeListener datasetChangeListener) {
        Class class_ = class$org$jfree$data$general$DatasetChangeListener == null ? (AbstractDataset.class$org$jfree$data$general$DatasetChangeListener = AbstractDataset.class$("org.jfree.data.general.DatasetChangeListener")) : class$org$jfree$data$general$DatasetChangeListener;
        this.listenerList.remove(class_, datasetChangeListener);
    }

    public boolean hasListener(EventListener eventListener) {
        List<Object> list = Arrays.asList(this.listenerList.getListenerList());
        return list.contains(eventListener);
    }

    protected void fireDatasetChanged() {
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }

    protected void notifyListeners(DatasetChangeEvent datasetChangeEvent) {
        Object[] arrobject = this.listenerList.getListenerList();
        int n2 = arrobject.length - 2;
        while (n2 >= 0) {
            if (arrobject[n2] == (class$org$jfree$data$general$DatasetChangeListener == null ? AbstractDataset.class$("org.jfree.data.general.DatasetChangeListener") : class$org$jfree$data$general$DatasetChangeListener)) {
                ((DatasetChangeListener)arrobject[n2 + 1]).datasetChanged(datasetChangeEvent);
            }
            n2 -= 2;
        }
    }

    public Object clone() {
        AbstractDataset abstractDataset = (AbstractDataset)super.clone();
        abstractDataset.listenerList = new EventListenerList();
        return abstractDataset;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.listenerList = new EventListenerList();
        objectInputStream.registerValidation(this, 10);
    }

    @Override
    public void validateObject() {
        this.fireDatasetChanged();
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

