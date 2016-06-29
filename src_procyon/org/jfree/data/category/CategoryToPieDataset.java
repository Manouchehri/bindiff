package org.jfree.data.category;

import org.jfree.util.*;
import java.util.*;
import org.jfree.data.general.*;

public class CategoryToPieDataset extends AbstractDataset implements DatasetChangeListener, PieDataset
{
    static final long serialVersionUID = 5516396319762189617L;
    private CategoryDataset source;
    private TableOrder extract;
    private int index;
    
    public CategoryToPieDataset(final CategoryDataset source, final TableOrder extract, final int index) {
        if (extract == null) {
            throw new IllegalArgumentException("Null 'extract' argument.");
        }
        this.source = source;
        if (this.source != null) {
            this.source.addChangeListener(this);
        }
        this.extract = extract;
        this.index = index;
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
    
    public int getItemCount() {
        int n = 0;
        if (this.source != null) {
            if (this.extract == TableOrder.BY_ROW) {
                n = this.source.getColumnCount();
            }
            else if (this.extract == TableOrder.BY_COLUMN) {
                n = this.source.getRowCount();
            }
        }
        return n;
    }
    
    public Number getValue(final int n) {
        Number n2 = null;
        if (n < 0 || n >= this.getItemCount()) {
            throw new IndexOutOfBoundsException("The 'item' index is out of bounds.");
        }
        if (this.extract == TableOrder.BY_ROW) {
            n2 = this.source.getValue(this.index, n);
        }
        else if (this.extract == TableOrder.BY_COLUMN) {
            n2 = this.source.getValue(n, this.index);
        }
        return n2;
    }
    
    public Comparable getKey(final int n) {
        Comparable comparable = null;
        if (n < 0 || n >= this.getItemCount()) {
            throw new IndexOutOfBoundsException("Invalid 'index': " + n);
        }
        if (this.extract == TableOrder.BY_ROW) {
            comparable = this.source.getColumnKey(n);
        }
        else if (this.extract == TableOrder.BY_COLUMN) {
            comparable = this.source.getRowKey(n);
        }
        return comparable;
    }
    
    public int getIndex(final Comparable comparable) {
        int n = -1;
        if (this.source != null) {
            if (this.extract == TableOrder.BY_ROW) {
                n = this.source.getColumnIndex(comparable);
            }
            else if (this.extract == TableOrder.BY_COLUMN) {
                n = this.source.getRowIndex(comparable);
            }
        }
        return n;
    }
    
    public List getKeys() {
        List list = Collections.EMPTY_LIST;
        if (this.source != null) {
            if (this.extract == TableOrder.BY_ROW) {
                list = this.source.getColumnKeys();
            }
            else if (this.extract == TableOrder.BY_COLUMN) {
                list = this.source.getRowKeys();
            }
        }
        return list;
    }
    
    public Number getValue(final Comparable comparable) {
        Number n = null;
        final int index = this.getIndex(comparable);
        if (index != -1) {
            if (this.extract == TableOrder.BY_ROW) {
                n = this.source.getValue(this.index, index);
            }
            else if (this.extract == TableOrder.BY_COLUMN) {
                n = this.source.getValue(index, this.index);
            }
        }
        return n;
    }
    
    public void datasetChanged(final DatasetChangeEvent datasetChangeEvent) {
        this.fireDatasetChanged();
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PieDataset)) {
            return false;
        }
        final PieDataset pieDataset = (PieDataset)o;
        final int itemCount = this.getItemCount();
        if (pieDataset.getItemCount() != itemCount) {
            return false;
        }
        for (int i = 0; i < itemCount; ++i) {
            if (!this.getKey(i).equals(pieDataset.getKey(i))) {
                return false;
            }
            final Number value = this.getValue(i);
            final Number value2 = pieDataset.getValue(i);
            if (value == null) {
                if (value2 != null) {
                    return false;
                }
            }
            else if (!value.equals(value2)) {
                return false;
            }
        }
        return true;
    }
}
