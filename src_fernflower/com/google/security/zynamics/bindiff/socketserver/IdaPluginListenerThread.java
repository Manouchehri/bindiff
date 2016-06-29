package com.google.security.zynamics.bindiff.socketserver;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.socketserver.SocketServer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class IdaPluginListenerThread extends Thread {
   private static final String NO_ACKNOWLEDGE = "nak";
   private static final String ACKNOWLEDGE = "ack";
   private final SocketServer server;

   public IdaPluginListenerThread(SocketServer var1) {
      this.server = (SocketServer)Preconditions.checkNotNull(var1);
   }

   private byte[] receiveChars(InputStream var1) {
      boolean var2 = true;
      byte[] var3 = new byte[4];
      if(var1.read(var3, 0, 4) != 4) {
         throw new IOException("Premature end of stream.");
      } else {
         int var4 = ByteBuffer.wrap(var3).order(ByteOrder.LITTLE_ENDIAN).getInt();
         byte[] var5 = new byte[var4];
         if(var1.read(var5, 0, var4) != var4) {
            throw new IOException("Unexpected end of stream.");
         } else {
            return var5;
         }
      }
   }

   private void send(OutputStream var1, String var2) {
      PrintStream var3 = new PrintStream(var1);
      Throwable var4 = null;

      try {
         var3.print(var2);
         if(var3.checkError()) {
            throw new IOException("Writing to socket server\'s output stream failed.");
         }
      } catch (Throwable var13) {
         var4 = var13;
         throw var13;
      } finally {
         if(var3 != null) {
            if(var4 != null) {
               try {
                  var3.close();
               } catch (Throwable var12) {
                  var4.addSuppressed(var12);
               }
            } else {
               var3.close();
            }
         }

      }

   }

   public void run() {
      while(!interrupted()) {
         try {
            Socket var1 = this.server.getSocket().accept();
            Throwable var2 = null;

            try {
               InputStream var3 = var1.getInputStream();
               Throwable var4 = null;

               try {
                  OutputStream var5 = var1.getOutputStream();
                  Throwable var6 = null;

                  try {
                     if(!var1.isConnected()) {
                        throw new IOException("Could not connect to BinDiff plugin.");
                     }

                     try {
                        this.server.handleReceivedByteBuffer(this.receiveChars(var3));
                     } catch (IOException var56) {
                        this.send(var5, "nak");
                     }

                     this.send(var5, "ack");
                  } catch (Throwable var57) {
                     var6 = var57;
                     throw var57;
                  } finally {
                     if(var5 != null) {
                        if(var6 != null) {
                           try {
                              var5.close();
                           } catch (Throwable var55) {
                              var6.addSuppressed(var55);
                           }
                        } else {
                           var5.close();
                        }
                     }

                  }
               } catch (Throwable var59) {
                  var4 = var59;
                  throw var59;
               } finally {
                  if(var3 != null) {
                     if(var4 != null) {
                        try {
                           var3.close();
                        } catch (Throwable var54) {
                           var4.addSuppressed(var54);
                        }
                     } else {
                        var3.close();
                     }
                  }

               }
            } catch (Throwable var61) {
               var2 = var61;
               throw var61;
            } finally {
               if(var1 != null) {
                  if(var2 != null) {
                     try {
                        var1.close();
                     } catch (Throwable var53) {
                        var2.addSuppressed(var53);
                     }
                  } else {
                     var1.close();
                  }
               }

            }
         } catch (SecurityException | IOException var63) {
            this.server.handleError(var63, var63.getMessage());
         }
      }

   }
}
