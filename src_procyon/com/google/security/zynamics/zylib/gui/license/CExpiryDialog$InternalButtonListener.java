package com.google.security.zynamics.zylib.gui.license;

import javax.swing.*;
import java.awt.event.*;

class CExpiryDialog$InternalButtonListener extends AbstractAction
{
    private static final long serialVersionUID = -3774947758218736158L;
    final /* synthetic */ CExpiryDialog this$0;
    
    public CExpiryDialog$InternalButtonListener(final CExpiryDialog this$0) {
        this.this$0 = this$0;
        super("OK");
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.dispose();
    }
}
