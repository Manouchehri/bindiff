/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSearcher;
import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.GraphSearchOptionsDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.GraphSearchOptionsDialog$InternalButtonListener;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class GraphSearchOptionsDialog
extends BaseDialog {
    private final GraphSearchOptionsDialog$InternalButtonListener buttonListener;
    private final JCheckBox regEx;
    private final JCheckBox caseSensitive;
    private final JCheckBox visibleOnly;
    private final JCheckBox selectedOnly;
    private final JButton okButton;
    private final JButton cancelButton;
    private final JButton setDefaultsButton;
    private final GraphSearcher searcher;
    private boolean originalRegEx;
    private boolean originalCaseSensitive;
    private boolean originalVisibleOnly;
    private boolean originalSelectedOnly;

    public GraphSearchOptionsDialog(Window window, BinDiffGraph binDiffGraph) {
        super(window, "Search Options");
        this.buttonListener = new GraphSearchOptionsDialog$InternalButtonListener(this, null);
        this.regEx = new JCheckBox("Regular Expression");
        this.caseSensitive = new JCheckBox("Case Sensitive");
        this.visibleOnly = new JCheckBox("Visible Only");
        this.selectedOnly = new JCheckBox("Selected Only");
        this.okButton = new JButton("Ok");
        this.cancelButton = new JButton("Cancel");
        this.setDefaultsButton = new JButton("Set Defaults");
        Preconditions.checkNotNull(binDiffGraph);
        this.setModal(true);
        this.setLayout(new BorderLayout());
        this.searcher = binDiffGraph.getGraphSearcher();
        this.regEx.setSelected(this.searcher.isRegEx());
        this.caseSensitive.setSelected(this.searcher.isCaseSensitive());
        this.visibleOnly.setSelected(this.searcher.isVisibleOnly());
        this.selectedOnly.setSelected(this.searcher.isSelectedOnly());
        this.okButton.addActionListener(this.buttonListener);
        this.cancelButton.addActionListener(this.buttonListener);
        this.setDefaultsButton.addActionListener(this.buttonListener);
        this.init();
        this.pack();
        this.setMinimumSize(this.getSize());
        GuiHelper.centerChildToParent(window, this, true);
    }

    private JPanel createButtonsPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(10, 5, 5, 5));
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.add((Component)this.setDefaultsButton, "West");
        JPanel jPanel3 = new JPanel(new GridLayout(1, 2, 5, 5));
        jPanel3.add(this.okButton);
        jPanel3.add(this.cancelButton);
        jPanel.add((Component)jPanel2, "West");
        jPanel.add((Component)jPanel3, "East");
        return jPanel;
    }

    private JPanel createOptionsPanel() {
        JPanel jPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel jPanel2 = new JPanel(new GridLayout(2, 1));
        jPanel2.setBorder(new TitledBorder(""));
        jPanel2.add(this.regEx);
        jPanel2.add(this.caseSensitive);
        JPanel jPanel3 = new JPanel(new GridLayout(2, 1));
        jPanel3.setBorder(new TitledBorder(""));
        jPanel3.add(this.visibleOnly);
        jPanel3.add(this.selectedOnly);
        jPanel.add(jPanel2);
        jPanel.add(jPanel3);
        return jPanel;
    }

    private void init() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new TitledBorder(""));
        jPanel.add((Component)this.createOptionsPanel(), "North");
        jPanel.add((Component)this.createButtonsPanel(), "South");
        this.add((Component)jPanel, "Center");
    }

    @Override
    public void setVisible(boolean bl2) {
        if (bl2) {
            this.originalRegEx = this.regEx.isSelected();
            this.originalCaseSensitive = this.caseSensitive.isSelected();
            this.originalVisibleOnly = this.visibleOnly.isSelected();
            this.originalSelectedOnly = this.selectedOnly.isSelected();
        }
        super.setVisible(bl2);
    }

    static /* synthetic */ JButton access$100(GraphSearchOptionsDialog graphSearchOptionsDialog) {
        return graphSearchOptionsDialog.setDefaultsButton;
    }

    static /* synthetic */ GraphSearcher access$200(GraphSearchOptionsDialog graphSearchOptionsDialog) {
        return graphSearchOptionsDialog.searcher;
    }

    static /* synthetic */ JCheckBox access$300(GraphSearchOptionsDialog graphSearchOptionsDialog) {
        return graphSearchOptionsDialog.regEx;
    }

    static /* synthetic */ JCheckBox access$400(GraphSearchOptionsDialog graphSearchOptionsDialog) {
        return graphSearchOptionsDialog.caseSensitive;
    }

    static /* synthetic */ JCheckBox access$500(GraphSearchOptionsDialog graphSearchOptionsDialog) {
        return graphSearchOptionsDialog.selectedOnly;
    }

    static /* synthetic */ JCheckBox access$600(GraphSearchOptionsDialog graphSearchOptionsDialog) {
        return graphSearchOptionsDialog.visibleOnly;
    }

    static /* synthetic */ JButton access$700(GraphSearchOptionsDialog graphSearchOptionsDialog) {
        return graphSearchOptionsDialog.okButton;
    }

    static /* synthetic */ JButton access$800(GraphSearchOptionsDialog graphSearchOptionsDialog) {
        return graphSearchOptionsDialog.cancelButton;
    }

    static /* synthetic */ boolean access$900(GraphSearchOptionsDialog graphSearchOptionsDialog) {
        return graphSearchOptionsDialog.originalRegEx;
    }

    static /* synthetic */ boolean access$1000(GraphSearchOptionsDialog graphSearchOptionsDialog) {
        return graphSearchOptionsDialog.originalCaseSensitive;
    }

    static /* synthetic */ boolean access$1100(GraphSearchOptionsDialog graphSearchOptionsDialog) {
        return graphSearchOptionsDialog.originalVisibleOnly;
    }

    static /* synthetic */ boolean access$1200(GraphSearchOptionsDialog graphSearchOptionsDialog) {
        return graphSearchOptionsDialog.originalSelectedOnly;
    }
}

