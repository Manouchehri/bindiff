/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CUnlimitedProgressDialog;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CUnlimitedProgressDialog$InternalCommandThread;

class CUnlimitedProgressDialog$InternalCommandThread$1
implements Runnable {
    final /* synthetic */ CUnlimitedProgressDialog$InternalCommandThread this$1;

    CUnlimitedProgressDialog$InternalCommandThread$1(CUnlimitedProgressDialog$InternalCommandThread internalCommandThread) {
        this.this$1 = internalCommandThread;
    }

    @Override
    public void run() {
        CUnlimitedProgressDialog.access$301(this.this$1.this$0);
        CUnlimitedProgressDialog.access$401(this.this$1.this$0, false);
        CUnlimitedProgressDialog$InternalCommandThread.access$500(this.this$1).countDown();
    }
}

