package com.google.security.zynamics.bindiff.gui.dialogs;

import java.awt.event.*;
import com.google.security.zynamics.bindiff.config.*;
import java.io.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.zylib.gui.FileChooser.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.database.*;
import com.google.security.zynamics.zylib.gui.*;
import java.sql.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.awt.*;
import javax.swing.border.*;

class AddDiffDialog$InternalDiffChooserListener implements ActionListener
{
    final /* synthetic */ AddDiffDialog this$0;
    
    private AddDiffDialog$InternalDiffChooserListener(final AddDiffDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final BinDiffConfigFile instance = BinDiffConfigFile.getInstance();
        final File access$500 = chooseFile(this.this$0, "Choose Diff", new File(instance.getMainSettings().getAddExistingDiffLastDir()));
        if (access$500 != null && access$500.exists()) {
            this.this$0.diffChooser.setText(access$500.getPath());
            instance.getMainSettings().setAddExistingDiffLastDir(access$500.getParent());
            this.this$0.updatedExportedSources();
        }
    }
}
