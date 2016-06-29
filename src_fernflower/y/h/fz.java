package y.h;

import java.awt.geom.Point2D;

class fz {
   private double a;
   private double b;
   private double c;
   private double d;

   public fz() {
      this(-1.7976931348623157E308D, Double.MAX_VALUE, -1.7976931348623157E308D, Double.MAX_VALUE);
   }

   public fz(double var1, double var3, double var5, double var7) {
      this.a = var1;
      this.b = var3;
      this.c = var5;
      this.d = var7;
   }

   public double a() {
      return this.a;
   }

   public void a(double var1) {
      this.a = var1;
   }

   public double b() {
      return this.b;
   }

   public void b(double var1) {
      this.b = var1;
   }

   public double c() {
      return this.c;
   }

   public void c(double var1) {
      this.c = var1;
   }

   public double d() {
      return this.d;
   }

   public void d(double var1) {
      this.d = var1;
   }

   public void a(Point2D var1) {
      if(var1.getX() > this.b()) {
         var1.setLocation(this.b(), var1.getY());
      }

      if(var1.getX() < this.a()) {
         var1.setLocation(this.a(), var1.getY());
      }

      if(var1.getY() > this.d()) {
         var1.setLocation(var1.getX(), this.d());
      }

      if(var1.getY() < this.c()) {
         var1.setLocation(var1.getX(), this.c());
      }

   }

   boolean a(double var1, double var3) {
      return this.a() <= var1 && var1 <= this.b() && this.c() <= var3 && var3 <= this.d();
   }
}
