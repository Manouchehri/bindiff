/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriteriumPanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class IndegreeCriteriumPanel$InternalComboboxListener
implements ActionListener {
    final /* synthetic */ IndegreeCriteriumPanel this$0;

    private IndegreeCriteriumPanel$InternalComboboxListener(IndegreeCriteriumPanel indegreeCriteriumPanel) {
        this.this$0 = indegreeCriteriumPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        IndegreeCriteriumPanel.access$200(this.this$0).update();
    }

    /* synthetic */ IndegreeCriteriumPanel$InternalComboboxListener(IndegreeCriteriumPanel indegreeCriteriumPanel, IndegreeCriteriumPanel$1 indegreeCriteriumPanel$1) {
        this(indegreeCriteriumPanel);
    }
}

