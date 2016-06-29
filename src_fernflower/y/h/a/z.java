package y.h.a;

import y.h.a.E;
import y.h.a.v;

class z {
   y.c.i a;
   y.c.q b;
   private final v c;

   z(v var1, y.c.i var2, y.c.q var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   y.c.i a() {
      return this.b != null?this.b.e():null;
   }

   z b() {
      y.c.i var1 = this.a();
      return var1 != null?v.a(this.c, var1):null;
   }

   y.c.i c() {
      return this.a;
   }

   y.c.q d() {
      return this.b;
   }

   y.c.y a(y.c.q var1) {
      int var5 = v.a;
      y.c.y var2 = null;
      if(var1.e() == this.a) {
         var2 = new y.c.y();
         var2.a(var1);
      } else {
         y.c.i var3 = var1.e();
         var2 = new y.c.y();
         var2.a(var1);

         y.c.i var10000;
         label26: {
            while(var3 != this.a) {
               var10000 = var3;
               if(var5 != 0) {
                  break label26;
               }

               if(var3 == this.c.g()) {
                  break;
               }

               y.c.q var4 = this.c.e(var3);
               var2.a(var4);
               var3 = this.c.f(var3);
               if(var5 != 0) {
                  break;
               }
            }

            var10000 = var3;
         }

         if(var10000 == null) {
            var2 = null;
         }
      }

      return var2;
   }

   void b(y.c.q var1) {
      int var8 = v.a;
      if(this.c.j(var1)) {
         y.c.i var2 = this.c.m(var1);
         var2.j();
         this.c.g(var1);
         if(var8 == 0) {
            return;
         }
      }

      y.c.q var9 = this.d();
      z var3 = this.b();

      while(var3 != null) {
         y.c.i var4 = var9.e();
         y.c.e var5 = var9.j();

         label37: {
            while(var5.f()) {
               y.c.d var6 = (y.c.d)var5.d();
               E var7 = v.a(this.c, var6);
               if(var8 != 0) {
                  break label37;
               }

               if(var7 != null && (var7.a() == var1 || var7.b() == var1)) {
                  var4.a(var6);
               }

               var5.g();
               if(var8 != 0) {
                  break;
               }
            }

            var9 = var3.d();
            var3 = var3.b();
         }

         if(var8 != 0) {
            break;
         }
      }

   }
}
