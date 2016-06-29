package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.graph.searchers.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.common.base.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class GraphSearchOptionsDialog extends BaseDialog
{
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
    
    public GraphSearchOptionsDialog(final Window window, final BinDiffGraph binDiffGraph) {
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
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 5, 5, 5));
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(this.setDefaultsButton, "West");
        final JPanel panel3 = new JPanel(new GridLayout(1, 2, 5, 5));
        panel3.add(this.okButton);
        panel3.add(this.cancelButton);
        panel.add(panel2, "West");
        panel.add(panel3, "East");
        return panel;
    }
    
    private JPanel createOptionsPanel() {
        final JPanel panel = new JPanel(new GridLayout(1, 2, 5, 5));
        final JPanel panel2 = new JPanel(new GridLayout(2, 1));
        panel2.setBorder(new TitledBorder(""));
        panel2.add(this.regEx);
        panel2.add(this.caseSensitive);
        final JPanel panel3 = new JPanel(new GridLayout(2, 1));
        panel3.setBorder(new TitledBorder(""));
        panel3.add(this.visibleOnly);
        panel3.add(this.selectedOnly);
        panel.add(panel2);
        panel.add(panel3);
        return panel;
    }
    
    private void init() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder(""));
        panel.add(this.createOptionsPanel(), "North");
        panel.add(this.createButtonsPanel(), "South");
        this.add(panel, "Center");
    }
    
    @Override
    public void setVisible(final boolean visible) {
        if (visible) {
            this.originalRegEx = this.regEx.isSelected();
            this.originalCaseSensitive = this.caseSensitive.isSelected();
            this.originalVisibleOnly = this.visibleOnly.isSelected();
            this.originalSelectedOnly = this.selectedOnly.isSelected();
        }
        super.setVisible(visible);
    }
}
