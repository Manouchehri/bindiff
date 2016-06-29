package com.google.security.zynamics.bindiff.gui.dialogs;

import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.FileChooser.*;
import java.io.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.zylib.io.*;
import java.awt.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;

class ExportViewDialog$InternalButtonListener implements ActionListener
{
    final /* synthetic */ ExportViewDialog this$0;
    
    private ExportViewDialog$InternalButtonListener(final ExportViewDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(this.this$0.okButton)) {
            if (!this.this$0.validatePaths()) {
                CMessageBox.showInformation(this.this$0.window, "Illegal image file names. Please enter valid names.");
                return;
            }
            if (!this.this$0.confirmOverwrites()) {
                return;
            }
            this.this$0.okPressed = true;
        }
        this.this$0.dispose();
    }
}
