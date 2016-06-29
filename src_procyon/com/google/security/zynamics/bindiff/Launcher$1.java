package com.google.security.zynamics.bindiff;

import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.bindiff.socketserver.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import java.io.*;

final class Launcher$1 implements Runnable
{
    final /* synthetic */ MainWindow val$window;
    
    Launcher$1(final MainWindow val$window) {
        this.val$window = val$window;
    }
    
    @Override
    public void run() {
        final int socketPort = Constants.getSocketPort();
        try {
            new SocketServer(socketPort, this.val$window.getController().getTabPanelManager().getWorkspaceTabPanel().getController()).startListening();
        }
        catch (IOException ex) {
            CMessageBox.showError(this.val$window, String.format("Could not listen on port %s. BinDiff exits.", socketPort));
            System.exit(1);
        }
    }
}
