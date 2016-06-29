package y.f.i.a;

import y.f.i.a.ai;
import y.f.i.a.aj;

final class ap {
   final ai a;
   final ai b;
   private final aj c;

   public ap(aj var1, ai var2, ai var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         ap var2 = (ap)var1;
         return this.a.equals(var2.a) && this.b.equals(var2.b);
      } else {
         return false;
      }
   }

   public int hashCode() {
      int var1 = this.a.hashCode();
      var1 = 31 * var1 + this.b.hashCode();
      return var1;
   }
}
