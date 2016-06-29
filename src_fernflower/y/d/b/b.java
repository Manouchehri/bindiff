package y.d.b;

import y.d.b.c;
import y.d.b.d;
import y.d.b.t;
import y.d.b.u;
import y.d.b.z;

public class b {
   protected u a;
   private z b;
   private z c;
   private z d;
   private double e;
   private double f;
   private double g;
   private int h;

   public b(z var1, z var2, z var3, u var4) {
      label11: {
         super();
         if(var3.f(var3.a()) > 0) {
            this.b = var1;
            this.c = var2;
            this.d = var3;
            if(c.a == 0) {
               break label11;
            }
         }

         this.b = var1.d();
         this.c = var2.d();
         this.d = var3.d();
      }

      this.e = this.b.e();
      this.f = this.c.e();
      this.g = this.d.e();
      this.h = (int)(this.e + this.f + this.g);
      this.a = var4;
   }

   public b(z var1, z var2, u var3) {
      this(var1, var2, var1.b(), var3);
   }

   public b(z var1, z var2, z var3) {
      this(var1, var2, var3, d.a());
   }

   public final z a() {
      return this.b;
   }

   public final z b() {
      return this.c;
   }

   public final z c() {
      return this.d;
   }

   public final double d() {
      return this.e;
   }

   public final double e() {
      return this.f;
   }

   public final double f() {
      return this.g;
   }

   public final t a(b var1) {
      z var2 = this.b.c(var1.c()).b(var1.a().c(this.d));
      z var3 = this.c.c(var1.c()).b(var1.b().c(this.d));
      z var4 = this.d.c(var1.c());
      return new t(var2, var3, var4);
   }

   public final void g() {
      z var1 = this.b.e(this.c);
      var1 = var1.e(this.d);
      this.b = this.b.d(var1);
      this.c = this.c.d(var1);
      this.d = this.d.d(var1);
      this.e = this.b.e();
      this.f = this.c.e();
      this.g = this.d.e();
   }

   public final boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof b)) {
         return false;
      } else {
         b var2 = (b)var1;
         z var3 = this.b.c(var2.c()).b(var2.a().c(this.d));
         z var4 = this.c.c(var2.c()).b(var2.b().c(this.d));
         return var3.c() == 0 && var4.c() == 0;
      }
   }

   public int hashCode() {
      return this.h;
   }

   public String toString() {
      return "X: " + this.b + " Y: " + this.c + " W: " + this.d;
   }
}
