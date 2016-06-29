package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;

public class VisibilityCriteriumPanel extends JPanel
{
    private final JComboBox visibilityBox;
    private final VisibilityCriteriumPanel$InternalComboboxListener comboboxListner;
    private final VisibilityCriterium criterium;
    
    public VisibilityCriteriumPanel(final VisibilityCriterium criterium) {
        super(new BorderLayout());
        this.visibilityBox = new JComboBox();
        this.comboboxListner = new VisibilityCriteriumPanel$InternalComboboxListener(this, null);
        this.criterium = criterium;
        this.visibilityBox.addActionListener(this.comboboxListner);
        this.initPanel();
    }
    
    private void initPanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder("Edit Visibility Condition"));
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.visibilityBox.addItem(VisibilityState.VISIBLE.toString());
        this.visibilityBox.addItem(VisibilityState.UNVISIBLE.toString());
        panel2.add(this.visibilityBox, "Center");
        panel.add(panel2, "North");
        this.add(panel, "Center");
    }
    
    public void delete() {
        this.visibilityBox.removeActionListener(this.comboboxListner);
    }
    
    public VisibilityState getVisibilityState() {
        return (VisibilityState)this.visibilityBox.getSelectedItem();
    }
}
