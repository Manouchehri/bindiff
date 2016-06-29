/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.menubar.HelpMenu;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class HelpMenu$1
extends AbstractAction {
    final /* synthetic */ TabPanelFunctions val$controller;
    final /* synthetic */ HelpMenu this$0;

    HelpMenu$1(HelpMenu helpMenu, TabPanelFunctions tabPanelFunctions) {
        this.this$0 = helpMenu;
        this.val$controller = tabPanelFunctions;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.val$controller.showHelp();
    }
}

