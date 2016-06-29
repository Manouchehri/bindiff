package com.google.security.zynamics.bindiff.gui.dialogs;

import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.utils.*;

class ViewSearchOptionsDialog$InternalOkButtonListener implements ActionListener
{
    final /* synthetic */ ViewSearchOptionsDialog this$0;
    
    private ViewSearchOptionsDialog$InternalOkButtonListener(final ViewSearchOptionsDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.okButtonPressed = true;
        this.this$0.dispose();
    }
}
