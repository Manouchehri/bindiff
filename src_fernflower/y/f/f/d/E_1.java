package y.f.f.d;

import y.f.X;
import y.f.f.d.M;
import y.f.f.d.o;

class E implements M {
   private y.f.f.b.h a;
   private int b = 0;
   private int c;
   private int d;

   public E(int var1) {
      this.c = var1;
   }

   public boolean a() {
      return false;
   }

   public void a(y.f.f.b.h var1) {
      boolean var6 = o.p;
      y.g.o.a(this, "Kandinsky Node Model !");
      this.a = var1;
      this.d = 1;
      X var2 = (X)var1.a();
      y.c.x var3 = var1.a().o();

      while(true) {
         if(var3.f()) {
            y.c.q var4 = var3.e();
            if(var6) {
               break;
            }

            if(var1.d(var4)) {
               var2.b(var3.e(), (double)this.c * 1.5D, (double)this.c * 1.5D);
               int[][] var5 = var1.i(var4);
               this.d = Math.max(this.d, var5[0][0]);
               this.d = Math.max(this.d, var5[1][0]);
               this.d = Math.max(this.d, var5[2][0]);
               this.d = Math.max(this.d, var5[3][0]);
               this.d = Math.max(this.d, var5[0][2]);
               this.d = Math.max(this.d, var5[1][2]);
               this.d = Math.max(this.d, var5[2][2]);
               this.d = Math.max(this.d, var5[3][2]);
            }

            var3.g();
            if(!var6) {
               continue;
            }
         }

         this.b = 2;
         break;
      }

   }

   public boolean a(y.c.q var1) {
      return this.a.d(var1);
   }

   public int b(y.c.q var1) {
      return this.b;
   }

   public int c(y.c.q var1) {
      return this.b;
   }

   public boolean d(y.c.q var1) {
      return this.a(var1);
   }

   public double b() {
      return (double)(2 * this.d);
   }

   public boolean c() {
      return true;
   }

   public int e(y.c.q var1) {
      return this.d;
   }

   public int f(y.c.q var1) {
      return this.d;
   }

   public void d() {
   }
}
