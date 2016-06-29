package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.components.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.zylib.gui.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.*;

public class HtmlReportDialog extends BaseDialog
{
    private static int DIALOG_WIDTH;
    private static int DIALOG_HEIGHT;
    private static int COMMENTPANEL_HEIGHT;
    private final JTextField headline;
    private final LimitedTextField comment;
    private final JCheckBox showCharts;
    private final JCheckBox showStatsTable;
    private final JCheckBox showMatchedFunctionsList;
    private final JCheckBox showPrimaryUnmatchedFunctionsList;
    private final JCheckBox showSecondaryUnmatchedFunctionsList;
    private final JCheckBox showMatchedFunctionsIdenticalBasicblocks;
    private final JCheckBox showMatchedFunctionsChangedBasicblocks;
    private final JCheckBox showMatchedFunctionsUnmatchedBasicblocks;
    private final JCheckBox showPrimaryUnmatchedFunctionsBasicblocks;
    private final JCheckBox showSecondaryUnmatchedFunctionsBasicblocks;
    private final String fileNameAddition;
    
    public HtmlReportDialog(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions, final Window window, final Diff diff) {
        super(window, "HTML Report");
        this.headline = new JTextField("HTML Report");
        this.comment = new LimitedTextField("");
        this.showCharts = new JCheckBox("Show charts");
        this.showStatsTable = new JCheckBox("Show stats table");
        this.showMatchedFunctionsList = new JCheckBox("Show matched functions list");
        this.showPrimaryUnmatchedFunctionsList = new JCheckBox("Show primary unmatched functions list");
        this.showSecondaryUnmatchedFunctionsList = new JCheckBox("Show secondary unmatched functions list");
        this.showMatchedFunctionsIdenticalBasicblocks = new JCheckBox("Show identical basicblocks (of matched functions)");
        this.showMatchedFunctionsChangedBasicblocks = new JCheckBox("Show changed basicblocks (of matched functions)");
        this.showMatchedFunctionsUnmatchedBasicblocks = new JCheckBox("Show unmatched basicblocks of matched functions");
        this.showPrimaryUnmatchedFunctionsBasicblocks = new JCheckBox("Show primary basicblocks of unmatched functions");
        this.showSecondaryUnmatchedFunctionsBasicblocks = new JCheckBox("Show secondary basicblocks of unmatched functions");
        this.fileNameAddition = "BinDiff HTML Report";
        this.init();
        this.pack();
        GuiHelper.centerChildToParent(window, this, true);
    }
    
    public HtmlReportDialog(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions, final Window window, final Diff diff, final String fileNameAddition, final String text, final boolean selected, final boolean selected2, final boolean selected3, final boolean selected4, final boolean selected5, final boolean selected6, final boolean selected7, final boolean selected8, final boolean selected9, final boolean selected10) {
        super(window, "HTML Report");
        this.headline = new JTextField("HTML Report");
        this.comment = new LimitedTextField("");
        this.showCharts = new JCheckBox("Show charts");
        this.showStatsTable = new JCheckBox("Show stats table");
        this.showMatchedFunctionsList = new JCheckBox("Show matched functions list");
        this.showPrimaryUnmatchedFunctionsList = new JCheckBox("Show primary unmatched functions list");
        this.showSecondaryUnmatchedFunctionsList = new JCheckBox("Show secondary unmatched functions list");
        this.showMatchedFunctionsIdenticalBasicblocks = new JCheckBox("Show identical basicblocks (of matched functions)");
        this.showMatchedFunctionsChangedBasicblocks = new JCheckBox("Show changed basicblocks (of matched functions)");
        this.showMatchedFunctionsUnmatchedBasicblocks = new JCheckBox("Show unmatched basicblocks of matched functions");
        this.showPrimaryUnmatchedFunctionsBasicblocks = new JCheckBox("Show primary basicblocks of unmatched functions");
        this.showSecondaryUnmatchedFunctionsBasicblocks = new JCheckBox("Show secondary basicblocks of unmatched functions");
        this.fileNameAddition = fileNameAddition;
        this.init();
        this.pack();
        GuiHelper.centerChildToParent(window, this, true);
        this.headline.setText(text);
        this.showCharts.setSelected(selected);
        this.showStatsTable.setSelected(selected2);
        this.showMatchedFunctionsList.setSelected(selected3);
        this.showPrimaryUnmatchedFunctionsList.setSelected(selected4);
        this.showSecondaryUnmatchedFunctionsList.setSelected(selected5);
        this.showMatchedFunctionsIdenticalBasicblocks.setSelected(selected6);
        this.showMatchedFunctionsChangedBasicblocks.setSelected(selected7);
        this.showMatchedFunctionsUnmatchedBasicblocks.setSelected(selected8);
        this.showPrimaryUnmatchedFunctionsBasicblocks.setSelected(selected9);
        this.showSecondaryUnmatchedFunctionsBasicblocks.setSelected(selected10);
    }
    
    private JPanel createBasicblocksPanel() {
        final JPanel panel = new JPanel(new GridLayout(5, 1));
        panel.setBorder(new TitledBorder("Basic Blocks"));
        panel.add(this.showMatchedFunctionsIdenticalBasicblocks);
        panel.add(this.showMatchedFunctionsChangedBasicblocks);
        panel.add(this.showMatchedFunctionsUnmatchedBasicblocks);
        panel.add(this.showPrimaryUnmatchedFunctionsBasicblocks);
        panel.add(this.showSecondaryUnmatchedFunctionsBasicblocks);
        return panel;
    }
    
    private JPanel createButtonsPanel() {
        return new JPanel(new GridLayout(1, 2, 5, 5));
    }
    
    private JPanel createFunctionListsSettingsPanel() {
        final JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.setBorder(new TitledBorder("Function Lists"));
        panel.add(this.showMatchedFunctionsList);
        panel.add(this.showPrimaryUnmatchedFunctionsList);
        panel.add(this.showSecondaryUnmatchedFunctionsList);
        return panel;
    }
    
    private JPanel createHeadlinePanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder("Headline"));
        panel.add(this.headline, "Center");
        return panel;
    }
    
    private JPanel createNotesPanel() {
        this.comment.setPreferredSize(new Dimension(this.comment.getPreferredSize().width, HtmlReportDialog.COMMENTPANEL_HEIGHT));
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder("Notes"));
        panel.add(new JScrollPane(this.comment));
        return panel;
    }
    
    private JPanel createStatsSettingsPanel() {
        final JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.setBorder(new TitledBorder("Statistics"));
        panel.add(this.showCharts);
        panel.add(this.showStatsTable);
        return panel;
    }
    
    private void init() {
        this.setSize(new Dimension(HtmlReportDialog.DIALOG_WIDTH, HtmlReportDialog.DIALOG_HEIGHT));
        this.setMinimumSize(new Dimension(HtmlReportDialog.DIALOG_WIDTH, HtmlReportDialog.DIALOG_HEIGHT));
        final JPanel panel = new JPanel(new BorderLayout());
        final JPanel headlinePanel = this.createHeadlinePanel();
        final JPanel notesPanel = this.createNotesPanel();
        final JPanel statsSettingsPanel = this.createStatsSettingsPanel();
        final JPanel functionListsSettingsPanel = this.createFunctionListsSettingsPanel();
        final JPanel basicblocksPanel = this.createBasicblocksPanel();
        final JPanel buttonsPanel = this.createButtonsPanel();
        final JPanel panel2 = new JPanel(new BorderLayout());
        final JPanel panel3 = new JPanel(new BorderLayout());
        final JPanel panel4 = new JPanel(new BorderLayout());
        final JPanel panel5 = new JPanel(new BorderLayout());
        final JPanel panel6 = new JPanel(new BorderLayout());
        panel2.add(headlinePanel, "North");
        panel2.add(panel3, "Center");
        panel3.add(notesPanel, "North");
        panel3.add(panel4, "Center");
        panel4.add(statsSettingsPanel, "North");
        panel4.add(panel5, "Center");
        panel5.add(functionListsSettingsPanel, "North");
        panel5.add(panel6, "Center");
        panel6.add(basicblocksPanel, "North");
        panel.add(panel2, "North");
        panel.add(buttonsPanel, "South");
        this.getContentPane().add(panel);
    }
    
    @Override
    public void dispose() {
        this.setVisible(false);
        super.dispose();
    }
    
    public String getComment() {
        return this.comment.getText();
    }
    
    public String getFileNameAddition() {
        return this.fileNameAddition;
    }
    
    public String getHeadline() {
        return this.headline.getText();
    }
    
    public boolean getShowChangedBasicblocks() {
        return this.showMatchedFunctionsChangedBasicblocks.isSelected();
    }
    
    public boolean getShowCharts() {
        return this.showCharts.isSelected();
    }
    
    public boolean getShowIdenticalBasicblocks() {
        return this.showMatchedFunctionsIdenticalBasicblocks.isSelected();
    }
    
    public boolean getShowMatchedFunctionsList() {
        return this.showMatchedFunctionsList.isSelected();
    }
    
    public boolean getShowPrimaryUnmatchedBasicblocksOfUmatchedFunctions() {
        return this.showPrimaryUnmatchedFunctionsBasicblocks.isSelected();
    }
    
    public boolean getShowPrimaryUnmatchedFunctionsList() {
        return this.showPrimaryUnmatchedFunctionsList.isSelected();
    }
    
    public boolean getShowSecondaryUnmatchedBasicblocksOfUnmatchedFunctions() {
        return this.showSecondaryUnmatchedFunctionsBasicblocks.isSelected();
    }
    
    public boolean getShowSecondaryUnmatchedFunctionsList() {
        return this.showSecondaryUnmatchedFunctionsList.isSelected();
    }
    
    public boolean getShowStatsTablel() {
        return this.showStatsTable.isSelected();
    }
    
    public boolean getShowUnmatchedBasicblocksOfMatchedFunctions() {
        return this.showMatchedFunctionsUnmatchedBasicblocks.isSelected();
    }
    
    static {
        HtmlReportDialog.DIALOG_WIDTH = 425;
        HtmlReportDialog.DIALOG_HEIGHT = 560;
        HtmlReportDialog.COMMENTPANEL_HEIGHT = 100;
    }
}
