package com.google.security.zynamics.bindiff.gui.dialogs;

import java.awt.event.*;
import com.google.security.zynamics.bindiff.config.*;
import java.io.*;
import com.google.security.zynamics.zylib.gui.FileChooser.*;
import com.google.common.base.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.gui.*;

class NewDiffDialog$InternalPrimaryFileChooserListener implements ActionListener
{
    final /* synthetic */ NewDiffDialog this$0;
    
    private NewDiffDialog$InternalPrimaryFileChooserListener(final NewDiffDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final BinDiffConfigFile instance = BinDiffConfigFile.getInstance();
        final File access$800 = chooseFile(this.this$0, "Choose Primary File", (this.this$0.lastSelectedFile == null) ? new File(instance.getMainSettings().getNewDiffLastPrimaryDir()) : this.this$0.lastSelectedFile, NewDiffDialog.IDB_FILEFILTER_INDEX);
        if (access$800 != null) {
            this.this$0.primaryChooser.setText(access$800.getPath());
            this.this$0.lastSelectedFile = access$800.getParentFile();
            instance.getMainSettings().setNewDiffLastPrimaryDir(this.this$0.lastSelectedFile.getPath());
        }
        this.this$0.updateDestinationFolder();
    }
}
