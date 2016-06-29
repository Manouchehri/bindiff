/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.ExportViewDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.ExportViewDialog$1;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ExportViewDialog$InternalButtonListener
implements ActionListener {
    final /* synthetic */ ExportViewDialog this$0;

    private ExportViewDialog$InternalButtonListener(ExportViewDialog exportViewDialog) {
        this.this$0 = exportViewDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(ExportViewDialog.access$200(this.this$0))) {
            if (!ExportViewDialog.access$300(this.this$0)) {
                CMessageBox.showInformation(ExportViewDialog.access$400(this.this$0), "Illegal image file names. Please enter valid names.");
                return;
            }
            if (!ExportViewDialog.access$500(this.this$0)) {
                return;
            }
            ExportViewDialog.access$602(this.this$0, true);
        }
        this.this$0.dispose();
    }

    /* synthetic */ ExportViewDialog$InternalButtonListener(ExportViewDialog exportViewDialog, ExportViewDialog$1 exportViewDialog$1) {
        this(exportViewDialog);
    }
}

