package y.h;

class eA implements Comparable {
   final double a;
   final y.c.q b;
   final boolean c;
   final double d;
   final double e;

   public eA(double var1, y.c.q var3, boolean var4, double var5, double var7) {
      this.a = var1;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.e = var7;
   }

   public int compareTo(Object var1) {
      eA var2 = (eA)var1;
      int var3 = y.g.e.a(this.a, var2.a);
      return var3 != 0?var3:(this.c != var2.c?(this.c?1:-1):0);
   }
}
