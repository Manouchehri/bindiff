package com.google.security.zynamics.bindiff.gui.dialogs;

import java.awt.event.*;
import com.google.security.zynamics.zylib.system.*;
import java.io.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.*;

class RenameFileDialog$InternalActionListener implements ActionListener
{
    final /* synthetic */ RenameFileDialog this$0;
    
    private RenameFileDialog$InternalActionListener(final RenameFileDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.okPressed = (actionEvent.getSource() == this.this$0.ok);
        this.this$0.dispose();
    }
}
