package y.f.i.a;

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D.Double;
import java.util.HashMap;
import y.f.i.a.Z;
import y.f.i.a.aO;
import y.f.i.a.aP;
import y.f.i.a.aQ;
import y.f.i.a.aR;
import y.f.i.a.aS;
import y.f.i.a.aT;
import y.f.i.a.ab;
import y.f.i.a.ac;
import y.f.i.a.w;
import y.f.i.a.x;
import y.f.i.a.y;

class aN {
   private static final double a = Math.sqrt(2.0D);
   private static final Object b = "y.layout.router.polyline.Polyliner.MIN_EDGE_LENGTH_DPKEY";
   private static final Object c = "y.layout.router.polyline.Polyliner.EDGE_WEIGHT_DPKEY";
   private double d;
   private double e;
   private Z f;

   public void a(double var1) {
      this.d = var1;
   }

   public void b(double var1) {
      this.e = var1;
   }

   public void a(y.c.f var1, ac var2, Z var3) {
      int var15 = ab.a;
      this.f = var3;
      y.f.X var4 = var3.a();
      y.c.h var5 = y.g.M.b();
      y.c.D var6 = new y.c.D();
      y.c.D var7 = new y.c.D();
      y.c.e var8 = var1.a();

      label130:
      while(true) {
         boolean var10000 = var8.f();

         label127: {
            y.c.d var9;
            Object var21;
            label126:
            while(true) {
               if(var10000) {
                  var9 = var8.a();
                  w var10 = var2.a(var9);
                  var21 = var10;
                  if(var15 != 0) {
                     break;
                  }

                  if(var10 != null) {
                     aR var11 = new aR(this, var10);
                     var5.a(var9, var11);
                     aS[] var12 = var11.a();
                     int var13 = 0;

                     while(var13 < var12.length) {
                        var10000 = var12[var13].k();
                        if(var15 != 0) {
                           continue label126;
                        }

                        label81: {
                           if(var10000) {
                              var6.add(var12[var13]);
                              if(var15 == 0) {
                                 break label81;
                              }
                           }

                           var7.add(var12[var13]);
                        }

                        ++var13;
                        if(var15 != 0) {
                           break;
                        }
                     }
                  }

                  var8.g();
                  if(var15 == 0) {
                     continue label130;
                  }

                  var8 = var4.p();
                  var10000 = var8.f();
               } else {
                  var8 = var4.p();
                  var10000 = var8.f();
               }

               label124:
               while(true) {
                  if(var10000) {
                     var9 = var8.a();
                     var21 = var5.b(var9);
                     if(var15 != 0) {
                        break label126;
                     }

                     if(var21 == null && y.b(var9, var4)) {
                        y.d.v var16 = var4.l(var9);
                        y.d.m var18 = null;
                        y.d.s var19 = var16.j();

                        while(var19.f()) {
                           y.d.m var20 = var19.a();
                           var10000 = var20.b();
                           if(var15 != 0) {
                              continue label124;
                           }

                           if(var10000 || var20.a()) {
                              if(var18 != null && var18.a() != var20.a()) {
                                 aQ var14 = new aQ(this, var18, var20, var9);
                                 if(var14.k()) {
                                    var6.add(var14);
                                    if(var15 != 0) {
                                       var7.add(var14);
                                    }
                                 } else {
                                    var7.add(var14);
                                 }
                              }

                              var18 = var20;
                           }

                           var19.g();
                           if(var15 != 0) {
                              break;
                           }
                        }
                     }

                     var8.g();
                     if(var15 == 0) {
                        var10000 = var8.f();
                        continue;
                     }
                  }

                  this.a(var4, var6, -45);
                  this.a(var4, var7, 45);
                  var8 = var1.a();
                  if(!var8.f()) {
                     break label127;
                  }

                  var9 = var8.a();
                  var21 = var5.b(var9);
                  break label126;
               }
            }

            while(true) {
               aR var17 = (aR)var21;
               if(var15 != 0) {
                  return;
               }

               if(var17 != null) {
                  var4.b(var9, var17.b());
               }

               var8.g();
               if(var15 != 0 || !var8.f()) {
                  break;
               }

               var9 = var8.a();
               var21 = var5.b(var9);
            }
         }

         this.f = null;
         return;
      }
   }

   private void a(y.f.X var1, y.c.D var2, int var3) {
      int var21 = ab.a;
      if(var2 != null && !var2.isEmpty()) {
         Rectangle var4 = var1.a();
         AffineTransform var5 = new AffineTransform();
         double var6 = (double)(var4.x + var4.width / 2);
         double var8 = (double)(var4.y + var4.height / 2);
         var5.translate(var6, var8);
         var5.rotate(y.d.e.a((double)var3));
         var5.translate(-var6, -var8);
         y.c.i var10 = this.a(var2, var5);
         y.c.A var11 = y.g.M.a();
         y.c.h var12 = (y.c.h)var10.c(b);
         y.c.h var13 = (y.c.h)var10.c(c);
         y.a.u.a(var10, var11, var13, var12);
         y.c.C var14 = var2.m();

         while(var14.f()) {
            aT var15 = (aT)var14.d();
            if(!var15.a()) {
               y.c.q var16 = var15.f;
               y.c.q var17 = var15.e;
               int var18 = Math.abs(var11.a(var16) - var11.a(var17));
               double var19 = (double)var18 * a;
               var15.a(var19);
            }

            var14.g();
            if(var21 != 0) {
               break;
            }
         }

      }
   }

   private y.c.i a(y.c.D var1, AffineTransform var2) {
      int var30 = ab.a;
      y.c.i var3 = new y.c.i();
      y.c.h var4 = y.g.M.b();
      var3.a((Object)b, (y.c.c)var4);
      y.c.h var5 = y.g.M.b();
      var3.a((Object)c, (y.c.c)var5);
      y.c.y var6 = new y.c.y();
      y.c.A var7 = y.g.M.a();
      HashMap var8 = new HashMap();
      Double var9 = new Double();
      y.c.A var10 = y.g.M.a();
      y.c.C var11 = var1.m();

      while(true) {
         if(var11.f()) {
            aT var12 = (aT)var11.d();
            double var13 = var12.b();
            double var15 = var12.c();
            var9.setLocation(var13, var15);
            var2.transform(var9, var9);
            if(var30 != 0) {
               break;
            }

            Integer var17;
            label79: {
               if(var12.i() == 1 || var12.i() == 3) {
                  var17 = new Integer((int)Math.floor(var9.getX()));
                  if(var30 == 0) {
                     break label79;
                  }
               }

               var17 = new Integer((int)Math.ceil(var9.getX()));
            }

            if(!var12.a()) {
               y.c.q var18 = (y.c.q)var8.get(var17);
               if(var18 == null) {
                  var18 = var3.d();
                  var8.put(var17, var18);
                  var7.a(var18, var17.intValue());
                  var6.add(var18);
               }

               var12.e = var18;
            }

            Integer var22;
            label80: {
               double var31 = var12.d();
               double var20 = var12.e();
               var9.setLocation((var13 + var31) / 2.0D, (var15 + var20) / 2.0D);
               var2.transform(var9, var9);
               if(var12.i() == 1 || var12.i() == 3) {
                  var22 = new Integer((int)Math.ceil(var9.getX()));
                  if(var30 == 0) {
                     break label80;
                  }
               }

               var22 = new Integer((int)Math.floor(var9.getX()));
            }

            y.c.q var23 = (y.c.q)var8.get(var22);
            if(var23 == null) {
               var23 = var3.d();
               var8.put(var22, var23);
               var7.a(var23, var22.intValue());
               var6.add(var23);
            }

            label78: {
               y.c.q var24 = var3.d();
               var10.a(var24, var22.intValue());
               var12.f = var24;
               y.c.d var25;
               if(var12.a()) {
                  var25 = var3.a(var23, var24);
                  var5.a(var25, 100000);
                  if(var30 == 0) {
                     break label78;
                  }
               }

               if(var17.intValue() - var22.intValue() == 0) {
                  var25 = var3.a(var12.e, var24);
                  var5.a(var25, 100000);
                  if(var30 == 0) {
                     break label78;
                  }
               }

               y.c.d var26;
               y.c.d var27;
               int var28;
               label46: {
                  y.c.q var32 = var3.d();
                  var28 = var17.intValue() - var22.intValue();
                  if(var28 > 0) {
                     var3.a(var24, var12.e);
                     var3.a(var23, var32);
                     var26 = var3.a(var32, var24);
                     var27 = var3.a(var32, var12.e);
                     if(var30 == 0) {
                        break label46;
                     }
                  }

                  var3.a(var12.e, var24);
                  var3.a(var32, var23);
                  var26 = var3.a(var24, var32);
                  var27 = var3.a(var12.e, var32);
               }

               var5.a(var26, 1);
               int var29 = Math.min((int)Math.ceil(this.e / 2.0D), Math.abs(var28));
               var4.a(var27, var29);
               var5.a(var27, 1);
            }

            var11.g();
            if(var30 == 0) {
               continue;
            }
         }

         this.a(var3, var6, var7);
         this.a(var1, var3, var4, var5, var10);
         break;
      }

      return var3;
   }

   private void a(y.c.i var1, y.c.y var2, y.c.A var3) {
      int var13 = ab.a;
      var2.sort(new aO(this, var3));
      y.c.h var4 = (y.c.h)var1.c(b);
      y.c.h var5 = (y.c.h)var1.c(c);
      y.c.q var6 = null;
      y.c.x var7 = var2.a();

      while(var7.f()) {
         y.c.q var8 = var7.e();
         if(var6 != null) {
            y.c.d var9 = var1.a(var6, var8);
            var5.a(var9, 100000);
            int var10 = var3.a(var8);
            int var11 = var3.a(var6);
            int var12 = var10 - var11;
            var4.a(var9, var12);
         }

         var6 = var8;
         var7.g();
         if(var13 != 0) {
            break;
         }
      }

   }

   private void a(y.c.D var1, y.c.i var2, y.c.h var3, y.c.h var4, y.c.c var5) {
      y.d.f.a(var1, new aP(this, var2, var3, var4, var5));
   }

   private double a(aT var1, aT var2) {
      x var3 = this.f.c().a(var1.j());
      x var4 = this.f.c().a(var2.j());
      return Math.max(var3.c(), var4.c());
   }

   static double a(aN var0, aT var1, aT var2) {
      return var0.a(var1, var2);
   }

   static double a(aN var0) {
      return var0.d;
   }
}
