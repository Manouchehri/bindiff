/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart;

import java.awt.Stroke;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.jfree.io.SerialUtilities;
import org.jfree.util.ObjectUtilities;

public class StrokeMap
implements Serializable,
Cloneable {
    private transient Map store = new TreeMap();

    public Stroke getStroke(Comparable comparable) {
        if (comparable != null) return (Stroke)this.store.get(comparable);
        throw new IllegalArgumentException("Null 'key' argument.");
    }

    public boolean containsKey(Comparable comparable) {
        return this.store.containsKey(comparable);
    }

    public void put(Comparable comparable, Stroke stroke) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        this.store.put(comparable, stroke);
    }

    public void clear() {
        this.store.clear();
    }

    public boolean equals(Object object) {
        Stroke stroke;
        Comparable comparable;
        Stroke stroke2;
        if (object == this) {
            return true;
        }
        if (!(object instanceof StrokeMap)) {
            return false;
        }
        StrokeMap strokeMap = (StrokeMap)object;
        if (this.store.size() != strokeMap.store.size()) {
            return false;
        }
        Set set = this.store.keySet();
        Iterator iterator = set.iterator();
        do {
            if (!iterator.hasNext()) return true;
        } while (ObjectUtilities.equal(stroke2 = this.getStroke(comparable = (Comparable)iterator.next()), stroke = strokeMap.getStroke(comparable)));
        return false;
    }

    public Object clone() {
        return super.clone();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.store.size());
        Set set = this.store.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Comparable comparable = (Comparable)iterator.next();
            objectOutputStream.writeObject(comparable);
            Stroke stroke = this.getStroke(comparable);
            SerialUtilities.writeStroke(stroke, objectOutputStream);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.store = new TreeMap();
        int n2 = objectInputStream.readInt();
        int n3 = 0;
        while (n3 < n2) {
            Comparable comparable = (Comparable)objectInputStream.readObject();
            Stroke stroke = SerialUtilities.readStroke(objectInputStream);
            this.store.put(comparable, stroke);
            ++n3;
        }
    }
}

