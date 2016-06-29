package y.d;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import y.c.D;
import y.d.A;
import y.d.t;
import y.d.z;

public final class e {
   public static int a(t var0, t var1, t var2) {
      return a(var0.a, var0.b, var1.a, var1.b, var2.a, var2.b);
   }

   public static int a(double var0, double var2, double var4, double var6, double var8, double var10) {
      var4 -= var0;
      var6 -= var2;
      var8 -= var0;
      var10 -= var2;
      double var12 = var8 * var6 - var10 * var4;
      return var12 < 0.0D?1:(var12 > 0.0D?-1:0);
   }

   public static boolean b(t var0, t var1, t var2) {
      return a(var0, var1, var2) > 0;
   }

   public static boolean c(t var0, t var1, t var2) {
      return a(var0, var1, var2) < 0;
   }

   public static boolean d(t var0, t var1, t var2) {
      return a(var0, var1, var2) == 0;
   }

   public static D a(D var0) {
      return A.a(var0);
   }

   public static double a(double var0) {
      return var0 / 180.0D * 3.141592653589793D;
   }

   public static double b(double var0) {
      return var0 * 180.0D / 3.141592653589793D;
   }

   public static t a(t var0, z var1, t var2, z var3) {
      double var4 = var0.a();
      double var6 = var0.b();
      double var8 = var2.a();
      double var10 = var2.b();
      return a(var4, var6, var4 + var1.a(), var6 + var1.b(), var8, var10, var8 + var3.a(), var10 + var3.b());
   }

   public static t a(double var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14) {
      double var16 = var6 - var2;
      double var18 = var0 - var4;
      double var20 = var14 - var10;
      double var22 = var8 - var12;
      double var24 = var16 * var22 - var20 * var18;
      if(var24 == 0.0D) {
         return null;
      } else {
         double var26 = var16 * var0 + var18 * var2;
         double var28 = var20 * var8 + var22 * var10;
         double var30 = (var22 * var26 - var18 * var28) / var24;
         double var32 = (var16 * var28 - var20 * var26) / var24;
         return new t(var30, var32);
      }
   }

   public static t b(double var0, double var2, double var4, double var6, double var8, double var10) {
      double var12 = var8 - var4;
      double var14 = var10 - var6;
      double var16 = var12 * var12 + var14 * var14;
      double var18 = 0.0D;
      if(var16 != 0.0D) {
         var18 = ((var0 - var4) * var12 + (var2 - var6) * var14) / var16;
         var18 = Math.min(1.0D, Math.max(0.0D, var18));
      }

      return new t(var4 * (1.0D - var18) + var8 * var18, var6 * (1.0D - var18) + var10 * var18);
   }

   public static Rectangle2D a(Rectangle2D var0, Rectangle2D var1, Rectangle2D var2) {
      boolean var3 = t.d;
      if(var2 == null) {
         var2 = new Double();
      }

      if(var2 != var1) {
         ((Rectangle2D)var2).setRect(var0);
         if(((Rectangle2D)var2).getWidth() < 0.0D || ((Rectangle2D)var2).getHeight() < 0.0D) {
            ((Rectangle2D)var2).setRect(var1);
            if(!var3) {
               return (Rectangle2D)var2;
            }
         }

         if(var1.getWidth() < 0.0D || var1.getHeight() < 0.0D) {
            return (Rectangle2D)var2;
         }

         ((Rectangle2D)var2).add(var1);
         if(!var3) {
            return (Rectangle2D)var2;
         }
      }

      if(((Rectangle2D)var2).getWidth() < 0.0D || ((Rectangle2D)var2).getHeight() < 0.0D) {
         ((Rectangle2D)var2).setRect(var0);
         if(!var3) {
            return (Rectangle2D)var2;
         }
      }

      if(var0.getWidth() >= 0.0D && var0.getHeight() >= 0.0D) {
         ((Rectangle2D)var2).add(var0);
      }

      return (Rectangle2D)var2;
   }

   public static Rectangle2D b(Rectangle2D var0, Rectangle2D var1, Rectangle2D var2) {
      if(var2 == null) {
         var2 = new Double(0.0D, 0.0D, -1.0D, -1.0D);
      }

      double var3 = var0.getX();
      double var5 = var1.getX();
      double var7 = var0.getY();
      double var9 = var1.getY();
      double var11 = var0.getWidth();
      double var13 = var1.getWidth();
      double var15 = var0.getHeight();
      double var17 = var1.getHeight();
      if(var11 < 0.0D || var15 < 0.0D || var13 < 0.0D || var17 < 0.0D) {
         ((Rectangle2D)var2).setRect(0.0D, 0.0D, -1.0D, -1.0D);
         if(!t.d) {
            return (Rectangle2D)var2;
         }
      }

      double var19 = Math.max(var3, var5);
      double var21 = Math.max(var7, var9);
      double var23 = Math.min(var3 + var11, var5 + var13);
      double var25 = Math.min(var7 + var15, var9 + var17);
      ((Rectangle2D)var2).setRect(var19, var21, var23 - var19, var25 - var21);
      return (Rectangle2D)var2;
   }
}
