package y.d.b;

import y.d.b.d;
import y.d.b.u;
import y.d.b.z;

public class t {
   protected u a;
   private z e;
   private z f;
   private z g;
   protected double b;
   protected double c;
   protected double d;
   private int h;

   public t(z var1, z var2, z var3, u var4) {
      this.e = var1;
      this.f = var2;
      this.g = var3;
      this.a = var4;
      this.b = this.e.e();
      this.c = this.f.e();
      this.d = this.g.e();
      this.h = (int)(this.b + this.c + this.d);
   }

   public t(z var1, z var2, z var3) {
      this(var1, var2, var3, d.a());
   }

   public z a() {
      return this.e;
   }

   public z b() {
      return this.f;
   }

   public z c() {
      return this.g;
   }

   public double a(t var1) {
      double var2 = Math.acos((this.b * var1.b + this.c * var1.c) / (Math.sqrt(this.b * this.b + this.c * this.c) * Math.sqrt(var1.b * var1.b + var1.c * var1.c)));
      if(this.b * var1.c + this.c * var1.b > 0.0D) {
         var2 = 6.283185307179586D - var2;
      }

      return var2;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof t)) {
         return false;
      } else {
         t var2 = (t)var1;
         z var3 = this.e.c(var2.c()).b(var2.a().c(this.g));
         z var4 = this.f.c(var2.c()).b(var2.b().c(this.g));
         return var3.c() == 0 && var4.c() == 0;
      }
   }

   public int hashCode() {
      return this.h;
   }

   public String toString() {
      return "(" + this.e + "," + this.f + "," + this.g + ")";
   }
}
