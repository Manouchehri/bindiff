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

class ExportViewDialog$InternalDestinationDirectoryListener implements ActionListener
{
    final /* synthetic */ ExportViewDialog this$0;
    
    private ExportViewDialog$InternalDestinationDirectoryListener(final ExportViewDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final String access$700 = this.this$0.selectDirectory(this.this$0.window);
        if (access$700 != null) {
            this.this$0.destinationChooserPanel.setText(access$700);
        }
    }
}
