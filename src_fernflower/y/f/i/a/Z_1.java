package y.f.i.a;

import y.f.i.a.aU;
import y.f.i.a.ab;
import y.f.i.a.y;

public class Z {
   private final y a;
   private final y.f.X b;
   private final y.f.b.c c;
   private y.c.h d;
   private long e;

   public Z(y.f.X var1, y.f.b.c var2, y var3) {
      this.b = var1;
      this.c = var2;
      this.a = var3;
   }

   public y.f.X a() {
      return this.b;
   }

   public y.f.b.c b() {
      return this.c;
   }

   public y c() {
      return this.a;
   }

   void a(long var1) {
      this.e = var1;
   }

   public long d() {
      long var1 = System.currentTimeMillis() - this.e;
      return Math.max(0L, this.a.b() - var1);
   }

   aU a(y.c.d var1) {
      aU var2 = (aU)this.e().b(var1);
      return var2;
   }

   private y.c.h e() {
      int var3 = ab.a;
      y.c.h var10000;
      if(this.d == null) {
         this.d = y.g.M.b();
         y.c.e var1 = this.b.p();

         while(var1.f()) {
            y.c.d var2 = var1.a();
            var10000 = this.d;
            if(var3 != 0) {
               return var10000;
            }

            var10000.a(var2, new aU(var2));
            var1.g();
            if(var3 != 0) {
               break;
            }
         }
      }

      var10000 = this.d;
      return var10000;
   }
}
