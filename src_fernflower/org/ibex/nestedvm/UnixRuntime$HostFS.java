package org.ibex.nestedvm;

import java.io.File;
import org.ibex.nestedvm.Runtime$ErrnoException;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.UnixRuntime;
import org.ibex.nestedvm.UnixRuntime$FS;
import org.ibex.nestedvm.util.InodeCache;

public class UnixRuntime$HostFS extends UnixRuntime$FS {
   InodeCache inodes;
   protected File root;

   public File getRoot() {
      return this.root;
   }

   protected File hostFile(String var1) {
      char var2 = File.separatorChar;
      if(var2 != 47) {
         char[] var3 = var1.toCharArray();

         for(int var4 = 0; var4 < var3.length; ++var4) {
            char var5 = var3[var4];
            if(var5 == 47) {
               var3[var4] = var2;
            } else if(var5 == var2) {
               var3[var4] = 47;
            }
         }

         var1 = new String(var3);
      }

      return new File(this.root, var1);
   }

   public UnixRuntime$HostFS(String var1) {
      this(new File(var1));
   }

   public UnixRuntime$HostFS(File var1) {
      this.inodes = new InodeCache(4000);
      this.root = var1;
   }

   public Runtime$FD open(UnixRuntime var1, String var2, int var3, int var4) {
      File var5 = this.hostFile(var2);
      return var1.hostFSOpen(var5, var3, var4, this);
   }

   public void unlink(UnixRuntime var1, String var2) {
      File var3 = this.hostFile(var2);
      if(var1.sm != null && !var1.sm.allowUnlink(var3)) {
         throw new Runtime$ErrnoException(1);
      } else if(!var3.exists()) {
         throw new Runtime$ErrnoException(2);
      } else {
         if(!var3.delete()) {
            boolean var4 = false;

            for(int var5 = 0; var5 < 64; ++var5) {
               if(var1.fds[var5] != null) {
                  String var6 = var1.fds[var5].getNormalizedPath();
                  if(var6 != null && var6.equals(var2)) {
                     var1.fds[var5].markDeleteOnClose();
                     var4 = true;
                  }
               }
            }

            if(!var4) {
               throw new Runtime$ErrnoException(1);
            }
         }

      }
   }

   public Runtime$FStat stat(UnixRuntime var1, String var2) {
      File var3 = this.hostFile(var2);
      if(var1.sm != null && !var1.sm.allowStat(var3)) {
         throw new Runtime$ErrnoException(13);
      } else {
         return !var3.exists()?null:var1.hostFStat(var3, this);
      }
   }

   public void mkdir(UnixRuntime var1, String var2, int var3) {
      File var4 = this.hostFile(var2);
      if(var1.sm != null && !var1.sm.allowWrite(var4)) {
         throw new Runtime$ErrnoException(13);
      } else if(var4.exists() && var4.isDirectory()) {
         throw new Runtime$ErrnoException(17);
      } else if(var4.exists()) {
         throw new Runtime$ErrnoException(20);
      } else {
         File var5 = getParentFile(var4);
         if(var5 != null && (!var5.exists() || !var5.isDirectory())) {
            throw new Runtime$ErrnoException(20);
         } else if(!var4.mkdir()) {
            throw new Runtime$ErrnoException(5);
         }
      }
   }

   private static File getParentFile(File var0) {
      String var1 = var0.getParent();
      return var1 == null?null:new File(var1);
   }

   static File access$400(File var0) {
      return getParentFile(var0);
   }
}
