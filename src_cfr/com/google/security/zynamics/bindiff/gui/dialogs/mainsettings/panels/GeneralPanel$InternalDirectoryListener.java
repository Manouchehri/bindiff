/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels;

import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels.GeneralPanel;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.FileChooser.FileChooserPanel;
import com.google.security.zynamics.zylib.io.DirectoryChooser;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class GeneralPanel$InternalDirectoryListener
implements ActionListener {
    final FileChooserPanel panel;
    final String title;
    final /* synthetic */ GeneralPanel this$0;

    public GeneralPanel$InternalDirectoryListener(GeneralPanel generalPanel, FileChooserPanel fileChooserPanel, String string) {
        this.this$0 = generalPanel;
        this.panel = fileChooserPanel;
        this.title = string;
    }

    private String selectDirectory(Container container) {
        DirectoryChooser directoryChooser = new DirectoryChooser(this.title);
        directoryChooser.setCurrentDirectory(new File(this.panel.getText()));
        if (directoryChooser.showOpenDialog(container) != 0) return null;
        File file = directoryChooser.getSelectedFile();
        if (!file.exists()) {
            CMessageBox.showError(container, "Directory does not exist.");
            return null;
        }
        if (file.canExecute()) return file.getAbsolutePath();
        CMessageBox.showError(container, "Directory is not executable.");
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = this.selectDirectory(this.this$0.getParent());
        if (string == null) return;
        this.panel.setText(string);
    }
}

