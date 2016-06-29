package org.jfree.data.category;

import org.jfree.data.general.*;
import java.io.*;
import org.jfree.data.*;
import java.util.*;

public class DefaultCategoryDataset extends AbstractDataset implements Serializable, CategoryDataset
{
    private static final long serialVersionUID = -8168173757291644622L;
    private DefaultKeyedValues2D data;
    
    public DefaultCategoryDataset() {
        this.data = new DefaultKeyedValues2D();
    }
    
    public int getRowCount() {
        return this.data.getRowCount();
    }
    
    public int getColumnCount() {
        return this.data.getColumnCount();
    }
    
    public Number getValue(final int n, final int n2) {
        return this.data.getValue(n, n2);
    }
    
    public Comparable getRowKey(final int n) {
        return this.data.getRowKey(n);
    }
    
    public int getRowIndex(final Comparable comparable) {
        return this.data.getRowIndex(comparable);
    }
    
    public List getRowKeys() {
        return this.data.getRowKeys();
    }
    
    public Comparable getColumnKey(final int n) {
        return this.data.getColumnKey(n);
    }
    
    public int getColumnIndex(final Comparable comparable) {
        return this.data.getColumnIndex(comparable);
    }
    
    public List getColumnKeys() {
        return this.data.getColumnKeys();
    }
    
    public Number getValue(final Comparable comparable, final Comparable comparable2) {
        return this.data.getValue(comparable, comparable2);
    }
    
    public void addValue(final Number n, final Comparable comparable, final Comparable comparable2) {
        this.data.addValue(n, comparable, comparable2);
        this.fireDatasetChanged();
    }
    
    public void addValue(final double n, final Comparable comparable, final Comparable comparable2) {
        this.addValue(new Double(n), comparable, comparable2);
    }
    
    public void setValue(final Number n, final Comparable comparable, final Comparable comparable2) {
        this.data.setValue(n, comparable, comparable2);
        this.fireDatasetChanged();
    }
    
    public void setValue(final double n, final Comparable comparable, final Comparable comparable2) {
        this.setValue(new Double(n), comparable, comparable2);
    }
    
    public void incrementValue(final double n, final Comparable comparable, final Comparable comparable2) {
        double doubleValue = 0.0;
        final Number value = this.getValue(comparable, comparable2);
        if (value != null) {
            doubleValue = value.doubleValue();
        }
        this.setValue(doubleValue + n, comparable, comparable2);
    }
    
    public void removeValue(final Comparable comparable, final Comparable comparable2) {
        this.data.removeValue(comparable, comparable2);
        this.fireDatasetChanged();
    }
    
    public void removeRow(final int n) {
        this.data.removeRow(n);
        this.fireDatasetChanged();
    }
    
    public void removeRow(final Comparable comparable) {
        this.data.removeRow(comparable);
        this.fireDatasetChanged();
    }
    
    public void removeColumn(final int n) {
        this.data.removeColumn(n);
        this.fireDatasetChanged();
    }
    
    public void removeColumn(final Comparable comparable) {
        this.data.removeColumn(comparable);
        this.fireDatasetChanged();
    }
    
    public void clear() {
        this.data.clear();
        this.fireDatasetChanged();
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CategoryDataset)) {
            return false;
        }
        final CategoryDataset categoryDataset = (CategoryDataset)o;
        if (!this.getRowKeys().equals(categoryDataset.getRowKeys())) {
            return false;
        }
        if (!this.getColumnKeys().equals(categoryDataset.getColumnKeys())) {
            return false;
        }
        final int rowCount = this.getRowCount();
        final int columnCount = this.getColumnCount();
        for (int i = 0; i < rowCount; ++i) {
            for (int j = 0; j < columnCount; ++j) {
                final Number value = this.getValue(i, j);
                final Number value2 = categoryDataset.getValue(i, j);
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
        return this.data.hashCode();
    }
    
    public Object clone() {
        final DefaultCategoryDataset defaultCategoryDataset = (DefaultCategoryDataset)super.clone();
        defaultCategoryDataset.data = (DefaultKeyedValues2D)this.data.clone();
        return defaultCategoryDataset;
    }
}
