package y.h;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D.Double;
import y.h.aB;
import y.h.bu;
import y.h.dr;
import y.h.hC;

public class x {
   private aB c;
   double a;
   double b;
   private boolean d;

   public y.c.d a() {
      return this.c.getEdge();
   }

   public void a(double var1, double var3) {
      double var5 = this.a;
      double var7 = this.b;
      this.a = var1;
      this.b = var3;
      this.c.bendChanged(this, var5, var7);
      this.c.setDirty();
   }

   public void b(double var1, double var3) {
      this.a += var1;
      this.b += var3;
      this.c.bendChanged(this, this.a - var1, this.b - var3);
      this.c.setDirty();
   }

   public double b() {
      return this.a;
   }

   public double c() {
      return this.b;
   }

   public boolean d() {
      return this.d;
   }

   y.d.t e() {
      return new y.d.t(this.b(), this.c());
   }

   public void a(boolean var1) {
      if(var1 != this.d) {
         this.d = var1;
         bu var2 = this.c.i();
         if(var2 != null) {
            var2.e(this);
         }
      }

   }

   public boolean c(double var1, double var3) {
      return (this.a - var1) * (this.a - var1) + (var3 - this.b) * (var3 - this.b) < 25.0D;
   }

   public boolean a(double var1, double var3, double var5, double var7) {
      return this.a <= var1 + var5 && this.a >= var1 && this.b <= var3 + var7 && this.b >= var3;
   }

   public void a(Graphics2D var1) {
      a(var1, this.a, this.b, Color.black);
   }

   public static void a(Graphics2D var0, double var1, double var3, Color var5) {
      Color var6 = var0.getColor();
      Double var7 = hC.a().k;
      var7.width = var7.height = 4.0D;
      Stroke var8 = var0.getStroke();
      var0.setStroke(dr.a);
      var0.setColor(var5);
      var7.x = var1 - 5.0D;
      var7.y = var3 - 5.0D;
      var0.fill(var7);
      var7.x = var1 + 1.0D;
      var7.y = var3 + 1.0D;
      var0.fill(var7);
      var7.x = var1 - 5.0D;
      var7.y = var3 + 1.0D;
      var0.fill(var7);
      var7.x = var1 + 1.0D;
      var7.y = var3 - 5.0D;
      var0.fill(var7);
      var0.setColor(var6);
      var0.setStroke(var8);
   }

   protected x(aB var1, double var2, double var4) {
      this.c = var1;
      this.a = var2;
      this.b = var4;
   }

   public String toString() {
      return "(" + this.a + ' ' + this.b + ')';
   }
}
