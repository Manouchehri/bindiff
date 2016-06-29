package com.google.security.zynamics.bindiff.processes;

import com.google.security.zynamics.bindiff.log.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessOutputStreamReader implements Runnable {
   private final String name;
   private final InputStream inStream;
   private Thread thread;

   public ProcessOutputStreamReader(String var1, InputStream var2) {
      this.name = var1;
      this.inStream = var2;
   }

   public void interruptThread() {
      if(this.thread != null) {
         this.thread.interrupt();
      }

   }

   public void run() {
      try {
         InputStreamReader var1 = new InputStreamReader(this.inStream);
         BufferedReader var2 = new BufferedReader(var1);

         while(!this.thread.isInterrupted()) {
            String var3 = var2.readLine();
            if(var3 == null) {
               break;
            }

            String var4 = this.name;
            String var5 = String.valueOf(var3.replace("%", "%%"));
            Logger.logInfo((new StringBuilder(3 + String.valueOf(var4).length() + String.valueOf(var5).length())).append("[").append(var4).append("] ").append(var5).toString(), new Object[0]);
         }
      } catch (Exception var14) {
         Logger.logException(var14, "Could\'t read process output stream.");
      } finally {
         if(this.inStream != null) {
            try {
               this.inStream.close();
            } catch (IOException var13) {
               Logger.logException(var13, "Could\'t close process output stream.");
            }
         }

      }

   }

   public void start() {
      this.thread = new Thread(this);
      this.thread.start();
   }
}
