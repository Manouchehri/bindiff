/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.ExportViewDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.ExportViewDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ExportViewDialog$InternalDestinationDirectoryListener
implements ActionListener {
    final /* synthetic */ ExportViewDialog this$0;

    private ExportViewDialog$InternalDestinationDirectoryListener(ExportViewDialog exportViewDialog) {
        this.this$0 = exportViewDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = ExportViewDialog.access$700(this.this$0, ExportViewDialog.access$400(this.this$0));
        if (string == null) return;
        ExportViewDialog.access$800(this.this$0).setText(string);
    }

    /* synthetic */ ExportViewDialog$InternalDestinationDirectoryListener(ExportViewDialog exportViewDialog, ExportViewDialog$1 exportViewDialog$1) {
        this(exportViewDialog);
    }
}

