package com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels;

import com.google.security.zynamics.zylib.gui.FileChooser.*;
import com.google.security.zynamics.zylib.io.*;
import java.io.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.event.*;

class GeneralPanel$InternalDirectoryListener implements ActionListener
{
    final FileChooserPanel panel;
    final String title;
    final /* synthetic */ GeneralPanel this$0;
    
    public GeneralPanel$InternalDirectoryListener(final GeneralPanel this$0, final FileChooserPanel panel, final String title) {
        this.this$0 = this$0;
        this.panel = panel;
        this.title = title;
    }
    
    private String selectDirectory(final Container container) {
        final DirectoryChooser directoryChooser = new DirectoryChooser(this.title);
        directoryChooser.setCurrentDirectory(new File(this.panel.getText()));
        if (directoryChooser.showOpenDialog(container) != 0) {
            return null;
        }
        final File selectedFile = directoryChooser.getSelectedFile();
        if (!selectedFile.exists()) {
            CMessageBox.showError(container, "Directory does not exist.");
            return null;
        }
        if (!selectedFile.canExecute()) {
            CMessageBox.showError(container, "Directory is not executable.");
            return null;
        }
        return selectedFile.getAbsolutePath();
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final String selectDirectory = this.selectDirectory(this.this$0.getParent());
        if (selectDirectory != null) {
            this.panel.setText(selectDirectory);
        }
    }
}
