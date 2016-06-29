/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.socketserver;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.io.SocketXmlReader;
import com.google.security.zynamics.bindiff.io.matches.FunctionDiffSocketXmlData;
import com.google.security.zynamics.bindiff.io.matches.IReadXmlHandlerData;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.socketserver.IdaPluginListenerThread;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.ServerSocket;

public final class SocketServer {
    private final int port;
    private ServerSocket socket;
    private final WorkspaceTabPanelFunctions controller;

    public SocketServer(int n2, WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.port = n2;
        this.socket = null;
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
    }

    public void handleReceivedByteBuffer(byte[] arrby) {
        Logger.logInfo("Received byte stream from socket...", new Object[0]);
        try {
            IReadXmlHandlerData iReadXmlHandlerData = SocketXmlReader.readXMLData(new ByteArrayInputStream(arrby));
            if (!(iReadXmlHandlerData instanceof FunctionDiffSocketXmlData)) return;
            this.controller.openFunctionDiffView((FunctionDiffSocketXmlData)iReadXmlHandlerData);
            return;
        }
        catch (IOException var3_3) {
            this.handleError(var3_3, "Couldn't handle received byte stream.");
        }
    }

    public void handleError(Exception exception, String string) {
        CMessageBox.showError(this.controller.getMainWindow(), string);
        if (exception != null) {
            Logger.logException(exception, string);
            return;
        }
        Logger.logSevere(string, new Object[0]);
    }

    public void handleWarning(Exception exception, String string) {
        CMessageBox.showWarning(this.controller.getMainWindow(), string);
        if (exception != null) {
            Logger.logException(exception, string);
            return;
        }
        Logger.logWarning(string, new Object[0]);
    }

    public void startListening() {
        this.socket = new ServerSocket(this.port);
        Logger.logInfo("Starting IDA plugin socket socket listener thread...", new Object[0]);
        new IdaPluginListenerThread(this).start();
    }

    public ServerSocket getSocket() {
        return this.socket;
    }

    public int getPort() {
        return this.port;
    }
}

