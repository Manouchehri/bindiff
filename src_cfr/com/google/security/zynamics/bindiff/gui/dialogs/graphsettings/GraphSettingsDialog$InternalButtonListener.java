/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings;

import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.GraphSettingsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.GraphSettingsDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GraphSettingsDialog$InternalButtonListener
implements ActionListener {
    final /* synthetic */ GraphSettingsDialog this$0;

    private GraphSettingsDialog$InternalButtonListener(GraphSettingsDialog graphSettingsDialog) {
        this.this$0 = graphSettingsDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Ok")) {
            GraphSettingsDialog.access$100(this.this$0);
        }
        this.this$0.dispose();
    }

    /* synthetic */ GraphSettingsDialog$InternalButtonListener(GraphSettingsDialog graphSettingsDialog, GraphSettingsDialog$1 graphSettingsDialog$1) {
        this(graphSettingsDialog);
    }
}

