package y.h;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import y.h.az;
import y.h.dh;
import y.h.fj;
import y.h.io;
import y.h.ip;
import y.h.is;

class ir implements az {
   private final double a;
   private final double b;
   private final double c;
   private final double d;
   private dh e;
   private boolean f;
   private final List g;

   ir(double var1, double var3, double var5, double var7) {
      this.a = var1;
      this.b = var3;
      this.c = var5;
      this.d = var7;
      this.g = new ArrayList(3);
      this.f = true;
   }

   ir() {
      this.a = 0.0D;
      this.b = 0.0D;
      this.c = 0.0D;
      this.d = 0.0D;
      this.g = new ArrayList(1);
      this.f = false;
   }

   public void a(Graphics2D var1) {
      Color var2 = var1.getColor();
      Stroke var3 = var1.getStroke();
      var1.setColor(this.a());
      var1.setStroke(new BasicStroke());
      this.a((is)(new io(this, var1)));
      var1.setColor(var2);
      var1.setStroke(var3);
   }

   public Rectangle getBounds() {
      Double var1 = new Double(0.0D, 0.0D, -1.0D, -1.0D);
      this.a((is)(new ip(this, var1)));
      if(var1.getWidth() >= 0.0D && var1.getHeight() >= 0.0D) {
         var1.setFrame(var1.getX() - 2.0D, var1.getY() - 2.0D, var1.getWidth() + 4.0D, var1.getHeight() + 4.0D);
      }

      return var1.getBounds();
   }

   void a(y.d.t var1) {
      this.g.add(var1);
   }

   void a(dh var1) {
      this.e = var1;
   }

   Color a() {
      return this.e == null?Color.LIGHT_GRAY:this.e.a();
   }

   void a(is var1) {
      y.d.z var2;
      java.awt.geom.Line2D.Double var3;
      double var4;
      double var6;
      boolean var26;
      label23: {
         var26 = fj.z;
         var3 = new java.awt.geom.Line2D.Double();
         if(this.f) {
            var2 = new y.d.z(this.c - this.a, this.d - this.b);
            var2.c();
            var4 = 10.0D * var2.a();
            var6 = 10.0D * var2.b();
            var3.setLine(this.a - var4, this.b - var6, this.c + var4, this.d + var6);
            var1.a(var3);
            if(!var26) {
               break label23;
            }
         }

         var2 = new y.d.z(0.0D, -1.0D);
      }

      var4 = var2.a();
      var6 = var2.b();
      if(!this.g.isEmpty()) {
         Iterator var8 = this.g.iterator();

         while(var8.hasNext()) {
            y.d.t var9 = (y.d.t)var8.next();
            double var10 = var9.a() - 3.0D * (var4 - var6);
            double var12 = var9.b() - 3.0D * (var4 + var6);
            double var14 = var10 + var4 * 6.0D;
            double var16 = var12 + var6 * 6.0D;
            double var18 = var10 + var4 * 6.0D - var6 * 6.0D;
            double var20 = var12 + var6 * 6.0D + var4 * 6.0D;
            double var22 = var10 - var6 * 6.0D;
            double var24 = var12 + var4 * 6.0D;
            var3.setLine(var10, var12, var18, var20);
            var1.a(var3);
            var3.setLine(var14, var16, var22, var24);
            var1.a(var3);
            if(var26) {
               break;
            }
         }
      }

   }
}
