package y.f.c;

import y.f.c.a;
import y.f.c.ab;

public class aa extends a {
   double[] o;
   ab[] p;
   int[] q;
   int[] r;
   double[] s;
   int t;
   int u;
   double v;
   int w = 5;
   int x = 10;
   y.c.q[][] y;
   y.c.D z;

   protected void a(y.c.y[] var1, y.c.c var2) {
      boolean var9 = a.i;
      y.g.o.a(this, "Polyline Drawer");
      this.y = new y.c.q[var1.length][];
      this.q = new int[this.g.f()];
      this.o = new double[this.g.f()];
      this.p = new ab[this.g.f()];
      this.s = new double[this.g.f()];
      this.r = new int[this.g.f()];
      int var3 = 0;

      while(true) {
         if(var3 < var1.length) {
            y.c.y var4 = var1[var3];
            y.c.q[] var5 = this.y[var3] = new y.c.q[var4.size()];
            int var6 = 0;
            if(var9) {
               break;
            }

            y.c.C var7 = var4.m();

            label27: {
               while(var7.f()) {
                  y.c.q var8 = (y.c.q)var7.d();
                  this.q[var8.d()] = var6;
                  var5[var6] = var8;
                  var7.g();
                  ++var6;
                  if(var9) {
                     break label27;
                  }

                  if(var9) {
                     break;
                  }
               }

               ++var3;
            }

            if(!var9) {
               continue;
            }
         }

         this.f();
         this.g();
         this.k();
         break;
      }

   }

   void f() {
      boolean var17 = a.i;
      double var1 = 0.0D;
      double[] var3 = new double[this.y.length];
      double[] var4 = new double[this.y.length];
      int var8 = 0;

      y.c.q[] var7;
      double var11;
      int var13;
      double var10000;
      while(true) {
         if(var8 < this.y.length) {
            double var9 = 0.0D;
            var10000 = 0.0D;
            if(var17) {
               break;
            }

            var11 = 0.0D;
            var7 = this.y[var8];
            var13 = 0;

            label51: {
               while(var13 < var7.length) {
                  var9 += this.g.r(var7[var13]).a();
                  var11 = Math.max(var11, this.g.r(var7[var13]).b());
                  ++var13;
                  if(var17) {
                     break label51;
                  }

                  if(var17) {
                     break;
                  }
               }

               var9 += (double)(var7.length - 1) * this.a;
               var1 = Math.max(var1, var9);
               var4[var8] = var11;
               var3[var8] = var9;
               ++var8;
            }

            if(!var17) {
               continue;
            }
         }

         var10000 = 0.0D;
         break;
      }

      double var18 = var10000;
      int var10 = 0;

      while(var10 < this.y.length) {
         var11 = (var1 - var3[var10]) / 2.0D;
         var7 = this.y[var10];
         var13 = 0;

         while(true) {
            if(var13 < var7.length) {
               y.c.q var14 = var7[var13];
               double var15 = var18 + (var4[var10] - this.g.r(var14).b()) / 2.0D;
               this.g.b(var14, new y.d.t(var11, var15));
               var11 += this.g.r(var14).a() + this.a;
               ++var13;
               if(var17) {
                  break;
               }

               if(!var17) {
                  continue;
               }
            }

            var18 += var4[var10] + this.b;
            ++var10;
            break;
         }

         if(var17) {
            break;
         }
      }

   }

   void g() {
      boolean var6 = a.i;
      double var1 = Double.MAX_VALUE;
      double var3 = this.h();
      if(var3 >= var1) {
         var1 = var3 + 1.0D;
      }

      int var5 = 0;

      while(var5 < this.w && var3 < var1) {
         var1 = var3;
         this.i();
         this.j();
         var3 = this.h();
         ++var5;
         if(var6) {
            break;
         }
      }

   }

   double h() {
      boolean var12 = a.i;
      double var1 = 0.0D;
      y.c.x var3 = this.g.o();

      double var10000;
      while(true) {
         if(var3.f()) {
            y.c.q var4 = var3.e();
            double var5 = this.g.l(var4).a();
            double var7 = 0.0D;
            var10000 = 0.0D;
            if(var12) {
               break;
            }

            double var9 = 0.0D;
            y.c.x var11 = var4.n();

            label31: {
               while(var11.f()) {
                  var7 += this.g.l(var11.e()).a() - var5;
                  var11.g();
                  if(var12) {
                     break label31;
                  }

                  if(var12) {
                     break;
                  }
               }

               var11 = var4.o();
            }

            label41: {
               while(var11.f()) {
                  var9 += this.g.l(var11.e()).a() - var5;
                  var11.g();
                  if(var12) {
                     break label41;
                  }

                  if(var12) {
                     break;
                  }
               }

               var1 += Math.abs(var7 + var9);
               var3.g();
            }

            if(!var12) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   void i() {
      boolean var6 = a.i;
      int var1 = 1;

      label43:
      while(true) {
         int var10000 = var1;
         int var10001 = this.y.length;

         label41:
         while(var10000 < var10001) {
            y.c.q[] var3 = this.y[var1];
            this.b(var3);
            this.d(var3);

            while(true) {
               boolean var2 = false;
               y.c.C var4 = this.z.m();

               while(var4.f()) {
                  ab var5 = (ab)var4.d();
                  var10000 = this.a(var5, var3);
                  var10001 = 1;
                  if(var6) {
                     continue label41;
                  }

                  if(var10000 == 1) {
                     var2 = true;
                  }

                  var4.g();
                  if(var6) {
                     break;
                  }
               }

               while(!var2) {
                  this.a(var3);
                  ++var1;
                  if(!var6) {
                     if(var6) {
                        return;
                     }
                     continue label43;
                  }
               }
            }
         }

         return;
      }
   }

   void j() {
      boolean var6 = a.i;
      int var1 = this.y.length - 2;

      label44:
      while(var1 >= 0) {
         y.c.q[] var3 = this.y[var1];
         this.c(var3);
         this.d(var3);

         label42:
         while(true) {
            boolean var2 = false;
            y.c.C var4 = this.z.m();

            while(true) {
               boolean var10000;
               if(var4.f()) {
                  ab var5 = (ab)var4.d();
                  var10000 = this.a(var5, var3);
                  if(!var6) {
                     if(var10000) {
                        var2 = true;
                     }

                     var4.g();
                     if(!var6) {
                        continue;
                     }

                     var10000 = var2;
                  }
               } else {
                  var10000 = var2;
               }

               while(true) {
                  if(var10000) {
                     continue label42;
                  }

                  this.a(var3);
                  --var1;
                  if(!var6) {
                     if(var6) {
                        return;
                     }
                     continue label44;
                  }

                  var10000 = var2;
               }
            }
         }
      }

   }

   void a(y.c.q[] var1) {
      boolean var11 = a.i;
      y.c.C var2 = this.z.m();

      while(var2.f()) {
         ab var6;
         double var9;
         label22: {
            var6 = (ab)var2.d();
            double var7 = var6.a();
            var9 = var7;
            y.c.q var3;
            y.c.q var4;
            ab var5;
            if(var7 < 0.0D) {
               var3 = (y.c.q)var6.a.f();
               if(this.q[var3.d()] <= 0) {
                  break label22;
               }

               var4 = var1[this.q[var3.d()] - 1];
               var5 = this.p[var4.d()];
               var9 = Math.max(var7, -(this.a(var4, var3) - this.a));
               if(!var11) {
                  break label22;
               }
            }

            var4 = (y.c.q)var6.a.i();
            if(this.q[var4.d()] < var1.length - 1) {
               var3 = var1[this.q[var4.d()] + 1];
               var5 = this.p[var3.d()];
               var9 = Math.min(var7, this.a(var4, var3) - this.a);
            }
         }

         var6.a(var9);
         var2.g();
         if(var11) {
            break;
         }
      }

   }

   void b(y.c.q[] var1) {
      boolean var9 = a.i;
      int var2 = 0;

      while(var2 < var1.length) {
         label33: {
            label41: {
               y.c.q var3 = var1[var2];
               if(var3.b() == 0) {
                  this.o[var3.d()] = 0.0D;
                  if(!var9) {
                     break label41;
                  }
               }

               double var4 = this.g.l(var3).a();
               double var6 = 0.0D;
               y.c.x var8 = var3.n();

               while(var8.f()) {
                  var6 += this.g.l(var8.e()).a() - var4;
                  var8.g();
                  if(var9) {
                     break label33;
                  }

                  if(var9) {
                     break;
                  }
               }

               this.o[var3.d()] = var6 / (double)var3.b();
            }

            ++var2;
         }

         if(var9) {
            break;
         }
      }

   }

   void c(y.c.q[] var1) {
      boolean var9 = a.i;
      int var2 = 0;

      while(var2 < var1.length) {
         label33: {
            label41: {
               y.c.q var3 = var1[var2];
               if(var3.c() == 0) {
                  this.o[var3.d()] = 0.0D;
                  if(!var9) {
                     break label41;
                  }
               }

               double var4 = this.g.l(var3).a();
               double var6 = 0.0D;
               y.c.x var8 = var3.o();

               while(var8.f()) {
                  var6 += this.g.l(var8.e()).a() - var4;
                  var8.g();
                  if(var9) {
                     break label33;
                  }

                  if(var9) {
                     break;
                  }
               }

               this.o[var3.d()] = var6 / (double)var3.c();
            }

            ++var2;
         }

         if(var9) {
            break;
         }
      }

   }

   void d(y.c.q[] var1) {
      boolean var5 = a.i;
      this.z = new y.c.D();
      int var2 = 0;

      while(var2 < var1.length) {
         y.c.q var3 = var1[var2];
         ab var4 = new ab(this, var3);
         this.p[var3.d()] = var4;
         this.z.b((Object)var4);
         ++var2;
         if(var5) {
            break;
         }
      }

   }

   boolean a(ab var1, y.c.q[] var2) {
      boolean var9 = a.i;
      y.c.q var4 = (y.c.q)var1.a.i();
      boolean var6 = false;
      if(this.q[var4.d()] < var2.length - 1) {
         y.c.q var3 = var2[this.q[var4.d()] + 1];
         ab var5 = this.p[var3.d()];
         if(this.a(var4, var3) < this.a && var1.a() >= var5.a()) {
            var6 = true;
            y.c.C var7 = var5.a.m();

            while(var7.f()) {
               y.c.q var8 = (y.c.q)var7.d();
               var1.a.b((Object)var8);
               this.p[var8.d()] = var1;
               var7.g();
               if(var9) {
                  return var6;
               }

               if(var9) {
                  break;
               }
            }

            this.z.remove(var5);
         }
      }

      return var6;
   }

   double a(y.c.q var1, y.c.q var2) {
      double var3 = this.g.o(var1).a() + this.g.r(var1).a();
      double var5 = this.g.o(var2).a();
      return var5 - var3;
   }

   void k() {
      boolean var6 = a.i;
      this.l();
      double var1 = Double.MAX_VALUE;
      double var3 = this.h();
      if(var3 >= var1) {
         var1 = var3 + 1.0D;
      }

      int var5 = 0;

      while(var5 < this.x) {
         this.m();
         var3 = this.h();
         ++var5;
         if(var6) {
            break;
         }
      }

   }

   void l() {
      boolean var2 = a.i;
      this.t = 50;
      this.u = 10;
      this.v = 0.5D;
      int var1 = this.g.f() - 1;

      while(var1 >= 0) {
         this.r[var1] = this.t;
         this.s[var1] = 0.0D;
         --var1;
         if(var2) {
            break;
         }
      }

   }

   void m() {
      boolean var13 = a.i;
      int var1 = 0;

      do {
         int var10000 = var1;

         label60:
         while(true) {
            if(var10000 >= this.y.length) {
               return;
            }

            y.c.q[] var2 = this.y[var1];
            int var3 = 0;

            while(true) {
               if(var3 >= var2.length) {
                  break label60;
               }

               y.c.q var4 = var2[var3];
               double var5 = this.h(var4);
               double var7 = var5;
               int var11 = this.r[var4.d()];
               double var14;
               var10000 = (var14 = var5 - 0.0D) == 0.0D?0:(var14 < 0.0D?-1:1);
               if(var13) {
                  break;
               }

               label42: {
                  if(var10000 < 0) {
                     if(this.q[var4.d()] <= 0) {
                        break label42;
                     }

                     y.c.q var9 = var2[this.q[var4.d()] - 1];
                     var7 = Math.max(var5, -(this.a(var9, var4) - this.a));
                     if(!var13) {
                        break label42;
                     }
                  }

                  if(this.q[var4.d()] < var2.length - 1) {
                     y.c.q var10 = var2[this.q[var4.d()] + 1];
                     var7 = Math.min(var5, this.a(var4, var10) - this.a);
                  }
               }

               int var12;
               label70: {
                  if(var7 == 0.0D || var7 * this.s[var4.d()] < 0.0D) {
                     var12 = (int)((1.0D - this.v) * (double)var11);
                     if(!var13) {
                        break label70;
                     }
                  }

                  var12 = (int)((1.0D + this.v) * (double)var11);
               }

               label55: {
                  if(var12 < 0) {
                     var12 = 0;
                     if(!var13) {
                        break label55;
                     }
                  }

                  if(var12 > 100) {
                     var12 = 100;
                  }
               }

               this.t += (var12 - var11) / this.g.f();
               this.g.b(var4, this.g.o(var4).b(var7, 0.0D));
               this.s[var4.d()] = var7;
               this.r[var4.d()] = var12;
               ++var3;
               if(var13) {
                  break label60;
               }
            }
         }

         ++var1;
      } while(!var13);

   }

   double h(y.c.q var1) {
      boolean var7 = a.i;
      double var2 = 0.0D;
      double var4 = this.g.l(var1).a();
      if(var1.a() > 0) {
         y.c.x var6 = var1.m();

         while(var6.f()) {
            var2 += this.g.l(var6.e()).a() - var4;
            var6.g();
            if(var7) {
               return var2;
            }

            if(var7) {
               break;
            }
         }

         var2 /= (double)var1.a();
      }

      return var2;
   }
}
