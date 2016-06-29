package y.f.i.a;

import java.util.Iterator;
import java.util.List;
import y.f.i.a.H;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.V;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.f;
import y.f.i.a.v;

class aM extends ab implements H {
   private double b;
   private double c;
   private double d;
   private boolean e;
   private int f;
   private boolean g = false;

   protected void b(aa var1) {
      super.b(var1);
      this.b = var1.d().d();
      this.f = var1.d().f().j();
      this.g = this.f > 0 && this.b > 0.0D;
      if(this.g) {
         var1.a().a((H)this);
      }

   }

   protected void c(aa var1) {
      super.c(var1);
      if(this.g) {
         var1.a().b((H)this);
      }

   }

   protected void d(aa var1) {
      super.d(var1);
      if(this.g) {
         var1.a().b((H)this);
      }

   }

   protected double a(f var1) {
      if(!this.g) {
         return 0.0D;
      } else if(!this.b().b(var1.a()) && this.b().b(var1.b().a())) {
         y.f.X var2 = this.a().a();
         y.c.d var3 = this.b().c();
         y.d.y var4 = var2.s(var3.c());
         P var5 = var1.c();
         double var6;
         double var8;
         if(var5.a()) {
            var6 = var4.d() + this.b;
            var8 = var4.d() + var4.b() - this.b;
            if(ab.a == 0) {
               return var5.b() + 1.0E-6D >= var6 && var5.c() - 1.0E-6D <= var8?0.0D:(double)this.f;
            }
         }

         var6 = var4.c() + this.b;
         var8 = var4.c() + var4.a() - this.b;
         return var5.b() + 1.0E-6D >= var6 && var5.c() - 1.0E-6D <= var8?0.0D:(double)this.f;
      } else {
         return 0.0D;
      }
   }

   protected void a(List var1) {
      int var21 = ab.a;
      if(this.g) {
         y.f.X var2 = this.a().a();
         aa var3 = this.b();
         y.c.d var4 = var3.c();
         y.d.y var5 = var2.s(var4.c());
         int var6 = 0;
         int var7 = var3.e();

         do {
            int var10000 = var6;

            label52:
            while(true) {
               if(var10000 >= var7) {
                  return;
               }

               R var8 = var3.a(var6);
               f var9 = new f(var8);
               List var10 = this.a().c().r().c(var8);
               Iterator var11 = var10.iterator();

               while(true) {
                  R var12;
                  P var13;
                  double var14;
                  double var16;
                  P var18;
                  y.f.y var19;
                  f var20;
                  while(true) {
                     do {
                        if(!var11.hasNext()) {
                           break label52;
                        }

                        var12 = (R)var11.next();
                     } while(var3.b(var12));

                     var13 = V.a(var8, var12);
                     var10000 = var13.a();
                     if(var21 != 0) {
                        continue label52;
                     }

                     if(var10000 == 0) {
                        break;
                     }

                     if(var5.b() > 2.0D * this.b) {
                        var14 = Math.max(var13.b(), var5.d() + this.b);
                        var16 = Math.min(var13.c(), var5.d() + var5.b() - this.b);
                        if(var14 < var16) {
                           var18 = new P(var14, var16, var13.f(), true);
                           var19 = V.a(var9, var12);
                           var20 = new f(var12);
                           var20.a(var9);
                           var20.a(var18);
                           var20.a(var19);
                           var1.add(var20);
                           if(var21 != 0) {
                              break;
                           }
                        }
                     }
                  }

                  if(var5.a() > 2.0D * this.b) {
                     var14 = Math.max(var13.b(), var5.c() + this.b);
                     var16 = Math.min(var13.c(), var5.c() + var5.a() - this.b);
                     if(var14 < var16) {
                        var18 = new P(var14, var16, var13.f(), false);
                        var19 = V.a(var9, var12);
                        var20 = new f(var12);
                        var20.a(var9);
                        var20.a(var18);
                        var20.a(var19);
                        var1.add(var20);
                        if(var21 != 0) {
                           break label52;
                        }
                     }
                  }
               }
            }

            ++var6;
         } while(var21 == 0);

      }
   }

   double[] a(f var1, R var2, P[] var3, v[] var4, double[] var5) {
      if(!this.g) {
         this.b("min node corner dist penalty", 0.0D, false);
         return new double[var3.length];
      } else {
         y.f.X var6 = this.a().a();
         y.c.d var7 = this.b().c();
         y.d.y var8 = var6.s(var7.d());
         R var9 = var1.a();
         this.e = !a(var8, var9) && a(var8, var2);
         if(!this.e) {
            this.b("min node corner dist penalty", 0.0D, false);
            return new double[var3.length];
         } else {
            if(var3[0].a()) {
               this.c = var8.d() + this.b;
               this.d = var8.d() + var8.b() - this.b;
               if(ab.a == 0) {
                  return super.a(var1, var2, var3, var4, var5);
               }
            }

            this.c = var8.c() + this.b;
            this.d = var8.c() + var8.a() - this.b;
            return super.a(var1, var2, var3, var4, var5);
         }
      }
   }

   protected double a(f var1, R var2, P var3, v var4, double var5) {
      int var7 = 0;
      if(this.e && (var3.b() + 1.0E-6D < this.c || var3.c() - 1.0E-6D > this.d)) {
         var7 += this.f;
      }

      this.a("min node corner dist penalty", (double)var7, false);
      return (double)var7;
   }

   public void a(f var1, R var2, P var3, List var4, aa var5) {
      if(this.b > 0.0D) {
         y.f.X var6 = this.a().a();
         y.c.d var7 = var5.c();
         P var8 = null;
         y.d.y var9 = var6.s(var7.d());
         if(!a(var9, var1.a()) && a(var9, var2)) {
            double var10;
            double var12;
            if(var3.a()) {
               if(var9.b() > 2.0D * this.b) {
                  var10 = Math.max(var3.b(), var9.d() + this.b);
                  var12 = Math.min(var3.c(), var9.d() + var9.b() - this.b);
                  if(var10 < var12) {
                     var8 = new P(var10, var12, var3.f(), true);
                  }
               }
            } else if(var9.a() > 2.0D * this.b) {
               var10 = Math.max(var3.b(), var9.c() + this.b);
               var12 = Math.min(var3.c(), var9.c() + var9.a() - this.b);
               if(var10 < var12) {
                  var8 = new P(var10, var12, var3.f(), false);
               }
            }
         }

         if(var8 != null) {
            var4.add(var8);
         }

      }
   }

   private static boolean a(y.d.y var0, R var1) {
      y.d.t var2 = var0.e();
      y.d.t var3 = new y.d.t(var0.c + var0.a, var0.d + var0.b);
      return var2.a - 1.0E-6D < var1.h() && var2.b - 1.0E-6D < var1.i() && var3.a + 1.0E-6D > var1.j() && var3.b + 1.0E-6D > var1.k();
   }
}
