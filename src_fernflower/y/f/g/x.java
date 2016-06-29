package y.f.g;

import java.util.BitSet;
import y.f.g.d;

class x extends BitSet {
   public x() {
   }

   public x(int var1) {
      super(var1);
   }

   public int nextSetBit(int var1) {
      boolean var4 = d.d;
      int var2 = this.size();
      int var3 = var1;

      byte var10000;
      while(true) {
         if(var3 < var2) {
            var10000 = this.get(var3);
            if(var4) {
               break;
            }

            if(var10000 != 0) {
               return var3;
            }

            ++var3;
            if(!var4) {
               continue;
            }
         }

         var10000 = -1;
         break;
      }

      return var10000;
   }

   public int cardinality() {
      boolean var4 = d.d;
      int var1 = this.size();
      int var2 = 0;
      int var3 = 0;

      int var10000;
      while(true) {
         if(var3 < var1) {
            var10000 = this.get(var3);
            if(var4) {
               break;
            }

            if(var10000 != 0) {
               ++var2;
            }

            ++var3;
            if(!var4) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   public void clear(int var1, int var2) {
      boolean var4 = d.d;
      int var3 = var1;

      while(var3 < var2) {
         this.clear(var3);
         ++var3;
         if(var4) {
            break;
         }
      }

   }

   public void set(int var1, int var2) {
      boolean var4 = d.d;
      int var3 = var1;

      while(var3 < var2) {
         this.set(var3);
         ++var3;
         if(var4) {
            break;
         }
      }

   }
}
