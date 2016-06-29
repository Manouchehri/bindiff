package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog;

import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabpanels.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.utils.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.filter.enums.*;
import java.awt.*;

class GraphNodeTreeOptionsDialog$InternalButtonListener implements ActionListener
{
    final /* synthetic */ GraphNodeTreeOptionsDialog this$0;
    
    private GraphNodeTreeOptionsDialog$InternalButtonListener(final GraphNodeTreeOptionsDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(this.this$0.okButton)) {
            this.this$0.ok = true;
            this.this$0.setVisible(false);
        }
        else if (actionEvent.getSource().equals(this.this$0.cancelButton)) {
            this.this$0.searchingPanel.restoreInitialSettings();
            this.this$0.filteringPanel.restoreInitialSettings();
            this.this$0.sortingPanel.restoreInitialSettings();
            this.this$0.setVisible(false);
        }
        else if (actionEvent.getSource().equals(this.this$0.setDefaultsButton)) {
            this.this$0.setDefaults(this.this$0.tab.getSelectedIndex());
        }
    }
}
