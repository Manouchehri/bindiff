package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.*;

class CEndlessProgressDialog$InternalWindowListener extends WindowAdapter
{
    final /* synthetic */ CEndlessProgressDialog this$0;
    
    private CEndlessProgressDialog$InternalWindowListener(final CEndlessProgressDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void windowClosed(final WindowEvent windowEvent) {
        this.this$0.m_progressPanel.stop();
    }
    
    @Override
    public void windowClosing(final WindowEvent windowEvent) {
        this.this$0.m_progressModel.closeRequested();
    }
}
