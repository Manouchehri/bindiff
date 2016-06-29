/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings;

import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.InitialCallGraphSettingsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.InitialCallGraphSettingsDialog$1;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class InitialCallGraphSettingsDialog$InternalButtonListener
implements ActionListener {
    final /* synthetic */ InitialCallGraphSettingsDialog this$0;

    private InitialCallGraphSettingsDialog$InternalButtonListener(InitialCallGraphSettingsDialog initialCallGraphSettingsDialog) {
        this.this$0 = initialCallGraphSettingsDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Ok")) {
            try {
                InitialCallGraphSettingsDialog.access$100(this.this$0);
            }
            catch (IOException var2_2) {
                CMessageBox.showError(this.this$0, "Couldn't save inital call graph settings.");
                Logger.logException(var2_2, "Couldn't save inital call graph settings.");
            }
        }
        this.this$0.dispose();
    }

    /* synthetic */ InitialCallGraphSettingsDialog$InternalButtonListener(InitialCallGraphSettingsDialog initialCallGraphSettingsDialog, InitialCallGraphSettingsDialog$1 initialCallGraphSettingsDialog$1) {
        this(initialCallGraphSettingsDialog);
    }
}

