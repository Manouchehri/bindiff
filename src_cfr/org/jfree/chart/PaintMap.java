/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart;

import java.awt.Paint;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.jfree.io.SerialUtilities;
import org.jfree.util.PaintUtilities;

public class PaintMap
implements Serializable,
Cloneable {
    private transient Map store = new HashMap();

    public Paint getPaint(Comparable comparable) {
        if (comparable != null) return (Paint)this.store.get(comparable);
        throw new IllegalArgumentException("Null 'key' argument.");
    }

    public boolean containsKey(Comparable comparable) {
        return this.store.containsKey(comparable);
    }

    public void put(Comparable comparable, Paint paint) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        this.store.put(comparable, paint);
    }

    public void clear() {
        this.store.clear();
    }

    public boolean equals(Object object) {
        Paint paint;
        Comparable comparable;
        Paint paint2;
        if (object == this) {
            return true;
        }
        if (!(object instanceof PaintMap)) {
            return false;
        }
        PaintMap paintMap = (PaintMap)object;
        if (this.store.size() != paintMap.store.size()) {
            return false;
        }
        Set set = this.store.keySet();
        Iterator iterator = set.iterator();
        do {
            if (!iterator.hasNext()) return true;
        } while (PaintUtilities.equal(paint2 = this.getPaint(comparable = (Comparable)iterator.next()), paint = paintMap.getPaint(comparable)));
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
            Paint paint = this.getPaint(comparable);
            SerialUtilities.writePaint(paint, objectOutputStream);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.store = new HashMap();
        int n2 = objectInputStream.readInt();
        int n3 = 0;
        while (n3 < n2) {
            Comparable comparable = (Comparable)objectInputStream.readObject();
            Paint paint = SerialUtilities.readPaint(objectInputStream);
            this.store.put(comparable, paint);
            ++n3;
        }
    }
}

