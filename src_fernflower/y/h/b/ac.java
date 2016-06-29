package y.h.b;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import y.h.b.a;
import y.h.b.ab;

class ac extends ab {
   private double e;
   private boolean f;
   private Color g = new Color(0, 222, 0, 192);
   private Stroke h = new BasicStroke(2.0F);

   public void a(Graphics2D var1) {
      var1.setColor(this.g);
      var1.setStroke(this.h);
      int var2 = (int)this.a;
      int var3 = (int)this.b;
      int var4 = (int)this.c;
      int var5 = (int)this.d;
      int var6 = (int)this.a();
      var1.drawRect(var2, var3, var4, var5);
      if(this.b()) {
         var1.drawLine(var2 + var6, var3, var2 + var6, var3 + var5);
         if(a.H == 0) {
            return;
         }
      }

      var1.drawLine(var2, var3 + var6, var2 + var4, var3 + var6);
   }

   public double a() {
      return this.e;
   }

   public void a(double var1) {
      this.e = var1;
   }

   public boolean b() {
      return this.f;
   }

   public void a(boolean var1) {
      this.f = var1;
   }
}
