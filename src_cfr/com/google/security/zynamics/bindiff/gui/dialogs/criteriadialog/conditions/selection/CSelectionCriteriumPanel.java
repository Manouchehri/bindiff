/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection.CSelectionCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection.CSelectionCriteriumPanel$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection.CSelectionCriteriumPanel$InternalComboboxListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection.SelectionState;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class CSelectionCriteriumPanel
extends JPanel {
    private final JComboBox selectionBox = new JComboBox();
    private final CSelectionCriteriumPanel$InternalComboboxListener comboboxListner;
    private final CSelectionCriterium criterium;

    public CSelectionCriteriumPanel(CSelectionCriterium cSelectionCriterium) {
        super(new BorderLayout());
        this.comboboxListner = new CSelectionCriteriumPanel$InternalComboboxListener(this, null);
        this.criterium = cSelectionCriterium;
        this.selectionBox.addActionListener(this.comboboxListner);
        this.initPanel();
    }

    private void initPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new TitledBorder("Edit Selection Condition"));
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.selectionBox.addItem(SelectionState.SELECTED.toString());
        this.selectionBox.addItem(SelectionState.UNSELECTED.toString());
        jPanel2.add((Component)this.selectionBox, "Center");
        jPanel.add((Component)jPanel2, "North");
        this.add((Component)jPanel, "Center");
    }

    public void delete() {
        this.selectionBox.removeActionListener(this.comboboxListner);
    }

    public SelectionState getSelectionState() {
        return (SelectionState)((Object)this.selectionBox.getSelectedItem());
    }

    static /* synthetic */ CSelectionCriterium access$100(CSelectionCriteriumPanel cSelectionCriteriumPanel) {
        return cSelectionCriteriumPanel.criterium;
    }
}

