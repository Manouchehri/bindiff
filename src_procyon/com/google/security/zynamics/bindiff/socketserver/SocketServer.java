package com.google.security.zynamics.bindiff.socketserver;

import java.net.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.bindiff.io.*;
import java.io.*;
import com.google.security.zynamics.bindiff.io.matches.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;

public final class SocketServer
{
    private final int port;
    private ServerSocket socket;
    private final WorkspaceTabPanelFunctions controller;
    
    public SocketServer(final int port, final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.port = port;
        this.socket = null;
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
    }
    
    public void handleReceivedByteBuffer(final byte[] array) {
        Logger.logInfo("Received byte stream from socket...", new Object[0]);
        try {
            final IReadXmlHandlerData xmlData = SocketXmlReader.readXMLData(new ByteArrayInputStream(array));
            if (xmlData instanceof FunctionDiffSocketXmlData) {
                this.controller.openFunctionDiffView((FunctionDiffSocketXmlData)xmlData);
            }
        }
        catch (IOException ex) {
            this.handleError(ex, "Couldn't handle received byte stream.");
        }
    }
    
    public void handleError(final Exception ex, final String s) {
        CMessageBox.showError(this.controller.getMainWindow(), s);
        if (ex != null) {
            Logger.logException(ex, s);
        }
        else {
            Logger.logSevere(s, new Object[0]);
        }
    }
    
    public void handleWarning(final Exception ex, final String s) {
        CMessageBox.showWarning(this.controller.getMainWindow(), s);
        if (ex != null) {
            Logger.logException(ex, s);
        }
        else {
            Logger.logWarning(s, new Object[0]);
        }
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
