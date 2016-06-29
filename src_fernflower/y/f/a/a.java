package y.f.a;

import java.util.Comparator;
import java.util.Iterator;
import y.f.X;
import y.f.aN;
import y.f.ad;
import y.f.aj;
import y.f.a.b;
import y.f.a.c;
import y.f.a.d;
import y.f.a.e;
import y.f.a.f;
import y.f.a.h;
import y.f.a.j;
import y.f.a.s;
import y.f.a.t;
import y.f.a.x;
import y.f.a.z;
import y.g.L;
import y.g.M;

public class a extends y.f.c {
   public static final Object n = "y.layout.circular.CircularLayouter.CIRCLE_ID_HOLDER_DPKEY";
   public static final Object o;
   private byte p;
   private X q;
   private f r;
   private x s;
   private byte t;
   private boolean u;
   private boolean v;
   private boolean w;
   private y.c.A x;

   public a() {
      label26: {
         int var2 = f.u;
         super();
         this.p = 0;
         this.t = 0;
         this.u = false;
         this.v = true;
         this.w = false;
         if(this.t == 0) {
            this.r = new f();
            if(var2 == 0) {
               break label26;
            }
         }

         if(this.t == 1) {
            this.r = new j();
            ((j)this.r).i(false);
            if(var2 == 0) {
               break label26;
            }
         }

         if(this.t == 2) {
            this.r = new j();
            ((j)this.r).i(true);
         }
      }

      this.s = new x();
      ((aN)this.c()).a((byte)1);
      ad var1 = this.f();
      if(var1 instanceof y.f.b.b) {
         ((y.f.b.b)var1).a(false);
      }

   }

   public void b(byte var1) {
      this.p = var1;
   }

   public byte a() {
      return this.p;
   }

   public f n() {
      return this.r;
   }

   public y.f.k.o o() {
      return this.s;
   }

   public void c(byte var1) {
      int var2 = f.u;
      this.t = var1;
      if(var1 == 0) {
         this.r = new f();
         if(var2 == 0) {
            return;
         }
      }

      if(var1 == 1) {
         this.r = new j();
         ((j)this.r).i(false);
         if(var2 == 0) {
            return;
         }
      }

      if(var1 == 2) {
         this.r = new j();
         ((j)this.r).i(true);
      }

   }

   public boolean b(X var1) {
      return true;
   }

   private void a(X var1, s var2) {
      int var11 = f.u;
      y.c.c var3 = var1.c(n);
      if(var3 != null) {
         boolean var4 = var3 instanceof y.c.a;
         int var5 = 0;
         y.c.x var6;
         y.c.q var7;
         if(var2 != null) {
            var2.P();
            var6 = var2.o();

            label68: {
               label67:
               do {
                  boolean var10000 = var6.f();

                  label64:
                  while(true) {
                     if(!var10000) {
                        break label67;
                     }

                     var7 = var6.e();
                     var2.v(var7);
                     if(var11 != 0) {
                        break label68;
                     }

                     y.c.x var8 = var1.o();

                     while(true) {
                        if(!var8.f()) {
                           break label64;
                        }

                        y.c.q var9 = var8.e();
                        var10000 = var4;
                        if(var11 != 0) {
                           break;
                        }

                        label59: {
                           if(var4) {
                              ((y.c.a)var3).a(var9, var5);
                              if(var11 == 0) {
                                 break label59;
                              }
                           }

                           Object var10 = var3.b(var9);
                           if(var10 instanceof L) {
                              ((L)var10).a(var5);
                           }
                        }

                        var8.g();
                        if(var11 != 0) {
                           break label64;
                        }
                     }
                  }

                  ++var5;
                  var2.w(var7);
                  var6.g();
               } while(var11 == 0);

               var2.Q();
            }

            if(var11 == 0) {
               return;
            }
         }

         var6 = var1.o();

         while(var6.f()) {
            label37: {
               var7 = var6.e();
               if(var4) {
                  ((y.c.a)var3).a(var7, var5);
                  if(var11 == 0) {
                     break label37;
                  }
               }

               Object var12 = var3.b(var7);
               if(var12 instanceof L) {
                  ((L)var12).a(var5);
               }
            }

            var6.g();
            if(var11 != 0) {
               break;
            }
         }
      }

   }

   public void a(X var1) {
      if(var1.f() >= 2) {
         label26: {
            this.q = var1;
            this.r.g(this.u);
            this.s.g(this.u);
            this.x = var1.t();
            if(this.a() == 3) {
               y.c.A var2 = null;
               if(this.w) {
                  var2 = this.q();
                  this.a(var2);
               }

               this.r.a(var1);
               if(this.w) {
                  this.r();
                  y.c.y var3 = new y.c.y(var1.o());
                  y.c.y var4 = var3;
                  if(this.r instanceof j) {
                     var4 = ((j)this.r).p();
                  }

                  this.a(var4, var3, var2);
               }

               this.a((X)var1, (s)null);
               if(f.u == 0) {
                  break label26;
               }
            }

            this.p();
         }

         var1.a((y.c.A)this.x);
      }
   }

   private y.c.A q() {
      int var11 = f.u;
      y.c.A var1 = M.a();
      y.c.x var2 = this.q.o();

      do {
         boolean var10000 = var2.f();

         y.c.q var3;
         y.c.D var6;
         label29:
         while(true) {
            if(!var10000) {
               return var1;
            }

            var3 = var2.e();
            y.d.y var4 = this.q.s(var3);
            aj[] var5 = this.q.a_(var3);
            var6 = new y.c.D();
            int var7 = 0;

            while(true) {
               if(var7 >= var5.length) {
                  break label29;
               }

               aj var8 = var5[var7];
               y.d.y var9 = var8.getBox();
               var10000 = var4.b(var9);
               if(var11 != 0) {
                  break;
               }

               if(!var10000) {
                  c var10 = new c(this, (y.c.q)null, var3, var9);
                  var6.add(var10);
               }

               ++var7;
               if(var11 != 0) {
                  break label29;
               }
            }
         }

         var1.a(var3, var6);
         var2.g();
      } while(var11 == 0);

      return var1;
   }

   private void a(y.c.y var1, y.c.y var2, y.c.A var3) {
      int var12 = f.u;
      if(var1.size() >= 2) {
         y.c.A var4 = M.a();
         y.c.x var5 = var1.a();

         y.c.x var10000;
         while(true) {
            if(var5.f()) {
               y.c.q var6 = var5.e();
               var4.a(var6, true);
               var10000 = var5;
               if(var12 != 0) {
                  break;
               }

               var5.g();
               if(var12 == 0) {
                  continue;
               }
            }

            var10000 = var1.a();
            break;
         }

         y.d.t var13 = a(var10000, this.q);
         double var14 = y.d.t.a(var13, this.q.l(var1.b()));
         y.c.A var8 = M.a();
         int var9 = 0;

         a var16;
         y.c.y var10001;
         y.c.A var10002;
         while(true) {
            if(var9 < 20) {
               var16 = this;
               var10001 = var2;
               var10002 = var4;
               if(var12 != 0) {
                  break;
               }

               if(!this.a(var2, var4, var3, var13, 0.9D, var8)) {
                  ++var9;
                  if(var12 == 0) {
                     continue;
                  }
               }
            }

            var16 = this;
            var10001 = var1;
            var10002 = var8;
            break;
         }

         var16.a(var10001, var10002);
         double var15 = 1.0D - 5.0D / var14;
         int var11 = 0;

         while(true) {
            if(var11 < 10) {
               var16 = this;
               var10001 = var2;
               var10002 = var4;
               if(var12 != 0) {
                  break;
               }

               if(!this.a(var2, var4, var3, var13, var15, var8)) {
                  ++var11;
                  if(var12 == 0) {
                     continue;
                  }
               }
            }

            var16 = this;
            var10001 = var1;
            var10002 = var8;
            break;
         }

         var16.a(var10001, var10002);
      }
   }

   private void a(y.c.y var1, y.c.A var2) {
      int var6 = f.u;
      y.c.x var3 = var1.a();

      while(var3.f()) {
         y.c.q var4 = var3.e();
         y.d.t var5 = (y.d.t)var2.b(var4);
         this.q.a(var4, var5);
         var3.g();
         if(var6 != 0) {
            break;
         }
      }

   }

   private static y.d.y a(y.d.y var0, double var1) {
      return new y.d.y(var0.c() - var1, var0.d() - var1, var0.a() + 2.0D * var1, var0.b() + 2.0D * var1);
   }

   private boolean a(y.c.y var1, y.c.A var2, y.c.A var3, y.d.t var4, double var5, y.c.A var7) {
      int var19 = f.u;
      double var8 = (double)this.r.a();
      double var10 = Math.min(var8, 2.0D);
      y.c.D var12 = new y.c.D();
      y.c.x var13 = var1.a();

      while(var13.f()) {
         y.c.q var14 = var13.e();
         if(var2.d(var14)) {
            y.d.t var15 = this.q.l(var14);
            var7.a(var14, var15);
            y.d.t var16 = new y.d.t((var15.a() - var4.a()) * var5, (var15.b() - var4.b()) * var5);
            this.q.a(var14, var16);
         }

         label31: {
            y.d.y var21 = this.q.s(var14);
            var12.add(new e(a(var21, var8 * 0.5D), var21, var14, (byte)0));
            y.c.D var22 = (y.c.D)var3.b(var14);
            if(var22 != null) {
               y.c.C var17 = var22.m();

               while(var17.f()) {
                  y.d.y var18 = ((c)var17.d()).a();
                  var12.add(new e(a(var18, var10 * 0.5D), var18, var14, (byte)1));
                  var17.g();
                  if(var19 != 0) {
                     break label31;
                  }

                  if(var19 != 0) {
                     break;
                  }
               }
            }

            var13.g();
         }

         if(var19 != 0) {
            break;
         }
      }

      d var20 = new d(var8, var10, var2);
      y.d.f.a(var12, var20);
      return var20.a();
   }

   private static y.d.t a(y.c.x var0, X var1) {
      if(var0.k() < 2) {
         return null;
      } else {
         y.d.t var2;
         y.d.t var3;
         if(var0.k() == 2) {
            var2 = var1.l(var0.e());
            var0.g();
            var3 = var1.l(var0.e());
            return y.d.t.c(var2, var3);
         } else {
            var2 = var1.l(var0.e());
            var0.g();
            var3 = var1.l(var0.e());
            var0.g();
            y.d.t var4 = var1.l(var0.e());
            y.d.a var5 = new y.d.a(y.d.t.c(var2, var3), y.d.z.c(new y.d.z(var2, var3)));
            y.d.a var6 = new y.d.a(y.d.t.c(var3, var4), y.d.z.c(new y.d.z(var3, var4)));
            return y.d.a.a(var5, var6);
         }
      }
   }

   void p() {
      // $FF: Couldn't be decompiled
   }

   private static void a(y.c.q var0, s var1, X var2) {
      int var8 = f.u;
      y.d.t var3 = var1.l(var0);
      double var4 = 0.0D;
      y.c.x var6 = var1.t(var0).a();

      while(true) {
         if(var6.f()) {
            y.c.q var7 = var6.e();
            var4 = Math.max(var4, a(var2.s(var7), var3));
            var6.g();
            if(var8 != 0) {
               break;
            }

            if(var8 == 0) {
               continue;
            }
         }

         var1.b(var0, Math.max(var1.p(var0), 2.0D * var4), Math.max(var1.q(var0), 2.0D * var4));
         var1.a(var0, var3);
         break;
      }

   }

   private static double a(y.d.y var0, y.d.t var1) {
      y.d.t var2 = var0.e();
      y.d.t var3 = new y.d.t(var0.c() + var0.a(), var0.d() + var0.b());
      y.d.t var4 = new y.d.t(var0.c(), var0.d() + var0.b());
      y.d.t var5 = new y.d.t(var0.c() + var0.a(), var0.d());
      double var6 = y.d.t.a(var1, var2);
      var6 = Math.max(var6, y.d.t.a(var1, var3));
      var6 = Math.max(var6, y.d.t.a(var1, var4));
      var6 = Math.max(var6, y.d.t.a(var1, var5));
      return var6;
   }

   private void a(y.c.A var1) {
      int var11 = f.u;
      y.c.x var2 = this.q.o();

      while(var2.f()) {
         y.c.q var3 = var2.e();
         y.d.y var4 = this.q.s(var3);
         y.c.D var5 = (y.c.D)var1.b(var3);
         Iterator var6 = var5.iterator();

         while(true) {
            if(var6.hasNext()) {
               c var7 = (c)var6.next();
               var4 = t.a(var4, var7.a());
               if(var11 != 0) {
                  break;
               }

               if(var11 == 0) {
                  continue;
               }
            }

            this.x.a(var3, this.q.r(var3));
            break;
         }

         y.d.t var12 = this.q.l(var3);
         double var13 = Math.floor(Math.max(var12.a() - var4.c(), var4.c() + var4.a() - var12.a()) + 1.0E-5D);
         double var9 = Math.floor(Math.max(var12.b() - var4.d(), var4.d() + var4.b() - var12.b()) + 1.0E-5D);
         this.q.b(var3, 2.0D * var13, 2.0D * var9);
         this.q.a(var3, var12);
         var2.g();
         if(var11 != 0) {
            break;
         }
      }

   }

   private void r() {
      int var4 = f.u;
      y.c.x var1 = this.q.o();

      while(var1.f()) {
         y.c.q var2 = var1.e();
         y.d.t var3 = this.q.l(var2);
         this.q.a(var2, (y.d.q)this.x.b(var2));
         this.q.a(var2, var3);
         var1.g();
         if(var4 != 0) {
            break;
         }
      }

   }

   private void a(s var1) {
      int var14 = f.u;
      y.c.x var2 = var1.o();

      while(var2.f()) {
         y.c.q var3 = var2.e();
         y.d.t var4 = var1.l(var3);
         y.c.y var5 = var1.t(var3);
         y.d.y var6 = null;
         y.c.x var7 = var5.a();

         while(true) {
            if(var7.f()) {
               y.c.q var8 = var7.e();
               y.d.y var9 = this.a(var8, var4);
               var6 = t.a(var6, var9);
               var7.g();
               if(var14 != 0) {
                  break;
               }

               if(var14 == 0) {
                  continue;
               }
            }

            var1.a(var3, var6);
            var1.b(var3, var6.e());
            break;
         }

         double var15 = var4.a() - var1.j(var3);
         double var16 = var4.b() - var1.k(var3);
         y.c.x var11 = var5.a();

         while(true) {
            if(var11.f()) {
               y.c.q var12 = var11.e();
               y.d.t var13 = this.q.l(var12);
               this.q.a(var12, var13.a() + var15, var13.b() + var16);
               var11.g();
               if(var14 != 0) {
                  break;
               }

               if(var14 == 0) {
                  continue;
               }
            }

            var2.g();
            break;
         }

         if(var14 != 0) {
            break;
         }
      }

   }

   private y.d.y a(y.c.q var1, y.d.t var2) {
      y.d.y var3 = this.q.s(var1);
      return new y.d.y(var2.a() + var3.c(), var2.b() + var3.d(), var3.a(), var3.b());
   }

   private void a(s var1, x var2) {
      z var3 = new z();
      var3.a(var2.r());
      var3.b(var2.a());
      var3.c(var1);
      var3.c(var1);
   }

   private void a(s var1, y.c.h var2) {
      int var22 = f.u;
      y.d.t[] var3 = new y.d.t[var1.e()];
      y.c.x var4 = var1.o();

      label273:
      while(true) {
         y.c.q var5;
         double var8;
         double var23;
         y.c.d var24;
         if(var4.f()) {
            var5 = var4.e();
            y.c.y var6 = var1.t(var5);
            y.d.t var10000 = var3[var5.d()];
            if(var22 == 0) {
               label314: {
                  if(var10000 != null) {
                     var4.g();
                     if(var22 == 0) {
                        continue;
                     }

                     var4 = var1.o();
                  } else {
                     label293: {
                        int var7;
                        double var10;
                        y.c.e var12;
                        if(var6.size() > 0) {
                           var3[var5.d()] = this.a(var6);
                           if(var22 == 0) {
                              var4.g();
                              if(var22 == 0) {
                                 continue;
                              }

                              var4 = var1.o();
                              break label293;
                           }

                           var7 = 0;
                           var8 = 0.0D;
                           var10 = 0.0D;
                           var12 = var5.j();
                        } else {
                           var7 = 0;
                           var8 = 0.0D;
                           var10 = 0.0D;
                           var12 = var5.j();
                        }

                        while(true) {
                           if(!var12.f()) {
                              var8 /= (double)var7;
                              var10 /= (double)var7;
                              var3[var5.d()] = new y.d.t(var8, var10);
                              var4.g();
                              if(var22 == 0) {
                                 continue label273;
                              }

                              var4 = var1.o();
                              break;
                           }

                           y.c.d var13 = var12.a();
                           y.c.q var14 = var13.a(var5);
                           var10000 = var3[var14.d()];
                           if(var22 != 0) {
                              var23 = var10000.a();
                              var8 = var3[var5.d()].b();
                              var24 = var5.f();
                              break label314;
                           }

                           if(var10000 != null) {
                              var3[var14.d()] = this.a(var1.t(var14));
                           }

                           var8 += var3[var14.d()].a();
                           var10 += var3[var14.d()].b();
                           var12.g();
                           ++var7;
                           if(var22 != 0) {
                              var8 /= (double)var7;
                              var10 /= (double)var7;
                              var3[var5.d()] = new y.d.t(var8, var10);
                              var4.g();
                              if(var22 == 0) {
                                 continue label273;
                              }

                              var4 = var1.o();
                              break;
                           }
                        }
                     }
                  }

                  if(!var4.f()) {
                     break;
                  }

                  var5 = var4.e();
                  var23 = var3[var5.d()].a();
                  var8 = var3[var5.d()].b();
                  var24 = var5.f();
               }
            } else {
               var23 = var10000.a();
               var8 = var3[var5.d()].b();
               var24 = var5.f();
            }
         } else {
            var4 = var1.o();
            if(!var4.f()) {
               break;
            }

            var5 = var4.e();
            var23 = var3[var5.d()].a();
            var8 = var3[var5.d()].b();
            var24 = var5.f();
         }

         while(true) {
            while(true) {
               label237:
               while(true) {
                  while(var24 == null) {
                     var4.g();
                     if(var22 != 0 || !var4.f()) {
                        return;
                     }

                     var5 = var4.e();
                     var23 = var3[var5.d()].a();
                     var8 = var3[var5.d()].b();
                     var24 = var5.f();
                  }

                  y.c.f var11 = var1.i(var24);
                  y.c.y var25 = new y.c.y();
                  if(var22 == 0) {
                     y.c.e var26 = var11.a();

                     double var18;
                     double var20;
                     y.d.t var27;
                     double var29;
                     double var30;
                     while(var26.f()) {
                        y.c.d var28 = var26.a();
                        y.c.q var15 = var28.c();
                        y.c.q var16 = var28.d();
                        y.c.q var31 = var1.x(var15);
                        if(var22 != 0) {
                           var27 = var31.b() > 0?var3[var5.g().c().d()]:null;
                           var29 = var27 == null?3.141592653589793D:Math.atan2(var27.b() - var8, -(var27.a() - var23));
                           var30 = var3[var24.d().d()].a();
                           var18 = var3[var24.d().d()].b();
                           var20 = Math.atan2(var18 - var8, -(var30 - var23));
                           if(var20 < var29) {
                              var20 += 6.283185307179586D;
                           }

                           var2.a(var24, var20);
                           var24 = var24.g();
                           if(var22 != 0) {
                              var4.g();
                              if(var22 != 0 || !var4.f()) {
                                 return;
                              }

                              var5 = var4.e();
                              var23 = var3[var5.d()].a();
                              var8 = var3[var5.d()].b();
                              var24 = var5.f();
                           }
                           continue label237;
                        }

                        if(var31 == var5) {
                           var25.add(var15);
                           if(var22 != 0) {
                              var25.add(var16);
                           }
                        } else {
                           var25.add(var16);
                        }

                        var26.g();
                        if(var22 != 0) {
                           var27 = var5.b() > 0?var3[var5.g().c().d()]:null;
                           var29 = var27 == null?3.141592653589793D:Math.atan2(var27.b() - var8, -(var27.a() - var23));
                           var30 = var3[var24.d().d()].a();
                           var18 = var3[var24.d().d()].b();
                           var20 = Math.atan2(var18 - var8, -(var30 - var23));
                           if(var20 < var29) {
                              var20 += 6.283185307179586D;
                           }

                           var2.a(var24, var20);
                           var24 = var24.g();
                           if(var22 != 0) {
                              var4.g();
                              if(var22 != 0 || !var4.f()) {
                                 return;
                              }

                              var5 = var4.e();
                              var23 = var3[var5.d()].a();
                              var8 = var3[var5.d()].b();
                              var24 = var5.f();
                           }
                           continue label237;
                        }
                     }

                     var27 = var5.b() > 0?var3[var5.g().c().d()]:null;
                     var29 = var27 == null?3.141592653589793D:Math.atan2(var27.b() - var8, -(var27.a() - var23));
                     var30 = var3[var24.d().d()].a();
                     var18 = var3[var24.d().d()].b();
                     var20 = Math.atan2(var18 - var8, -(var30 - var23));
                     if(var20 < var29) {
                        var20 += 6.283185307179586D;
                     }

                     var2.a(var24, var20);
                     var24 = var24.g();
                     if(var22 != 0) {
                        var4.g();
                        if(var22 != 0 || !var4.f()) {
                           return;
                        }

                        var5 = var4.e();
                        var23 = var3[var5.d()].a();
                        var8 = var3[var5.d()].b();
                        var24 = var5.f();
                     }
                  } else {
                     if(var22 != 0 || !var4.f()) {
                        return;
                     }

                     var5 = var4.e();
                     var23 = var3[var5.d()].a();
                     var8 = var3[var5.d()].b();
                     var24 = var5.f();
                  }
               }
            }
         }
      }

   }

   void a(y.c.i var1, y.c.h var2, y.c.h var3, y.c.q var4) {
      int var7 = f.u;
      b var5 = new b(this, var2, var3, var4);
      y.c.x var6 = var1.o();

      while(var6.f()) {
         var6.e().b((Comparator)var5);
         var6.g();
         if(var7 != 0) {
            break;
         }
      }

   }

   double a(s var1, y.c.q var2, y.c.h var3, y.c.h var4) {
      int var15 = f.u;
      if(var1.t(var2).size() <= 1) {
         return 0.0D;
      } else {
         double var5 = 0.0D;
         double var7 = 0.0D;
         double var9 = 0.0D;
         y.c.e var11 = var2.l();

         y.c.d var12;
         double var13;
         int var10000;
         while(true) {
            if(var11.f()) {
               var12 = var11.a();
               var13 = var3.c(var12);
               double var17;
               var10000 = (var17 = var13 - var5 - var7) == 0.0D?0:(var17 < 0.0D?-1:1);
               if(var15 != 0) {
                  break;
               }

               if(var10000 > 0) {
                  var7 = var13 - var5;
                  var9 = (var5 + var13) / 2.0D;
               }

               var5 = var13;
               var11.g();
               if(var15 == 0) {
                  continue;
               }
            }

            double var18;
            var10000 = (var18 = 360.0D - var5 - var7) == 0.0D?0:(var18 < 0.0D?-1:1);
            break;
         }

         if(var10000 > 0) {
            var9 = (360.0D + var5) / 2.0D;
         }

         this.a(var1, var2, var9);
         var11 = var2.l();

         double var16;
         while(true) {
            if(var11.f()) {
               var12 = var11.a();
               var13 = var3.c(var12);
               var16 = var13 - var9;
               if(var15 != 0) {
                  break;
               }

               var13 = var16;

               label47: {
                  while(var13 < 0.0D) {
                     var13 += 360.0D;
                     if(var15 != 0) {
                        break label47;
                     }

                     if(var15 != 0) {
                        break;
                     }
                  }

                  var3.a(var12, var13);
               }

               if(this.u) {
                  var4.a(var12, var4.c(var12) - var9);
               }

               var11.g();
               if(var15 == 0) {
                  continue;
               }
            }

            var2.b((Comparator)(new b(this, var3, var4, var2)));
            var16 = var9;
            break;
         }

         return var16;
      }
   }

   void a(s var1, y.c.q var2, y.c.A var3) {
      int var17 = f.u;
      y.d.t var4 = var1.l(var2);
      y.c.e var5 = var2.l();

      while(var5.f()) {
         y.c.d var6 = var5.a();
         y.c.q var7 = var6.d();
         y.d.t var8 = var1.l(var7);
         double var9 = var8.a() - var4.a();
         double var11 = var8.b() - var4.b();
         double var13 = y.d.e.b(Math.atan2(var11, var9));
         if(var3.b(var7) != null) {
            double var15 = var3.c(var7);
            var13 += var15;
         }

         this.a(var1, var7, var13);
         this.a(var1, var7, var3);
         var5.g();
         if(var17 != 0) {
            break;
         }
      }

   }

   void a(s var1, y.c.q var2, double var3) {
      int var20 = f.u;
      var3 = y.d.e.a(var3);
      y.c.y var5 = var1.t(var2);
      if(var5.size() > 1) {
         y.c.x var6 = var5.a();

         while(var6.f()) {
            y.c.q var7 = var6.e();
            double var8 = this.q.j(var7);
            double var10 = this.q.k(var7);
            double var12 = Math.cos(var3);
            double var14 = Math.sin(var3);
            double var16 = var8 * var12 - var14 * var10;
            double var18 = var8 * var14 + var12 * var10;
            this.q.a(var7, var16, var18);
            var6.g();
            if(var20 != 0) {
               break;
            }
         }

      }
   }

   void a(s var1, y.c.h var2, y.c.A var3) {
      int var10 = f.u;
      int[] var4 = new int[this.q.f()];
      y.c.x var5 = var1.o();

      s var10000;
      while(true) {
         if(var5.f()) {
            y.c.q var6 = var5.e();
            var10000 = var1;
            if(var10 != 0) {
               break;
            }

            y.c.y var7 = var1.t(var6);
            y.c.x var8 = var7.a();

            label27: {
               while(var8.f()) {
                  y.c.q var9 = var8.e();
                  var4[var9.d()] = var6.d();
                  var8.g();
                  if(var10 != 0) {
                     break label27;
                  }

                  if(var10 != 0) {
                     break;
                  }
               }

               var5.g();
            }

            if(var10 == 0) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      y.c.q var11 = var10000.N();
      this.a(var1, var11, var4, var2, var3);
   }

   void a(s var1, y.c.q var2, int[] var3, y.c.h var4, y.c.A var5) {
      int var25 = f.u;
      int var6 = var2.d();
      double var7 = var5.c(var2);
      y.c.e var9 = var2.l();

      while(var9.f()) {
         y.c.d var10 = var9.a();
         y.c.f var11 = var1.i(var10);
         int var12 = var1.t(var10.d()).size();
         int var10000 = var12;
         int var10001 = 5;

         double var13;
         double var15;
         double var17;
         double var19;
         label68:
         while(true) {
            if(var10000 > var10001 && var11.size() == var12) {
               var11.remove(0);
            }

            var13 = 0.0D;
            var15 = 0.0D;
            var17 = 0.0D;
            var19 = 0.0D;
            y.c.e var21 = var11.a();

            while(true) {
               if(!var21.f()) {
                  break label68;
               }

               y.c.d var22 = var21.a();
               y.c.q var23 = null;
               y.c.q var24 = null;
               var10000 = var3[var22.c().d()];
               var10001 = var6;
               if(var25 != 0) {
                  break;
               }

               if(var10000 == var6) {
                  var23 = var22.c();
                  var24 = var22.d();
               } else {
                  var23 = var22.d();
                  var24 = var22.c();
               }

               var17 -= this.q.j(var23);
               var19 += this.q.k(var23);
               var13 -= this.q.j(var24);
               var15 += this.q.k(var24);
               var21.g();
               if(var25 != 0) {
                  break label68;
               }
            }
         }

         double var26;
         if(var17 != 0.0D || var19 != 0.0D) {
            label80: {
               var26 = y.d.e.b(Math.atan2(var19, var17)) - var7;

               while(var26 < 0.0D) {
                  var26 += 360.0D;
                  if(var25 != 0) {
                     break label80;
                  }

                  if(var25 != 0) {
                     break;
                  }
               }

               var4.a(var10, var26);
            }
         }

         if(var13 != 0.0D && var15 != 0.0D) {
            var26 = y.d.e.b(Math.atan2(var15, var13));
            if(var26 < 0.0D) {
               var26 += 360.0D;
            }

            var5.a(var10.d(), var26);
         }

         this.a(var1, var10.d(), var3, var4, var5);
         var9.g();
         if(var25 != 0) {
            break;
         }
      }

   }

   public void c(X var1) {
      if(this.u && this.k()) {
         ((y.f.e)this.e()).a((byte)96);
      }

      if(this.k() && this.p == 2) {
         ad var2 = this.e();
         boolean var3 = this.r.k();
         h var4 = new h(var2);
         var4.a(true);
         this.d(var4);
         this.r.e(false);
         super.c(var1);
         this.r.e(var3);
         this.d(var2);
         if(f.u == 0) {
            return;
         }
      }

      super.c(var1);
   }

   y.d.t a(y.c.y var1) {
      int var8 = f.u;
      double var2 = 0.0D;
      double var4 = 0.0D;
      if(var1.size() > 0) {
         y.c.x var6 = var1.a();

         label20: {
            while(var6.f()) {
               y.c.q var7 = var6.e();
               var2 += this.q.j(var7);
               var4 += this.q.k(var7);
               var6.g();
               if(var8 != 0) {
                  break label20;
               }

               if(var8 != 0) {
                  break;
               }
            }

            var2 /= (double)var1.size();
         }

         var4 /= (double)var1.size();
      }

      return new y.d.t(var2, var4);
   }

   static double a(double var0) {
      double var10000;
      label36: {
         int var2 = f.u;
         if(var0 < 0.0D) {
            do {
               if(var0 >= 0.0D) {
                  break label36;
               }

               var10000 = var0 + 6.283185307179586D;
               if(var2 != 0) {
                  return var10000;
               }

               var0 = var10000;
            } while(var2 == 0);
         }

         if(var0 >= 6.283185307179586D) {
            while(var0 >= 6.283185307179586D) {
               var10000 = var0 - 6.283185307179586D;
               if(var2 != 0) {
                  return var10000;
               }

               var0 = var10000;
               if(var2 != 0) {
                  break;
               }
            }
         }
      }

      var10000 = var0;
      return var10000;
   }

   static X a(a var0) {
      return var0.q;
   }

   static boolean b(a var0) {
      return var0.u;
   }

   static {
      o = s.k;
   }
}
