package y.f.i.a;

import java.util.Iterator;
import java.util.List;
import y.f.i.a.L;
import y.f.i.a.M;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.S;
import y.f.i.a.Z;
import y.f.i.a.aU;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.f;
import y.f.i.a.v;
import y.f.i.a.x;

class bW extends ab {
   private List b;
   private L c;
   private double d;

   protected void c() {
      super.c();
      this.b = null;
      this.c = null;
   }

   protected void a(Z var1) {
      super.a(var1);
      this.c = var1.c().k();
      this.b = new y.c.D();
   }

   protected void b(aa var1) {
      super.b(var1);
      this.f(var1);
   }

   private void f(aa var1) {
      double var3;
      boolean var6;
      R var7;
      P var12;
      int var10000;
      label51: {
         int var16 = ab.a;
         x var2 = this.b().d();
         var3 = var2.d();
         int var5 = var2.f().j();
         var6 = var5 > 0 && var3 > 0.0D;
         var7 = var1.g();
         this.b.clear();
         aU var8 = this.a().a(var1.c());
         List var9 = var8 != null?var8.a(false):null;
         if(var9 != null) {
            Iterator var10 = var9.iterator();

            label48:
            do {
               do {
                  if(!var10.hasNext()) {
                     break label48;
                  }

                  y.f.ax var11 = (y.f.ax)var10.next();
                  var10000 = var11.a();
                  if(var16 != 0) {
                     break label51;
                  }

                  if(var10000 == 255) {
                     this.b.clear();
                     if(var16 == 0) {
                        break label48;
                     }
                  }

                  var12 = var7.a(S.a(var11));
                  if(!var11.b()) {
                     break;
                  }

                  y.d.t var13 = var8.a(var11, false);
                  double var14 = var12.a()?var13.b():var13.a();
                  this.b.add(new P(var14, var14, var12.f(), var12.a()));
               } while(var16 == 0);

               this.b.add(this.a(var12, var6, var3));
            } while(var16 == 0);
         }

         var10000 = this.b.isEmpty();
      }

      if(var10000 != 0) {
         P var17 = var7.a(S.a);
         P var18 = var7.a(S.b);
         var12 = var7.a(S.d);
         P var19 = var7.a(S.c);
         this.b.add(this.a(var17, var6, var3));
         this.b.add(this.a(var18, var6, var3));
         this.b.add(this.a(var19, var6, var3));
         this.b.add(this.a(var12, var6, var3));
      }

   }

   private P a(P var1, boolean var2, double var3) {
      return var2 && var1.d() > 2.0D * var3?new P(var1.b() + var3, var1.c() - var3, var1.f(), var1.a()):var1;
   }

   double[] a(f var1, R var2, P[] var3, v[] var4, double[] var5) {
      if(var1.d() == null) {
         this.b("distance penalty", 0.0D, false);
         return new double[var3.length];
      } else {
         this.d = 0.0D;
         if(this.c != null && var4[0].c() == 3) {
            R var6 = var1.a();
            P var7 = this.a(var6, var3[0].a());
            if(this.c.a(var7)) {
               this.d += 2.0D * this.c.b(var3[0].f(), var7);
            }
         }

         return super.a(var1, var2, var3, var4, var5);
      }
   }

   protected double a(f var1, R var2, P var3, v var4, double var5) {
      double var7 = this.d;
      P var9 = this.d(var1);
      if(var9 != null) {
         P var10 = this.a(var3, var9);
         var7 += var9.a(var10);
      }

      double var12 = var7 / this.b().h();
      this.a("distance penalty", var12, false);
      return var12;
   }

   private P a(P var1, P var2) {
      return var1.a() == var2.a()?this.b(var2, var1):this.c(var2, var1);
   }

   private P d(f var1) {
      P var2 = var1.h();
      if(var2 == null) {
         var2 = this.e(var1);
         if(var2 != null) {
            var1.b(var2);
            if(ab.a == 0) {
               return var2;
            }
         }

         var2 = var1.c();
      }

      return var2;
   }

   private P e(f var1) {
      f var2 = var1.b();
      P var3 = var2 != null?this.d(var2):null;
      return var3 != null?this.a(var1.c(), var3):null;
   }

   protected double b(f var1) {
      double var10000;
      double var2;
      label23: {
         int var9 = ab.a;
         var2 = 0.0D;
         if(!this.b.isEmpty()) {
            var2 = Double.MAX_VALUE;
            P var4 = this.d(var1);
            Iterator var5 = this.b.iterator();

            while(var5.hasNext()) {
               P var6 = (P)var5.next();
               double var7 = var4.a(var6);
               if(var7 < var2) {
                  var10000 = var7;
                  if(var9 != 0) {
                     break label23;
                  }

                  var2 = var7;
                  if(var9 != 0) {
                     break;
                  }
               }
            }
         }

         var10000 = var2 / this.b().h();
      }

      double var10 = var10000;
      this.a("HEUR distance penalty", var2 / this.b().h(), true);
      return var10;
   }

   private P b(P var1, P var2) {
      double var3 = var2.f();
      boolean var5 = var2.a();
      if(var1.d() == 0.0D) {
         double var11 = var2.e().c(var1.b());
         if(this.c != null && this.c.a(var2)) {
            var11 = this.c.a(var11, var2);
         }

         return new P(var11, var11, var3, var5);
      } else {
         M var6 = M.a(var1.e(), var2.e());
         double var7;
         if(var6 == null) {
            var7 = var1.b() > var2.c()?var1.b():var1.c();
            double var9 = var2.e().c(var7);
            if(this.c != null && this.c.a(var2)) {
               var9 = this.c.a(var9, var2);
            }

            return new P(var9, var9, var3, var5);
         } else if(this.c == null) {
            return new P(var6, var3, var5);
         } else if(this.c.a(var6, !var5)) {
            M var12 = this.c.b(var6, !var5);
            return new P(var12, var3, var5);
         } else if(this.c.a(var2)) {
            var7 = this.c.a(var1.b(), var2);
            return new P(var7, var7, var3, var5);
         } else {
            return new P(var6, var3, var5);
         }
      }
   }

   private P c(P var1, P var2) {
      double var3 = var2.e().c(var1.f());
      if(this.c != null && this.c.a(var2)) {
         var3 = this.c.a(var3, var2);
      }

      return new P(var3, var3, var2.f(), var2.a());
   }

   private P a(R var1, boolean var2) {
      S var3 = var2?S.a:S.d;
      return var1.a(var3);
   }
}
