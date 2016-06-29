package com.google.security.zynamics.bindiff.gui.dialogs.mainsettings;

import java.awt.event.*;
import com.google.security.zynamics.bindiff.log.*;
import java.io.*;
import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.bindiff.*;
import com.google.security.zynamics.bindiff.config.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

class MainSettingsDialog$InternalButtonListener implements ActionListener
{
    final /* synthetic */ MainSettingsDialog this$0;
    
    private MainSettingsDialog$InternalButtonListener(final MainSettingsDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.this$0.buttons.getFirstButton()) {
            try {
                this.this$0.save();
            }
            catch (IOException ex) {
                CMessageBox.showError(this.this$0, "Couldn't save main settings.");
                Logger.logException(ex, "Couldn't save main settings.");
            }
        }
        this.this$0.dispose();
    }
}
