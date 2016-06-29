package y.f;

import y.f.X;
import y.f.a;
import y.f.ae;
import y.f.at;
import y.f.au;
import y.f.av;

public class as extends a {
   public static final Object a = "y.layout.ParallelEdgeLayouter.SCOPE_DPKEY";
   public static final Object b = "y.layout.ParallelEdgeLayouter.MASTER_EDGE_DPKEY";
   protected y.c.f c = new y.c.f();
   public y.c.h d;
   protected double e = 10.0D;
   boolean f = false;
   private boolean g = false;
   private double h = 20.0D;
   private double i = 0.1D;
   private boolean n = true;
   private boolean o = true;

   public void a(boolean var1) {
      this.o = var1;
   }

   public void a(double var1) {
      this.e = var1;
   }

   public void c(X var1) {
      this.d = var1.u();
      this.a((y.c.i)var1);
      this.a((X)var1);
      this.b(var1);
      this.a(var1, this.d);
      var1.a((y.c.h)this.d);
   }

   protected void a(X var1, y.c.h var2) {
      boolean var17 = X.j;
      y.c.e var3 = var1.p();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         if(var2.b(var4) != null) {
            label45: {
               y.c.f var5 = (y.c.f)var2.b(var4);
               double var6 = this.e;
               if(this.o && !this.g) {
                  y.d.y var9;
                  if(var4.e()) {
                     int var8 = var5.size() + 1;
                     var9 = var1.s(var4.c());
                     double var10 = Math.min(var9.a(), var9.b()) * 0.5D / (double)(var8 + 1);
                     ae.a(var1, var4, var5, Math.floor(Math.min(var10, this.e)), this.n, false, this.h, this.i);
                     if(!var17) {
                        break label45;
                     }
                  }

                  y.d.a var12;
                  if(var1.k(var4).isEmpty()) {
                     y.d.z var18 = new y.d.z(var1.p(var4), var1.q(var4));
                     var9 = var1.s(var4.c());
                     y.c.D var21 = a(var9, var18);
                     y.d.y var11 = var1.s(var4.d());
                     var21.a(a(var11, var18));
                     var21.sort(new av());
                     var12 = (y.d.a)var21.get(1);
                     y.d.a var13 = (y.d.a)var21.get(2);
                     y.d.a var14 = new y.d.a(var1.p(var4), var18);
                     double var15 = 2.0D * Math.min(a(var12, var14, var18), a(var13, var14, var18)) / (double)(var5.size() + 2);
                     ae.a(var1, var4, var5, Math.floor(Math.min(var15, var6)), this.n, this.g, this.h, this.i);
                     this.a(var5, var4.c(), var12, var13, var1);
                     this.a(var5, var4.d(), var12, var13, var1);
                     if(!var17) {
                        break label45;
                     }
                  }

                  y.d.v var19 = var1.l(var4);
                  y.d.z var20 = var19.a(0).i();
                  y.d.y var22 = var1.s(var4.c());
                  y.c.D var23 = a(var22, var20);
                  var12 = new y.d.a(var1.p(var4), var20);
                  double var24 = 2.0D * Math.min(a((y.d.a)var23.f(), var12, var20), a((y.d.a)var23.i(), var12, var20)) / (double)(var5.size() + 2);
                  var20 = var19.a(var19.h() - 2).i();
                  y.d.y var25 = var1.s(var4.d());
                  y.c.D var16 = a(var25, var20);
                  var24 = Math.min(var24, a((y.d.a)var16.f(), (y.d.a)var16.i(), var20) / (double)(var5.size() + 2));
                  ae.a(var1, var4, var5, Math.floor(Math.min(var24, var6)), this.n, this.g, this.h, this.i);
                  this.a(var5, var4.c(), (y.d.a)var23.f(), (y.d.a)var23.i(), var1);
                  this.a(var5, var4.d(), (y.d.a)var16.f(), (y.d.a)var16.i(), var1);
                  if(!var17) {
                     break label45;
                  }
               }

               if(var4.e()) {
                  ae.a(var1, var4, var5, Math.floor(var6), this.n, false, this.h, this.i);
                  if(!var17) {
                     break label45;
                  }
               }

               ae.a(var1, var4, var5, Math.floor(var6), this.n, this.g, this.h, this.i);
            }
         }

         var3.g();
         if(var17) {
            break;
         }
      }

   }

   private void a(y.c.f var1, y.c.q var2, y.d.a var3, y.d.a var4, X var5) {
      boolean var16 = X.j;
      y.d.y var6 = var5.s(var2);
      y.d.t var7 = var5.l(var2);
      boolean var8 = this.a(var6, var3, var4);
      y.c.e var9 = var1.a();

      while(var9.f()) {
         y.c.d var10;
         y.d.t var14;
         label30: {
            var10 = var9.a();
            y.d.v var11 = var5.l(var10);
            y.d.m var12 = var10.c() == var2?var11.a(0):var11.a(var11.h() - 2);
            y.d.a var13 = new y.d.a(var12.c(), var12.i());
            y.d.a var15;
            if(var8) {
               var15 = new y.d.a(var7, new y.d.z(1.0D, 0.0D));
               var14 = y.d.a.a(var15, var13);
               if(!var16) {
                  break label30;
               }
            }

            var15 = new y.d.a(var7, new y.d.z(0.0D, 1.0D));
            var14 = y.d.a.a(var15, var13);
         }

         label25: {
            if(var10.c() == var2) {
               var5.c(var10, var14);
               if(!var16) {
                  break label25;
               }
            }

            var5.d(var10, var14);
         }

         var9.g();
         if(var16) {
            break;
         }
      }

   }

   private boolean a(y.d.y var1, y.d.a var2, y.d.a var3) {
      double var4 = var1.d() + var1.b() * 0.5D;
      y.d.a var6 = new y.d.a(new y.d.t(0.0D, var4), new y.d.z(1.0D, 0.0D));
      y.d.t var7 = y.d.a.a(var6, var2);
      if(var7 == null) {
         return false;
      } else {
         y.d.t var8 = y.d.a.a(var6, var3);
         return a(var1, var7) && a(var1, var8);
      }
   }

   private static boolean a(y.d.y var0, y.d.t var1) {
      return var1.a() + 0.001D >= var0.c() && var1.a() - var0.c() <= var0.a() + 0.001D && var1.b() + 0.001D >= var0.d() && var1.b() - var0.d() <= var0.b() + 0.001D;
   }

   private static double a(y.d.a var0, y.d.a var1, y.d.z var2) {
      y.d.a var3 = new y.d.a(new y.d.t(0.0D, 0.0D), y.d.z.c(var2));
      y.d.t var4 = y.d.a.a(var0, var3);
      y.d.t var5 = y.d.a.a(var1, var3);
      return var4 != null && var5 != null?y.d.t.a(var4, var5):0.0D;
   }

   private static y.c.D a(y.d.y var0, y.d.z var1) {
      y.d.t var2 = new y.d.t(var0.c() + 0.5D * var0.a(), var0.d());
      y.d.t var3 = new y.d.t(var0.c(), var0.d() + 0.5D * var0.b());
      y.d.t var4 = new y.d.t(var0.c() + 0.5D * var0.a(), var0.d() + var0.b());
      y.d.t var5 = new y.d.t(var0.c() + var0.a(), var0.d() + 0.5D * var0.b());
      y.c.D var6 = new y.c.D();
      var6.add(new y.d.a(var2, var1));
      var6.add(new y.d.a(var3, var1));
      var6.add(new y.d.a(var5, var1));
      var6.add(new y.d.a(var4, var1));
      var6.sort(new av());
      y.c.D var7 = new y.c.D();
      var7.add(var6.f());
      var7.add(var6.i());
      return var7;
   }

   private y.c.f a(y.c.q var1) {
      boolean var5 = X.j;
      y.c.f var2 = new y.c.f(var1.l());
      y.c.e var3 = var1.k();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         if(!var4.e()) {
            var2.add(var4);
         }

         var3.g();
         if(var5) {
            break;
         }
      }

      return var2;
   }

   protected void a(y.c.i var1) {
      boolean var13 = X.j;
      y.c.A var2 = var1.t();
      y.c.c var3 = var1.c(a);
      y.c.c var4 = var1.c(b);
      y.c.x var5 = var1.o();

      while(true) {
         if(var5.f()) {
            y.c.q var6 = var5.e();
            if(var13) {
               break;
            }

            y.c.f var7 = this.f?new y.c.f(var6.l()):this.a(var6);
            y.c.c var10000 = var4;

            y.c.e var8;
            y.c.d var9;
            y.c.q var10;
            label75:
            while(true) {
               if(var10000 != null) {
                  var7.sort(new au(var4, (at)null));
               }

               var8 = var7.a();

               while(true) {
                  if(!var8.f()) {
                     break label75;
                  }

                  var9 = var8.a();
                  var10000 = var3;
                  if(var13) {
                     break;
                  }

                  if(var3 == null || var3.d(var9)) {
                     var10 = var9.a(var6);
                     y.c.d var11 = (y.c.d)var2.b(var10);
                     if(var11 != var9) {
                        label89: {
                           if(var11 == null) {
                              var2.a(var10, var9);
                              if(!var13) {
                                 break label89;
                              }
                           }

                           if(this.d.b(var11) == null) {
                              this.d.a(var11, new y.c.f());
                           }

                           y.c.f var12 = (y.c.f)this.d.b(var11);
                           var12.add(var9);
                           this.c.c(var9);
                           var1.d(var9);
                        }
                     }
                  }

                  var8.g();
                  if(var13) {
                     break label75;
                  }
               }
            }

            var8 = var6.j();

            label53: {
               while(var8.f()) {
                  var9 = var8.a();
                  var10 = var9.a(var6);
                  var2.a(var10, (Object)null);
                  var8.g();
                  if(var13) {
                     break label53;
                  }

                  if(var13) {
                     break;
                  }
               }

               var5.g();
            }

            if(!var13) {
               continue;
            }
         }

         var1.a(var2);
         break;
      }

   }

   private void b(y.c.i var1) {
      boolean var2 = X.j;

      while(!this.c.isEmpty()) {
         var1.e(this.c.d());
         if(var2) {
            break;
         }
      }

   }

   public void b(boolean var1) {
      this.n = var1;
   }
}
