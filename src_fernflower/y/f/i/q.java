package y.f.i;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.Iterator;
import y.f.i.r;
import y.f.i.s;
import y.f.i.t;
import y.f.i.u;
import y.f.i.v;

public class q implements y.f.ad {
   private y.f.ah b;
   private y.f.X c;
   private Double d;
   private double e;
   private ArrayList[][] f;
   private y.c.D g;
   private y.c.D h;
   private double i;
   private double n;
   private double o;
   private double p;
   private int q;
   private int r;
   private int s;
   private y.g.ar t;
   private double u;
   private double v;
   private double w;
   private double x;
   private int y;
   private int z;
   public static final Object a = "y.layout.router.OrganicEdgeRouter.ROUTE_EDGE_DPKEY";
   private double A;
   private boolean B;
   private boolean C;
   private boolean D;
   private ArrayList E;

   public q() {
      this(10.0D);
   }

   public q(double var1) {
      this.D = true;
      this.A = var1;
   }

   public void c(y.f.X var1) {
      int var9 = v.f;
      boolean var2 = false;
      if(var1.c("y.layout.router.ORGANIC_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY") == null) {
         this.a(var1);
         var1.a((Object)"y.layout.router.ORGANIC_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY", (y.c.c)y.g.q.a((Object)Boolean.TRUE));
         var2 = true;
      }

      if(this.b != null) {
         this.b.c(var1);
      }

      y.g.I var3 = new y.g.I(var1);
      y.c.h var4 = var1.u();
      y.c.y var5 = null;
      if(this.D) {
         var5 = this.a(var1, var4, var3);
      }

      this.E = new ArrayList(var1.f());
      y.c.c var6 = null;
      if(this.b(var1)) {
         label66: {
            var6 = var1.c(a);
            y.c.e var7 = var1.p();

            while(var7.f()) {
               y.c.d var8 = var7.a();
               if(var9 != 0) {
                  break label66;
               }

               if(var6 == null || var6.d(var8)) {
                  if(!this.B) {
                     y.f.ae.a(var1, var8);
                  }

                  this.a(var8);
                  if(this.a(var1.l(var8))) {
                     y.f.ae.a(var1, var8);
                  }
               }

               var7.g();
               if(var9 != 0) {
                  break;
               }
            }

            this.c();
         }
      }

      if(this.D) {
         this.a(var5, var1, var4, var3);
      }

      var1.a((y.c.h)var4);
      y.f.aN var10 = new y.f.aN();
      var10.a((byte)1);
      if(var6 != null) {
         var1.a((Object)y.f.aN.a, (y.c.c)y.g.q.a(var6));
      }

      var10.c(var1);
      if(var6 != null) {
         var1.d_(y.f.aN.a);
      }

      if(var2) {
         var1.d_("y.layout.router.ORGANIC_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY");
      }

   }

   private boolean a(y.d.v var1) {
      int var14 = v.f;
      byte var2 = 0;
      y.d.t[] var3 = var1.f();
      int var10000;
      if(var3.length > 2) {
         int var7 = 0;

         while(var7 < var3.length - 2) {
            y.d.t var4 = var3[var7];
            y.d.t var5 = var3[var7 + 1];
            y.d.t var6 = var3[var7 + 2];
            y.d.z var8 = new y.d.z(var4, var5);
            y.d.z var9 = new y.d.z(var5, var6);
            double var10 = y.d.z.d(var8, var9);
            double var12 = var10 * 180.0D / 3.141592653589793D;
            double var15;
            var10000 = (var15 = var12 - 90.0D) == 0.0D?0:(var15 < 0.0D?-1:1);
            if(var14 != 0) {
               return (boolean)var10000;
            }

            if(var10000 > 0 && var12 < 270.0D) {
               var2 = 1;
               if(var14 == 0) {
                  break;
               }
            }

            ++var7;
            if(var14 != 0) {
               break;
            }
         }
      }

      var10000 = var2;
      return (boolean)var10000;
   }

   private void a(y.f.X var1) {
      this.a((y.c.n)var1, (y.f.O)var1);
   }

   private void a(y.c.n var1, y.f.O var2) {
      int var6 = v.f;
      y.c.c var3 = var1.c(y.f.b.f.d);
      if(var3 == null) {
         var3 = y.g.q.a((Object)Boolean.FALSE);
      }

      Iterator var4 = var1.x();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         if(!var3.d(var5)) {
            this.a(var2, var5);
            if(var6 == 0) {
               continue;
            }
         }

         this.b(var2, var5);
         if(var6 != 0) {
            break;
         }
      }

   }

   protected void a(y.f.O var1, Object var2) {
      y.f.am var3 = var1.a(var2);
      if(var3.getWidth() == 0.0D || var3.getHeight() == 0.0D) {
         throw new IllegalArgumentException("Graph contains nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
      }
   }

   protected void b(y.f.O var1, Object var2) {
      y.f.am var3 = var1.a(var2);
      if(var3.getWidth() == 0.0D || var3.getHeight() == 0.0D) {
         throw new IllegalArgumentException("Graph contains group nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
      }
   }

   private void a(y.c.y var1, y.f.X var2, y.c.h var3, y.g.I var4) {
      int var11 = v.f;
      if(var1 != null) {
         var4.f();
         y.c.x var5 = var1.a();

         while(var5.f()) {
            y.c.q var6 = var5.e();
            y.c.e var7 = var6.j();

            while(true) {
               if(var7.f()) {
                  y.c.d var8 = var7.a();
                  y.d.v var9 = var2.l(var8);
                  y.c.d var10 = (y.c.d)var3.b(var8);
                  var2.a(var10, var9);
                  var7.g();
                  if(var11 != 0) {
                     break;
                  }

                  if(var11 == 0) {
                     continue;
                  }
               }

               var2.a((y.c.q)var6);
               var5.g();
               break;
            }

            if(var11 != 0) {
               break;
            }
         }

      }
   }

   private y.c.q b(y.c.y var1, y.f.X var2, y.c.h var3, y.g.I var4) {
      int var16 = v.f;
      if(var1.size() < 2) {
         return null;
      } else {
         y.c.q var5 = var2.d();
         double var6 = 0.0D;
         double var8 = 0.0D;
         y.c.x var10 = var1.a();

         y.c.q var11;
         while(true) {
            if(var10.f()) {
               var11 = var10.e();
               var6 = Math.max(var6, var2.p(var11));
               var8 = Math.max(var8, var2.q(var11));
               var10.g();
               if(var16 != 0) {
                  break;
               }

               if(var16 == 0) {
                  continue;
               }
            }

            var2.b(var5, var6, var8);
            var2.a(var5, var2.l(var1.b()));
            break;
         }

         var10 = var1.a();

         y.c.q var10000;
         while(true) {
            if(var10.f()) {
               var11 = var10.e();
               var10000 = var11;
               if(var16 != 0) {
                  break;
               }

               y.c.e var12 = var11.j();

               while(var12.f()) {
                  y.c.d var13 = var12.a();
                  y.d.v var14 = var2.l(var13);
                  var10000 = var13.c();
                  if(var16 != 0) {
                     return var10000;
                  }

                  y.c.d var15 = var10000 == var11?var2.a((y.c.q)var5, (y.c.q)var13.d()):var2.a((y.c.q)var13.c(), (y.c.q)var5);
                  var2.a(var15, var14);
                  var3.a(var15, var13);
                  var4.a(var13);
                  var12.g();
                  if(var16 != 0) {
                     break;
                  }
               }

               var4.a(var11);
               var10.g();
               if(var16 == 0) {
                  continue;
               }
            }

            var10000 = var5;
            break;
         }

         return var10000;
      }
   }

   private y.c.y a(y.f.X var1, y.c.h var2, y.g.I var3) {
      int var12 = v.f;
      y.c.y var4 = new y.c.y();
      if(var1.f() < 2) {
         return var4;
      } else {
         y.c.q[] var5 = var1.m();
         y.g.e.a((Object[])var5, new t(var1));
         y.d.t var6 = var1.l(var5[0]);
         y.c.y var7 = new y.c.y(var5[0]);
         int var8 = 1;

         while(var8 < var5.length) {
            label33: {
               y.c.q var9 = var5[var8];
               y.d.t var10 = var1.l(var9);
               if(var6.equals(var10)) {
                  var7.add(var9);
                  if(var12 == 0) {
                     break label33;
                  }
               }

               if(var7.size() > 1) {
                  y.c.q var11 = this.b(var7, var1, var2, var3);
                  var4.add(var11);
               }

               var6 = var10;
               var7.clear();
               var7.add(var9);
            }

            ++var8;
            if(var12 != 0) {
               break;
            }
         }

         return var4;
      }
   }

   private boolean b(y.f.X var1) {
      int var8 = v.f;
      this.c = var1;
      this.g = new y.c.D();
      this.h = new y.c.D();
      this.d = new Double();
      Rectangle var2 = var1.a();
      this.d.setFrame((double)var2.x, (double)var2.y, (double)var2.width, (double)var2.height);
      this.t = new y.g.ar(42L);
      int var3 = 1 + var1.e();
      this.q = Math.max(1, (int)Math.ceil(Math.sqrt((double)var3) * this.d.width / this.d.height));
      this.r = Math.max(1, (int)Math.ceil((double)var3 / (double)this.q));
      this.o = this.d.width / (double)this.q;
      this.p = this.d.height / (double)this.r;
      this.f = new ArrayList[this.r][this.q];
      int var4 = 5 + var1.e() / (4 * this.r * this.q);
      int var5 = this.r - 1;

      while(var5 >= 0) {
         ArrayList[] var6 = this.f[var5];
         int var7 = this.q - 1;

         while(true) {
            if(var7 >= 0) {
               var6[var7] = new ArrayList(var4);
               --var7;
               if(var8 != 0) {
                  break;
               }

               if(var8 == 0) {
                  continue;
               }
            }

            --var5;
            break;
         }

         if(var8 != 0) {
            break;
         }
      }

      y.c.x var9 = var1.o();

      while(true) {
         if(var9.f()) {
            y.c.q var10 = var9.e();
            y.f.am var11 = var1.a((Object)var10);
            this.a(var10.d(), var11.getX(), var11.getY(), var11.getWidth(), var11.getHeight(), this.A);
            var9.g();
            if(var8 != 0) {
               break;
            }

            if(var8 == 0) {
               continue;
            }
         }

         if(this.D) {
            this.b();
         }

         this.a(this.A);
         this.s = 0;
         break;
      }

      return var1 != null;
   }

   private void b() {
      int var15 = v.f;
      int var1 = 0;

      do {
         int var10000 = var1;

         label29:
         while(true) {
            if(var10000 >= this.E.size()) {
               return;
            }

            u var2 = (u)this.E.get(var1);
            int var3 = var1 + 1;

            while(true) {
               if(var3 >= this.E.size()) {
                  break label29;
               }

               u var4 = (u)this.E.get(var3);
               double var5 = y.d.t.a(var2.a, var2.b, var4.a, var4.b);
               double var7 = var2.e + var4.e + 3.0D;
               double var16;
               var10000 = (var16 = var5 - var7) == 0.0D?0:(var16 < 0.0D?-1:1);
               if(var15 != 0) {
                  break;
               }

               if(var10000 < 0) {
                  double var9 = var5 / var7;
                  double var11 = var2.e * var9;
                  double var13 = var4.e * var9;
                  var2.d = Math.min(var2.d, var11);
                  var4.d = Math.min(var4.d, var13);
               }

               ++var3;
               if(var15 != 0) {
                  break label29;
               }
            }
         }

         ++var1;
      } while(var15 == 0);

   }

   private void a(int var1, double var2, double var4, double var6, double var8, double var10) {
      double var16 = Math.sqrt(var6 * var6 + var8 * var8) * 0.5D + var10;
      u var18 = new u(var1, var2 + var6 / 2.0D, var4 + var8 / 2.0D, var16, 2.0D);
      this.E.add(var18);
      this.a(var18);
   }

   private void a(u var1) {
      int var9 = v.f;
      int var2 = Math.max(0, (int)((var1.a - var1.d - this.d.x) / this.o));
      int var3 = Math.max(0, (int)((var1.b - var1.d - this.d.y) / this.p));
      int var4 = Math.min(this.q - 1, (int)((var1.a + var1.d - this.d.x) / this.o));
      int var5 = Math.min(this.r - 1, (int)((var1.b + var1.d - this.d.y) / this.p));
      int var6 = var3;

      while(var6 <= var5) {
         ArrayList[] var7 = this.f[var6];
         int var8 = var2;

         while(true) {
            if(var8 <= var4) {
               var7[var8].add(var1);
               ++var8;
               if(var9 != 0) {
                  break;
               }

               if(var9 == 0) {
                  continue;
               }
            }

            ++var6;
            break;
         }

         if(var9 != 0) {
            break;
         }
      }

   }

   private boolean a(double var1, double var3, double var5, double var7, int var9, int var10) {
      int var49 = v.f;
      double var11 = var5 - var1;
      double var13 = var7 - var3;
      double var15 = Math.sqrt(var11 * var11 + var13 * var13);
      int var17 = (int)Math.floor((Math.min(var1, var5) - this.d.x - this.x) / this.o);
      int var18 = (int)Math.floor((Math.min(var3, var7) - this.d.y - this.x) / this.p);
      int var19 = (int)Math.floor((Math.max(var1, var5) - this.d.x + this.x) / this.o) + 1;
      int var20 = (int)Math.floor((Math.max(var3, var7) - this.d.y + this.x) / this.p) + 1;
      var17 = Math.max(0, var17);
      var18 = Math.max(0, var18);
      var19 = Math.min(var19, this.f[0].length);
      var20 = Math.min(var20, this.f.length);
      ++this.s;
      int var21 = var18;

      label77:
      while(true) {
         int var10000 = var21;

         label74:
         while(var10000 < var20) {
            ArrayList[] var22 = this.f[var21];
            var10000 = var17;
            if(var49 != 0) {
               return (boolean)var10000;
            }

            int var23 = var17;

            label71:
            do {
               var10000 = var23;
               int var10001 = var19;

               label68:
               while(true) {
                  if(var10000 >= var10001) {
                     break label71;
                  }

                  ArrayList var24 = var22[var23];
                  var10000 = var24.size() - 1;
                  if(var49 != 0) {
                     continue label74;
                  }

                  int var25 = var10000;

                  while(true) {
                     if(var25 < 0) {
                        break label68;
                     }

                     u var26 = (u)var24.get(var25);
                     var10000 = var26.c;
                     var10001 = this.s;
                     if(var49 != 0) {
                        break;
                     }

                     if(var10000 != var10001) {
                        var26.c = this.s;
                        if(var26.g != var9 && var26.g != var10) {
                           double var27 = var26.a - var1;
                           double var29 = var26.b - var3;
                           double var31 = (var27 * var11 + var29 * var13) / var15;
                           double var33 = -var31 / var15;
                           double var35 = var27 + var33 * var11;
                           double var37 = var29 + var33 * var13;
                           double var39 = Math.sqrt(var35 * var35 + var37 * var37);
                           if(var39 <= var26.d) {
                              double var41 = Math.sqrt(var27 * var27 + var29 * var29);
                              if(var41 < var26.d) {
                                 return true;
                              }

                              double var43 = var26.a - var5;
                              double var45 = var26.b - var7;
                              double var47 = Math.sqrt(var43 * var43 + var45 * var45);
                              if(var47 < var26.d) {
                                 return true;
                              }

                              if(var31 >= 0.0D && var31 < var15 && var39 < var26.d) {
                                 return true;
                              }
                           }
                        }
                     }

                     --var25;
                     if(var49 != 0) {
                        break label68;
                     }
                  }
               }

               ++var23;
            } while(var49 == 0);

            ++var21;
            if(var49 == 0) {
               continue label77;
            }
            break;
         }

         var10000 = 0;
         return (boolean)var10000;
      }
   }

   private void a(double var1) {
      this.u = 1.5D + var1 * 0.05D;
      this.A = var1;
      this.v = var1 * 0.6D;
      this.w = 0.1D;
      this.n = 2.0D * var1;
      this.n *= this.n;
      this.i = 0.5D * var1;
      this.i *= this.i;
      this.x = 2.0D * var1 + 100.0D;
   }

   private void c() {
      this.c = null;
      this.g = null;
      this.f = (ArrayList[][])null;
      this.h = null;
   }

   private void a(y.c.d var1) {
      y.f.I var4;
      int var9;
      double var10;
      int var14;
      boolean var10000;
      int var26;
      label174: {
         var26 = v.f;
         y.c.q var2 = var1.c();
         y.c.q var3 = var1.d();
         this.y = var2.d();
         this.z = var3.d();
         var4 = this.c.b(var1);
         this.g.clear();
         y.d.t var5 = var4.getTargetPoint();
         y.f.am var6 = this.c.a((Object)var3);
         y.d.t var7 = new y.d.t(var6.getX() + var6.getWidth() * 0.5D + var5.a, var6.getY() + var6.getHeight() * 0.5D + var5.b);
         var5 = var4.getSourcePoint();
         var6 = this.c.a((Object)var2);
         y.d.t var8 = new y.d.t(var6.getX() + var6.getWidth() * 0.5D + var5.a, var6.getY() + var6.getHeight() * 0.5D + var5.b);
         var9 = 6;
         var10 = this.A;
         this.A = var10 * (double)(1 << var9);
         this.a(this.A);
         this.e = 0.0D;
         s var12 = this.a(var7.a, var7.b);
         var12.i = this.g.b((Object)var12);
         if(var4.pointCount() > 0) {
            y.d.t var13 = new y.d.t(var7.a, var7.b);
            var14 = var4.pointCount() - 1;

            while(var14 >= 0) {
               y.d.t var15 = var4.getPoint(var14);
               var10000 = this.D;
               if(var26 != 0) {
                  break label174;
               }

               if(!var10000 || y.d.t.a(var13, var15) >= var10 + 20.0D) {
                  var12 = this.a(var15.a, var15.b);
                  var12.i = this.g.a((Object)var12);
                  var13 = var15;
               }

               --var14;
               if(var26 != 0) {
                  break;
               }
            }
         }

         var12 = this.a(var8.a, var8.b);
         var12.i = this.g.a((Object)var12);
         var10000 = false;
      }

      y.c.p var28;
      y.c.p var30;
      s var31;
      label157: {
         boolean var27;
         label178: {
            var27 = var10000;
            if(this.C) {
               var27 = true;
               if(var26 == 0) {
                  break label178;
               }
            }

            var28 = this.g.l();
            var30 = this.g.k();

            while(var30 != var28) {
               var31 = (s)var30.c();
               s var16 = (s)var30.a().c();
               var27 = this.a(var31.b, var31.c, var16.b, var16.c, this.y, this.z);
               var10000 = var27;
               if(var26 != 0) {
                  break label157;
               }

               if(var27) {
                  break;
               }

               var30 = var30.a();
               if(var26 != 0) {
                  break;
               }
            }
         }

         var10000 = var27;
      }

      int var34;
      label186: {
         if(var10000) {
            label138:
            while(true) {
               if(this.g.size() < 8) {
                  var34 = var9;
                  if(var26 != 0) {
                     break label186;
                  }

                  if(var9 > 0) {
                     --var9;
                     this.A = var10 * (double)(1 << var9);
                     this.a(this.A);
                     this.c(this.A);
                     if(var26 == 0) {
                        continue;
                     }
                  }
               }

               r var29 = new r();
               this.b(this.u);
               var14 = Math.max(var9, 1);
               boolean var32 = true;
               double var33 = Math.max(10.0D, var10 * 0.2D);

               label128:
               while(true) {
                  if(var10 * (double)(1 << var14) <= var33 || var14 < 0) {
                     break label138;
                  }

                  if(!var32) {
                     this.A = var10 * (double)(1 << var14);
                     this.a(this.A);
                     this.c(this.A);
                     this.b(this.u);
                  }

                  var32 = false;
                  --var14;
                  int var18 = 150 - var14 * 20;
                  int var19 = 30;

                  while(true) {
                     while(true) {
                        label117:
                        while(true) {
                           if(var19-- <= 0) {
                              if(var18-- <= 0) {
                                 continue label128;
                              }

                              double var35;
                              var34 = (var35 = this.e / (double)this.g.size() - 1.2D * (double)(var14 + 2)) == 0.0D?0:(var35 < 0.0D?-1:1);
                              if(var26 != 0) {
                                 break label186;
                              }

                              if(var34 < 0) {
                                 continue label128;
                              }
                           }

                           if(this.g.size() <= 2) {
                              break;
                           }

                           y.c.p var20 = this.g.l();
                           s var21 = (s)this.g.k().c();
                           var21.l = var21.m = var21.n = 0.0D;
                           y.c.p var22 = this.g.k().a();

                           s var23;
                           while(true) {
                              if(var22 != null) {
                                 var23 = (s)var22.c();
                                 this.b(var23);
                                 var22 = var22.a();
                                 if(var26 != 0) {
                                    break;
                                 }

                                 if(var26 == 0) {
                                    continue;
                                 }
                              }

                              var22 = this.g.k().a();
                              break;
                           }

                           while(true) {
                              if(var22 != var20) {
                                 var23 = (s)var22.c();
                                 double var24 = this.a(var23, var29);
                                 this.a(var23, var29, var24);
                                 var22 = var22.a();
                                 if(var26 != 0) {
                                    break;
                                 }

                                 if(var26 == 0) {
                                    continue;
                                 }
                              }

                              var22 = this.g.k().a();
                              break;
                           }

                           while(true) {
                              if(var22 == var20) {
                                 break label117;
                              }

                              var23 = (s)var22.c();
                              this.c(var23);
                              var22 = var22.a();
                              if(var26 != 0) {
                                 break;
                              }

                              if(var26 != 0) {
                                 break label117;
                              }
                           }
                        }

                        while(this.g.size() < 3) {
                           var18 = 0;
                           if(var26 == 0) {
                              if(var26 != 0) {
                                 break label138;
                              }
                              break;
                           }
                        }
                     }
                  }
               }
            }
         }

         var4.clearPoints();
         var34 = this.g.size();
      }

      if(var34 > 2) {
         this.d();
         var28 = this.g.l();
         var30 = this.g.k().a();

         while(var30 != var28) {
            var31 = (s)var30.c();
            var4.addPoint(var31.b, var31.c);
            var30 = var30.a();
            if(var26 != 0) {
               return;
            }

            if(var26 != 0) {
               break;
            }
         }
      }

      this.e();
      this.A = var10;
   }

   private void d() {
      int var31 = v.f;
      if(this.g.size() >= 3) {
         y.c.p var3 = this.g.k();
         s var4 = (s)var3.c();
         double var5 = var4.b;
         double var7 = var4.c;
         var3 = var3.a();
         var4 = (s)var3.c();
         double var9 = var4.b;
         double var11 = var4.c;
         var3 = var3.a();

         while(var3 != null) {
            label21: {
               var4 = (s)var3.c();
               double var13 = var9 - var5;
               double var15 = var11 - var7;
               double var17 = var4.b;
               double var19 = var4.c;
               double var21 = var17 - var5;
               double var23 = var19 - var7;
               double var25 = -(var21 * var13 + var23 * var15) / (var13 * var13 + var15 * var15);
               double var27 = var21 + var25 * var13;
               double var29 = var23 + var25 * var15;
               if(var27 * var27 + var29 * var29 < 0.25D) {
                  this.a((s)this.g.h(var3.b()));
                  var9 = var17;
                  var11 = var19;
                  if(var31 == 0) {
                     break label21;
                  }
               }

               var5 = var9;
               var7 = var11;
               var9 = var17;
               var11 = var19;
            }

            var3 = var3.a();
            if(var31 != 0) {
               break;
            }
         }

      }
   }

   private s a(double var1, double var3) {
      if(this.h.size() > 0) {
         s var5 = (s)this.h.g();
         var5.a();
         var5.b = var1;
         var5.c = var3;
         return var5;
      } else {
         return new s(var1, var3);
      }
   }

   private void a(s var1) {
      this.h.c((Object)var1);
   }

   private void e() {
      this.h.a(this.g);
   }

   private void b(double var1) {
      int var10 = v.f;
      double var3 = 1.0D;
      double var5 = 0.0D;
      y.c.p var7 = this.g.l();
      y.c.p var8 = this.g.k().a();

      while(true) {
         if(var8 != var7) {
            s var9 = (s)var8.c();
            var9.a();
            var9.a = var1;
            var8 = var8.a();
            if(var10 != 0) {
               break;
            }

            if(var10 == 0) {
               continue;
            }
         }

         this.e = 2.4D + (double)(this.g.size() - 2) * var1 * var1;
         break;
      }

   }

   private void c(double var1) {
      int var4 = v.f;
      y.c.p var3 = this.g.k().a();

      while(var3 != null) {
         this.a((s)var3.b().c(), (s)var3.c(), var1);
         var3 = var3.a();
         if(var4 != 0) {
            break;
         }
      }

   }

   private void a(s var1, s var2, double var3) {
      int var22 = v.f;
      double var5 = var2.b - var1.b;
      double var7 = var2.c - var1.c;
      double var9 = Math.sqrt(var5 * var5 + var7 * var7);
      if(var9 > var3) {
         int var11 = Math.min(10, (int)Math.ceil(var9 / var3) - 1);
         double var12 = var5 / (double)(var11 + 1);
         double var14 = var7 / (double)(var11 + 1);
         double var16 = var1.b + var12;
         double var18 = var1.c + var14;
         int var20 = 0;

         while(var20 < var11) {
            s var21 = this.a(var16, var18);
            var21.i = this.g.a((Object)var21, (y.c.p)var2.i);
            var16 += var12;
            var18 += var14;
            ++var20;
            if(var22 != 0) {
               break;
            }
         }
      }

   }

   private void b(s var1) {
      int var71 = v.f;
      ++this.s;
      s var2 = (s)var1.i.b().c();
      double var5 = 0.0D;
      double var3 = 0.0D;
      double var7 = var1.b - var2.b;
      double var9 = var1.c - var2.c;
      double var11 = Math.sqrt(var7 * var7 + var9 * var9);
      if(var11 > 1.0E-6D) {
         double var17 = 1.0D / var11;
         double var13 = var7 * var17;
         double var15 = var9 * var17;
         int var72 = (int)Math.floor((Math.min(var1.b, var2.b) - this.d.x - this.x) / this.o);
         int var18 = (int)Math.floor((Math.min(var1.c, var2.c) - this.d.y - this.x) / this.p);
         int var19 = (int)Math.floor((Math.max(var1.b, var2.b) - this.d.x + this.x) / this.o) + 1;
         int var20 = (int)Math.floor((Math.max(var1.c, var2.c) - this.d.y + this.x) / this.p) + 1;
         var72 = Math.max(0, var72);
         var18 = Math.max(0, var18);
         var19 = Math.min(var19, this.f[0].length);
         var20 = Math.min(var20, this.f.length);
         int var21 = var18;

         label116: {
            label115:
            do {
               int var10000 = var21;

               label112:
               while(true) {
                  if(var10000 >= var20) {
                     break label115;
                  }

                  ArrayList[] var22 = this.f[var21];
                  if(var71 != 0) {
                     break label116;
                  }

                  int var23 = var72;

                  while(true) {
                     var10000 = var23;
                     int var10001 = var19;

                     label107:
                     while(true) {
                        if(var10000 >= var10001) {
                           break label112;
                        }

                        ArrayList var24 = var22[var23];
                        var10000 = var24.size() - 1;
                        if(var71 != 0) {
                           continue label112;
                        }

                        int var25 = var10000;

                        while(true) {
                           if(var25 < 0) {
                              break label107;
                           }

                           u var26 = (u)var24.get(var25);
                           var10000 = var26.c;
                           var10001 = this.s;
                           if(var71 != 0) {
                              break;
                           }

                           if(var10000 != var10001) {
                              var26.c = this.s;
                              if(var26.g != this.y && var26.g != this.z) {
                                 double var27 = var26.a - var2.b;
                                 double var29 = var26.b - var2.c;
                                 double var31 = Math.sqrt(var27 * var27 + var29 * var29);
                                 double var35 = var26.a - var1.b;
                                 double var37 = var26.b - var1.c;
                                 double var33 = Math.sqrt(var35 * var35 + var37 * var37);
                                 if(var11 >= this.x || var31 <= this.x + var26.d || var33 <= this.x + var26.d) {
                                    double var39;
                                    double var41;
                                    double var43;
                                    double var45;
                                    double var51;
                                    double var53;
                                    label101: {
                                       var39 = (var27 * var7 + var29 * var9) / var11;
                                       var51 = -var39 / var11;
                                       double var47 = var27 + var51 * var7;
                                       double var49 = var29 + var51 * var9;
                                       var41 = Math.sqrt(var47 * var47 + var49 * var49);
                                       if(var41 == 0.0D) {
                                          var43 = var15;
                                          var45 = -var13;
                                          var41 = 1.0E-5D;
                                          if(var71 == 0) {
                                             break label101;
                                          }
                                       }

                                       var53 = -1.0D / var41;
                                       var43 = var47 * var53;
                                       var45 = var49 * var53;
                                    }

                                    label96: {
                                       if(var41 > 0.0D) {
                                          if(var39 < 0.0D) {
                                             if(var26.d < var31) {
                                                var51 = -var39 + var39 * var26.d / var31;
                                                var41 *= 1.0D - var26.d / var31;
                                                if(var71 == 0) {
                                                   break label96;
                                                }
                                             }

                                             var51 = -var39 + var39 * 0.999999D;
                                             var41 *= 1.0000000000287557E-6D;
                                             if(var71 == 0) {
                                                break label96;
                                             }
                                          }

                                          if(var39 > var11) {
                                             if(var26.d < var33) {
                                                var51 = -var39 + (var39 - var11) * var26.d / var33;
                                                var41 *= 1.0D - var26.d / var33;
                                                if(var71 == 0) {
                                                   break label96;
                                                }
                                             }

                                             var51 = -var39 + (var39 - var11) * 0.999999D;
                                             var41 *= 1.0000000000287557E-6D;
                                             if(var71 == 0) {
                                                break label96;
                                             }
                                          }

                                          var51 = -var39;
                                          if(var26.d < var41) {
                                             var41 -= var26.d;
                                             if(var71 == 0) {
                                                break label96;
                                             }
                                          }

                                          var41 *= 1.0000000000287557E-6D;
                                          if(var71 == 0) {
                                             break label96;
                                          }
                                       }

                                       var41 = 1.0E-7D * (var41 + var26.d);
                                       var51 = -var39;
                                    }

                                    var53 = var51 + var11;
                                    double var57 = var41 * var41;
                                    double var59 = var51 * var51;
                                    double var61 = var53 * var53;
                                    double var67 = Math.sqrt(var59 + var57);
                                    double var69 = Math.sqrt(var61 + var57);
                                    double var63 = var26.f * (1.0D / var67 - 1.0D / var69);
                                    double var65 = var26.f * var41 * (var53 / (var57 * var69) - var51 / (var57 * var67));
                                    var3 += var13 * var63 + var43 * var65;
                                    var5 += var15 * var63 + var45 * var65;
                                 }
                              }
                           }

                           --var25;
                           if(var71 != 0) {
                              break label107;
                           }
                        }
                     }

                     ++var23;
                     if(var71 != 0) {
                        break label112;
                     }
                  }
               }

               ++var21;
            } while(var71 == 0);

            var2.l += var3;
         }

         var2.m += var5;
      }

      var1.l = var3;
      var1.m = var5;
   }

   private double a(s var1, r var2) {
      s var7 = (s)var1.i.b().c();
      double var8 = var7.b - var1.b;
      double var10 = var7.c - var1.c;
      double var3 = var8 * 3.0D;
      double var5 = var10 * 3.0D;
      var7 = (s)var1.i.a().c();
      var8 = var7.b - var1.b;
      var10 = var7.c - var1.c;
      var3 += var8 * 3.0D;
      var5 += var10 * 3.0D;
      var3 += var1.l;
      var5 += var1.m;
      var3 += this.t.a(-0.5D, 0.5D);
      var5 += this.t.a(-0.5D, 0.5D);
      var2.a = var3;
      var2.b = var5;
      return Math.sqrt(var3 * var3 + var5 * var5);
   }

   private void a(s var1, r var2, double var3) {
      int var9 = v.f;
      if(var3 > 1.0E-5D) {
         double var7;
         label23: {
            var1.g = var1.f;
            var1.j = var1.d;
            var1.k = var1.e;
            var1.d = var2.a;
            var1.e = var2.b;
            var1.f = var3;
            double var5 = var1.d * var1.j + var1.e * var1.k;
            var7 = var5 / (var1.f * var1.g);
            this.e -= var1.a * var1.a;
            if(var1.h * var7 > 0.0D) {
               var1.a += var7 * 0.45D;
               if(var9 == 0) {
                  break label23;
               }
            }

            var1.a += var7 * 0.15D;
         }

         label18: {
            if(var1.a > this.v) {
               var1.a = this.v;
               if(var9 == 0) {
                  break label18;
               }
            }

            if(var1.a < this.w) {
               var1.a = this.w;
            }
         }

         this.e += var1.a * var1.a;
         var1.h = var7;
      }

   }

   private void c(s var1) {
      if(var1.f > 0.0D) {
         double var2 = var1.a / var1.f;
         if(var2 > 0.0D) {
            var1.b += var2 * var1.d;
            var1.c += var2 * var1.e;
         }
      }

   }

   public y.f.ah a() {
      return this.b;
   }

   public void a(y.f.ah var1) {
      this.b = var1;
   }
}
