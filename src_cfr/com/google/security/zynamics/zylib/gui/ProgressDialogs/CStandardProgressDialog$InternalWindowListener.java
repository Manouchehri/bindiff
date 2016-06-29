/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CStandardProgressDialog;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CStandardProgressDialog$1;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class CStandardProgressDialog$InternalWindowListener
extends WindowAdapter {
    final /* synthetic */ CStandardProgressDialog this$0;

    private CStandardProgressDialog$InternalWindowListener(CStandardProgressDialog cStandardProgressDialog) {
        this.this$0 = cStandardProgressDialog;
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        CStandardProgressDialog.access$400(this.this$0).closeRequested();
    }

    /* synthetic */ CStandardProgressDialog$InternalWindowListener(CStandardProgressDialog cStandardProgressDialog, CStandardProgressDialog$1 cStandardProgressDialog$1) {
        this(cStandardProgressDialog);
    }
}

