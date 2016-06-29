package com.google.security.zynamics.zylib.gui.errordialog;

import javax.swing.*;
import java.awt.event.*;

class ErrorDialog$CloseButtonListener extends AbstractAction
{
    private static final long serialVersionUID = 2709310936594698502L;
    final /* synthetic */ ErrorDialog this$0;
    
    private ErrorDialog$CloseButtonListener(final ErrorDialog this$0) {
        this.this$0 = this$0;
        super("Close");
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.dispose();
    }
}
