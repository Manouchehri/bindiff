package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.*;

class CStandardProgressDialog$InternalWindowListener extends WindowAdapter
{
    final /* synthetic */ CStandardProgressDialog this$0;
    
    private CStandardProgressDialog$InternalWindowListener(final CStandardProgressDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void windowClosed(final WindowEvent windowEvent) {
    }
    
    @Override
    public void windowClosing(final WindowEvent windowEvent) {
        this.this$0.m_progressModel.closeRequested();
    }
}
