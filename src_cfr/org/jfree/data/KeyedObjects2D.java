/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jfree.data.KeyedObjects;

public class KeyedObjects2D
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -1015873563138522374L;
    private List rowKeys = new ArrayList();
    private List columnKeys = new ArrayList();
    private List rows = new ArrayList();

    public int getRowCount() {
        return this.rowKeys.size();
    }

    public int getColumnCount() {
        return this.columnKeys.size();
    }

    public Object getObject(int n2, int n3) {
        Object object = null;
        KeyedObjects keyedObjects = (KeyedObjects)this.rows.get(n2);
        if (keyedObjects == null) return object;
        Comparable comparable = (Comparable)this.columnKeys.get(n3);
        if (comparable == null) return object;
        return keyedObjects.getObject(comparable);
    }

    public Comparable getRowKey(int n2) {
        return (Comparable)this.rowKeys.get(n2);
    }

    public int getRowIndex(Comparable comparable) {
        return this.rowKeys.indexOf(comparable);
    }

    public List getRowKeys() {
        return Collections.unmodifiableList(this.rowKeys);
    }

    public Comparable getColumnKey(int n2) {
        return (Comparable)this.columnKeys.get(n2);
    }

    public int getColumnIndex(Comparable comparable) {
        return this.columnKeys.indexOf(comparable);
    }

    public List getColumnKeys() {
        return Collections.unmodifiableList(this.columnKeys);
    }

    public Object getObject(Comparable comparable, Comparable comparable2) {
        Object object = null;
        int n2 = this.rowKeys.indexOf(comparable);
        if (n2 < 0) return object;
        KeyedObjects keyedObjects = (KeyedObjects)this.rows.get(n2);
        return keyedObjects.getObject(comparable2);
    }

    public void addObject(Object object, Comparable comparable, Comparable comparable2) {
        this.setObject(object, comparable, comparable2);
    }

    public void setObject(Object object, Comparable comparable, Comparable comparable2) {
        KeyedObjects keyedObjects;
        int n2 = this.rowKeys.indexOf(comparable);
        if (n2 >= 0) {
            keyedObjects = (KeyedObjects)this.rows.get(n2);
        } else {
            this.rowKeys.add(comparable);
            keyedObjects = new KeyedObjects();
            this.rows.add(keyedObjects);
        }
        keyedObjects.setObject(comparable2, object);
        int n3 = this.columnKeys.indexOf(comparable2);
        if (n3 >= 0) return;
        this.columnKeys.add(comparable2);
    }

    public void removeObject(Comparable comparable, Comparable comparable2) {
        this.setObject(null, comparable, comparable2);
    }

    public void removeRow(int n2) {
        this.rowKeys.remove(n2);
        this.rows.remove(n2);
    }

    public void removeRow(Comparable comparable) {
        this.removeRow(this.getRowIndex(comparable));
    }

    public void removeColumn(int n2) {
        Comparable comparable = this.getColumnKey(n2);
        this.removeColumn(comparable);
    }

    public void removeColumn(Comparable comparable) {
        Iterator iterator = this.rows.iterator();
        do {
            if (!iterator.hasNext()) {
                this.columnKeys.remove(comparable);
                return;
            }
            KeyedObjects keyedObjects = (KeyedObjects)iterator.next();
            keyedObjects.removeValue(comparable);
        } while (true);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof KeyedObjects2D)) {
            return false;
        }
        KeyedObjects2D keyedObjects2D = (KeyedObjects2D)object;
        if (!this.getRowKeys().equals(keyedObjects2D.getRowKeys())) {
            return false;
        }
        if (!this.getColumnKeys().equals(keyedObjects2D.getColumnKeys())) {
            return false;
        }
        int n2 = this.getRowCount();
        if (n2 != keyedObjects2D.getRowCount()) {
            return false;
        }
        int n3 = this.getColumnCount();
        if (n3 != keyedObjects2D.getColumnCount()) {
            return false;
        }
        int n4 = 0;
        while (n4 < n2) {
            for (int i2 = 0; i2 < n3; ++i2) {
                Object object2 = this.getObject(n4, i2);
                Object object3 = keyedObjects2D.getObject(n4, i2);
                if (!(object2 == null ? object3 != null : !object2.equals(object3))) continue;
                return false;
            }
            ++n4;
        }
        return true;
    }

    public int hashCode() {
        int n2 = this.rowKeys.hashCode();
        n2 = 29 * n2 + this.columnKeys.hashCode();
        return 29 * n2 + this.rows.hashCode();
    }

    public Object clone() {
        return super.clone();
    }
}

