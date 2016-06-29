package org.jfree.data;

import java.io.*;
import java.util.*;

public class KeyedObjects2D implements Serializable, Cloneable
{
    private static final long serialVersionUID = -1015873563138522374L;
    private List rowKeys;
    private List columnKeys;
    private List rows;
    
    public KeyedObjects2D() {
        this.rowKeys = new ArrayList();
        this.columnKeys = new ArrayList();
        this.rows = new ArrayList();
    }
    
    public int getRowCount() {
        return this.rowKeys.size();
    }
    
    public int getColumnCount() {
        return this.columnKeys.size();
    }
    
    public Object getObject(final int n, final int n2) {
        Object object = null;
        final KeyedObjects keyedObjects = this.rows.get(n);
        if (keyedObjects != null) {
            final Comparable comparable = this.columnKeys.get(n2);
            if (comparable != null) {
                object = keyedObjects.getObject(comparable);
            }
        }
        return object;
    }
    
    public Comparable getRowKey(final int n) {
        return this.rowKeys.get(n);
    }
    
    public int getRowIndex(final Comparable comparable) {
        return this.rowKeys.indexOf(comparable);
    }
    
    public List getRowKeys() {
        return Collections.unmodifiableList((List<?>)this.rowKeys);
    }
    
    public Comparable getColumnKey(final int n) {
        return this.columnKeys.get(n);
    }
    
    public int getColumnIndex(final Comparable comparable) {
        return this.columnKeys.indexOf(comparable);
    }
    
    public List getColumnKeys() {
        return Collections.unmodifiableList((List<?>)this.columnKeys);
    }
    
    public Object getObject(final Comparable comparable, final Comparable comparable2) {
        Object object = null;
        final int index = this.rowKeys.indexOf(comparable);
        if (index >= 0) {
            object = ((KeyedObjects)this.rows.get(index)).getObject(comparable2);
        }
        return object;
    }
    
    public void addObject(final Object o, final Comparable comparable, final Comparable comparable2) {
        this.setObject(o, comparable, comparable2);
    }
    
    public void setObject(final Object o, final Comparable comparable, final Comparable comparable2) {
        final int index = this.rowKeys.indexOf(comparable);
        KeyedObjects keyedObjects;
        if (index >= 0) {
            keyedObjects = this.rows.get(index);
        }
        else {
            this.rowKeys.add(comparable);
            keyedObjects = new KeyedObjects();
            this.rows.add(keyedObjects);
        }
        keyedObjects.setObject(comparable2, o);
        if (this.columnKeys.indexOf(comparable2) < 0) {
            this.columnKeys.add(comparable2);
        }
    }
    
    public void removeObject(final Comparable comparable, final Comparable comparable2) {
        this.setObject(null, comparable, comparable2);
    }
    
    public void removeRow(final int n) {
        this.rowKeys.remove(n);
        this.rows.remove(n);
    }
    
    public void removeRow(final Comparable comparable) {
        this.removeRow(this.getRowIndex(comparable));
    }
    
    public void removeColumn(final int n) {
        this.removeColumn(this.getColumnKey(n));
    }
    
    public void removeColumn(final Comparable comparable) {
        final Iterator<KeyedObjects> iterator = this.rows.iterator();
        while (iterator.hasNext()) {
            iterator.next().removeValue(comparable);
        }
        this.columnKeys.remove(comparable);
    }
    
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof KeyedObjects2D)) {
            return false;
        }
        final KeyedObjects2D keyedObjects2D = (KeyedObjects2D)o;
        if (!this.getRowKeys().equals(keyedObjects2D.getRowKeys())) {
            return false;
        }
        if (!this.getColumnKeys().equals(keyedObjects2D.getColumnKeys())) {
            return false;
        }
        final int rowCount = this.getRowCount();
        if (rowCount != keyedObjects2D.getRowCount()) {
            return false;
        }
        final int columnCount = this.getColumnCount();
        if (columnCount != keyedObjects2D.getColumnCount()) {
            return false;
        }
        for (int i = 0; i < rowCount; ++i) {
            for (int j = 0; j < columnCount; ++j) {
                final Object object = this.getObject(i, j);
                final Object object2 = keyedObjects2D.getObject(i, j);
                if (object == null) {
                    if (object2 != null) {
                        return false;
                    }
                }
                else if (!object.equals(object2)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int hashCode() {
        return 29 * (29 * this.rowKeys.hashCode() + this.columnKeys.hashCode()) + this.rows.hashCode();
    }
    
    public Object clone() {
        return super.clone();
    }
}
