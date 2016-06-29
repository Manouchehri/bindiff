/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractFunctionDiffViewsTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable$InternalMouseListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable$InternalSelectionListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.ExtendedMatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsContainerTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsContainerTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public abstract class AbstractTable
extends JTable {
    private final AbstractTableModel model;
    private final WorkspaceTabPanelFunctions controller;
    private final CTableSorter tableSorter;
    private final ListenerProvider listeners = new ListenerProvider();
    private final AbstractTable$InternalMouseListener mouseListener;
    private final AbstractTable$InternalSelectionListener selectionListener;

    public AbstractTable(AbstractTableModel abstractTableModel, WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.mouseListener = new AbstractTable$InternalMouseListener(this, null);
        this.selectionListener = new AbstractTable$InternalSelectionListener(this, null);
        this.model = (AbstractTableModel)Preconditions.checkNotNull(abstractTableModel);
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.tableSorter = new CTableSorter(abstractTableModel);
        this.setModel(this.tableSorter);
        this.tableSorter.setTableHeader(this.getTableHeader());
        Iterator iterator = abstractTableModel.getSorters().iterator();
        do {
            if (!iterator.hasNext()) {
                this.getModel().getTableHeader().setToolTipText("Press CTRL to add secondary sort.");
                this.addMouseListener(this.mouseListener);
                this.getSelectionModel().addListSelectionListener(this.selectionListener);
                return;
            }
            Pair pair = (Pair)iterator.next();
            this.tableSorter.setColumnComparator((Integer)pair.first(), (Comparator)pair.second());
        } while (true);
    }

    public static Diff getRowDiff(AbstractTable abstractTable, int n2) {
        int n3 = abstractTable.getModel().modelIndex(n2);
        if (abstractTable.getTableModel() instanceof FunctionDiffViewsContainerTableModel) {
            FunctionDiffViewsContainerTableModel functionDiffViewsContainerTableModel = (FunctionDiffViewsContainerTableModel)abstractTable.getTableModel();
            return functionDiffViewsContainerTableModel.getDiffAt(n3);
        }
        if (!(abstractTable.getTableModel() instanceof FunctionDiffViewsTableModel)) return abstractTable.getDiff();
        FunctionDiffViewsTableModel functionDiffViewsTableModel = (FunctionDiffViewsTableModel)abstractTable.getTableModel();
        return functionDiffViewsTableModel.getDiffAt(n3);
    }

    public static Pair getViewAddressPair(AbstractTable abstractTable, int n2) {
        IAddress iAddress = null;
        IAddress iAddress2 = null;
        if (abstractTable instanceof MatchedFunctionViewsTable) {
            iAddress = new CAddress(abstractTable.getValueAt(n2, 3).toString(), 16);
            iAddress2 = new CAddress(abstractTable.getValueAt(n2, 6).toString(), 16);
            return Pair.make(iAddress, iAddress2);
        }
        if (abstractTable instanceof ExtendedMatchedFunctionViewsTable) {
            String string;
            String string2 = abstractTable.getValueAt(n2, 3).toString();
            if (!string2.isEmpty()) {
                iAddress = new CAddress(string2, 16);
            }
            if ((string = abstractTable.getValueAt(n2, 6).toString()).isEmpty()) return Pair.make(iAddress, iAddress2);
            iAddress2 = new CAddress(string, 16);
            return Pair.make(iAddress, iAddress2);
        }
        if (abstractTable instanceof FunctionDiffViewsContainerTable || abstractTable instanceof FunctionDiffViewsTable) {
            Diff diff = abstractTable.getDiff();
            if (diff == null) {
                AbstractFunctionDiffViewsTableModel abstractFunctionDiffViewsTableModel = (AbstractFunctionDiffViewsTableModel)abstractTable.getTableModel();
                int n3 = abstractTable.getModel().modelIndex(n2);
                diff = abstractFunctionDiffViewsTableModel.getDiffAt(n3);
            }
            if (!diff.isLoaded()) {
                return null;
            }
            iAddress = ((RawFunction)diff.getCallgraph(ESide.PRIMARY).getNodes().get(0)).getAddress();
            iAddress2 = ((RawFunction)diff.getCallgraph(ESide.SECONDARY).getNodes().get(0)).getAddress();
            return Pair.make(iAddress, iAddress2);
        }
        if (!(abstractTable instanceof UnmatchedFunctionViewsTable)) return Pair.make(iAddress, iAddress2);
        CAddress cAddress = new CAddress(abstractTable.getValueAt(n2, 0).toString(), 16);
        if (((UnmatchedFunctionViewsTable)abstractTable).getSide() == ESide.PRIMARY) {
            iAddress = cAddress;
            return Pair.make(iAddress, iAddress2);
        }
        iAddress2 = cAddress;
        return Pair.make(iAddress, iAddress2);
    }

    private void displayPopupMenu(MouseEvent mouseEvent) {
        int n2;
        int n3 = this.getSelectionIndex(mouseEvent);
        if (n3 == -1) {
            return;
        }
        int n4 = this.rowAtPoint(mouseEvent.getPoint());
        JPopupMenu jPopupMenu = this.getPopupMenu(n4, n2 = this.columnAtPoint(mouseEvent.getPoint()));
        if (jPopupMenu == null) return;
        jPopupMenu.show(this, mouseEvent.getX(), mouseEvent.getY());
    }

    private int getSelectionIndex(MouseEvent mouseEvent) {
        return this.tableSorter.modelIndex(this.rowAtPoint(mouseEvent.getPoint()));
    }

    protected abstract JPopupMenu getPopupMenu(int var1, int var2);

    protected int[] getSortSelectedRows() {
        int[] arrn = this.getSelectedRows();
        int n2 = 0;
        while (n2 < arrn.length) {
            arrn[n2] = this.tableSorter.modelIndex(arrn[n2]);
            ++n2;
        }
        return arrn;
    }

    protected abstract void handleDoubleClick(int var1);

    public void addListener(IViewsTableListener iViewsTableListener) {
        this.listeners.addListener(iViewsTableListener);
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

    public String getToolTipForRow(Diff diff, int n2) {
        return null;
    }

    public boolean hasSelection() {
        if (this.getSelectedRowCount() <= 0) return false;
        return true;
    }

    public void removeListener(IViewsTableListener iViewsTableListener) {
        this.listeners.removeListener(iViewsTableListener);
    }

    public void sortColumn(int n2, int n3) {
        this.tableSorter.setSortingStatus(n2, n3);
    }

    static /* synthetic */ int access$200(AbstractTable abstractTable, MouseEvent mouseEvent) {
        return abstractTable.getSelectionIndex(mouseEvent);
    }

    static /* synthetic */ void access$300(AbstractTable abstractTable, MouseEvent mouseEvent) {
        abstractTable.displayPopupMenu(mouseEvent);
    }

    static /* synthetic */ ListenerProvider access$400(AbstractTable abstractTable) {
        return abstractTable.listeners;
    }
}

