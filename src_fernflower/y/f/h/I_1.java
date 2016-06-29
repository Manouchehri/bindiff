package y.f.h;

import y.f.h.D;
import y.f.h.N;
import y.f.h.p;

public class I {
   private y.c.f a = new y.c.f();
   private D b;

   public I(D var1) {
      this.b = var1;
   }

   public void a() {
      boolean var3 = N.d;
      y.c.i var1 = this.b.g();
      y.c.e var2 = var1.p();

      while(var2.f()) {
         if(var2.a().e()) {
            this.a.c(var2.a());
            var1.d(var2.a());
         }

         var2.g();
         if(var3) {
            break;
         }
      }

   }

   public void b() {
      boolean var6 = N.d;
      y.c.i var1 = this.b.g();
      y.c.e var2 = this.a.a();

      while(var2.f()) {
         y.c.d var3 = var2.a();
         y.c.d var10000 = var3;

         label41:
         while(true) {
            if(var10000.c().a() == 0) {
               var1.e(var3);
               this.b.g(var3);
               this.b.l();
               this.b.b((p)this.b.h().a());
               if(!var6) {
                  break;
               }
            }

            y.c.d var4 = null;
            y.c.e var5 = var3.c().l();

            while(var5.f()) {
               var10000 = var4;
               if(var6) {
                  continue label41;
               }

               if(var4 == null) {
                  var4 = var5.a();
               }

               if(this.b.i(var5.a()).a().k() == 1) {
                  var4 = var5.a();
               }

               var5.g();
               if(var6) {
                  break;
               }
            }

            var1.e(var3);
            this.b.a(var4, var3);
            this.b.k();
            break;
         }

         var2.g();
         if(var6) {
            break;
         }
      }

   }
}
