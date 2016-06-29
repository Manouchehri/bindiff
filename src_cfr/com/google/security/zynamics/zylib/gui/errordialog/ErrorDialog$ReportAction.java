/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.errordialog;

import com.google.security.zynamics.zylib.gui.errordialog.ErrorDialog;
import com.google.security.zynamics.zylib.gui.errordialog.ErrorDialog$1;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class ErrorDialog$ReportAction
extends AbstractAction {
    private static final long serialVersionUID = -5953309819908682475L;
    final /* synthetic */ ErrorDialog this$0;

    private ErrorDialog$ReportAction(ErrorDialog errorDialog) {
        this.this$0 = errorDialog;
        super("Report");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.this$0.report();
    }

    /* synthetic */ ErrorDialog$ReportAction(ErrorDialog errorDialog, ErrorDialog$1 errorDialog$1) {
        this(errorDialog);
    }
}

