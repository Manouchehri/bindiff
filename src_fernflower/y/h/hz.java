package y.h;

import java.awt.Component;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import javax.swing.JComponent;
import y.h.fj;
import y.h.hw;

final class hz {
   private JComponent a;
   private AffineTransform b;

   public hz(JComponent var1, AffineTransform var2) {
      this.a = var1;
      this.a.putClientProperty("FloatingJComponent.Instance", this);
      this.b = var2;
   }

   public void a(Double var1) {
      this.a(new Double(0.0D, 0.0D, (double)this.a.getWidth(), (double)this.a.getHeight()), var1);
   }

   public void a(Rectangle2D var1, Rectangle2D var2) {
      double[] var3 = new double[8];
      var3[0] = var3[2] = var1.getX();
      var3[1] = var3[5] = var1.getY();
      var3[3] = var3[7] = var1.getMaxY();
      var3[4] = var3[6] = var1.getMaxX();
      this.b.transform(var3, 0, var3, 0, 4);
      double var4 = Math.max(Math.max(var3[0], var3[2]), Math.max(var3[4], var3[6]));
      double var6 = Math.min(Math.min(var3[0], var3[2]), Math.min(var3[4], var3[6]));
      double var8 = Math.max(Math.max(var3[1], var3[3]), Math.max(var3[5], var3[7]));
      double var10 = Math.min(Math.min(var3[1], var3[3]), Math.min(var3[5], var3[7]));
      var2.setFrame(var6, var10, var4 - var6, var8 - var10);
   }

   public JComponent a(double var1, double var3) {
      double[] var5 = new double[]{var1, var3};

      try {
         this.b.inverseTransform(var5, 0, var5, 0, 1);
      } catch (NoninvertibleTransformException var8) {
         return null;
      }

      int var6 = (int)var5[0];
      int var7 = (int)var5[1];
      return var6 >= 0 && var7 >= 0 && var6 < this.a.getWidth() && var7 < this.a.getHeight()?hw.a(this.a, var6, var7):null;
   }

   public boolean a(JComponent var1, double var2, double var4, Point var6) {
      boolean var11 = fj.z;
      double[] var7 = new double[]{var2, var4};

      try {
         this.b.inverseTransform(var7, 0, var7, 0, 1);
      } catch (NoninvertibleTransformException var12) {
         return false;
      }

      int var8 = (int)var7[0];
      int var9 = (int)var7[1];
      Object var10 = var1;

      Object var10000;
      while(true) {
         if(var10 != this.a) {
            var10000 = var10;
            if(var11) {
               break;
            }

            if(var10 != null) {
               var8 -= ((Component)var10).getX();
               var9 -= ((Component)var10).getY();
               var10 = ((Component)var10).getParent();
               if(!var11) {
                  continue;
               }
            }
         }

         var10000 = var10;
         break;
      }

      if(var10000 == null) {
         return false;
      } else {
         var6.x = var8;
         var6.y = var9;
         return true;
      }
   }
}
