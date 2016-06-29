package y.f.g;

import java.util.Comparator;
import y.f.g.o;
import y.f.g.s;

class u extends y.d.m {
   static final Comparator a = new s((o)null);
   private final int b;
   private final y.d.m c;

   u(y.d.t var1, y.d.t var2, int var3) {
      super(var1, var2);
      this.c = null;
      this.b = var3;
   }

   u(y.d.t var1, y.d.t var2, int var3, y.d.m var4) {
      super(var1, var2);
      this.b = var3;
      this.c = var4;
   }

   public boolean b() {
      return this.c().b == this.d().b;
   }

   public int l() {
      return this.b;
   }

   public y.d.m m() {
      return this.c;
   }

   public String toString() {
      return this.c() + " " + this.d() + " priority: " + this.b;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         u var2 = (u)var1;
         return this.b != var2.b?false:this.c().equals(var2.c()) && this.d().equals(var2.d());
      } else {
         return false;
      }
   }

   public int hashCode() {
      int var1 = this.b;
      var1 = 31 * var1 + this.c().hashCode();
      var1 = 31 * var1 + this.d().hashCode();
      return var1;
   }
}
