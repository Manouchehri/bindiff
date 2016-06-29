/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.misc.EPercentageBarSortType;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractTableModel
extends javax.swing.table.AbstractTableModel {
    private final Diff diff;
    private final Map sortRelevance = new HashMap();

    public AbstractTableModel() {
        this.diff = null;
    }

    public AbstractTableModel(Diff diff) {
        Preconditions.checkNotNull(diff);
        this.diff = diff;
    }

    protected EPercentageBarSortType getColumnSortRelevance(int n2) {
        return (EPercentageBarSortType)((Object)this.sortRelevance.get(n2));
    }

    public void dispose() {
    }

    @Override
    public abstract String getColumnName(int var1);

    public Diff getDiff() {
        return this.diff;
    }

    public abstract List getSorters();

    public void setColumnSortRelevance(int n2, EPercentageBarSortType ePercentageBarSortType) {
        if (n2 >= this.getColumnCount()) {
            Logger.logWarning("Column is not in table.", new Object[0]);
            return;
        }
        this.sortRelevance.put(n2, ePercentageBarSortType);
    }
}

