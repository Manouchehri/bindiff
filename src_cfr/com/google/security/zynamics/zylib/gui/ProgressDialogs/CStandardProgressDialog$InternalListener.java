/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CStandardProgressDialog;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CStandardProgressDialog$1;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IStandardProgressListener;

class CStandardProgressDialog$InternalListener
implements IStandardProgressListener {
    final /* synthetic */ CStandardProgressDialog this$0;

    private CStandardProgressDialog$InternalListener(CStandardProgressDialog cStandardProgressDialog) {
        this.this$0 = cStandardProgressDialog;
    }

    @Override
    public void changedDescription(String string) {
        this.this$0.setSubDescription(string);
    }

    @Override
    public void changedMaximum(int n2) {
        CStandardProgressDialog.access$200(this.this$0).setMaximum(n2);
    }

    @Override
    public void finished() {
        CStandardProgressDialog.access$302(this.this$0, true);
        CStandardProgressDialog.access$400(this.this$0).removeProgressListener(this);
        this.this$0.dispose();
    }

    @Override
    public void next() {
        CStandardProgressDialog.access$200(this.this$0).next();
    }

    @Override
    public void reset() {
        CStandardProgressDialog.access$200(this.this$0).reset();
    }

    /* synthetic */ CStandardProgressDialog$InternalListener(CStandardProgressDialog cStandardProgressDialog, CStandardProgressDialog$1 cStandardProgressDialog$1) {
        this(cStandardProgressDialog);
    }
}

