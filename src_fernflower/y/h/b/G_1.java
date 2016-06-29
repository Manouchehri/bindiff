package y.h.b;

import java.awt.geom.Rectangle2D;
import java.util.Collection;
import y.h.bu;
import y.h.b.B;
import y.h.b.C;
import y.h.b.f;

final class G implements C {
   private final Rectangle2D a;
   private final B b;

   G(Rectangle2D var1, B var2) {
      this.a = var1;
      this.b = var2;
   }

   public double a(Object var1) {
      return ((f)var1).g();
   }

   public double b(Object var1) {
      return ((f)var1).f();
   }

   public y.d.r c(Object var1) {
      return ((f)var1).i();
   }

   public int d(Object var1) {
      return ((f)var1).n();
   }

   public Collection e(Object var1) {
      return ((f)var1).o();
   }

   public y.d.r a(double var1, double var3) {
      return new y.d.r(var1, 0.0D, var3, 0.0D);
   }

   public double a(y.d.r var1) {
      return var1.b;
   }

   public double b(y.d.r var1) {
      return var1.d;
   }

   public double c(y.d.r var1) {
      return var1.a;
   }

   public double d(y.d.r var1) {
      return var1.c;
   }

   public double a() {
      return this.a.getY();
   }

   public double b() {
      return this.a.getMaxY();
   }

   public double a(bu var1, y.c.q var2) {
      return var1.k(var2);
   }

   public Collection c() {
      return this.b.e;
   }

   public y.d.r f(Object var1) {
      return (y.d.r)this.b.f.get(var1);
   }
}
