package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import javax.swing.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.*;

public class FunctionDiffViewsContainerNodeContextPanel extends AbstractTreeNodeContextPanel
{
    private final FunctionDiffViewsContainerTable allFunctionDiffsViewsTable;
    private final TableModelListener tableModelListener;
    
    public FunctionDiffViewsContainerNodeContextPanel(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.tableModelListener = new FunctionDiffViewsContainerNodeContextPanel$InternalTableModelListener(this, null);
        final FunctionDiffViewsContainerTableModel functionDiffViewsContainerTableModel = new FunctionDiffViewsContainerTableModel(((WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions)).getWorkspace().getDiffList(true));
        this.allFunctionDiffsViewsTable = new FunctionDiffViewsContainerTable(functionDiffViewsContainerTableModel, workspaceTabPanelFunctions);
        functionDiffViewsContainerTableModel.addTableModelListener(this.tableModelListener);
        this.init();
    }
    
    private JPanel createTablePanel() {
        final JScrollPane scrollPane = new JScrollPane(this.allFunctionDiffsViewsTable);
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
        ((TitledBorder)this.getBorder()).setTitle(String.format("%d Single Function Diff Views", this.allFunctionDiffsViewsTable.getRowCount()));
    }
    
    public void dispose() {
        this.allFunctionDiffsViewsTable.getTableModel().removeTableModelListener(this.tableModelListener);
    }
    
    @Override
    public List getTables() {
        final ArrayList<FunctionDiffViewsContainerTable> list = new ArrayList<FunctionDiffViewsContainerTable>();
        list.add(this.allFunctionDiffsViewsTable);
        return list;
    }
}
