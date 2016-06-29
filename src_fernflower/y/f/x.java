package y.f;

import y.f.am;

public class x implements am {
   protected double a;
   protected double b;
   protected double c;
   protected double d;

   public x() {
   }

   public x(am var1) {
      this(var1.getX(), var1.getY(), var1.getWidth(), var1.getHeight());
   }

   public x(double var1, double var3, double var5, double var7) {
      this.a = var1;
      this.b = var3;
      this.c = var5;
      this.d = var7;
   }

   public void setLocation(double var1, double var3) {
      this.a = var1;
      this.b = var3;
   }

   public void a(double var1, double var3) {
      this.a = var1 - this.c / 2.0D;
      this.b = var3 - this.d / 2.0D;
   }

   public void setSize(double var1, double var3) {
      this.c = var1;
      this.d = var3;
   }

   public double getHeight() {
      return this.d;
   }

   public double getWidth() {
      return this.c;
   }

   public double getX() {
      return this.a;
   }

   public double getY() {
      return this.b;
   }
}
