package com.google.security.zynamics.bindiff.gui.components.closeablebuttontab;

import com.google.security.zynamics.bindiff.gui.components.*;
import com.google.security.zynamics.bindiff.log.*;
import java.util.*;
import com.google.security.zynamics.zylib.general.*;
import javax.swing.*;
import com.google.common.base.*;
import javax.swing.plaf.basic.*;
import javax.swing.plaf.*;
import java.awt.event.*;
import java.awt.*;

class TabButton$InternalButtonListener implements ActionListener
{
    final /* synthetic */ TabButton this$0;
    
    private TabButton$InternalButtonListener(final TabButton this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (this.this$0.pane.indexOfTabComponent(this.this$0.tabButtonComponent) == -1) {
            return;
        }
        for (final ICloseTabButtonListener closeTabButtonListener : this.this$0.closeTabButtonListeners) {
            try {
                if (!closeTabButtonListener.closing(this.this$0.tabButtonComponent)) {
                    return;
                }
                continue;
            }
            catch (Exception ex) {
                MessageBox.showError(SwingUtilities.getWindowAncestor(this.this$0), "An error occured while closing the tab.");
                Logger.logException(ex, "An error occured while closing the tab.");
            }
        }
    }
}
