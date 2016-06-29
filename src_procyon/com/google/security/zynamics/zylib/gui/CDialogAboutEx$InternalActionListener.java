package com.google.security.zynamics.zylib.gui;

import java.awt.event.*;

class CDialogAboutEx$InternalActionListener implements ActionListener
{
    final /* synthetic */ CDialogAboutEx this$0;
    
    private CDialogAboutEx$InternalActionListener(final CDialogAboutEx this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.dispose();
    }
}
