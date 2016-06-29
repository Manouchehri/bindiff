package y.f.i.a;

import java.util.ArrayList;
import y.f.i.a.aN;
import y.f.i.a.aS;
import y.f.i.a.ab;
import y.f.i.a.ah;
import y.f.i.a.w;

class aR {
   private final aS[] a;
   private final aN b;

   aR(aN var1, w var2) {
      int var9 = ab.a;
      super();
      this.b = var1;
      y.d.m[] var3 = var2.f();
      ArrayList var4 = new ArrayList();
      int var5 = 0;

      int var10000;
      int var10001;
      while(true) {
         if(var5 < var3.length - 1) {
            y.d.m var6 = var3[var5];
            y.d.m var7 = var3[var5 + 1];
            var10000 = var6.b();
            var10001 = var7.b();
            if(var9 != 0) {
               break;
            }

            if(var10000 != var10001) {
               ah var8 = var2.a(var5 + 1).k();
               var4.add(new aS(var1, var6, var7, var2, var8, var5));
            }

            ++var5;
            if(var9 == 0) {
               continue;
            }
         }

         this.a = new aS[var4.size()];
         var5 = 0;
         var10000 = var5;
         var10001 = this.a.length;
         break;
      }

      while(var10000 < var10001) {
         this.a[var5] = (aS)var4.get(var5);
         ++var5;
         if(var9 != 0) {
            break;
         }

         var10000 = var5;
         var10001 = this.a.length;
      }

   }

   public aS[] a() {
      return this.a;
   }

   public y.c.D b() {
      int var3 = ab.a;
      y.c.D var1 = new y.c.D();
      if(this.a != null && this.a.length >= 1) {
         int var2 = 0;

         y.c.D var10000;
         while(true) {
            if(var2 < this.a.length) {
               var10000 = var1;
               if(var3 != 0) {
                  break;
               }

               var1.a(this.a[var2].g());
               ++var2;
               if(var3 == 0) {
                  continue;
               }
            }

            var10000 = var1;
            break;
         }

         return var10000;
      } else {
         return var1;
      }
   }
}
