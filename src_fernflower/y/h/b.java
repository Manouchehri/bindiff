package y.h;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import y.h.bo;
import y.h.fj;
import y.h.hk;

public abstract class b implements bo {
   private Color a;
   private Stroke b;
   private Paint c;

   public void a(fj var1, Graphics2D var2) {
      this.b(var1, var2, false);
   }

   protected void a(Graphics2D var1) {
      this.a = var1.getColor();
      this.b = var1.getStroke();
      this.c = var1.getPaint();
   }

   protected void b(fj var1, Graphics2D var2) {
      if(g(var1, var2)) {
         var1.paintHotSpots(var2);
      }

   }

   protected void c(fj var1, Graphics2D var2) {
      if(var1.labelCount() > 0) {
         var1.paintText(var2);
      }

   }

   protected void d(fj var1, Graphics2D var2) {
      var1.paintPorts(var2);
   }

   protected void b(Graphics2D var1) {
      var1.setColor(this.a);
      var1.setStroke(this.b);
      var1.setPaint(this.c);
   }

   protected Color a(fj var1, boolean var2) {
      return var1.getLineColor();
   }

   protected Color a(Color var1) {
      return new Color(Math.max((int)((double)var1.getRed() * 0.7D), 0), Math.max((int)((double)var1.getGreen() * 0.7D), 0), Math.max((int)((double)var1.getBlue() * 0.7D), 0), var1.getAlpha());
   }

   protected Color b(fj var1, boolean var2) {
      Color var3 = var1.getFillColor();
      return var3 != null?(var2?this.a(var3):var3):null;
   }

   protected Paint c(fj var1, boolean var2) {
      Color var3 = this.b(var1, var2);
      if(var3 != null) {
         Color var4 = this.d(var1, var2);
         return (Paint)(var4 != null?new GradientPaint((float)(var1.getX() + var1.getWidth() * 0.33D), (float)var1.getY(), var3, (float)(var1.getX() + var1.getWidth()), (float)var1.getY(), var4, true):var3);
      } else {
         return null;
      }
   }

   protected Color d(fj var1, boolean var2) {
      Color var3 = var1.getFillColor2();
      return var3 != null?(var2?this.a(var3):var3):null;
   }

   protected abstract void a(fj var1, Graphics2D var2, boolean var3);

   public void e(fj var1, Graphics2D var2) {
      this.b(var1, var2, true);
   }

   private void b(fj var1, Graphics2D var2, boolean var3) {
      if(var1.isVisible()) {
         this.a(var2);

         try {
            if(!var3) {
               this.b(var1, var2);
            }

            this.a(var1, var2, var3);
         } finally {
            this.b(var2);
         }

         if(b(var2, var3)) {
            this.d(var1, var2);
         }

         if(a(var2, var3)) {
            this.c(var1, var2);
         }

      }
   }

   Paint f(fj var1, Graphics2D var2) {
      boolean var3 = g(var1, var2);
      return (Paint)(c(var2)?this.c(var1, var3):this.b(var1, var3));
   }

   static boolean c(Graphics2D var0) {
      return hk.c(var0);
   }

   static boolean g(fj var0, Graphics2D var1) {
      return fj.b(var0, var1);
   }

   static boolean a(Graphics2D var0, boolean var1) {
      return fj.c(var0, var1);
   }

   static boolean b(Graphics2D var0, boolean var1) {
      return fj.b(var0, var1);
   }
}
