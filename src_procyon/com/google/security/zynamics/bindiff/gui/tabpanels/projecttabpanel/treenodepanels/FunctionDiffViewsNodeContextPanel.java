package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import javax.swing.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.*;

public class FunctionDiffViewsNodeContextPanel extends AbstractTreeNodeContextPanel
{
    private final FunctionDiffViewsTable functionDiffViewsTable;
    private final TableModelListener tableModelListener;
    
    public FunctionDiffViewsNodeContextPanel(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions, final List list) {
        this.tableModelListener = new FunctionDiffViewsNodeContextPanel$InternalTableModelListener(this, null);
        this.functionDiffViewsTable = new FunctionDiffViewsTable(new FunctionDiffViewsTableModel(list), workspaceTabPanelFunctions);
        this.functionDiffViewsTable.getTableModel().addTableModelListener(this.tableModelListener);
        this.init();
    }
    
    private JPanel createTablePanel() {
        final JScrollPane scrollPane = new JScrollPane(this.functionDiffViewsTable);
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, "Center");
        return panel;
    }
    
    private void init() {
        this.setBorder(new TitledBorder(""));
        this.add(this.createTablePanel(), "Center");
        this.updateBorderTitle();
    }
    
    private void updateBorderTitle() {
        ((TitledBorder)this.getBorder()).setTitle(String.format("%d Single Function Diff Views", this.functionDiffViewsTable.getRowCount()));
    }
    
    public void dispose() {
        this.functionDiffViewsTable.getTableModel().removeTableModelListener(this.tableModelListener);
    }
    
    public FunctionDiffViewsTableModel getFunctionViewsTableModel() {
        return (FunctionDiffViewsTableModel)this.functionDiffViewsTable.getTableModel();
    }
    
    @Override
    public List getTables() {
        final ArrayList<FunctionDiffViewsTable> list = new ArrayList<FunctionDiffViewsTable>();
        list.add(this.functionDiffViewsTable);
        return list;
    }
}
