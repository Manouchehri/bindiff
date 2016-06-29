/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriteriumPanel$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriteriumPanel$InternalComboboxListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriteriumPanel$InternalTextListener;
import com.google.security.zynamics.zylib.gui.CDecFormatter;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class IndegreeCriteriumPanel
extends JPanel {
    private final IndegreeCriterium criterium;
    private final JFormattedTextField inputField = new JFormattedTextField(new CDecFormatter(8));
    private final JComboBox operatorBox = new JComboBox();
    private final IndegreeCriteriumPanel$InternalComboboxListener comboboxListener;
    private final IndegreeCriteriumPanel$InternalTextListener textFieldListener;

    public IndegreeCriteriumPanel(IndegreeCriterium indegreeCriterium) {
        super(new BorderLayout());
        this.comboboxListener = new IndegreeCriteriumPanel$InternalComboboxListener(this, null);
        this.textFieldListener = new IndegreeCriteriumPanel$InternalTextListener(this, null);
        this.criterium = indegreeCriterium;
        this.operatorBox.addActionListener(this.comboboxListener);
        this.inputField.addKeyListener(this.textFieldListener);
        this.initPanel();
    }

    private void initPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new TitledBorder("Edit Indegree Condition"));
        this.operatorBox.addItem("<");
        this.operatorBox.addItem("=");
        this.operatorBox.addItem(">");
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        jPanel2.add((Component)this.operatorBox, "Center");
        JPanel jPanel3 = new JPanel(new BorderLayout());
        jPanel3.setBorder(new EmptyBorder(5, 0, 5, 5));
        jPanel3.add((Component)this.inputField, "Center");
        JPanel jPanel4 = new JPanel(new BorderLayout());
        jPanel4.add((Component)jPanel2, "West");
        jPanel4.add((Component)jPanel3, "Center");
        jPanel.add((Component)jPanel4, "North");
        this.add((Component)jPanel, "Center");
    }

    public void delete() {
        this.operatorBox.removeActionListener(this.comboboxListener);
        this.inputField.removeKeyListener(this.textFieldListener);
    }

    public int getIndegree() {
        if (this.inputField.getText().isEmpty()) {
            return 0;
        }
        int n2 = Integer.valueOf(this.inputField.getText());
        return n2;
    }

    public String getOperator() {
        return this.operatorBox.getSelectedItem().toString();
    }

    static /* synthetic */ IndegreeCriterium access$200(IndegreeCriteriumPanel indegreeCriteriumPanel) {
        return indegreeCriteriumPanel.criterium;
    }
}

