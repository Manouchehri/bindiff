package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import java.util.*;

public class MatchedFunctionsTreeNodeContextPanel extends AbstractTreeNodeContextPanel
{
    private final Diff diff;
    private final JPanel tablePanel;
    private JPanel overviewPanel;
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
    
    public MatchedFunctionsTreeNodeContextPanel(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions, final Diff diff) {
        this.tablePanel = new JPanel(new BorderLayout());
        this.overviewPanel = new JPanel(new BorderLayout());
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
        final JPanel panel = new JPanel(new BorderLayout(0, 0));
        panel.setBorder(new CompoundBorder(new TitledBorder("Overview"), new LineBorder(Color.GRAY)));
        final JPanel panel2 = new JPanel(new GridLayout(1, 4, 0, 0));
        panel.add(panel2, "Center");
        panel2.add(this.basicblocksPiePanel);
        panel2.add(this.jumpsPiePanel);
        panel2.add(this.instructionsPiePanel);
        panel2.add(this.similarityBarChartPanel);
        return panel;
    }
    
    private JPanel createTablePanel() {
        final JScrollPane scrollPane = new JScrollPane(this.matchedFunctionsTable);
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, "Center");
        return panel;
    }
    
    private void initComponents() {
        this.tablePanel.setBorder(new TitledBorder(""));
        this.overviewPanel = this.createOverviewPanel();
        this.updateBorderTitle();
        final JSplitPane splitPane = new JSplitPane(0, true);
        splitPane.setBorder(null);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(200);
        final JSplitPane bottomComponent = new JSplitPane(0, true);
        bottomComponent.setBorder(null);
        bottomComponent.setOneTouchExpandable(true);
        bottomComponent.setResizeWeight(1.0);
        bottomComponent.setDividerLocation(0.7);
        this.tablePanel.add(this.filterPanel, "North");
        this.tablePanel.add(this.createTablePanel(), "Center");
        splitPane.setTopComponent(this.overviewPanel);
        splitPane.setBottomComponent(bottomComponent);
        bottomComponent.setTopComponent(this.tablePanel);
        bottomComponent.setBottomComponent(this.callerAndCallesPanel);
        this.add(splitPane, "Center");
    }
    
    private void updateBorderTitle() {
        ((TitledBorder)this.tablePanel.getBorder()).setTitle(String.format("%d / %d Matched Functions", this.matchedFunctionsTable.getRowCount(), this.diff.getMatches().getSizeOfMatchedFunctions()));
        this.updateUI();
    }
    
    private void updateCharts(final MatchedFunctionViewsTable matchedFunctionViewsTable) {
        final Vector<Double> vector = new Vector<Double>();
        final Vector<Double> vector2 = new Vector<Double>();
        int[] selectedRows = matchedFunctionViewsTable.getSelectedRows();
        if (selectedRows.length == 0) {
            selectedRows = new int[matchedFunctionViewsTable.getRowCount()];
            for (int i = 0; i < matchedFunctionViewsTable.getRowCount(); ++i) {
                selectedRows[i] = i;
            }
        }
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        for (final int n10 : selectedRows) {
            final CAddress cAddress = new CAddress((String)matchedFunctionViewsTable.getValueAt(n10, matchedFunctionViewsTable.convertColumnIndexToView(3)), 16);
            final CAddress cAddress2 = new CAddress((String)matchedFunctionViewsTable.getValueAt(n10, matchedFunctionViewsTable.convertColumnIndexToView(6)), 16);
            final RawFunction function = this.diff.getFunction(cAddress, ESide.PRIMARY);
            final RawFunction function2 = this.diff.getFunction(cAddress2, ESide.SECONDARY);
            n += function.getSizeOfMatchedBasicblocks();
            n2 += function.getSizeOfUnmatchedBasicblocks();
            n3 += function2.getSizeOfUnmatchedBasicblocks();
            n4 += function.getSizeOfMatchedJumps();
            n5 += function.getSizeOfUnmatchedJumps();
            n6 += function2.getSizeOfUnmatchedJumps();
            n7 += function.getSizeOfMatchedInstructions();
            n8 += function.getSizeOfUnmatchedInstructions();
            n9 += function2.getSizeOfUnmatchedInstructions();
            final FunctionMatchData functionMatch = function.getFunctionMatch();
            vector.add(functionMatch.getSimilarity());
            vector2.add(functionMatch.getConfidence());
        }
        this.basicblocksPiePanel.updateDataset(n, n2, n3);
        this.jumpsPiePanel.updateDataset(n4, n5, n6);
        this.instructionsPiePanel.updateDataset(n7, n8, n9);
        this.similarityBarChartPanel.updateDataset(vector);
    }
    
    public void dispose() {
        this.matchedFunctionsTable.removeListener(this.tableListener);
        this.filterPanel.removeListener(this.filterCheckboxListener);
        this.matchedFunctionsTable.dispose();
        this.diff.getMetaData().removeListener(this.countsChangeListener);
    }
    
    @Override
    public List getTables() {
        final ArrayList<MatchedFunctionViewsTable> list = new ArrayList<MatchedFunctionViewsTable>();
        list.add(this.matchedFunctionsTable);
        return list;
    }
}
