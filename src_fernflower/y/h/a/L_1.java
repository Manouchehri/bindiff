package y.h.a;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import y.h.fj;
import y.h.gd;
import y.h.gt;
import y.h.a.a;

public class L extends gd implements a, gt {
   public L() {
   }

   public L(fj var1) {
      super(var1);
   }

   public fj createCopy(fj var1) {
      return new L(var1);
   }

   public y.d.r getAutoBoundsInsets() {
      fj var1 = this.e();
      if(var1 != null) {
         a var2 = var1.getAutoBoundsFeature();
         if(var2 != null) {
            return var2.getAutoBoundsInsets();
         }
      }

      return new y.d.r(0.0D, 0.0D, 0.0D, 0.0D);
   }

   public void setAutoBoundsInsets(y.d.r var1) {
      fj var2 = this.e();
      if(var2 != null) {
         a var3 = var2.getAutoBoundsFeature();
         if(var3 != null) {
            var3.setAutoBoundsInsets(var1);
         }
      }

   }

   public boolean isAutoBoundsEnabled() {
      fj var1 = this.e();
      if(var1 != null) {
         a var2 = var1.getAutoBoundsFeature();
         if(var2 != null) {
            return var2.isAutoBoundsEnabled();
         }
      }

      return false;
   }

   public void setAutoBoundsEnabled(boolean var1) {
      fj var2 = this.e();
      if(var2 != null) {
         a var3 = var2.getAutoBoundsFeature();
         if(var3 != null) {
            var3.setAutoBoundsEnabled(var1);
         }
      }

   }

   public Rectangle2D getMinimalAutoBounds() {
      fj var1 = this.e();
      if(var1 != null) {
         a var2 = var1.getAutoBoundsFeature();
         if(var2 != null) {
            return var2.getMinimalAutoBounds();
         }
      }

      return new Rectangle(0, 0, -1, -1);
   }

   public y.d.q getMinimumSize() {
      fj var1 = this.e();
      if(var1 != null) {
         gt var2 = var1.getSizeConstraintProvider();
         if(var2 != null) {
            return var2.getMinimumSize();
         }
      }

      return new y.d.q(0.0D, 0.0D);
   }

   public y.d.q getMaximumSize() {
      fj var1 = this.e();
      if(var1 != null) {
         gt var2 = var1.getSizeConstraintProvider();
         if(var2 != null) {
            return var2.getMaximumSize();
         }
      }

      return new y.d.q(Double.MAX_VALUE, Double.MAX_VALUE);
   }
}
