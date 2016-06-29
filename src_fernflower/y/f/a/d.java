package y.f.a;

import y.f.a.e;
import y.f.a.f;
import y.f.a.t;

class d implements y.d.g {
   private boolean a = false;
   private double b;
   private double c;
   private y.c.A d;

   d(double var1, double var3, y.c.A var5) {
      this.b = var1;
      this.c = var3;
      this.d = var5;
   }

   public boolean a() {
      return this.a;
   }

   public void a(Object var1, Object var2) {
      e var3 = (e)var1;
      e var4 = (e)var2;
      if(var3.b() != var4.b() && (this.d.d(var3.b()) || this.d.d(var4.b()))) {
         double var5 = t.b(var3.c(), var4.c());
         if(var3.a() && var4.a()) {
            if(var5 >= this.b) {
               return;
            }

            this.a = true;
            if(f.u == 0) {
               return;
            }
         }

         if(var5 < this.c) {
            this.a = true;
         }
      }

   }
}
