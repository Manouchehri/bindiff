package com.google.security.zynamics.bindiff.gui.dialogs;

import java.awt.event.*;

class ViewSearchOptionsDialog$InternalCancelButtonListener implements ActionListener
{
    final /* synthetic */ ViewSearchOptionsDialog this$0;
    
    private ViewSearchOptionsDialog$InternalCancelButtonListener(final ViewSearchOptionsDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.dispose();
    }
}
