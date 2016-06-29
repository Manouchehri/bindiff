package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import java.awt.event.*;
import com.google.common.base.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;

class CProgressPanel$InternalActionListener implements ActionListener
{
    final /* synthetic */ CProgressPanel this$0;
    
    private CProgressPanel$InternalActionListener(final CProgressPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.updateSecondsText();
    }
}
