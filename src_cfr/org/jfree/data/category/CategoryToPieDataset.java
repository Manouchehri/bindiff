/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.category;

import java.util.Collections;
import java.util.List;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.AbstractDataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.PieDataset;
import org.jfree.util.TableOrder;

public class CategoryToPieDataset
extends AbstractDataset
implements DatasetChangeListener,
PieDataset {
    static final long serialVersionUID = 5516396319762189617L;
    private CategoryDataset source;
    private TableOrder extract;
    private int index;

    public CategoryToPieDataset(CategoryDataset categoryDataset, TableOrder tableOrder, int n2) {
        if (tableOrder == null) {
            throw new IllegalArgumentException("Null 'extract' argument.");
        }
        this.source = categoryDataset;
        if (this.source != null) {
            this.source.addChangeListener(this);
        }
        this.extract = tableOrder;
        this.index = n2;
    }

    public CategoryDataset getUnderlyingDataset() {
        return this.source;
    }

    public TableOrder getExtractType() {
        return this.extract;
    }

    public int getExtractIndex() {
        return this.index;
    }

    @Override
    public int getItemCount() {
        int n2 = 0;
        if (this.source == null) return n2;
        if (this.extract == TableOrder.BY_ROW) {
            return this.source.getColumnCount();
        }
        if (this.extract != TableOrder.BY_COLUMN) return n2;
        return this.source.getRowCount();
    }

    @Override
    public Number getValue(int n2) {
        Number number = null;
        if (n2 < 0) throw new IndexOutOfBoundsException("The 'item' index is out of bounds.");
        if (n2 >= this.getItemCount()) {
            throw new IndexOutOfBoundsException("The 'item' index is out of bounds.");
        }
        if (this.extract == TableOrder.BY_ROW) {
            return this.source.getValue(this.index, n2);
        }
        if (this.extract != TableOrder.BY_COLUMN) return number;
        return this.source.getValue(n2, this.index);
    }

    @Override
    public Comparable getKey(int n2) {
        Comparable comparable = null;
        if (n2 < 0) throw new IndexOutOfBoundsException(new StringBuffer().append("Invalid 'index': ").append(n2).toString());
        if (n2 >= this.getItemCount()) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Invalid 'index': ").append(n2).toString());
        }
        if (this.extract == TableOrder.BY_ROW) {
            return this.source.getColumnKey(n2);
        }
        if (this.extract != TableOrder.BY_COLUMN) return comparable;
        return this.source.getRowKey(n2);
    }

    @Override
    public int getIndex(Comparable comparable) {
        int n2 = -1;
        if (this.source == null) return n2;
        if (this.extract == TableOrder.BY_ROW) {
            return this.source.getColumnIndex(comparable);
        }
        if (this.extract != TableOrder.BY_COLUMN) return n2;
        return this.source.getRowIndex(comparable);
    }

    @Override
    public List getKeys() {
        List list = Collections.EMPTY_LIST;
        if (this.source == null) return list;
        if (this.extract == TableOrder.BY_ROW) {
            return this.source.getColumnKeys();
        }
        if (this.extract != TableOrder.BY_COLUMN) return list;
        return this.source.getRowKeys();
    }

    @Override
    public Number getValue(Comparable comparable) {
        Number number = null;
        int n2 = this.getIndex(comparable);
        if (n2 == -1) return number;
        if (this.extract == TableOrder.BY_ROW) {
            return this.source.getValue(this.index, n2);
        }
        if (this.extract != TableOrder.BY_COLUMN) return number;
        return this.source.getValue(n2, this.index);
    }

    @Override
    public void datasetChanged(DatasetChangeEvent datasetChangeEvent) {
        this.fireDatasetChanged();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof PieDataset)) {
            return false;
        }
        PieDataset pieDataset = (PieDataset)object;
        int n2 = this.getItemCount();
        if (pieDataset.getItemCount() != n2) {
            return false;
        }
        int n3 = 0;
        while (n3 < n2) {
            Comparable comparable;
            Comparable comparable2 = this.getKey(n3);
            if (!comparable2.equals(comparable = pieDataset.getKey(n3))) {
                return false;
            }
            Number number = this.getValue(n3);
            Number number2 = pieDataset.getValue(n3);
            if (number == null ? number2 != null : !number.equals(number2)) {
                return false;
            }
            ++n3;
        }
        return true;
    }
}

