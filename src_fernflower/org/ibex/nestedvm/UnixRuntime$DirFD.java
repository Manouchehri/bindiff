package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.UnixRuntime;
import org.ibex.nestedvm.UnixRuntime$DirFD$1;

public abstract class UnixRuntime$DirFD extends Runtime$FD {
   private int pos = -2;

   protected abstract int size();

   protected abstract String name(int var1);

   protected abstract int inode(int var1);

   protected abstract int myDev();

   protected abstract int parentInode();

   protected abstract int myInode();

   public int flags() {
      return 0;
   }

   public int getdents(byte[] var1, int var2, int var3) {
      int var4;
      for(var4 = var2; var3 > 0 && this.pos < this.size(); ++this.pos) {
         int var5;
         int var6;
         switch(this.pos) {
         case -2:
         case -1:
            var5 = this.pos == -1?this.parentInode():this.myInode();
            if(var5 == -1) {
               continue;
            }

            var6 = 9 + (this.pos == -1?2:1);
            if(var6 > var3) {
               return var2 - var4;
            }

            var1[var2 + 8] = 46;
            if(this.pos == -1) {
               var1[var2 + 9] = 46;
            }
            break;
         default:
            String var7 = this.name(this.pos);
            byte[] var8 = Runtime.getBytes(var7);
            var6 = var8.length + 9;
            if(var6 > var3) {
               return var2 - var4;
            }

            var5 = this.inode(this.pos);
            System.arraycopy(var8, 0, var1, var2 + 8, var8.length);
         }

         var1[var2 + var6 - 1] = 0;
         var6 = var6 + 3 & -4;
         UnixRuntime.access$500(var1, var2, var6);
         UnixRuntime.access$500(var1, var2 + 4, var5);
         var2 += var6;
         var3 -= var6;
      }

      return var2 - var4;
   }

   protected Runtime$FStat _fstat() {
      return new UnixRuntime$DirFD$1(this);
   }
}
