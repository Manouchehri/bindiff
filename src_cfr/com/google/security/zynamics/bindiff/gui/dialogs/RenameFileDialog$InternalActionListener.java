/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.RenameFileDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.RenameFileDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RenameFileDialog$InternalActionListener
implements ActionListener {
    final /* synthetic */ RenameFileDialog this$0;

    private RenameFileDialog$InternalActionListener(RenameFileDialog renameFileDialog) {
        this.this$0 = renameFileDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        RenameFileDialog.access$102(this.this$0, actionEvent.getSource() == RenameFileDialog.access$200(this.this$0));
        this.this$0.dispose();
    }

    /* synthetic */ RenameFileDialog$InternalActionListener(RenameFileDialog renameFileDialog, RenameFileDialog$1 renameFileDialog$1) {
        this(renameFileDialog);
    }
}

