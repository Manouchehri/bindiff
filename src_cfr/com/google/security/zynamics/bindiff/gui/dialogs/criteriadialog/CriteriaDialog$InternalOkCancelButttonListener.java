/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.CriteriaDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.CriteriaDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CriteriaDialog$InternalOkCancelButttonListener
implements ActionListener {
    final /* synthetic */ CriteriaDialog this$0;

    private CriteriaDialog$InternalOkCancelButttonListener(CriteriaDialog criteriaDialog) {
        this.this$0 = criteriaDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        CriteriaDialog.access$102(this.this$0, actionEvent.getActionCommand().equals("Execute"));
        this.this$0.dispose();
    }

    /* synthetic */ CriteriaDialog$InternalOkCancelButttonListener(CriteriaDialog criteriaDialog, CriteriaDialog$1 criteriaDialog$1) {
        this(criteriaDialog);
    }
}

