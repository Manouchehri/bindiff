package com.google.security.zynamics.bindiff.gui.window;

import javax.swing.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.project.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.zylib.io.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;

class MainWindow$InternalWindowListener extends WindowAdapter
{
    final /* synthetic */ MainWindow this$0;
    
    private MainWindow$InternalWindowListener(final MainWindow this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void windowClosed(final WindowEvent windowEvent) {
        this.this$0.removeWindowListener(this.this$0.windowListener);
    }
    
    @Override
    public void windowClosing(final WindowEvent windowEvent) {
        this.this$0.controller.getTabPanelManager().getWorkspaceTabPanel().getController().getWorkspaceTree().grabFocus();
        SwingUtilities.invokeLater(new MainWindow$InternalWindowListener$1(this));
    }
}
