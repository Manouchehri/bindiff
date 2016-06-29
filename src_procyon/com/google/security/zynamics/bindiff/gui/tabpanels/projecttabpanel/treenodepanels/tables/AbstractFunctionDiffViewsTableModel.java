package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.common.base.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import java.util.*;

public abstract class AbstractFunctionDiffViewsTableModel extends AbstractTableModel
{
    private final IDiffListener diffListener;
    List functionDiffViewList;
    
    public AbstractFunctionDiffViewsTableModel(final List functionDiffViewList) {
        this.diffListener = new AbstractFunctionDiffViewsTableModel$InternalDiffListener(this, null);
        Preconditions.checkNotNull(functionDiffViewList);
        this.functionDiffViewList = functionDiffViewList;
        this.addDiffListener();
    }
    
    private void addDiffListener() {
        final Iterator<Diff> iterator = this.functionDiffViewList.iterator();
        while (iterator.hasNext()) {
            iterator.next().addListener(this.diffListener);
        }
    }
    
    private void removeDiffListener() {
        final Iterator<Diff> iterator = this.functionDiffViewList.iterator();
        while (iterator.hasNext()) {
            iterator.next().removeListener(this.diffListener);
        }
    }
    
    public void addRow(final Diff diff) {
        if (this.functionDiffViewList.add(diff)) {
            diff.addListener(this.diffListener);
            this.fireTableDataChanged();
        }
    }
    
    @Override
    public void dispose() {
        this.removeDiffListener();
    }
    
    public Diff getDiffAt(final int n) {
        return this.functionDiffViewList.get(n);
    }
    
    @Override
    public int getRowCount() {
        return this.functionDiffViewList.size();
    }
    
    public void removeRow(final Diff diff) {
        if (this.functionDiffViewList.remove(diff)) {
            diff.removeListener(this.diffListener);
            this.fireTableDataChanged();
        }
    }
    
    public void setFunctionDiffList(final List functionDiffViewList) {
        this.removeDiffListener();
        this.functionDiffViewList = functionDiffViewList;
        this.addDiffListener();
        this.fireTableDataChanged();
    }
}
