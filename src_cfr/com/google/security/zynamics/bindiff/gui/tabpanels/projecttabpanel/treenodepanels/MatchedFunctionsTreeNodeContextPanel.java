/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.AbstractTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel$InternalFilterCheckboxListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel$InternalViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.BasicBlockMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.InstructionMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.JumpMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.SimilarityBarChart2dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.AddedAndRemovedCalledFunctionsPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.IViewsFilterCheckboxListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IMatchedFunctionsViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionsViewsTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.ICountsChangeListener;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MatchedFunctionsTreeNodeContextPanel
extends AbstractTreeNodeContextPanel {
    private final Diff diff;
    private final JPanel tablePanel = new JPanel(new BorderLayout());
    private JPanel overviewPanel = new JPanel(new BorderLayout());
    private final MatchedFunctionViewsFilterPanel filterPanel;
    private final AddedAndRemovedCalledFunctionsPanel callerAndCallesPanel;
    private final JumpMatchesPie3dPanel jumpsPiePanel;
    private final BasicBlockMatchesPie3dPanel basicblocksPiePanel;
    private final InstructionMatchesPie3dPanel instructionsPiePanel;
    private final SimilarityBarChart2dPanel similarityBarChartPanel;
    private final MatchedFunctionsViewsTableModel matchedFunctionsTableModel;
    private final MatchedFunctionViewsTable matchedFunctionsTable;
    private final MatchedFunctionsTreeNodeContextPanel$InternalViewsTableListener tableListener;
    private final MatchedFunctionsTreeNodeContextPanel$InternalFilterCheckboxListener filterCheckboxListener;
    private final MatchedFunctionsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener countsChangeListener;

    public MatchedFunctionsTreeNodeContextPanel(WorkspaceTabPanelFunctions workspaceTabPanelFunctions, Diff diff) {
        this.tableListener = new MatchedFunctionsTreeNodeContextPanel$InternalViewsTableListener(this, null);
        this.filterCheckboxListener = new MatchedFunctionsTreeNodeContextPanel$InternalFilterCheckboxListener(this, null);
        this.countsChangeListener = new MatchedFunctionsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener(this, null);
        Preconditions.checkNotNull(diff);
        this.diff = diff;
        this.basicblocksPiePanel = new BasicBlockMatchesPie3dPanel(diff, false);
        this.jumpsPiePanel = new JumpMatchesPie3dPanel(diff, false);
        this.instructionsPiePanel = new InstructionMatchesPie3dPanel(diff, false);
        this.similarityBarChartPanel = new SimilarityBarChart2dPanel(diff.getMetaData());
        this.matchedFunctionsTableModel = new MatchedFunctionsViewsTableModel(diff, true);
        this.matchedFunctionsTable = new MatchedFunctionViewsTable(this.matchedFunctionsTableModel, workspaceTabPanelFunctions);
        this.filterPanel = new MatchedFunctionViewsFilterPanel(this.matchedFunctionsTable);
        this.callerAndCallesPanel = new AddedAndRemovedCalledFunctionsPanel(diff, workspaceTabPanelFunctions, this.matchedFunctionsTable);
        this.filterPanel.addListener(this.filterCheckboxListener);
        this.matchedFunctionsTable.addListener(this.tableListener);
        this.matchedFunctionsTableModel.addListener(this.tableListener);
        diff.getMetaData().addListener(this.countsChangeListener);
        this.initComponents();
        this.updateCharts(this.matchedFunctionsTable);
    }

    private JPanel createOverviewPanel() {
        JPanel jPanel = new JPanel(new BorderLayout(0, 0));
        jPanel.setBorder(new CompoundBorder(new TitledBorder("Overview"), new LineBorder(Color.GRAY)));
        JPanel jPanel2 = new JPanel(new GridLayout(1, 4, 0, 0));
        jPanel.add((Component)jPanel2, "Center");
        jPanel2.add(this.basicblocksPiePanel);
        jPanel2.add(this.jumpsPiePanel);
        jPanel2.add(this.instructionsPiePanel);
        jPanel2.add(this.similarityBarChartPanel);
        return jPanel;
    }

    private JPanel createTablePanel() {
        JScrollPane jScrollPane = new JScrollPane(this.matchedFunctionsTable);
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add((Component)jScrollPane, "Center");
        return jPanel;
    }

    private void initComponents() {
        this.tablePanel.setBorder(new TitledBorder(""));
        this.overviewPanel = this.createOverviewPanel();
        this.updateBorderTitle();
        JSplitPane jSplitPane = new JSplitPane(0, true);
        jSplitPane.setBorder(null);
        jSplitPane.setOneTouchExpandable(true);
        jSplitPane.setDividerLocation(200);
        JSplitPane jSplitPane2 = new JSplitPane(0, true);
        jSplitPane2.setBorder(null);
        jSplitPane2.setOneTouchExpandable(true);
        jSplitPane2.setResizeWeight(1.0);
        jSplitPane2.setDividerLocation(0.7);
        this.tablePanel.add((Component)this.filterPanel, "North");
        this.tablePanel.add((Component)this.createTablePanel(), "Center");
        jSplitPane.setTopComponent(this.overviewPanel);
        jSplitPane.setBottomComponent(jSplitPane2);
        jSplitPane2.setTopComponent(this.tablePanel);
        jSplitPane2.setBottomComponent(this.callerAndCallesPanel);
        this.add((Component)jSplitPane, "Center");
    }

    private void updateBorderTitle() {
        ((TitledBorder)this.tablePanel.getBorder()).setTitle(String.format("%d / %d Matched Functions", this.matchedFunctionsTable.getRowCount(), this.diff.getMatches().getSizeOfMatchedFunctions()));
        this.updateUI();
    }

    private void updateCharts(MatchedFunctionViewsTable matchedFunctionViewsTable) {
        int n2;
        Vector<Double> vector = new Vector<Double>();
        Vector<Double> vector2 = new Vector<Double>();
        int[] arrn = matchedFunctionViewsTable.getSelectedRows();
        if (arrn.length == 0) {
            arrn = new int[matchedFunctionViewsTable.getRowCount()];
            n2 = 0;
            while (n2 < matchedFunctionViewsTable.getRowCount()) {
                arrn[n2] = n2++;
            }
        }
        n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int[] arrn2 = arrn;
        int n11 = arrn2.length;
        int n12 = 0;
        do {
            if (n12 >= n11) {
                this.basicblocksPiePanel.updateDataset(n2, n3, n4);
                this.jumpsPiePanel.updateDataset(n5, n6, n7);
                this.instructionsPiePanel.updateDataset(n8, n9, n10);
                this.similarityBarChartPanel.updateDataset(vector);
                return;
            }
            int n13 = arrn2[n12];
            String string = (String)matchedFunctionViewsTable.getValueAt(n13, matchedFunctionViewsTable.convertColumnIndexToView(3));
            CAddress cAddress = new CAddress(string, 16);
            String string2 = (String)matchedFunctionViewsTable.getValueAt(n13, matchedFunctionViewsTable.convertColumnIndexToView(6));
            CAddress cAddress2 = new CAddress(string2, 16);
            RawFunction rawFunction = this.diff.getFunction(cAddress, ESide.PRIMARY);
            RawFunction rawFunction2 = this.diff.getFunction(cAddress2, ESide.SECONDARY);
            n2 += rawFunction.getSizeOfMatchedBasicblocks();
            n3 += rawFunction.getSizeOfUnmatchedBasicblocks();
            n4 += rawFunction2.getSizeOfUnmatchedBasicblocks();
            n5 += rawFunction.getSizeOfMatchedJumps();
            n6 += rawFunction.getSizeOfUnmatchedJumps();
            n7 += rawFunction2.getSizeOfUnmatchedJumps();
            n8 += rawFunction.getSizeOfMatchedInstructions();
            n9 += rawFunction.getSizeOfUnmatchedInstructions();
            n10 += rawFunction2.getSizeOfUnmatchedInstructions();
            FunctionMatchData functionMatchData = rawFunction.getFunctionMatch();
            vector.add(functionMatchData.getSimilarity());
            vector2.add(functionMatchData.getConfidence());
            ++n12;
        } while (true);
    }

    public void dispose() {
        this.matchedFunctionsTable.removeListener(this.tableListener);
        this.filterPanel.removeListener(this.filterCheckboxListener);
        this.matchedFunctionsTable.dispose();
        this.diff.getMetaData().removeListener(this.countsChangeListener);
    }

    @Override
    public List getTables() {
        ArrayList<MatchedFunctionViewsTable> arrayList = new ArrayList<MatchedFunctionViewsTable>();
        arrayList.add(this.matchedFunctionsTable);
        return arrayList;
    }

    static /* synthetic */ Diff access$300(MatchedFunctionsTreeNodeContextPanel matchedFunctionsTreeNodeContextPanel) {
        return matchedFunctionsTreeNodeContextPanel.diff;
    }

    static /* synthetic */ MatchedFunctionViewsTable access$400(MatchedFunctionsTreeNodeContextPanel matchedFunctionsTreeNodeContextPanel) {
        return matchedFunctionsTreeNodeContextPanel.matchedFunctionsTable;
    }

    static /* synthetic */ void access$500(MatchedFunctionsTreeNodeContextPanel matchedFunctionsTreeNodeContextPanel, MatchedFunctionViewsTable matchedFunctionViewsTable) {
        matchedFunctionsTreeNodeContextPanel.updateCharts(matchedFunctionViewsTable);
    }

    static /* synthetic */ void access$600(MatchedFunctionsTreeNodeContextPanel matchedFunctionsTreeNodeContextPanel) {
        matchedFunctionsTreeNodeContextPanel.updateBorderTitle();
    }
}

