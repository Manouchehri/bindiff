package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings;

import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

class GraphSettingsDialog$InternalButtonListener implements ActionListener
{
    final /* synthetic */ GraphSettingsDialog this$0;
    
    private GraphSettingsDialog$InternalButtonListener(final GraphSettingsDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Ok")) {
            this.this$0.save();
        }
        this.this$0.dispose();
    }
}
