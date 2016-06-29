package y.h;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D.Double;
import y.h.fj;
import y.h.gZ;
import y.h.hC;
import y.h.hd;

public abstract class a implements hd {
   final BasicStroke a = a(1);
   final BasicStroke b = a(3);
   boolean c;

   public boolean a() {
      return this.c;
   }

   public void a(boolean var1) {
      this.c = var1;
   }

   public void a(gZ var1, Graphics2D var2) {
      boolean var13 = fj.z;
      if(var1.w) {
         y.d.n var3 = var1.getContentBox();
         if(var3.i() == -1.0D) {
            double var4 = var3.f();
            var1.paintImpl(var2, var3.b(), var3.c() - var4, var3.e(), var4);
            if(!var13) {
               return;
            }
         }

         double var5;
         double var7;
         Graphics2D var14;
         label19: {
            var14 = (Graphics2D)var2.create();
            var5 = var3.e();
            var7 = var3.f();
            double var9 = var3.g();
            double var11 = var3.i();
            if(this.a() && var11 > 0.0D) {
               var14.transform(new AffineTransform(var11, -var9, var9, var11, var3.b() - var11 * var5, var3.c() + var9 * var5));
               if(!var13) {
                  break label19;
               }
            }

            var14.transform(new AffineTransform(-var11, var9, -var9, -var11, var3.b() + var9 * var7, var3.c() + var11 * var7));
         }

         var1.paintImpl(var14, 0.0D, 0.0D, var5, var7);
         var14.dispose();
      }
   }

   public void a(gZ var1, Graphics2D var2, double var3, double var5, double var7, double var9) {
      Color var11 = var2.getColor();
      Paint var12 = var2.getPaint();
      Stroke var13 = var2.getStroke();
      Double var14;
      if(this.b(var1, var2)) {
         var14 = hC.a().k;
         var14.setFrame(var3, var5, var7, var9);
         var2.fill(var14);
      }

      if(this.c(var1, var2)) {
         var14 = hC.a().k;
         var14.setFrame(var3, var5, var7, var9);
         var2.draw(var14);
      }

      this.a_(var1, var2, var3, var5, var7, var9);
      var2.setStroke(var13);
      var2.setPaint(var12);
      var2.setColor(var11);
   }

   protected void a_(gZ var1, Graphics2D var2, double var3, double var5, double var7, double var9) {
      if(d(var1, var2)) {
         Double var11 = hC.a().k;
         var11.setFrame(var3 - 2.0D, var5 - 2.0D, var7 + 4.0D, var9 + 4.0D);
         var2.setColor(Color.BLACK);
         var2.setStroke(this.b);
         var2.draw(var11);
         var2.setStroke(this.a);
         var2.setColor(Color.WHITE);
         var2.draw(var11);
      }

   }

   protected boolean b(gZ var1, Graphics2D var2) {
      Paint var3 = this.a(var1, d(var1, var2));
      if(var3 != null) {
         var2.setPaint(var3);
         return true;
      } else {
         return false;
      }
   }

   protected Paint a(gZ var1, boolean var2) {
      return this.b(var1, var2);
   }

   protected Color b(gZ var1, boolean var2) {
      return var1.k;
   }

   protected boolean c(gZ var1, Graphics2D var2) {
      boolean var3 = d(var1, var2);
      Paint var4 = this.d(var1, var3);
      if(var4 != null) {
         var2.setStroke(this.c(var1, var3));
         var2.setPaint(var4);
         return true;
      } else {
         return false;
      }
   }

   protected Stroke c(gZ var1, boolean var2) {
      return this.a;
   }

   protected Paint d(gZ var1, boolean var2) {
      return this.e(var1, var2);
   }

   protected Color e(gZ var1, boolean var2) {
      return var1.gb;
   }

   y.d.n a(gZ var1, y.d.n var2) {
      y.d.n var3 = var1.getContentBox();
      return var3.i() > 0.0D?new y.d.n(var3.e() - var2.b(), -var3.f() - var2.c(), var2.e(), var2.f(), -var2.g(), -var2.i()):var2;
   }

   private static BasicStroke a(int var0) {
      return new BasicStroke((float)var0, 2, 0, 1.6F);
   }

   private static boolean d(gZ var0, Graphics2D var1) {
      return gZ.b(var0, var1);
   }
}
