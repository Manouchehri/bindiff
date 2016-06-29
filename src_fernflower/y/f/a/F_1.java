package y.f.a;

import java.util.Comparator;

class F implements Comparator, y.g.g {
   y.c.A a;
   y.c.A b;
   y.c.A c;

   public F(y.c.A var1, y.c.A var2, y.c.A var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public int compare(Object var1, Object var2) {
      y.c.q var3 = (y.c.q)var1;
      y.c.q var4 = (y.c.q)var2;
      return this.a.a(var3) < this.a.a(var4)?1:(this.a.a(var3) > this.a.a(var4)?-1:(this.a(this.b.a(var3), this.b.a(var4))?-1:(this.a(this.b.a(var4), this.b.a(var3))?1:(this.c.a(var3) < this.c.a(var4)?-1:(this.c.a(var3) > this.c.a(var4)?1:0)))));
   }

   private boolean a(int var1, int var2) {
      return var1 < var2?(var1 > -1?100.0D < (double)(var2 - var1):(double)var1 + 100.0D < (double)var2):false;
   }
}
