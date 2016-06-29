package org.jfree.data;

import java.io.*;
import java.util.*;
import org.jfree.util.*;

public class DefaultKeyedValues2D implements Serializable, Cloneable, KeyedValues2D, PublicCloneable
{
    private static final long serialVersionUID = -5514169970951994748L;
    private List rowKeys;
    private List columnKeys;
    private List rows;
    private boolean sortRowKeys;
    
    public DefaultKeyedValues2D() {
        this(false);
    }
    
    public DefaultKeyedValues2D(final boolean sortRowKeys) {
        this.rowKeys = new ArrayList();
        this.columnKeys = new ArrayList();
        this.rows = new ArrayList();
        this.sortRowKeys = sortRowKeys;
    }
    
    public int getRowCount() {
        return this.rowKeys.size();
    }
    
    public int getColumnCount() {
        return this.columnKeys.size();
    }
    
    public Number getValue(final int n, final int n2) {
        Number value = null;
        final DefaultKeyedValues defaultKeyedValues = this.rows.get(n);
        if (defaultKeyedValues != null) {
            final int index = defaultKeyedValues.getIndex(this.columnKeys.get(n2));
            if (index >= 0) {
                value = defaultKeyedValues.getValue(index);
            }
        }
        return value;
    }
    
    public Comparable getRowKey(final int n) {
        return this.rowKeys.get(n);
    }
    
    public int getRowIndex(final Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        if (this.sortRowKeys) {
            return Collections.binarySearch(this.rowKeys, comparable);
        }
        return this.rowKeys.indexOf(comparable);
    }
    
    public List getRowKeys() {
        return Collections.unmodifiableList((List<?>)this.rowKeys);
    }
    
    public Comparable getColumnKey(final int n) {
        return this.columnKeys.get(n);
    }
    
    public int getColumnIndex(final Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        return this.columnKeys.indexOf(comparable);
    }
    
    public List getColumnKeys() {
        return Collections.unmodifiableList((List<?>)this.columnKeys);
    }
    
    public Number getValue(final Comparable comparable, final Comparable comparable2) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'rowKey' argument.");
        }
        if (comparable2 == null) {
            throw new IllegalArgumentException("Null 'columnKey' argument.");
        }
        if (!this.columnKeys.contains(comparable2)) {
            throw new UnknownKeyException("Unrecognised columnKey: " + comparable2);
        }
        final int rowIndex = this.getRowIndex(comparable);
        if (rowIndex >= 0) {
            final DefaultKeyedValues defaultKeyedValues = this.rows.get(rowIndex);
            final int index = defaultKeyedValues.getIndex(comparable2);
            return (index >= 0) ? defaultKeyedValues.getValue(index) : null;
        }
        throw new UnknownKeyException("Unrecognised rowKey: " + comparable);
    }
    
    public void addValue(final Number n, final Comparable comparable, final Comparable comparable2) {
        this.setValue(n, comparable, comparable2);
    }
    
    public void setValue(final Number n, final Comparable comparable, final Comparable comparable2) {
        final int rowIndex = this.getRowIndex(comparable);
        DefaultKeyedValues defaultKeyedValues;
        if (rowIndex >= 0) {
            defaultKeyedValues = this.rows.get(rowIndex);
        }
        else {
            defaultKeyedValues = new DefaultKeyedValues();
            if (this.sortRowKeys) {
                final int n2 = -rowIndex - 1;
                this.rowKeys.add(n2, comparable);
                this.rows.add(n2, defaultKeyedValues);
            }
            else {
                this.rowKeys.add(comparable);
                this.rows.add(defaultKeyedValues);
            }
        }
        defaultKeyedValues.setValue(comparable2, n);
        if (this.columnKeys.indexOf(comparable2) < 0) {
            this.columnKeys.add(comparable2);
        }
    }
    
    public void removeValue(final Comparable comparable, final Comparable comparable2) {
        this.setValue(null, comparable, comparable2);
        boolean b = true;
        final int rowIndex = this.getRowIndex(comparable);
        final DefaultKeyedValues defaultKeyedValues = this.rows.get(rowIndex);
        for (int i = 0; i < defaultKeyedValues.getItemCount(); ++i) {
            if (defaultKeyedValues.getValue(i) != null) {
                b = false;
                break;
            }
        }
        if (b) {
            this.rowKeys.remove(rowIndex);
            this.rows.remove(rowIndex);
        }
        boolean b2 = true;
        final int columnIndex = this.getColumnIndex(comparable2);
        for (int j = 0; j < this.rows.size(); ++j) {
            if (((DefaultKeyedValues)this.rows.get(j)).getValue(columnIndex) != null) {
                b2 = false;
                break;
            }
        }
        if (b2) {
            for (int k = 0; k < this.rows.size(); ++k) {
                ((DefaultKeyedValues)this.rows.get(k)).removeValue(columnIndex);
            }
            this.columnKeys.remove(columnIndex);
        }
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
        final Iterator<DefaultKeyedValues> iterator = this.rows.iterator();
        while (iterator.hasNext()) {
            iterator.next().removeValue(comparable);
        }
        this.columnKeys.remove(comparable);
    }
    
    public void clear() {
        this.rowKeys.clear();
        this.columnKeys.clear();
        this.rows.clear();
    }
    
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof KeyedValues2D)) {
            return false;
        }
        final KeyedValues2D keyedValues2D = (KeyedValues2D)o;
        if (!this.getRowKeys().equals(keyedValues2D.getRowKeys())) {
            return false;
        }
        if (!this.getColumnKeys().equals(keyedValues2D.getColumnKeys())) {
            return false;
        }
        final int rowCount = this.getRowCount();
        if (rowCount != keyedValues2D.getRowCount()) {
            return false;
        }
        final int columnCount = this.getColumnCount();
        if (columnCount != keyedValues2D.getColumnCount()) {
            return false;
        }
        for (int i = 0; i < rowCount; ++i) {
            for (int j = 0; j < columnCount; ++j) {
                final Number value = this.getValue(i, j);
                final Number value2 = keyedValues2D.getValue(i, j);
                if (value == null) {
                    if (value2 != null) {
                        return false;
                    }
                }
                else if (!value.equals(value2)) {
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
        final DefaultKeyedValues2D defaultKeyedValues2D = (DefaultKeyedValues2D)super.clone();
        defaultKeyedValues2D.columnKeys = new ArrayList(this.columnKeys);
        defaultKeyedValues2D.rowKeys = new ArrayList(this.rowKeys);
        defaultKeyedValues2D.rows = (List)ObjectUtilities.deepClone(this.rows);
        return defaultKeyedValues2D;
    }
}
