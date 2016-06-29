package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.*;
import java.awt.event.*;
import com.google.common.base.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;

class CProgressPanel$2 extends SwingInvoker
{
    final /* synthetic */ CProgressPanel this$0;
    
    CProgressPanel$2(final CProgressPanel this$0) {
        this.this$0 = this$0;
    }
    
    public void operation() {
        this.this$0.m_label.updateUI();
    }
}
