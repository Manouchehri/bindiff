/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.ViewSearchOptionsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.ViewSearchOptionsDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ViewSearchOptionsDialog$InternalCancelButtonListener
implements ActionListener {
    final /* synthetic */ ViewSearchOptionsDialog this$0;

    private ViewSearchOptionsDialog$InternalCancelButtonListener(ViewSearchOptionsDialog viewSearchOptionsDialog) {
        this.this$0 = viewSearchOptionsDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.this$0.dispose();
    }

    /* synthetic */ ViewSearchOptionsDialog$InternalCancelButtonListener(ViewSearchOptionsDialog viewSearchOptionsDialog, ViewSearchOptionsDialog$1 viewSearchOptionsDialog$1) {
        this(viewSearchOptionsDialog);
    }
}

