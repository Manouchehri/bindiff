/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity.VisibilityCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity.VisibilityCriteriumPanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class VisibilityCriteriumPanel$InternalComboboxListener
implements ActionListener {
    final /* synthetic */ VisibilityCriteriumPanel this$0;

    private VisibilityCriteriumPanel$InternalComboboxListener(VisibilityCriteriumPanel visibilityCriteriumPanel) {
        this.this$0 = visibilityCriteriumPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        VisibilityCriteriumPanel.access$100(this.this$0).update();
    }

    /* synthetic */ VisibilityCriteriumPanel$InternalComboboxListener(VisibilityCriteriumPanel visibilityCriteriumPanel, VisibilityCriteriumPanel$1 visibilityCriteriumPanel$1) {
        this(visibilityCriteriumPanel);
    }
}

