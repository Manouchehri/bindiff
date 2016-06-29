package com.google.security.zynamics.zylib.gui.errordialog;

import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import javax.swing.border.*;
import com.google.security.zynamics.zylib.general.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

class ErrorDialog$SendAction extends AbstractAction
{
    private static final long serialVersionUID = -6488875605584243902L;
    final /* synthetic */ ErrorDialog this$0;
    
    private ErrorDialog$SendAction(final ErrorDialog this$0) {
        this.this$0 = this$0;
        super("Send");
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.send(this.this$0.m_description, this.this$0.m_message, this.this$0.m_exception);
    }
}
