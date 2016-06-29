/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.database.MatchesDatabase;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.AbstractTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel$InternalDescriptionFocusListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel$InternalKeyListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel$InternalTimerListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.FunctionMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.SimilarityBarChart2dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarLabel;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.gui.CPathLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class DiffTreeNodeContextPanel
extends AbstractTreeNodeContextPanel {
    private static final int TEXTFIELDHEIGHT = 25;
    private static final int TEXTFIELDLABELWIDTH = 100;
    private final DiffTreeNodeContextPanel$InternalDescriptionFocusListener focusListener;
    private final DiffTreeNodeContextPanel$InternalKeyListener keyListener;
    private final DiffTreeNodeContextPanel$InternalTimerListener timerListener;
    private final CPathLabel diffPath;
    private final JTextField creationDate;
    private final JTextField primaryIDBName;
    private final JTextField primaryImageName;
    private final JTextField primaryImageHash;
    private final JTextField primaryArchitectureName;
    private final JTextField secondaryIDBName;
    private final JTextField secondaryImageName;
    private final JTextField secondaryImageHash;
    private final JTextField secondaryArchitectureName;
    private final JTextArea description;
    private final PercentageTwoBarLabel primaryFunctions;
    private final PercentageTwoBarLabel secondaryFunctions;
    private final Timer timer;
    private final Diff diff;
    private final TitledBorder descriptionBorder;
    private final WorkspaceTabPanelFunctions controller;

    public DiffTreeNodeContextPanel(Diff diff, WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.focusListener = new DiffTreeNodeContextPanel$InternalDescriptionFocusListener(this, null);
        this.keyListener = new DiffTreeNodeContextPanel$InternalKeyListener(this, null);
        this.timerListener = new DiffTreeNodeContextPanel$InternalTimerListener(this, null);
        this.timer = new Timer(3500, this.timerListener);
        this.descriptionBorder = new TitledBorder("Description");
        this.diff = (Diff)Preconditions.checkNotNull(diff);
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        DiffMetaData diffMetaData = diff.getMetaData();
        this.creationDate = new JTextField(diffMetaData.getDateString());
        Object[] arrobject = new Object[2];
        arrobject[0] = diffMetaData.getIdbName(ESide.PRIMARY);
        arrobject[1] = diffMetaData.getAddressSpace(ESide.PRIMARY) == 0 ? "?" : Integer.valueOf(diffMetaData.getAddressSpace(ESide.PRIMARY));
        this.primaryIDBName = new JTextField(String.format("%s (%sBit)", arrobject));
        this.primaryImageName = new JTextField(diffMetaData.getImageName(ESide.PRIMARY));
        this.primaryImageHash = new JTextField(diffMetaData.getImageHash(ESide.PRIMARY));
        this.primaryArchitectureName = new JTextField(diffMetaData.getArchitectureName(ESide.PRIMARY));
        Object[] arrobject2 = new Object[2];
        arrobject2[0] = diffMetaData.getIdbName(ESide.SECONDARY);
        arrobject2[1] = diffMetaData.getAddressSpace(ESide.SECONDARY) == 0 ? "?" : Integer.valueOf(diffMetaData.getAddressSpace(ESide.SECONDARY));
        this.secondaryIDBName = new JTextField(String.format("%s (%sBit)", arrobject2));
        this.secondaryImageName = new JTextField(diffMetaData.getImageName(ESide.SECONDARY));
        this.secondaryImageHash = new JTextField(diffMetaData.getImageHash(ESide.SECONDARY));
        this.secondaryArchitectureName = new JTextField(diffMetaData.getArchitectureName(ESide.SECONDARY));
        int n2 = diffMetaData.getSizeOfMatchedFunctions();
        PercentageTwoBarCellData percentageTwoBarCellData = new PercentageTwoBarCellData(n2, diffMetaData.getSizeOfUnmatchedFunctions(ESide.PRIMARY));
        PercentageTwoBarCellData percentageTwoBarCellData2 = new PercentageTwoBarCellData(n2, diffMetaData.getSizeOfUnmatchedFunctions(ESide.SECONDARY));
        this.primaryFunctions = new PercentageTwoBarLabel(percentageTwoBarCellData, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_PRIMARY_LABEL_BAR, 25);
        this.secondaryFunctions = new PercentageTwoBarLabel(percentageTwoBarCellData2, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_SECONDARY_LABEL_BAR, 25);
        this.diffPath = new CPathLabel(diff.getMatchesDatabase().getPath());
        this.description = new JTextArea(diffMetaData.getDiffDescription());
        this.description.addFocusListener(this.focusListener);
        this.description.addKeyListener(this.keyListener);
        this.initComponents();
        this.loadDescription();
    }

    private JPanel createDescriptionPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(this.descriptionBorder);
        jPanel.add((Component)new JScrollPane(this.description), "Center");
        return jPanel;
    }

    private JPanel createDiffInfoPanel() {
        JPanel jPanel = new JPanel(new GridLayout(1, 2, 2, 2));
        JPanel jPanel2 = new JPanel(new BorderLayout());
        JPanel jPanel3 = new JPanel(new BorderLayout());
        JPanel jPanel4 = new JPanel(new GridLayout(5, 1, 2, 2));
        JPanel jPanel5 = new JPanel(new GridLayout(5, 1, 2, 2));
        jPanel2.setBorder(new TitledBorder("Primary Image"));
        jPanel3.setBorder(new TitledBorder("Secondary Image"));
        jPanel4.setBorder(new LineBorder(Color.GRAY));
        jPanel5.setBorder(new LineBorder(Color.GRAY));
        jPanel4.setBackground(Color.WHITE);
        jPanel5.setBackground(Color.WHITE);
        jPanel4.add(GuiUtils.createHorizontalNamedLabelPanel("IDB Name", 100, this.primaryIDBName, 25));
        jPanel4.add(GuiUtils.createHorizontalNamedLabelPanel("Image Name", 100, this.primaryImageName, 25));
        jPanel4.add(GuiUtils.createHorizontalNamedLabelPanel("Hash", 100, this.primaryImageHash, 25));
        jPanel4.add(GuiUtils.createHorizontalNamedLabelPanel("Architecture", 100, this.primaryArchitectureName, 25));
        jPanel4.add(GuiUtils.createHorizontalNamedLabelPanel("Functions", 100, this.primaryFunctions, 25));
        jPanel5.add(GuiUtils.createHorizontalNamedLabelPanel("IDB Name", 100, this.secondaryIDBName, 25));
        jPanel5.add(GuiUtils.createHorizontalNamedLabelPanel("Image Name", 100, this.secondaryImageName, 25));
        jPanel5.add(GuiUtils.createHorizontalNamedLabelPanel("Hash", 100, this.secondaryImageHash, 25));
        jPanel5.add(GuiUtils.createHorizontalNamedLabelPanel("Architecture", 100, this.secondaryArchitectureName, 25));
        jPanel5.add(GuiUtils.createHorizontalNamedLabelPanel("Functions", 100, this.secondaryFunctions, 25));
        jPanel2.add((Component)jPanel4, "Center");
        jPanel3.add((Component)jPanel5, "Center");
        jPanel.add(jPanel2);
        jPanel.add(jPanel3);
        return jPanel;
    }

    private JPanel createOverviewPanel() {
        DiffMetaData diffMetaData = this.diff.getMetaData();
        JPanel jPanel = new JPanel(new BorderLayout(0, 0));
        jPanel.setBorder(new CompoundBorder(new TitledBorder("Overview"), new LineBorder(Color.GRAY)));
        JPanel jPanel2 = new JPanel(new GridLayout(1, 1, 0, 0));
        jPanel.add((Component)jPanel2, "Center");
        jPanel2.add(new FunctionMatchesPie3dPanel(diffMetaData));
        jPanel2.add(new SimilarityBarChart2dPanel(diffMetaData));
        JPanel jPanel3 = new JPanel(new GridLayout(2, 1, 2, 2));
        jPanel3.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        jPanel3.setBackground(Color.WHITE);
        jPanel3.add(GuiUtils.createHorizontalNamedLabelPanel("Diff Path", 100, this.diffPath, 25));
        jPanel3.add(GuiUtils.createHorizontalNamedLabelPanel("File Date", 100, this.creationDate, 25));
        JPanel jPanel4 = new JPanel(new BorderLayout());
        jPanel4.setBorder(new TitledBorder("Diff Info"));
        jPanel4.add((Component)jPanel3, "Center");
        JPanel jPanel5 = new JPanel(new BorderLayout());
        jPanel5.add((Component)jPanel, "Center");
        jPanel5.add((Component)jPanel4, "South");
        return jPanel5;
    }

    private void initComponents() {
        this.diffPath.setPreferredSize(new Dimension(this.diffPath.getPreferredSize().width, 25));
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add((Component)this.createOverviewPanel(), "Center");
        jPanel.add((Component)this.createDiffInfoPanel(), "South");
        this.add((Component)jPanel, "North");
        this.add((Component)this.createDescriptionPanel(), "Center");
    }

    private void loadDescription() {
        MatchesDatabase matchesDatabase = null;
        try {
            matchesDatabase = new MatchesDatabase(this.diff.getMatchesDatabase());
            this.description.setText(matchesDatabase.loadDiffDescription());
            return;
        }
        catch (SQLException var2_2) {
            Logger.logException(var2_2, "Load diff description failed.");
        }
    }

    private void saveDescription() {
        if (!this.controller.saveDescription(this.diff, this.description.getText())) return;
        this.descriptionBorder.setTitleColor(Colors.JUMP_CONDITIONAL_FALSE);
        this.descriptionBorder.setTitle("Saved description");
        this.updateUI();
        this.timer.start();
    }

    public void dispose() {
        this.description.removeFocusListener(this.focusListener);
        this.description.removeKeyListener(this.keyListener);
    }

    @Override
    public List getTables() {
        return null;
    }

    static /* synthetic */ void access$300(DiffTreeNodeContextPanel diffTreeNodeContextPanel) {
        diffTreeNodeContextPanel.saveDescription();
    }

    static /* synthetic */ TitledBorder access$400(DiffTreeNodeContextPanel diffTreeNodeContextPanel) {
        return diffTreeNodeContextPanel.descriptionBorder;
    }

    static /* synthetic */ Timer access$500(DiffTreeNodeContextPanel diffTreeNodeContextPanel) {
        return diffTreeNodeContextPanel.timer;
    }
}

