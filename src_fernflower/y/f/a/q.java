package y.f.a;

import y.f.X;
import y.f.a.f;
import y.f.a.j;
import y.f.e.a.af;
import y.f.e.a.ag;
import y.f.e.a.am;

class q implements am {
   private double a;
   private double b;
   private final j c;

   q(j var1) {
      this.c = var1;
   }

   public void a(double var1) {
      this.a = var1;
   }

   public void b(double var1) {
      this.b = var1;
   }

   public void a(y.f.e.a.l var1, af var2) {
      int var25 = f.u;
      X var3 = var2.f();
      if(var3.e() - j.a(this.c).size() > 0) {
         double var4 = 0.0D;
         double var6 = 1.0D / var2.c();
         y.c.x var8 = var3.o();

         double var10;
         q var10000;
         while(true) {
            if(var8.f()) {
               y.c.q var9 = var8.e();
               var10000 = this;
               if(var25 != 0) {
                  break;
               }

               if(!j.c(this.c).d(var9)) {
                  var10 = var2.a(var9).e() * var6;
                  var4 += j.b(this.c).c(var9) * var10;
               }

               var8.g();
               if(var25 == 0) {
                  continue;
               }
            }

            var4 /= (double)(var3.e() - j.a(this.c).size());
            var10000 = this;
            break;
         }

         double var26 = var10000.a;
         var10 = 1.0D - var1.a();
         double var12 = this.a * var4 * var10;
         if(var4 != 0.0D && var12 >= var26) {
            double var14 = this.b;
            this.b += var12;
            j.d(this.c).b(this.b);
            double var16 = this.b / var14;
            y.c.x var18 = j.a(this.c).a();

            while(var18.f()) {
               y.c.q var19 = var18.e();
               ag var20 = var2.c(var19);
               double var21 = var20.b() * var16;
               double var23 = var20.c() * var16;
               var20.a(var21, var23, 0.0D);
               var18.g();
               if(var25 != 0) {
                  break;
               }
            }
         }

      }
   }
}
