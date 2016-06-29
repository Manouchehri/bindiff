package y.f.a;

import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.List;
import y.f.ae;
import y.f.a.G;
import y.f.a.f;
import y.f.a.g;
import y.f.a.k;
import y.f.a.l;
import y.f.a.m;
import y.f.a.n;
import y.f.a.o;
import y.f.a.p;
import y.f.a.q;
import y.f.a.r;
import y.f.e.a.J;
import y.f.e.a.aj;
import y.f.e.a.am;
import y.f.e.a.av;
import y.f.e.a.aw;
import y.f.e.a.ax;
import y.f.e.a.ay;
import y.g.I;
import y.g.ar;

class j extends f {
   private y.c.A v;
   private y.c.A w;
   private y.c.y x;
   private av y;
   private int z;
   private double A;
   private y.c.y B;
   private boolean C = false;
   private y.c.y D = new y.c.y();

   public void i(boolean var1) {
      this.C = var1;
   }

   public y.c.y p() {
      return this.D;
   }

   public void a(y.c.y var1) {
      this.x = var1;
   }

   public void a(ay var1, long var2) {
      ((y.f.e.a.o)var1.z()).a(var2);
   }

   double a(y.c.x var1, double var2) {
      this.A = Math.max(this.s / 6.283185307179586D, var2);
      if(this.x == null) {
         this.x = new y.c.y();
      }

      int var4 = Math.max(this.x.size(), (int)(4.0D * (Math.sqrt((double)this.n.e()) - 1.0D) + 1.0D));
      this.z = this.n.e();
      this.B = new y.c.y(var1);
      double var5;
      if(this.n.e() > 8 && this.n.e() > var4 - 1) {
         ay var7;
         y.f.e.a.h var8;
         label17: {
            this.v = this.n.t();
            var7 = new ay(false);
            var8 = new y.f.e.a.h();
            var7.a((y.f.e.a.p)var8);
            var7.h(true);
            long var9 = Math.max((long)(1000.0D * Math.pow((double)(this.n.e() - this.D.size()), 0.75D)), 500L);
            y.f.e.a.o var11 = new y.f.e.a.o();
            var11.a(var9);
            var11.a(0.05D);
            var11.b(0.03D);
            var7.a((aw)var11);
            var7.a((am)(new n()));
            var7.a((am)(new r(this)));
            if(this.C) {
               var5 = this.a(var7, var8);
               if(f.u == 0) {
                  break label17;
               }
            }

            var5 = this.a(var7, var2, var4, var8);
         }

         var5 = this.a(var7, var5, var8, (double)this.p);
         this.n.a((y.c.A)this.v);
         return var5;
      } else {
         var5 = 3.141592653589793D / (double)this.n.e();
         this.a(var5);
         this.D = this.B;
         return super.a(this.B.a(), var2);
      }
   }

   private double a(ay var1, y.f.e.a.h var2) {
      int var16 = f.u;
      if(!this.t) {
         label56: {
            this.D = new y.c.y();
            y.c.f var3 = new y.c.f();
            if(!y.a.g.c(this.n)) {
               var3 = y.a.h.b(this.n);
            }

            y.f.e.q var4 = new y.f.e.q();
            var4.b(0.3D);
            var4.h(true);
            var4.g(true);
            var4.a(0.5D);
            var4.c((double)this.p);
            var4.d((double)this.p);
            var4.m();
            var4.c(this.n);
            if(var3.size() > 0) {
               y.c.e var5 = var3.a();

               while(var5.f()) {
                  y.c.d var6 = var5.a();
                  this.n.a((y.c.d)var6);
                  var5.g();
                  if(var16 != 0) {
                     break label56;
                  }

                  if(var16 != 0) {
                     break;
                  }
               }
            }

            if(!this.q) {
               double var19 = this.s();
               y.f.j.a var7 = new y.f.j.a();
               var7.b(this.o / var19);
               var7.a(this.n);
            }
         }
      }

      G var17 = new G();
      var17.a(this.v);
      var17.a(this.q);
      Rectangle2D var18 = ae.a(this.n, this.n.o());
      y.d.t var20 = new y.d.t(var18.getCenterX(), var18.getCenterY());
      double var21 = var20.a();
      double var8 = var20.b();
      y.c.x var10 = this.n.o();

      label38: {
         while(true) {
            if(var10.f()) {
               y.c.q var11 = var10.e();
               this.n.d(var11, -var21, -var8);
               var10.g();
               if(var16 != 0) {
                  break;
               }

               if(var16 == 0) {
                  continue;
               }
            }

            if(!this.t) {
               var17.a(this.r);
               var17.b(false);
               if(var16 == 0) {
                  break label38;
               }
            }
            break;
         }

         double var22 = var18.getHeight() / 2.0D;
         double var12 = var18.getWidth() / 2.0D;
         double var14 = Math.sqrt(var22 * var22 + var12 * var12);
         var17.a(var14);
         var17.b(false);
      }

      if(!this.q) {
         var17.b(this.o);
      }

      var17.c(this.n);
      this.D = var17.a();
      return var17.b();
   }

   private double a(ay var1, double var2, int var4, y.f.e.a.h var5) {
      double var6;
      double var14;
      label13: {
         this.w = this.n.t();
         y.a.p var8 = this.o();
         if(this.t && var8 instanceof g) {
            this.t();
            y.c.q var9 = this.D.b();
            double var10 = ((g)var8).a().a();
            double var12 = ((g)var8).a().b();
            var14 = Math.atan2(this.n.k(var9) - var12, this.n.j(var9) - var10);
            this.a(var14);
            var6 = super.a(this.D.a(), var2);
            if(f.u == 0) {
               break label13;
            }
         }

         this.a(var4, this.n.e());
         double var17 = 3.141592653589793D / (double)this.D.a().k();
         this.a(var17);
         var6 = super.a(this.D.a(), var2);
      }

      this.q();
      this.y = new l(this);
      this.y.b(var6);
      this.y.a(0.2D * var6);
      J var18 = new J(this.y, J.d, 0.0D, 1.0D);
      var18.c(1.0D);
      var18.a(J.c);
      var1.a((ax)var18);
      q var16 = new q(this);
      var1.c(var16);
      var16.b(var6);
      var16.a(0.2D * var6);
      var1.b((double)this.p);
      var1.a((double)this.p);
      var5.a(2.0D);
      var1.a(this.n);
      var1.d((am)var16);
      var1.b((ax)var18);
      this.n.a((y.c.A)this.w);
      var6 = this.s();
      double var11 = Math.max(this.r / 2.0D, (double)this.p);
      this.a(var6, var11);
      this.r();
      y.c.q var13 = this.D.b();
      var14 = Math.atan2(this.n.k(var13), this.n.j(var13));
      this.a(var14);
      var6 = super.a(this.D.a(), var6);
      return var6;
   }

   private double a(ay var1, double var2, y.f.e.a.h var4, double var5) {
      int var28 = f.u;
      if(this.q && this.t) {
         var2 = Math.max(var2, this.s / 6.283185307179586D);
      }

      if(this.q && var2 > this.A) {
         double var7 = this.A / var2;
         y.f.j.a var9 = new y.f.j.a();
         var9.b(var7);
         var9.g(false);
         var9.a(this.n);
         var2 = this.A;
      }

      long var11;
      label67: {
         var4.c(3.0D);
         var1.a(var5);
         var1.b(var5);
         J var29 = new J(new aj(), J.a, 0.0D, Math.max(var5, this.r));
         ((aj)var29.b()).a(var5);
         var29.c(0.25D);
         var29.a(J.j);
         var1.a((ax)var29);
         this.y = new av();
         double var8 = Math.max(var5 / 2.0D, this.r / 2.0D);
         this.y.b(var2 - var8);
         this.y.a(var8);
         J var10 = new J(this.y, J.d, 0.0D, 1.0D);
         var1.a((ax)var10);
         var10.c(1.0D);
         if(this.q && !this.C) {
            var11 = var1.s().e();
            if(var28 == 0) {
               break label67;
            }
         }

         var11 = (long)(1000.0D * Math.pow((double)(this.n.e() - this.D.size()), 0.75D));
      }

      this.a(var1, Math.max(200L, var11));
      var1.a(this.n);
      if(this.q) {
         ar var13 = new ar(42L);
         y.f.e.k var14 = new y.f.e.k(var13, var5);
         var14.c(this.n);
      }

      double var30;
      label60: {
         var30 = var2;
         var2 = this.s();
         this.a(var2, this.r / 2.0D);
         y.c.q var15 = this.D.b();
         double var16 = Math.atan2(this.n.k(var15), this.n.j(var15));
         if(this.q) {
            this.a(var16);
            var2 = super.a(this.D.a(), var2);
            if(var28 == 0) {
               break label60;
            }
         }

         this.a(var16);
         super.b(this.D.a(), 0.0D);
      }

      double var18 = 0.0D;
      y.c.x var20 = this.D.a();

      double var10000;
      while(true) {
         if(var20.f()) {
            y.d.y var21 = this.n.s(var20.e());
            var18 = Math.max(var18, var21.b());
            var10000 = Math.max(var18, var21.a());
            if(var28 != 0) {
               break;
            }

            var18 = var10000;
            var20.g();
            if(var28 == 0) {
               continue;
            }
         }

         var10000 = (var2 - var18) / var30;
         break;
      }

      double var32 = var10000;
      if(var32 > 1.0D) {
         this.e(var32);
      }

      if(this.q) {
         y.c.D var22 = this.c(this.n.o(), var5);
         this.a(var22, var5);
         var30 = var2;
         double var23 = Math.max(var18 / 5.0D, 5.0D);
         int var25 = 0;

         while(!var22.isEmpty() && var25++ < 5) {
            double var26 = var30 + var23;
            this.d(var26 / var30);
            this.a(var22, var5);
            var30 = var26;
            if(var28 != 0) {
               break;
            }
         }
      }

      return var2;
   }

   private void d(double var1) {
      int var9 = f.u;
      y.c.x var3 = this.n.o();

      while(var3.f()) {
         y.c.q var4 = var3.e();
         double var5 = this.n.j(var4);
         double var7 = this.n.k(var4);
         this.n.a(var4, var5 * var1, var7 * var1);
         var3.g();
         if(var9 != 0) {
            break;
         }
      }

   }

   private static y.d.y a(y.d.y var0, double var1) {
      return new y.d.y(var0.c() - var1, var0.d() - var1, var0.a() + 2.0D * var1, var0.b() + 2.0D * var1);
   }

   private void a(y.c.D var1, double var2) {
      int var6 = f.u;
      y.c.C var4 = var1.m();

      while(var4.f()) {
         p var5 = (p)var4.d();
         if(!var5.a(var2)) {
            var1.b(var4);
         }

         var4.g();
         if(var6 != 0) {
            break;
         }
      }

   }

   private y.c.D c(y.c.x var1, double var2) {
      int var8 = f.u;
      y.c.D var4 = new y.c.D();
      double var5 = var2 * 0.5D;

      while(var1.f()) {
         y.c.q var7 = var1.e();
         var4.add(new m(var7, a(this.n.s(var7), var5)));
         var1.g();
         if(var8 != 0) {
            break;
         }
      }

      o var9 = new o(this);
      y.d.f.a(var4, var9);
      return var9.a();
   }

   private void a(int var1, int var2) {
      y.c.A var3;
      int var4;
      int var16;
      j var10000;
      label127: {
         var16 = f.u;
         var3 = this.n.t();
         var4 = this.n.e();
         if(this.x != null) {
            Iterator var5 = this.x.iterator();

            while(var5.hasNext()) {
               y.c.q var6 = (y.c.q)var5.next();
               var10000 = this;
               if(var16 != 0) {
                  break label127;
               }

               this.v.a(var6, true);
               if(var16 != 0) {
                  break;
               }
            }
         }

         var10000 = this;
      }

      y.c.q[] var17 = var10000.B.e();
      y.c.A var18 = this.n.t();
      int var7 = 0;
      y.c.x var8 = this.B.a();

      while(var8.f()) {
         y.c.q var9 = var8.e();
         var18.a(var9, var7);
         var8.g();
         ++var7;
         if(var16 != 0) {
            break;
         }
      }

      boolean var19 = y.a.A.b(this.n);
      int var20 = 0;

      int var26;
      byte var27;
      label107:
      while(true) {
         var26 = var20;
         int var10001 = var17.length;

         label104:
         while(var26 < var10001) {
            y.c.q var10 = var17[var20];
            var27 = this.v.d(var10);
            if(var16 != 0) {
               break label107;
            }

            label133: {
               if(var27 != 0) {
                  var3.a(var10, -1);
                  if(var16 == 0) {
                     break label133;
                  }
               }

               if(var19 && var10.a() == 1) {
                  var3.a(var10, 0);
                  if(var16 == 0) {
                     break label133;
                  }
               }

               int var11 = 0;
               y.c.e var12 = var10.j();

               while(var12.f()) {
                  y.c.d var13 = var12.a();
                  int var14 = var18.a(var13.a(var10));
                  var26 = var20;
                  var10001 = var14;
                  if(var16 != 0) {
                     continue label104;
                  }

                  int var15;
                  label87: {
                     if(var20 > var14) {
                        var15 = Math.min(var20 - var14, var14 + var4 - var20) - 1;
                        if(var16 == 0) {
                           break label87;
                        }
                     }

                     var15 = Math.min(var14 - var20, var4 + var20 - var14) - 1;
                  }

                  var11 += var15;
                  var12.g();
                  if(var16 != 0) {
                     break;
                  }
               }

               var3.a(var10, var11);
            }

            ++var20;
            if(var16 == 0) {
               continue label107;
            }
            break;
         }

         y.g.e.a((Object[])var17, y.g.e.b(var3));
         var20 = 0;
         var27 = 0;
         break;
      }

      int var21 = var27;

      while(var21 < var2) {
         y.c.q var23 = var17[var21];
         if(var20 < var1 || var3.a(var23) <= 0) {
            this.v.a(var23, true);
            ++var20;
         }

         ++var21;
         if(var16 != 0) {
            break;
         }
      }

      y.c.y var22 = new y.c.y();
      y.c.x var24 = this.B.a();

      while(true) {
         if(var24.f()) {
            y.c.q var25 = var24.e();
            var26 = this.v.d(var25);
            if(var16 != 0) {
               break;
            }

            if(var26 != 0) {
               var22.add(var25);
            }

            var24.g();
            if(var16 == 0) {
               continue;
            }
         }

         this.D = var22;
         var26 = this.D.size();
         break;
      }

      if(var26 <= var2) {
         this.r();
      }

      this.n.a((y.c.A)var3);
      this.n.a((y.c.A)var18);
   }

   private void r() {
      int var10 = f.u;
      if(this.D.size() < this.z) {
         y.c.y var1 = new y.c.y();
         y.c.x var2 = this.n.o();

         while(true) {
            boolean var10000;
            if(var2.f()) {
               y.c.q var3 = var2.e();
               var10000 = this.v.d(var3);
               if(var10 == 0) {
                  if(!var10000) {
                     var1.add(var3);
                  }

                  var2.g();
                  if(var10 == 0) {
                     continue;
                  }

                  var10000 = false;
               }
            } else {
               var10000 = false;
            }

            while(true) {
               boolean var11 = var10000;
               y.c.x var12 = var1.a();

               label84:
               do {
                  while(true) {
                     if(!var12.f()) {
                        break label84;
                     }

                     y.c.q var4 = var12.e();
                     y.c.y var5 = new y.c.y();
                     y.c.x var14 = var4.m();
                     if(var10 == 0) {
                        y.c.x var6 = var14;

                        y.c.q var7;
                        int var15;
                        while(true) {
                           if(!var6.f()) {
                              var15 = var5.size();
                              break;
                           }

                           var7 = var6.e();
                           var15 = this.v.d(var7);
                           if(var10 != 0) {
                              break;
                           }

                           if(var15 != 0) {
                              var5.add(var7);
                           }

                           var6.g();
                           if(var10 != 0) {
                              var15 = var5.size();
                              break;
                           }
                        }

                        if(var15 == 2) {
                           label99: {
                              y.c.q var13 = var5.b();
                              var7 = var5.c();
                              y.c.p var8 = this.D.d(var13);
                              y.c.p var9 = this.D.d(var7);
                              if(this.D.e(var8) == var9) {
                                 this.D.b(var4, var8);
                                 this.v.a(var4, true);
                                 var1.remove(var4);
                                 var11 = true;
                                 if(var10 == 0) {
                                    break label99;
                                 }
                              }

                              if(this.D.e(var9) == var8) {
                                 this.D.b(var4, var9);
                                 this.v.a(var4, true);
                                 var1.remove(var4);
                                 var11 = true;
                              }
                           }
                        }

                        if(this.D.size() >= this.z) {
                           return;
                        }

                        var12.g();
                        break;
                     }

                     var12 = var14;
                  }
               } while(var10 == 0);

               if(!var11) {
                  return;
               }

               var10000 = false;
            }
         }
      }
   }

   private void e(double var1) {
      int var9 = f.u;
      y.c.x var3 = this.n.o();

      while(var3.f()) {
         y.c.q var4 = var3.e();
         if(!this.v.d(var4)) {
            double var5 = this.n.j(var4);
            double var7 = this.n.k(var4);
            this.n.a(var4, var5 * var1, var7 * var1);
         }

         var3.g();
         if(var9 != 0) {
            break;
         }
      }

   }

   private double s() {
      int var9 = f.u;
      double var1 = 0.0D;
      y.c.x var3 = this.n.o();

      double var10000;
      while(true) {
         if(var3.f()) {
            y.c.q var4 = var3.e();
            double var5 = this.n.j(var4);
            double var7 = this.n.k(var4);
            var10000 = Math.max(var1, Math.sqrt(var5 * var5 + var7 * var7));
            if(var9 != 0) {
               break;
            }

            var1 = var10000;
            var3.g();
            if(var9 == 0) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   private void a(double var1, double var3) {
      int var14 = f.u;
      y.c.y var5 = new y.c.y();
      y.c.x var6 = this.n.o();

      while(true) {
         if(var6.f()) {
            y.c.q var7 = var6.e();
            double var8 = this.n.j(var7);
            double var10 = this.n.k(var7);
            double var12 = Math.sqrt(var8 * var8 + var10 * var10);
            if(var14 != 0) {
               break;
            }

            if(var12 >= var1 - var3) {
               this.v.a(var7, true);
            }

            if(this.v.d(var7)) {
               var5.add(var7);
            }

            var6.g();
            if(var14 == 0) {
               continue;
            }
         }

         y.g.e.a((List)var5, new k(this));
         this.D = var5;
         break;
      }

   }

   void b(y.c.x var1, double var2) {
      label19: {
         this.v = this.n.t();
         this.B = new y.c.y(var1);
         ay var4 = new ay(false);
         y.f.e.a.h var5 = new y.f.e.a.h();
         var4.a((y.f.e.a.p)var5);
         var4.h(true);
         var4.a((am)(new n()));
         var4.a((am)(new r(this)));
         this.z = this.n.e();
         if(!this.C) {
            this.a(8, this.z);
            double var6;
            if(this.n.e() <= 8 || this.n.e() <= this.D.size()) {
               var6 = 3.141592653589793D / (double)this.n.e();
               this.a(var6);
               super.b(this.B.a(), 0.0D);
               this.D = this.B;
               return;
            }

            var6 = 3.141592653589793D / (double)this.D.size();
            this.a(var6);
            super.b(this.D.a(), 0.0D);
            this.q();
            this.a(var4, this.o, var5, this.o / Math.sqrt((double)this.n.e()));
            if(f.u == 0) {
               break label19;
            }
         }

         this.a(var4, var5);
         this.a(var4, this.o, var5, this.o / Math.sqrt((double)this.n.e()));
      }

      this.n.a((y.c.A)this.v);
   }

   void q() {
      int var3 = f.u;
      y.c.x var1 = this.n.o();

      while(var1.f()) {
         y.c.q var2 = var1.e();
         if(!this.v.d(var2)) {
            this.n.a(var2, 0.0D, 0.0D);
         }

         var1.g();
         if(var3 != 0) {
            break;
         }
      }

   }

   private void t() {
      int var22 = f.u;
      y.d.t var1 = this.b(this.n.o());
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = (double)this.n.e();
      y.c.x var8 = this.n.o();

      double var10;
      double var10000;
      while(true) {
         if(var8.f()) {
            y.c.q var9 = var8.e();
            var10 = var1.a(this.n.l(var9));
            var2 += var10;
            var10000 = var4 + var10 * var10;
            if(var22 != 0) {
               break;
            }

            var4 = var10000;
            var8.g();
            if(var22 == 0) {
               continue;
            }
         }

         var10000 = var2 / var6;
         break;
      }

      double var23 = var10000;
      var10 = (var6 * var4 - var2 * var2) / (var6 * (var6 - 1.0D));
      if(var10 < 0.0D) {
         var10 = 0.0D;
      }

      double var12 = Math.sqrt(var10);
      y.c.y var14 = new y.c.y();
      if(var12 > 0.1D) {
         y.c.x var15 = this.n.o();

         while(var15.f()) {
            y.c.q var16 = var15.e();
            double var17 = var1.a(this.n.l(var16));
            if(var17 < var23 - 2.0D * var12 || var17 > var23 + 2.0D * var12) {
               var14.add(var16);
            }

            var15.g();
            if(var22 != 0) {
               break;
            }
         }
      }

      I var24 = new I(this.n);
      var24.a(var14);
      G var25 = new G();
      var25.b(true);
      var25.a(var1);
      var25.a(this.v);
      var25.a(false);
      var25.b(var23);
      var25.a(var23);
      var25.b(true);
      var25.c(this.n);
      y.c.y var26 = var25.a();
      var24.f();
      var1 = this.b(var26.a());
      var2 = 0.0D;
      var6 = (double)var26.size();
      y.c.x var18 = var26.a();

      y.c.q var19;
      double var20;
      while(true) {
         if(var18.f()) {
            var19 = var18.e();
            var20 = var1.a(this.n.l(var19));
            var2 += var20;
            var18.g();
            if(var22 != 0) {
               break;
            }

            if(var22 == 0) {
               continue;
            }
         }

         var23 = var2 / var6;
         break;
      }

      var18 = this.n.o();

      label74:
      while(true) {
         if(var18.f()) {
            var19 = var18.e();
            var20 = var1.a(this.n.l(var19));
            if(var22 != 0) {
               break;
            }

            if(var20 >= var23 - this.r) {
               this.v.a(var19, true);
            }

            var18.g();
            if(var22 == 0) {
               continue;
            }
         }

         if(this.x != null) {
            Iterator var27 = this.x.iterator();

            while(var27.hasNext()) {
               var19 = (y.c.q)var27.next();
               this.v.a(var19, true);
               if(var22 != 0) {
                  break label74;
               }

               if(var22 != 0) {
                  break;
               }
            }
         }

         this.D = new y.c.y();
         break;
      }

      y.a.p var28 = this.o();
      if(var28 instanceof g) {
         ((g)var28).a(new y.d.t(var1.a(), var1.b()));
      }

      this.B = new y.c.y(var28.a(this.n));
      y.c.x var29 = this.B.a();

      while(var29.f()) {
         y.c.q var30 = var29.e();
         if(this.v.d(var30)) {
            this.D.b(var30);
         }

         var29.g();
         if(var22 != 0) {
            break;
         }
      }

   }

   private y.d.t b(y.c.x var1) {
      int var7 = f.u;
      double var2 = 0.0D;
      double var4 = 0.0D;
      var1.i();

      while(true) {
         if(var1.f()) {
            y.c.q var6 = var1.e();
            var2 += this.n.j(var6);
            var4 += this.n.k(var6);
            var1.g();
            if(var7 != 0) {
               break;
            }

            if(var7 == 0) {
               continue;
            }
         }

         var2 /= (double)var1.k();
         var4 /= (double)var1.k();
         break;
      }

      return new y.d.t(var2, var4);
   }

   static y.c.y a(j var0) {
      return var0.D;
   }

   static y.c.A b(j var0) {
      return var0.w;
   }

   static y.c.A c(j var0) {
      return var0.v;
   }

   static av d(j var0) {
      return var0.y;
   }
}
