/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.AbstractTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.CallGraphsTreeNodeContextPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.CallGraphsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.BasicBlockMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.CallMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.FunctionMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.InstructionMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.JumpMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.SimilarityBarChart2dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarExtendedCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarExtendedLabel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarLabel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.CallGraphViewTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.CallGraphViewTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.ICountsChangeListener;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CallGraphsTreeNodeContextPanel
extends AbstractTreeNodeContextPanel {
    private static final int TEXTFIELDHEIGHT = 25;
    private static final int TEXTFIELDLABELWIDTH = 100;
    private final Diff diff;
    private final CallGraphViewTable callgraphTable;
    private final CallGraphsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener countsChangeListener;
    private PercentageTwoBarExtendedLabel primaryFunctions;
    private PercentageTwoBarExtendedLabel secondaryFunctions;
    private PercentageTwoBarExtendedLabel primaryCalls;
    private PercentageTwoBarExtendedLabel secondaryCalls;
    private PercentageTwoBarLabel primaryBasicblocks;
    private PercentageTwoBarLabel secondaryBasicblocks;
    private PercentageTwoBarLabel primaryJumps;
    private PercentageTwoBarLabel secondaryJumps;
    private PercentageTwoBarLabel primaryInstructions;
    private PercentageTwoBarLabel secondaryInstructions;

    public CallGraphsTreeNodeContextPanel(Diff diff, WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.countsChangeListener = new CallGraphsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener(this, null);
        Preconditions.checkNotNull(diff);
        this.diff = diff;
        this.callgraphTable = new CallGraphViewTable(new CallGraphViewTableModel(diff), workspaceTabPanelFunctions);
        this.init();
        diff.getMetaData().addListener(this.countsChangeListener);
    }

    private JPanel createChartsPanel() {
        JPanel jPanel = new JPanel(new BorderLayout(0, 0));
        jPanel.setBorder(new CompoundBorder(new TitledBorder("Overview"), new LineBorder(Color.GRAY)));
        JPanel jPanel2 = new JPanel(new GridLayout(2, 3, 0, 0));
        jPanel2.setBackground(Color.WHITE);
        jPanel.add((Component)jPanel2, "Center");
        jPanel2.add(new FunctionMatchesPie3dPanel(this.diff));
        jPanel2.add(new CallMatchesPie3dPanel(this.diff));
        jPanel2.add(new SimilarityBarChart2dPanel(this.diff.getDiffMetaData()));
        jPanel2.add(new BasicBlockMatchesPie3dPanel(this.diff, true));
        jPanel2.add(new JumpMatchesPie3dPanel(this.diff, true));
        jPanel2.add(new InstructionMatchesPie3dPanel(this.diff, true));
        return jPanel;
    }

    private JPanel createInfoPanel() {
        MatchData matchData = this.diff.getMatches();
        int n2 = matchData.getSizeOfMatchedFunctions();
        int n3 = matchData.getSizeOfChangedFunctions();
        int n4 = matchData.getSizeOfUnmatchedFunctions(ESide.PRIMARY);
        int n5 = matchData.getSizeOfUnmatchedFunctions(ESide.SECONDARY);
        PercentageTwoBarExtendedCellData percentageTwoBarExtendedCellData = new PercentageTwoBarExtendedCellData(n2, n3, n4);
        PercentageTwoBarExtendedCellData percentageTwoBarExtendedCellData2 = new PercentageTwoBarExtendedCellData(n2, n3, n5);
        this.primaryFunctions = new PercentageTwoBarExtendedLabel(percentageTwoBarExtendedCellData, Colors.MATCHED_LABEL_BAR, Colors.TABLE_CELL_CHANGED_BACKGROUND, Colors.UNMATCHED_PRIMARY_LABEL_BAR, 25);
        this.secondaryFunctions = new PercentageTwoBarExtendedLabel(percentageTwoBarExtendedCellData2, Colors.MATCHED_LABEL_BAR, Colors.TABLE_CELL_CHANGED_BACKGROUND, Colors.UNMATCHED_SECONDARY_LABEL_BAR, 25);
        int n6 = matchData.getSizeOfMatchedCalls();
        int n7 = matchData.getSizeOfChangedCalls();
        int n8 = matchData.getSizeOfUnmatchedCalls(ESide.PRIMARY);
        int n9 = matchData.getSizeOfUnmatchedCalls(ESide.SECONDARY);
        PercentageTwoBarExtendedCellData percentageTwoBarExtendedCellData3 = new PercentageTwoBarExtendedCellData(n6, n7, n8);
        PercentageTwoBarExtendedCellData percentageTwoBarExtendedCellData4 = new PercentageTwoBarExtendedCellData(n6, n7, n9);
        this.primaryCalls = new PercentageTwoBarExtendedLabel(percentageTwoBarExtendedCellData3, Colors.MATCHED_LABEL_BAR, Colors.TABLE_CELL_CHANGED_BACKGROUND, Colors.UNMATCHED_PRIMARY_LABEL_BAR, 25);
        this.secondaryCalls = new PercentageTwoBarExtendedLabel(percentageTwoBarExtendedCellData4, Colors.MATCHED_LABEL_BAR, Colors.TABLE_CELL_CHANGED_BACKGROUND, Colors.UNMATCHED_SECONDARY_LABEL_BAR, 25);
        int n10 = matchData.getSizeOfMatchedBasicblocks();
        int n11 = matchData.getSizeOfUnmatchedBasicblocks(ESide.PRIMARY);
        int n12 = matchData.getSizeOfUnmatchedBasicblocks(ESide.SECONDARY);
        PercentageTwoBarCellData percentageTwoBarCellData = new PercentageTwoBarCellData(n10, n11);
        PercentageTwoBarCellData percentageTwoBarCellData2 = new PercentageTwoBarCellData(n10, n12);
        this.primaryBasicblocks = new PercentageTwoBarLabel(percentageTwoBarCellData, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_PRIMARY_LABEL_BAR, 25);
        this.secondaryBasicblocks = new PercentageTwoBarLabel(percentageTwoBarCellData2, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_SECONDARY_LABEL_BAR, 25);
        int n13 = matchData.getSizeOfMatchedJumps();
        int n14 = matchData.getSizeOfUnmatchedJumps(ESide.PRIMARY);
        int n15 = matchData.getSizeOfUnmatchedJumps(ESide.SECONDARY);
        PercentageTwoBarCellData percentageTwoBarCellData3 = new PercentageTwoBarCellData(n13, n14);
        PercentageTwoBarCellData percentageTwoBarCellData4 = new PercentageTwoBarCellData(n13, n15);
        this.primaryJumps = new PercentageTwoBarLabel(percentageTwoBarCellData3, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_PRIMARY_LABEL_BAR, 25);
        this.secondaryJumps = new PercentageTwoBarLabel(percentageTwoBarCellData4, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_SECONDARY_LABEL_BAR, 25);
        int n16 = matchData.getSizeOfMatchedInstructions();
        int n17 = matchData.getSizeOfUnmatchedInstructions(ESide.PRIMARY);
        int n18 = matchData.getSizeOfUnmatchedInstructions(ESide.SECONDARY);
        PercentageTwoBarCellData percentageTwoBarCellData5 = new PercentageTwoBarCellData(n16, n17);
        PercentageTwoBarCellData percentageTwoBarCellData6 = new PercentageTwoBarCellData(n16, n18);
        this.primaryInstructions = new PercentageTwoBarLabel(percentageTwoBarCellData5, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_PRIMARY_LABEL_BAR, 25);
        this.secondaryInstructions = new PercentageTwoBarLabel(percentageTwoBarCellData6, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_SECONDARY_LABEL_BAR, 25);
        JLabel jLabel = new JLabel(this.diff.getMetaData().getImageName(ESide.PRIMARY));
        JLabel jLabel2 = new JLabel(this.diff.getMetaData().getImageName(ESide.SECONDARY));
        JPanel jPanel = new JPanel(new GridLayout(1, 2, 2, 2));
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(new TitledBorder("Primary Call Graph"));
        JPanel jPanel3 = new JPanel(new GridLayout(6, 1, 2, 2));
        jPanel3.setBorder(new LineBorder(Color.GRAY));
        jPanel3.setBackground(Color.WHITE);
        jPanel3.add(GuiUtils.createHorizontalNamedLabelPanel("Image Name", 100, jLabel, 25));
        jPanel3.add(GuiUtils.createHorizontalNamedLabelPanel("Functions", 100, this.primaryFunctions, 25));
        jPanel3.add(GuiUtils.createHorizontalNamedLabelPanel("Calls", 100, this.primaryCalls, 25));
        jPanel3.add(GuiUtils.createHorizontalNamedLabelPanel("Basic Blocks", 100, this.primaryBasicblocks, 25));
        jPanel3.add(GuiUtils.createHorizontalNamedLabelPanel("Jumps", 100, this.primaryJumps, 25));
        jPanel3.add(GuiUtils.createHorizontalNamedLabelPanel("Instructions", 100, this.primaryInstructions, 25));
        jPanel2.add((Component)jPanel3, "Center");
        JPanel jPanel4 = new JPanel(new BorderLayout());
        jPanel4.setBorder(new TitledBorder("Secondary Call Graph"));
        JPanel jPanel5 = new JPanel(new GridLayout(6, 1, 2, 2));
        jPanel5.setBorder(new LineBorder(Color.GRAY));
        jPanel5.setBackground(Color.WHITE);
        jPanel5.add(GuiUtils.createHorizontalNamedLabelPanel("Image Name", 100, jLabel2, 25));
        jPanel5.add(GuiUtils.createHorizontalNamedLabelPanel("Functions", 100, this.secondaryFunctions, 25));
        jPanel5.add(GuiUtils.createHorizontalNamedLabelPanel("Calls", 100, this.secondaryCalls, 25));
        jPanel5.add(GuiUtils.createHorizontalNamedLabelPanel("Basic Blocks", 100, this.secondaryBasicblocks, 25));
        jPanel5.add(GuiUtils.createHorizontalNamedLabelPanel("Jumps", 100, this.secondaryJumps, 25));
        jPanel5.add(GuiUtils.createHorizontalNamedLabelPanel("Instructions", 100, this.secondaryInstructions, 25));
        jPanel4.add((Component)jPanel5, "Center");
        jPanel.add(jPanel2);
        jPanel.add(jPanel4);
        return jPanel;
    }

    private JPanel createTablePanel() {
        this.callgraphTable.setPreferredSize(new Dimension(this.callgraphTable.getPreferredSize().width, 40));
        JScrollPane jScrollPane = new JScrollPane(this.callgraphTable);
        jScrollPane.setVerticalScrollBarPolicy(21);
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new TitledBorder(String.format("%d Call Graph View", 1)));
        jPanel.add((Component)jScrollPane, "Center");
        jPanel.setPreferredSize(new Dimension(jPanel.getPreferredSize().width, 60));
        return jPanel;
    }

    private void init() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add((Component)this.createChartsPanel(), "North");
        jPanel.add((Component)this.createInfoPanel(), "Center");
        jPanel.add((Component)this.createTablePanel(), "South");
        this.add((Component)jPanel, "North");
    }

    public void dipose() {
        this.diff.getMetaData().removeListener(this.countsChangeListener);
    }

    @Override
    public List getTables() {
        ArrayList<CallGraphViewTable> arrayList = new ArrayList<CallGraphViewTable>();
        arrayList.add(this.callgraphTable);
        return arrayList;
    }

    static /* synthetic */ Diff access$100(CallGraphsTreeNodeContextPanel callGraphsTreeNodeContextPanel) {
        return callGraphsTreeNodeContextPanel.diff;
    }

    static /* synthetic */ PercentageTwoBarLabel access$200(CallGraphsTreeNodeContextPanel callGraphsTreeNodeContextPanel) {
        return callGraphsTreeNodeContextPanel.primaryBasicblocks;
    }

    static /* synthetic */ PercentageTwoBarLabel access$300(CallGraphsTreeNodeContextPanel callGraphsTreeNodeContextPanel) {
        return callGraphsTreeNodeContextPanel.secondaryBasicblocks;
    }

    static /* synthetic */ PercentageTwoBarExtendedLabel access$400(CallGraphsTreeNodeContextPanel callGraphsTreeNodeContextPanel) {
        return callGraphsTreeNodeContextPanel.primaryCalls;
    }

    static /* synthetic */ PercentageTwoBarExtendedLabel access$500(CallGraphsTreeNodeContextPanel callGraphsTreeNodeContextPanel) {
        return callGraphsTreeNodeContextPanel.secondaryCalls;
    }

    static /* synthetic */ PercentageTwoBarExtendedLabel access$600(CallGraphsTreeNodeContextPanel callGraphsTreeNodeContextPanel) {
        return callGraphsTreeNodeContextPanel.primaryFunctions;
    }

    static /* synthetic */ PercentageTwoBarExtendedLabel access$700(CallGraphsTreeNodeContextPanel callGraphsTreeNodeContextPanel) {
        return callGraphsTreeNodeContextPanel.secondaryFunctions;
    }

    static /* synthetic */ PercentageTwoBarLabel access$800(CallGraphsTreeNodeContextPanel callGraphsTreeNodeContextPanel) {
        return callGraphsTreeNodeContextPanel.primaryInstructions;
    }

    static /* synthetic */ PercentageTwoBarLabel access$900(CallGraphsTreeNodeContextPanel callGraphsTreeNodeContextPanel) {
        return callGraphsTreeNodeContextPanel.secondaryInstructions;
    }

    static /* synthetic */ PercentageTwoBarLabel access$1000(CallGraphsTreeNodeContextPanel callGraphsTreeNodeContextPanel) {
        return callGraphsTreeNodeContextPanel.primaryJumps;
    }

    static /* synthetic */ PercentageTwoBarLabel access$1100(CallGraphsTreeNodeContextPanel callGraphsTreeNodeContextPanel) {
        return callGraphsTreeNodeContextPanel.secondaryJumps;
    }
}

