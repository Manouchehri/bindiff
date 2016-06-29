package org.jfree.chart;

import java.awt.*;
import org.jfree.util.*;
import java.util.*;
import org.jfree.io.*;
import java.io.*;

public class StrokeMap implements Serializable, Cloneable
{
    private transient Map store;
    
    public StrokeMap() {
        this.store = new TreeMap();
    }
    
    public Stroke getStroke(final Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        return this.store.get(comparable);
    }
    
    public boolean containsKey(final Comparable comparable) {
        return this.store.containsKey(comparable);
    }
    
    public void put(final Comparable comparable, final Stroke stroke) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        this.store.put(comparable, stroke);
    }
    
    public void clear() {
        this.store.clear();
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof StrokeMap)) {
            return false;
        }
        final StrokeMap strokeMap = (StrokeMap)o;
        if (this.store.size() != strokeMap.store.size()) {
            return false;
        }
        for (final Comparable comparable : this.store.keySet()) {
            if (!ObjectUtilities.equal(this.getStroke(comparable), strokeMap.getStroke(comparable))) {
                return false;
            }
        }
        return true;
    }
    
    public Object clone() {
        return super.clone();
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.store.size());
        for (final Comparable comparable : this.store.keySet()) {
            objectOutputStream.writeObject(comparable);
            SerialUtilities.writeStroke(this.getStroke(comparable), objectOutputStream);
        }
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.store = new TreeMap();
        for (int int1 = objectInputStream.readInt(), i = 0; i < int1; ++i) {
            this.store.put(objectInputStream.readObject(), SerialUtilities.readStroke(objectInputStream));
        }
    }
}
