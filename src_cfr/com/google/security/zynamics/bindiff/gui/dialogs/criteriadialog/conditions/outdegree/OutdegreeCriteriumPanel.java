/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.OutdegreeCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.OutdegreeCriteriumPanel$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.OutdegreeCriteriumPanel$InternalComboboxListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.OutdegreeCriteriumPanel$InternalTextListener;
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

public class OutdegreeCriteriumPanel
extends JPanel {
    private final OutdegreeCriterium criterium;
    private final JFormattedTextField inputField = new JFormattedTextField(new CDecFormatter(8));
    private final JComboBox operatorBox = new JComboBox();
    private final OutdegreeCriteriumPanel$InternalComboboxListener comboboxListener;
    private final OutdegreeCriteriumPanel$InternalTextListener textFieldListener;

    public OutdegreeCriteriumPanel(OutdegreeCriterium outdegreeCriterium) {
        super(new BorderLayout());
        this.comboboxListener = new OutdegreeCriteriumPanel$InternalComboboxListener(this, null);
        this.textFieldListener = new OutdegreeCriteriumPanel$InternalTextListener(this, null);
        this.criterium = outdegreeCriterium;
        this.operatorBox.addActionListener(this.comboboxListener);
        this.inputField.addKeyListener(this.textFieldListener);
        this.initPanel();
    }

    private void initPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new TitledBorder("Edit Outdegree Condition"));
        this.operatorBox.addItem("<");
        this.operatorBox.addItem("=");
        this.operatorBox.addItem(">");
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        JPanel jPanel3 = new JPanel(new BorderLayout());
        jPanel3.setBorder(new EmptyBorder(5, 0, 5, 5));
        jPanel2.add((Component)this.operatorBox, "Center");
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

    public String getOperator() {
        return this.operatorBox.getSelectedItem().toString();
    }

    public int getOutdegree() {
        if (this.inputField.getText().isEmpty()) {
            return 0;
        }
        int n2 = Integer.valueOf(this.inputField.getText());
        return n2;
    }

    static /* synthetic */ OutdegreeCriterium access$200(OutdegreeCriteriumPanel outdegreeCriteriumPanel) {
        return outdegreeCriteriumPanel.criterium;
    }
}

