package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$ErrnoException;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.UnixRuntime;
import org.ibex.nestedvm.UnixRuntime$DevFS$1;
import org.ibex.nestedvm.UnixRuntime$DevFS$2;
import org.ibex.nestedvm.UnixRuntime$DevFS$3;
import org.ibex.nestedvm.UnixRuntime$DevFS$4;
import org.ibex.nestedvm.UnixRuntime$DevFS$5;
import org.ibex.nestedvm.UnixRuntime$DevFS$6;
import org.ibex.nestedvm.UnixRuntime$FS;

public class UnixRuntime$DevFS extends UnixRuntime$FS {
   private static final int ROOT_INODE = 1;
   private static final int NULL_INODE = 2;
   private static final int ZERO_INODE = 3;
   private static final int FD_INODE = 4;
   private static final int FD_INODES = 32;
   private Runtime$FD devZeroFD = new UnixRuntime$DevFS$1(this);
   private Runtime$FD devNullFD = new UnixRuntime$DevFS$2(this);

   public Runtime$FD open(UnixRuntime var1, String var2, int var3, int var4) {
      if(var2.equals("null")) {
         return this.devNullFD;
      } else if(var2.equals("zero")) {
         return this.devZeroFD;
      } else {
         int var5;
         if(var2.startsWith("fd/")) {
            try {
               var5 = Integer.parseInt(var2.substring(4));
            } catch (NumberFormatException var8) {
               return null;
            }

            return var5 >= 0 && var5 < 64?(var1.fds[var5] == null?null:var1.fds[var5].dup()):null;
         } else if(var2.equals("fd")) {
            var5 = 0;

            for(int var6 = 0; var6 < 64; ++var6) {
               if(var1.fds[var6] != null) {
                  ++var5;
               }
            }

            int[] var9 = new int[var5];
            var5 = 0;

            for(int var7 = 0; var7 < 64; ++var7) {
               if(var1.fds[var7] != null) {
                  var9[var5++] = var7;
               }
            }

            return new UnixRuntime$DevFS$3(this, var9);
         } else {
            return var2.equals("")?new UnixRuntime$DevFS$4(this):null;
         }
      }
   }

   public Runtime$FStat stat(UnixRuntime var1, String var2) {
      if(var2.equals("null")) {
         return this.devNullFD.fstat();
      } else if(var2.equals("zero")) {
         return this.devZeroFD.fstat();
      } else if(var2.startsWith("fd/")) {
         int var3;
         try {
            var3 = Integer.parseInt(var2.substring(3));
         } catch (NumberFormatException var5) {
            return null;
         }

         return var3 >= 0 && var3 < 64?(var1.fds[var3] == null?null:var1.fds[var3].fstat()):null;
      } else {
         return (Runtime$FStat)(var2.equals("fd")?new UnixRuntime$DevFS$5(this):(var2.equals("")?new UnixRuntime$DevFS$6(this):null));
      }
   }

   public void mkdir(UnixRuntime var1, String var2, int var3) {
      throw new Runtime$ErrnoException(30);
   }

   public void unlink(UnixRuntime var1, String var2) {
      throw new Runtime$ErrnoException(30);
   }
}
