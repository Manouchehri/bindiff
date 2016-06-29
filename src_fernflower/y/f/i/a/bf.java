package y.f.i.a;

import java.util.HashSet;
import java.util.Iterator;
import y.f.i.a.M;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.aW;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.bD;
import y.f.i.a.bE;
import y.f.i.a.bR;
import y.f.i.a.bg;
import y.f.i.a.bh;
import y.f.i.a.f;
import y.f.i.a.v;

class bf extends ab implements bR {
   private int b;

   protected void b(aa var1) {
      super.b(var1);
      this.b = var1.d().f().b();
      if(this.d()) {
         var1.a().a((bR)this);
      }

   }

   protected void c(aa var1) {
      super.c(var1);
      if(this.d()) {
         this.b().a().b((bR)this);
      }

   }

   protected void d(aa var1) {
      super.d(var1);
      if(this.d()) {
         this.b().a().b((bR)this);
      }

   }

   private boolean d() {
      return this.b > 0;
   }

   double[] a(f var1, R var2, P[] var3, v[] var4, double[] var5) {
      if(!this.d()) {
         this.b("crossing cost", 0.0D, false);
         return new double[var3.length];
      } else {
         return super.a(var1, var2, var3, var4, var5);
      }
   }

   protected double a(f var1, R var2, P var3, v var4, double var5) {
      int var7;
      label60: {
         int var19 = ab.a;
         var7 = 0;
         if(var4 != null && var4.c() == 0 && !var4.i().d(var4.j())) {
            P var8 = var4.i();
            M var9 = var8.e();
            M var10 = var3.e();
            P var11 = new P(var10, var8.f(), var8.a());
            v var12 = null;
            v var13 = new v(var4.g(), var4.h(), var11, var4.j(), var4.k(), var4.l(), var4.d());
            y.c.D var14 = new y.c.D();
            var14.add(new bh(var1, var12, var13, (bg)null));
            var12 = var1.j();
            f var15 = var1.b();

            while(var15 != null && var12 != null) {
               P var16;
               P var17;
               boolean var18;
               label51: {
                  var16 = var8;
                  var17 = var11;
                  var18 = var12.c() == 0 && !var12.i().d(var11);
                  if(var18) {
                     var8 = new P(var9, var12.i().f(), var12.i().a());
                     var11 = new P(var10, var12.i().f(), var12.i().a());
                     if(var19 == 0) {
                        break label51;
                     }
                  }

                  var8 = var12.i();
                  var11 = var12.i();
               }

               var12 = new v(var12.g(), var12.h(), var8, var16, var12.k(), var12.l(), var12.d());
               var13 = new v(var12.g(), var12.h(), var11, var17, var12.k(), var12.l(), var12.d());
               var14.a((Object)(new bh(var15, var12, var13, (bg)null)));
               if(!var18) {
                  break;
               }

               var12 = var15.j();
               var15 = var15.b();
               if(var19 != 0) {
                  break;
               }
            }

            Iterator var21 = var14.iterator();

            do {
               if(!var21.hasNext()) {
                  break label60;
               }

               bh var22 = (bh)var21.next();
               if(bh.a(var22) != null) {
                  var7 -= this.a(bh.b(var22), bh.a(var22));
               }

               var7 += this.a(bh.b(var22), bh.c(var22));
            } while(var19 == 0);
         }

         var7 = this.a(var1, var4);
      }

      double var20 = (double)(var7 * this.b);
      this.a("crossing cost", var20, false);
      return var20;
   }

   private int a(f var1, v var2) {
      int var12 = ab.a;
      int var3 = 0;
      y.c.D var4 = var1.a().b().a();
      if(var4 != null && !var4.isEmpty()) {
         y.c.D var5 = new y.c.D();
         HashSet var6 = new HashSet();
         y.c.C var7 = var4.m();

         while(var7.f()) {
            v var8 = (v)var7.d();
            bD var9 = this.a(var1, this.b().c(), var8.g());
            bE var10 = var8.a().a(var2, var9);
            aW var11 = var8.f();
            if(var12 != 0) {
               return var3;
            }

            if(var11 == null || var6.add(var11)) {
               var3 += var10.a();
            }

            if(var10.c()) {
               var5.add(var10.b());
            }

            var7.g();
            if(var12 != 0) {
               break;
            }
         }

         if(var5.size() > 0) {
            var2.a = var5;
         }
      }

      return var3;
   }

   private bD a(f var1, y.c.d var2, y.c.d var3) {
      int var7 = ab.a;
      y.c.D var4 = var1.a;
      if(var4 != null && !var4.isEmpty()) {
         y.c.C var5 = var4.m();

         while(var5.f()) {
            bD var6 = (bD)var5.d();
            if(var6.b() == var2 && var6.a() == var3) {
               return var6;
            }

            var5.g();
            if(var7 != 0) {
               break;
            }
         }
      }

      return null;
   }

   public void a(f var1, aa var2, byte var3) {
      if(var3 != 0 && var1.b() != null && var1.j() != null) {
         y.c.D var4 = var1.j().a;
         if(var4 != null) {
            var1.a = var4;
         }
      }

   }
}
