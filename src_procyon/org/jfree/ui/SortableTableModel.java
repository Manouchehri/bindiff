package org.jfree.ui;

import javax.swing.table.*;

public abstract class SortableTableModel extends AbstractTableModel
{
    private int sortingColumn;
    private boolean ascending;
    
    public SortableTableModel() {
        this.sortingColumn = -1;
        this.ascending = true;
    }
    
    public int getSortingColumn() {
        return this.sortingColumn;
    }
    
    public boolean isAscending() {
        return this.ascending;
    }
    
    public void setAscending(final boolean ascending) {
        this.ascending = ascending;
    }
    
    public void sortByColumn(final int sortingColumn, final boolean b) {
        if (this.isSortable(sortingColumn)) {
            this.sortingColumn = sortingColumn;
        }
    }
    
    public boolean isSortable(final int n) {
        return false;
    }
}
