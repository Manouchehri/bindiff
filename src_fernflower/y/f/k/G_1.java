package y.f.k;

import y.f.k.A;
import y.f.k.B;
import y.f.k.E;
import y.f.k.F;
import y.f.k.I;
import y.f.k.K;
import y.f.k.P;
import y.f.k.d;
import y.f.k.x;

class G implements K {
   private x a;
   private final y.f.X b;
   private final y.c.q c;
   private double d;
   private y.c.A e;
   private final B f;

   G(B var1, x var2, y.f.X var3, y.c.q var4) {
      this.f = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   public void a(y.c.b var1, y.c.b var2, y.c.b var3) {
      if(this.b.c(B.h) == null) {
         this.e = this.b.t();
         this.b.a((Object)B.h, (y.c.c)this.e);
      }

      this.a((y.c.A)this.b.c(B.h), var1);
   }

   E a(y.c.A var1, y.c.b var2) {
      int var12 = d.g;
      E var3 = new E(this.f, this.b);
      var3.a(this.d);
      y.c.y var4 = new y.c.y();
      var4.add(this.c);

      while(var4.size() > 0) {
         y.c.q var5;
         F var6;
         label49: {
            var5 = var4.d();
            if(var5 == this.c || var5.g() == null) {
               var6 = var3.a(0);
               if(var12 == 0) {
                  break label49;
               }
            }

            y.c.q var7 = var5.g().c();
            F var8 = (F)var1.b(var7);
            var6 = var8.e();
         }

         A var13 = this.a.f(var5);
         P var14 = new P(this.f.c, var13);
         var6.a(var5, var14, this.f.c);
         var1.a(var5, var6);
         I var9 = (I)var2.b(var5);
         if(var9 instanceof B && this.f.c().equals(((B)var9).c())) {
            y.c.d var10 = var5.f();

            while(var10 != null) {
               y.c.q var11 = var10.d();
               var4.add(var11);
               var10 = var10.g();
               if(var12 != 0 || var12 != 0) {
                  return var3;
               }
            }
         }
      }

      return var3;
   }

   public void a() {
      if(this.e != null) {
         this.b.a((y.c.A)this.e);
         this.b.d_(B.h);
      }

   }

   public void a(double var1) {
      this.d = var1;
   }
}
