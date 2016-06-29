/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IUnmatchedFunctionsViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTable$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTable$InternalSelectionListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup.FlowGraphViewsTablePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.BackgroundCellRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.FunctionTypeCellRenderer;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import java.awt.Color;
import javax.swing.JPopupMenu;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class UnmatchedFunctionViewsTable
extends AbstractTable {
    private final ListenerProvider listeners = new ListenerProvider();
    private final UnmatchedFunctionViewsTable$InternalSelectionListener selectionListener;
    private final ESide side;

    public UnmatchedFunctionViewsTable(UnmatchedFunctionViewsTableModel unmatchedFunctionViewsTableModel, WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super(unmatchedFunctionViewsTableModel, workspaceTabPanelFunctions);
        this.selectionListener = new UnmatchedFunctionViewsTable$InternalSelectionListener(this, null);
        this.sortColumn(2, 1);
        this.sortColumn(0, 1);
        this.side = unmatchedFunctionViewsTableModel.getSide();
        this.init();
        this.getSelectionModel().addListSelectionListener(this.selectionListener);
    }

    private void init() {
        TableColumn tableColumn = this.getColumnModel().getColumn(0);
        TableColumn tableColumn2 = this.getColumnModel().getColumn(1);
        TableColumn tableColumn3 = this.getColumnModel().getColumn(2);
        TableColumn tableColumn4 = this.getColumnModel().getColumn(6);
        TableColumn tableColumn5 = this.getColumnModel().getColumn(7);
        TableColumn tableColumn6 = this.getColumnModel().getColumn(3);
        TableColumn tableColumn7 = this.getColumnModel().getColumn(4);
        TableColumn tableColumn8 = this.getColumnModel().getColumn(5);
        tableColumn.setMinWidth(60);
        tableColumn2.setMinWidth(55);
        tableColumn3.setMinWidth(35);
        tableColumn4.setMinWidth(40);
        tableColumn5.setMinWidth(75);
        tableColumn6.setMinWidth(40);
        tableColumn7.setMinWidth(40);
        tableColumn8.setMinWidth(40);
        tableColumn.setPreferredWidth(60);
        tableColumn2.setPreferredWidth(200);
        tableColumn3.setPreferredWidth(35);
        tableColumn4.setPreferredWidth(50);
        tableColumn5.setPreferredWidth(75);
        tableColumn6.setPreferredWidth(50);
        tableColumn7.setPreferredWidth(50);
        tableColumn8.setPreferredWidth(50);
        BackgroundCellRenderer backgroundCellRenderer = new BackgroundCellRenderer(Colors.GRAY250, Colors.GRAY32, 2);
        tableColumn.setCellRenderer(backgroundCellRenderer);
        tableColumn2.setCellRenderer(backgroundCellRenderer);
        tableColumn3.setCellRenderer(new FunctionTypeCellRenderer());
        tableColumn4.setCellRenderer(backgroundCellRenderer);
        tableColumn6.setCellRenderer(backgroundCellRenderer);
        tableColumn7.setCellRenderer(backgroundCellRenderer);
        tableColumn8.setCellRenderer(backgroundCellRenderer);
        tableColumn5.setCellRenderer(backgroundCellRenderer);
    }

    @Override
    protected JPopupMenu getPopupMenu(int n2, int n3) {
        return new FlowGraphViewsTablePopupMenu(this, n2, n3);
    }

    @Override
    protected void handleDoubleClick(int n2) {
        CAddress cAddress = null;
        CAddress cAddress2 = null;
        if (this.side == ESide.PRIMARY) {
            cAddress = new CAddress((String)this.getTableModel().getValueAt(n2, 0), 16);
        } else {
            cAddress2 = new CAddress((String)this.getTableModel().getValueAt(n2, 0), 16);
        }
        this.getController().openFlowgraphView(this.getController().getMainWindow(), this.getDiff(), cAddress, cAddress2);
    }

    public void addListener(IUnmatchedFunctionsViewsTableListener iUnmatchedFunctionsViewsTableListener) {
        this.listeners.addListener(iUnmatchedFunctionsViewsTableListener);
    }

    public ESide getSide() {
        return this.side;
    }

    public void removeListener(IUnmatchedFunctionsViewsTableListener iUnmatchedFunctionsViewsTableListener) {
        this.listeners.removeListener(iUnmatchedFunctionsViewsTableListener);
    }

    static /* synthetic */ ListenerProvider access$100(UnmatchedFunctionViewsTable unmatchedFunctionViewsTable) {
        return unmatchedFunctionViewsTable.listeners;
    }
}

