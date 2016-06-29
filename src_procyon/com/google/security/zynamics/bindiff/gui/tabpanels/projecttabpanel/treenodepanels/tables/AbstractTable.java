package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.zylib.gui.tables.*;
import com.google.common.base.*;
import javax.swing.table.*;
import com.google.security.zynamics.zylib.general.*;
import javax.swing.event.*;
import java.util.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public abstract class AbstractTable extends JTable
{
    private final AbstractTableModel model;
    private final WorkspaceTabPanelFunctions controller;
    private final CTableSorter tableSorter;
    private final ListenerProvider listeners;
    private final AbstractTable$InternalMouseListener mouseListener;
    private final AbstractTable$InternalSelectionListener selectionListener;
    
    public AbstractTable(final AbstractTableModel abstractTableModel, final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.listeners = new ListenerProvider();
        this.mouseListener = new AbstractTable$InternalMouseListener(this, null);
        this.selectionListener = new AbstractTable$InternalSelectionListener(this, null);
        this.model = (AbstractTableModel)Preconditions.checkNotNull(abstractTableModel);
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.setModel(this.tableSorter = new CTableSorter(abstractTableModel));
        this.tableSorter.setTableHeader(this.getTableHeader());
        for (final Pair pair : abstractTableModel.getSorters()) {
            this.tableSorter.setColumnComparator((int)pair.first(), (Comparator)pair.second());
        }
        this.getModel().getTableHeader().setToolTipText("Press CTRL to add secondary sort.");
        this.addMouseListener(this.mouseListener);
        this.getSelectionModel().addListSelectionListener(this.selectionListener);
    }
    
    public static Diff getRowDiff(final AbstractTable abstractTable, final int n) {
        final int modelIndex = abstractTable.getModel().modelIndex(n);
        if (abstractTable.getTableModel() instanceof FunctionDiffViewsContainerTableModel) {
            return ((FunctionDiffViewsContainerTableModel)abstractTable.getTableModel()).getDiffAt(modelIndex);
        }
        if (abstractTable.getTableModel() instanceof FunctionDiffViewsTableModel) {
            return ((FunctionDiffViewsTableModel)abstractTable.getTableModel()).getDiffAt(modelIndex);
        }
        return abstractTable.getDiff();
    }
    
    public static Pair getViewAddressPair(final AbstractTable abstractTable, final int n) {
        Object address = null;
        Object address2 = null;
        if (abstractTable instanceof MatchedFunctionViewsTable) {
            address = new CAddress(abstractTable.getValueAt(n, 3).toString(), 16);
            address2 = new CAddress(abstractTable.getValueAt(n, 6).toString(), 16);
        }
        else if (abstractTable instanceof ExtendedMatchedFunctionViewsTable) {
            final String string = abstractTable.getValueAt(n, 3).toString();
            if (!string.isEmpty()) {
                address = new CAddress(string, 16);
            }
            final String string2 = abstractTable.getValueAt(n, 6).toString();
            if (!string2.isEmpty()) {
                address2 = new CAddress(string2, 16);
            }
        }
        else if (abstractTable instanceof FunctionDiffViewsContainerTable || abstractTable instanceof FunctionDiffViewsTable) {
            Diff diff = abstractTable.getDiff();
            if (diff == null) {
                diff = ((AbstractFunctionDiffViewsTableModel)abstractTable.getTableModel()).getDiffAt(abstractTable.getModel().modelIndex(n));
            }
            if (!diff.isLoaded()) {
                return null;
            }
            address = ((RawFunction)diff.getCallgraph(ESide.PRIMARY).getNodes().get(0)).getAddress();
            address2 = ((RawFunction)diff.getCallgraph(ESide.SECONDARY).getNodes().get(0)).getAddress();
        }
        else if (abstractTable instanceof UnmatchedFunctionViewsTable) {
            final CAddress cAddress = new CAddress(abstractTable.getValueAt(n, 0).toString(), 16);
            if (((UnmatchedFunctionViewsTable)abstractTable).getSide() == ESide.PRIMARY) {
                address = cAddress;
            }
            else {
                address2 = cAddress;
            }
        }
        return Pair.make(address, address2);
    }
    
    private void displayPopupMenu(final MouseEvent mouseEvent) {
        if (this.getSelectionIndex(mouseEvent) == -1) {
            return;
        }
        final JPopupMenu popupMenu = this.getPopupMenu(this.rowAtPoint(mouseEvent.getPoint()), this.columnAtPoint(mouseEvent.getPoint()));
        if (popupMenu != null) {
            popupMenu.show(this, mouseEvent.getX(), mouseEvent.getY());
        }
    }
    
    private int getSelectionIndex(final MouseEvent mouseEvent) {
        return this.tableSorter.modelIndex(this.rowAtPoint(mouseEvent.getPoint()));
    }
    
    protected abstract JPopupMenu getPopupMenu(final int p0, final int p1);
    
    protected int[] getSortSelectedRows() {
        final int[] selectedRows = this.getSelectedRows();
        for (int i = 0; i < selectedRows.length; ++i) {
            selectedRows[i] = this.tableSorter.modelIndex(selectedRows[i]);
        }
        return selectedRows;
    }
    
    protected abstract void handleDoubleClick(final int p0);
    
    public void addListener(final IViewsTableListener viewsTableListener) {
        this.listeners.addListener(viewsTableListener);
    }
    
    public void dispose() {
        this.removeMouseListener(this.mouseListener);
        this.getSelectionModel().removeListSelectionListener(this.selectionListener);
        this.model.dispose();
    }
    
    public WorkspaceTabPanelFunctions getController() {
        return this.controller;
    }
    
    public Diff getDiff() {
        return this.model.getDiff();
    }
    
    @Override
    public CTableSorter getModel() {
        return this.tableSorter;
    }
    
    public AbstractTableModel getTableModel() {
        return this.model;
    }
    
    public String getToolTipForRow(final Diff diff, final int n) {
        return null;
    }
    
    public boolean hasSelection() {
        return this.getSelectedRowCount() > 0;
    }
    
    public void removeListener(final IViewsTableListener viewsTableListener) {
        this.listeners.removeListener(viewsTableListener);
    }
    
    public void sortColumn(final int n, final int n2) {
        this.tableSorter.setSortingStatus(n, n2);
    }
}
