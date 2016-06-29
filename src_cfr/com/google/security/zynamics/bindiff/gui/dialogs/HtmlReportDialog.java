/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.components.LimitedTextField;
import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Window;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class HtmlReportDialog
extends BaseDialog {
    private static int DIALOG_WIDTH = 425;
    private static int DIALOG_HEIGHT = 560;
    private static int COMMENTPANEL_HEIGHT = 100;
    private final JTextField headline = new JTextField("HTML Report");
    private final LimitedTextField comment = new LimitedTextField("");
    private final JCheckBox showCharts = new JCheckBox("Show charts");
    private final JCheckBox showStatsTable = new JCheckBox("Show stats table");
    private final JCheckBox showMatchedFunctionsList = new JCheckBox("Show matched functions list");
    private final JCheckBox showPrimaryUnmatchedFunctionsList = new JCheckBox("Show primary unmatched functions list");
    private final JCheckBox showSecondaryUnmatchedFunctionsList = new JCheckBox("Show secondary unmatched functions list");
    private final JCheckBox showMatchedFunctionsIdenticalBasicblocks = new JCheckBox("Show identical basicblocks (of matched functions)");
    private final JCheckBox showMatchedFunctionsChangedBasicblocks = new JCheckBox("Show changed basicblocks (of matched functions)");
    private final JCheckBox showMatchedFunctionsUnmatchedBasicblocks = new JCheckBox("Show unmatched basicblocks of matched functions");
    private final JCheckBox showPrimaryUnmatchedFunctionsBasicblocks = new JCheckBox("Show primary basicblocks of unmatched functions");
    private final JCheckBox showSecondaryUnmatchedFunctionsBasicblocks = new JCheckBox("Show secondary basicblocks of unmatched functions");
    private final String fileNameAddition;

    public HtmlReportDialog(WorkspaceTabPanelFunctions workspaceTabPanelFunctions, Window window, Diff diff) {
        super(window, "HTML Report");
        this.fileNameAddition = "BinDiff HTML Report";
        this.init();
        this.pack();
        GuiHelper.centerChildToParent(window, this, true);
    }

    public HtmlReportDialog(WorkspaceTabPanelFunctions workspaceTabPanelFunctions, Window window, Diff diff, String string, String string2, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11) {
        super(window, "HTML Report");
        this.fileNameAddition = string;
        this.init();
        this.pack();
        GuiHelper.centerChildToParent(window, this, true);
        this.headline.setText(string2);
        this.showCharts.setSelected(bl2);
        this.showStatsTable.setSelected(bl3);
        this.showMatchedFunctionsList.setSelected(bl4);
        this.showPrimaryUnmatchedFunctionsList.setSelected(bl5);
        this.showSecondaryUnmatchedFunctionsList.setSelected(bl6);
        this.showMatchedFunctionsIdenticalBasicblocks.setSelected(bl7);
        this.showMatchedFunctionsChangedBasicblocks.setSelected(bl8);
        this.showMatchedFunctionsUnmatchedBasicblocks.setSelected(bl9);
        this.showPrimaryUnmatchedFunctionsBasicblocks.setSelected(bl10);
        this.showSecondaryUnmatchedFunctionsBasicblocks.setSelected(bl11);
    }

    private JPanel createBasicblocksPanel() {
        JPanel jPanel = new JPanel(new GridLayout(5, 1));
        jPanel.setBorder(new TitledBorder("Basic Blocks"));
        jPanel.add(this.showMatchedFunctionsIdenticalBasicblocks);
        jPanel.add(this.showMatchedFunctionsChangedBasicblocks);
        jPanel.add(this.showMatchedFunctionsUnmatchedBasicblocks);
        jPanel.add(this.showPrimaryUnmatchedFunctionsBasicblocks);
        jPanel.add(this.showSecondaryUnmatchedFunctionsBasicblocks);
        return jPanel;
    }

    private JPanel createButtonsPanel() {
        return new JPanel(new GridLayout(1, 2, 5, 5));
    }

    private JPanel createFunctionListsSettingsPanel() {
        JPanel jPanel = new JPanel(new GridLayout(3, 1));
        jPanel.setBorder(new TitledBorder("Function Lists"));
        jPanel.add(this.showMatchedFunctionsList);
        jPanel.add(this.showPrimaryUnmatchedFunctionsList);
        jPanel.add(this.showSecondaryUnmatchedFunctionsList);
        return jPanel;
    }

    private JPanel createHeadlinePanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new TitledBorder("Headline"));
        jPanel.add((Component)this.headline, "Center");
        return jPanel;
    }

    private JPanel createNotesPanel() {
        this.comment.setPreferredSize(new Dimension(this.comment.getPreferredSize().width, COMMENTPANEL_HEIGHT));
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new TitledBorder("Notes"));
        jPanel.add(new JScrollPane(this.comment));
        return jPanel;
    }

    private JPanel createStatsSettingsPanel() {
        JPanel jPanel = new JPanel(new GridLayout(2, 1));
        jPanel.setBorder(new TitledBorder("Statistics"));
        jPanel.add(this.showCharts);
        jPanel.add(this.showStatsTable);
        return jPanel;
    }

    private void init() {
        this.setSize(new Dimension(DIALOG_WIDTH, DIALOG_HEIGHT));
        this.setMinimumSize(new Dimension(DIALOG_WIDTH, DIALOG_HEIGHT));
        JPanel jPanel = new JPanel(new BorderLayout());
        JPanel jPanel2 = this.createHeadlinePanel();
        JPanel jPanel3 = this.createNotesPanel();
        JPanel jPanel4 = this.createStatsSettingsPanel();
        JPanel jPanel5 = this.createFunctionListsSettingsPanel();
        JPanel jPanel6 = this.createBasicblocksPanel();
        JPanel jPanel7 = this.createButtonsPanel();
        JPanel jPanel8 = new JPanel(new BorderLayout());
        JPanel jPanel9 = new JPanel(new BorderLayout());
        JPanel jPanel10 = new JPanel(new BorderLayout());
        JPanel jPanel11 = new JPanel(new BorderLayout());
        JPanel jPanel12 = new JPanel(new BorderLayout());
        jPanel8.add((Component)jPanel2, "North");
        jPanel8.add((Component)jPanel9, "Center");
        jPanel9.add((Component)jPanel3, "North");
        jPanel9.add((Component)jPanel10, "Center");
        jPanel10.add((Component)jPanel4, "North");
        jPanel10.add((Component)jPanel11, "Center");
        jPanel11.add((Component)jPanel5, "North");
        jPanel11.add((Component)jPanel12, "Center");
        jPanel12.add((Component)jPanel6, "North");
        jPanel.add((Component)jPanel8, "North");
        jPanel.add((Component)jPanel7, "South");
        this.getContentPane().add(jPanel);
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
}

