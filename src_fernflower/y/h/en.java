package y.h;

import y.h.az;
import y.h.dZ;
import y.h.ea;
import y.h.el;
import y.h.fj;
import y.h.gy;
import y.h.gz;
import y.h.id;

public final class en {
   final boolean a;
   private final el b;
   private final el c;
   private final boolean d;

   public el a() {
      return this.c;
   }

   public el b() {
      return this.b;
   }

   void a(double var1, double var3) {
      this.b.a(var1, var3);
      this.c.a(var1, var3);
   }

   public en(el var1, el var2) {
      label31: {
         boolean var7 = fj.z;
         super();
         double var3 = var1.b().a - var2.b().a;
         double var5 = var1.b().b - var2.b().b;
         if(var3 == 0.0D && (var5 != 0.0D || var1.c() != var2.c())) {
            this.a = true;
            this.d = true;
            if(!var7) {
               break label31;
            }
         }

         if(var5 == 0.0D && (var3 != 0.0D || var1.d() != var2.d())) {
            this.a = false;
            this.d = true;
            if(!var7) {
               break label31;
            }
         }

         this.d = false;
         this.a = true;
      }

      this.b = var1;
      this.c = var2;
   }

   gz a(gy var1, y.d.t var2, double var3, double var5, double var7) {
      if(!this.d) {
         return gz.b;
      } else {
         if(this.a == (var1.c() == 1)) {
            y.d.t var9 = var1.b();
            double var10;
            double var12;
            double var14;
            if(this.a) {
               var10 = var9.a - this.b.a(var3);
               if(Math.abs(var10) < var7) {
                  var12 = Math.min(this.b.b(var5), this.c.b(var5));
                  var14 = Math.max(this.b.b(var5), this.c.b(var5));
                  if(var12 < var1.f() && var14 > var1.e()) {
                     if(var1 instanceof id) {
                        return new dZ(this, 0.5D * var1.a(), (az)null, true, var2.a + var3 + var10, var1.g(), var1);
                     }

                     return gz.a(0.5D * var1.a(), var1, true, var2.a + var3 + var10, var1.g());
                  }
               }
            } else {
               var10 = var9.b - this.b.b(var5);
               if(Math.abs(var10) < var7) {
                  var12 = Math.min(this.b.a(var3), this.c.a(var3));
                  var14 = Math.max(this.b.a(var3), this.c.a(var3));
                  if(var12 < var1.f() && var14 > var1.e()) {
                     if(var1 instanceof id) {
                        return new ea(this, 0.5D * var1.a(), (az)null, false, var2.b + var5 + var10, var1.g(), var1);
                     }

                     return gz.a(0.5D * var1.a(), var1, false, var2.b + var5 + var10, var1.g());
                  }
               }
            }
         }

         return gz.b;
      }
   }

   static el a(en var0) {
      return var0.b;
   }

   static el b(en var0) {
      return var0.c;
   }
}
