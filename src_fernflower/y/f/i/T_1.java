package y.f.i;

class T implements Cloneable {
   final boolean a;
   final double b;
   double c;
   final double d;
   final double e;

   T(double var1, double var3, double var5, double var7, boolean var9) {
      this.e = var7;
      this.b = var1;
      this.d = var5;
      this.c = var3;
      this.a = var9;
   }

   public Object clone() {
      try {
         return super.clone();
      } catch (CloneNotSupportedException var2) {
         throw new InternalError();
      }
   }
}
