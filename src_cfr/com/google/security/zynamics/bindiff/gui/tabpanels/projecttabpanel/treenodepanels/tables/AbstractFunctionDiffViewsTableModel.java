/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractFunctionDiffViewsTableModel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractFunctionDiffViewsTableModel$InternalDiffListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.IDiffListener;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractFunctionDiffViewsTableModel
extends AbstractTableModel {
    private final IDiffListener diffListener;
    List functionDiffViewList;

    public AbstractFunctionDiffViewsTableModel(List list) {
        this.diffListener = new AbstractFunctionDiffViewsTableModel$InternalDiffListener(this, null);
        Preconditions.checkNotNull(list);
        this.functionDiffViewList = list;
        this.addDiffListener();
    }

    private void addDiffListener() {
        Iterator iterator = this.functionDiffViewList.iterator();
        while (iterator.hasNext()) {
            Diff diff = (Diff)iterator.next();
            diff.addListener(this.diffListener);
        }
    }

    private void removeDiffListener() {
        Iterator iterator = this.functionDiffViewList.iterator();
        while (iterator.hasNext()) {
            Diff diff = (Diff)iterator.next();
            diff.removeListener(this.diffListener);
        }
    }

    public void addRow(Diff diff) {
        if (!this.functionDiffViewList.add(diff)) return;
        diff.addListener(this.diffListener);
        this.fireTableDataChanged();
    }

    @Override
    public void dispose() {
        this.removeDiffListener();
    }

    public Diff getDiffAt(int n2) {
        return (Diff)this.functionDiffViewList.get(n2);
    }

    @Override
    public int getRowCount() {
        return this.functionDiffViewList.size();
    }

    public void removeRow(Diff diff) {
        if (!this.functionDiffViewList.remove(diff)) return;
        diff.removeListener(this.diffListener);
        this.fireTableDataChanged();
    }

    public void setFunctionDiffList(List list) {
        this.removeDiffListener();
        this.functionDiffViewList = list;
        this.addDiffListener();
        this.fireTableDataChanged();
    }
}

