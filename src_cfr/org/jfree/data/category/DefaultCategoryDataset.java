/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.category;

import java.io.Serializable;
import java.util.List;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.AbstractDataset;

public class DefaultCategoryDataset
extends AbstractDataset
implements Serializable,
CategoryDataset {
    private static final long serialVersionUID = -8168173757291644622L;
    private DefaultKeyedValues2D data = new DefaultKeyedValues2D();

    @Override
    public int getRowCount() {
        return this.data.getRowCount();
    }

    @Override
    public int getColumnCount() {
        return this.data.getColumnCount();
    }

    @Override
    public Number getValue(int n2, int n3) {
        return this.data.getValue(n2, n3);
    }

    @Override
    public Comparable getRowKey(int n2) {
        return this.data.getRowKey(n2);
    }

    @Override
    public int getRowIndex(Comparable comparable) {
        return this.data.getRowIndex(comparable);
    }

    @Override
    public List getRowKeys() {
        return this.data.getRowKeys();
    }

    @Override
    public Comparable getColumnKey(int n2) {
        return this.data.getColumnKey(n2);
    }

    @Override
    public int getColumnIndex(Comparable comparable) {
        return this.data.getColumnIndex(comparable);
    }

    @Override
    public List getColumnKeys() {
        return this.data.getColumnKeys();
    }

    @Override
    public Number getValue(Comparable comparable, Comparable comparable2) {
        return this.data.getValue(comparable, comparable2);
    }

    public void addValue(Number number, Comparable comparable, Comparable comparable2) {
        this.data.addValue(number, comparable, comparable2);
        this.fireDatasetChanged();
    }

    public void addValue(double d2, Comparable comparable, Comparable comparable2) {
        this.addValue(new Double(d2), comparable, comparable2);
    }

    public void setValue(Number number, Comparable comparable, Comparable comparable2) {
        this.data.setValue(number, comparable, comparable2);
        this.fireDatasetChanged();
    }

    public void setValue(double d2, Comparable comparable, Comparable comparable2) {
        this.setValue(new Double(d2), comparable, comparable2);
    }

    public void incrementValue(double d2, Comparable comparable, Comparable comparable2) {
        double d3 = 0.0;
        Number number = this.getValue(comparable, comparable2);
        if (number != null) {
            d3 = number.doubleValue();
        }
        this.setValue(d3 + d2, comparable, comparable2);
    }

    public void removeValue(Comparable comparable, Comparable comparable2) {
        this.data.removeValue(comparable, comparable2);
        this.fireDatasetChanged();
    }

    public void removeRow(int n2) {
        this.data.removeRow(n2);
        this.fireDatasetChanged();
    }

    public void removeRow(Comparable comparable) {
        this.data.removeRow(comparable);
        this.fireDatasetChanged();
    }

    public void removeColumn(int n2) {
        this.data.removeColumn(n2);
        this.fireDatasetChanged();
    }

    public void removeColumn(Comparable comparable) {
        this.data.removeColumn(comparable);
        this.fireDatasetChanged();
    }

    public void clear() {
        this.data.clear();
        this.fireDatasetChanged();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CategoryDataset)) {
            return false;
        }
        CategoryDataset categoryDataset = (CategoryDataset)object;
        if (!this.getRowKeys().equals(categoryDataset.getRowKeys())) {
            return false;
        }
        if (!this.getColumnKeys().equals(categoryDataset.getColumnKeys())) {
            return false;
        }
        int n2 = this.getRowCount();
        int n3 = this.getColumnCount();
        int n4 = 0;
        while (n4 < n2) {
            for (int i2 = 0; i2 < n3; ++i2) {
                Number number = this.getValue(n4, i2);
                Number number2 = categoryDataset.getValue(n4, i2);
                if (!(number == null ? number2 != null : !number.equals(number2))) continue;
                return false;
            }
            ++n4;
        }
        return true;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    @Override
    public Object clone() {
        DefaultCategoryDataset defaultCategoryDataset = (DefaultCategoryDataset)super.clone();
        defaultCategoryDataset.data = (DefaultKeyedValues2D)this.data.clone();
        return defaultCategoryDataset;
    }
}

