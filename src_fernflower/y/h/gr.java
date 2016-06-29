package y.h;

import y.h.aB;
import y.h.aI;
import y.h.fj;
import y.h.x;
import y.h.z;

public class gr implements aI {
   public int a(aB var1) {
      return 0;
   }

   public x a(aB var1, z var2, double var3, double var5, x var7, int var8) {
      x var9 = new x(var1, var3, var5);
      this.a(var1, var2, var9, var7, var8);
      return var9;
   }

   public void a(aB var1, z var2, x var3, x var4, int var5) {
      label28: {
         boolean var6 = fj.z;
         if(var5 == 0) {
            if(var2.size() > 0 && var4 == var2.i()) {
               var2.b(var3, var2.l());
               if(!var6) {
                  break label28;
               }
            }

            var2.b(var3, var2.d(var4));
            if(!var6) {
               break label28;
            }
         }

         if(var2.size() > 0 && var4 == var2.f()) {
            var2.a(var3, var2.k());
            if(!var6) {
               break label28;
            }
         }

         var2.a(var3, var2.d(var4));
      }

      var1.setDirty();
   }

   public x a(aB var1, z var2, double var3, double var5) {
      int var7 = var1.containsSeg(var3, var5);
      return var7 > 0 && var7 <= var2.size()?this.a(var1, var2, var3, var5, (x)var2.a(var7 - 1), 1):var1.appendBend(var3, var5);
   }

   public void a(aB var1, z var2, x var3, double var4, double var6) {
   }

   public x a(aB var1, z var2, x var3) {
      var2.remove(var3);
      var1.setDirty();
      return var3;
   }
}
