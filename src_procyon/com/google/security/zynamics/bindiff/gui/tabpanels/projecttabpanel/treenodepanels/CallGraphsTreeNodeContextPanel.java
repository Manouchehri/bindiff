package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class CallGraphsTreeNodeContextPanel extends AbstractTreeNodeContextPanel
{
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
    
    public CallGraphsTreeNodeContextPanel(final Diff diff, final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.countsChangeListener = new CallGraphsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener(this, null);
        Preconditions.checkNotNull(diff);
        this.diff = diff;
        this.callgraphTable = new CallGraphViewTable(new CallGraphViewTableModel(diff), workspaceTabPanelFunctions);
        this.init();
        diff.getMetaData().addListener(this.countsChangeListener);
    }
    
    private JPanel createChartsPanel() {
        final JPanel panel = new JPanel(new BorderLayout(0, 0));
        panel.setBorder(new CompoundBorder(new TitledBorder("Overview"), new LineBorder(Color.GRAY)));
        final JPanel panel2 = new JPanel(new GridLayout(2, 3, 0, 0));
        panel2.setBackground(Color.WHITE);
        panel.add(panel2, "Center");
        panel2.add(new FunctionMatchesPie3dPanel(this.diff));
        panel2.add(new CallMatchesPie3dPanel(this.diff));
        panel2.add(new SimilarityBarChart2dPanel(this.diff.getDiffMetaData()));
        panel2.add(new BasicBlockMatchesPie3dPanel(this.diff, true));
        panel2.add(new JumpMatchesPie3dPanel(this.diff, true));
        panel2.add(new InstructionMatchesPie3dPanel(this.diff, true));
        return panel;
    }
    
    private JPanel createInfoPanel() {
        final MatchData matches = this.diff.getMatches();
        final int sizeOfMatchedFunctions = matches.getSizeOfMatchedFunctions();
        final int sizeOfChangedFunctions = matches.getSizeOfChangedFunctions();
        final int sizeOfUnmatchedFunctions = matches.getSizeOfUnmatchedFunctions(ESide.PRIMARY);
        final int sizeOfUnmatchedFunctions2 = matches.getSizeOfUnmatchedFunctions(ESide.SECONDARY);
        final PercentageTwoBarExtendedCellData percentageTwoBarExtendedCellData = new PercentageTwoBarExtendedCellData(sizeOfMatchedFunctions, sizeOfChangedFunctions, sizeOfUnmatchedFunctions);
        final PercentageTwoBarExtendedCellData percentageTwoBarExtendedCellData2 = new PercentageTwoBarExtendedCellData(sizeOfMatchedFunctions, sizeOfChangedFunctions, sizeOfUnmatchedFunctions2);
        this.primaryFunctions = new PercentageTwoBarExtendedLabel(percentageTwoBarExtendedCellData, Colors.MATCHED_LABEL_BAR, Colors.TABLE_CELL_CHANGED_BACKGROUND, Colors.UNMATCHED_PRIMARY_LABEL_BAR, 25);
        this.secondaryFunctions = new PercentageTwoBarExtendedLabel(percentageTwoBarExtendedCellData2, Colors.MATCHED_LABEL_BAR, Colors.TABLE_CELL_CHANGED_BACKGROUND, Colors.UNMATCHED_SECONDARY_LABEL_BAR, 25);
        final int sizeOfMatchedCalls = matches.getSizeOfMatchedCalls();
        final int sizeOfChangedCalls = matches.getSizeOfChangedCalls();
        final int sizeOfUnmatchedCalls = matches.getSizeOfUnmatchedCalls(ESide.PRIMARY);
        final int sizeOfUnmatchedCalls2 = matches.getSizeOfUnmatchedCalls(ESide.SECONDARY);
        final PercentageTwoBarExtendedCellData percentageTwoBarExtendedCellData3 = new PercentageTwoBarExtendedCellData(sizeOfMatchedCalls, sizeOfChangedCalls, sizeOfUnmatchedCalls);
        final PercentageTwoBarExtendedCellData percentageTwoBarExtendedCellData4 = new PercentageTwoBarExtendedCellData(sizeOfMatchedCalls, sizeOfChangedCalls, sizeOfUnmatchedCalls2);
        this.primaryCalls = new PercentageTwoBarExtendedLabel(percentageTwoBarExtendedCellData3, Colors.MATCHED_LABEL_BAR, Colors.TABLE_CELL_CHANGED_BACKGROUND, Colors.UNMATCHED_PRIMARY_LABEL_BAR, 25);
        this.secondaryCalls = new PercentageTwoBarExtendedLabel(percentageTwoBarExtendedCellData4, Colors.MATCHED_LABEL_BAR, Colors.TABLE_CELL_CHANGED_BACKGROUND, Colors.UNMATCHED_SECONDARY_LABEL_BAR, 25);
        final int sizeOfMatchedBasicblocks = matches.getSizeOfMatchedBasicblocks();
        final int sizeOfUnmatchedBasicblocks = matches.getSizeOfUnmatchedBasicblocks(ESide.PRIMARY);
        final int sizeOfUnmatchedBasicblocks2 = matches.getSizeOfUnmatchedBasicblocks(ESide.SECONDARY);
        final PercentageTwoBarCellData percentageTwoBarCellData = new PercentageTwoBarCellData(sizeOfMatchedBasicblocks, sizeOfUnmatchedBasicblocks);
        final PercentageTwoBarCellData percentageTwoBarCellData2 = new PercentageTwoBarCellData(sizeOfMatchedBasicblocks, sizeOfUnmatchedBasicblocks2);
        this.primaryBasicblocks = new PercentageTwoBarLabel(percentageTwoBarCellData, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_PRIMARY_LABEL_BAR, 25);
        this.secondaryBasicblocks = new PercentageTwoBarLabel(percentageTwoBarCellData2, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_SECONDARY_LABEL_BAR, 25);
        final int sizeOfMatchedJumps = matches.getSizeOfMatchedJumps();
        final int sizeOfUnmatchedJumps = matches.getSizeOfUnmatchedJumps(ESide.PRIMARY);
        final int sizeOfUnmatchedJumps2 = matches.getSizeOfUnmatchedJumps(ESide.SECONDARY);
        final PercentageTwoBarCellData percentageTwoBarCellData3 = new PercentageTwoBarCellData(sizeOfMatchedJumps, sizeOfUnmatchedJumps);
        final PercentageTwoBarCellData percentageTwoBarCellData4 = new PercentageTwoBarCellData(sizeOfMatchedJumps, sizeOfUnmatchedJumps2);
        this.primaryJumps = new PercentageTwoBarLabel(percentageTwoBarCellData3, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_PRIMARY_LABEL_BAR, 25);
        this.secondaryJumps = new PercentageTwoBarLabel(percentageTwoBarCellData4, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_SECONDARY_LABEL_BAR, 25);
        final int sizeOfMatchedInstructions = matches.getSizeOfMatchedInstructions();
        final int sizeOfUnmatchedInstructions = matches.getSizeOfUnmatchedInstructions(ESide.PRIMARY);
        final int sizeOfUnmatchedInstructions2 = matches.getSizeOfUnmatchedInstructions(ESide.SECONDARY);
        final PercentageTwoBarCellData percentageTwoBarCellData5 = new PercentageTwoBarCellData(sizeOfMatchedInstructions, sizeOfUnmatchedInstructions);
        final PercentageTwoBarCellData percentageTwoBarCellData6 = new PercentageTwoBarCellData(sizeOfMatchedInstructions, sizeOfUnmatchedInstructions2);
        this.primaryInstructions = new PercentageTwoBarLabel(percentageTwoBarCellData5, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_PRIMARY_LABEL_BAR, 25);
        this.secondaryInstructions = new PercentageTwoBarLabel(percentageTwoBarCellData6, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_SECONDARY_LABEL_BAR, 25);
        final JLabel label = new JLabel(this.diff.getMetaData().getImageName(ESide.PRIMARY));
        final JLabel label2 = new JLabel(this.diff.getMetaData().getImageName(ESide.SECONDARY));
        final JPanel panel = new JPanel(new GridLayout(1, 2, 2, 2));
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new TitledBorder("Primary Call Graph"));
        final JPanel panel3 = new JPanel(new GridLayout(6, 1, 2, 2));
        panel3.setBorder(new LineBorder(Color.GRAY));
        panel3.setBackground(Color.WHITE);
        panel3.add(GuiUtils.createHorizontalNamedLabelPanel("Image Name", 100, label, 25));
        panel3.add(GuiUtils.createHorizontalNamedLabelPanel("Functions", 100, this.primaryFunctions, 25));
        panel3.add(GuiUtils.createHorizontalNamedLabelPanel("Calls", 100, this.primaryCalls, 25));
        panel3.add(GuiUtils.createHorizontalNamedLabelPanel("Basic Blocks", 100, this.primaryBasicblocks, 25));
        panel3.add(GuiUtils.createHorizontalNamedLabelPanel("Jumps", 100, this.primaryJumps, 25));
        panel3.add(GuiUtils.createHorizontalNamedLabelPanel("Instructions", 100, this.primaryInstructions, 25));
        panel2.add(panel3, "Center");
        final JPanel panel4 = new JPanel(new BorderLayout());
        panel4.setBorder(new TitledBorder("Secondary Call Graph"));
        final JPanel panel5 = new JPanel(new GridLayout(6, 1, 2, 2));
        panel5.setBorder(new LineBorder(Color.GRAY));
        panel5.setBackground(Color.WHITE);
        panel5.add(GuiUtils.createHorizontalNamedLabelPanel("Image Name", 100, label2, 25));
        panel5.add(GuiUtils.createHorizontalNamedLabelPanel("Functions", 100, this.secondaryFunctions, 25));
        panel5.add(GuiUtils.createHorizontalNamedLabelPanel("Calls", 100, this.secondaryCalls, 25));
        panel5.add(GuiUtils.createHorizontalNamedLabelPanel("Basic Blocks", 100, this.secondaryBasicblocks, 25));
        panel5.add(GuiUtils.createHorizontalNamedLabelPanel("Jumps", 100, this.secondaryJumps, 25));
        panel5.add(GuiUtils.createHorizontalNamedLabelPanel("Instructions", 100, this.secondaryInstructions, 25));
        panel4.add(panel5, "Center");
        panel.add(panel2);
        panel.add(panel4);
        return panel;
    }
    
    private JPanel createTablePanel() {
        this.callgraphTable.setPreferredSize(new Dimension(this.callgraphTable.getPreferredSize().width, 40));
        final JScrollPane scrollPane = new JScrollPane(this.callgraphTable);
        scrollPane.setVerticalScrollBarPolicy(21);
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder(String.format("%d Call Graph View", 1)));
        panel.add(scrollPane, "Center");
        panel.setPreferredSize(new Dimension(panel.getPreferredSize().width, 60));
        return panel;
    }
    
    private void init() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(this.createChartsPanel(), "North");
        panel.add(this.createInfoPanel(), "Center");
        panel.add(this.createTablePanel(), "South");
        this.add(panel, "North");
    }
    
    public void dipose() {
        this.diff.getMetaData().removeListener(this.countsChangeListener);
    }
    
    @Override
    public List getTables() {
        final ArrayList<CallGraphViewTable> list = new ArrayList<CallGraphViewTable>();
        list.add(this.callgraphTable);
        return list;
    }
}
