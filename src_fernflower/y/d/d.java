package y.d;

public class d {
   y.c.p a;
   double b;
   double c;
   double d;

   d(double var1, double var3, double var5) {
      this.c = var1;
      this.b = var3;
      this.d = var5;
   }

   static d a(double var0, double var2, double var4) {
      return new d(var0, var2, var4);
   }

   public double a(double var1) {
      if(var1 != this.c && this.d != 0.0D) {
         double var3 = var1 - this.c;
         return this.b + var3 * this.d;
      } else {
         return this.b;
      }
   }

   public double a() {
      y.c.p var1 = this.a.a();
      return var1 == null?Double.MAX_VALUE:((d)var1.c()).c;
   }

   public final d b() {
      return this.a.b() != null?(d)this.a.b().c():null;
   }

   public String toString() {
      return "Segment [" + this.c + " - " + this.a() + "], value=" + this.b + ", slope=" + this.d;
   }
}
