package y.h;

import java.awt.geom.Point2D.Double;
import y.h.bu;
import y.h.fj;

final class fl implements y.f.P {
   private bu e;
   private boolean f;
   private boolean g;
   y.c.d c;
   Double d = new Double();

   fl(bu var1, boolean var2, boolean var3) {
      this.e = var1;
      this.f = var3;
      this.g = var2;
   }

   public y.d.t a(y.f.am var1, double var2, double var4, double var6, double var8) {
      boolean var32;
      fj var10;
      label57: {
         var32 = fj.z;
         if(this.f) {
            var10 = this.e.t(this.c.c());
            if(!var32) {
               break label57;
            }
         }

         var10 = this.e.t(this.c.d());
      }

      double var11 = var10.getCenterX();
      double var13 = var10.getCenterY();
      if(var10.contains(var11 + var2, var13 + var4)) {
         return null;
      } else if(var10.getWidth() == var1.getWidth() && var10.getHeight() == var1.getHeight()) {
         double var15 = var11 + var2 - var6 * 5.0D;
         double var17 = var13 + var4 - var8 * 5.0D;
         double var19 = 10.0D + Math.max(var10.getWidth(), var10.getHeight());
         double var21 = var11;
         double var23 = var13;
         boolean var25 = false;
         double var26 = 0.0D;

         boolean var10000;
         while(true) {
            if(var26 < var19 * 2.0D) {
               label61: {
                  double var28 = var15 + var6 * var26;
                  double var30 = var17 + var8 * var26;
                  var10000 = var10.contains(var28, var30);
                  if(var32) {
                     break;
                  }

                  if(var10000) {
                     var21 = var28;
                     var23 = var30;
                     var15 = var28 - var6 * 2.0D;
                     var17 = var30 - var8 * 2.0D;
                     var25 = true;
                     if(!var32) {
                        break label61;
                     }
                  }

                  ++var26;
                  if(!var32) {
                     continue;
                  }
               }
            }

            var10000 = var25;
            break;
         }

         return var10000?(var10.findIntersection(var21, var23, var15, var17, this.d)?new y.d.t(this.d.x - var11, this.d.y - var13):new y.d.t(var2, var4)):(this.g?(var10.findIntersection(var11, var13, var11 + var2, var13 + var4, this.d)?new y.d.t(this.d.x - var11, this.d.y - var13):new y.d.t(var2, var4)):null);
      } else {
         return null;
      }
   }
}
