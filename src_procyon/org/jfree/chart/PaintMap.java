package org.jfree.chart;

import java.awt.*;
import org.jfree.util.*;
import java.util.*;
import org.jfree.io.*;
import java.io.*;

public class PaintMap implements Serializable, Cloneable
{
    private transient Map store;
    
    public PaintMap() {
        this.store = new HashMap();
    }
    
    public Paint getPaint(final Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        return this.store.get(comparable);
    }
    
    public boolean containsKey(final Comparable comparable) {
        return this.store.containsKey(comparable);
    }
    
    public void put(final Comparable comparable, final Paint paint) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        this.store.put(comparable, paint);
    }
    
    public void clear() {
        this.store.clear();
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PaintMap)) {
            return false;
        }
        final PaintMap paintMap = (PaintMap)o;
        if (this.store.size() != paintMap.store.size()) {
            return false;
        }
        for (final Comparable comparable : this.store.keySet()) {
            if (!PaintUtilities.equal(this.getPaint(comparable), paintMap.getPaint(comparable))) {
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
            SerialUtilities.writePaint(this.getPaint(comparable), objectOutputStream);
        }
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.store = new HashMap();
        for (int int1 = objectInputStream.readInt(), i = 0; i < int1; ++i) {
            this.store.put(objectInputStream.readObject(), SerialUtilities.readPaint(objectInputStream));
        }
    }
}
