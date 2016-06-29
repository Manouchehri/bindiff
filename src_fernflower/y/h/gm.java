package y.h;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D.Double;
import y.h.b;
import y.h.bd;
import y.h.cV;
import y.h.fj;
import y.h.hC;
import y.h.hk;

public class gm extends b implements bd {
   private byte a;
   private boolean b;

   public gm() {
      this((byte)0);
   }

   public gm(byte var1) {
      this.b = true;
      this.a = var1;
   }

   protected void a(fj var1, Graphics2D var2, boolean var3) {
      Shape var4 = this.a(var1);
      this.a(var1, var2, var4);
      this.b(var1, var2, var4);
   }

   private Shape a(fj var1) {
      double var2;
      double var4;
      double var6;
      double var8;
      label23: {
         if(var1 != null) {
            var2 = var1.getX();
            var4 = var1.getY();
            var6 = var1.getWidth();
            var8 = var1.getHeight();
            if(!fj.z) {
               break label23;
            }
         }

         var2 = 0.0D;
         var4 = 0.0D;
         var6 = 1.0D;
         var8 = 1.0D;
      }

      GeneralPath var10;
      switch(this.a) {
      case 0:
      case 6:
         return new Double(var2, var4, var6, var8);
      case 1:
         return new java.awt.geom.RoundRectangle2D.Double(var2, var4, var6, var8, 8.0D, 8.0D);
      case 2:
         return new java.awt.geom.Ellipse2D.Double(var2, var4, var6, var8);
      case 3:
         var10 = new GeneralPath(0, 9);
         var10.moveTo((float)(var2 + var6 * 0.1D), (float)var4);
         var10.lineTo((float)(var2 + var6), (float)var4);
         var10.lineTo((float)(var2 + var6 * 0.9D), (float)(var4 + var8));
         var10.lineTo((float)var2, (float)(var4 + var8));
         var10.closePath();
         return var10;
      case 4:
         var10 = new GeneralPath(0, 9);
         var10.moveTo((float)var2, (float)(var4 + var8 / 2.0D));
         var10.lineTo((float)(var2 + var6 * 0.1D), (float)var4);
         var10.lineTo((float)(var2 + var6 * 0.9D), (float)var4);
         var10.lineTo((float)(var2 + var6), (float)(var4 + var8 / 2.0D));
         var10.lineTo((float)(var2 + var6 * 0.9D), (float)(var4 + var8));
         var10.lineTo((float)(var2 + var6 * 0.1D), (float)(var4 + var8));
         var10.closePath();
         return var10;
      case 5:
         var10 = new GeneralPath(0, 9);
         var10.moveTo((float)(var2 + var6 / 2.0D), (float)var4);
         var10.lineTo((float)(var2 + var6), (float)(var4 + var8));
         var10.lineTo((float)var2, (float)(var4 + var8));
         var10.closePath();
         return var10;
      case 7:
         double var11 = Math.sqrt(2.0D);
         double var13 = var6 / (2.0D + var11);
         double var15 = var8 / (2.0D + var11);
         var10 = new GeneralPath(0, 9);
         var10.moveTo((float)var2, (float)(var4 + var15));
         var10.lineTo((float)(var2 + var13), (float)var4);
         var10.lineTo((float)(var2 + var6 - var13), (float)var4);
         var10.lineTo((float)(var2 + var6), (float)(var4 + var15));
         var10.lineTo((float)(var2 + var6), (float)(var4 + var8 - var15));
         var10.lineTo((float)(var2 + var6 - var13), (float)(var4 + var8));
         var10.lineTo((float)(var2 + var13), (float)(var4 + var8));
         var10.lineTo((float)var2, (float)(var4 + var8 - var15));
         var10.closePath();
         return var10;
      case 8:
         var10 = new GeneralPath(0, 9);
         var10.moveTo((float)var2, (float)(var4 + var8 * 0.5D));
         var10.lineTo((float)(var2 + var6 * 0.5D), (float)var4);
         var10.lineTo((float)(var2 + var6), (float)(var4 + var8 * 0.5D));
         var10.lineTo((float)(var2 + var6 * 0.5D), (float)(var4 + var8));
         var10.closePath();
         return var10;
      case 9:
         var10 = new GeneralPath(0, 9);
         var10.moveTo((float)var2, (float)(var4 + var8));
         var10.lineTo((float)(var2 + var6 * 0.25D), (float)var4);
         var10.lineTo((float)(var2 + var6 * 0.75D), (float)var4);
         var10.lineTo((float)(var2 + var6), (float)(var4 + var8));
         var10.closePath();
         return var10;
      case 10:
         var10 = new GeneralPath(0, 9);
         var10.moveTo((float)var2, (float)var4);
         var10.lineTo((float)(var2 + var6), (float)var4);
         var10.lineTo((float)(var2 + var6 * 0.75D), (float)(var4 + var8));
         var10.lineTo((float)(var2 + var6 * 0.25D), (float)(var4 + var8));
         var10.closePath();
         return var10;
      default:
         return new Double(var2, var4, var6, var8);
      }
   }

   protected void a(fj var1, Graphics2D var2, Shape var3) {
      if(!var1.isTransparent()) {
         Paint var4 = this.f(var1, var2);
         if(var4 != null) {
            var2.setPaint(var4);
            var2.fill(var3);
         }
      }

   }

   protected Color b(fj var1, boolean var2) {
      Color var3 = super.b(var1, var2);
      if(this.a() && var3 != null) {
         y.c.q var4 = var1.getNode();
         if(var4 != null) {
            y.h.a.v var5 = y.h.a.v.a(var4.e());
            if(var5 != null && var5.k(var4)) {
               Color var6 = var3;
               int var7 = var5.o(var4);
               if(var7 > 0) {
                  var6 = new Color(Math.max(var3.getRed() - 20 * var7, 0), Math.max(var3.getGreen() - 20 * var7, 0), Math.max(var3.getBlue() - 20 * var7, 0), var3.getAlpha());
               }

               var3 = var6;
            }
         }
      }

      return var3;
   }

   protected void b(fj var1, Graphics2D var2, Shape var3) {
      boolean var8 = fj.z;
      Color var4;
      if(this.a == 6) {
         var4 = this.b(var1, g(var1, var2));
         if(var4 == null) {
            return;
         }

         var2.setColor(var4);
         this.b(var1, var2, true);
         if(!var8) {
            return;
         }
      }

      var4 = this.a(var1, g(var1, var2));
      if(var4 != null) {
         Stroke var5;
         label28: {
            var5 = var2.getStroke();
            var2.setStroke(var1.getLineType());
            var2.setColor(var4);
            if(this.a == 2) {
               cV var6 = (cV)var2.getRenderingHint(hk.z);
               Object var7 = var2.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
               if(!RenderingHints.VALUE_ANTIALIAS_ON.equals(var7) && (var6 == null || !var6.b())) {
                  var2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                  var2.draw(var3);
                  var2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, var7);
                  if(!var8) {
                     break label28;
                  }
               }

               var2.draw(var3);
               if(!var8) {
                  break label28;
               }
            }

            var2.draw(var3);
         }

         var2.setStroke(var5);
      }

   }

   private void b(fj var1, Graphics2D var2, boolean var3) {
      double var4;
      double var6;
      double var8;
      double var10;
      Paint var12;
      Color var14;
      Color var15;
      label23: {
         var4 = var1.getX();
         var6 = var1.getY();
         var8 = var1.getWidth();
         var10 = var1.getHeight();
         var12 = var2.getPaint();
         Color var13 = var2.getColor();
         var14 = var13.brighter();
         var15 = var13.darker();
         if(!var3) {
            var2.setColor(var15);
            if(!fj.z) {
               break label23;
            }
         }

         if(var12 != var13) {
            var2.setColor(var13);
         }
      }

      var2.setColor(var3?var14:var15);
      Double var16 = hC.a().k;
      var16.setFrame(var4, var6, 1.0D, var10);
      var2.fill(var16);
      var16.setFrame(var4 + 1.0D, var6, var8 - 2.0D, 1.0D);
      var2.fill(var16);
      var2.setColor(var3?var15:var14);
      var16.setFrame(var4 + 1.0D, var6 + var10 - 1.0D, var8 - 1.0D, 1.0D);
      var2.fill(var16);
      var16.setFrame(var4 + var8 - 1.0D, var6, 1.0D, var10 - 1.0D);
      var2.fill(var16);
      var2.setPaint(var12);
   }

   public boolean a() {
      return this.b;
   }

   public boolean a(fj var1, double var2, double var4) {
      return this.a(var1).contains(var2, var4);
   }
}
