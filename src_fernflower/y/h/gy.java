package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D.Double;
import y.h.az;
import y.h.fj;

public class gy implements az {
   private final byte a;
   private final byte b;
   private final y.d.t c;
   private Object d;
   private double e;
   private double f;
   private double g = 1.0D;

   public gy(byte var1, byte var2, y.d.t var3, Object var4, double var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.g = var5;
      if(var1 == 1) {
         this.e = var3.b - 1000.0D;
         this.f = var3.b + 1000.0D;
         if(!fj.z) {
            return;
         }
      }

      this.e = var3.a - 1000.0D;
      this.f = var3.a + 1000.0D;
   }

   public gy(byte var1, byte var2, y.d.t var3, double var4, double var6, Object var8, double var9) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.e = var4;
      this.f = var6;
      this.d = var8;
      this.g = var9;
   }

   public double a() {
      return this.g;
   }

   public y.d.t b() {
      return this.c;
   }

   public byte c() {
      return this.a;
   }

   public byte d() {
      return this.b;
   }

   public double e() {
      return this.e;
   }

   public double f() {
      return this.f;
   }

   public void a(double var1) {
      this.e = var1;
   }

   public void b(double var1) {
      this.f = var1;
   }

   public Rectangle getBounds() {
      y.d.t var1 = this.b();
      Double var2;
      if(this.a == 1) {
         var2 = new Double(var1.a - 5.0D, this.e - 10.0D, var1.a + 5.0D, this.f + 10.0D);
         if(!fj.z) {
            return var2.getBounds();
         }
      }

      var2 = new Double(this.e - 10.0D, var1.b - 5.0D, this.f + 10.0D, var1.b + 5.0D);
      return var2.getBounds();
   }

   public void a(Graphics2D var1) {
      Double var3;
      double var4;
      double var6;
      label11: {
         y.d.t var2 = this.b();
         var4 = var2.a;
         var6 = var2.b;
         if(this.a == 1) {
            var3 = new Double(var4, this.e - 10.0D, var4, this.f + 10.0D);
            a(var1, var4, this.e);
            a(var1, var4, this.f);
            if(!fj.z) {
               break label11;
            }
         }

         var3 = new Double(this.e - 10.0D, var6, this.f + 10.0D, var6);
         a(var1, this.e, var6);
         a(var1, this.f, var6);
      }

      var1.draw(var3);
      a(var1, var4, var6);
   }

   static void a(Graphics2D var0, double var1, double var3) {
      var0.draw(new Double(var1 - 3.0D, var3 - 3.0D, var1 + 3.0D, var3 + 3.0D));
      var0.draw(new Double(var1 - 3.0D, var3 + 3.0D, var1 + 3.0D, var3 - 3.0D));
   }

   public Object g() {
      return this.d;
   }
}
