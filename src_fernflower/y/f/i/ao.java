package y.f.i;

import y.f.i.ag;
import y.f.i.v;

class ao {
   public y.d.t k;
   public y.d.t l;
   private ag[] a;
   protected boolean m;
   private boolean b;
   boolean n;
   float o = Float.MAX_VALUE;
   float p = -3.4028235E38F;

   public ao(double var1, double var3, double var5, double var7, boolean var9) {
      this.k = new y.d.t(var1, var3);
      this.l = new y.d.t(var5, var7);
      this.a = new ag[2];
      this.m = var9;
   }

   public void a(ag var1, ag var2) {
      this.a[0] = var1;
      this.a[1] = var2;
   }

   public void n() {
      this.b = true;
   }

   public ag o() {
      return this.a[0];
   }

   public double p() {
      double var1;
      if(this.m) {
         var1 = this.l.a - this.k.a;
         if(v.f == 0) {
            return var1;
         }
      }

      var1 = this.l.b - this.k.b;
      return var1;
   }

   public double q() {
      double var1;
      if(this.m) {
         var1 = this.l.b - this.k.b;
         if(v.f == 0) {
            return var1;
         }
      }

      var1 = this.l.a - this.k.a;
      return var1;
   }

   public double r() {
      return (this.k.a + this.l.a) / 2.0D;
   }

   public double s() {
      return (this.k.b + this.l.b) / 2.0D;
   }

   public double t() {
      double var1;
      if(this.m) {
         var1 = this.k.a;
         if(v.f == 0) {
            return var1;
         }
      }

      var1 = this.k.b;
      return var1;
   }

   public double u() {
      double var1;
      if(this.m) {
         var1 = this.l.a;
         if(v.f == 0) {
            return var1;
         }
      }

      var1 = this.l.b;
      return var1;
   }

   public double v() {
      return this.m?this.k.b:this.k.a;
   }

   public double w() {
      return this.m?this.l.b:this.l.a;
   }

   public boolean x() {
      return this.m;
   }

   public boolean y() {
      return this.b;
   }

   public String toString() {
      return "[" + (this.m?"vertical":"horizontal") + ";(" + this.k + ")(" + this.l + ")]";
   }
}
