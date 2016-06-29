/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.ViewSearchOptionsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.ViewSearchOptionsDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ViewSearchOptionsDialog$InternalOkButtonListener
implements ActionListener {
    final /* synthetic */ ViewSearchOptionsDialog this$0;

    private ViewSearchOptionsDialog$InternalOkButtonListener(ViewSearchOptionsDialog viewSearchOptionsDialog) {
        this.this$0 = viewSearchOptionsDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ViewSearchOptionsDialog.access$202(this.this$0, true);
        this.this$0.dispose();
    }

    /* synthetic */ ViewSearchOptionsDialog$InternalOkButtonListener(ViewSearchOptionsDialog viewSearchOptionsDialog, ViewSearchOptionsDialog$1 viewSearchOptionsDialog$1) {
        this(viewSearchOptionsDialog);
    }
}

