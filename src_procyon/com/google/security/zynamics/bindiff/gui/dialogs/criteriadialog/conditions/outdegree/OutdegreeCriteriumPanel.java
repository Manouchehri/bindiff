package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree;

import javax.swing.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;

public class OutdegreeCriteriumPanel extends JPanel
{
    private final OutdegreeCriterium criterium;
    private final JFormattedTextField inputField;
    private final JComboBox operatorBox;
    private final OutdegreeCriteriumPanel$InternalComboboxListener comboboxListener;
    private final OutdegreeCriteriumPanel$InternalTextListener textFieldListener;
    
    public OutdegreeCriteriumPanel(final OutdegreeCriterium criterium) {
        super(new BorderLayout());
        this.inputField = new JFormattedTextField((JFormattedTextField.AbstractFormatter)new CDecFormatter(8));
        this.operatorBox = new JComboBox();
        this.comboboxListener = new OutdegreeCriteriumPanel$InternalComboboxListener(this, null);
        this.textFieldListener = new OutdegreeCriteriumPanel$InternalTextListener(this, null);
        this.criterium = criterium;
        this.operatorBox.addActionListener(this.comboboxListener);
        this.inputField.addKeyListener(this.textFieldListener);
        this.initPanel();
    }
    
    private void initPanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder("Edit Outdegree Condition"));
        this.operatorBox.addItem("<");
        this.operatorBox.addItem("=");
        this.operatorBox.addItem(">");
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        final JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBorder(new EmptyBorder(5, 0, 5, 5));
        panel2.add(this.operatorBox, "Center");
        panel3.add(this.inputField, "Center");
        final JPanel panel4 = new JPanel(new BorderLayout());
        panel4.add(panel2, "West");
        panel4.add(panel3, "Center");
        panel.add(panel4, "North");
        this.add(panel, "Center");
    }
    
    public void delete() {
        this.operatorBox.removeActionListener(this.comboboxListener);
        this.inputField.removeKeyListener(this.textFieldListener);
    }
    
    public String getOperator() {
        return this.operatorBox.getSelectedItem().toString();
    }
    
    public int getOutdegree() {
        return this.inputField.getText().isEmpty() ? 0 : Integer.valueOf(this.inputField.getText());
    }
}
