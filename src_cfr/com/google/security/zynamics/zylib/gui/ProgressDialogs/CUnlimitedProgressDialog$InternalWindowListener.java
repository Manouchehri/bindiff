/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CUnlimitedProgressDialog;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CUnlimitedProgressDialog$1;
import com.google.security.zynamics.zylib.types.common.ICancelableCommand;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class CUnlimitedProgressDialog$InternalWindowListener
extends WindowAdapter
implements ActionListener {
    final /* synthetic */ CUnlimitedProgressDialog this$0;

    private CUnlimitedProgressDialog$InternalWindowListener(CUnlimitedProgressDialog cUnlimitedProgressDialog) {
        this.this$0 = cUnlimitedProgressDialog;
    }

    private void cancel() {
        try {
            if (!CUnlimitedProgressDialog.access$600(this.this$0)) return;
            this.this$0.setDescription("Canceling...");
            ((ICancelableCommand)CUnlimitedProgressDialog.access$100(this.this$0)).cancel();
            return;
        }
        catch (Exception var1_1) {
            CUnlimitedProgressDialog.access$200(this.this$0, var1_1);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.cancel();
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        this.cancel();
    }

    /* synthetic */ CUnlimitedProgressDialog$InternalWindowListener(CUnlimitedProgressDialog cUnlimitedProgressDialog, CUnlimitedProgressDialog$1 cUnlimitedProgressDialog$1) {
        this(cUnlimitedProgressDialog);
    }
}

