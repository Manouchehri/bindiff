package y.f.a;

import java.util.HashMap;
import y.f.X;
import y.f.ae;
import y.f.am;
import y.f.a.A;
import y.f.a.B;
import y.f.a.C;
import y.f.a.E;
import y.f.a.F;
import y.f.a.f;
import y.g.M;

class z extends y.f.c {
   private int n = 10;
   private int o = 10;
   private int p = 1;
   private X q;
   private HashMap r;
   private y.c.c s;
   private y.c.c t;
   private y.c.c u;
   private byte v = 0;
   private byte w = 1;

   public void a(int var1) {
      this.n = var1;
   }

   public void b(int var1) {
      this.o = var1;
   }

   private y.c.D a(y.c.q var1) {
      return this.t == null?null:(y.c.D)this.t.b(var1);
   }

   private y.c.D a(y.c.d var1) {
      return this.u == null?null:(y.c.D)this.u.b(var1);
   }

   private boolean b(y.c.q var1) {
      return this.s == null || this.s.a(var1) == 0;
   }

   private boolean c(y.c.q var1) {
      return this.s != null && this.s.a(var1) == 1;
   }

   public void a(X var1) {
      int var13 = f.u;
      this.r = new HashMap();
      this.q = var1;
      this.s = var1.c("NODE_SHAPE_DP");
      this.t = var1.c("NODE_TO_LABEL_BOXES");
      this.u = var1.c("EDGE_TO_MULTI_EDGES");
      this.o = Math.max(1, this.o);
      this.p = Math.max(1, this.p);
      y.c.q var2 = this.a();
      y.c.f var3 = y.a.A.a((y.c.i)var1, (y.c.q)var2);
      y.c.e var4 = var3.a();

      while(var4.f()) {
         y.c.d var5 = var4.a();
         ae.a(var1.g(var5));
         var4.g();
         if(var13 != 0) {
            break;
         }
      }

      y.c.y var14 = new y.c.y(var1.o());
      y.c.A var15 = var1.t();
      this.b(var2, var15);
      y.c.A var6 = var1.t();
      this.a(var2, var6);
      y.c.A var7 = var1.t();
      this.a(var7);
      var14.sort(new F(var15, var6, var7));
      y.c.D var8 = this.n();
      y.c.A var9 = var1.t();
      y.c.x var10 = var14.a();

      while(var10.f()) {
         y.c.q var11 = var10.e();
         if(var11 != var2) {
            y.c.d var12 = this.f(var11);
            this.a(var12, var9, var8);
         }

         var10.g();
         if(var13 != 0) {
            break;
         }
      }

      y.c.e var16 = var3.a();

      while(true) {
         if(var16.f()) {
            y.c.d var17 = var16.a();
            var1.c(var17);
            ae.a(var1.g(var17));
            var16.g();
            if(var13 != 0) {
               break;
            }

            if(var13 == 0) {
               continue;
            }
         }

         var1.a((y.c.A)var9);
         var1.a((y.c.A)var7);
         var1.a((y.c.A)var15);
         var1.a((y.c.A)var6);
         break;
      }

      if(y.c.i.g) {
         ++var13;
         f.u = var13;
      }

   }

   private void a(y.c.A var1) {
      int var14 = f.u;
      y.c.x var2 = this.q.o();

      while(var2.f()) {
         label79: {
            y.c.x var16;
            label78: {
               y.c.q var3 = var2.e();
               if(var3.c() > 4) {
                  y.d.t var4 = this.q.l(var3);
                  y.d.t var5 = var3.b() > 0?this.q.l(var3.g().c()):null;
                  double var6 = var5 == null?3.141592653589793D:b(var4, var5);
                  A var8 = new A(this, var4, var6);
                  y.c.f var9 = new y.c.f(var3.l());
                  var9.sort(var8);
                  y.c.y var10 = new y.c.y();
                  y.c.e var11 = var9.a();

                  while(var11.f()) {
                     var10.add(var11.a().d());
                     var11.g();
                     if(var14 != 0) {
                        break label79;
                     }

                     if(var14 != 0) {
                        break;
                     }
                  }

                  int var15 = 1;

                  label67:
                  do {
                     boolean var10000 = var10.isEmpty();

                     label64:
                     while(true) {
                        if(var10000) {
                           break label67;
                        }

                        boolean var12 = true;
                        var16 = var10.a();
                        if(var14 != 0) {
                           break label78;
                        }

                        y.c.x var13 = var16;

                        while(true) {
                           if(!var13.f()) {
                              break label64;
                           }

                           var10000 = var12;
                           if(var14 != 0) {
                              break;
                           }

                           if(var12) {
                              var1.a(var10.b(var13), var15);
                           }

                           var12 = !var12;
                           var13.g();
                           if(var14 != 0) {
                              break label64;
                           }
                        }
                     }

                     ++var15;
                  } while(var14 == 0);
               }

               var16 = var2;
            }

            var16.g();
         }

         if(var14 != 0) {
            break;
         }
      }

   }

   private static double b(y.d.t var0, y.d.t var1) {
      double var2 = var1.a - var0.a;
      double var4 = var1.b - var0.b;
      return Math.atan2(var4, var2);
   }

   private y.d.t a(y.d.m var1) {
      return y.d.t.c(var1.c(), var1.d());
   }

   private void a(y.c.d var1, y.c.A var2, y.c.D var3) {
      int var12 = f.u;
      y.c.q var4 = var1.d();
      y.c.A var5 = M.a(new boolean[this.q.f()]);
      y.c.y var6 = this.e(var4);
      y.c.x var7 = var6.a();

      while(var7.f()) {
         var5.a(var7.e(), true);
         var7.g();
         if(var12 != 0) {
            break;
         }
      }

      y.d.m var13 = new y.d.m(this.q.q(var1), this.q.p(var1));
      y.d.y var8 = this.a(var13, var6, (double)this.o);
      y.c.D[] var9 = this.a(var5, var8, var3);

      while(var13.g() > 10.0D) {
         this.a(var6.a(), var2);
         y.d.t var10 = var13.c();
         y.d.t var11 = this.a(var13);
         ae.a(this.q, var6.a(), var11.a() - var10.a(), var11.b() - var10.b());
         if(this.a(var1, var9)) {
            var13 = new y.d.m(this.a(var13), var13.d());
            if(var12 == 0) {
               continue;
            }
         }

         var13 = new y.d.m(var13.c(), this.a(var13));
         this.b(var6.a(), var2);
         if(var12 != 0) {
            break;
         }
      }

   }

   private y.c.D[] a(y.c.A var1, y.d.y var2, y.c.D var3) {
      int var12 = f.u;
      y.c.D[] var4 = new y.c.D[2];
      var4[this.v] = new y.c.D();
      var4[this.w] = new y.c.D();
      y.c.C var5 = var3.m();

      while(var5.f()) {
         label115: {
            B var6 = (B)var5.d();
            boolean var8;
            y.d.y var10;
            if(var6.e()) {
               y.c.q var7 = (y.c.q)var6.i();
               var8 = var1.d(var7);
               y.d.y var9;
               if(var8) {
                  var9 = this.q.s(var7);
                  var10 = a(var9, (double)this.o);
                  var6.a((y.d.o)var10);
                  var6.a(var9);
                  var6.a(var8);
                  if(!y.d.y.a(var10, var2)) {
                     break label115;
                  }

                  var4[this.v].add(var6);
                  var4[this.w].add(var6);
                  if(var12 == 0) {
                     break label115;
                  }
               }

               if(var6.c()) {
                  var9 = this.q.s(var7);
                  var6.a((y.d.o)var9);
                  var6.a(var9);
                  var6.a(false);
                  if(!y.d.y.a(var9, var2)) {
                     break label115;
                  }

                  var4[this.w].add(var6);
                  if(var12 == 0) {
                     break label115;
                  }
               }

               if(!y.d.y.a(var6.h(), var2)) {
                  break label115;
               }

               var4[this.w].add(var6);
               if(var12 == 0) {
                  break label115;
               }
            }

            if(var6.g()) {
               boolean var13 = var1.d(var6.i());
               if(var13 || var6.c()) {
                  y.c.q var15 = (y.c.q)var6.i();
                  y.d.t var16 = this.q.l(var15);
                  var10 = var6.d();
                  y.d.y var11 = new y.d.y(var16.a() + var10.c(), var16.b() + var10.d(), var10.a(), var10.b());
                  var6.a((y.d.o)var11);
                  var6.a(var13);
                  if(!y.d.y.a(var11, var2)) {
                     break label115;
                  }

                  if(var13) {
                     var4[this.v].add(var6);
                  }

                  var4[this.w].add(var6);
                  if(var12 == 0) {
                     break label115;
                  }
               }

               if(!y.d.y.a(var6.h(), var2)) {
                  break label115;
               }

               var4[this.w].add(var6);
               if(var12 == 0) {
                  break label115;
               }
            }

            y.c.d var14 = (y.c.d)var6.i();
            var8 = var1.d(var14.c()) || var1.d(var14.d());
            if(var8 || var6.c()) {
               y.d.m var17 = var6.a()?var6.b().a(this.q):this.b(var14);
               var6.a((y.d.o)var17);
               var6.a(var8);
               if(!y.d.y.a(var17.h(), var2)) {
                  break label115;
               }

               if(var8) {
                  var4[this.v].add(var6);
               }

               var4[this.w].add(var6);
               if(var12 == 0) {
                  break label115;
               }
            }

            if(y.d.y.a(var6.h(), var2)) {
               var4[this.w].add(var6);
            }
         }

         var5.g();
         if(var12 != 0) {
            break;
         }
      }

      return var4;
   }

   private y.d.y a(y.d.m var1, y.c.y var2, double var3) {
      int var20 = f.u;
      double var5 = var1.d().a() - var1.c().a();
      double var7 = var1.d().b() - var1.c().b();
      double var9 = Double.MAX_VALUE;
      double var11 = Double.MAX_VALUE;
      double var13 = -1.7976931348623157E308D;
      double var15 = -1.7976931348623157E308D;
      y.c.x var17 = var2.a();

      while(var17.f()) {
         am var19;
         label25: {
            y.c.q var18 = var17.e();
            var19 = this.q.h(var18);
            if(var5 > 0.0D) {
               var9 = Math.min(var9, var19.getX());
               var13 = Math.max(var13, var19.getX() + var19.getWidth() + var5);
               if(var20 == 0) {
                  break label25;
               }
            }

            var9 = Math.min(var9, var19.getX() + var5);
            var13 = Math.max(var13, var19.getX() + var19.getWidth());
         }

         label20: {
            if(var7 > 0.0D) {
               var11 = Math.min(var11, var19.getY());
               var15 = Math.max(var15, var19.getY() + var19.getHeight() + var7);
               if(var20 == 0) {
                  break label20;
               }
            }

            var11 = Math.min(var11, var19.getY() + var7);
            var15 = Math.max(var15, var19.getY() + var19.getHeight());
         }

         var17.g();
         if(var20 != 0) {
            break;
         }
      }

      return new y.d.y(var9 - var3, var11 - var3, var13 - var9 + 2.0D * var3, var15 - var11 + 2.0D * var3);
   }

   private void a(y.c.x var1, y.c.A var2) {
      int var4 = f.u;

      while(var1.f()) {
         y.c.q var3 = var1.e();
         var2.a(var3, this.q.l(var3));
         var1.g();
         if(var4 != 0) {
            break;
         }
      }

   }

   private void b(y.c.x var1, y.c.A var2) {
      int var4 = f.u;

      while(var1.f()) {
         y.c.q var3 = var1.e();
         this.q.a(var3, (y.d.t)var2.b(var3));
         var1.g();
         if(var4 != 0) {
            break;
         }
      }

   }

   private double d(y.c.q var1) {
      return Math.max(this.q.p(var1), this.q.q(var1)) * 0.5D;
   }

   private boolean a(y.c.d var1, y.c.D[] var2) {
      int var8 = f.u;
      double var3 = y.d.t.a(this.q.p(var1), this.q.q(var1));
      if(var3 < (double)this.n) {
         return false;
      } else {
         y.c.D var5 = this.a(var1);
         int var10000;
         if(var5 != null) {
            y.c.C var6 = var5.m();

            while(var6.f()) {
               C var7 = (C)var6.d();
               var3 = var7.a(this.q).g();
               double var9;
               var10000 = (var9 = var3 - (double)this.n) == 0.0D?0:(var9 < 0.0D?-1:1);
               if(var8 != 0) {
                  return var10000 == 0;
               }

               if(var10000 < 0) {
                  return false;
               }

               var6.g();
               if(var8 != 0) {
                  break;
               }
            }
         }

         var10000 = this.a(var2, var1);
         return var10000 == 0;
      }
   }

   private boolean a(B var1, B var2) {
      y.c.q var3 = (y.c.q)var1.i();
      y.c.q var4 = (y.c.q)var2.i();
      if(!y.d.y.a(var1.h(), var2.h())) {
         return false;
      } else if(this.b(var3) && this.b(var4)) {
         return true;
      } else {
         double var7;
         if(this.c(var3) && this.c(var4)) {
            double var15 = Math.max(var1.h().a(), var1.h().b()) * 0.5D;
            var7 = Math.max(var2.h().a(), var2.h().b()) * 0.5D;
            return y.d.t.a(this.q.l(var3), this.q.l(var4)) - var15 - var7 < 0.0D;
         } else {
            B var5 = this.b(var3)?var1:var2;
            B var6 = this.c(var3)?var1:var2;
            var7 = var5.h().a();
            double var9 = var5.h().b();
            double var11 = Math.sqrt(var9 * var9 + var7 * var7) * 0.5D;
            double var13 = Math.max(var6.h().a(), var6.h().b()) * 0.5D;
            return y.d.t.a(this.q.l(var3), this.q.l(var4)) - var13 - var11 < 0.0D;
         }
      }
   }

   private boolean a(y.c.q var1, y.d.m var2) {
      if(!y.d.y.a(this.q.s(var1), var2.h())) {
         return false;
      } else {
         double var3 = 0.0D;
         if(this.c(var1)) {
            var3 = a(var2, this.q.l(var1)) - this.d(var1) - (double)this.p;
            if(f.u == 0) {
               return var3 < 0.0D;
            }
         }

         double var5 = y.d.t.a(this.q.l(var1), this.q.o(var1));
         var3 = a(var2, this.q.l(var1)) - var5 - (double)this.p;
         return var3 < 0.0D;
      }
   }

   private static y.d.y a(y.d.y var0, double var1) {
      y.d.t var3 = var0.e();
      return new y.d.y(var3.a() - var1, var3.b() - var1, var0.a() + 2.0D * var1, var0.b() + 2.0D * var1);
   }

   private boolean b(B var1, B var2) {
      y.c.q var3 = (y.c.q)var1.i();
      y.d.y var4 = var2.h();
      if(!y.d.y.a(var1.d(), var4)) {
         return false;
      } else if(this.b(var3)) {
         return true;
      } else {
         double var5 = Math.sqrt(var4.b() * var4.b() + var4.a() * var4.a()) * 0.5D;
         double var7 = Math.max(var1.d().a(), var1.d().b()) * 0.5D;
         y.d.t var9 = new y.d.t(var4.c() + var4.a() * 0.5D, var4.d() + var4.b() * 0.5D);
         return y.d.t.a(this.q.l(var3), var9) - var7 - var5 < 0.0D;
      }
   }

   private boolean c(B var1, B var2) {
      int var3 = var1.c()?1:0;
      var3 += var2.c()?1:0;
      return var3 == 1;
   }

   private static double a(y.d.m var0, y.d.t var1) {
      double var2 = var0.c().a;
      double var4 = var0.d().a;
      double var6 = var0.c().b;
      double var8 = var0.d().b;
      double var10 = var1.a();
      double var12 = var1.b();
      var4 -= var2;
      var8 -= var6;
      var10 -= var2;
      var12 -= var6;
      double var14 = 0.0D;
      double var16 = var10 * var4 + var12 * var8;
      if(var16 > 0.0D) {
         label16: {
            var10 = var4 - var10;
            var12 = var8 - var12;
            var16 = var10 * var4 + var12 * var8;
            if(var16 <= 0.0D) {
               var14 = 0.0D;
               if(f.u == 0) {
                  break label16;
               }
            }

            var14 = var16 * var16 / (var4 * var4 + var8 * var8);
         }
      }

      double var18 = var10 * var10 + var12 * var12 - var14;
      return var18 < 0.0D?0.0D:Math.sqrt(var18);
   }

   private boolean a(y.c.D[] var1, y.c.d var2) {
      int var17 = f.u;
      double var3 = Double.MAX_VALUE;
      double var5 = Double.MAX_VALUE;
      double var7 = -1.7976931348623157E308D;
      double var9 = -1.7976931348623157E308D;
      y.c.C var11 = var1[this.v].m();

      while(var11.f()) {
         label64: {
            B var12 = (B)var11.d();
            y.c.q var13;
            y.d.y var15;
            if(var12.e()) {
               var13 = (y.c.q)var12.i();
               y.d.y var14 = this.q.s(var13);
               var15 = a(var14, (double)this.o);
               var12.a(var14);
               var12.a((y.d.o)var15);
               var3 = Math.min(var3, var15.c());
               var5 = Math.min(var5, var15.d());
               var7 = Math.max(var7, var15.c() + var15.a());
               var9 = Math.max(var9, var15.d() + var15.b());
               if(var17 == 0) {
                  break label64;
               }
            }

            if(var12.f()) {
               y.c.d var20;
               y.d.m var23;
               label49: {
                  var20 = (y.c.d)var12.i();
                  if(var12.a()) {
                     var23 = var12.b().a(this.q);
                     if(var17 == 0) {
                        break label49;
                     }
                  }

                  var23 = this.b(var20);
               }

               var12.a((y.d.o)var23);
               if(var20 == var2 && !var12.a()) {
                  break label64;
               }

               var15 = var23.h();
               var3 = Math.min(var3, var15.c());
               var5 = Math.min(var5, var15.d());
               var7 = Math.max(var7, var15.c() + var15.a());
               var9 = Math.max(var9, var15.d() + var15.b());
               if(var17 == 0) {
                  break label64;
               }
            }

            var13 = (y.c.q)var12.i();
            y.d.t var24 = this.q.l(var13);
            var15 = var12.d();
            y.d.y var16 = new y.d.y(var24.a() + var15.c(), var24.b() + var15.d(), var15.a(), var15.b());
            var12.a((y.d.o)var16);
            var3 = Math.min(var3, var16.c());
            var5 = Math.min(var5, var16.d());
            var7 = Math.max(var7, var16.c() + var16.a());
            var9 = Math.max(var9, var16.d() + var16.b());
         }

         var11.g();
         if(var17 != 0) {
            break;
         }
      }

      y.d.y var18 = new y.d.y(var3, var5, var7 - var3, var9 - var5);
      y.c.D var19 = new y.c.D();
      y.c.C var21 = var1[this.w].m();

      while(var21.f()) {
         label32: {
            B var25 = (B)var21.d();
            if(var25.c()) {
               var19.add(var25);
               if(var17 == 0) {
                  break label32;
               }
            }

            if(y.d.y.a(var25.h(), var18)) {
               var19.add(var25);
            }
         }

         var21.g();
         if(var17 != 0) {
            break;
         }
      }

      E var22 = new E(this, false);
      y.d.f.a(var19, var22);
      return var22.a();
   }

   private y.c.D n() {
      int var10 = f.u;
      y.c.D var1 = new y.c.D();
      int var2 = 1;
      y.c.x var3 = this.q.o();

      y.c.D var5;
      z var10000;
      while(true) {
         if(var3.f()) {
            y.c.q var4 = var3.e();
            var1.add(new B(this, var4, var2++, this.q.s(var4), this.q.s(var4), (byte)0));
            var10000 = this;
            if(var10 != 0) {
               break;
            }

            label61: {
               var5 = this.a(var4);
               if(var5 != null && !var5.isEmpty()) {
                  y.d.t var6 = this.q.l(var4);
                  y.c.C var7 = var5.m();

                  while(var7.f()) {
                     y.d.y var8 = (y.d.y)var7.d();
                     y.d.y var9 = new y.d.y(var6.a() + var8.c(), var6.b() + var8.d(), var8.a(), var8.b());
                     var1.add(new B(this, var4, var2++, var9, var8, (byte)2));
                     var7.g();
                     if(var10 != 0) {
                        break label61;
                     }

                     if(var10 != 0) {
                        break;
                     }
                  }
               }

               var3.g();
            }

            if(var10 == 0) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      y.c.e var11 = var10000.q.p();

      while(var11.f()) {
         label41: {
            y.c.d var13 = var11.a();
            var1.add(new B(this, var13, var2++, this.b(var13), (byte)1));
            var5 = this.a(var13);
            if(var5 != null && !var5.isEmpty()) {
               y.c.C var14 = var5.m();

               while(var14.f()) {
                  C var15 = (C)var14.d();
                  y.d.m var16 = var15.a(this.q);
                  var1.add(new B(this, var13, var2++, var16, (byte)1, var15));
                  var14.g();
                  if(var10 != 0) {
                     break label41;
                  }

                  if(var10 != 0) {
                     break;
                  }
               }
            }

            var11.g();
         }

         if(var10 != 0) {
            break;
         }
      }

      E var12 = new E(this, true);
      y.d.f.a(var1, var12);
      return var1;
   }

   private y.d.m b(y.c.d var1) {
      return new y.d.m(this.q.p(var1), this.q.q(var1));
   }

   private y.c.y e(y.c.q var1) {
      y.c.y var2 = new y.c.y(var1);
      a(var1, var2);
      return var2;
   }

   private static void a(y.c.q var0, y.c.y var1) {
      int var4 = f.u;
      y.c.x var2 = var0.o();

      while(var2.f()) {
         y.c.q var3 = var2.e();
         var1.b(var3);
         a(var3, var1);
         var2.g();
         if(var4 != 0) {
            break;
         }
      }

   }

   private y.c.d f(y.c.q var1) {
      y.c.e var2 = var1.k();
      if(var2.k() > 1) {
         System.out.println("wrong tree structure: node " + var1 + " has multiple parents");
      }

      return var2.f()?var2.a():null;
   }

   public void a(y.c.q var1, y.c.A var2) {
      this.c(var1, var2);
   }

   private double c(y.c.q var1, y.c.A var2) {
      int var7 = f.u;
      double var3 = this.q.p(var1) * this.q.q(var1);
      y.c.d var5 = var1.f();

      while(true) {
         if(var5 != null) {
            y.c.q var6 = var5.d();
            var3 += this.c(var6, var2);
            var5 = var5.g();
            if(var7 != 0) {
               break;
            }

            if(var7 == 0) {
               continue;
            }
         }

         var2.a(var1, var3);
         break;
      }

      return var3;
   }

   public void b(y.c.q var1, y.c.A var2) {
      y.a.b.a(this.q, (y.c.y)(new y.c.y(var1)), var2);
   }

   public y.c.q a() {
      return y.a.A.d(this.q);
   }

   public boolean b(X var1) {
      return y.a.A.b(var1) && y.a.h.c(var1);
   }

   static X a(z var0) {
      return var0.q;
   }

   static double a(y.d.t var0, y.d.t var1) {
      return b(var0, var1);
   }

   static HashMap b(z var0) {
      return var0.r;
   }

   static boolean a(z var0, B var1, B var2) {
      return var0.b(var1, var2);
   }

   static boolean b(z var0, B var1, B var2) {
      return var0.c(var1, var2);
   }

   static boolean c(z var0, B var1, B var2) {
      return var0.a(var1, var2);
   }

   static boolean a(z var0, y.c.q var1, y.d.m var2) {
      return var0.a(var1, var2);
   }
}
