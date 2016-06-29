package org.ibex.nestedvm;

import java.net.URLConnection;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.UnixRuntime$ResourceFS;

class UnixRuntime$ResourceFS$1 extends Runtime$FStat {
   private final URLConnection val$conn;
   private final UnixRuntime$ResourceFS this$0;

   UnixRuntime$ResourceFS$1(UnixRuntime$ResourceFS var1, URLConnection var2) {
      this.this$0 = var1;
      this.val$conn = var2;
   }

   public int type() {
      return '耀';
   }

   public int nlink() {
      return 1;
   }

   public int mode() {
      return 292;
   }

   public int size() {
      return this.val$conn.getContentLength();
   }

   public int mtime() {
      return (int)(this.val$conn.getDate() / 1000L);
   }

   public int inode() {
      return this.this$0.inodes.get(this.val$conn.getURL().toString());
   }

   public int dev() {
      return this.this$0.devno;
   }
}
