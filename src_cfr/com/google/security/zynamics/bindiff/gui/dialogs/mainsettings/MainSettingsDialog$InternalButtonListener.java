/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.mainsettings;

import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.MainSettingsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.MainSettingsDialog$1;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;

class MainSettingsDialog$InternalButtonListener
implements ActionListener {
    final /* synthetic */ MainSettingsDialog this$0;

    private MainSettingsDialog$InternalButtonListener(MainSettingsDialog mainSettingsDialog) {
        this.this$0 = mainSettingsDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == MainSettingsDialog.access$100(this.this$0).getFirstButton()) {
            try {
                MainSettingsDialog.access$200(this.this$0);
            }
            catch (IOException var2_2) {
                CMessageBox.showError(this.this$0, "Couldn't save main settings.");
                Logger.logException(var2_2, "Couldn't save main settings.");
            }
        }
        this.this$0.dispose();
    }

    /* synthetic */ MainSettingsDialog$InternalButtonListener(MainSettingsDialog mainSettingsDialog, MainSettingsDialog$1 mainSettingsDialog$1) {
        this(mainSettingsDialog);
    }
}

