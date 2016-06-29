package com.google.security.zynamics.bindiff.gui.dialogs;

import java.awt.event.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.bindiff.gui.components.*;
import javax.swing.event.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import java.io.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.system.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.io.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.security.zynamics.bindiff.utils.*;
import java.util.*;
import com.google.security.zynamics.zylib.gui.*;

class SaveFunctionDiffViewDialog$InternalButtonListener implements ActionListener
{
    final /* synthetic */ SaveFunctionDiffViewDialog this$0;
    
    private SaveFunctionDiffViewDialog$InternalButtonListener(final SaveFunctionDiffViewDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.this$0.okButton) {
            try {
                if (!this.this$0.validateInput()) {
                    return;
                }
                this.this$0.okPressed = true;
            }
            catch (IOException ex) {
                Logger.logSevere("Save function diff view failed. Couldn't calculate source BinExport MD5.", new Object[0]);
                MessageBox.showError(this.this$0.getParent(), "Save function diff view failed. Couldn't calculate source BinExport MD5.");
                return;
            }
        }
        this.this$0.dispose();
    }
}
