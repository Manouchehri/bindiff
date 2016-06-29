package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.common.base.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.zylib.types.common.*;
import java.awt.event.*;
import java.util.concurrent.*;
import javax.swing.*;

class CUnlimitedProgressDialog$InternalCommandThread$1 implements Runnable
{
    final /* synthetic */ CUnlimitedProgressDialog$InternalCommandThread this$1;
    
    CUnlimitedProgressDialog$InternalCommandThread$1(final CUnlimitedProgressDialog$InternalCommandThread this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    public void run() {
        this.this$1.this$0.dispose();
        this.this$1.this$0.setVisible(false);
        this.this$1.m_countDownLatch.countDown();
    }
}
