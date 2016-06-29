package org.ibex.nestedvm;

import java.io.File;
import java.util.Hashtable;
import org.ibex.nestedvm.Runtime;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.UnixRuntime;
import org.ibex.nestedvm.UnixRuntime$CygdriveFS;
import org.ibex.nestedvm.UnixRuntime$DevFS;
import org.ibex.nestedvm.UnixRuntime$FS;
import org.ibex.nestedvm.UnixRuntime$GlobalState$MP;
import org.ibex.nestedvm.UnixRuntime$HostFS;
import org.ibex.nestedvm.UnixRuntime$ResourceFS;
import org.ibex.nestedvm.util.Platform;
import org.ibex.nestedvm.util.Seekable$Lock;
import org.ibex.nestedvm.util.Sort;

public final class UnixRuntime$GlobalState {
   Hashtable execCache;
   final UnixRuntime[] tasks;
   int nextPID;
   Seekable$Lock[] locks;
   private UnixRuntime$GlobalState$MP[] mps;
   private UnixRuntime$FS root;

   public UnixRuntime$GlobalState() {
      this(255);
   }

   public UnixRuntime$GlobalState(int var1) {
      this(var1, true);
   }

   public UnixRuntime$GlobalState(int var1, boolean var2) {
      this.execCache = new Hashtable();
      this.nextPID = 1;
      this.locks = new Seekable$Lock[16];
      this.mps = new UnixRuntime$GlobalState$MP[0];
      this.tasks = new UnixRuntime[var1 + 1];
      if(var2) {
         File var3 = null;
         if(Platform.getProperty("nestedvm.root") != null) {
            var3 = new File(Platform.getProperty("nestedvm.root"));
            if(!var3.isDirectory()) {
               throw new IllegalArgumentException("nestedvm.root is not a directory");
            }
         } else {
            String var4 = Platform.getProperty("user.dir");
            var3 = Platform.getRoot(new File(var4 != null?var4:"."));
         }

         this.addMount("/", new UnixRuntime$HostFS(var3));
         if(Platform.getProperty("nestedvm.root") == null) {
            File[] var7 = Platform.listRoots();

            for(int var5 = 0; var5 < var7.length; ++var5) {
               String var6 = var7[var5].getPath();
               if(var6.endsWith(File.separator)) {
                  var6 = var6.substring(0, var6.length() - 1);
               }

               if(var6.length() != 0 && var6.indexOf(47) == -1) {
                  this.addMount("/" + var6.toLowerCase(), new UnixRuntime$HostFS(var7[var5]));
               }
            }
         }

         this.addMount("/dev", new UnixRuntime$DevFS());
         this.addMount("/resource", new UnixRuntime$ResourceFS());
         this.addMount("/cygdrive", new UnixRuntime$CygdriveFS());
      }

   }

   public String mapHostPath(String var1) {
      return this.mapHostPath(new File(var1));
   }

   public String mapHostPath(File var1) {
      UnixRuntime$FS var3;
      synchronized(this) {
         this.mps = this.mps;
         var3 = this.root;
      }

      if(!var1.isAbsolute()) {
         var1 = new File(var1.getAbsolutePath());
      }

      for(int var4 = this.mps.length; var4 >= 0; --var4) {
         UnixRuntime$FS var5 = var4 == this.mps.length?var3:this.mps[var4].fs;
         String var6 = var4 == this.mps.length?"":this.mps[var4].path;
         if(var5 instanceof UnixRuntime$HostFS) {
            File var7 = ((UnixRuntime$HostFS)var5).getRoot();
            if(!var7.isAbsolute()) {
               var7 = new File(var7.getAbsolutePath());
            }

            if(var1.getPath().startsWith(var7.getPath())) {
               char var8 = File.separatorChar;
               String var9 = var1.getPath().substring(var7.getPath().length());
               if(var8 != 47) {
                  char[] var10 = var9.toCharArray();

                  for(int var11 = 0; var11 < var10.length; ++var11) {
                     if(var10[var11] == 47) {
                        var10[var11] = var8;
                     } else if(var10[var11] == var8) {
                        var10[var11] = 47;
                     }
                  }

                  var9 = new String(var10);
               }

               String var13 = "/" + (var6.length() == 0?"":var6 + "/") + var9;
               return var13;
            }
         }
      }

      return null;
   }

   public synchronized UnixRuntime$FS getMount(String var1) {
      if(!var1.startsWith("/")) {
         throw new IllegalArgumentException("Mount point doesn\'t start with a /");
      } else if(var1.equals("/")) {
         return this.root;
      } else {
         var1 = var1.substring(1);

         for(int var2 = 0; var2 < this.mps.length; ++var2) {
            if(this.mps[var2].path.equals(var1)) {
               return this.mps[var2].fs;
            }
         }

         return null;
      }
   }

   public synchronized void addMount(String var1, UnixRuntime$FS var2) {
      if(this.getMount(var1) != null) {
         throw new IllegalArgumentException("mount point already exists");
      } else if(!var1.startsWith("/")) {
         throw new IllegalArgumentException("Mount point doesn\'t start with a /");
      } else {
         if(var2.owner != null) {
            var2.owner.removeMount(var2);
         }

         var2.owner = this;
         if(var1.equals("/")) {
            this.root = var2;
            var2.devno = 1;
         } else {
            var1 = var1.substring(1);
            int var3 = this.mps.length;
            UnixRuntime$GlobalState$MP[] var4 = new UnixRuntime$GlobalState$MP[var3 + 1];
            if(var3 != 0) {
               System.arraycopy(this.mps, 0, var4, 0, var3);
            }

            var4[var3] = new UnixRuntime$GlobalState$MP(var1, var2);
            Sort.sort(var4);
            this.mps = var4;
            int var5 = 0;

            for(int var6 = 0; var6 < this.mps.length; ++var6) {
               var5 = Runtime.max(var5, this.mps[var6].fs.devno);
            }

            var2.devno = var5 + 2;
         }
      }
   }

   public synchronized void removeMount(UnixRuntime$FS var1) {
      for(int var2 = 0; var2 < this.mps.length; ++var2) {
         if(this.mps[var2].fs == var1) {
            this.removeMount(var2);
            return;
         }
      }

      throw new IllegalArgumentException("mount point doesn\'t exist");
   }

   public synchronized void removeMount(String var1) {
      if(!var1.startsWith("/")) {
         throw new IllegalArgumentException("Mount point doesn\'t start with a /");
      } else {
         if(var1.equals("/")) {
            this.removeMount(-1);
         } else {
            var1 = var1.substring(1);

            int var2;
            for(var2 = 0; var2 < this.mps.length && !this.mps[var2].path.equals(var1); ++var2) {
               ;
            }

            if(var2 == this.mps.length) {
               throw new IllegalArgumentException("mount point doesn\'t exist");
            }

            this.removeMount(var2);
         }

      }
   }

   private void removeMount(int var1) {
      if(var1 == -1) {
         this.root.owner = null;
         this.root = null;
      } else {
         UnixRuntime$GlobalState$MP[] var2 = new UnixRuntime$GlobalState$MP[this.mps.length - 1];
         System.arraycopy(this.mps, 0, var2, 0, var1);
         System.arraycopy(this.mps, 0, var2, var1, this.mps.length - var1 - 1);
         this.mps = var2;
      }
   }

   private Object fsop(int var1, UnixRuntime var2, String var3, int var4, int var5) {
      int var6 = var3.length();
      if(var6 != 0) {
         UnixRuntime$GlobalState$MP[] var7;
         synchronized(this) {
            var7 = this.mps;
         }

         for(int var8 = 0; var8 < var7.length; ++var8) {
            UnixRuntime$GlobalState$MP var9 = var7[var8];
            int var10 = var9.path.length();
            if(var3.startsWith(var9.path) && (var6 == var10 || var3.charAt(var10) == 47)) {
               return var9.fs.dispatch(var1, var2, var6 == var10?"":var3.substring(var10 + 1), var4, var5);
            }
         }
      }

      return this.root.dispatch(var1, var2, var3, var4, var5);
   }

   public final Runtime$FD open(UnixRuntime var1, String var2, int var3, int var4) {
      return (Runtime$FD)this.fsop(1, var1, var2, var3, var4);
   }

   public final Runtime$FStat stat(UnixRuntime var1, String var2) {
      return (Runtime$FStat)this.fsop(2, var1, var2, 0, 0);
   }

   public final Runtime$FStat lstat(UnixRuntime var1, String var2) {
      return (Runtime$FStat)this.fsop(3, var1, var2, 0, 0);
   }

   public final void mkdir(UnixRuntime var1, String var2, int var3) {
      this.fsop(4, var1, var2, var3, 0);
   }

   public final void unlink(UnixRuntime var1, String var2) {
      this.fsop(5, var1, var2, 0, 0);
   }
}
