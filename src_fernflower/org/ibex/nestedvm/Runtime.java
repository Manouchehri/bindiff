package org.ibex.nestedvm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.ibex.nestedvm.Registers;
import org.ibex.nestedvm.Runtime$1;
import org.ibex.nestedvm.Runtime$CPUState;
import org.ibex.nestedvm.Runtime$CallException;
import org.ibex.nestedvm.Runtime$CallJavaCB;
import org.ibex.nestedvm.Runtime$ErrnoException;
import org.ibex.nestedvm.Runtime$ExecutionException;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.Runtime$FaultException;
import org.ibex.nestedvm.Runtime$HostFStat;
import org.ibex.nestedvm.Runtime$ReadFaultException;
import org.ibex.nestedvm.Runtime$SecurityManager;
import org.ibex.nestedvm.Runtime$TerminalFD;
import org.ibex.nestedvm.Runtime$Win32ConsoleIS;
import org.ibex.nestedvm.Runtime$WriteFaultException;
import org.ibex.nestedvm.UsermodeConstants;
import org.ibex.nestedvm.util.Platform;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$File;

public abstract class Runtime implements Cloneable, Registers, UsermodeConstants {
   public static final String VERSION = "1.0";
   static final boolean STDERR_DIAG = true;
   protected final int pageShift;
   private final int stackBottom;
   protected int[][] readPages;
   protected int[][] writePages;
   private int heapEnd;
   private static final int STACK_GUARD_PAGES = 4;
   private long startTime;
   public static final int RUNNING = 0;
   public static final int STOPPED = 1;
   public static final int PAUSED = 2;
   public static final int CALLJAVA = 3;
   public static final int EXITED = 4;
   public static final int EXECED = 5;
   protected int state;
   private int exitStatus;
   public Runtime$ExecutionException exitException;
   Runtime$FD[] fds;
   boolean[] closeOnExec;
   Runtime$SecurityManager sm;
   private Runtime$CallJavaCB callJavaCB;
   private byte[] _byteBuf;
   static final int MAX_CHUNK = 16776192;
   static final boolean win32Hacks;
   public static final int RD_ONLY = 0;
   public static final int WR_ONLY = 1;
   public static final int RDWR = 2;
   public static final int O_CREAT = 512;
   public static final int O_EXCL = 2048;
   public static final int O_APPEND = 8;
   public static final int O_TRUNC = 1024;
   public static final int O_NONBLOCK = 16384;
   public static final int O_NOCTTY = 32768;

   protected abstract int heapStart();

   protected abstract int entryPoint();

   protected int userInfoBase() {
      return 0;
   }

   protected int userInfoSize() {
      return 0;
   }

   protected abstract int gp();

   public final int getState() {
      return this.state;
   }

   public void setSecurityManager(Runtime$SecurityManager var1) {
      this.sm = var1;
   }

   public void setCallJavaCB(Runtime$CallJavaCB var1) {
      this.callJavaCB = var1;
   }

   protected abstract void _execute();

   public int lookupSymbol(String var1) {
      return -1;
   }

   protected abstract void getCPUState(Runtime$CPUState var1);

   protected abstract void setCPUState(Runtime$CPUState var1);

   protected Object clone() {
      Runtime var1 = (Runtime)super.clone();
      var1._byteBuf = null;
      var1.startTime = 0L;
      var1.fds = new Runtime$FD[64];

      int var2;
      for(var2 = 0; var2 < 64; ++var2) {
         if(this.fds[var2] != null) {
            var1.fds[var2] = this.fds[var2].dup();
         }
      }

      var2 = this.writePages.length;
      var1.readPages = new int[var2][];
      var1.writePages = new int[var2][];

      for(int var3 = 0; var3 < var2; ++var3) {
         if(this.readPages[var3] != null) {
            if(this.writePages[var3] == null) {
               var1.readPages[var3] = this.readPages[var3];
            } else {
               var1.readPages[var3] = var1.writePages[var3] = (int[])((int[])this.writePages[var3].clone());
            }
         }
      }

      return var1;
   }

   protected Runtime(int var1, int var2) {
      this(var1, var2, false);
   }

   protected Runtime(int var1, int var2, boolean var3) {
      this.state = 1;
      if(var1 <= 0) {
         throw new IllegalArgumentException("pageSize <= 0");
      } else if(var2 <= 0) {
         throw new IllegalArgumentException("totalPages <= 0");
      } else if((var1 & var1 - 1) != 0) {
         throw new IllegalArgumentException("pageSize not a power of two");
      } else {
         int var4;
         for(var4 = 0; var1 >>> var4 != 1; ++var4) {
            ;
         }

         this.pageShift = var4;
         int var5 = this.heapStart();
         int var6 = var2 * var1;
         int var7 = max(var6 / 512, 131072);
         boolean var8 = false;
         if(var2 > 1) {
            var7 = max(var7, var1);
            var7 = var7 + var1 - 1 & ~(var1 - 1);
            int var10 = var7 >>> this.pageShift;
            var5 = var5 + var1 - 1 & ~(var1 - 1);
            if(var10 + 4 + (var5 >>> this.pageShift) >= var2) {
               throw new IllegalArgumentException("total pages too small");
            }
         } else {
            if(var1 < var5 + var7) {
               throw new IllegalArgumentException("total memory too small");
            }

            var5 = var5 + 4095 & -4097;
         }

         this.stackBottom = var6 - var7;
         this.heapEnd = var5;
         this.readPages = new int[var2][];
         this.writePages = new int[var2][];
         if(var2 == 1) {
            this.readPages[0] = this.writePages[0] = new int[var1 >> 2];
         } else {
            for(int var9 = this.stackBottom >>> this.pageShift; var9 < this.writePages.length; ++var9) {
               this.readPages[var9] = this.writePages[var9] = new int[var1 >> 2];
            }
         }

         if(!var3) {
            this.fds = new Runtime$FD[64];
            this.closeOnExec = new boolean[64];
            Object var11 = win32Hacks?new Runtime$Win32ConsoleIS(System.in):System.in;
            this.addFD(new Runtime$TerminalFD((InputStream)var11));
            this.addFD(new Runtime$TerminalFD(System.out));
            this.addFD(new Runtime$TerminalFD(System.err));
         }

      }
   }

   protected final void initPages(int[] var1, int var2, boolean var3) {
      int var4 = 1 << this.pageShift >>> 2;
      int var5 = (1 << this.pageShift) - 1;

      int var9;
      for(int var6 = 0; var6 < var1.length; var2 += var9 * 4) {
         int var7 = var2 >>> this.pageShift;
         int var8 = (var2 & var5) >> 2;
         var9 = min(var4 - var8, var1.length - var6);
         if(this.readPages[var7] == null) {
            this.initPage(var7, var3);
         } else if(!var3 && this.writePages[var7] == null) {
            this.writePages[var7] = this.readPages[var7];
         }

         System.arraycopy(var1, var6, this.readPages[var7], var8, var9);
         var6 += var9;
      }

   }

   protected final void clearPages(int var1, int var2) {
      int var3 = 1 << this.pageShift >>> 2;
      int var4 = (1 << this.pageShift) - 1;

      int var8;
      for(int var5 = 0; var5 < var2; var1 += var8 * 4) {
         int var6 = var1 >>> this.pageShift;
         int var7 = (var1 & var4) >> 2;
         var8 = min(var3 - var7, var2 - var5);
         if(this.readPages[var6] == null) {
            this.readPages[var6] = this.writePages[var6] = new int[var3];
         } else {
            if(this.writePages[var6] == null) {
               this.writePages[var6] = this.readPages[var6];
            }

            for(int var9 = var7; var9 < var7 + var8; ++var9) {
               this.writePages[var6][var9] = 0;
            }
         }

         var5 += var8;
      }

   }

   public final void copyin(int var1, byte[] var2, int var3) {
      int var4 = 1 << this.pageShift >>> 2;
      int var5 = var4 - 1;
      int var6 = 0;
      if(var3 != 0) {
         int var7;
         if((var1 & 3) != 0) {
            var7 = this.memRead(var1 & -4);
            switch(var1 & 3) {
            case 1:
               var2[var6++] = (byte)(var7 >>> 16 & 255);
               --var3;
               if(var3 == 0) {
                  break;
               }
            case 2:
               var2[var6++] = (byte)(var7 >>> 8 & 255);
               --var3;
               if(var3 == 0) {
                  break;
               }
            case 3:
               var2[var6++] = (byte)(var7 >>> 0 & 255);
               --var3;
               if(var3 == 0) {
                  ;
               }
            }

            var1 = (var1 & -4) + 4;
         }

         if((var3 & -4) != 0) {
            var7 = var3 >>> 2;

            int var8;
            int var11;
            for(var8 = var1 >>> 2; var7 != 0; var7 -= var11) {
               int[] var9 = this.readPages[var8 >>> this.pageShift - 2];
               if(var9 == null) {
                  throw new Runtime$ReadFaultException(var8 << 2);
               }

               int var10 = var8 & var5;
               var11 = min(var7, var4 - var10);

               for(int var12 = 0; var12 < var11; var6 += 4) {
                  int var13 = var9[var10 + var12];
                  var2[var6 + 0] = (byte)(var13 >>> 24 & 255);
                  var2[var6 + 1] = (byte)(var13 >>> 16 & 255);
                  var2[var6 + 2] = (byte)(var13 >>> 8 & 255);
                  var2[var6 + 3] = (byte)(var13 >>> 0 & 255);
                  ++var12;
               }

               var8 += var11;
            }

            var1 = var8 << 2;
            var3 &= 3;
         }

         if(var3 != 0) {
            var7 = this.memRead(var1);
            switch(var3) {
            case 3:
               var2[var6 + 2] = (byte)(var7 >>> 8 & 255);
            case 2:
               var2[var6 + 1] = (byte)(var7 >>> 16 & 255);
            case 1:
               var2[var6 + 0] = (byte)(var7 >>> 24 & 255);
            }
         }

      }
   }

   public final void copyout(byte[] var1, int var2, int var3) {
      int var4 = 1 << this.pageShift >>> 2;
      int var5 = var4 - 1;
      int var6 = 0;
      if(var3 != 0) {
         int var7;
         if((var2 & 3) != 0) {
            var7 = this.memRead(var2 & -4);
            switch(var2 & 3) {
            case 1:
               var7 = var7 & -16711681 | (var1[var6++] & 255) << 16;
               --var3;
               if(var3 == 0) {
                  break;
               }
            case 2:
               var7 = var7 & -65281 | (var1[var6++] & 255) << 8;
               --var3;
               if(var3 == 0) {
                  break;
               }
            case 3:
               var7 = var7 & -256 | (var1[var6++] & 255) << 0;
               --var3;
               if(var3 == 0) {
                  ;
               }
            }

            this.memWrite(var2 & -4, var7);
            var2 += var6;
         }

         if((var3 & -4) != 0) {
            var7 = var3 >>> 2;

            int var8;
            int var11;
            for(var8 = var2 >>> 2; var7 != 0; var7 -= var11) {
               int[] var9 = this.writePages[var8 >>> this.pageShift - 2];
               if(var9 == null) {
                  throw new Runtime$WriteFaultException(var8 << 2);
               }

               int var10 = var8 & var5;
               var11 = min(var7, var4 - var10);

               for(int var12 = 0; var12 < var11; var6 += 4) {
                  var9[var10 + var12] = (var1[var6 + 0] & 255) << 24 | (var1[var6 + 1] & 255) << 16 | (var1[var6 + 2] & 255) << 8 | (var1[var6 + 3] & 255) << 0;
                  ++var12;
               }

               var8 += var11;
            }

            var2 = var8 << 2;
            var3 &= 3;
         }

         if(var3 != 0) {
            var7 = this.memRead(var2);
            switch(var3) {
            case 1:
               var7 = var7 & 16777215 | (var1[var6 + 0] & 255) << 24;
               break;
            case 2:
               var7 = var7 & '\uffff' | (var1[var6 + 0] & 255) << 24 | (var1[var6 + 1] & 255) << 16;
               break;
            case 3:
               var7 = var7 & 255 | (var1[var6 + 0] & 255) << 24 | (var1[var6 + 1] & 255) << 16 | (var1[var6 + 2] & 255) << 8;
            }

            this.memWrite(var2, var7);
         }

      }
   }

   public final void memcpy(int var1, int var2, int var3) {
      int var4 = 1 << this.pageShift >>> 2;
      int var5 = var4 - 1;
      int var6;
      if((var1 & 3) == 0 && (var2 & 3) == 0) {
         int var14;
         if((var3 & -4) != 0) {
            var6 = var3 >> 2;
            var14 = var2 >>> 2;

            int var8;
            int var13;
            for(var8 = var1 >>> 2; var6 != 0; var6 -= var13) {
               int[] var9 = this.readPages[var14 >>> this.pageShift - 2];
               if(var9 == null) {
                  throw new Runtime$ReadFaultException(var14 << 2);
               }

               int[] var10 = this.writePages[var8 >>> this.pageShift - 2];
               if(var10 == null) {
                  throw new Runtime$WriteFaultException(var8 << 2);
               }

               int var11 = var14 & var5;
               int var12 = var8 & var5;
               var13 = min(var6, var4 - max(var11, var12));
               System.arraycopy(var9, var11, var10, var12, var13);
               var14 += var13;
               var8 += var13;
            }

            var2 = var14 << 2;
            var1 = var8 << 2;
            var3 &= 3;
         }

         if(var3 != 0) {
            var6 = this.memRead(var2);
            var14 = this.memRead(var1);
            switch(var3) {
            case 1:
               this.memWrite(var1, var6 & -16777216 | var14 & 16777215);
               break;
            case 2:
               this.memWrite(var1, var6 & -65536 | var14 & '\uffff');
               break;
            case 3:
               this.memWrite(var1, var6 & -256 | var14 & 255);
            }
         }
      } else {
         while(var3 > 0) {
            var6 = min(var3, 16776192);
            byte[] var7 = this.byteBuf(var6);
            this.copyin(var2, var7, var6);
            this.copyout(var7, var1, var6);
            var3 -= var6;
            var2 += var6;
            var1 += var6;
         }
      }

   }

   public final void memset(int var1, int var2, int var3) {
      int var4 = 1 << this.pageShift >>> 2;
      int var5 = var4 - 1;
      int var6 = (var2 & 255) << 24 | (var2 & 255) << 16 | (var2 & 255) << 8 | (var2 & 255) << 0;
      int var7;
      if((var1 & 3) != 0) {
         var7 = this.memRead(var1 & -4);
         switch(var1 & 3) {
         case 1:
            var7 = var7 & -16711681 | (var2 & 255) << 16;
            --var3;
            if(var3 == 0) {
               break;
            }
         case 2:
            var7 = var7 & -65281 | (var2 & 255) << 8;
            --var3;
            if(var3 == 0) {
               break;
            }
         case 3:
            var7 = var7 & -256 | (var2 & 255) << 0;
            --var3;
            if(var3 == 0) {
               ;
            }
         }

         this.memWrite(var1 & -4, var7);
         var1 = (var1 & -4) + 4;
      }

      if((var3 & -4) != 0) {
         var7 = var3 >> 2;

         int var8;
         int var11;
         for(var8 = var1 >>> 2; var7 != 0; var7 -= var11) {
            int[] var9 = this.readPages[var8 >>> this.pageShift - 2];
            if(var9 == null) {
               throw new Runtime$WriteFaultException(var8 << 2);
            }

            int var10 = var8 & var5;
            var11 = min(var7, var4 - var10);

            for(int var12 = var10; var12 < var10 + var11; ++var12) {
               var9[var12] = var6;
            }

            var8 += var11;
         }

         var1 = var8 << 2;
         var3 &= 3;
      }

      if(var3 != 0) {
         var7 = this.memRead(var1);
         switch(var3) {
         case 1:
            var7 = var7 & 16777215 | var6 & -16777216;
            break;
         case 2:
            var7 = var7 & '\uffff' | var6 & -65536;
            break;
         case 3:
            var7 = var7 & 255 | var6 & -256;
         }

         this.memWrite(var1, var7);
      }

   }

   public final int memRead(int var1) {
      if((var1 & 3) != 0) {
         throw new Runtime$ReadFaultException(var1);
      } else {
         return this.unsafeMemRead(var1);
      }
   }

   protected final int unsafeMemRead(int var1) {
      int var2 = var1 >>> this.pageShift;
      int var3 = (var1 & (1 << this.pageShift) - 1) >> 2;

      try {
         return this.readPages[var2][var3];
      } catch (ArrayIndexOutOfBoundsException var5) {
         if(var2 >= 0 && var2 < this.readPages.length) {
            throw var5;
         } else {
            throw new Runtime$ReadFaultException(var1);
         }
      } catch (NullPointerException var6) {
         throw new Runtime$ReadFaultException(var1);
      }
   }

   public final void memWrite(int var1, int var2) {
      if((var1 & 3) != 0) {
         throw new Runtime$WriteFaultException(var1);
      } else {
         this.unsafeMemWrite(var1, var2);
      }
   }

   protected final void unsafeMemWrite(int var1, int var2) {
      int var3 = var1 >>> this.pageShift;
      int var4 = (var1 & (1 << this.pageShift) - 1) >> 2;

      try {
         this.writePages[var3][var4] = var2;
      } catch (ArrayIndexOutOfBoundsException var6) {
         if(var3 >= 0 && var3 < this.writePages.length) {
            throw var6;
         } else {
            throw new Runtime$WriteFaultException(var1);
         }
      } catch (NullPointerException var7) {
         throw new Runtime$WriteFaultException(var1);
      }
   }

   private final int[] initPage(int var1) {
      return this.initPage(var1, false);
   }

   private final int[] initPage(int var1, boolean var2) {
      int[] var3 = new int[1 << this.pageShift >>> 2];
      this.writePages[var1] = var2?null:var3;
      this.readPages[var1] = var3;
      return var3;
   }

   public final int exitStatus() {
      if(this.state != 4) {
         throw new IllegalStateException("exitStatus() called in an inappropriate state");
      } else {
         return this.exitStatus;
      }
   }

   private int addStringArray(String[] var1, int var2) {
      int var3 = var1.length;
      int var4 = 0;

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4 += var1[var5].length() + 1;
      }

      var4 += (var3 + 1) * 4;
      var5 = var2 - var4 & -4;
      int var6 = var5 + (var3 + 1) * 4;
      int[] var7 = new int[var3 + 1];

      try {
         int var8;
         for(var8 = 0; var8 < var3; ++var8) {
            byte[] var9 = getBytes(var1[var8]);
            var7[var8] = var6;
            this.copyout(var9, var6, var9.length);
            this.memset(var6 + var9.length, 0, 1);
            var6 += var9.length + 1;
         }

         var6 = var5;

         for(var8 = 0; var8 < var3 + 1; ++var8) {
            this.memWrite(var6, var7[var8]);
            var6 += 4;
         }

         return var5;
      } catch (Runtime$FaultException var10) {
         throw new RuntimeException(var10.toString());
      }
   }

   String[] createEnv(String[] var1) {
      if(var1 == null) {
         var1 = new String[0];
      }

      return var1;
   }

   public void setUserInfo(int var1, int var2) {
      if(var1 >= 0 && var1 < this.userInfoSize() / 4) {
         try {
            this.memWrite(this.userInfoBase() + var1 * 4, var2);
         } catch (Runtime$FaultException var4) {
            throw new RuntimeException(var4.toString());
         }
      } else {
         throw new IndexOutOfBoundsException("setUserInfo called with index >= " + this.userInfoSize() / 4);
      }
   }

   public int getUserInfo(int var1) {
      if(var1 >= 0 && var1 < this.userInfoSize() / 4) {
         try {
            return this.memRead(this.userInfoBase() + var1 * 4);
         } catch (Runtime$FaultException var3) {
            throw new RuntimeException(var3.toString());
         }
      } else {
         throw new IndexOutOfBoundsException("setUserInfo called with index >= " + this.userInfoSize() / 4);
      }
   }

   private void __execute() {
      try {
         this._execute();
      } catch (Runtime$FaultException var2) {
         var2.printStackTrace();
         this.exit(139, true);
         this.exitException = var2;
      } catch (Runtime$ExecutionException var3) {
         var3.printStackTrace();
         this.exit(132, true);
         this.exitException = var3;
      }

   }

   public final boolean execute() {
      if(this.state != 2) {
         throw new IllegalStateException("execute() called in inappropriate state");
      } else {
         if(this.startTime == 0L) {
            this.startTime = System.currentTimeMillis();
         }

         this.state = 0;
         this.__execute();
         if(this.state != 2 && this.state != 4 && this.state != 5) {
            throw new IllegalStateException("execute() ended up in an inappropriate state (" + this.state + ")");
         } else {
            return this.state != 2;
         }
      }
   }

   static String[] concatArgv(String var0, String[] var1) {
      String[] var2 = new String[var1.length + 1];
      System.arraycopy(var1, 0, var2, 1, var1.length);
      var2[0] = var0;
      return var2;
   }

   public final int run() {
      return this.run((String[])null);
   }

   public final int run(String var1, String[] var2) {
      return this.run(concatArgv(var1, var2));
   }

   public final int run(String[] var1) {
      return this.run((String[])var1, (String[])null);
   }

   public final int run(String[] var1, String[] var2) {
      this.start(var1, var2);

      while(!this.execute()) {
         System.err.println("WARNING: Pause requested while executing run()");
      }

      if(this.state == 5) {
         System.err.println("WARNING: Process exec()ed while being run under run()");
      }

      return this.state == 4?this.exitStatus():0;
   }

   public final void start() {
      this.start((String[])null);
   }

   public final void start(String[] var1) {
      this.start(var1, (String[])null);
   }

   public final void start(String[] var1, String[] var2) {
      if(this.state != 1) {
         throw new IllegalStateException("start() called in inappropriate state");
      } else {
         if(var1 == null) {
            var1 = new String[]{this.getClass().getName()};
         }

         int var3;
         int var4 = var3 = this.writePages.length * (1 << this.pageShift);

         int var5;
         int var6;
         try {
            var4 = var5 = this.addStringArray(var1, var4);
            var4 = var6 = this.addStringArray(this.createEnv(var2), var4);
         } catch (Runtime$FaultException var8) {
            throw new IllegalArgumentException("args/environ too big");
         }

         var4 &= -16;
         if(var3 - var4 > 65536) {
            throw new IllegalArgumentException("args/environ too big");
         } else {
            if(this.heapEnd == 0) {
               this.heapEnd = this.heapStart();
               if(this.heapEnd == 0) {
                  throw new Error("heapEnd == 0");
               }

               int var7 = this.writePages.length == 1?4096:1 << this.pageShift;
               this.heapEnd = this.heapEnd + var7 - 1 & ~(var7 - 1);
            }

            Runtime$CPUState var9 = new Runtime$CPUState();
            var9.r[4] = var5;
            var9.r[5] = var6;
            var9.r[29] = var4;
            var9.r[31] = -559038737;
            var9.r[28] = this.gp();
            var9.pc = this.entryPoint();
            this.setCPUState(var9);
            this.state = 2;
            this._started();
         }
      }
   }

   public final void stop() {
      if(this.state != 0 && this.state != 2) {
         throw new IllegalStateException("stop() called in inappropriate state");
      } else {
         this.exit(0, false);
      }
   }

   void _started() {
   }

   public final int call(String var1, Object[] var2) {
      if(this.state != 2 && this.state != 3) {
         throw new IllegalStateException("call() called in inappropriate state");
      } else if(var2.length > 7) {
         throw new IllegalArgumentException("args.length > 7");
      } else {
         Runtime$CPUState var3 = new Runtime$CPUState();
         this.getCPUState(var3);
         int var4 = var3.r[29];
         int[] var5 = new int[var2.length];

         int var6;
         for(var6 = 0; var6 < var2.length; ++var6) {
            Object var7 = var2[var6];
            byte[] var8 = null;
            if(var7 instanceof String) {
               var8 = getBytes((String)var7);
            } else if(var7 instanceof byte[]) {
               var8 = (byte[])((byte[])var7);
            } else if(var7 instanceof Number) {
               var5[var6] = ((Number)var7).intValue();
            }

            if(var8 != null) {
               var4 -= var8.length;
               this.copyout(var8, var4, var8.length);
               var5[var6] = var4;
            }
         }

         var6 = var3.r[29];
         if(var6 == var4) {
            return this.call(var1, var5);
         } else {
            var3.r[29] = var4;
            this.setCPUState(var3);
            int var9 = this.call(var1, var5);
            var3.r[29] = var6;
            this.setCPUState(var3);
            return var9;
         }
      }
   }

   public final int call(String var1) {
      return this.call(var1, new int[0]);
   }

   public final int call(String var1, int var2) {
      return this.call(var1, new int[]{var2});
   }

   public final int call(String var1, int var2, int var3) {
      return this.call(var1, new int[]{var2, var3});
   }

   public final int call(String var1, int[] var2) {
      int var3 = this.lookupSymbol(var1);
      if(var3 == -1) {
         throw new Runtime$CallException(var1 + " not found");
      } else {
         int var4 = this.lookupSymbol("_call_helper");
         if(var4 == -1) {
            throw new Runtime$CallException("_call_helper not found");
         } else {
            return this.call(var4, var3, var2);
         }
      }
   }

   public final int call(int var1, int var2, int[] var3) {
      if(var3.length > 7) {
         throw new IllegalArgumentException("rest.length > 7");
      } else if(this.state != 2 && this.state != 3) {
         throw new IllegalStateException("call() called in inappropriate state");
      } else {
         int var4 = this.state;
         Runtime$CPUState var5 = new Runtime$CPUState();
         this.getCPUState(var5);
         Runtime$CPUState var6 = var5.dup();
         var6.r[29] &= -16;
         var6.r[31] = -559038737;
         var6.r[4] = var2;
         switch(var3.length) {
         case 7:
            var6.r[19] = var3[6];
         case 6:
            var6.r[18] = var3[5];
         case 5:
            var6.r[17] = var3[4];
         case 4:
            var6.r[16] = var3[3];
         case 3:
            var6.r[7] = var3[2];
         case 2:
            var6.r[6] = var3[1];
         case 1:
            var6.r[5] = var3[0];
         default:
            var6.pc = var1;
            this.state = 0;
            this.setCPUState(var6);
            this.__execute();
            this.getCPUState(var6);
            this.setCPUState(var5);
            if(this.state != 2) {
               throw new Runtime$CallException("Process exit()ed while servicing a call() request");
            } else {
               this.state = var4;
               return var6.r[3];
            }
         }
      }
   }

   public final int addFD(Runtime$FD var1) {
      if(this.state != 4 && this.state != 5) {
         int var2;
         for(var2 = 0; var2 < 64 && this.fds[var2] != null; ++var2) {
            ;
         }

         if(var2 == 64) {
            return -1;
         } else {
            this.fds[var2] = var1;
            this.closeOnExec[var2] = false;
            return var2;
         }
      } else {
         throw new IllegalStateException("addFD called in inappropriate state");
      }
   }

   void _preCloseFD(Runtime$FD var1) {
   }

   void _postCloseFD(Runtime$FD var1) {
   }

   public final boolean closeFD(int var1) {
      if(this.state != 4 && this.state != 5) {
         if(var1 >= 0 && var1 < 64) {
            if(this.fds[var1] == null) {
               return false;
            } else {
               this._preCloseFD(this.fds[var1]);
               this.fds[var1].close();
               this._postCloseFD(this.fds[var1]);
               this.fds[var1] = null;
               return true;
            }
         } else {
            return false;
         }
      } else {
         throw new IllegalStateException("closeFD called in inappropriate state");
      }
   }

   public final int dupFD(int var1) {
      if(var1 >= 0 && var1 < 64) {
         if(this.fds[var1] == null) {
            return -1;
         } else {
            int var2;
            for(var2 = 0; var2 < 64 && this.fds[var2] != null; ++var2) {
               ;
            }

            if(var2 == 64) {
               return -1;
            } else {
               this.fds[var2] = this.fds[var1].dup();
               return var2;
            }
         }
      } else {
         return -1;
      }
   }

   Runtime$FD hostFSOpen(File var1, int var2, int var3, Object var4) {
      if((var2 & -3596) != 0) {
         System.err.println("WARNING: Unsupported flags passed to open(\"" + var1 + "\"): " + toHex(var2 & -3596));
         throw new Runtime$ErrnoException(134);
      } else {
         boolean var5 = (var2 & 3) != 0;
         if(this.sm != null) {
            label74: {
               if(var5) {
                  if(this.sm.allowWrite(var1)) {
                     break label74;
                  }
               } else if(this.sm.allowRead(var1)) {
                  break label74;
               }

               throw new Runtime$ErrnoException(13);
            }
         }

         if((var2 & 2560) == 2560) {
            try {
               if(!Platform.atomicCreateFile(var1)) {
                  throw new Runtime$ErrnoException(17);
               }
            } catch (IOException var8) {
               throw new Runtime$ErrnoException(5);
            }
         } else if(!var1.exists()) {
            if((var2 & 512) == 0) {
               return null;
            }
         } else if(var1.isDirectory()) {
            return this.hostFSDirFD(var1, var4);
         }

         Seekable$File var6;
         try {
            var6 = new Seekable$File(var1, var5, (var2 & 1024) != 0);
         } catch (FileNotFoundException var9) {
            if(var9.getMessage() != null && var9.getMessage().indexOf("Permission denied") >= 0) {
               throw new Runtime$ErrnoException(13);
            }

            return null;
         } catch (IOException var10) {
            throw new Runtime$ErrnoException(5);
         }

         return new Runtime$1(this, var6, var2, var1, var6, var4);
      }
   }

   Runtime$FStat hostFStat(File var1, Seekable$File var2, Object var3) {
      return new Runtime$HostFStat(var1, var2);
   }

   Runtime$FD hostFSDirFD(File var1, Object var2) {
      return null;
   }

   Runtime$FD _open(String var1, int var2, int var3) {
      return this.hostFSOpen(new File(var1), var2, var3, (Object)null);
   }

   private int sys_open(int var1, int var2, int var3) {
      String var4 = this.cstring(var1);
      if(var4.length() == 1024 && this.getClass().getName().equals("tests.TeX")) {
         var4 = var4.trim();
      }

      var2 &= -32769;
      Runtime$FD var5 = this._open(var4, var2, var3);
      if(var5 == null) {
         return -2;
      } else {
         int var6 = this.addFD(var5);
         if(var6 == -1) {
            var5.close();
            return -23;
         } else {
            return var6;
         }
      }
   }

   private int sys_write(int var1, int var2, int var3) {
      var3 = Math.min(var3, 16776192);
      if(var1 >= 0 && var1 < 64) {
         if(this.fds[var1] == null) {
            return -81;
         } else {
            byte[] var4 = this.byteBuf(var3);
            this.copyin(var2, var4, var3);

            try {
               return this.fds[var1].write(var4, 0, var3);
            } catch (Runtime$ErrnoException var6) {
               if(var6.errno == 32) {
                  this.sys_exit(141);
               }

               throw var6;
            }
         }
      } else {
         return -81;
      }
   }

   private int sys_read(int var1, int var2, int var3) {
      var3 = Math.min(var3, 16776192);
      if(var1 >= 0 && var1 < 64) {
         if(this.fds[var1] == null) {
            return -81;
         } else {
            byte[] var4 = this.byteBuf(var3);
            int var5 = this.fds[var1].read(var4, 0, var3);
            this.copyout(var4, var2, var5);
            return var5;
         }
      } else {
         return -81;
      }
   }

   private int sys_ftruncate(int var1, long var2) {
      if(var1 >= 0 && var1 < 64) {
         if(this.fds[var1] == null) {
            return -81;
         } else {
            Seekable var4 = this.fds[var1].seekable();
            if(var2 >= 0L && var4 != null) {
               try {
                  var4.resize(var2);
                  return 0;
               } catch (IOException var6) {
                  return -5;
               }
            } else {
               return -22;
            }
         }
      } else {
         return -81;
      }
   }

   private int sys_close(int var1) {
      return this.closeFD(var1)?0:-81;
   }

   private int sys_lseek(int var1, int var2, int var3) {
      if(var1 >= 0 && var1 < 64) {
         if(this.fds[var1] == null) {
            return -81;
         } else if(var3 != 0 && var3 != 1 && var3 != 2) {
            return -22;
         } else {
            int var4 = this.fds[var1].seek(var2, var3);
            return var4 < 0?-29:var4;
         }
      } else {
         return -81;
      }
   }

   int stat(Runtime$FStat var1, int var2) {
      this.memWrite(var2 + 0, var1.dev() << 16 | var1.inode() & '\uffff');
      this.memWrite(var2 + 4, var1.type() & '\uf000' | var1.mode() & 4095);
      this.memWrite(var2 + 8, var1.nlink() << 16 | var1.uid() & '\uffff');
      this.memWrite(var2 + 12, var1.gid() << 16 | 0);
      this.memWrite(var2 + 16, var1.size());
      this.memWrite(var2 + 20, var1.atime());
      this.memWrite(var2 + 28, var1.mtime());
      this.memWrite(var2 + 36, var1.ctime());
      this.memWrite(var2 + 44, var1.blksize());
      this.memWrite(var2 + 48, var1.blocks());
      return 0;
   }

   private int sys_fstat(int var1, int var2) {
      return var1 >= 0 && var1 < 64?(this.fds[var1] == null?-81:this.stat(this.fds[var1].fstat(), var2)):-81;
   }

   private int sys_gettimeofday(int var1, int var2) {
      long var3 = System.currentTimeMillis();
      int var5 = (int)(var3 / 1000L);
      int var6 = (int)(var3 % 1000L * 1000L);
      this.memWrite(var1 + 0, var5);
      this.memWrite(var1 + 4, var6);
      return 0;
   }

   private int sys_sleep(int var1) {
      if(var1 < 0) {
         var1 = Integer.MAX_VALUE;
      }

      try {
         Thread.sleep((long)var1 * 1000L);
         return 0;
      } catch (InterruptedException var3) {
         return -1;
      }
   }

   private int sys_times(int var1) {
      long var2 = System.currentTimeMillis();
      int var4 = (int)((var2 - this.startTime) / 16L);
      int var5 = (int)((var2 - this.startTime) / 16L);

      try {
         if(var1 != 0) {
            this.memWrite(var1 + 0, var4);
            this.memWrite(var1 + 4, var5);
            this.memWrite(var1 + 8, var4);
            this.memWrite(var1 + 12, var5);
         }
      } catch (Runtime$FaultException var7) {
         return -14;
      }

      return (int)var2;
   }

   private int sys_sysconf(int var1) {
      switch(var1) {
      case 2:
         return 1000;
      case 8:
         return this.writePages.length == 1?4096:1 << this.pageShift;
      case 11:
         return this.writePages.length == 1?(1 << this.pageShift) / 4096:this.writePages.length;
      default:
         System.err.println("WARNING: Attempted to use unknown sysconf key: " + var1);
         return -22;
      }
   }

   public final int sbrk(int var1) {
      if(var1 < 0) {
         return -12;
      } else if(var1 == 0) {
         return this.heapEnd;
      } else {
         var1 = var1 + 3 & -4;
         int var2 = this.heapEnd;
         int var3 = var2 + var1;
         if(var3 >= this.stackBottom) {
            return -12;
         } else {
            if(this.writePages.length > 1) {
               int var4 = (1 << this.pageShift) - 1;
               int var5 = 1 << this.pageShift >>> 2;
               int var6 = var2 + var4 >>> this.pageShift;
               int var7 = var3 + var4 >>> this.pageShift;

               try {
                  for(int var8 = var6; var8 < var7; ++var8) {
                     this.readPages[var8] = this.writePages[var8] = new int[var5];
                  }
               } catch (OutOfMemoryError var9) {
                  System.err.println("WARNING: Caught OOM Exception in sbrk: " + var9);
                  return -12;
               }
            }

            this.heapEnd = var3;
            return var2;
         }
      }
   }

   private int sys_getpid() {
      return this.getPid();
   }

   int getPid() {
      return 1;
   }

   private int sys_calljava(int var1, int var2, int var3, int var4) {
      if(this.state != 0) {
         throw new IllegalStateException("wound up calling sys_calljava while not in RUNNING");
      } else if(this.callJavaCB != null) {
         this.state = 3;

         int var5;
         try {
            var5 = this.callJavaCB.call(var1, var2, var3, var4);
         } catch (RuntimeException var7) {
            System.err.println("Error while executing callJavaCB");
            var7.printStackTrace();
            var5 = 0;
         }

         this.state = 0;
         return var5;
      } else {
         System.err.println("WARNING: calljava syscall invoked without a calljava callback set");
         return 0;
      }
   }

   private int sys_pause() {
      this.state = 2;
      return 0;
   }

   private int sys_getpagesize() {
      return this.writePages.length == 1?4096:1 << this.pageShift;
   }

   void _exited() {
   }

   void exit(int var1, boolean var2) {
      if(var2 && this.fds[2] != null) {
         try {
            byte[] var3 = getBytes("Process exited on signal " + (var1 - 128) + "\n");
            this.fds[2].write(var3, 0, var3.length);
         } catch (Runtime$ErrnoException var4) {
            ;
         }
      }

      this.exitStatus = var1;

      for(int var5 = 0; var5 < this.fds.length; ++var5) {
         if(this.fds[var5] != null) {
            this.closeFD(var5);
         }
      }

      this.state = 4;
      this._exited();
   }

   private int sys_exit(int var1) {
      this.exit(var1, false);
      return 0;
   }

   final int sys_fcntl(int var1, int var2, int var3) {
      if(var1 >= 0 && var1 < 64) {
         if(this.fds[var1] == null) {
            return -81;
         } else {
            Runtime$FD var5 = this.fds[var1];
            switch(var2) {
            case 0:
               if(var3 >= 0 && var3 < 64) {
                  int var4;
                  for(var4 = var3; var4 < 64 && this.fds[var4] != null; ++var4) {
                     ;
                  }

                  if(var4 == 64) {
                     return -24;
                  } else {
                     this.fds[var4] = var5.dup();
                     return var4;
                  }
               } else {
                  return -22;
               }
            case 1:
               return this.closeOnExec[var1]?1:0;
            case 2:
               this.closeOnExec[var1] = var3 != 0;
               return 0;
            case 3:
               return var5.flags();
            case 4:
            case 5:
            case 6:
            default:
               System.err.println("WARNING: Unknown fcntl command: " + var2);
               return -88;
            case 7:
            case 8:
               System.err.println("WARNING: file locking requires UnixRuntime");
               return -88;
            }
         }
      } else {
         return -81;
      }
   }

   final int fsync(int var1) {
      if(var1 >= 0 && var1 < 64) {
         if(this.fds[var1] == null) {
            return -81;
         } else {
            Runtime$FD var2 = this.fds[var1];
            Seekable var3 = var2.seekable();
            if(var3 == null) {
               return -22;
            } else {
               try {
                  var3.sync();
                  return 0;
               } catch (IOException var5) {
                  return -5;
               }
            }
         }
      } else {
         return -81;
      }
   }

   protected final int syscall(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      try {
         int var8 = this._syscall(var1, var2, var3, var4, var5, var6, var7);
         return var8;
      } catch (Runtime$ErrnoException var9) {
         return -var9.errno;
      } catch (Runtime$FaultException var10) {
         return -14;
      } catch (RuntimeException var11) {
         var11.printStackTrace();
         throw new Error("Internal Error in _syscall()");
      }
   }

   int _syscall(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      switch(var1) {
      case 0:
         return 0;
      case 1:
         return this.sys_exit(var2);
      case 2:
         return this.sys_pause();
      case 3:
         return this.sys_open(var2, var3, var4);
      case 4:
         return this.sys_close(var2);
      case 5:
         return this.sys_read(var2, var3, var4);
      case 6:
         return this.sys_write(var2, var3, var4);
      case 7:
         return this.sbrk(var2);
      case 8:
         return this.sys_fstat(var2, var3);
      case 9:
      case 20:
      case 21:
      case 28:
      case 30:
      case 32:
      case 33:
      case 34:
      case 35:
      case 36:
      case 39:
      case 40:
      case 41:
      case 42:
      case 43:
      case 45:
      case 46:
      case 47:
      case 48:
      case 49:
      case 50:
      case 51:
      case 52:
      case 53:
      case 54:
      case 55:
      case 56:
      case 57:
      case 58:
      case 59:
      case 60:
      case 61:
      case 62:
      case 63:
      case 64:
      case 65:
      case 66:
      case 67:
      case 72:
      case 73:
      case 74:
      case 75:
      case 76:
      case 77:
      case 78:
      case 79:
      case 80:
      case 81:
      case 82:
      case 83:
      case 84:
      case 85:
      case 86:
      case 87:
      case 88:
      case 89:
      case 90:
      default:
         System.err.println("Attempted to use unknown syscall: " + var1);
         return -88;
      case 10:
         return this.sys_lseek(var2, var3, var4);
      case 11:
      case 14:
      case 18:
      case 22:
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
         System.err.println("Attempted to use a UnixRuntime syscall in Runtime (" + var1 + ")");
         return -88;
      case 12:
         return this.sys_getpid();
      case 13:
         return this.sys_calljava(var2, var3, var4, var5);
      case 15:
         return this.sys_gettimeofday(var2, var3);
      case 16:
         return this.sys_sleep(var2);
      case 17:
         return this.sys_times(var2);
      case 19:
         return this.sys_getpagesize();
      case 29:
         return this.sys_fcntl(var2, var3, var4);
      case 31:
         return this.sys_sysconf(var2);
      case 37:
         this.memcpy(var2, var3, var4);
         return var2;
      case 38:
         this.memset(var2, var3, var4);
         return var2;
      case 44:
         return this.sys_ftruncate(var2, (long)var3);
      case 68:
         return this.sys_getuid();
      case 69:
         return this.sys_getgid();
      case 70:
         return this.sys_geteuid();
      case 71:
         return this.sys_getegid();
      case 91:
         return this.fsync(var2);
      }
   }

   private int sys_getuid() {
      return 0;
   }

   private int sys_geteuid() {
      return 0;
   }

   private int sys_getgid() {
      return 0;
   }

   private int sys_getegid() {
      return 0;
   }

   public int xmalloc(int var1) {
      int var2 = this.malloc(var1);
      if(var2 == 0) {
         throw new RuntimeException("malloc() failed");
      } else {
         return var2;
      }
   }

   public int xrealloc(int var1, int var2) {
      int var3 = this.realloc(var1, var2);
      if(var3 == 0) {
         throw new RuntimeException("realloc() failed");
      } else {
         return var3;
      }
   }

   public int realloc(int var1, int var2) {
      try {
         return this.call("realloc", var1, var2);
      } catch (Runtime$CallException var4) {
         return 0;
      }
   }

   public int malloc(int var1) {
      try {
         return this.call("malloc", var1);
      } catch (Runtime$CallException var3) {
         return 0;
      }
   }

   public void free(int var1) {
      try {
         if(var1 != 0) {
            this.call("free", var1);
         }
      } catch (Runtime$CallException var3) {
         ;
      }

   }

   public int strdup(String var1) {
      if(var1 == null) {
         var1 = "(null)";
      }

      byte[] var3 = getBytes(var1);
      byte[] var2 = new byte[var3.length + 1];
      System.arraycopy(var3, 0, var2, 0, var3.length);
      int var4 = this.malloc(var2.length);
      if(var4 == 0) {
         return 0;
      } else {
         try {
            this.copyout(var2, var4, var2.length);
            return var4;
         } catch (Runtime$FaultException var6) {
            this.free(var4);
            return 0;
         }
      }
   }

   public final String utfstring(int var1) {
      if(var1 == 0) {
         return null;
      } else {
         int var2 = var1;

         for(int var3 = 1; var3 != 0; ++var2) {
            var3 = this.memRead(var2 & -4);
            switch(var2 & 3) {
            case 0:
               var3 = var3 >>> 24 & 255;
               break;
            case 1:
               var3 = var3 >>> 16 & 255;
               break;
            case 2:
               var3 = var3 >>> 8 & 255;
               break;
            case 3:
               var3 = var3 >>> 0 & 255;
            }
         }

         if(var2 > var1) {
            --var2;
         }

         byte[] var6 = new byte[var2 - var1];
         this.copyin(var1, var6, var6.length);

         try {
            return new String(var6, "UTF-8");
         } catch (UnsupportedEncodingException var5) {
            throw new RuntimeException(var5);
         }
      }
   }

   public final String cstring(int var1) {
      if(var1 == 0) {
         return null;
      } else {
         StringBuffer var2 = new StringBuffer();

         while(true) {
            int var3;
            label36:
            while(true) {
               var3 = this.memRead(var1 & -4);
               switch(var1 & 3) {
               case 0:
                  if((var3 >>> 24 & 255) == 0) {
                     return var2.toString();
                  }

                  var2.append((char)(var3 >>> 24 & 255));
                  ++var1;
               case 1:
                  if((var3 >>> 16 & 255) == 0) {
                     return var2.toString();
                  }

                  var2.append((char)(var3 >>> 16 & 255));
                  ++var1;
               case 2:
                  if((var3 >>> 8 & 255) == 0) {
                     return var2.toString();
                  }

                  var2.append((char)(var3 >>> 8 & 255));
                  ++var1;
               case 3:
                  break label36;
               }
            }

            if((var3 >>> 0 & 255) == 0) {
               return var2.toString();
            }

            var2.append((char)(var3 >>> 0 & 255));
            ++var1;
         }
      }
   }

   protected final void nullPointerCheck(int var1) {
      if(var1 < 65536) {
         throw new Runtime$ExecutionException("Attempted to dereference a null pointer " + toHex(var1));
      }
   }

   byte[] byteBuf(int var1) {
      if(this._byteBuf == null) {
         this._byteBuf = new byte[var1];
      } else if(this._byteBuf.length < var1) {
         this._byteBuf = new byte[min(max(this._byteBuf.length * 2, var1), 16776192)];
      }

      return this._byteBuf;
   }

   protected static final int[] decodeData(String var0, int var1) {
      if(var0.length() % 8 != 0) {
         throw new IllegalArgumentException("string length must be a multiple of 8");
      } else if(var0.length() / 8 * 7 < var1 * 4) {
         throw new IllegalArgumentException("string isn\'t big enough");
      } else {
         int[] var2 = new int[var1];
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;

         for(int var6 = 0; var6 < var1; var5 += 8) {
            long var7 = 0L;

            for(int var9 = 0; var9 < 8; ++var9) {
               var7 <<= 7;
               var7 |= (long)(var0.charAt(var5 + var9) & 127);
            }

            if(var4 > 0) {
               var2[var6++] = var3 | (int)(var7 >>> 56 - var4);
            }

            if(var6 < var1) {
               var2[var6++] = (int)(var7 >>> 24 - var4);
            }

            var4 = var4 + 8 & 31;
            var3 = (int)(var7 << var4);
         }

         return var2;
      }
   }

   static byte[] getBytes(String var0) {
      try {
         return var0.getBytes("UTF-8");
      } catch (UnsupportedEncodingException var2) {
         return null;
      }
   }

   static byte[] getNullTerminatedBytes(String var0) {
      byte[] var1 = getBytes(var0);
      byte[] var2 = new byte[var1.length + 1];
      System.arraycopy(var1, 0, var2, 0, var1.length);
      return var2;
   }

   static final String toHex(int var0) {
      return "0x" + Long.toString((long)var0 & 4294967295L, 16);
   }

   static final int min(int var0, int var1) {
      return var0 < var1?var0:var1;
   }

   static final int max(int var0, int var1) {
      return var0 > var1?var0:var1;
   }

   static {
      String var0 = Platform.getProperty("os.name");
      String var1 = Platform.getProperty("nestedvm.win32hacks");
      if(var1 != null) {
         win32Hacks = Boolean.valueOf(var1).booleanValue();
      } else {
         win32Hacks = var0 != null && var0.toLowerCase().indexOf("windows") != -1;
      }

   }
}
