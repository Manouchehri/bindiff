package com.google.security.zynamics.bindiff.gui.dialogs;

import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

class SaveAsViewDialog$InternalButtonListener implements ActionListener
{
    final /* synthetic */ SaveAsViewDialog this$0;
    
    private SaveAsViewDialog$InternalButtonListener(final SaveAsViewDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(this.this$0.okButton)) {
            this.this$0.pressedOkButton = true;
        }
        else {
            this.this$0.pressedOkButton = false;
        }
        this.this$0.dispose();
    }
}
