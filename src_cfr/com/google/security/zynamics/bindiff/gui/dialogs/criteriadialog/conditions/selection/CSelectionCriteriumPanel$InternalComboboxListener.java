/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection.CSelectionCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection.CSelectionCriteriumPanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CSelectionCriteriumPanel$InternalComboboxListener
implements ActionListener {
    final /* synthetic */ CSelectionCriteriumPanel this$0;

    private CSelectionCriteriumPanel$InternalComboboxListener(CSelectionCriteriumPanel cSelectionCriteriumPanel) {
        this.this$0 = cSelectionCriteriumPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        CSelectionCriteriumPanel.access$100(this.this$0).update();
    }

    /* synthetic */ CSelectionCriteriumPanel$InternalComboboxListener(CSelectionCriteriumPanel cSelectionCriteriumPanel, CSelectionCriteriumPanel$1 cSelectionCriteriumPanel$1) {
        this(cSelectionCriteriumPanel);
    }
}

