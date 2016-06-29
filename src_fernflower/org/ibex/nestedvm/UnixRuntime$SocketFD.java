package org.ibex.nestedvm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import org.ibex.nestedvm.Runtime$ErrnoException;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.Runtime$SocketFStat;
import org.ibex.nestedvm.util.Platform;

class UnixRuntime$SocketFD extends Runtime$FD {
   public static final int TYPE_STREAM = 0;
   public static final int TYPE_DGRAM = 1;
   public static final int LISTEN = 2;
   int flags;
   int options;
   Socket s;
   ServerSocket ss;
   DatagramSocket ds;
   InetAddress bindAddr;
   int bindPort = -1;
   InetAddress connectAddr;
   int connectPort = -1;
   DatagramPacket dp;
   InputStream is;
   OutputStream os;
   private static final byte[] EMPTY = new byte[0];

   public int type() {
      return this.flags & 1;
   }

   public boolean listen() {
      return (this.flags & 2) != 0;
   }

   public UnixRuntime$SocketFD(int var1) {
      this.flags = var1;
      if(var1 == 1) {
         this.dp = new DatagramPacket(EMPTY, 0);
      }

   }

   public void setOptions() {
      try {
         if(this.s != null && this.type() == 0 && !this.listen()) {
            Platform.socketSetKeepAlive(this.s, (this.options & 8) != 0);
         }
      } catch (SocketException var2) {
         var2.printStackTrace();
      }

   }

   public void _close() {
      try {
         if(this.s != null) {
            this.s.close();
         }

         if(this.ss != null) {
            this.ss.close();
         }

         if(this.ds != null) {
            this.ds.close();
         }
      } catch (IOException var2) {
         ;
      }

   }

   public int read(byte[] var1, int var2, int var3) {
      if(this.type() == 1) {
         return this.recvfrom(var1, var2, var3, (InetAddress[])null, (int[])null);
      } else if(this.is == null) {
         throw new Runtime$ErrnoException(32);
      } else {
         try {
            int var4 = this.is.read(var1, var2, var3);
            return var4 < 0?0:var4;
         } catch (IOException var5) {
            throw new Runtime$ErrnoException(5);
         }
      }
   }

   public int recvfrom(byte[] var1, int var2, int var3, InetAddress[] var4, int[] var5) {
      if(this.type() == 0) {
         return this.read(var1, var2, var3);
      } else if(var2 != 0) {
         throw new IllegalArgumentException("off must be 0");
      } else {
         this.dp.setData(var1);
         this.dp.setLength(var3);

         try {
            if(this.ds == null) {
               this.ds = new DatagramSocket();
            }

            this.ds.receive(this.dp);
         } catch (IOException var7) {
            var7.printStackTrace();
            throw new Runtime$ErrnoException(5);
         }

         if(var4 != null) {
            var4[0] = this.dp.getAddress();
            var5[0] = this.dp.getPort();
         }

         return this.dp.getLength();
      }
   }

   public int write(byte[] var1, int var2, int var3) {
      if(this.type() == 1) {
         return this.sendto(var1, var2, var3, (InetAddress)null, -1);
      } else if(this.os == null) {
         throw new Runtime$ErrnoException(32);
      } else {
         try {
            this.os.write(var1, var2, var3);
            return var3;
         } catch (IOException var5) {
            throw new Runtime$ErrnoException(5);
         }
      }
   }

   public int sendto(byte[] var1, int var2, int var3, InetAddress var4, int var5) {
      if(var2 != 0) {
         throw new IllegalArgumentException("off must be 0");
      } else if(this.type() == 0) {
         return this.write(var1, var2, var3);
      } else {
         if(var4 == null) {
            var4 = this.connectAddr;
            var5 = this.connectPort;
            if(var4 == null) {
               throw new Runtime$ErrnoException(128);
            }
         }

         this.dp.setAddress(var4);
         this.dp.setPort(var5);
         this.dp.setData(var1);
         this.dp.setLength(var3);

         try {
            if(this.ds == null) {
               this.ds = new DatagramSocket();
            }

            this.ds.send(this.dp);
         } catch (IOException var7) {
            var7.printStackTrace();
            if("Network is unreachable".equals(var7.getMessage())) {
               throw new Runtime$ErrnoException(118);
            }

            throw new Runtime$ErrnoException(5);
         }

         return this.dp.getLength();
      }
   }

   public int flags() {
      return 2;
   }

   public Runtime$FStat _fstat() {
      return new Runtime$SocketFStat();
   }
}
