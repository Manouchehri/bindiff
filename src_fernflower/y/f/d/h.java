package y.f.d;

import java.util.Comparator;
import y.f.d.f;
import y.f.d.r;

class h implements Comparator {
   r[] a;
   private final f b;

   h(f var1, r[] var2) {
      this.b = var1;
      this.a = var2;
   }

   public int compare(Object var1, Object var2) {
      y.c.q var3 = (y.c.q)var1;
      y.c.q var4 = (y.c.q)var2;
      boolean var5 = this.a[this.b.p.a(var3)].c();
      boolean var6 = this.a[this.b.p.a(var4)].c();
      return var5 && var6?0:(var5?-1:(var6?1:(f.a(this.b).c(var3) < f.a(this.b).c(var4)?1:(f.a(this.b).c(var4) < f.a(this.b).c(var3)?-1:0))));
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof h && this.a == ((h)var1).a;
   }

   public int hashCode() {
      return this.a != null?this.a.hashCode():0;
   }
}
