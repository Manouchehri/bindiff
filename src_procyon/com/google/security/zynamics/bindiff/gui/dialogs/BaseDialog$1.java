package com.google.security.zynamics.bindiff.gui.dialogs;

import java.awt.event.*;

class BaseDialog$1 implements ActionListener
{
    final /* synthetic */ BaseDialog this$0;
    
    BaseDialog$1(final BaseDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.setVisible(false);
        this.this$0.dispose();
    }
}
