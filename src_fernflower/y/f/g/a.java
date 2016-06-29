package y.f.g;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import y.f.X;
import y.f.ae;
import y.f.g.b;
import y.f.g.c;
import y.f.g.d;
import y.f.g.u;
import y.f.g.y;
import y.f.g.z;

class a {
   private static double b = 30.0D;
   private double c = 1.0D;
   private double d = 0.0D;
   private double e = Double.MAX_VALUE;
   private double f = 0.0D;
   private double g = 30.0D;
   z a = new z();

   public void a(double var1) {
      this.g = var1;
   }

   public SortedSet a(X var1, y.c.y var2, y.c.y var3, y.c.A var4, Map var5, y.d.t var6, boolean var7, y var8, y.c.A var9, y.c.A var10) {
      Rectangle var11 = var1.a();
      double var12 = var11.getMinX();
      double var14 = var11.getMaxX();
      y.c.f var16 = (y.c.f)var5.get(var2);
      b var17 = this.a(var1, var2, var4, var16, var6, var8, var9, var10);
      Object var18 = null;
      if(var7) {
         var18 = this.a.a(var1, var3, var2, var17, var6, true);
      } else {
         var18 = new TreeSet(u.a);
         u var19 = new u(new y.d.t(var12 - (var14 - var12), var17.f().b()), new y.d.t(var14 + (var14 - var12), var17.f().b()), 0);
         ((SortedSet)var18).add(var19);
      }

      return (SortedSet)var18;
   }

   public b a(X var1, y.c.y var2, y.c.A var3, y.c.f var4, y.d.t var5, y var6, y.c.A var7, y.c.A var8) {
      boolean var58 = d.d;
      Rectangle var9 = var1.a();
      double var10 = var9.getMinX();
      double var12 = var9.getMaxX();
      double var14 = var9.getMinY();
      double var16 = var9.getMaxY();
      double var18 = var16 - var14;
      Rectangle2D var20 = ae.a(var1, var2.a());
      double var21 = var20.getMinY();
      double var30;
      double var35;
      double var37;
      double var42;
      double var69;
      if(var7.d(var2.b())) {
         y.f.b.c var61 = new y.f.b.c(var1);
         y.c.q var63 = var2.b();
         y.c.f var65 = var61.f(var63);
         y.c.f var68 = var61.g(var63);
         if((var65 == null || var65.size() == 0) && (var68 == null || var68.size() == 0)) {
            var65.a(var63.k());
            var68.a(var63.l());
         }

         var69 = var14;
         boolean var70 = false;
         var30 = 0.0D;
         y.c.e var32 = var65.a();

         double var60;
         while(true) {
            if(var32.f()) {
               y.c.d var73 = var32.a();
               var60 = var1.k(var73.c());
               if(var58) {
                  break;
               }

               if(var60 > var69) {
                  var69 = var1.k(var73.c());
                  var70 = true;
                  var30 = var20.getCenterY() - var1.k(var73.d());
               }

               var32.g();
               if(!var58) {
                  continue;
               }
            }

            var60 = var16;
            break;
         }

         double var71 = var60;
         boolean var74 = false;
         var35 = 0.0D;
         y.c.e var75 = var68.a();

         while(true) {
            if(var75.f()) {
               y.c.d var38 = var75.a();
               var60 = var1.k(var38.d());
               if(var58) {
                  break;
               }

               if(var60 < var71) {
                  var71 = var1.k(var38.d());
                  var74 = true;
                  var35 = var20.getCenterY() - var1.k(var38.c());
               }

               var75.g();
               if(!var58) {
                  continue;
               }
            }

            var60 = 0.0D;
            break;
         }

         double var40;
         y.d.q var76;
         label113: {
            var76 = (y.d.q)var8.b(var63);
            var40 = var76.b();
            if(var70 && var74) {
               var37 = var71 - var69;
               if(!var58) {
                  break label113;
               }
            }

            var37 = var40;
         }

         double var53;
         label193: {
            var42 = Math.max(var40, var37);
            y.d.q var44 = new y.d.q(var76.a(), var42);
            var8.a(var63, var44);
            var1.a(var63, var44);
            var53 = 0.0D;
            y.c.c var55 = var1.c(y.f.b.f.e);
            y.d.r var56 = y.d.r.a(var55.b(var63));
            if(var70 && var74) {
               var53 = (var71 - var69) / 2.0D;
               if(!var58) {
                  break label193;
               }
            }

            if(var70 && !var74) {
               var53 = var69 + var44.b() / 2.0D + this.g + var56.a;
               if(!var58) {
                  break label193;
               }
            }

            if(!var70 && var74) {
               var53 = var71 - var44.b() / 2.0D - this.g - var56.c;
            }
         }

         double var45 = var10 - (var12 - var10);
         double var49 = (var12 - var10) * 3.0D;
         b var57 = new b(var45, var53, var49, var42, new y.d.t(var5.a(), var53));
         return var57;
      } else {
         y.c.A var23 = var1.t();
         y.c.x var24 = var2.a();

         while(var24.f()) {
            y.c.q var25 = var24.e();
            double var26 = var1.o(var25).b() - var21;
            var23.a(var25, var26);
            var24.g();
            if(var58) {
               break;
            }
         }

         c[] var62 = new c[var4.size()];
         int var64 = 0;
         y.c.e var66 = var4.a();

         byte var10000;
         while(true) {
            if(var66.f()) {
               y.c.d var27 = var66.a();
               var10000 = var3.d(var27.c());
               if(var58) {
                  break;
               }

               double var28;
               if(var10000 != 0) {
                  var28 = var1.k(var27.c()) + var1.q(var27.c()) / 2.0D + this.g - var23.c(var27.d());
                  var62[var64] = new c(var28, c.a);
               }

               if(var3.d(var27.d())) {
                  var28 = var1.q(var27.c());
                  var30 = var1.k(var27.d()) - var1.q(var27.d()) / 2.0D - this.g - var28 - var23.c(var27.c());
                  var62[var64] = new c(var30, c.b);
               }

               ++var64;
               var66.g();
               if(!var58) {
                  continue;
               }
            }

            var1.a((y.c.A)var23);
            var10000 = 0;
            break;
         }

         int var67 = var10000;
         var69 = 0.0D;
         double var29 = var18;
         double var31 = var18;
         int var33 = 0;

         double var39;
         while(var33 < var62.length) {
            c var59 = var62[var33];

            label163:
            while(var59 != null) {
               double var34 = var62[var33].b();
               int var36 = 0;
               var37 = var18;
               var39 = var18;
               int var41 = 0;

               while(var41 < var62.length) {
                  var59 = var62[var41];
                  if(var58) {
                     continue label163;
                  }

                  if(var59 != null) {
                     if(var62[var41].b() >= var34 && var62[var41].a() == c.b) {
                        var42 = var62[var41].b() - var34;
                        if(var42 < var37) {
                           var37 = var42;
                        }

                        ++var36;
                     }

                     if(var62[var41].b() <= var34 && var62[var41].a() == c.a) {
                        var42 = var34 - var62[var41].b();
                        if(var42 < var39) {
                           var39 = var42;
                        }

                        ++var36;
                     }
                  }

                  ++var41;
                  if(var58) {
                     break;
                  }
               }

               if(var36 > var67) {
                  var67 = var36;
                  var69 = var34;
                  var31 = var39;
                  var29 = var37;
               }
               break;
            }

            ++var33;
            if(var58) {
               break;
            }
         }

         var69 += var20.getHeight() / 2.0D;
         double var72 = var10 - (var12 - var10);
         var37 = (var12 - var10) * 3.0D;
         var35 = var69 - var31;
         var39 = var31 + var29;
         b var77 = new b(var72, var35, var37, var39, new y.d.t(var5.a(), var69));
         if(y.c.i.g) {
            d.d = !var58;
         }

         return var77;
      }
   }
}
