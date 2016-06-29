package org.ibex.nestedvm;

import java.io.File;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.util.Seekable$File;

class Runtime$HostFStat extends Runtime$FStat {
   private final File f;
   private final Seekable$File sf;
   private final boolean executable;

   public Runtime$HostFStat(File var1, Seekable$File var2) {
      this(var1, var2, false);
   }

   public Runtime$HostFStat(File var1, boolean var2) {
      this(var1, (Seekable$File)null, var2);
   }

   public Runtime$HostFStat(File var1, Seekable$File var2, boolean var3) {
      this.f = var1;
      this.sf = var2;
      this.executable = var3;
   }

   public int dev() {
      return 1;
   }

   public int inode() {
      return this.f.getAbsolutePath().hashCode() & 32767;
   }

   public int type() {
      return this.f.isDirectory()?16384:'耀';
   }

   public int nlink() {
      return 1;
   }

   public int mode() {
      int var1 = 0;
      boolean var2 = this.f.canRead();
      if(var2 && (this.executable || this.f.isDirectory())) {
         var1 |= 73;
      }

      if(var2) {
         var1 |= 292;
      }

      if(this.f.canWrite()) {
         var1 |= 146;
      }

      return var1;
   }

   public int size() {
      try {
         return this.sf != null?this.sf.length():(int)this.f.length();
      } catch (Exception var2) {
         return (int)this.f.length();
      }
   }

   public int mtime() {
      return (int)(this.f.lastModified() / 1000L);
   }
}
