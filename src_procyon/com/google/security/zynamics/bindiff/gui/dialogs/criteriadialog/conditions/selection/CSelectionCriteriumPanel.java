package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;

public class CSelectionCriteriumPanel extends JPanel
{
    private final JComboBox selectionBox;
    private final CSelectionCriteriumPanel$InternalComboboxListener comboboxListner;
    private final CSelectionCriterium criterium;
    
    public CSelectionCriteriumPanel(final CSelectionCriterium criterium) {
        super(new BorderLayout());
        this.selectionBox = new JComboBox();
        this.comboboxListner = new CSelectionCriteriumPanel$InternalComboboxListener(this, null);
        this.criterium = criterium;
        this.selectionBox.addActionListener(this.comboboxListner);
        this.initPanel();
    }
    
    private void initPanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder("Edit Selection Condition"));
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.selectionBox.addItem(SelectionState.SELECTED.toString());
        this.selectionBox.addItem(SelectionState.UNSELECTED.toString());
        panel2.add(this.selectionBox, "Center");
        panel.add(panel2, "North");
        this.add(panel, "Center");
    }
    
    public void delete() {
        this.selectionBox.removeActionListener(this.comboboxListner);
    }
    
    public SelectionState getSelectionState() {
        return (SelectionState)this.selectionBox.getSelectedItem();
    }
}
