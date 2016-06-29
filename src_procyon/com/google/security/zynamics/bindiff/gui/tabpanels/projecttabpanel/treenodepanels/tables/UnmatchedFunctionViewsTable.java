package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import javax.swing.event.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.*;
import javax.swing.table.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup.*;
import com.google.security.zynamics.zylib.disassembly.*;

public class UnmatchedFunctionViewsTable extends AbstractTable
{
    private final ListenerProvider listeners;
    private final UnmatchedFunctionViewsTable$InternalSelectionListener selectionListener;
    private final ESide side;
    
    public UnmatchedFunctionViewsTable(final UnmatchedFunctionViewsTableModel unmatchedFunctionViewsTableModel, final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super(unmatchedFunctionViewsTableModel, workspaceTabPanelFunctions);
        this.listeners = new ListenerProvider();
        this.selectionListener = new UnmatchedFunctionViewsTable$InternalSelectionListener(this, null);
        this.sortColumn(2, 1);
        this.sortColumn(0, 1);
        this.side = unmatchedFunctionViewsTableModel.getSide();
        this.init();
        this.getSelectionModel().addListSelectionListener(this.selectionListener);
    }
    
    private void init() {
        final TableColumn column = this.getColumnModel().getColumn(0);
        final TableColumn column2 = this.getColumnModel().getColumn(1);
        final TableColumn column3 = this.getColumnModel().getColumn(2);
        final TableColumn column4 = this.getColumnModel().getColumn(6);
        final TableColumn column5 = this.getColumnModel().getColumn(7);
        final TableColumn column6 = this.getColumnModel().getColumn(3);
        final TableColumn column7 = this.getColumnModel().getColumn(4);
        final TableColumn column8 = this.getColumnModel().getColumn(5);
        column.setMinWidth(60);
        column2.setMinWidth(55);
        column3.setMinWidth(35);
        column4.setMinWidth(40);
        column5.setMinWidth(75);
        column6.setMinWidth(40);
        column7.setMinWidth(40);
        column8.setMinWidth(40);
        column.setPreferredWidth(60);
        column2.setPreferredWidth(200);
        column3.setPreferredWidth(35);
        column4.setPreferredWidth(50);
        column5.setPreferredWidth(75);
        column6.setPreferredWidth(50);
        column7.setPreferredWidth(50);
        column8.setPreferredWidth(50);
        final BackgroundCellRenderer cellRenderer = new BackgroundCellRenderer(Colors.GRAY250, Colors.GRAY32, 2);
        column.setCellRenderer(cellRenderer);
        column2.setCellRenderer(cellRenderer);
        column3.setCellRenderer(new FunctionTypeCellRenderer());
        column4.setCellRenderer(cellRenderer);
        column6.setCellRenderer(cellRenderer);
        column7.setCellRenderer(cellRenderer);
        column8.setCellRenderer(cellRenderer);
        column5.setCellRenderer(cellRenderer);
    }
    
    @Override
    protected JPopupMenu getPopupMenu(final int n, final int n2) {
        return new FlowGraphViewsTablePopupMenu(this, n, n2);
    }
    
    @Override
    protected void handleDoubleClick(final int n) {
        IAddress address = null;
        IAddress address2 = null;
        if (this.side == ESide.PRIMARY) {
            address = new CAddress((String)this.getTableModel().getValueAt(n, 0), 16);
        }
        else {
            address2 = new CAddress((String)this.getTableModel().getValueAt(n, 0), 16);
        }
        this.getController().openFlowgraphView(this.getController().getMainWindow(), this.getDiff(), address, address2);
    }
    
    public void addListener(final IUnmatchedFunctionsViewsTableListener unmatchedFunctionsViewsTableListener) {
        this.listeners.addListener(unmatchedFunctionsViewsTableListener);
    }
    
    public ESide getSide() {
        return this.side;
    }
    
    public void removeListener(final IUnmatchedFunctionsViewsTableListener unmatchedFunctionsViewsTableListener) {
        this.listeners.removeListener(unmatchedFunctionsViewsTableListener);
    }
}
