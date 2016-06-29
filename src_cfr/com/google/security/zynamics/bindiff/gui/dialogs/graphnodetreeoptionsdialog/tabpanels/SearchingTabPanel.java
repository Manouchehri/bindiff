/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabpanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SearchingTabPanel
extends JPanel {
    private final JCheckBox regExCheckBox = new JCheckBox("Regular Expression");
    private final JCheckBox caseSensitiveCheckBox = new JCheckBox("Case Sensitive");
    private final JCheckBox primarySideCheckBox = new JCheckBox("Primary Side");
    private final JCheckBox secondarySideCheckBox = new JCheckBox("Secondary Side");
    private final JCheckBox useTempResultsCheckBox = new JCheckBox("Search in last temporary Results");
    private final JCheckBox hightlightGraphNodesCheckBox = new JCheckBox("Highlight Graph Nodes");
    private boolean initialRegEx;
    private boolean initialCaseSensitive;
    private boolean initialPrimarySide;
    private boolean initialSecondarySide;
    private boolean initialHighlightGraphNode;
    private boolean initialUseTempResults;

    public SearchingTabPanel(boolean bl2) {
        super(new BorderLayout());
        this.add((Component)this.createPanel(bl2), "Center");
        this.setDefaults();
    }

    private JPanel createPanel(boolean bl2) {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new LineBorder(Color.GRAY));
        JPanel jPanel2 = new JPanel(new BorderLayout());
        JPanel jPanel3 = new JPanel(new GridLayout(bl2 ? 4 : 2, 1));
        jPanel3.setBorder(new TitledBorder("Search Options"));
        jPanel3.add(this.regExCheckBox);
        jPanel3.add(this.caseSensitiveCheckBox);
        if (bl2) {
            jPanel3.add(this.primarySideCheckBox);
            jPanel3.add(this.secondarySideCheckBox);
        }
        JPanel jPanel4 = new JPanel(new BorderLayout());
        JPanel jPanel5 = new JPanel(new GridLayout(2, 1));
        jPanel5.setBorder(new TitledBorder("Result options"));
        jPanel5.add(this.useTempResultsCheckBox);
        jPanel5.add(this.hightlightGraphNodesCheckBox);
        jPanel2.add((Component)jPanel3, "North");
        jPanel4.add((Component)jPanel5, "North");
        jPanel.add((Component)jPanel2, "North");
        jPanel.add((Component)jPanel4, "Center");
        return jPanel;
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

