/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsPanel$InternalViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IUnmatchedFunctionsViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class UnmatchedFunctionViewsPanel
extends JPanel {
    private final Diff diff;
    private final ESide side;
    private final UnmatchedFunctionViewsTable unmatchedFunctionsTable;
    private final UnmatchedFunctionViewsFilterPanel filterPanel;
    private final UnmatchedFunctionViewsPanel$InternalViewsTableListener tableListener;
    private final UnmatchedFunctionViewsTableModel unmatchedFunctionsTableModel;

    public UnmatchedFunctionViewsPanel(Diff diff, WorkspaceTabPanelFunctions workspaceTabPanelFunctions, ESide eSide) {
        super(new BorderLayout());
        this.tableListener = new UnmatchedFunctionViewsPanel$InternalViewsTableListener(this, null);
        this.diff = (Diff)Preconditions.checkNotNull(diff);
        this.side = (ESide)((Object)Preconditions.checkNotNull((Object)eSide));
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
        JScrollPane jScrollPane = new JScrollPane(this.unmatchedFunctionsTable);
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add((Component)this.filterPanel, "North");
        jPanel.add((Component)jScrollPane, "Center");
        this.add((Component)jPanel, "Center");
    }

    private void updateBorderTitle() {
        Object[] arrobject = new Object[3];
        arrobject[0] = this.unmatchedFunctionsTableModel.getRowCount();
        arrobject[1] = this.diff.getMatches().getSizeOfUnmatchedFunctions(this.side);
        arrobject[2] = this.side == ESide.PRIMARY ? "Primary" : "Secondary";
        ((TitledBorder)this.getBorder()).setTitle(String.format("%d / %d %s Unmatched Functions", arrobject));
        this.updateUI();
    }

    public List getTables() {
        ArrayList<UnmatchedFunctionViewsTable> arrayList = new ArrayList<UnmatchedFunctionViewsTable>();
        arrayList.add(this.unmatchedFunctionsTable);
        return arrayList;
    }

    static /* synthetic */ void access$100(UnmatchedFunctionViewsPanel unmatchedFunctionViewsPanel) {
        unmatchedFunctionViewsPanel.updateBorderTitle();
    }
}

