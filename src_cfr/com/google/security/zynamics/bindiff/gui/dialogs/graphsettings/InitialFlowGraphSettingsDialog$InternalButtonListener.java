/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings;

import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.InitialFlowGraphSettingsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.InitialFlowGraphSettingsDialog$1;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class InitialFlowGraphSettingsDialog$InternalButtonListener
implements ActionListener {
    final /* synthetic */ InitialFlowGraphSettingsDialog this$0;

    private InitialFlowGraphSettingsDialog$InternalButtonListener(InitialFlowGraphSettingsDialog initialFlowGraphSettingsDialog) {
        this.this$0 = initialFlowGraphSettingsDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Ok")) {
            try {
                InitialFlowGraphSettingsDialog.access$100(this.this$0);
            }
            catch (IOException var2_2) {
                CMessageBox.showError(this.this$0, "Couldn't save inital flow graph settings.");
                Logger.logException(var2_2, "Couldn't save inital flow graph settings.");
            }
        }
        this.this$0.dispose();
    }

    /* synthetic */ InitialFlowGraphSettingsDialog$InternalButtonListener(InitialFlowGraphSettingsDialog initialFlowGraphSettingsDialog, InitialFlowGraphSettingsDialog$1 initialFlowGraphSettingsDialog$1) {
        this(initialFlowGraphSettingsDialog);
    }
}

