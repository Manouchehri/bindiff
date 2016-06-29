/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessProgressDialog;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessProgressDialog$1;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IEndlessProgressListener;

class CEndlessProgressDialog$InternalListener
implements IEndlessProgressListener {
    final /* synthetic */ CEndlessProgressDialog this$0;

    private CEndlessProgressDialog$InternalListener(CEndlessProgressDialog cEndlessProgressDialog) {
        this.this$0 = cEndlessProgressDialog;
    }

    @Override
    public void changedDescription(String string) {
        this.this$0.setSubDescription(string);
    }

    @Override
    public void changedGeneralDescription(String string) {
        this.this$0.setDescription(string);
    }

    @Override
    public void finished() {
        CEndlessProgressDialog.access$202(this.this$0, true);
        CEndlessProgressDialog.access$300(this.this$0).removeProgressListener(this);
        this.this$0.dispose();
    }

    /* synthetic */ CEndlessProgressDialog$InternalListener(CEndlessProgressDialog cEndlessProgressDialog, CEndlessProgressDialog$1 cEndlessProgressDialog$1) {
        this(cEndlessProgressDialog);
    }
}

