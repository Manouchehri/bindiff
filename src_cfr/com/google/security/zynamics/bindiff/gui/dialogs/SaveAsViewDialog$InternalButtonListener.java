/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.SaveAsViewDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveAsViewDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SaveAsViewDialog$InternalButtonListener
implements ActionListener {
    final /* synthetic */ SaveAsViewDialog this$0;

    private SaveAsViewDialog$InternalButtonListener(SaveAsViewDialog saveAsViewDialog) {
        this.this$0 = saveAsViewDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(SaveAsViewDialog.access$100(this.this$0))) {
            SaveAsViewDialog.access$202(this.this$0, true);
        } else {
            SaveAsViewDialog.access$202(this.this$0, false);
        }
        this.this$0.dispose();
    }

    /* synthetic */ SaveAsViewDialog$InternalButtonListener(SaveAsViewDialog saveAsViewDialog, SaveAsViewDialog$1 saveAsViewDialog$1) {
        this(saveAsViewDialog);
    }
}

