package y.h.b;

import y.h.b.K;

public final class L {
   private final int a;

   private L(int var1) {
      this.a = var1;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         L var2 = (L)var1;
         return this.a == var2.a;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.a;
   }

   L(int var1, K var2) {
      this(var1);
   }
}
