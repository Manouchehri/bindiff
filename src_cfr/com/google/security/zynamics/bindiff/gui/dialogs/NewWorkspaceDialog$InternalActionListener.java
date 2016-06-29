/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.NewWorkspaceDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.NewWorkspaceDialog$1;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.io.DirectoryChooser;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;

class NewWorkspaceDialog$InternalActionListener
implements ActionListener {
    final /* synthetic */ NewWorkspaceDialog this$0;

    private NewWorkspaceDialog$InternalActionListener(NewWorkspaceDialog newWorkspaceDialog) {
        this.this$0 = newWorkspaceDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == NewWorkspaceDialog.access$100(this.this$0).getButton()) {
            DirectoryChooser directoryChooser = new DirectoryChooser("Select workspace location");
            directoryChooser.setSelectedFile(new File(NewWorkspaceDialog.access$100(this.this$0).getText()));
            if (directoryChooser.showOpenDialog(this.this$0) != 0) return;
            File file = directoryChooser.getSelectedFile();
            if (file.exists()) {
                NewWorkspaceDialog.access$100(this.this$0).setText(directoryChooser.getSelectedFile().getAbsolutePath());
                return;
            }
            CMessageBox.showError(directoryChooser, "Workspace directory does not exist. Please choose a valid one.");
            return;
        }
        if (actionEvent.getSource() == NewWorkspaceDialog.access$200(this.this$0)) {
            if (!NewWorkspaceDialog.access$300(this.this$0)) {
                return;
            }
            NewWorkspaceDialog.access$402(this.this$0, true);
        }
        this.this$0.dispose();
    }

    /* synthetic */ NewWorkspaceDialog$InternalActionListener(NewWorkspaceDialog newWorkspaceDialog, NewWorkspaceDialog$1 newWorkspaceDialog$1) {
        this(newWorkspaceDialog);
    }
}

