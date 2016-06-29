package com.google.security.zynamics.bindiff.socketserver;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
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

   public SocketServer(int var1, WorkspaceTabPanelFunctions var2) {
      this.port = var1;
      this.socket = null;
      this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(var2);
   }

   public void handleReceivedByteBuffer(byte[] var1) {
      Logger.logInfo("Received byte stream from socket...", new Object[0]);

      try {
         IReadXmlHandlerData var2 = SocketXmlReader.readXMLData(new ByteArrayInputStream(var1));
         if(var2 instanceof FunctionDiffSocketXmlData) {
            this.controller.openFunctionDiffView((FunctionDiffSocketXmlData)var2);
         }
      } catch (IOException var4) {
         this.handleError(var4, "Couldn\'t handle received byte stream.");
      }

   }

   public void handleError(Exception var1, String var2) {
      CMessageBox.showError(this.controller.getMainWindow(), var2);
      if(var1 != null) {
         Logger.logException(var1, var2);
      } else {
         Logger.logSevere(var2, new Object[0]);
      }

   }

   public void handleWarning(Exception var1, String var2) {
      CMessageBox.showWarning(this.controller.getMainWindow(), var2);
      if(var1 != null) {
         Logger.logException(var1, var2);
      } else {
         Logger.logWarning(var2, new Object[0]);
      }

   }

   public void startListening() {
      this.socket = new ServerSocket(this.port);
      Logger.logInfo("Starting IDA plugin socket socket listener thread...", new Object[0]);
      (new IdaPluginListenerThread(this)).start();
   }

   public ServerSocket getSocket() {
      return this.socket;
   }

   public int getPort() {
      return this.port;
   }
}
