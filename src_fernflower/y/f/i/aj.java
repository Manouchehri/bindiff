package y.f.i;

class aj {
   public final y.c.d a;
   public double b;
   public final double c;
   public final double d;

   aj(y.c.d var1, double var2, double var4, double var6) {
      this.a = var1;
      this.b = var2;
      double var8 = Math.max(var4, var6);
      this.c = Math.min(var4, var6);
      this.d = var8;
   }

   private void a(double var1) {
      this.b = var1;
   }

   public String toString() {
      return "[e=" + this.a + "; coord=" + this.b + "; from=" + this.c + "; to=" + this.d + "]";
   }

   static void a(aj var0, double var1) {
      var0.a(var1);
   }
}
