package y.f.c.a;

import y.f.c.a.bi;
import y.f.c.a.bt;
import y.f.c.a.l;

public final class bj implements Comparable {
   final bt a;
   final l b;

   private bj(bt var1, l var2) {
      this.a = var1;
      this.b = var2;
   }

   public bt a() {
      return this.a;
   }

   public l b() {
      return this.b;
   }

   public int compareTo(Object var1) {
      bj var2 = (bj)var1;
      int var3 = y.g.e.a(this.a.a(), var2.a.a());
      return var3 != 0?var3:y.g.e.a(this.b.a(), var2.b.a());
   }

   bj(bt var1, l var2, bi var3) {
      this(var1, var2);
   }
}
