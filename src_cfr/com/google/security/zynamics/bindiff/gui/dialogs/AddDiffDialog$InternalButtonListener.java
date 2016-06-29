/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.AddDiffDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.AddDiffDialog$1;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class AddDiffDialog$InternalButtonListener
extends AbstractAction {
    final /* synthetic */ AddDiffDialog this$0;

    private AddDiffDialog$InternalButtonListener(AddDiffDialog addDiffDialog) {
        this.this$0 = addDiffDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(AddDiffDialog.access$200(this.this$0))) {
            if (!AddDiffDialog.access$300(this.this$0)) {
                return;
            }
            AddDiffDialog.access$402(this.this$0, true);
        }
        this.this$0.dispose();
    }

    /* synthetic */ AddDiffDialog$InternalButtonListener(AddDiffDialog addDiffDialog, AddDiffDialog$1 addDiffDialog$1) {
        this(addDiffDialog);
    }
}

