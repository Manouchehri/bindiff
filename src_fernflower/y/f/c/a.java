package y.f.c;

import y.f.c.ax;
import y.f.c.v;

public abstract class a implements v {
   protected double a = 20.0D;
   protected double b = 60.0D;
   protected double c = 5.0D;
   protected double d = 0.0D;
   protected y.c.A e;
   protected Object f;
   protected y.f.X g;
   protected y.c.A h;
   public static boolean i;

   public void a(double var1) {
      this.c = var1;
   }

   public void b(double var1) {
      this.d = var1;
   }

   public double a() {
      return this.c;
   }

   public double b() {
      return this.d;
   }

   public void c(double var1) {
      this.a = var1;
   }

   public void d(double var1) {
      this.b = var1;
   }

   public void a(y.c.A var1) {
      this.e = var1;
   }

   public double c() {
      return this.a;
   }

   public double d() {
      return this.b;
   }

   public void a(y.f.X var1, y.c.y[] var2) {
      boolean var5 = i;
      y.c.x[] var3 = new y.c.x[var2.length];
      int var4 = 0;

      while(true) {
         if(var4 < var2.length) {
            var3[var4] = var2[var4].a();
            ++var4;
            if(var5) {
               break;
            }

            if(!var5) {
               continue;
            }
         }

         this.a(var1, var3);
         break;
      }

   }

   public void a(y.f.X var1, y.c.x[] var2) {
      boolean var15 = i;
      double[] var3 = new double[var2.length];
      double var4 = 0.0D;
      int var6 = 0;

      while(var6 < var2.length) {
         double var7 = 0.0D;
         y.c.x var9 = var2[var6];
         var9.i();

         while(true) {
            if(var9.f()) {
               var7 = Math.max(var7, var1.q(var9.e()));
               var9.g();
               if(var15) {
                  break;
               }

               if(!var15) {
                  continue;
               }
            }

            var3[var6] = var7;
            break;
         }

         var9.i();

         double var10;
         while(true) {
            if(var9.f()) {
               var10 = (var3[var6] - var1.q(var9.e())) / 2.0D;
               var1.b(var9.e(), new y.d.t(var1.m(var9.e()), var4 + var10));
               var9.g();
               if(var15) {
                  break;
               }

               if(!var15) {
                  continue;
               }
            }

            var10 = this.d();
            break;
         }

         Object var10000 = this.f;

         label57:
         while(var10000 != null) {
            y.c.c var12 = var1.c(this.f);
            if(var12 == null) {
               break;
            }

            var9.i();

            while(true) {
               if(!var9.f()) {
                  break label57;
               }

               y.c.q var13 = var9.e();
               var10000 = var13.l();
               if(var15) {
                  break;
               }

               Object var14 = var10000;

               label52: {
                  while(((y.c.e)var14).f()) {
                     var10 = Math.max(var10, var12.c(((y.c.e)var14).a()));
                     ((y.c.e)var14).g();
                     if(var15) {
                        break label52;
                     }

                     if(var15) {
                        break;
                     }
                  }

                  var9.g();
               }

               if(var15) {
                  break label57;
               }
            }
         }

         var4 += var3[var6] + var10;
         var9.i();
         ++var6;
         if(var15) {
            break;
         }
      }

   }

   public void a(y.f.X var1, y.c.y[] var2, y.c.c var3) {
      this.g = var1;
      this.a(var2);
      this.a(var2, var3);
      this.e();
   }

   protected abstract void a(y.c.y[] var1, y.c.c var2);

   public double a(y.c.q var1) {
      return this.g.m(var1) - this.c(var1);
   }

   public double b(y.c.q var1) {
      return this.g.m(var1) + this.g.p(var1) + this.d(var1);
   }

   public double c(y.c.q var1) {
      if(this.e.b(var1) != null) {
         return 0.0D;
      } else {
         y.c.c var2 = this.g.c(v.j);
         return var2 != null?var2.c(var1):0.0D;
      }
   }

   public double d(y.c.q var1) {
      if(this.e.b(var1) != null) {
         return 0.0D;
      } else {
         y.c.c var2 = this.g.c(v.e_);
         return var2 != null?var2.c(var1):0.0D;
      }
   }

   public double e(y.c.q var1) {
      return this.g.p(var1) / 2.0D + this.c(var1);
   }

   public double f(y.c.q var1) {
      return this.g.p(var1) / 2.0D + this.d(var1);
   }

   protected void a(y.c.y[] var1) {
      y.c.c var2;
      y.c.c var3;
      boolean var11;
      label58: {
         var11 = i;
         var2 = this.g.c(v.e_);
         var3 = this.g.c(v.j);
         y.c.c var4 = this.g.c(v.n);
         this.h = y.g.M.a(new double[this.g.e()]);
         if(var4 == null) {
            ax var5 = new ax();
            var5.b(this.a());
            var5.a(this.c());
            var5.a(this.g, var1, this.e, this.h);
            if(!var11) {
               break label58;
            }
         }

         y.c.x var12 = this.g.o();

         while(var12.f()) {
            y.c.q var6 = var12.e();
            this.h.a(var6, var4.c(var6));
            var12.g();
            if(var11) {
               break;
            }
         }
      }

      int var13 = 0;

      while(var13 < var1.length) {
         label40: {
            y.c.x var14 = var1[var13].a();
            if(var14.f()) {
               y.c.q var7 = var14.e();
               var14.g();

               while(var14.f()) {
                  y.c.q var8 = var14.e();
                  double var9 = this.h.c(var7);
                  if(var11) {
                     break label40;
                  }

                  if(var2 != null) {
                     var9 += var2.c(var7);
                  }

                  if(var3 != null) {
                     var9 += var3.c(var8);
                  }

                  this.h.a(var7, var9);
                  var7 = var8;
                  var14.g();
                  if(var11) {
                     break;
                  }
               }
            }

            ++var13;
         }

         if(var11) {
            break;
         }
      }

   }

   protected double g(y.c.q var1) {
      return this.h.c(var1);
   }

   protected void e() {
      this.h = null;
   }
}
