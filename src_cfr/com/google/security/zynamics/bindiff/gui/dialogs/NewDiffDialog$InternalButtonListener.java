/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.NewDiffDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.NewDiffDialog$1;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class NewDiffDialog$InternalButtonListener
extends AbstractAction {
    final /* synthetic */ NewDiffDialog this$0;

    private NewDiffDialog$InternalButtonListener(NewDiffDialog newDiffDialog) {
        this.this$0 = newDiffDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(NewDiffDialog.access$300(this.this$0))) {
            if (!NewDiffDialog.access$400(this.this$0)) {
                return;
            }
            NewDiffDialog.access$502(this.this$0, true);
        }
        this.this$0.dispose();
    }

    /* synthetic */ NewDiffDialog$InternalButtonListener(NewDiffDialog newDiffDialog, NewDiffDialog$1 newDiffDialog$1) {
        this(newDiffDialog);
    }
}

