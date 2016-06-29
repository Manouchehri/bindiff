/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.OutdegreeCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.OutdegreeCriteriumPanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class OutdegreeCriteriumPanel$InternalComboboxListener
implements ActionListener {
    final /* synthetic */ OutdegreeCriteriumPanel this$0;

    private OutdegreeCriteriumPanel$InternalComboboxListener(OutdegreeCriteriumPanel outdegreeCriteriumPanel) {
        this.this$0 = outdegreeCriteriumPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        OutdegreeCriteriumPanel.access$200(this.this$0).update();
    }

    /* synthetic */ OutdegreeCriteriumPanel$InternalComboboxListener(OutdegreeCriteriumPanel outdegreeCriteriumPanel, OutdegreeCriteriumPanel$1 outdegreeCriteriumPanel$1) {
        this(outdegreeCriteriumPanel);
    }
}

