package org.ibex.nestedvm;

import java.io.File;
import org.ibex.nestedvm.UnixRuntime$DirFD;
import org.ibex.nestedvm.UnixRuntime$HostFS;

public class UnixRuntime$HostFS$HostDirFD extends UnixRuntime$DirFD {
   private final File f;
   private final File[] children;
   private final UnixRuntime$HostFS this$0;

   public UnixRuntime$HostFS$HostDirFD(UnixRuntime$HostFS var1, File var2) {
      this.this$0 = var1;
      this.f = var2;
      String[] var3 = var2.list();
      this.children = new File[var3.length];

      for(int var4 = 0; var4 < var3.length; ++var4) {
         this.children[var4] = new File(var2, var3[var4]);
      }

   }

   public int size() {
      return this.children.length;
   }

   public String name(int var1) {
      return this.children[var1].getName();
   }

   public int inode(int var1) {
      return this.this$0.inodes.get(this.children[var1].getAbsolutePath());
   }

   public int parentInode() {
      File var1 = UnixRuntime$HostFS.access$400(this.f);
      return var1 == null?this.myInode():this.this$0.inodes.get(var1.getAbsolutePath());
   }

   public int myInode() {
      return this.this$0.inodes.get(this.f.getAbsolutePath());
   }

   public int myDev() {
      return this.this$0.devno;
   }
}
