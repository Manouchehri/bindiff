/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion.RecursionCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion.RecursionCriteriumPanel$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion.RecursionCriteriumPanel$InternalComboboxListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion.RecursionState;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class RecursionCriteriumPanel
extends JPanel {
    private final JComboBox recursionBox = new JComboBox();
    private final RecursionCriteriumPanel$InternalComboboxListener comboboxListner;
    private final RecursionCriterium criterium;

    public RecursionCriteriumPanel(RecursionCriterium recursionCriterium) {
        super(new BorderLayout());
        this.comboboxListner = new RecursionCriteriumPanel$InternalComboboxListener(this, null);
        this.criterium = recursionCriterium;
        this.recursionBox.addActionListener(this.comboboxListner);
        this.initPanel();
    }

    private void initPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new TitledBorder("Edit Recursion Condition"));
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.recursionBox.addItem(RecursionState.IS_RECURSION.toString());
        this.recursionBox.addItem(RecursionState.IS_NOT_RECURSION.toString());
        jPanel2.add((Component)this.recursionBox, "Center");
        jPanel.add((Component)jPanel2, "North");
        this.add((Component)jPanel, "Center");
    }

    public void delete() {
        this.recursionBox.removeActionListener(this.comboboxListner);
    }

    public RecursionState getRecursionState() {
        return (RecursionState)((Object)this.recursionBox.getSelectedItem());
    }

    static /* synthetic */ RecursionCriterium access$100(RecursionCriteriumPanel recursionCriteriumPanel) {
        return recursionCriteriumPanel.criterium;
    }
}

