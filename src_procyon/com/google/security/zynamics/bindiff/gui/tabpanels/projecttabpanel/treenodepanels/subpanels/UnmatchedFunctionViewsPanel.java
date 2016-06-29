package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class UnmatchedFunctionViewsPanel extends JPanel
{
    private final Diff diff;
    private final ESide side;
    private final UnmatchedFunctionViewsTable unmatchedFunctionsTable;
    private final UnmatchedFunctionViewsFilterPanel filterPanel;
    private final UnmatchedFunctionViewsPanel$InternalViewsTableListener tableListener;
    private final UnmatchedFunctionViewsTableModel unmatchedFunctionsTableModel;
    
    public UnmatchedFunctionViewsPanel(final Diff diff, final WorkspaceTabPanelFunctions workspaceTabPanelFunctions, final ESide eSide) {
        super(new BorderLayout());
        this.tableListener = new UnmatchedFunctionViewsPanel$InternalViewsTableListener(this, null);
        this.diff = (Diff)Preconditions.checkNotNull(diff);
        this.side = (ESide)Preconditions.checkNotNull(eSide);
        this.unmatchedFunctionsTableModel = new UnmatchedFunctionViewsTableModel(diff, eSide, true);
        this.unmatchedFunctionsTable = new UnmatchedFunctionViewsTable(this.unmatchedFunctionsTableModel, (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions));
        this.filterPanel = new UnmatchedFunctionViewsFilterPanel(this.unmatchedFunctionsTable, eSide);
        this.unmatchedFunctionsTable.addListener(this.tableListener);
        this.unmatchedFunctionsTableModel.addListener(this.tableListener);
        this.init();
    }
    
    private void init() {
        this.setBorder(new TitledBorder(""));
        this.updateBorderTitle();
        final JScrollPane scrollPane = new JScrollPane(this.unmatchedFunctionsTable);
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(this.filterPanel, "North");
        panel.add(scrollPane, "Center");
        this.add(panel, "Center");
    }
    
    private void updateBorderTitle() {
        ((TitledBorder)this.getBorder()).setTitle(String.format("%d / %d %s Unmatched Functions", this.unmatchedFunctionsTableModel.getRowCount(), this.diff.getMatches().getSizeOfUnmatchedFunctions(this.side), (this.side == ESide.PRIMARY) ? "Primary" : "Secondary"));
        this.updateUI();
    }
    
    public List getTables() {
        final ArrayList<UnmatchedFunctionViewsTable> list = new ArrayList<UnmatchedFunctionViewsTable>();
        list.add(this.unmatchedFunctionsTable);
        return list;
    }
}
