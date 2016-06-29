package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;

public class RecursionCriteriumPanel extends JPanel
{
    private final JComboBox recursionBox;
    private final RecursionCriteriumPanel$InternalComboboxListener comboboxListner;
    private final RecursionCriterium criterium;
    
    public RecursionCriteriumPanel(final RecursionCriterium criterium) {
        super(new BorderLayout());
        this.recursionBox = new JComboBox();
        this.comboboxListner = new RecursionCriteriumPanel$InternalComboboxListener(this, null);
        this.criterium = criterium;
        this.recursionBox.addActionListener(this.comboboxListner);
        this.initPanel();
    }
    
    private void initPanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder("Edit Recursion Condition"));
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.recursionBox.addItem(RecursionState.IS_RECURSION.toString());
        this.recursionBox.addItem(RecursionState.IS_NOT_RECURSION.toString());
        panel2.add(this.recursionBox, "Center");
        panel.add(panel2, "North");
        this.add(panel, "Center");
    }
    
    public void delete() {
        this.recursionBox.removeActionListener(this.comboboxListner);
    }
    
    public RecursionState getRecursionState() {
        return (RecursionState)this.recursionBox.getSelectedItem();
    }
}
