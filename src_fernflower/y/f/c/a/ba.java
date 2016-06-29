package y.f.c.a;

import y.f.c.a.N;
import y.f.c.a.aT;
import y.f.c.a.aU;
import y.f.c.a.aV;

public class ba implements aT {
   private y.f.c.R a;

   public ba(y.f.c.R var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.a = var1;
      }
   }

   public void a(y.f.X var1, aU var2, aV var3) {
      boolean var10 = N.x;
      y.c.f var4 = new y.c.f();
      y.c.A var5 = var1.t();
      int var6 = this.a.a(var1, var5, var4);
      int var7 = 0;

      while(var7 < var6) {
         var2.a((byte)0, var7);
         ++var7;
         if(var10) {
            break;
         }
      }

      y.c.x var11 = var1.o();

      while(var11.f()) {
         y.c.q var8 = var11.e();
         int var9 = var5.a(var8);
         var2.a(var9).a(var8);
         var11.g();
         if(var10) {
            break;
         }
      }

      y.c.p var12 = var4.k();

      while(true) {
         if(var12 != null) {
            var1.c((y.c.d)var12.c());
            var12 = var12.a();
            if(var10) {
               break;
            }

            if(!var10) {
               continue;
            }
         }

         var1.a((y.c.A)var5);
         break;
      }

   }

   public y.f.c.R a() {
      return this.a;
   }
}
