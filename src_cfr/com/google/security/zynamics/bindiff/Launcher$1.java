/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff;

import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.window.CWindowFunctions;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.resources.Constants;
import com.google.security.zynamics.bindiff.socketserver.SocketServer;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.io.IOException;

final class Launcher$1
implements Runnable {
    final /* synthetic */ MainWindow val$window;

    Launcher$1(MainWindow mainWindow) {
        this.val$window = mainWindow;
    }

    @Override
    public void run() {
        int n2 = Constants.getSocketPort();
        try {
            new SocketServer(n2, this.val$window.getController().getTabPanelManager().getWorkspaceTabPanel().getController()).startListening();
            return;
        }
        catch (IOException var2_2) {
            CMessageBox.showError(this.val$window, String.format("Could not listen on port %s. BinDiff exits.", n2));
            System.exit(1);
        }
    }
}

