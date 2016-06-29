/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity.VisibilityCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity.VisibilityCriteriumPanel$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity.VisibilityCriteriumPanel$InternalComboboxListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity.VisibilityState;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class VisibilityCriteriumPanel
extends JPanel {
    private final JComboBox visibilityBox = new JComboBox();
    private final VisibilityCriteriumPanel$InternalComboboxListener comboboxListner;
    private final VisibilityCriterium criterium;

    public VisibilityCriteriumPanel(VisibilityCriterium visibilityCriterium) {
        super(new BorderLayout());
        this.comboboxListner = new VisibilityCriteriumPanel$InternalComboboxListener(this, null);
        this.criterium = visibilityCriterium;
        this.visibilityBox.addActionListener(this.comboboxListner);
        this.initPanel();
    }

    private void initPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new TitledBorder("Edit Visibility Condition"));
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.visibilityBox.addItem(VisibilityState.VISIBLE.toString());
        this.visibilityBox.addItem(VisibilityState.UNVISIBLE.toString());
        jPanel2.add((Component)this.visibilityBox, "Center");
        jPanel.add((Component)jPanel2, "North");
        this.add((Component)jPanel, "Center");
    }

    public void delete() {
        this.visibilityBox.removeActionListener(this.comboboxListner);
    }

    public VisibilityState getVisibilityState() {
        return (VisibilityState)((Object)this.visibilityBox.getSelectedItem());
    }

    static /* synthetic */ VisibilityCriterium access$100(VisibilityCriteriumPanel visibilityCriteriumPanel) {
        return visibilityCriteriumPanel.criterium;
    }
}

