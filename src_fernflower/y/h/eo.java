package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import y.h.az;
import y.h.dW;
import y.h.fj;
import y.h.gy;
import y.h.id;

class eo extends gy implements id {
   eo(byte var1, byte var2, y.d.t var3, double var4, double var6, Object var8, double var9) {
      super(var1, var2, var3, var4, var6, var8, var9);
   }

   eo(byte var1, byte var2, y.d.t var3, Object var4, double var5) {
      super(var1, var2, var3, var4, var5);
   }

   public az a(Rectangle2D var1) {
      return new dW(this, var1);
   }

   protected Rectangle b(Rectangle2D var1) {
      boolean var11 = fj.z;
      double var6;
      double var2 = var6 = this.b().a;
      double var8;
      double var4 = var8 = this.b().b;
      switch(this.d()) {
      case 16:
      default:
         if(this.c() == 0) {
            var6 = var1.getCenterX();
            if(!var11) {
               break;
            }
         }

         var8 = var1.getCenterY();
         if(!var11) {
            break;
         }
      case 4:
      case 8:
         var8 = var1.getCenterY();
         if(!var11) {
            break;
         }
      case 1:
      case 2:
         var6 = var1.getCenterX();
      }

      Rectangle var10 = new Rectangle((int)var2, (int)var4, 0, 0);
      var10.add(var6, var8);
      var10.grow(22, 22);
      return var10;
   }

   protected void a(Graphics2D var1, Rectangle2D var2) {
      boolean var12 = fj.z;
      double var7;
      double var3 = var7 = this.b().a;
      double var9;
      double var5 = var9 = this.b().b;
      boolean var11;
      switch(this.d()) {
      case 16:
      default:
         if(this.c() == 0) {
            var7 = var2.getCenterX();
            var11 = true;
            if(!var12) {
               break;
            }
         }

         var9 = var2.getCenterY();
         var11 = false;
         if(!var12) {
            break;
         }
      case 4:
      case 8:
         var9 = var2.getCenterY();
         var11 = false;
         if(!var12) {
            break;
         }
      case 1:
      case 2:
         var11 = true;
         var7 = var2.getCenterX();
      }

      label17: {
         if(var11) {
            var1.draw(new Double(Math.min(var3, var7) - 20.0D, var5, Math.max(var3, var7) + 20.0D, var9));
            if(!var12) {
               break label17;
            }
         }

         var1.draw(new Double(var3, Math.min(var5, var9) - 20.0D, var7, Math.max(var5, var9) + 20.0D));
      }

      a(var1, var3, var5);
      a(var1, var7, var9);
   }
}
