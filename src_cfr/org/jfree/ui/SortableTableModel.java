/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import javax.swing.table.AbstractTableModel;

public abstract class SortableTableModel
extends AbstractTableModel {
    private int sortingColumn = -1;
    private boolean ascending = true;

    public int getSortingColumn() {
        return this.sortingColumn;
    }

    public boolean isAscending() {
        return this.ascending;
    }

    public void setAscending(boolean bl2) {
        this.ascending = bl2;
    }

    public void sortByColumn(int n2, boolean bl2) {
        if (!this.isSortable(n2)) return;
        this.sortingColumn = n2;
    }

    public boolean isSortable(int n2) {
        return false;
    }
}

