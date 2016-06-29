/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues2D;
import org.jfree.data.UnknownKeyException;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class DefaultKeyedValues2D
implements Serializable,
Cloneable,
KeyedValues2D,
PublicCloneable {
    private static final long serialVersionUID = -5514169970951994748L;
    private List rowKeys = new ArrayList();
    private List columnKeys = new ArrayList();
    private List rows = new ArrayList();
    private boolean sortRowKeys;

    public DefaultKeyedValues2D() {
        this(false);
    }

    public DefaultKeyedValues2D(boolean bl2) {
        this.sortRowKeys = bl2;
    }

    @Override
    public int getRowCount() {
        return this.rowKeys.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnKeys.size();
    }

    @Override
    public Number getValue(int n2, int n3) {
        Number number = null;
        DefaultKeyedValues defaultKeyedValues = (DefaultKeyedValues)this.rows.get(n2);
        if (defaultKeyedValues == null) return number;
        Comparable comparable = (Comparable)this.columnKeys.get(n3);
        int n4 = defaultKeyedValues.getIndex(comparable);
        if (n4 < 0) return number;
        return defaultKeyedValues.getValue(n4);
    }

    @Override
    public Comparable getRowKey(int n2) {
        return (Comparable)this.rowKeys.get(n2);
    }

    @Override
    public int getRowIndex(Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'key' argument.");
        }
        if (!this.sortRowKeys) return this.rowKeys.indexOf(comparable);
        return Collections.binarySearch(this.rowKeys, comparable);
    }

    @Override
    public List getRowKeys() {
        return Collections.unmodifiableList(this.rowKeys);
    }

    @Override
    public Comparable getColumnKey(int n2) {
        return (Comparable)this.columnKeys.get(n2);
    }

    @Override
    public int getColumnIndex(Comparable comparable) {
        if (comparable != null) return this.columnKeys.indexOf(comparable);
        throw new IllegalArgumentException("Null 'key' argument.");
    }

    @Override
    public List getColumnKeys() {
        return Collections.unmodifiableList(this.columnKeys);
    }

    @Override
    public Number getValue(Comparable comparable, Comparable comparable2) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'rowKey' argument.");
        }
        if (comparable2 == null) {
            throw new IllegalArgumentException("Null 'columnKey' argument.");
        }
        if (!this.columnKeys.contains(comparable2)) {
            throw new UnknownKeyException(new StringBuffer().append("Unrecognised columnKey: ").append(comparable2).toString());
        }
        int n2 = this.getRowIndex(comparable);
        if (n2 < 0) throw new UnknownKeyException(new StringBuffer().append("Unrecognised rowKey: ").append(comparable).toString());
        DefaultKeyedValues defaultKeyedValues = (DefaultKeyedValues)this.rows.get(n2);
        int n3 = defaultKeyedValues.getIndex(comparable2);
        if (n3 < 0) return null;
        Number number = defaultKeyedValues.getValue(n3);
        return number;
    }

    public void addValue(Number number, Comparable comparable, Comparable comparable2) {
        this.setValue(number, comparable, comparable2);
    }

    public void setValue(Number number, Comparable comparable, Comparable comparable2) {
        DefaultKeyedValues defaultKeyedValues;
        int n2 = this.getRowIndex(comparable);
        if (n2 >= 0) {
            defaultKeyedValues = (DefaultKeyedValues)this.rows.get(n2);
        } else {
            defaultKeyedValues = new DefaultKeyedValues();
            if (this.sortRowKeys) {
                n2 = - n2 - 1;
                this.rowKeys.add(n2, comparable);
                this.rows.add(n2, defaultKeyedValues);
            } else {
                this.rowKeys.add(comparable);
                this.rows.add(defaultKeyedValues);
            }
        }
        defaultKeyedValues.setValue(comparable2, number);
        int n3 = this.columnKeys.indexOf(comparable2);
        if (n3 >= 0) return;
        this.columnKeys.add(comparable2);
    }

    public void removeValue(Comparable comparable, Comparable comparable2) {
        int n2;
        this.setValue(null, comparable, comparable2);
        boolean bl2 = true;
        int n3 = this.getRowIndex(comparable);
        DefaultKeyedValues defaultKeyedValues = (DefaultKeyedValues)this.rows.get(n3);
        int n4 = defaultKeyedValues.getItemCount();
        for (n2 = 0; n2 < n4; ++n2) {
            if (defaultKeyedValues.getValue(n2) == null) continue;
            bl2 = false;
            break;
        }
        if (bl2) {
            this.rowKeys.remove(n3);
            this.rows.remove(n3);
        }
        bl2 = true;
        n2 = this.getColumnIndex(comparable2);
        int n5 = this.rows.size();
        for (n4 = 0; n4 < n5; ++n4) {
            defaultKeyedValues = (DefaultKeyedValues)this.rows.get(n4);
            if (defaultKeyedValues.getValue(n2) == null) continue;
            return;
        }
        if (!bl2) return;
        n4 = 0;
        n5 = this.rows.size();
        do {
            if (n4 >= n5) {
                this.columnKeys.remove(n2);
                return;
            }
            defaultKeyedValues = (DefaultKeyedValues)this.rows.get(n4);
            defaultKeyedValues.removeValue(n2);
            ++n4;
        } while (true);
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
            DefaultKeyedValues defaultKeyedValues = (DefaultKeyedValues)iterator.next();
            defaultKeyedValues.removeValue(comparable);
        } while (true);
    }

    public void clear() {
        this.rowKeys.clear();
        this.columnKeys.clear();
        this.rows.clear();
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof KeyedValues2D)) {
            return false;
        }
        KeyedValues2D keyedValues2D = (KeyedValues2D)object;
        if (!this.getRowKeys().equals(keyedValues2D.getRowKeys())) {
            return false;
        }
        if (!this.getColumnKeys().equals(keyedValues2D.getColumnKeys())) {
            return false;
        }
        int n2 = this.getRowCount();
        if (n2 != keyedValues2D.getRowCount()) {
            return false;
        }
        int n3 = this.getColumnCount();
        if (n3 != keyedValues2D.getColumnCount()) {
            return false;
        }
        int n4 = 0;
        while (n4 < n2) {
            for (int i2 = 0; i2 < n3; ++i2) {
                Number number = this.getValue(n4, i2);
                Number number2 = keyedValues2D.getValue(n4, i2);
                if (!(number == null ? number2 != null : !number.equals(number2))) continue;
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

    @Override
    public Object clone() {
        DefaultKeyedValues2D defaultKeyedValues2D = (DefaultKeyedValues2D)super.clone();
        defaultKeyedValues2D.columnKeys = new ArrayList(this.columnKeys);
        defaultKeyedValues2D.rowKeys = new ArrayList(this.rowKeys);
        defaultKeyedValues2D.rows = (List)ObjectUtilities.deepClone(this.rows);
        return defaultKeyedValues2D;
    }
}

