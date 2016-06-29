/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.window;

import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.gui.window.MainWindow$1;
import com.google.security.zynamics.bindiff.gui.window.MainWindow$InternalWindowListener$1;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.SwingUtilities;

class MainWindow$InternalWindowListener
extends WindowAdapter {
    final /* synthetic */ MainWindow this$0;

    private MainWindow$InternalWindowListener(MainWindow mainWindow) {
        this.this$0 = mainWindow;
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {
        this.this$0.removeWindowListener(MainWindow.access$300(this.this$0));
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        WorkspaceTabPanelFunctions workspaceTabPanelFunctions = MainWindow.access$400(this.this$0).getTabPanelManager().getWorkspaceTabPanel().getController();
        workspaceTabPanelFunctions.getWorkspaceTree().grabFocus();
        SwingUtilities.invokeLater(new MainWindow$InternalWindowListener$1(this));
    }

    /* synthetic */ MainWindow$InternalWindowListener(MainWindow mainWindow, MainWindow$1 mainWindow$1) {
        this(mainWindow);
    }
}

