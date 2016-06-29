package y.f.e;

import java.util.HashSet;
import y.f.X;
import y.f.aN;
import y.f.ac;
import y.f.ad;
import y.f.ae;
import y.f.ah;
import y.f.aj;
import y.f.as;
import y.f.e.A;
import y.f.e.B;
import y.f.e.a;
import y.f.e.d;
import y.f.e.i;
import y.f.e.k;
import y.f.e.l;
import y.f.e.r;
import y.f.e.t;
import y.f.e.u;
import y.f.e.v;
import y.f.e.w;
import y.f.e.x;
import y.f.e.y;
import y.f.e.z;
import y.f.e.a.J;
import y.f.e.a.am;
import y.f.e.a.ax;
import y.f.e.a.ay;
import y.g.M;
import y.g.ar;

public class q extends y.f.c {
   private long t;
   private double u = 0.6D;
   private long v = 30000L;
   public static final Object n;
   public static final Object o;
   public static final Object p;
   public static final Object q;
   public static final Object r;
   public static final Object s;
   private byte w = 0;
   private double x = 0.5D;
   private double y = 0.4D;
   private double z = 40.0D;
   private double A;
   private boolean B;
   private boolean C;
   private double D;
   private boolean E;
   private y.f.b.a F;
   private i G;
   private boolean H;
   private short I;
   private boolean J;
   private double K;
   private boolean L;
   private double M;
   private boolean N;
   private boolean O;
   private y.c.A P;

   public double a() {
      return this.y;
   }

   public boolean n() {
      return this.N;
   }

   public q() {
      this.A = this.z;
      this.F = new y.f.b.h();
      this.G = i.a;
      this.I = 1;
      this.L = false;
      this.M = 0.5D;
      this.N = true;
      this.d(false);
      ((aN)this.c()).a((byte)1);
   }

   public y.f.b.a o() {
      return this.F;
   }

   protected void a(X var1, y.f.e var2) {
      if(this.J) {
         label24: {
            if(this.w != 0) {
               var2.a((byte)(32 + (this.E?0:64)));
               if(!this.E) {
                  var2.b(this.r());
               }

               y.c.c var3 = var1.c(n);
               if(var3 == null) {
                  break label24;
               }

               var1.a((Object)y.f.e.b, (y.c.c)(new r(this, var3)));
               if(!i.b) {
                  break label24;
               }
            }

            var2.a((byte)(var2.f() & -33));
         }
      }

      this.K = var2.d();
      var2.b(Math.max(this.K, this.D));
   }

   public void c(X var1) {
      y.c.h var2 = var1.u();
      y.c.A var3 = var1.t();
      a(var1, var2, var3, this.p());
      y.c.q var4 = null;
      y.d.t var5 = null;
      y.c.x var6 = var1.o();

      while(var6.f()) {
         y.c.q var7 = var6.e();
         if(!var3.d(var7)) {
            var4 = var7;
            var5 = var1.l(var7);
            break;
         }

         var6.g();
      }

      y var21 = null;
      if(this.L) {
         var21 = new y(this, var1);
         var21.a(var3);
      }

      y.f.e var22 = null;
      if(this.e() instanceof y.f.e) {
         var22 = (y.f.e)this.e();
         this.a(var1, var22);
      }

      as var8 = null;
      y.c.h var9 = null;
      if(this.l() && this.d() instanceof as) {
         var8 = (as)this.d();
         if(var1.c(as.a) == null) {
            var9 = var2;
            var1.a((Object)as.a, (y.c.c)var2);
         }
      }

      aN var10 = null;
      t var11 = null;
      if(this.j() && this.c() instanceof aN) {
         var10 = (aN)this.c();
         y.c.c var12 = var1.c(aN.a);
         if(var12 == null) {
            var11 = new t(this, var3);
            var1.a((Object)aN.a, (y.c.c)var11);
         }
      }

      try {
         super.c(var1);
      } finally {
         if(var22 != null) {
            this.b(var1, var22);
         }

         if(var9 != null) {
            var1.d_(as.a);
         }

         if(var11 != null) {
            var1.d_(aN.a);
         }

         var1.a((y.c.h)var2);
         var1.a((y.c.A)var3);
         if(this.L) {
            var21.a();
         }

         if(var4 != null) {
            double var15 = var5.a - var1.j(var4);
            double var17 = var5.b - var1.k(var4);
            if(var15 != 0.0D || var17 != 0.0D) {
               ae.a(var1, var1.o(), var15, var17);
            }
         }

      }

   }

   protected void b(X var1, y.f.e var2) {
      if(this.J) {
         var1.d_(y.f.e.b);
      }

      var2.b(this.K);
   }

   protected boolean b(X var1) {
      return var1 != null;
   }

   private void d(X var1) {
      boolean var11 = i.b;
      if(this.O) {
         this.P = var1.t();
         y.c.x var2 = var1.o();

         while(var2.f()) {
            y.c.q var3 = var2.e();
            y.d.y var4 = var1.s(var3);
            aj[] var5 = var1.a_(var3);
            int var6 = 0;

            label26: {
               while(var6 < var5.length) {
                  aj var7 = var5[var6];
                  var4 = this.a(var4, var7.getBox());
                  ++var6;
                  if(var11) {
                     break label26;
                  }

                  if(var11) {
                     break;
                  }
               }

               this.P.a(var3, var1.r(var3));
            }

            y.d.t var12 = var1.l(var3);
            double var13 = Math.floor(Math.max(var12.a() - var4.c(), var4.c() + var4.a() - var12.a()) + 1.0E-5D);
            double var9 = Math.floor(Math.max(var12.b() - var4.d(), var4.d() + var4.b() - var12.b()) + 1.0E-5D);
            var1.b(var3, 2.0D * var13, 2.0D * var9);
            var1.a(var3, var12);
            var2.g();
            if(var11) {
               break;
            }
         }
      }

   }

   private void e(X var1) {
      boolean var5 = i.b;
      if(this.O) {
         y.c.x var2 = var1.o();

         while(var2.f()) {
            y.c.q var3 = var2.e();
            y.d.t var4 = var1.l(var3);
            var1.a(var3, (y.d.q)this.P.b(var3));
            var1.a(var3, var4);
            var2.g();
            if(var5) {
               return;
            }

            if(var5) {
               break;
            }
         }

         var1.a((y.c.A)this.P);
      }

   }

   private y.d.y a(y.d.y var1, y.d.y var2) {
      if(var1 != null && var2 != null) {
         double var3 = Math.min(var1.c(), var2.c());
         double var5 = Math.max(var1.c() + var1.a(), var2.c() + var2.a());
         double var7 = Math.min(var1.d(), var2.d());
         double var9 = Math.max(var1.d() + var1.b(), var2.d() + var2.b());
         return new y.d.y(var3, var7, var5 - var3, var9 - var7);
      } else {
         return var1 == null?var2:var1;
      }
   }

   private y.c.c a(X var1, y.c.c var2) {
      boolean var12 = i.b;
      y.f.b.c var3 = new y.f.b.c(var1);
      y.c.A var4 = M.a();
      y.c.A var5 = M.a();
      y.c.x var6 = var1.o();

      Object var10000;
      while(true) {
         if(var6.f()) {
            y.c.q var7 = var6.e();
            var10000 = var5;
            if(var12) {
               break;
            }

            var5.a(var7, var2.d(var7));
            var6.g();
            if(!var12) {
               continue;
            }
         }

         var10000 = var1.c(o);
         break;
      }

      Object var13 = var10000;
      y.c.x var14 = var1.o();

      y.f.b.c var15;
      while(true) {
         if(var14.f()) {
            y.c.q var8 = var14.e();
            var15 = var3;
            if(var12) {
               break;
            }

            label38: {
               if(var3.d(var8) && this.a((y.c.q)var8, (y.c.c)var13) && !var4.d(var8)) {
                  y.c.y var9 = var3.c(var8);
                  y.c.x var10 = var9.a();

                  while(var10.f()) {
                     y.c.q var11 = var10.e();
                     var5.a(var11, false);
                     var4.a(var11, true);
                     var10.g();
                     if(var12) {
                        break label38;
                     }

                     if(var12) {
                        break;
                     }
                  }
               }

               var14.g();
            }

            if(!var12) {
               continue;
            }
         }

         var15 = var3;
         break;
      }

      var15.c();
      return var5;
   }

   private boolean a(y.c.q var1, y.c.c var2) {
      return this.I == 2 || var2 != null && var2.b(var1) == r;
   }

   private boolean a(y.c.q var1, y.c.c var2, X var3) {
      if(this.I == 3) {
         y.c.c var4 = var3.c(y.f.e.a.as.a);
         return var4 != null?var4.d(var1):true;
      } else {
         return var2 != null && var2.b(var1) == q;
      }
   }

   protected void a(X var1) {
      boolean var11 = i.b;
      this.g(var1);
      this.d(var1);
      this.u();
      boolean var2 = y.f.b.c.c((y.c.i)var1);
      y.c.c var3 = var1.c(n);
      if(var3 != null) {
         label117: {
            if(this.w == 0) {
               var1.d_(n);
               if(!var11) {
                  break label117;
               }
            }

            if(!var2) {
               var1.a((Object)n, (y.c.c)this.a(var1, var3));
            }
         }
      }

      a var4 = this.w();
      if(var4 != null && (var2 || this.I == 1)) {
         this.a(var4);
         var4.c(var1);
         if(!var2) {
            B var5 = new B(this, var1);
            (new y.f.b.j((ah)null, new A(new z(this.o(), var5)))).c(var1);
         }
      }

      B var15;
      if(!this.v() && this.u > 0.1D) {
         label104: {
            if(this.s()) {
               ay var12 = this.h(var1);
               if(var12 == null) {
                  break label104;
               }

               short var10000;
               label100: {
                  this.G.a(var12, var1);
                  var12.g(false);
                  y.c.c var6 = var1.c(as.a);
                  if(var6 != null) {
                     y.c.e var7 = var1.p();

                     while(var7.f()) {
                        var10000 = var6.d(var7.a());
                        if(var11) {
                           break label100;
                        }

                        if(var10000 != 0) {
                           ae.a(var1, var7.a());
                        }

                        var7.g();
                        if(var11) {
                           break;
                        }
                     }
                  }

                  var10000 = this.I;
               }

               label87: {
                  if(var10000 == 2 && !y.f.b.c.c((y.c.i)var1)) {
                     y.f.b.c var19 = new y.f.b.c(var1);
                     HashSet var8 = new HashSet(var19.b(var19.b()));
                     var19.c();
                     ac var9 = new ac();
                     var1.a((Object)ac.a, (y.c.c)(new u(this, var8, var12)));
                     y.f.b.j var10 = new y.f.b.j(var9);
                     var10.a((y.f.b.a)(new v(this)));
                     var10.c(var1);
                     if(!var11) {
                        break label87;
                     }
                  }

                  var12.c(var1);
               }

               if(!var2) {
                  B var20 = new B(this, var1);
                  (new y.f.b.j((ah)null, new A(new z(this.o(), var20)))).c(var1);
               }

               this.G.b(var12, var1);
               if(!var11) {
                  break label104;
               }
            }

            d var13 = this.x();
            if(var13 != null) {
               var15 = new B(this, var1);
               this.a((d)var13, (y.c.c)var15);
               var13.c(var1);
            }
         }
      }

      if(!this.E) {
         if(this.w != 0) {
            y.c.c var14 = var1.c(n);
            if(var14 != null) {
               var1.a((Object)l.b, (y.c.c)(new w(this, var14)));
            }
         }

         label124: {
            l var16;
            if(!var2) {
               var16 = new l();
               if(this.w != 0) {
                  var16.b(false);
               }

               var16.a((byte)2);
               var16.a(this.D);
               var16.a(false);
               var15 = new B(this, var1);
               (new y.f.b.j(var16, new A(new z(this.o(), var15)))).c(var1);
               if(!var11) {
                  break label124;
               }
            }

            if(this.w == 0) {
               ar var17 = this.C?new ar(42L):new ar();
               k var18 = new k(var17, this.D);
               var18.c(var1);
               if(!var11) {
                  break label124;
               }
            }

            var16 = new l();
            var16.b(false);
            var16.a((byte)2);
            var16.a(this.D);
            var16.a(false);
            var16.c(var1);
         }

         if(this.w != 0) {
            var1.d_(l.b);
         }
      }

      if(var3 != null) {
         var1.a((Object)n, (y.c.c)var3);
      }

      this.f(var1);
      this.e(var1);
   }

   private void f(X var1) {
      boolean var2 = i.b;
      switch(this.I) {
      case 1:
      default:
         if(!var2) {
            break;
         }
      case 3:
         var1.d_(y.f.e.a.as.a);
         if(!var2) {
            break;
         }
      case 2:
         var1.d_(d.o);
      }

      this.I = 1;
   }

   private static void a(X var0, y.c.a var1, y.c.a var2, int var3) {
      boolean var14 = i.b;
      y.c.c var4 = var0.c(n);
      y.c.c var5 = var0.c(o);
      if(var5 != null || var4 != null) {
         int[] var6;
         y.c.x var20;
         label487: {
            var6 = new int[var0.e()];
            y.c.x var9;
            if(var4 != null && var3 != 0) {
               label488: {
                  if(var3 == 1) {
                     int[] var7 = new int[var0.e()];
                     y.c.A var8 = M.a(var7);
                     y.a.b.a(var0, (y.c.c)var4, var8);
                     var9 = var0.o();

                     do {
                        if(!var9.f()) {
                           break label488;
                        }

                        boolean var10 = var4.d(var9.e());
                        int var11 = var7[var9.e().d()];
                        if(var14) {
                           break label487;
                        }

                        var6[var9.e().d()] = !var10 && (var11 < 0 || var11 >= 5)?1:0;
                        var9.g();
                     } while(!var14);
                  }

                  var20 = var0.o();

                  while(var20.f()) {
                     boolean var23 = var4.d(var20.e());
                     if(var14) {
                        break label487;
                     }

                     var6[var20.e().d()] = var23?0:1;
                     var20.g();
                     if(var14) {
                        break;
                     }
                  }
               }
            }

            if(y.f.b.c.b((y.c.i)var0)) {
               label504: {
                  y.f.b.c var21 = new y.f.b.c(var0);
                  boolean var16 = false;

                  try {
                     var16 = true;
                     int var25 = 0;
                     var9 = var0.o();

                     int var10000;
                     y.c.q var28;
                     label442: {
                        while(var9.f()) {
                           var28 = var9.e();
                           var10000 = var21.d(var28);
                           if(var14) {
                              break label442;
                           }

                           if(var10000 != 0) {
                              boolean var30 = var3 == 0 || var4 == null || var4.d(var28);
                              Object var12 = var5 != null?var5.b(var28):null;
                              if(var12 == null) {
                                 var12 = p;
                              }

                              if(var12 == r && var30) {
                                 ++var25;
                              }

                              if(var12 == q) {
                                 var6[var28.d()] = var30?0:1;
                              }
                           }

                           var9.g();
                           if(var14) {
                              break;
                           }
                        }

                        var10000 = var25;
                     }

                     if(var10000 > 0) {
                        var9 = var0.o();

                        while(true) {
                           if(!var9.f()) {
                              var16 = false;
                              break;
                           }

                           var28 = var9.e();
                           y.c.q var31 = var21.a(var28);
                           if(var14) {
                              var16 = false;
                              break label504;
                           }

                           y.c.q var32 = null;

                           while(var31 != var21.b()) {
                              if(var5.b(var31) == r) {
                                 var32 = var31;
                              }

                              var31 = var21.a(var31);
                              if(var14) {
                                 break;
                              }
                           }

                           if(var32 != null) {
                              var6[var28.d()] = var32.d() + 2;
                           }

                           var9.g();
                           if(var14) {
                              var16 = false;
                              break;
                           }
                        }
                     } else {
                        var16 = false;
                     }
                  } finally {
                     if(var16) {
                        var21.c();
                     }
                  }

                  var21.c();
               }
            }
         }

         y.c.e var22 = var0.p();

         while(var22.f()) {
            y.c.d var26 = var22.a();
            int var27 = var6[var26.c().d()];
            int var29 = var6[var26.d().d()];
            if(var14) {
               return;
            }

            label514: {
               if(var27 == 0 || var29 == 0) {
                  var1.a(var26, true);
                  if(!var14) {
                     break label514;
                  }
               }

               if(var27 != var29) {
                  var1.a(var26, true);
                  if(!var14) {
                     break label514;
                  }
               }

               var1.a(var26, false);
            }

            var22.g();
            if(var14) {
               break;
            }
         }

         var20 = var0.o();

         do {
            if(!var20.f()) {
               return;
            }

            var2.a(var20.e(), var6[var20.e().d()] == 0);
            var20.g();
         } while(!var14);
      }

      y.c.e var18 = var0.p();

      while(var18.f()) {
         y.c.d var24 = var18.a();
         var1.a(var24, true);
         var18.g();
         if(var14) {
            return;
         }

         if(var14) {
            break;
         }
      }

      y.c.x var19 = var0.o();

      while(var19.f()) {
         var2.a(var19.e(), true);
         var19.g();
         if(var14) {
            break;
         }
      }

   }

   private void g(X var1) {
      boolean var12 = i.b;
      this.I = 1;
      y.c.c var2 = var1.c(n);
      y.c.c var3 = var1.c(o);
      if((var3 != null || var2 != null) && y.f.b.c.b((y.c.i)var1)) {
         y.f.b.c var4 = new y.f.b.c(var1);
         boolean var14 = false;

         y.f.b.c var19;
         label254: {
            try {
               var14 = true;
               int var5 = 0;
               int var6 = 0;
               y.c.x var7 = var1.o();

               int var10000;
               label219: {
                  while(var7.f()) {
                     y.c.q var8 = var7.e();
                     var10000 = var4.d(var8);
                     if(var12) {
                        break label219;
                     }

                     if(var10000 != 0) {
                        boolean var9 = this.w == 0 || var2 == null || var2.d(var8);
                        Object var10 = var3 != null?var3.b(var8):null;
                        if(var10 == null) {
                           var10 = p;
                        }

                        if(var10 == r && var9) {
                           ++var5;
                        }

                        if(var10 == q) {
                           ++var6;
                        }
                     }

                     var7.g();
                     if(var12) {
                        break;
                     }
                  }

                  var10000 = var6;
               }

               y.c.A var16;
               y.c.x var17;
               y.c.q var18;
               if(var10000 <= 0) {
                  if(var5 > 0) {
                     this.I = 2;
                     var16 = M.a();
                     var17 = var1.o();

                     while(var17.f()) {
                        var18 = var17.e();
                        var19 = var4;
                        if(var12) {
                           var14 = false;
                           break label254;
                        }

                        if(var4.d(var18) && (this.w == 0 || var2 == null || var2.d(var18)) && var3.b(var18) == r) {
                           var16.a(var18, true);
                        }

                        var17.g();
                        if(var12) {
                           break;
                        }
                     }

                     var1.a((Object)d.o, (y.c.c)var16);
                     var14 = false;
                  } else {
                     var14 = false;
                  }
               } else {
                  var16 = M.a();
                  this.I = 3;
                  var17 = var1.o();

                  while(true) {
                     if(var17.f()) {
                        var18 = var17.e();
                        var19 = var4;
                        if(var12) {
                           var14 = false;
                           break label254;
                        }

                        if(var4.d(var18) && var3.b(var18) == q) {
                           var16.a(var18, true);
                        }

                        var17.g();
                        if(!var12) {
                           continue;
                        }
                     }

                     var1.a((Object)y.f.e.a.as.a, (y.c.c)var16);
                     var14 = false;
                     break;
                  }
               }
            } finally {
               if(var14) {
                  var4.c();
               }
            }

            var19 = var4;
         }

         var19.c();
      }

   }

   private boolean s() {
      boolean var1 = this.G != i.a;
      return var1?true:(this.I == 3?true:(this.I == 2?false:this.H));
   }

   private J t() {
      y.f.e.a.aj var1 = new y.f.e.a.aj();
      var1.a(true);
      var1.a(this.A);
      J var2 = new J(var1, J.a, 0.0D, 50.0D);
      var2.a(J.a);
      var2.c(0.0D);
      return var2;
   }

   private ay h(X var1) {
      boolean var8 = i.b;
      ay var2 = new ay(false);
      var2.m();
      if(this.w != 0) {
         x var3 = new x(this);
         var2.e((am)var3);
      }

      Object var9;
      label28: {
         if(y.f.b.c.c((y.c.i)var1)) {
            var9 = new y.f.e.a.h();
            if(!var8) {
               break label28;
            }
         }

         var9 = new y.f.e.a.x();
         if(this.I == 3) {
            var2.a((y.f.e.a.p)(new y.f.e.a.as()));
         }
      }

      label23: {
         ((y.f.e.a.h)var9).d(this.x);
         var2.a((y.f.e.a.p)var9);
         var2.a(this.q());
         var2.b(this.q());
         var2.h(this.C);
         y.f.e.a.o var4 = (y.f.e.a.o)var2.z();
         var4.a((long)((double)this.v * this.u * 0.8D));
         double var5 = this.u;
         if(this.H) {
            var4.a(0.6D - 0.57D * var5);
            var4.b(0.3D - 0.29D * var5);
            ((y.f.e.a.h)var9).c(((y.f.e.a.h)var9).f() * 10.0D);
            if(!var8) {
               break label23;
            }
         }

         var4.a(0.6D - 0.585D * var5);
         var4.b(0.3D - 0.295D * var5);
      }

      this.G.a(var2);
      if(this.H) {
         J var7 = this.t();
         var7.c(((y.f.e.a.h)var9).e());
         var2.a((ax)var7);
      }

      return var2;
   }

   private void u() {
      this.t = System.currentTimeMillis();
   }

   private boolean v() {
      return System.currentTimeMillis() - this.t > this.v;
   }

   private a w() {
      if(this.w != 0) {
         return null;
      } else {
         a var1 = new a();
         var1.h(this.C);
         return var1;
      }
   }

   private d x() {
      return new d();
   }

   private void a(a var1) {
      var1.m();
      if(!this.k()) {
         var1.e(true);
      }

      var1.a((ad)(new y.f.b.i()));
      var1.g(this.u > 0.0D);
      var1.c((int)this.z);
      var1.h(this.C);
      var1.i(this.B);
      if(this.u > 0.1D) {
         var1.b(2 + (int)(this.u * 8.0D));
         var1.a(8 + (int)(this.u * 22.0D));
         var1.d(15);
         if(!i.b) {
            return;
         }
      }

      var1.b(2 + (int)(28.0D * this.u / 0.1D));
      var1.a(25 + (int)(92.0D * this.u / 0.1D));
      var1.d(15);
   }

   private void a(d var1, y.c.c var2) {
      label75: {
         boolean var3 = i.b;
         var1.m();
         var1.c((int)this.z);
         var1.c((byte)2);
         var1.b((byte)0);
         var1.h(false);
         var1.g(this.C);
         var1.b(this.w);
         if(this.x == 0.0D) {
            var1.c(0.0D);
            var1.b((int)0);
            var1.a(0);
            var1.a(0.0D);
            if(!var3) {
               break label75;
            }
         }

         if(this.x < 0.2D) {
            var1.c(0.0D);
            var1.b((int)1);
            var1.a(0);
            var1.a(0.1D);
            if(!var3) {
               break label75;
            }
         }

         if(this.x < 0.4D) {
            var1.c(0.0D);
            var1.b((int)1);
            var1.a(1);
            var1.a(0.2D);
            if(!var3) {
               break label75;
            }
         }

         if(this.x < 0.5D) {
            var1.c(0.0D);
            var1.b((int)1);
            var1.a(1);
            var1.a(0.3D);
            if(!var3) {
               break label75;
            }
         }

         if(this.x < 0.6D) {
            var1.c(0.0D);
            var1.b((int)2);
            var1.a(1);
            var1.a(0.4D);
            if(!var3) {
               break label75;
            }
         }

         if(this.x < 0.7D) {
            var1.c(0.0D);
            var1.b((int)2);
            var1.a(2);
            var1.a(0.8D);
            if(!var3) {
               break label75;
            }
         }

         if(this.x < 0.8D) {
            var1.c(0.1D);
            var1.b((int)2);
            var1.a(2);
            var1.a(1.0D);
            if(!var3) {
               break label75;
            }
         }

         if(this.x < 0.9D) {
            var1.c(0.3D);
            var1.b((int)2);
            var1.a(2);
            var1.a(1.0D);
            if(!var3) {
               break label75;
            }
         }

         if(this.x < 1.0D) {
            var1.c(0.6D);
            var1.b((int)2);
            var1.a(2);
            var1.a(1.0D);
            if(!var3) {
               break label75;
            }
         }

         var1.c(4.0D);
         var1.b((int)2);
         var1.a(2);
         var1.a(1.0D);
      }

      if(!this.n()) {
         var1.a(this.a());
      }

      var1.i(this.B || this.O);
      var1.a((long)((double)this.v * this.u * 0.8D));
      var1.b(2.0D - this.u);
      var1.d(1.0D + this.u * this.u * 100.0D);
      var1.a((y.f.b.a)(new A(new z(this.o(), var2))));
   }

   public void a(double var1) {
      if(var1 >= 0.0D && var1 <= 1.0D) {
         this.u = var1;
      } else {
         throw new IllegalArgumentException("Ratio must lie within [0,1]");
      }
   }

   public byte p() {
      return this.w;
   }

   public void b(double var1) {
      if(var1 >= 0.0D && var1 <= 1.0D) {
         this.x = var1;
      } else {
         throw new IllegalArgumentException("Compactness must lie within [0,1]");
      }
   }

   public double q() {
      return this.z;
   }

   public void c(double var1) {
      this.z = var1;
   }

   public void g(boolean var1) {
      this.B = var1;
   }

   public void h(boolean var1) {
      this.C = var1;
   }

   public double r() {
      return this.D;
   }

   public void d(double var1) {
      this.D = var1;
   }

   static double a(q var0) {
      return var0.M;
   }

   static boolean a(q var0, y.c.q var1, y.c.c var2, X var3) {
      return var0.a(var1, var2, var3);
   }

   static boolean a(q var0, y.c.q var1, y.c.c var2) {
      return var0.a(var1, var2);
   }

   static {
      n = d.n;
      o = "y.layout.organic.SmartOrganicLayouter.GROUP_NODE_MODE_DATA";
      p = "GROUP_NODE_MODE_NORMAL";
      q = "GROUP_NODE_MODE_FIX_BOUNDS";
      r = "GROUP_NODE_MODE_FIX_CONTENTS";
      s = d.p;
   }
}
