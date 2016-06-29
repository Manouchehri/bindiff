/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CUnlimitedProgressDialog;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CUnlimitedProgressDialog$InternalCommandThread$1;
import java.util.concurrent.CountDownLatch;
import javax.swing.SwingUtilities;

class CUnlimitedProgressDialog$InternalCommandThread
implements Runnable {
    private final CountDownLatch m_countDownLatch;
    final /* synthetic */ CUnlimitedProgressDialog this$0;

    public CUnlimitedProgressDialog$InternalCommandThread(CUnlimitedProgressDialog cUnlimitedProgressDialog, CountDownLatch countDownLatch) {
        this.this$0 = cUnlimitedProgressDialog;
        this.m_countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            CUnlimitedProgressDialog.access$100(this.this$0).execute();
        }
        catch (Exception var1_1) {
            CUnlimitedProgressDialog.access$200(this.this$0, var1_1);
        }
        try {
            SwingUtilities.invokeLater(new CUnlimitedProgressDialog$InternalCommandThread$1(this));
            return;
        }
        catch (Exception var1_2) {
            CUnlimitedProgressDialog.access$200(this.this$0, var1_2);
            return;
        }
        finally {
            this.m_countDownLatch.countDown();
        }
    }

    static /* synthetic */ CountDownLatch access$500(CUnlimitedProgressDialog$InternalCommandThread cUnlimitedProgressDialog$InternalCommandThread) {
        return cUnlimitedProgressDialog$InternalCommandThread.m_countDownLatch;
    }
}

