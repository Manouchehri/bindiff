package com.google.security.zynamics.zylib.gui;

import javax.swing.*;
import java.awt.event.*;

class CDialogEscaper$1 implements ActionListener
{
    final /* synthetic */ JDialog val$dialog;
    final /* synthetic */ CDialogEscaper this$0;
    
    CDialogEscaper$1(final CDialogEscaper this$0, final JDialog val$dialog) {
        this.this$0 = this$0;
        this.val$dialog = val$dialog;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.val$dialog.setVisible(false);
        this.val$dialog.dispose();
    }
}
