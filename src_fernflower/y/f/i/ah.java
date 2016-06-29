package y.f.i;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.Collection;
import java.util.Iterator;
import y.f.i.v;

class ah {
   public static Rectangle2D a(y.f.X var0, y.c.q var1, y.c.y var2, byte var3) {
      int var14 = v.f;
      Rectangle2D var4 = y.f.ae.a(var0, var2.a());
      Double var5 = new Double();
      double var6;
      double var8;
      double var10;
      double var12;
      switch(var3) {
      case 1:
         var6 = Math.min(var0.m(var1), var4.getX());
         var8 = var4.getY() + var4.getHeight();
         var10 = Math.max(var0.m(var1) + var0.p(var1), var4.getX() + var4.getWidth()) - var6;
         var12 = var0.n(var1) - var8;
         var5.setFrame(var6, var8, var10, var12);
         if(var14 == 0) {
            break;
         }
      case 2:
         var6 = Math.min(var0.m(var1), var4.getX());
         var8 = var0.n(var1) + var0.q(var1);
         var10 = Math.max(var0.m(var1) + var0.p(var1), var4.getX() + var4.getWidth()) - var6;
         var12 = var4.getY() - var8;
         var5.setFrame(var6, var8, var10, var12);
         if(var14 == 0) {
            break;
         }
      case 8:
         var6 = var4.getX() + var4.getWidth();
         var8 = Math.min(var4.getY(), var0.n(var1));
         var10 = var0.m(var1) - (var4.getX() + var4.getWidth());
         var12 = Math.max(var0.n(var1) + var0.q(var1), var4.getY() + var4.getHeight()) - var8;
         var5.setFrame(var6, var8, var10, var12);
         if(var14 == 0) {
            break;
         }
      case 4:
         var6 = var0.m(var1) + var0.p(var1);
         var8 = Math.min(var4.getY(), var0.n(var1));
         var10 = var4.getX() - var6;
         var12 = Math.max(var0.n(var1) + var0.q(var1), var4.getY() + var4.getHeight()) - var8;
         var5.setFrame(var6, var8, var10, var12);
      case 3:
      case 5:
      case 6:
      case 7:
      }

      return var5;
   }

   public static y.c.y a(y.f.X var0, y.c.q var1, y.c.y var2, byte var3, double var4) {
      int var19 = v.f;
      y.f.am var6 = var0.h(var1);
      double var7 = var6.getX();
      double var9 = var6.getY();
      double var11 = var7 + var6.getWidth();
      double var13 = var9 + var6.getHeight();
      y.c.y var15 = new y.c.y();
      y.c.x var16 = var2.a();

      while(var16.f()) {
         y.c.q var17 = var16.e();
         y.f.am var18 = var0.h(var17);
         switch(var3) {
         case 1:
            if(var9 - var4 < var18.getY() + var18.getHeight()) {
               break;
            }

            var15.add(var17);
            if(var19 == 0) {
               break;
            }
         case 2:
            if(var13 + var4 > var18.getY()) {
               break;
            }

            var15.add(var17);
            if(var19 == 0) {
               break;
            }
         case 8:
            if(var7 - var4 < var18.getX() + var18.getWidth()) {
               break;
            }

            var15.add(var17);
            if(var19 == 0) {
               break;
            }
         case 4:
            if(var11 + var4 <= var18.getX()) {
               var15.add(var17);
            }
         case 3:
         case 5:
         case 6:
         case 7:
         }

         var16.g();
         if(var19 != 0) {
            break;
         }
      }

      return var15;
   }

   private static y.f.ax a(y.c.d var0, boolean var1, y.c.i var2) {
      int var9 = v.f;
      Object var3 = var1?y.f.ax.a:y.f.ax.b;
      y.c.c var4 = var2.c(var3);
      if(var4 != null && var4.b(var0) != null) {
         Collection var5 = (Collection)var4.b(var0);
         if(var5.isEmpty()) {
            return null;
         } else {
            y.f.ax var6 = null;
            Iterator var7 = var5.iterator();

            y.f.ax var10000;
            while(true) {
               if(var7.hasNext()) {
                  y.f.ax var8 = (y.f.ax)var7.next();
                  if(var6 == null) {
                     var6 = var8;
                  }

                  if(var8.b()) {
                     continue;
                  }

                  var10000 = var8;
                  if(var9 != 0) {
                     break;
                  }

                  var6 = var8;
               }

               var10000 = var6;
               break;
            }

            return var10000;
         }
      } else {
         return null;
      }
   }

   private static boolean a(y.f.ax var0) {
      return var0.a((int)4) && var0.a((int)8) && var0.a((int)1) && var0.a((int)2);
   }

   public static byte a(y.f.X var0, y.c.q var1, y.c.f var2) {
      int var19 = v.f;
      y.f.am var3 = var0.h(var1);
      double var4 = var3.getX();
      double var6 = var3.getY();
      double var8 = var4 + var3.getWidth();
      double var10 = var6 + var3.getHeight();
      double[] var12 = new double[4];
      y.f.ax var13 = a(var2.b(), false, var0);
      if(var13 != null && !a(var13)) {
         if(var13.a((int)1)) {
            ++var12[0];
         }

         if(var13.a((int)4)) {
            ++var12[1];
         }

         if(var13.a((int)8)) {
            ++var12[2];
         }

         if(var13.a((int)4)) {
            ++var12[3];
         }
      }

      y.c.e var14 = var2.a();

      label92: {
         while(true) {
            if(var14.f()) {
               y.c.d var15 = var14.a();
               y.f.ax var16 = a(var15, true, var0);
               if(var19 != 0) {
                  break;
               }

               if(var16 != null && !a(var16)) {
                  if(var16.a((int)2)) {
                     ++var12[0];
                  }

                  if(var16.a((int)1)) {
                     ++var12[1];
                  }

                  if(var16.a((int)4)) {
                     ++var12[2];
                  }

                  if(var16.a((int)8)) {
                     ++var12[3];
                  }
               }

               y.c.q var17 = var15.c();
               y.f.am var18 = var0.h(var17);
               if(var18.getY() + var18.getHeight() < var6) {
                  ++var12[0];
               }

               if(var18.getY() > var10) {
                  ++var12[1];
               }

               if(var18.getX() + var18.getWidth() < var4) {
                  ++var12[2];
               }

               if(var18.getX() > var8) {
                  ++var12[3];
               }

               var14.g();
               if(var19 == 0) {
                  continue;
               }
            }

            if(a(var0, var2)) {
               var12[2] += 0.5D;
               var12[3] += 0.5D;
               if(var19 == 0) {
                  break label92;
               }
            }

            var12[0] += 0.5D;
            break;
         }

         var12[1] += 0.5D;
      }

      double var20 = var12[0];
      byte var21 = 1;
      if(var12[1] > var20) {
         var20 = var12[1];
         var21 = 2;
      }

      if(var12[2] > var20) {
         var20 = var12[2];
         var21 = 8;
      }

      if(var12[3] > var20) {
         var20 = var12[3];
         var21 = 4;
      }

      return var21;
   }

   static boolean a(y.f.X var0, y.c.f var1) {
      int var13 = v.f;
      double var2 = 0.0D;
      double var4 = 0.0D;
      y.c.e var6 = var1.a();

      while(true) {
         if(var6.f()) {
            y.c.d var7 = var6.a();
            var2 += var0.j(var7.c());
            var4 += var0.k(var7.c());
            var6.g();
            if(var13 != 0) {
               break;
            }

            if(var13 == 0) {
               continue;
            }
         }

         var2 /= (double)var1.size();
         var4 /= (double)var1.size();
         break;
      }

      double var14 = 0.0D;
      double var8 = 0.0D;
      y.c.e var12 = var1.a();

      boolean var10000;
      while(true) {
         if(var12.f()) {
            double var10 = var2 - var0.j(var12.a().c());
            var14 += var10 * var10;
            var10 = var4 - var0.k(var12.a().c());
            var8 += var10 * var10;
            var12.g();
            if(var13 != 0) {
               break;
            }

            if(var13 == 0) {
               continue;
            }
         }

         if(var8 > var14) {
            var10000 = true;
            return var10000;
         }
         break;
      }

      var10000 = false;
      return var10000;
   }

   public static boolean a(y.d.t var0, y.d.t var1) {
      return var0.a == var1.a;
   }

   public static boolean b(y.d.t var0, y.d.t var1) {
      return var0.b == var1.b;
   }

   public static byte a(y.f.X var0, y.c.q var1, y.c.D var2) {
      y.d.t var3 = (y.d.t)var2.a(0);
      y.d.t var4 = (y.d.t)var2.a(1);
      return (byte)(var3.a == var4.a?(var3.b < var0.k(var1)?1:2):(var3.a < var0.j(var1)?8:4));
   }
}
