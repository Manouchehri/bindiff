/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessProgressDialog;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessProgressDialog$1;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class CEndlessProgressDialog$InternalWindowListener
extends WindowAdapter {
    final /* synthetic */ CEndlessProgressDialog this$0;

    private CEndlessProgressDialog$InternalWindowListener(CEndlessProgressDialog cEndlessProgressDialog) {
        this.this$0 = cEndlessProgressDialog;
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {
        CEndlessProgressDialog.access$400(this.this$0).stop();
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        CEndlessProgressDialog.access$300(this.this$0).closeRequested();
    }

    /* synthetic */ CEndlessProgressDialog$InternalWindowListener(CEndlessProgressDialog cEndlessProgressDialog, CEndlessProgressDialog$1 cEndlessProgressDialog$1) {
        this(cEndlessProgressDialog);
    }
}

