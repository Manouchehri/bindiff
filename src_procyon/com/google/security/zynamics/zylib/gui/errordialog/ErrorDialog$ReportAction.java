package com.google.security.zynamics.zylib.gui.errordialog;

import javax.swing.*;
import java.awt.event.*;

class ErrorDialog$ReportAction extends AbstractAction
{
    private static final long serialVersionUID = -5953309819908682475L;
    final /* synthetic */ ErrorDialog this$0;
    
    private ErrorDialog$ReportAction(final ErrorDialog this$0) {
        this.this$0 = this$0;
        super("Report");
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.report();
    }
}
