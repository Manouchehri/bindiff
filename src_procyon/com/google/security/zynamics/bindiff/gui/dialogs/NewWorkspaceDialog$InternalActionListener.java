package com.google.security.zynamics.bindiff.gui.dialogs;

import java.awt.event.*;
import com.google.security.zynamics.zylib.io.*;
import com.google.security.zynamics.zylib.gui.FileChooser.*;
import com.google.security.zynamics.zylib.system.*;
import javax.swing.text.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.zylib.gui.*;
import java.io.*;
import java.awt.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;

class NewWorkspaceDialog$InternalActionListener implements ActionListener
{
    final /* synthetic */ NewWorkspaceDialog this$0;
    
    private NewWorkspaceDialog$InternalActionListener(final NewWorkspaceDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.this$0.workspaceDirectoryPanel.getButton()) {
            final DirectoryChooser directoryChooser = new DirectoryChooser("Select workspace location");
            directoryChooser.setSelectedFile(new File(this.this$0.workspaceDirectoryPanel.getText()));
            if (directoryChooser.showOpenDialog(this.this$0) == 0) {
                if (directoryChooser.getSelectedFile().exists()) {
                    this.this$0.workspaceDirectoryPanel.setText(directoryChooser.getSelectedFile().getAbsolutePath());
                }
                else {
                    CMessageBox.showError(directoryChooser, "Workspace directory does not exist. Please choose a valid one.");
                }
            }
            return;
        }
        if (actionEvent.getSource() == this.this$0.ok) {
            if (!this.this$0.validateValues()) {
                return;
            }
            this.this$0.okPressed = true;
        }
        this.this$0.dispose();
    }
}
