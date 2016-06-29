/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion.RecursionCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion.RecursionCriteriumPanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RecursionCriteriumPanel$InternalComboboxListener
implements ActionListener {
    final /* synthetic */ RecursionCriteriumPanel this$0;

    private RecursionCriteriumPanel$InternalComboboxListener(RecursionCriteriumPanel recursionCriteriumPanel) {
        this.this$0 = recursionCriteriumPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        RecursionCriteriumPanel.access$100(this.this$0).update();
    }

    /* synthetic */ RecursionCriteriumPanel$InternalComboboxListener(RecursionCriteriumPanel recursionCriteriumPanel, RecursionCriteriumPanel$1 recursionCriteriumPanel$1) {
        this(recursionCriteriumPanel);
    }
}

