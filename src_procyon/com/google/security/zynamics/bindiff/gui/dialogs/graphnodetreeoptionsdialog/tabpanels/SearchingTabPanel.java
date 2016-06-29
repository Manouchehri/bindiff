package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabpanels;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class SearchingTabPanel extends JPanel
{
    private final JCheckBox regExCheckBox;
    private final JCheckBox caseSensitiveCheckBox;
    private final JCheckBox primarySideCheckBox;
    private final JCheckBox secondarySideCheckBox;
    private final JCheckBox useTempResultsCheckBox;
    private final JCheckBox hightlightGraphNodesCheckBox;
    private boolean initialRegEx;
    private boolean initialCaseSensitive;
    private boolean initialPrimarySide;
    private boolean initialSecondarySide;
    private boolean initialHighlightGraphNode;
    private boolean initialUseTempResults;
    
    public SearchingTabPanel(final boolean b) {
        super(new BorderLayout());
        this.regExCheckBox = new JCheckBox("Regular Expression");
        this.caseSensitiveCheckBox = new JCheckBox("Case Sensitive");
        this.primarySideCheckBox = new JCheckBox("Primary Side");
        this.secondarySideCheckBox = new JCheckBox("Secondary Side");
        this.useTempResultsCheckBox = new JCheckBox("Search in last temporary Results");
        this.hightlightGraphNodesCheckBox = new JCheckBox("Highlight Graph Nodes");
        this.add(this.createPanel(b), "Center");
        this.setDefaults();
    }
    
    private JPanel createPanel(final boolean b) {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new LineBorder(Color.GRAY));
        final JPanel panel2 = new JPanel(new BorderLayout());
        final JPanel panel3 = new JPanel(new GridLayout(b ? 4 : 2, 1));
        panel3.setBorder(new TitledBorder("Search Options"));
        panel3.add(this.regExCheckBox);
        panel3.add(this.caseSensitiveCheckBox);
        if (b) {
            panel3.add(this.primarySideCheckBox);
            panel3.add(this.secondarySideCheckBox);
        }
        final JPanel panel4 = new JPanel(new BorderLayout());
        final JPanel panel5 = new JPanel(new GridLayout(2, 1));
        panel5.setBorder(new TitledBorder("Result options"));
        panel5.add(this.useTempResultsCheckBox);
        panel5.add(this.hightlightGraphNodesCheckBox);
        panel2.add(panel3, "North");
        panel4.add(panel5, "North");
        panel.add(panel2, "North");
        panel.add(panel4, "Center");
        return panel;
    }
    
    public boolean getCaseSensitive() {
        return this.caseSensitiveCheckBox.isSelected();
    }
    
    public boolean getHighlightGraphNodes() {
        return this.hightlightGraphNodesCheckBox.isSelected();
    }
    
    public boolean getPrimarySide() {
        return this.primarySideCheckBox.isSelected();
    }
    
    public boolean getRegEx() {
        return this.regExCheckBox.isSelected();
    }
    
    public boolean getSecondarySide() {
        return this.secondarySideCheckBox.isSelected();
    }
    
    public boolean getUseTemporaryResult() {
        return this.useTempResultsCheckBox.isSelected();
    }
    
    public void restoreInitialSettings() {
        this.regExCheckBox.setSelected(this.initialRegEx);
        this.caseSensitiveCheckBox.setSelected(this.initialCaseSensitive);
        this.primarySideCheckBox.setSelected(this.initialPrimarySide);
        this.secondarySideCheckBox.setSelected(this.initialSecondarySide);
        this.hightlightGraphNodesCheckBox.setSelected(this.initialHighlightGraphNode);
        this.useTempResultsCheckBox.setSelected(this.initialUseTempResults);
    }
    
    public void setDefaults() {
        this.regExCheckBox.setSelected(false);
        this.caseSensitiveCheckBox.setSelected(false);
        this.primarySideCheckBox.setSelected(true);
        this.secondarySideCheckBox.setSelected(true);
        this.hightlightGraphNodesCheckBox.setSelected(true);
        this.useTempResultsCheckBox.setSelected(false);
    }
    
    public void storeInitialSettings() {
        this.initialRegEx = this.getRegEx();
        this.initialCaseSensitive = this.getCaseSensitive();
        this.initialPrimarySide = this.getPrimarySide();
        this.initialSecondarySide = this.getSecondarySide();
        this.initialHighlightGraphNode = this.getHighlightGraphNodes();
        this.initialUseTempResults = this.getUseTemporaryResult();
    }
}
