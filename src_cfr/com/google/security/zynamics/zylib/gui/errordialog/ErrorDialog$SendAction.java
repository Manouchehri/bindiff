/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.errordialog;

import com.google.security.zynamics.zylib.gui.errordialog.ErrorDialog;
import com.google.security.zynamics.zylib.gui.errordialog.ErrorDialog$1;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class ErrorDialog$SendAction
extends AbstractAction {
    private static final long serialVersionUID = -6488875605584243902L;
    final /* synthetic */ ErrorDialog this$0;

    private ErrorDialog$SendAction(ErrorDialog errorDialog) {
        this.this$0 = errorDialog;
        super("Send");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.this$0.send(ErrorDialog.access$300(this.this$0), ErrorDialog.access$400(this.this$0), ErrorDialog.access$500(this.this$0));
    }

    /* synthetic */ ErrorDialog$SendAction(ErrorDialog errorDialog, ErrorDialog$1 errorDialog$1) {
        this(errorDialog);
    }
}

