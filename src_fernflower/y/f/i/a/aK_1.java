package y.f.i.a;

import y.f.i.a.aI;
import y.f.i.a.aJ;

class aK {
   final aJ a;
   final aJ b;
   final y.d.t c;
   final int d;

   private aK(aJ var1, aJ var2, y.d.t var3, int var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public int a() {
      return Math.min(this.a.a, this.b.a);
   }

   public int b() {
      return Math.max(this.a.a, this.b.a);
   }

   aK(aJ var1, aJ var2, y.d.t var3, int var4, aI var5) {
      this(var1, var2, var3, var4);
   }
}
