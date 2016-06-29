package y.f.j;

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import y.c.C;
import y.c.D;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.q;
import y.c.x;
import y.d.t;
import y.d.u;
import y.d.v;
import y.f.I;
import y.f.X;
import y.f.ad;
import y.f.ae;
import y.f.ah;
import y.f.am;
import y.f.c;
import y.f.b.j;

public class a extends c implements ad {
   private int o;
   private double p;
   private boolean q;
   private double r;
   private double s;
   private double t;
   private double u;
   private boolean v;
   private double w;
   private double x;
   private ah y;
   public static boolean n;

   public a() {
      boolean var1 = n;
      super();
      this.o = 3;
      this.p = 0.0D;
      this.q = false;
      this.r = 1.0D;
      this.s = 1.0D;
      this.t = 0.0D;
      this.u = 0.0D;
      this.v = false;
      this.w = 1.41D;
      this.x = 1.0D;
      this.e(false);
      this.b(false);
      this.f(false);
      this.d(false);
      if(var1) {
         i.g = !i.g;
      }

   }

   public void a(ah var1) {
      this.y = var1;
   }

   public ah a() {
      return this.y;
   }

   public void a(int var1) {
      this.o = var1;
      if(var1 != 2) {
         this.v = false;
      }

   }

   public void a(double var1) {
      this.p = var1;
   }

   public void g(boolean var1) {
      this.q = var1;
   }

   public void b(double var1) {
      this.r = this.s = var1;
   }

   public void a(double var1, double var3) {
      this.r = var1;
      this.s = var3;
   }

   public double n() {
      return this.t;
   }

   public double o() {
      return this.u;
   }

   public boolean b(X var1) {
      return true;
   }

   public void a(X var1) {
      boolean var14 = n;
      if(this.a() != null) {
         this.a().c(var1);
      }

      Rectangle var2 = var1.a();
      if(var2.width > 0 && var2.height > 0) {
         boolean var30;
         label196: {
            X var10000;
            label195: {
               label194: {
                  label204: {
                     label205: {
                        x var3;
                        q var4;
                        t var5;
                        t var6;
                        u var8;
                        switch(this.o) {
                        case 0:
                           var3 = var1.o();

                           while(var3.f()) {
                              var4 = var3.e();
                              var5 = var1.l(var4);
                              var1.a(var4, a(var5, var2));
                              var3.g();
                              if(var14) {
                                 break label194;
                              }

                              if(var14) {
                                 break;
                              }
                           }

                           e var15 = var1.p();

                           label173:
                           do {
                              if(!var15.f()) {
                                 break label194;
                              }

                              d var18 = var15.a();
                              var5 = var1.n(var18);
                              var1.a(var18, new t(var5.a(), -var5.b()));
                              var6 = var1.o(var18);
                              var1.b(var18, new t(var6.a(), -var6.b()));
                              ArrayList var7 = new ArrayList();
                              var10000 = var1;
                              if(var14) {
                                 break label195;
                              }

                              var8 = var1.j(var18).b();

                              while(var8.f()) {
                                 var7.add(a(var8.a(), var2));
                                 var8.g();
                                 if(var14) {
                                    continue label173;
                                 }

                                 if(var14) {
                                    break;
                                 }
                              }

                              var1.b(var18, new v(var7));
                              var15.g();
                           } while(!var14);
                        case 1:
                           var3 = var1.o();

                           while(var3.f()) {
                              var4 = var3.e();
                              var5 = var1.l(var4);
                              var1.a(var4, b(var5, var2));
                              var3.g();
                              if(var14) {
                                 break label194;
                              }

                              if(var14) {
                                 break;
                              }
                           }

                           ArrayList var16 = new ArrayList();
                           e var19 = var1.p();

                           label149:
                           do {
                              if(!var19.f()) {
                                 break label194;
                              }

                              d var21 = var19.a();
                              var6 = var1.n(var21);
                              var1.a(var21, new t(-var6.a(), var6.b()));
                              t var23 = var1.o(var21);
                              var1.b(var21, new t(-var23.a(), var23.b()));
                              var16.clear();
                              var10000 = var1;
                              if(var14) {
                                 break label195;
                              }

                              var8 = var1.j(var21).b();

                              while(var8.f()) {
                                 var16.add(b(var8.a(), var2));
                                 var8.g();
                                 if(var14) {
                                    continue label149;
                                 }

                                 if(var14) {
                                    break;
                                 }
                              }

                              var1.b(var21, new v(var16));
                              var19.g();
                           } while(!var14);
                        case 2:
                           break;
                        case 3:
                           break label205;
                        case 4:
                           break label204;
                        default:
                           break label194;
                        }

                        if(this.v) {
                           a(var1, this.w, this.x);
                           if(!var14) {
                              break label194;
                           }
                        }

                        a(var1, this.p, var2);
                        if(!var14) {
                           break label194;
                        }
                     }

                     AffineTransform var17 = new AffineTransform();
                     double var20 = (double)(var2.x + var2.width / 2);
                     double var22 = (double)(var2.y + var2.height / 2);
                     Double var24 = new Double();
                     var17.translate(var20, var22);
                     var17.scale(this.r, this.s);
                     var17.translate(-var20, -var22);
                     x var9 = var1.o();

                     t var13;
                     while(var9.f()) {
                        q var29 = var9.e();

                        q var10;
                        label128:
                        while(true) {
                           var10 = var29;
                           var24.setLocation(var1.j(var10), var1.k(var10));
                           var17.transform(var24, var24);
                           var30 = this.q;
                           if(var14) {
                              break label196;
                           }

                           if(!var30) {
                              break;
                           }

                           var1.b(var10, var1.p(var10) * this.r, var1.q(var10) * this.s);
                           e var11 = var10.j();

                           while(true) {
                              if(!var11.f()) {
                                 break label128;
                              }

                              d var12 = var11.a();
                              var29 = var12.c();
                              if(var14) {
                                 break;
                              }

                              if(var29 == var10) {
                                 var13 = var1.n(var12);
                                 var1.a(var12, new t(var13.a * this.r, var13.b * this.s));
                              }

                              if(var12.d() == var10) {
                                 var13 = var1.o(var12);
                                 var1.b(var12, new t(var13.a * this.r, var13.b * this.s));
                              }

                              var11.g();
                              if(var14) {
                                 break label128;
                              }
                           }
                        }

                        var1.a(var10, var24.getX(), var24.getY());
                        var9.g();
                        if(var14) {
                           break;
                        }
                     }

                     ArrayList var25 = new ArrayList();
                     e var26 = var1.p();

                     label107:
                     do {
                        if(!var26.f()) {
                           break label194;
                        }

                        d var27 = var26.a();
                        var25.clear();
                        var10000 = var1;
                        if(var14) {
                           break label195;
                        }

                        u var28 = var1.j(var27).b();

                        while(var28.f()) {
                           var13 = var28.a();
                           var24.setLocation(var13.a(), var13.b());
                           var17.transform(var24, var24);
                           var25.add(new t(var24.getX(), var24.getY()));
                           var28.g();
                           if(var14) {
                              continue label107;
                           }

                           if(var14) {
                              break;
                           }
                        }

                        var1.b(var27, new v(var25));
                        var26.g();
                     } while(!var14);
                  }

                  ae.a(var1, var1.o(), this.n(), this.o());
               }

               var10000 = var1;
            }

            var30 = y.f.b.c.c((i)var10000);
         }

         if(!var30) {
            (new j()).c(var1);
         }

      }
   }

   private static void a(X var0, double var1, Rectangle var3) {
      boolean var15 = n;
      AffineTransform var4 = new AffineTransform();
      double var5 = (double)(var3.x + var3.width / 2);
      double var7 = (double)(var3.y + var3.height / 2);
      Double var9 = new Double();
      var4.translate(var5, var7);
      var4.rotate(y.d.e.a(var1));
      var4.translate(-var5, -var7);
      x var10 = var0.o();

      while(var10.f()) {
         q var11 = var10.e();
         var9.setLocation(var0.j(var11), var0.k(var11));
         var4.transform(var9, var9);
         var0.a(var11, var9.getX(), var9.getY());
         var10.g();
         if(var15) {
            break;
         }
      }

      ArrayList var16 = new ArrayList();
      e var17 = var0.p();

      while(var17.f()) {
         d var12 = var17.a();
         var16.clear();
         u var13 = var0.j(var12).b();

         while(true) {
            if(var13.f()) {
               t var14 = var13.a();
               var9.setLocation(var14.a(), var14.b());
               var4.transform(var9, var9);
               var16.add(new t(var9.getX(), var9.getY()));
               var13.g();
               if(var15) {
                  break;
               }

               if(!var15) {
                  continue;
               }
            }

            var0.b(var12, new v(var16));
            var17.g();
            break;
         }

         if(var15) {
            break;
         }
      }

   }

   public static double a(X var0, double var1, double var3) {
      double var5 = b(var0, var1, var3);
      a(var0, var5, var0.a());
      return var5;
   }

   public static double b(X var0, double var1, double var3) {
      boolean var15 = n;
      if(var0.f() <= 1) {
         return 0.0D;
      } else {
         D var5 = d(var0);
         double var6 = java.lang.Double.MAX_VALUE;
         double var8 = 0.0D;
         double var10 = 0.0D;

         double var10000;
         while(true) {
            if(var10 < 360.0D) {
               y.d.q var12 = a(var5, var10);
               double var13 = Math.abs(var12.a() * var3 - var1 * var12.b());
               var10000 = var13;
               if(var15) {
                  break;
               }

               if(var13 < var6) {
                  var6 = var13;
                  var8 = var10;
               }

               var10 += 10.0D;
               if(!var15) {
                  continue;
               }
            }

            var10000 = var8;
            break;
         }

         return var10000;
      }
   }

   public static void a(X var0, double var1, double var3, double var5, double var7) {
      boolean var36 = n;
      java.awt.geom.Rectangle2D.Double var9 = new java.awt.geom.Rectangle2D.Double(var1, var3, var5, var7);
      if(var0.e() != 0) {
         double var10 = java.lang.Double.MAX_VALUE;
         double var12 = java.lang.Double.MAX_VALUE;
         double var14 = -1.7976931348623157E308D;
         double var16 = -1.7976931348623157E308D;
         x var18 = var0.o();

         double var10000;
         double var10001;
         while(true) {
            if(var18.f()) {
               q var19 = var18.e();
               var10000 = var0.p(var19);
               var10001 = var5;
               if(var36) {
                  break;
               }

               if(var10000 > var5 || var0.q(var19) > var7) {
                  return;
               }

               var10 = Math.min(var10, var0.j(var19));
               var12 = Math.min(var12, var0.k(var19));
               var14 = Math.max(var14, var0.j(var19));
               var16 = Math.max(var16, var0.k(var19));
               var18.g();
               if(!var36) {
                  continue;
               }
            }

            var10000 = var10;
            var10001 = (var14 - var10) / 2.0D;
            break;
         }

         double var39 = var10000 + var10001;
         double var20 = var12 + (var16 - var12) / 2.0D;
         var5 /= 2.0D;
         var7 /= 2.0D;
         double var22 = 1.0D;
         double var24 = 1.0D;
         x var34 = var0.o();

         label38: {
            while(true) {
               if(var34.f()) {
                  q var35 = var34.e();
                  double var26 = Math.abs(var39 - var0.j(var35));
                  double var28 = Math.abs(var20 - var0.k(var35));
                  double var30 = var5 - var0.p(var35) / 2.0D;
                  double var32 = var7 - var0.q(var35) / 2.0D;
                  var22 = Math.min(var22, var30 / var26);
                  var24 = Math.min(var24, var32 / var28);
                  var34.g();
                  if(var36) {
                     break;
                  }

                  if(!var36) {
                     continue;
                  }
               }

               if(var22 >= 1.0D && var24 >= 1.0D) {
                  break label38;
               }
               break;
            }

            a var37 = new a();
            var37.a(3);
            var37.a(var22, var24);
            var37.g(false);
            var37.a(var0);
         }

         Rectangle2D var38 = ae.a(var0, var0.o(), var0.p());
         if(!var9.contains(var38)) {
            ae.a(var0, var0.o(), var9.getCenterX() - var38.getCenterX(), var9.getCenterY() - var38.getCenterY());
         }

      }
   }

   public static void c(X var0, double var1, double var3) {
      boolean var10 = n;
      x var5 = var0.o();

      while(var5.f()) {
         q var6 = var5.e();
         var0.a(var6, var0.j(var6) + var1, var0.k(var6) + var3);
         var5.g();
         if(var10) {
            break;
         }
      }

      ArrayList var11 = new ArrayList();
      e var12 = var0.p();

      while(var12.f()) {
         d var7 = var12.a();
         var11.clear();
         u var8 = var0.j(var7).b();

         while(true) {
            if(var8.f()) {
               t var9 = var8.a();
               var11.add(new t(var9.a + var1, var9.b + var3));
               var8.g();
               if(var10) {
                  break;
               }

               if(!var10) {
                  continue;
               }
            }

            var0.b(var7, new v(var11));
            var12.g();
            break;
         }

         if(var10) {
            break;
         }
      }

   }

   private static t a(t var0, Rectangle var1) {
      return new t(var0.a, (double)(2 * var1.y + var1.height) - var0.b);
   }

   private static t b(t var0, Rectangle var1) {
      return new t((double)(2 * var1.x + var1.width) - var0.a, var0.b);
   }

   private static D d(X var0) {
      boolean var5 = n;
      D var1 = new D();
      x var2 = var0.o();

      X var10000;
      while(true) {
         if(var2.f()) {
            var10000 = var0;
            if(var5) {
               break;
            }

            am var3 = var0.h(var2.e());
            var1.add(new t(var3.getX() + var3.getWidth() / 2.0D, var3.getY() + var3.getHeight() / 2.0D));
            var2.g();
            if(!var5) {
               continue;
            }
         }

         var10000 = var0;
         break;
      }

      e var6 = var10000.p();

      while(var6.f()) {
         I var7 = var0.g(var6.a());
         int var4 = 0;

         while(true) {
            if(var4 < var7.pointCount()) {
               var1.add(var7.getPoint(var4));
               ++var4;
               if(var5) {
                  break;
               }

               if(!var5) {
                  continue;
               }
            }

            var6.g();
            break;
         }

         if(var5) {
            break;
         }
      }

      return y.d.e.a(var1);
   }

   private static y.d.q a(D var0, double var1) {
      boolean var21 = n;
      var1 = y.d.e.a(var1);
      double var3 = java.lang.Double.MAX_VALUE;
      double var5 = -1.7976931348623157E308D;
      double var7 = java.lang.Double.MAX_VALUE;
      double var9 = -1.7976931348623157E308D;
      double var11 = Math.cos(var1);
      double var13 = Math.sin(var1);
      C var15 = var0.m();

      while(var15.f()) {
         t var16 = (t)var15.d();
         double var17 = var16.a() * var11 - var16.b() * var13;
         double var19 = var16.a() * var13 + var16.b() * var11;
         if(var17 < var3) {
            var3 = var17;
         }

         if(var19 < var7) {
            var7 = var19;
         }

         if(var17 > var5) {
            var5 = var17;
         }

         if(var19 > var9) {
            var9 = var19;
         }

         var15.g();
         if(var21) {
            break;
         }
      }

      return new y.d.q(var5 - var3, var9 - var7);
   }
}
