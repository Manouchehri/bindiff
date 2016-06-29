package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings;

import java.awt.event.*;
import com.google.security.zynamics.bindiff.log.*;
import java.io.*;
import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.config.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

class InitialFlowGraphSettingsDialog$InternalButtonListener implements ActionListener
{
    final /* synthetic */ InitialFlowGraphSettingsDialog this$0;
    
    private InitialFlowGraphSettingsDialog$InternalButtonListener(final InitialFlowGraphSettingsDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Ok")) {
            try {
                this.this$0.save();
            }
            catch (IOException ex) {
                CMessageBox.showError(this.this$0, "Couldn't save inital flow graph settings.");
                Logger.logException(ex, "Couldn't save inital flow graph settings.");
            }
        }
        this.this$0.dispose();
    }
}
