package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.*;
import com.google.security.zynamics.bindiff.resources.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.database.*;
import com.google.security.zynamics.bindiff.log.*;
import java.sql.*;
import java.util.*;

public class DiffTreeNodeContextPanel extends AbstractTreeNodeContextPanel
{
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
    
    public DiffTreeNodeContextPanel(final Diff diff, final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.focusListener = new DiffTreeNodeContextPanel$InternalDescriptionFocusListener(this, null);
        this.keyListener = new DiffTreeNodeContextPanel$InternalKeyListener(this, null);
        this.timerListener = new DiffTreeNodeContextPanel$InternalTimerListener(this, null);
        this.timer = new Timer(3500, this.timerListener);
        this.descriptionBorder = new TitledBorder("Description");
        this.diff = (Diff)Preconditions.checkNotNull(diff);
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        final DiffMetaData metaData = diff.getMetaData();
        this.creationDate = new JTextField(metaData.getDateString());
        this.primaryIDBName = new JTextField(String.format("%s (%sBit)", metaData.getIdbName(ESide.PRIMARY), (metaData.getAddressSpace(ESide.PRIMARY) == 0) ? "?" : metaData.getAddressSpace(ESide.PRIMARY)));
        this.primaryImageName = new JTextField(metaData.getImageName(ESide.PRIMARY));
        this.primaryImageHash = new JTextField(metaData.getImageHash(ESide.PRIMARY));
        this.primaryArchitectureName = new JTextField(metaData.getArchitectureName(ESide.PRIMARY));
        this.secondaryIDBName = new JTextField(String.format("%s (%sBit)", metaData.getIdbName(ESide.SECONDARY), (metaData.getAddressSpace(ESide.SECONDARY) == 0) ? "?" : metaData.getAddressSpace(ESide.SECONDARY)));
        this.secondaryImageName = new JTextField(metaData.getImageName(ESide.SECONDARY));
        this.secondaryImageHash = new JTextField(metaData.getImageHash(ESide.SECONDARY));
        this.secondaryArchitectureName = new JTextField(metaData.getArchitectureName(ESide.SECONDARY));
        final int sizeOfMatchedFunctions = metaData.getSizeOfMatchedFunctions();
        final PercentageTwoBarCellData percentageTwoBarCellData = new PercentageTwoBarCellData(sizeOfMatchedFunctions, metaData.getSizeOfUnmatchedFunctions(ESide.PRIMARY));
        final PercentageTwoBarCellData percentageTwoBarCellData2 = new PercentageTwoBarCellData(sizeOfMatchedFunctions, metaData.getSizeOfUnmatchedFunctions(ESide.SECONDARY));
        this.primaryFunctions = new PercentageTwoBarLabel(percentageTwoBarCellData, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_PRIMARY_LABEL_BAR, 25);
        this.secondaryFunctions = new PercentageTwoBarLabel(percentageTwoBarCellData2, Colors.MATCHED_LABEL_BAR, Colors.UNMATCHED_SECONDARY_LABEL_BAR, 25);
        this.diffPath = new CPathLabel(diff.getMatchesDatabase().getPath());
        (this.description = new JTextArea(metaData.getDiffDescription())).addFocusListener(this.focusListener);
        this.description.addKeyListener(this.keyListener);
        this.initComponents();
        this.loadDescription();
    }
    
    private JPanel createDescriptionPanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(this.descriptionBorder);
        panel.add(new JScrollPane(this.description), "Center");
        return panel;
    }
    
    private JPanel createDiffInfoPanel() {
        final JPanel panel = new JPanel(new GridLayout(1, 2, 2, 2));
        final JPanel panel2 = new JPanel(new BorderLayout());
        final JPanel panel3 = new JPanel(new BorderLayout());
        final JPanel panel4 = new JPanel(new GridLayout(5, 1, 2, 2));
        final JPanel panel5 = new JPanel(new GridLayout(5, 1, 2, 2));
        panel2.setBorder(new TitledBorder("Primary Image"));
        panel3.setBorder(new TitledBorder("Secondary Image"));
        panel4.setBorder(new LineBorder(Color.GRAY));
        panel5.setBorder(new LineBorder(Color.GRAY));
        panel4.setBackground(Color.WHITE);
        panel5.setBackground(Color.WHITE);
        panel4.add(GuiUtils.createHorizontalNamedLabelPanel("IDB Name", 100, this.primaryIDBName, 25));
        panel4.add(GuiUtils.createHorizontalNamedLabelPanel("Image Name", 100, this.primaryImageName, 25));
        panel4.add(GuiUtils.createHorizontalNamedLabelPanel("Hash", 100, this.primaryImageHash, 25));
        panel4.add(GuiUtils.createHorizontalNamedLabelPanel("Architecture", 100, this.primaryArchitectureName, 25));
        panel4.add(GuiUtils.createHorizontalNamedLabelPanel("Functions", 100, this.primaryFunctions, 25));
        panel5.add(GuiUtils.createHorizontalNamedLabelPanel("IDB Name", 100, this.secondaryIDBName, 25));
        panel5.add(GuiUtils.createHorizontalNamedLabelPanel("Image Name", 100, this.secondaryImageName, 25));
        panel5.add(GuiUtils.createHorizontalNamedLabelPanel("Hash", 100, this.secondaryImageHash, 25));
        panel5.add(GuiUtils.createHorizontalNamedLabelPanel("Architecture", 100, this.secondaryArchitectureName, 25));
        panel5.add(GuiUtils.createHorizontalNamedLabelPanel("Functions", 100, this.secondaryFunctions, 25));
        panel2.add(panel4, "Center");
        panel3.add(panel5, "Center");
        panel.add(panel2);
        panel.add(panel3);
        return panel;
    }
    
    private JPanel createOverviewPanel() {
        final DiffMetaData metaData = this.diff.getMetaData();
        final JPanel panel = new JPanel(new BorderLayout(0, 0));
        panel.setBorder(new CompoundBorder(new TitledBorder("Overview"), new LineBorder(Color.GRAY)));
        final JPanel panel2 = new JPanel(new GridLayout(1, 1, 0, 0));
        panel.add(panel2, "Center");
        panel2.add(new FunctionMatchesPie3dPanel(metaData));
        panel2.add(new SimilarityBarChart2dPanel(metaData));
        final JPanel panel3 = new JPanel(new GridLayout(2, 1, 2, 2));
        panel3.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel3.setBackground(Color.WHITE);
        panel3.add(GuiUtils.createHorizontalNamedLabelPanel("Diff Path", 100, this.diffPath, 25));
        panel3.add(GuiUtils.createHorizontalNamedLabelPanel("File Date", 100, this.creationDate, 25));
        final JPanel panel4 = new JPanel(new BorderLayout());
        panel4.setBorder(new TitledBorder("Diff Info"));
        panel4.add(panel3, "Center");
        final JPanel panel5 = new JPanel(new BorderLayout());
        panel5.add(panel, "Center");
        panel5.add(panel4, "South");
        return panel5;
    }
    
    private void initComponents() {
        this.diffPath.setPreferredSize(new Dimension(this.diffPath.getPreferredSize().width, 25));
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(this.createOverviewPanel(), "Center");
        panel.add(this.createDiffInfoPanel(), "South");
        this.add(panel, "North");
        this.add(this.createDescriptionPanel(), "Center");
    }
    
    private void loadDescription() {
        try {
            this.description.setText(new MatchesDatabase(this.diff.getMatchesDatabase()).loadDiffDescription());
        }
        catch (SQLException ex) {
            Logger.logException(ex, "Load diff description failed.");
        }
    }
    
    private void saveDescription() {
        if (this.controller.saveDescription(this.diff, this.description.getText())) {
            this.descriptionBorder.setTitleColor(Colors.JUMP_CONDITIONAL_FALSE);
            this.descriptionBorder.setTitle("Saved description");
            this.updateUI();
            this.timer.start();
        }
    }
    
    public void dispose() {
        this.description.removeFocusListener(this.focusListener);
        this.description.removeKeyListener(this.keyListener);
    }
    
    @Override
    public List getTables() {
        return null;
    }
}
