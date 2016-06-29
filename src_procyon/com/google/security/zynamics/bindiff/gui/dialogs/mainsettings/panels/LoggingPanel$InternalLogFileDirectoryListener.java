package com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels;

import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.FileChooser.*;
import com.google.security.zynamics.zylib.io.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.bindiff.config.*;
import java.awt.*;
import javax.swing.*;

class LoggingPanel$InternalLogFileDirectoryListener implements ActionListener
{
    final /* synthetic */ LoggingPanel this$0;
    
    private LoggingPanel$InternalLogFileDirectoryListener(final LoggingPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final String access$100 = selectLogFileDirectory(this.this$0.getParent());
        if (access$100 != null) {
            this.this$0.logFileLocationPanel.setText(access$100);
        }
    }
}
