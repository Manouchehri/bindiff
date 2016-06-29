package com.google.security.zynamics.bindiff.gui.tabpanels.menubar;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import java.awt.event.*;

class HelpMenu$4 extends AbstractAction
{
    final /* synthetic */ TabPanelFunctions val$controller;
    final /* synthetic */ HelpMenu this$0;
    
    HelpMenu$4(final HelpMenu this$0, final TabPanelFunctions val$controller) {
        this.this$0 = this$0;
        this.val$controller = val$controller;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.val$controller.checkForUpdates();
    }
}
