package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import javax.swing.*;
import com.google.security.zynamics.zylib.types.common.*;
import com.google.common.base.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.*;
import java.util.concurrent.*;

class CUnlimitedProgressDialog$InternalWindowListener extends WindowAdapter implements ActionListener
{
    final /* synthetic */ CUnlimitedProgressDialog this$0;
    
    private CUnlimitedProgressDialog$InternalWindowListener(final CUnlimitedProgressDialog this$0) {
        this.this$0 = this$0;
    }
    
    private void cancel() {
        try {
            if (this.this$0.m_isCancelable) {
                this.this$0.setDescription("Canceling...");
                ((ICancelableCommand)this.this$0.m_command).cancel();
            }
        }
        catch (Exception ex) {
            this.this$0.setException(ex);
        }
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.cancel();
    }
    
    @Override
    public void windowClosing(final WindowEvent windowEvent) {
        this.cancel();
    }
}
