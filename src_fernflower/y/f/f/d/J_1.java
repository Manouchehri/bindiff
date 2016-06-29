package y.f.f.d;

import java.awt.Dimension;
import y.f.X;
import y.f.f.d.M;
import y.f.f.d.o;

class J implements M {
   private y.f.f.b.h a;
   private y.c.A b;
   private int c;

   public J(int var1) {
      this.c = var1;
   }

   public void a(y.f.f.b.h var1) {
      boolean var9 = o.p;
      y.g.o.a(this, "Big Node Model !");
      this.a = var1;
      X var2 = (X)var1.a();
      this.b = var1.a().t();
      y.c.x var3 = var1.a().o();

      while(var3.f()) {
         y.c.q var4 = var3.e();
         if(var1.d(var4)) {
            Dimension var5 = null;
            int[] var6 = var1.h(var4);
            if(var6[0] <= 1 && var6[1] <= 1 && var6[2] <= 1 && var6[3] <= 1) {
               var5 = new Dimension(0, 0);
            } else {
               int var7 = var6[1] > var6[3]?var6[1]:var6[3];
               int var8 = var6[0] > var6[2]?var6[0]:var6[2];
               if(var7 > 0) {
                  --var7;
               }

               if(var8 > 0) {
                  --var8;
               }

               var5 = new Dimension(var8, var7);
            }

            this.b.a(var4, var5);
            var2.b(var4, (double)(var5.width * this.c + this.c / 2), (double)(var5.height * this.c + this.c / 2));
         }

         var3.g();
         if(var9) {
            break;
         }
      }

   }

   public boolean a() {
      return false;
   }

   public boolean a(y.c.q var1) {
      return this.a.d(var1);
   }

   public int b(y.c.q var1) {
      Dimension var2 = (Dimension)this.b.b(var1);
      return var2.width;
   }

   public int c(y.c.q var1) {
      Dimension var2 = (Dimension)this.b.b(var1);
      return var2.height;
   }

   public boolean d(y.c.q var1) {
      return this.a(var1);
   }

   public double b() {
      return 1.0D;
   }

   public boolean c() {
      return false;
   }

   public int e(y.c.q var1) {
      return 0;
   }

   public int f(y.c.q var1) {
      return 0;
   }

   public void d() {
      this.a.a().a(this.b);
   }
}
