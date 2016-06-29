package y.h;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import y.h.dr;
import y.h.eU;
import y.h.eW;
import y.h.eX;
import y.h.eZ;
import y.h.fa;
import y.h.fc;
import y.h.fj;
import y.h.hC;

public class gq implements eW, eX, eZ, fa, fc {
   private y.d.q a = new y.d.q(10.0D, 10.0D);
   private y.d.t b = new y.d.t(0.5D, 0.5D);

   public y.d.q a() {
      return this.a;
   }

   public y.d.t b() {
      return this.b;
   }

   public boolean a(eU var1, double var2, double var4) {
      return var1.k().a(var2, var4);
   }

   public boolean a(eU var1, double var2, double var4, double var6, double var8, Point2D var10) {
      boolean var21 = fj.z;
      if(var1.a(var2, var4)) {
         if(var1.a(var6, var8)) {
            var10.setLocation(var6, var8);
            return false;
         }
      } else if(!var1.a(var6, var8)) {
         var10.setLocation(var2, var4);
         return false;
      }

      double var11 = Math.sqrt((var6 - var2) * (var6 - var2) + (var8 - var4) * (var8 - var4));
      if(!Double.isNaN(var11) && !Double.isInfinite(var11)) {
         double var13 = (var6 - var2) / 2.0D;
         double var15 = (var8 - var4) / 2.0D;
         double var17 = var2 + var13;
         double var19 = var4 + var15;

         boolean var10000;
         while(true) {
            if(var11 > 0.1D) {
               var11 /= 2.0D;
               var13 /= 2.0D;
               var15 /= 2.0D;
               var10000 = var1.a(var17, var19);
               if(var21) {
                  break;
               }

               if(var10000) {
                  var17 += var13;
                  var19 += var15;
                  if(!var21) {
                     continue;
                  }
               }

               var17 -= var13;
               var19 -= var15;
               if(!var21) {
                  continue;
               }
            }

            var10.setLocation(var17, var19);
            var10000 = true;
            break;
         }

         return var10000;
      } else {
         var10.setLocation(var2, var4);
         return true;
      }
   }

   public void a(eU var1, Graphics2D var2) {
      Stroke var3 = var2.getStroke();
      Paint var4 = var2.getPaint();
      Color var5 = var2.getColor();
      fj var6 = var1.b();
      Rectangle2D var7 = eU.c(var1);
      if(this.b(var6, var1, var2)) {
         var2.fill(var7);
      }

      if(this.c(var6, var1, var2)) {
         var2.draw(var7);
      }

      this.a(var6, var1, var2);
      var2.setColor(var5);
      var2.setPaint(var4);
      var2.setStroke(var3);
   }

   protected void a(fj var1, eU var2, Graphics2D var3) {
      if(eU.a(var2, var3)) {
         y.d.y var4 = var2.k();
         java.awt.geom.Rectangle2D.Double var7 = hC.a().k;
         var7.setFrame(var4.c() - 2.0D, var4.d() - 2.0D, var4.a() + 4.0D, var4.b() + 4.0D);
         Color var8 = this.c(var1, var2, true);
         var3.setColor(var8 == null?Color.BLACK:var8);
         var3.setStroke(dr.a);
         var3.draw(var7);
      }

   }

   protected boolean b(fj var1, eU var2, Graphics2D var3) {
      Paint var4 = this.a(var1, var2, eU.a(var2, var3));
      if(var4 != null) {
         var3.setPaint(var4);
         return true;
      } else {
         return false;
      }
   }

   protected Paint a(fj var1, eU var2, boolean var3) {
      return this.a(var1, var3);
   }

   protected Paint a(fj var1, boolean var2) {
      Color var3 = var1.getFillColor();
      return var1.isSelected() && var3 != null?var3.darker():var3;
   }

   protected boolean c(fj var1, eU var2, Graphics2D var3) {
      boolean var4 = eU.a(var2, var3);
      Color var5 = this.c(var1, var2, var4);
      if(var5 != null) {
         Stroke var6 = this.b(var1, var2, var4);
         if(var6 != null) {
            var3.setColor(var5);
            var3.setStroke(var6);
            return true;
         }
      }

      return false;
   }

   protected Stroke b(fj var1, eU var2, boolean var3) {
      return this.b(var1, var3);
   }

   protected Stroke b(fj var1, boolean var2) {
      return var1.getLineType();
   }

   protected Color c(fj var1, eU var2, boolean var3) {
      return this.c(var1, var3);
   }

   protected Color c(fj var1, boolean var2) {
      Color var3 = var1.getLineColor();
      return var3 == null?Color.BLACK:var3;
   }

   public y.d.y a(eU var1) {
      y.d.t var2 = var1.h();
      y.d.q var3 = this.a();
      double var4 = var3.a();
      double var6 = var3.b();
      y.d.t var8 = this.b();
      return new y.d.y(var2.a() - var4 * var8.a(), var2.b() - var6 * var8.b(), var4, var6);
   }

   public void a(eU var1, Rectangle2D var2) {
      y.d.y var3 = var1.k();
      if(var2.getWidth() <= 0.0D) {
         var2.setFrame(var3.c(), var3.d(), var3.a(), var3.b());
         if(!fj.z) {
            return;
         }
      }

      var2.add(var3.c(), var3.d());
      var2.add(var3.c() + var3.a(), var3.d() + var3.b());
   }
}
