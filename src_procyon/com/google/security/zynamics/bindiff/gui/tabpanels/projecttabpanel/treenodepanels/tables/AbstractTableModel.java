package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.misc.*;
import java.util.*;
import com.google.security.zynamics.bindiff.log.*;

public abstract class AbstractTableModel extends javax.swing.table.AbstractTableModel
{
    private final Diff diff;
    private final Map sortRelevance;
    
    public AbstractTableModel() {
        this.sortRelevance = new HashMap();
        this.diff = null;
    }
    
    public AbstractTableModel(final Diff diff) {
        this.sortRelevance = new HashMap();
        Preconditions.checkNotNull(diff);
        this.diff = diff;
    }
    
    protected EPercentageBarSortType getColumnSortRelevance(final int n) {
        return this.sortRelevance.get(n);
    }
    
    public void dispose() {
    }
    
    @Override
    public abstract String getColumnName(final int p0);
    
    public Diff getDiff() {
        return this.diff;
    }
    
    public abstract List getSorters();
    
    public void setColumnSortRelevance(final int n, final EPercentageBarSortType ePercentageBarSortType) {
        if (n >= this.getColumnCount()) {
            Logger.logWarning("Column is not in table.", new Object[0]);
            return;
        }
        this.sortRelevance.put(n, ePercentageBarSortType);
    }
}
