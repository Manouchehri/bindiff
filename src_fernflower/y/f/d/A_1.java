package y.f.d;

import java.util.HashMap;
import java.util.Map;
import y.f.Q;
import y.f.R;
import y.f.X;
import y.f.aG;
import y.f.aH;
import y.f.d.C;
import y.f.d.a;
import y.f.d.m;
import y.f.d.r;

class A implements aH {
   private double a = 3.0D;
   private double b = 1.5D;
   private double c = 1.0D;
   private double d = 2.0D;
   private double e = 1.0D;
   private double f = 1.0D;
   private double g = 1.0D;
   private double h = 0.1D;
   private Map i = new HashMap();
   private Map j = new HashMap();
   private double[] k;
   private double[] l;
   private double m;
   private double[] n;
   private double[] o;
   private aH p;

   public void a(double var1) {
      int var3 = a.f;
      if(var1 < 0.0D) {
         this.h = 0.0D;
         if(var3 == 0) {
            return;
         }
      }

      if(var1 > 1.0D) {
         this.h = 1.0D;
         if(var3 == 0) {
            return;
         }
      }

      this.h = var1;
   }

   public A(r[] var1, X var2) {
      this.m = this.b(var1);
      int var3 = this.a(var1);
      this.k = new double[var3];
      this.l = new double[var3];
      this.n = new double[var3];
      this.o = new double[var3];
      this.a(var1, var2);
   }

   public void b(double var1) {
      this.a = var1;
   }

   public void c(double var1) {
      this.f = var1;
   }

   public void d(double var1) {
      this.b = var1;
   }

   public void e(double var1) {
      this.c = var1;
   }

   public void f(double var1) {
      this.d = var1;
   }

   public void g(double var1) {
      this.e = var1;
   }

   public void h(double var1) {
      this.g = var1;
   }

   public double a(Q var1) {
      double var2 = this.a + this.b + this.e + this.d + this.c + this.f + this.g;
      if(var2 == 0.0D) {
         return 0.0D;
      } else {
         double var4 = var1.a() * this.g;
         int var6 = ((Integer)this.i.get(var1)).intValue();
         var4 += this.o[var6] * this.e;
         var4 += this.n[var6] * this.f;
         double var7 = 0.0D;
         if(var1.j() <= 0.0D) {
            ;
         }

         var7 = this.l[var6] > 1.0D?0.0D:1.0D - this.l[var6];
         var4 += var7 * this.b;
         if(var1.i() <= 0.0D) {
            ;
         }

         var7 = this.k[var6] > 1.0D?0.0D:1.0D - this.k[var6];
         var4 += var7 * this.a;
         r var9 = (r)this.j.get(var1);
         var7 = 1.0D / (double)var9.b().size();
         var4 += var7 * this.d;
         var7 = var1.d().f() * var1.d().e() / this.m;
         var4 += var7 * this.c;
         double var10 = var4 / var2;
         if(this.p != null && this.h > 0.0D) {
            var10 = this.p.a(var1) * this.h + var10 * (1.0D - this.h);
         }

         return var10;
      }
   }

   private double a(X var1, Q var2) {
      int var15 = a.f;
      R var3 = var2.e();
      if(!(var3 instanceof y.f.C)) {
         return 0.0D;
      } else {
         y.d.t[] var4 = y.d.n.a(var2.d());
         double var5 = Double.MAX_VALUE;
         y.c.d var7 = a(var3, var1);
         y.d.v var8 = var1.l(var7);
         y.d.u var9 = var8.b();
         y.d.t var10 = var9.a();
         var9.g();

         double var13;
         label40:
         do {
            int var10000 = var9.f();

            label37:
            while(true) {
               if(var10000 == 0) {
                  break label40;
               }

               y.d.m var11 = new y.d.m(var10, var9.a());
               int var12 = 0;

               while(true) {
                  if(var12 >= var4.length) {
                     break label37;
                  }

                  var13 = m.a(var11, var4[var12]);
                  double var17;
                  var10000 = (var17 = var13 - var5) == 0.0D?0:(var17 < 0.0D?-1:1);
                  if(var15 != 0) {
                     break;
                  }

                  if(var10000 < 0) {
                     var5 = var13;
                  }

                  ++var12;
                  if(var15 != 0) {
                     break label37;
                  }
               }
            }

            var10 = var9.a();
            var9.g();
         } while(var15 == 0);

         double var16 = Math.max(0.0D, ((y.f.C)var3).getPreferredPlacementDescriptor().h());
         var13 = Math.abs(var5 - var16);
         return var13 > 100.0D?0.0D:1.0D - var13 / 100.0D;
      }
   }

   private double a(X var1, y.c.d var2) {
      int var8 = a.f;
      y.d.v var3 = var1.l(var2);
      double var4 = 0.0D;
      y.d.s var6 = var3.j();

      double var10000;
      while(true) {
         if(var6.f()) {
            y.d.m var7 = var6.a();
            var10000 = var4 + var7.g();
            if(var8 != 0) {
               break;
            }

            var4 = var10000;
            var6.g();
            if(var8 == 0) {
               continue;
            }
         }

         var10000 = var4;
         break;
      }

      return var10000;
   }

   private static y.c.d a(R var0, X var1) {
      return var1.a((y.f.C)var0);
   }

   private double b(X var1, Q var2) {
      R var3 = var2.e();
      if(!(var3 instanceof y.f.C)) {
         return 0.0D;
      } else {
         y.f.C var4 = (y.f.C)var3;
         aG var5 = var4.getPreferredPlacementDescriptor();
         if(var5.i() && var5.j() && var5.k() || !var5.i() && !var5.j() && !var5.k()) {
            return 1.0D;
         } else {
            double var6 = 1.0D;
            y.c.d var8 = a(var3, var1);
            double var9 = this.a(var1, var8);
            double var11 = Math.max(0.0D, ((y.f.C)var3).getPreferredPlacementDescriptor().h());
            double var13 = 15.0D + var11;
            double var15 = Math.max(100.0D, var9 * 0.2D);
            y.d.n var17 = var2.d();
            y.d.y var18;
            double var19;
            if(var5.i()) {
               var18 = var1.s(var8.c());
               var19 = m.a(var18, var17);
               if(var19 <= var13) {
                  return 1.0D;
               }

               if(var19 < var15) {
                  var6 *= var19 / var15;
               }
            }

            if(var5.k()) {
               var18 = var1.s(var8.d());
               var19 = m.a(var18, var17);
               if(var19 <= var13) {
                  return 1.0D;
               }

               if(var19 < var15) {
                  var6 *= var19 / var15;
               }
            }

            if(var5.j()) {
               y.d.v var24 = var1.l(var8);
               int var25 = (int)Math.floor((double)(var24.h() - 1) * 0.5D);
               y.d.m var20 = var24.a(var25);
               y.d.t var21 = y.d.t.c(var20.c(), var20.d());
               double var22 = m.a(var17, var21);
               var6 *= var22 / var15;
            }

            return 1.0D - var6;
         }
      }
   }

   private void a(r[] var1, X var2) {
      int var8 = a.f;
      int var3 = 0;

      while(var3 < var1.length) {
         r var4 = var1[var3];
         y.c.C var5 = var4.b().m();

         while(true) {
            if(var5.f()) {
               Q var6 = (Q)var5.d();
               int var7 = ((Integer)this.i.get(var6)).intValue();
               this.n[var7] = this.a(var2, var6);
               this.o[var7] = this.b(var2, var6);
               var5.g();
               if(var8 != 0) {
                  break;
               }

               if(var8 == 0) {
                  continue;
               }
            }

            ++var3;
            break;
         }

         if(var8 != 0) {
            break;
         }
      }

   }

   private int a(r[] var1) {
      int var7 = a.f;
      int var2 = 0;
      int var3 = 0;

      while(var3 < var1.length) {
         r var4 = var1[var3];
         y.c.C var5 = var4.b().m();

         while(true) {
            if(var5.f()) {
               Q var6 = (Q)var5.d();
               this.i.put(var6, new Integer(var2++));
               this.j.put(var6, var4);
               var5.g();
               if(var7 != 0) {
                  break;
               }

               if(var7 == 0) {
                  continue;
               }
            }

            ++var3;
            break;
         }

         if(var7 != 0) {
            break;
         }
      }

      return var2;
   }

   void a(Q var1, y.c.q var2, y.d.y var3) {
      int var4 = ((Integer)this.i.get(var1)).intValue();
      double var5 = C.a(var1.d(), var3);
      this.k[var4] += var5;
   }

   void a(Q var1, y.c.d var2, y.d.m var3) {
      int var4 = ((Integer)this.i.get(var1)).intValue();
      double var5 = C.a(var1.d(), var3);
      if(var1.e() != null && var1.e() instanceof y.f.C) {
         y.f.C var7 = (y.f.C)var1.e();
         if(var2.a() != null && var2.a() instanceof X) {
            X var8 = (X)var2.a();
            y.c.d var9 = var8.a(var7);
            if(var2.equals(var9)) {
               var5 /= 2.0D;
            }
         }
      }

      this.l[var4] += var5;
   }

   private double b(r[] var1) {
      int var9 = a.f;
      double var2 = 0.0D;
      int var4 = 0;

      while(var4 < var1.length) {
         y.c.D var5 = var1[var4].b();
         if(!var5.isEmpty()) {
            Q var6 = (Q)var5.f();
            double var7 = var6.d().f() * var6.d().e();
            if(var7 > var2) {
               var2 = var7;
            }
         }

         ++var4;
         if(var9 != 0) {
            break;
         }
      }

      return var2;
   }

   public void a(aH var1) {
      this.p = var1;
   }
}
