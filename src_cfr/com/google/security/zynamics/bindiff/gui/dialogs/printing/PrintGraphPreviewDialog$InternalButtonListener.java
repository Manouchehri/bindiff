/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.printing;

import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphOptionsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphPreviewDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphPreviewDialog$1;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import y.h.bW;

class PrintGraphPreviewDialog$InternalButtonListener
implements ActionListener {
    final /* synthetic */ PrintGraphPreviewDialog this$0;

    private PrintGraphPreviewDialog$InternalButtonListener(PrintGraphPreviewDialog printGraphPreviewDialog) {
        this.this$0 = printGraphPreviewDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() != PrintGraphPreviewDialog.access$700(this.this$0) && actionEvent.getSource() != PrintGraphPreviewDialog.access$400(this.this$0)) {
            if (actionEvent.getSource() != PrintGraphPreviewDialog.access$800(this.this$0)) return;
            PrintGraphOptionsDialog printGraphOptionsDialog = new PrintGraphOptionsDialog(this.this$0, PrintGraphPreviewDialog.access$900(this.this$0));
            if (!printGraphOptionsDialog.isOkPressed()) return;
            PrintGraphPreviewDialog.access$1000(this.this$0).setPages(0, PrintGraphPreviewDialog.access$900(this.this$0).c(), PrintGraphPreviewDialog.access$900(this.this$0).c() * PrintGraphPreviewDialog.access$900(this.this$0).b());
            return;
        }
        this.this$0.dispose();
    }

    /* synthetic */ PrintGraphPreviewDialog$InternalButtonListener(PrintGraphPreviewDialog printGraphPreviewDialog, PrintGraphPreviewDialog$1 printGraphPreviewDialog$1) {
        this(printGraphPreviewDialog);
    }
}

