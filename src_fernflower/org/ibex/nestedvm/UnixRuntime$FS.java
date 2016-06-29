package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.UnixRuntime;
import org.ibex.nestedvm.UnixRuntime$GlobalState;

public abstract class UnixRuntime$FS {
   static final int OPEN = 1;
   static final int STAT = 2;
   static final int LSTAT = 3;
   static final int MKDIR = 4;
   static final int UNLINK = 5;
   UnixRuntime$GlobalState owner;
   int devno;

   Object dispatch(int var1, UnixRuntime var2, String var3, int var4, int var5) {
      switch(var1) {
      case 1:
         return this.open(var2, var3, var4, var5);
      case 2:
         return this.stat(var2, var3);
      case 3:
         return this.lstat(var2, var3);
      case 4:
         this.mkdir(var2, var3, var4);
         return null;
      case 5:
         this.unlink(var2, var3);
         return null;
      default:
         throw new Error("should never happen");
      }
   }

   public Runtime$FStat lstat(UnixRuntime var1, String var2) {
      return this.stat(var1, var2);
   }

   public abstract Runtime$FD open(UnixRuntime var1, String var2, int var3, int var4);

   public abstract Runtime$FStat stat(UnixRuntime var1, String var2);

   public abstract void mkdir(UnixRuntime var1, String var2, int var3);

   public abstract void unlink(UnixRuntime var1, String var2);
}
