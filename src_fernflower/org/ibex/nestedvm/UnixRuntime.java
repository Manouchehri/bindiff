package org.ibex.nestedvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.TimeZone;
import java.util.Vector;
import org.ibex.nestedvm.Runtime;
import org.ibex.nestedvm.Runtime$CPUState;
import org.ibex.nestedvm.Runtime$ErrnoException;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.Runtime$FaultException;
import org.ibex.nestedvm.UnixRuntime$1;
import org.ibex.nestedvm.UnixRuntime$ForkedProcess;
import org.ibex.nestedvm.UnixRuntime$GlobalState;
import org.ibex.nestedvm.UnixRuntime$GlobalState$CacheEnt;
import org.ibex.nestedvm.UnixRuntime$HostFS;
import org.ibex.nestedvm.UnixRuntime$HostFS$HostDirFD;
import org.ibex.nestedvm.UnixRuntime$Pipe;
import org.ibex.nestedvm.UnixRuntime$ProcessTableFullExn;
import org.ibex.nestedvm.UnixRuntime$SocketFD;
import org.ibex.nestedvm.util.Platform;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$Lock;

public abstract class UnixRuntime extends Runtime implements Cloneable {
   private int pid;
   private UnixRuntime parent;
   private static final UnixRuntime$GlobalState defaultGS = new UnixRuntime$GlobalState();
   private UnixRuntime$GlobalState gs;
   private String cwd;
   private UnixRuntime execedRuntime;
   private Object children;
   private Vector activeChildren;
   private Vector exitedChildren;
   private static final Method runtimeCompilerCompile;
   static Class class$org$ibex$nestedvm$util$Seekable;
   static Class class$java$lang$String;

   public final int getPid() {
      return this.pid;
   }

   public void setGlobalState(UnixRuntime$GlobalState var1) {
      if(this.state != 1) {
         throw new IllegalStateException("can\'t change GlobalState when running");
      } else if(var1 == null) {
         throw new NullPointerException("gs is null");
      } else {
         this.gs = var1;
      }
   }

   protected UnixRuntime(int var1, int var2) {
      this(var1, var2, false);
   }

   protected UnixRuntime(int var1, int var2, boolean var3) {
      super(var1, var2, var3);
      if(!var3) {
         this.gs = defaultGS;
         String var4 = Platform.getProperty("user.dir");
         this.cwd = var4 == null?null:this.gs.mapHostPath(var4);
         if(this.cwd == null) {
            this.cwd = "/";
         }

         this.cwd = this.cwd.substring(1);
      }

   }

   private static String posixTZ() {
      StringBuffer var0 = new StringBuffer();
      TimeZone var1 = TimeZone.getDefault();
      int var2 = var1.getRawOffset() / 1000;
      var0.append(Platform.timeZoneGetDisplayName(var1, false, false));
      if(var2 > 0) {
         var0.append("-");
      } else {
         var2 = -var2;
      }

      var0.append(var2 / 3600);
      var2 %= 3600;
      if(var2 > 0) {
         var0.append(":").append(var2 / 60);
      }

      var2 %= 60;
      if(var2 > 0) {
         var0.append(":").append(var2);
      }

      if(var1.useDaylightTime()) {
         var0.append(Platform.timeZoneGetDisplayName(var1, true, false));
      }

      return var0.toString();
   }

   private static boolean envHas(String var0, String[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         if(var1[var2] != null && var1[var2].startsWith(var0 + "=")) {
            return true;
         }
      }

      return false;
   }

   String[] createEnv(String[] var1) {
      String[] var2 = new String[7];
      int var3 = 0;
      if(var1 == null) {
         var1 = new String[0];
      }

      if(!envHas("USER", var1) && Platform.getProperty("user.name") != null) {
         var2[var3++] = "USER=" + Platform.getProperty("user.name");
      }

      String var4;
      if(!envHas("HOME", var1) && (var4 = Platform.getProperty("user.home")) != null && (var4 = this.gs.mapHostPath(var4)) != null) {
         var2[var3++] = "HOME=" + var4;
      }

      if(!envHas("TMPDIR", var1) && (var4 = Platform.getProperty("java.io.tmpdir")) != null && (var4 = this.gs.mapHostPath(var4)) != null) {
         var2[var3++] = "TMPDIR=" + var4;
      }

      if(!envHas("SHELL", var1)) {
         var2[var3++] = "SHELL=/bin/sh";
      }

      if(!envHas("TERM", var1) && !win32Hacks) {
         var2[var3++] = "TERM=vt100";
      }

      if(!envHas("TZ", var1)) {
         var2[var3++] = "TZ=" + posixTZ();
      }

      if(!envHas("PATH", var1)) {
         var2[var3++] = "PATH=/usr/local/bin:/usr/bin:/bin:/usr/local/sbin:/usr/sbin:/sbin";
      }

      String[] var5 = new String[var1.length + var3];

      int var6;
      for(var6 = 0; var6 < var3; ++var6) {
         var5[var6] = var2[var6];
      }

      for(var6 = 0; var6 < var1.length; ++var6) {
         var5[var3++] = var1[var6];
      }

      return var5;
   }

   void _started() {
      UnixRuntime[] var1 = this.gs.tasks;
      UnixRuntime$GlobalState var2 = this.gs;
      synchronized(this.gs) {
         int var5;
         if(this.pid != 0) {
            UnixRuntime var3 = var1[this.pid];
            if(var3 == null || var3 == this || var3.pid != this.pid || var3.parent != this.parent) {
               throw new Error("should never happen");
            }

            Object var4 = this.parent.children;
            synchronized(this.parent.children) {
               var5 = this.parent.activeChildren.indexOf(var3);
               if(var5 == -1) {
                  throw new Error("should never happen");
               }

               this.parent.activeChildren.setElementAt(this, var5);
            }
         } else {
            int var10 = -1;
            int var11 = this.gs.nextPID;

            for(var5 = var11; var5 < var1.length; ++var5) {
               if(var1[var5] == null) {
                  var10 = var5;
                  break;
               }
            }

            if(var10 == -1) {
               for(var5 = 1; var5 < var11; ++var5) {
                  if(var1[var5] == null) {
                     var10 = var5;
                     break;
                  }
               }
            }

            if(var10 == -1) {
               throw new UnixRuntime$ProcessTableFullExn((UnixRuntime$1)null);
            }

            this.pid = var10;
            this.gs.nextPID = var10 + 1;
         }

         var1[this.pid] = this;
      }
   }

   int _syscall(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      switch(var1) {
      case 11:
         return this.sys_kill(var2, var3);
      case 12:
      case 13:
      case 15:
      case 16:
      case 17:
      case 19:
      case 21:
      case 30:
      case 31:
      case 32:
      case 34:
      case 35:
      case 37:
      case 38:
      case 40:
      case 41:
      case 42:
      case 44:
      case 45:
      case 47:
      case 48:
      case 49:
      case 50:
      case 51:
      case 54:
      case 55:
      case 68:
      case 69:
      case 70:
      case 71:
      case 72:
      default:
         return super._syscall(var1, var2, var3, var4, var5, var6, var7);
      case 14:
         return this.sys_stat(var2, var3);
      case 18:
         return this.sys_mkdir(var2, var3);
      case 20:
         return this.sys_unlink(var2);
      case 22:
         return this.sys_chdir(var2);
      case 23:
         return this.sys_pipe(var2);
      case 24:
         return this.sys_dup2(var2, var3);
      case 25:
         return this.sys_fork();
      case 26:
         return this.sys_waitpid(var2, var3, var4);
      case 27:
         return this.sys_getcwd(var2, var3);
      case 28:
         return this.sys_exec(var2, var3, var4);
      case 29:
         return this.sys_fcntl_lock(var2, var3, var4);
      case 33:
         return this.sys_lstat(var2, var3);
      case 36:
         return this.sys_getdents(var2, var3, var4, var5);
      case 39:
         return this.sys_dup(var2);
      case 43:
         return this.sys_chown(var2, var3, var4);
      case 46:
         return this.sys_getppid();
      case 52:
         return this.sys_realpath(var2, var3);
      case 53:
         return this.sys_sysctl(var2, var3, var4, var5, var6, var7);
      case 56:
         return this.sys_socket(var2, var3, var4);
      case 57:
         return this.sys_connect(var2, var3, var4);
      case 58:
         return this.sys_resolve_hostname(var2, var3, var4);
      case 59:
         return this.sys_accept(var2, var3, var4);
      case 60:
         return this.sys_setsockopt(var2, var3, var4, var5, var6);
      case 61:
         return this.sys_getsockopt(var2, var3, var4, var5, var6);
      case 62:
         return this.sys_listen(var2, var3);
      case 63:
         return this.sys_bind(var2, var3, var4);
      case 64:
         return this.sys_shutdown(var2, var3);
      case 65:
         return this.sys_sendto(var2, var3, var4, var5, var6, var7);
      case 66:
         return this.sys_recvfrom(var2, var3, var4, var5, var6, var7);
      case 67:
         return this.sys_select(var2, var3, var4, var5, var6);
      case 73:
         return this.sys_umask(var2);
      case 74:
         return this.sys_chmod(var2, var3, var4);
      case 75:
         return this.sys_fchmod(var2, var3, var4);
      case 76:
         return this.sys_chown(var2, var3, var4);
      case 77:
         return this.sys_fchown(var2, var3, var4);
      case 78:
         return this.sys_access(var2, var3);
      }
   }

   Runtime$FD _open(String var1, int var2, int var3) {
      var1 = this.normalizePath(var1);
      Runtime$FD var4 = this.gs.open(this, var1, var2, var3);
      if(var4 != null && var1 != null) {
         var4.setNormalizedPath(var1);
      }

      return var4;
   }

   private int sys_getppid() {
      return this.parent == null?1:this.parent.pid;
   }

   private int sys_chown(int var1, int var2, int var3) {
      return 0;
   }

   private int sys_lchown(int var1, int var2, int var3) {
      return 0;
   }

   private int sys_fchown(int var1, int var2, int var3) {
      return 0;
   }

   private int sys_chmod(int var1, int var2, int var3) {
      return 0;
   }

   private int sys_fchmod(int var1, int var2, int var3) {
      return 0;
   }

   private int sys_umask(int var1) {
      return 0;
   }

   private int sys_access(int var1, int var2) {
      return this.gs.stat(this, this.cstring(var1)) == null?-2:0;
   }

   private int sys_realpath(int var1, int var2) {
      String var3 = this.normalizePath(this.cstring(var1));
      byte[] var4 = getNullTerminatedBytes(var3);
      if(var4.length > 1024) {
         return -34;
      } else {
         this.copyout(var4, var2, var4.length);
         return 0;
      }
   }

   private int sys_kill(int var1, int var2) {
      if(var1 != var1) {
         return -3;
      } else if(var2 >= 0 && var2 < 32) {
         switch(var2) {
         case 0:
            return 0;
         case 1:
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
         case 9:
         case 10:
         case 11:
         case 12:
         case 13:
         case 14:
         case 15:
         case 16:
         case 24:
         case 25:
         case 26:
         case 27:
         default:
            this.exit(128 + var2, true);
         case 17:
         case 18:
         case 19:
         case 20:
         case 21:
         case 22:
         case 23:
         case 28:
            return 0;
         }
      } else {
         return -22;
      }
   }

   private int sys_waitpid(int var1, int var2, int var3) {
      if((var3 & -2) != 0) {
         return -22;
      } else if(var1 != 0 && var1 >= -1) {
         boolean var5 = (var3 & 1) == 0;
         if(var1 != -1 && (var1 <= 0 || var1 >= this.gs.tasks.length)) {
            return -10;
         } else if(this.children == null) {
            return var5?-10:0;
         } else {
            UnixRuntime var6 = null;
            Object var7 = this.children;
            synchronized(this.children) {
               while(true) {
                  if(var1 == -1) {
                     if(this.exitedChildren.size() > 0) {
                        var6 = (UnixRuntime)this.exitedChildren.elementAt(this.exitedChildren.size() - 1);
                        this.exitedChildren.removeElementAt(this.exitedChildren.size() - 1);
                     }
                  } else {
                     if(var1 <= 0) {
                        throw new Error("should never happen");
                     }

                     if(var1 >= this.gs.tasks.length) {
                        return -10;
                     }

                     UnixRuntime var8 = this.gs.tasks[var1];
                     if(var8.parent != this) {
                        return -10;
                     }

                     if(var8.state == 4) {
                        if(!this.exitedChildren.removeElement(var8)) {
                           throw new Error("should never happen");
                        }

                        var6 = var8;
                     }
                  }

                  if(var6 != null) {
                     this.gs.tasks[var6.pid] = null;
                     break;
                  }

                  if(!var5) {
                     return 0;
                  }

                  try {
                     this.children.wait();
                  } catch (InterruptedException var10) {
                     ;
                  }
               }
            }

            if(var2 != 0) {
               this.memWrite(var2, var6.exitStatus() << 8);
            }

            return var6.pid;
         }
      } else {
         System.err.println("WARNING: waitpid called with a pid of " + var1);
         return -10;
      }
   }

   void _exited() {
      if(this.children != null) {
         Object var1 = this.children;
         synchronized(this.children) {
            Enumeration var2;
            UnixRuntime var3;
            for(var2 = this.exitedChildren.elements(); var2.hasMoreElements(); this.gs.tasks[var3.pid] = null) {
               var3 = (UnixRuntime)var2.nextElement();
            }

            this.exitedChildren.removeAllElements();

            for(var2 = this.activeChildren.elements(); var2.hasMoreElements(); var3.parent = null) {
               var3 = (UnixRuntime)var2.nextElement();
            }

            this.activeChildren.removeAllElements();
         }
      }

      UnixRuntime var8 = this.parent;
      if(var8 == null) {
         this.gs.tasks[this.pid] = null;
      } else {
         Object var9 = var8.children;
         synchronized(var8.children) {
            if(this.parent == null) {
               this.gs.tasks[this.pid] = null;
            } else {
               if(!this.parent.activeChildren.removeElement(this)) {
                  throw new Error("should never happen _exited: pid: " + this.pid);
               }

               this.parent.exitedChildren.addElement(this);
               this.parent.children.notify();
            }
         }
      }

   }

   protected Object clone() {
      UnixRuntime var1 = (UnixRuntime)super.clone();
      var1.pid = 0;
      var1.parent = null;
      var1.children = null;
      var1.activeChildren = var1.exitedChildren = null;
      return var1;
   }

   private int sys_fork() {
      UnixRuntime var1;
      try {
         var1 = (UnixRuntime)this.clone();
      } catch (Exception var4) {
         var4.printStackTrace();
         return -12;
      }

      var1.parent = this;

      try {
         var1._started();
      } catch (UnixRuntime$ProcessTableFullExn var3) {
         return -12;
      }

      if(this.children == null) {
         this.children = new Object();
         this.activeChildren = new Vector();
         this.exitedChildren = new Vector();
      }

      this.activeChildren.addElement(var1);
      Runtime$CPUState var2 = new Runtime$CPUState();
      this.getCPUState(var2);
      var2.r[2] = 0;
      var2.pc += 4;
      var1.setCPUState(var2);
      var1.state = 2;
      new UnixRuntime$ForkedProcess(var1);
      return var1.pid;
   }

   public static int runAndExec(UnixRuntime var0, String var1, String[] var2) {
      return runAndExec(var0, concatArgv(var1, var2));
   }

   public static int runAndExec(UnixRuntime var0, String[] var1) {
      var0.start(var1);
      return executeAndExec(var0);
   }

   public static int executeAndExec(UnixRuntime var0) {
      while(true) {
         if(var0.execute()) {
            if(var0.state != 5) {
               return var0.exitStatus();
            }

            var0 = var0.execedRuntime;
         } else {
            System.err.println("WARNING: Pause requested while executing runAndExec()");
         }
      }
   }

   private String[] readStringArray(int var1) {
      int var2 = 0;

      for(int var3 = var1; this.memRead(var3) != 0; var3 += 4) {
         ++var2;
      }

      String[] var6 = new String[var2];
      int var4 = 0;

      for(int var5 = var1; var4 < var2; var5 += 4) {
         var6[var4] = this.cstring(this.memRead(var5));
         ++var4;
      }

      return var6;
   }

   private int sys_exec(int var1, int var2, int var3) {
      return this.exec(this.normalizePath(this.cstring(var1)), this.readStringArray(var2), this.readStringArray(var3));
   }

   public Class runtimeCompile(Seekable var1, String var2) {
      if(runtimeCompilerCompile == null) {
         System.err.println("WARNING: Exec attempted but RuntimeCompiler not found!");
         return null;
      } else {
         try {
            return (Class)runtimeCompilerCompile.invoke((Object)null, new Object[]{var1, "unixruntime,maxinsnpermethod=256,lessconstants", var2});
         } catch (IllegalAccessException var5) {
            var5.printStackTrace();
            return null;
         } catch (InvocationTargetException var6) {
            Throwable var4 = var6.getTargetException();
            if(var4 instanceof IOException) {
               throw (IOException)var4;
            } else if(var4 instanceof RuntimeException) {
               throw (RuntimeException)var4;
            } else if(var4 instanceof Error) {
               throw (Error)var4;
            } else {
               var4.printStackTrace();
               return null;
            }
         }
      }
   }

   private int exec(String var1, String[] var2, String[] var3) {
      if(var2.length == 0) {
         var2 = new String[]{""};
      }

      if(var1.equals("bin/busybox") && this.getClass().getName().endsWith("BusyBox")) {
         return this.execClass(this.getClass(), var2, var3);
      } else {
         Runtime$FStat var4 = this.gs.stat(this, var1);
         if(var4 == null) {
            return -2;
         } else {
            UnixRuntime$GlobalState$CacheEnt var5 = (UnixRuntime$GlobalState$CacheEnt)this.gs.execCache.get(var1);
            long var6 = (long)var4.mtime();
            long var8 = (long)var4.size();
            if(var5 != null) {
               if(var5.time == var6 && var5.size == var8) {
                  if(var5.o instanceof Class) {
                     return this.execClass((Class)var5.o, var2, var3);
                  }

                  if(var5.o instanceof String[]) {
                     return this.execScript(var1, (String[])((String[])var5.o), var2, var3);
                  }

                  throw new Error("should never happen");
               }

               this.gs.execCache.remove(var1);
            }

            Runtime$FD var10 = this.gs.open(this, var1, 0, 0);
            if(var10 == null) {
               throw new Runtime$ErrnoException(2);
            } else {
               Seekable var11 = var10.seekable();
               if(var11 == null) {
                  throw new Runtime$ErrnoException(13);
               } else {
                  byte[] var12 = new byte[4096];

                  try {
                     byte var14;
                     try {
                        int var13 = var11.read(var12, 0, var12.length);
                        if(var13 == -1) {
                           throw new Runtime$ErrnoException(8);
                        } else {
                           int var15;
                           switch(var12[0]) {
                           case 35:
                              if(var13 == 1) {
                                 var15 = var11.read(var12, 1, var12.length - 1);
                                 if(var15 == -1) {
                                    byte var28 = -8;
                                    return var28;
                                 }

                                 var13 += var15;
                              }

                              if(var12[1] == 33) {
                                 var15 = 2;
                                 var13 -= 2;

                                 int var16;
                                 label350:
                                 while(true) {
                                    for(var16 = var15; var16 < var15 + var13; ++var16) {
                                       if(var12[var16] == 10) {
                                          var15 = var16;
                                          break label350;
                                       }
                                    }

                                    var15 += var13;
                                    if(var15 == var12.length) {
                                       break;
                                    }

                                    var13 = var11.read(var12, var15, var12.length - var15);
                                 }

                                 for(var16 = 2; var16 < var15 && var12[var16] == 32; ++var16) {
                                    ;
                                 }

                                 if(var16 == var15) {
                                    throw new Runtime$ErrnoException(8);
                                 }

                                 int var17;
                                 for(var17 = var16; var17 < var15 && var12[var17] != 32; ++var17) {
                                    ;
                                 }

                                 int var18;
                                 for(var18 = var17; var17 < var15 && var12[var17] == 32; ++var17) {
                                    ;
                                 }

                                 String[] var19 = new String[]{new String(var12, var16, var18 - var16), var17 < var15?new String(var12, var17, var15 - var17):null};
                                 this.gs.execCache.put(var1, new UnixRuntime$GlobalState$CacheEnt(var6, var8, var19));
                                 int var20 = this.execScript(var1, var19, var2, var3);
                                 return var20;
                              }

                              byte var27 = -8;
                              return var27;
                           case 127:
                              if(var13 < 4) {
                                 var11.tryReadFully(var12, var13, 4 - var13);
                              }

                              if(var12[1] != 69 || var12[2] != 76 || var12[3] != 70) {
                                 var14 = -8;
                                 return var14;
                              } else {
                                 var11.seek(0);
                                 System.err.println("Running RuntimeCompiler for " + var1);
                                 Class var26 = this.runtimeCompile(var11, var1);
                                 System.err.println("RuntimeCompiler finished for " + var1);
                                 if(var26 == null) {
                                    throw new Runtime$ErrnoException(8);
                                 }

                                 this.gs.execCache.put(var1, new UnixRuntime$GlobalState$CacheEnt(var6, var8, var26));
                                 var15 = this.execClass(var26, var2, var3);
                                 return var15;
                              }
                           default:
                              byte var29 = -8;
                              return var29;
                           }
                        }
                     } catch (IOException var24) {
                        var14 = -5;
                        return var14;
                     }
                  } finally {
                     var10.close();
                  }
               }
            }
         }
      }
   }

   public int execScript(String var1, String[] var2, String[] var3, String[] var4) {
      String[] var5 = new String[var3.length - 1 + (var2[1] != null?3:2)];
      int var6 = var2[0].lastIndexOf(47);
      var5[0] = var6 == -1?var2[0]:var2[0].substring(var6 + 1);
      var5[1] = "/" + var1;
      var6 = 2;
      if(var2[1] != null) {
         var5[var6++] = var2[1];
      }

      int var7;
      for(var7 = 1; var7 < var3.length; ++var7) {
         var5[var6++] = var3[var7];
      }

      if(var6 != var5.length) {
         throw new Error("p != newArgv.length");
      } else {
         System.err.println("Execing: " + var2[0]);

         for(var7 = 0; var7 < var5.length; ++var7) {
            System.err.println("execing [" + var7 + "] " + var5[var7]);
         }

         return this.exec(var2[0], var5, var4);
      }
   }

   public int execClass(Class var1, String[] var2, String[] var3) {
      try {
         UnixRuntime var4 = (UnixRuntime)var1.getDeclaredConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.TRUE});
         return this.exec(var4, var2, var3);
      } catch (Exception var5) {
         var5.printStackTrace();
         return -8;
      }
   }

   private int exec(UnixRuntime var1, String[] var2, String[] var3) {
      for(int var4 = 0; var4 < 64; ++var4) {
         if(this.closeOnExec[var4]) {
            this.closeFD(var4);
         }
      }

      var1.fds = this.fds;
      var1.closeOnExec = this.closeOnExec;
      this.fds = null;
      this.closeOnExec = null;
      var1.gs = this.gs;
      var1.sm = this.sm;
      var1.cwd = this.cwd;
      var1.pid = this.pid;
      var1.parent = this.parent;
      var1.start(var2, var3);
      this.state = 5;
      this.execedRuntime = var1;
      return 0;
   }

   private int sys_pipe(int var1) {
      UnixRuntime$Pipe var2 = new UnixRuntime$Pipe();
      int var3 = this.addFD(var2.reader);
      if(var3 < 0) {
         return -23;
      } else {
         int var4 = this.addFD(var2.writer);
         if(var4 < 0) {
            this.closeFD(var3);
            return -23;
         } else {
            try {
               this.memWrite(var1, var3);
               this.memWrite(var1 + 4, var4);
               return 0;
            } catch (Runtime$FaultException var6) {
               this.closeFD(var3);
               this.closeFD(var4);
               return -14;
            }
         }
      }
   }

   private int sys_dup2(int var1, int var2) {
      if(var1 == var2) {
         return 0;
      } else if(var1 >= 0 && var1 < 64) {
         if(var2 >= 0 && var2 < 64) {
            if(this.fds[var1] == null) {
               return -81;
            } else {
               if(this.fds[var2] != null) {
                  this.fds[var2].close();
               }

               this.fds[var2] = this.fds[var1].dup();
               return 0;
            }
         } else {
            return -81;
         }
      } else {
         return -81;
      }
   }

   private int sys_dup(int var1) {
      if(var1 >= 0 && var1 < 64) {
         if(this.fds[var1] == null) {
            return -81;
         } else {
            Runtime$FD var2 = this.fds[var1].dup();
            int var3 = this.addFD(var2);
            if(var3 < 0) {
               var2.close();
               return -23;
            } else {
               return var3;
            }
         }
      } else {
         return -81;
      }
   }

   private int sys_stat(int var1, int var2) {
      Runtime$FStat var3 = this.gs.stat(this, this.normalizePath(this.cstring(var1)));
      return var3 == null?-2:this.stat(var3, var2);
   }

   private int sys_lstat(int var1, int var2) {
      Runtime$FStat var3 = this.gs.lstat(this, this.normalizePath(this.cstring(var1)));
      return var3 == null?-2:this.stat(var3, var2);
   }

   private int sys_mkdir(int var1, int var2) {
      this.gs.mkdir(this, this.normalizePath(this.cstring(var1)), var2);
      return 0;
   }

   private int sys_unlink(int var1) {
      this.gs.unlink(this, this.normalizePath(this.cstring(var1)));
      return 0;
   }

   private int sys_getcwd(int var1, int var2) {
      byte[] var3 = getBytes(this.cwd);
      if(var2 == 0) {
         return -22;
      } else if(var2 < var3.length + 2) {
         return -34;
      } else {
         this.memset(var1, 47, 1);
         this.copyout(var3, var1 + 1, var3.length);
         this.memset(var1 + var3.length + 1, 0, 1);
         return var1;
      }
   }

   private int sys_chdir(int var1) {
      String var2 = this.normalizePath(this.cstring(var1));
      Runtime$FStat var3 = this.gs.stat(this, var2);
      if(var3 == null) {
         return -2;
      } else if(var3.type() != 16384) {
         return -20;
      } else {
         this.cwd = var2;
         return 0;
      }
   }

   private int sys_getdents(int var1, int var2, int var3, int var4) {
      var3 = Math.min(var3, 16776192);
      if(var1 >= 0 && var1 < 64) {
         if(this.fds[var1] == null) {
            return -81;
         } else {
            byte[] var5 = this.byteBuf(var3);
            int var6 = this.fds[var1].getdents(var5, 0, var3);
            this.copyout(var5, var2, var6);
            return var6;
         }
      } else {
         return -81;
      }
   }

   void _preCloseFD(Runtime$FD var1) {
      Seekable var2 = var1.seekable();
      if(var2 != null) {
         try {
            for(int var3 = 0; var3 < this.gs.locks.length; ++var3) {
               Seekable$Lock var4 = this.gs.locks[var3];
               if(var4 != null && var2.equals(var4.seekable()) && var4.getOwner() == this) {
                  var4.release();
                  this.gs.locks[var3] = null;
               }
            }

         } catch (IOException var5) {
            throw new RuntimeException(var5);
         }
      }
   }

   void _postCloseFD(Runtime$FD var1) {
      if(var1.isMarkedForDeleteOnClose()) {
         try {
            this.gs.unlink(this, var1.getNormalizedPath());
         } catch (Throwable var3) {
            ;
         }
      }

   }

   private int sys_fcntl_lock(int var1, int var2, int var3) {
      if(var2 != 7 && var2 != 8) {
         return this.sys_fcntl(var1, var2, var3);
      } else if(var1 >= 0 && var1 < 64) {
         if(this.fds[var1] == null) {
            return -81;
         } else {
            Runtime$FD var4 = this.fds[var1];
            if(var3 == 0) {
               return -22;
            } else {
               int var5 = this.memRead(var3);
               int var6 = this.memRead(var3 + 4);
               int var7 = this.memRead(var3 + 8);
               int var8 = var5 >> 16;
               int var9 = var5 & 255;
               Seekable$Lock[] var10 = this.gs.locks;
               Seekable var11 = var4.seekable();
               if(var11 == null) {
                  return -22;
               } else {
                  try {
                     switch(var9) {
                     case 0:
                        break;
                     case 1:
                        var6 += var11.pos();
                        break;
                     case 2:
                        var6 += var11.length();
                        break;
                     default:
                        return -1;
                     }

                     int var12;
                     Seekable$Lock var15;
                     if(var2 == 7) {
                        for(var12 = 0; var12 < var10.length; ++var12) {
                           if(var10[var12] != null && var11.equals(var10[var12].seekable()) && var10[var12].overlaps(var6, var7) && var10[var12].getOwner() != this && (!var10[var12].isShared() || var8 != 1)) {
                              return 0;
                           }
                        }

                        var15 = var11.lock((long)var6, (long)var7, var8 == 1);
                        if(var15 != null) {
                           this.memWrite(var3, 196608);
                           var15.release();
                        }

                        return 0;
                     } else if(var2 != 8) {
                        return -22;
                     } else {
                        int var13;
                        if(var8 == 3) {
                           for(var12 = 0; var12 < var10.length; ++var12) {
                              if(var10[var12] != null && var11.equals(var10[var12].seekable()) && var10[var12].getOwner() == this) {
                                 var13 = (int)var10[var12].position();
                                 if(var13 >= var6 && (var6 == 0 || var7 == 0 || (long)var13 + var10[var12].size() <= (long)(var6 + var7))) {
                                    var10[var12].release();
                                    var10[var12] = null;
                                 }
                              }
                           }

                           return 0;
                        } else if(var8 != 1 && var8 != 2) {
                           return -22;
                        } else {
                           for(var12 = 0; var12 < var10.length; ++var12) {
                              if(var10[var12] != null && var11.equals(var10[var12].seekable())) {
                                 if(var10[var12].getOwner() == this) {
                                    if(var10[var12].contained(var6, var7)) {
                                       var10[var12].release();
                                       var10[var12] = null;
                                    } else if(var10[var12].contains(var6, var7)) {
                                       if(var10[var12].isShared() == (var8 == 1)) {
                                          this.memWrite(var3 + 4, (int)var10[var12].position());
                                          this.memWrite(var3 + 8, (int)var10[var12].size());
                                          return 0;
                                       }

                                       var10[var12].release();
                                       var10[var12] = null;
                                    }
                                 } else if(var10[var12].overlaps(var6, var7) && (!var10[var12].isShared() || var8 == 2)) {
                                    return -11;
                                 }
                              }
                           }

                           var15 = var11.lock((long)var6, (long)var7, var8 == 1);
                           if(var15 == null) {
                              return -11;
                           } else {
                              var15.setOwner(this);

                              for(var13 = 0; var13 < var10.length && var10[var13] != null; ++var13) {
                                 ;
                              }

                              if(var13 == var10.length) {
                                 return -46;
                              } else {
                                 var10[var13] = var15;
                                 return 0;
                              }
                           }
                        }
                     }
                  } catch (IOException var14) {
                     throw new RuntimeException(var14);
                  }
               }
            }
         }
      } else {
         return -81;
      }
   }

   private int sys_socket(int var1, int var2, int var3) {
      return var1 == 2 && (var2 == 1 || var2 == 2)?this.addFD(new UnixRuntime$SocketFD(var2 == 1?0:1)):-123;
   }

   private UnixRuntime$SocketFD getSocketFD(int var1) {
      if(var1 >= 0 && var1 < 64) {
         if(this.fds[var1] == null) {
            throw new Runtime$ErrnoException(81);
         } else if(!(this.fds[var1] instanceof UnixRuntime$SocketFD)) {
            throw new Runtime$ErrnoException(108);
         } else {
            return (UnixRuntime$SocketFD)this.fds[var1];
         }
      } else {
         throw new Runtime$ErrnoException(81);
      }
   }

   private int sys_connect(int var1, int var2, int var3) {
      UnixRuntime$SocketFD var4 = this.getSocketFD(var1);
      if(var4.type() == 0 && (var4.s != null || var4.ss != null)) {
         return -127;
      } else {
         int var5 = this.memRead(var2);
         if((var5 >>> 16 & 255) != 2) {
            return -106;
         } else {
            int var6 = var5 & '\uffff';
            byte[] var7 = new byte[4];
            this.copyin(var2 + 4, var7, 4);

            InetAddress var8;
            try {
               var8 = Platform.inetAddressFromBytes(var7);
            } catch (UnknownHostException var11) {
               return -125;
            }

            var4.connectAddr = var8;
            var4.connectPort = var6;

            try {
               switch(var4.type()) {
               case 0:
                  Socket var9 = new Socket(var8, var6);
                  var4.s = var9;
                  var4.setOptions();
                  var4.is = var9.getInputStream();
                  var4.os = var9.getOutputStream();
               case 1:
                  return 0;
               default:
                  throw new Error("should never happen");
               }
            } catch (IOException var10) {
               return -111;
            }
         }
      }
   }

   private int sys_resolve_hostname(int var1, int var2, int var3) {
      String var4 = this.cstring(var1);
      int var5 = this.memRead(var3);

      InetAddress[] var6;
      try {
         var6 = InetAddress.getAllByName(var4);
      } catch (UnknownHostException var10) {
         return 1;
      }

      int var7 = min(var5 / 4, var6.length);

      for(int var8 = 0; var8 < var7; var2 += 4) {
         byte[] var9 = var6[var8].getAddress();
         this.copyout(var9, var2, 4);
         ++var8;
      }

      this.memWrite(var3, var7 * 4);
      return 0;
   }

   private int sys_setsockopt(int var1, int var2, int var3, int var4, int var5) {
      UnixRuntime$SocketFD var6 = this.getSocketFD(var1);
      switch(var2) {
      case 65535:
         switch(var3) {
         case 4:
         case 8:
            if(var5 != 4) {
               return -22;
            }

            int var7 = this.memRead(var4);
            if(var7 != 0) {
               var6.options |= var3;
            } else {
               var6.options &= ~var3;
            }

            var6.setOptions();
            return 0;
         default:
            System.err.println("Unknown setsockopt name passed: " + var3);
            return -109;
         }
      default:
         System.err.println("Unknown setsockopt leve passed: " + var2);
         return -109;
      }
   }

   private int sys_getsockopt(int var1, int var2, int var3, int var4, int var5) {
      UnixRuntime$SocketFD var6 = this.getSocketFD(var1);
      switch(var2) {
      case 65535:
         switch(var3) {
         case 4:
         case 8:
            int var7 = this.memRead(var5);
            if(var7 < 4) {
               return -22;
            }

            int var8 = (var6.options & var3) != 0?1:0;
            this.memWrite(var4, var8);
            this.memWrite(var5, 4);
            return 0;
         default:
            System.err.println("Unknown setsockopt name passed: " + var3);
            return -109;
         }
      default:
         System.err.println("Unknown setsockopt leve passed: " + var2);
         return -109;
      }
   }

   private int sys_bind(int var1, int var2, int var3) {
      UnixRuntime$SocketFD var4 = this.getSocketFD(var1);
      if(var4.type() != 0 || var4.s == null && var4.ss == null) {
         int var5 = this.memRead(var2);
         if((var5 >>> 16 & 255) != 2) {
            return -106;
         } else {
            int var6 = var5 & '\uffff';
            InetAddress var7 = null;
            if(this.memRead(var2 + 4) != 0) {
               byte[] var8 = new byte[4];
               this.copyin(var2 + 4, var8, 4);

               try {
                  var7 = Platform.inetAddressFromBytes(var8);
               } catch (UnknownHostException var11) {
                  return -125;
               }
            }

            switch(var4.type()) {
            case 0:
               var4.bindAddr = var7;
               var4.bindPort = var6;
               return 0;
            case 1:
               if(var4.ds != null) {
                  var4.ds.close();
               }

               try {
                  var4.ds = var7 != null?new DatagramSocket(var6, var7):new DatagramSocket(var6);
                  return 0;
               } catch (IOException var10) {
                  return -112;
               }
            default:
               throw new Error("should never happen");
            }
         }
      } else {
         return -127;
      }
   }

   private int sys_listen(int var1, int var2) {
      UnixRuntime$SocketFD var3 = this.getSocketFD(var1);
      if(var3.type() != 0) {
         return -95;
      } else if(var3.ss == null && var3.s == null) {
         if(var3.bindPort < 0) {
            return -95;
         } else {
            try {
               var3.ss = new ServerSocket(var3.bindPort, var2, var3.bindAddr);
               var3.flags |= 2;
               return 0;
            } catch (IOException var5) {
               return -112;
            }
         }
      } else {
         return -127;
      }
   }

   private int sys_accept(int var1, int var2, int var3) {
      UnixRuntime$SocketFD var4 = this.getSocketFD(var1);
      if(var4.type() != 0) {
         return -95;
      } else if(!var4.listen()) {
         return -95;
      } else {
         int var5 = this.memRead(var3);
         ServerSocket var6 = var4.ss;

         Socket var7;
         try {
            var7 = var6.accept();
         } catch (IOException var11) {
            return -5;
         }

         if(var5 >= 8) {
            this.memWrite(var2, 100794368 | var7.getPort());
            byte[] var8 = var7.getInetAddress().getAddress();
            this.copyout(var8, var2 + 4, 4);
            this.memWrite(var3, 8);
         }

         UnixRuntime$SocketFD var12 = new UnixRuntime$SocketFD(0);
         var12.s = var7;

         try {
            var12.is = var7.getInputStream();
            var12.os = var7.getOutputStream();
         } catch (IOException var10) {
            return -5;
         }

         int var9 = this.addFD(var12);
         if(var9 == -1) {
            var12.close();
            return -23;
         } else {
            return var9;
         }
      }
   }

   private int sys_shutdown(int var1, int var2) {
      UnixRuntime$SocketFD var3 = this.getSocketFD(var1);
      if(var3.type() == 0 && !var3.listen()) {
         if(var3.s == null) {
            return -128;
         } else {
            Socket var4 = var3.s;

            try {
               if(var2 == 0 || var2 == 2) {
                  Platform.socketHalfClose(var4, false);
               }

               if(var2 == 1 || var2 == 2) {
                  Platform.socketHalfClose(var4, true);
               }

               return 0;
            } catch (IOException var6) {
               return -5;
            }
         }
      } else {
         return -95;
      }
   }

   private int sys_sendto(int var1, int var2, int var3, int var4, int var5, int var6) {
      UnixRuntime$SocketFD var7 = this.getSocketFD(var1);
      if(var4 != 0) {
         throw new Runtime$ErrnoException(22);
      } else {
         int var8 = this.memRead(var5);
         if((var8 >>> 16 & 255) != 2) {
            return -106;
         } else {
            int var9 = var8 & '\uffff';
            byte[] var11 = new byte[4];
            this.copyin(var5 + 4, var11, 4);

            InetAddress var10;
            try {
               var10 = Platform.inetAddressFromBytes(var11);
            } catch (UnknownHostException var14) {
               return -125;
            }

            var3 = Math.min(var3, 16776192);
            byte[] var12 = this.byteBuf(var3);
            this.copyin(var2, var12, var3);

            try {
               return var7.sendto(var12, 0, var3, var10, var9);
            } catch (Runtime$ErrnoException var15) {
               if(var15.errno == 32) {
                  this.exit(141, true);
               }

               throw var15;
            }
         }
      }
   }

   private int sys_recvfrom(int var1, int var2, int var3, int var4, int var5, int var6) {
      UnixRuntime$SocketFD var7 = this.getSocketFD(var1);
      if(var4 != 0) {
         throw new Runtime$ErrnoException(22);
      } else {
         InetAddress[] var8 = var5 == 0?null:new InetAddress[1];
         int[] var9 = var5 == 0?null:new int[1];
         var3 = Math.min(var3, 16776192);
         byte[] var10 = this.byteBuf(var3);
         int var11 = var7.recvfrom(var10, 0, var3, var8, var9);
         this.copyout(var10, var2, var11);
         if(var5 != 0) {
            this.memWrite(var5, 131072 | var9[0]);
            byte[] var12 = var8[0].getAddress();
            this.copyout(var12, var5 + 4, 4);
         }

         return var11;
      }
   }

   private int sys_select(int var1, int var2, int var3, int var4, int var5) {
      return -88;
   }

   private static String hostName() {
      try {
         return InetAddress.getLocalHost().getHostName();
      } catch (UnknownHostException var1) {
         return "darkstar";
      }
   }

   private int sys_sysctl(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var5 != 0) {
         return -1;
      } else if(var2 == 0) {
         return -2;
      } else if(var3 == 0) {
         return 0;
      } else {
         String var7 = null;
         switch(this.memRead(var1)) {
         case 1:
            if(var2 == 2) {
               switch(this.memRead(var1 + 4)) {
               case 1:
                  var7 = "NestedVM";
                  break;
               case 2:
                  var7 = "1.0";
               case 3:
               case 5:
               case 6:
               case 7:
               case 8:
               case 9:
               default:
                  break;
               case 4:
                  var7 = "NestedVM Kernel Version 1.0";
                  break;
               case 10:
                  var7 = hostName();
               }
            }
            break;
         case 6:
            if(var2 == 2) {
               switch(this.memRead(var1 + 4)) {
               case 1:
                  var7 = "NestedVM Virtual Machine";
               }
            }
         }

         if(var7 == null) {
            return -2;
         } else {
            int var8 = this.memRead(var4);
            if(var7 instanceof String) {
               byte[] var9 = getNullTerminatedBytes((String)var7);
               if(var8 < var9.length) {
                  return -12;
               }

               var8 = var9.length;
               this.copyout(var9, var3, var8);
               this.memWrite(var4, var8);
            } else {
               if(!(var7 instanceof Integer)) {
                  throw new Error("should never happen");
               }

               if(var8 < 4) {
                  return -12;
               }

               this.memWrite(var3, ((Integer)var7).intValue());
            }

            return 0;
         }
      }
   }

   private String normalizePath(String var1) {
      boolean var2 = var1.startsWith("/");
      int var3 = this.cwd.length();
      if(!var1.startsWith(".") && var1.indexOf("./") == -1 && var1.indexOf("//") == -1 && !var1.endsWith(".")) {
         return var2?var1.substring(1):(var3 == 0?var1:(var1.length() == 0?this.cwd:this.cwd + "/" + var1));
      } else {
         char[] var4 = new char[var1.length() + 1];
         char[] var5 = new char[var4.length + (var2?-1:this.cwd.length())];
         var1.getChars(0, var1.length(), var4, 0);
         int var6 = 0;
         int var7 = 0;
         if(var2) {
            do {
               ++var6;
            } while(var4[var6] == 47);
         } else if(var3 != 0) {
            this.cwd.getChars(0, var3, var5, 0);
            var7 = var3;
         }

         while(var4[var6] != 0) {
            if(var6 != 0) {
               while(var4[var6] != 0 && var4[var6] != 47) {
                  var5[var7++] = var4[var6++];
               }

               if(var4[var6] == 0) {
                  break;
               }

               while(var4[var6] == 47) {
                  ++var6;
               }
            }

            if(var4[var6] == 0) {
               break;
            }

            if(var4[var6] != 46) {
               var5[var7++] = 47;
               var5[var7++] = var4[var6++];
            } else if(var4[var6 + 1] != 0 && var4[var6 + 1] != 47) {
               if(var4[var6 + 1] == 46 && (var4[var6 + 2] == 0 || var4[var6 + 2] == 47)) {
                  var6 += 2;
                  if(var7 > 0) {
                     --var7;
                  }

                  while(var7 > 0 && var5[var7] != 47) {
                     --var7;
                  }
               } else {
                  ++var6;
                  var5[var7++] = 47;
                  var5[var7++] = 46;
               }
            } else {
               ++var6;
            }
         }

         if(var7 > 0 && var5[var7 - 1] == 47) {
            --var7;
         }

         int var8 = var5[0] == 47?1:0;
         return new String(var5, var8, var7 - var8);
      }
   }

   Runtime$FStat hostFStat(File var1, Object var2) {
      boolean var3 = false;

      try {
         FileInputStream var4 = new FileInputStream(var1);
         switch(var4.read()) {
         case 35:
            var3 = var4.read() == 33;
            break;
         case 127:
            var3 = var4.read() == 69 && var4.read() == 76 && var4.read() == 70;
         }

         var4.close();
      } catch (IOException var7) {
         ;
      }

      UnixRuntime$HostFS var8 = (UnixRuntime$HostFS)var2;
      short var5 = var8.inodes.get(var1.getAbsolutePath());
      int var6 = var8.devno;
      return new UnixRuntime$1(this, var1, var3, var5, var6);
   }

   Runtime$FD hostFSDirFD(File var1, Object var2) {
      UnixRuntime$HostFS var3 = (UnixRuntime$HostFS)var2;
      var3.getClass();
      return new UnixRuntime$HostFS$HostDirFD(var3, var1);
   }

   private static void putInt(byte[] var0, int var1, int var2) {
      var0[var1 + 0] = (byte)(var2 >>> 24 & 255);
      var0[var1 + 1] = (byte)(var2 >>> 16 & 255);
      var0[var1 + 2] = (byte)(var2 >>> 8 & 255);
      var0[var1 + 3] = (byte)(var2 >>> 0 & 255);
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static void access$500(byte[] var0, int var1, int var2) {
      putInt(var0, var1, var2);
   }

   static {
      Method var0;
      try {
         var0 = Class.forName("org.ibex.nestedvm.RuntimeCompiler").getMethod("compile", new Class[]{class$org$ibex$nestedvm$util$Seekable == null?(class$org$ibex$nestedvm$util$Seekable = class$("org.ibex.nestedvm.util.Seekable")):class$org$ibex$nestedvm$util$Seekable, class$java$lang$String == null?(class$java$lang$String = class$("java.lang.String")):class$java$lang$String, class$java$lang$String == null?(class$java$lang$String = class$("java.lang.String")):class$java$lang$String});
      } catch (NoSuchMethodException var2) {
         var0 = null;
      } catch (ClassNotFoundException var3) {
         var0 = null;
      }

      runtimeCompilerCompile = var0;
   }
}
