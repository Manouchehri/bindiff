/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.errordialog;

import com.google.security.zynamics.zylib.gui.errordialog.ErrorDialog;
import com.google.security.zynamics.zylib.gui.errordialog.ErrorDialog$1;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class ErrorDialog$CloseButtonListener
extends AbstractAction {
    private static final long serialVersionUID = 2709310936594698502L;
    final /* synthetic */ ErrorDialog this$0;

    private ErrorDialog$CloseButtonListener(ErrorDialog errorDialog) {
        this.this$0 = errorDialog;
        super("Close");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.this$0.dispose();
    }

    /* synthetic */ ErrorDialog$CloseButtonListener(ErrorDialog errorDialog, ErrorDialog$1 errorDialog$1) {
        this(errorDialog);
    }
}

