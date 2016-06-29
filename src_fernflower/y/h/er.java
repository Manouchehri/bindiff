package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import y.h.az;
import y.h.dX;
import y.h.e;
import y.h.fj;
import y.h.gy;
import y.h.id;

class er extends gy implements id {
   protected final double a;
   protected final double b;

   public er(byte var1, byte var2, y.d.t var3, double var4, double var6, Object var8, double var9, double var11, double var13) {
      super(var1, var2, var3, var4, var6, var8, var9);
      this.a = var11;
      this.b = var13;
   }

   public az a(Rectangle2D var1) {
      return new dX(this, var1);
   }

   public Rectangle b(Rectangle2D var1) {
      boolean var16 = fj.z;
      double var2;
      double var4;
      double var6;
      double var8;
      double var10;
      double var12;
      Double var14;
      Rectangle var15;
      if(this.c() == 0) {
         label16: {
            if(var1.getCenterX() < this.b().a) {
               var10 = Math.min(var1.getX(), this.e()) - 8.0D;
               var12 = Math.max(var1.getX(), this.b().a);
               if(!var16) {
                  break label16;
               }
            }

            var12 = Math.min(var1.getX() + var1.getWidth(), this.b().a);
            var10 = Math.max(var1.getX() + var1.getWidth(), this.f()) + 8.0D;
         }

         var2 = this.a;
         var4 = this.b;
         var6 = var1.getY();
         var8 = var6 + var1.getHeight();
         var14 = new Double(Math.min(var10, var12), Math.min(Math.min(var6, var8), Math.min(var2, var4)), Math.abs(var12 - var10), 0.0D);
         var14.height = Math.max(Math.max(var6, var8), Math.max(var2, var4)) - var14.y;
         var15 = var14.getBounds();
         var15.grow(20, 20);
         return var15;
      } else {
         label22: {
            var2 = this.a;
            var4 = this.b;
            var6 = var1.getX();
            var8 = var1.getX() + var1.getWidth();
            if(var1.getCenterY() < this.b().b) {
               var10 = Math.min(var1.getY(), this.e()) - 8.0D;
               var12 = Math.max(var1.getY(), this.b().b);
               if(!var16) {
                  break label22;
               }
            }

            var12 = Math.min(var1.getY() + var1.getHeight(), this.b().b);
            var10 = Math.max(var1.getY() + var1.getHeight(), this.f()) + 8.0D;
         }

         var14 = new Double(Math.min(Math.min(var6, var8), Math.min(var2, var4)), Math.min(var10, var12), 0.0D, Math.abs(var12 - var10));
         var14.width = Math.max(Math.max(var6, var8), Math.max(var2, var4)) - var14.x;
         var15 = var14.getBounds();
         var15.grow(20, 20);
         return var15;
      }
   }

   public void a(Graphics2D var1, Rectangle2D var2) {
      double var3;
      double var5;
      double var7;
      double var9;
      double var11;
      double var13;
      boolean var15;
      label36: {
         var15 = fj.z;
         if(this.c() == 0) {
            label30: {
               if(var2.getCenterX() < this.b().a) {
                  var11 = Math.min(var2.getX(), this.e()) - 8.0D;
                  var13 = Math.max(var2.getX(), this.b().a);
                  if(!var15) {
                     break label30;
                  }
               }

               var13 = Math.min(var2.getX() + var2.getWidth(), this.b().a);
               var11 = Math.max(var2.getX() + var2.getWidth(), this.f()) + 8.0D;
            }

            var3 = this.a;
            var5 = this.b;
            var7 = var2.getY();
            var9 = var7 + var2.getHeight();
            if(!var15) {
               break label36;
            }
         }

         var3 = this.a;
         var5 = this.b;
         var7 = var2.getX();
         var9 = var2.getX() + var2.getWidth();
         if(var2.getCenterY() < this.b().b) {
            var11 = Math.min(var2.getY(), this.e()) - 8.0D;
            var13 = Math.max(var2.getY(), this.b().b);
            if(!var15) {
               break label36;
            }
         }

         var13 = Math.min(var2.getY() + var2.getHeight(), this.b().b);
         var11 = Math.max(var2.getY() + var2.getHeight(), this.f()) + 8.0D;
      }

      if(this.c() == 0) {
         var1.draw(new java.awt.geom.Line2D.Double(var11, var3, var13, var3));
         var1.draw(new java.awt.geom.Line2D.Double(var11, var5, var13, var5));
         var1.draw(new java.awt.geom.Line2D.Double(var11, var7, var13, var7));
         var1.draw(new java.awt.geom.Line2D.Double(var11, var9, var13, var9));
         e.a(var1, var11, var3, var11, var7);
         e.a(var1, var11, var9, var11, var5);
         if(!var15) {
            return;
         }
      }

      var1.draw(new java.awt.geom.Line2D.Double(var3, var11, var3, var13));
      var1.draw(new java.awt.geom.Line2D.Double(var5, var11, var5, var13));
      var1.draw(new java.awt.geom.Line2D.Double(var7, var11, var7, var13));
      var1.draw(new java.awt.geom.Line2D.Double(var9, var11, var9, var13));
      e.a(var1, var3, var11, var7, var11);
      e.a(var1, var5, var11, var9, var11);
   }
}
