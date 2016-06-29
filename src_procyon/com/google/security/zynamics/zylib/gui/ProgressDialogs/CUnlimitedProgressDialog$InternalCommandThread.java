package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import java.util.concurrent.*;
import javax.swing.*;
import com.google.common.base.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.zylib.types.common.*;
import java.awt.event.*;

class CUnlimitedProgressDialog$InternalCommandThread implements Runnable
{
    private final CountDownLatch m_countDownLatch;
    final /* synthetic */ CUnlimitedProgressDialog this$0;
    
    public CUnlimitedProgressDialog$InternalCommandThread(final CUnlimitedProgressDialog this$0, final CountDownLatch countDownLatch) {
        this.this$0 = this$0;
        this.m_countDownLatch = countDownLatch;
    }
    
    @Override
    public void run() {
        try {
            this.this$0.m_command.execute();
        }
        catch (Exception ex) {
            this.this$0.setException(ex);
        }
        try {
            SwingUtilities.invokeLater(new CUnlimitedProgressDialog$InternalCommandThread$1(this));
        }
        catch (Exception ex2) {
            this.this$0.setException(ex2);
        }
        finally {
            this.m_countDownLatch.countDown();
        }
    }
}
