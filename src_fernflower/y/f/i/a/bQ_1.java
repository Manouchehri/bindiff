package y.f.i.a;

final class bQ {
   private final y.c.q a;
   private final Object b;

   bQ(y.c.q var1, Object var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof bQ)) {
         return false;
      } else {
         bQ var2 = (bQ)var1;
         if(this.a != var2.a) {
            return false;
         } else {
            if(this.b != null) {
               if(!this.b.equals(var2.b)) {
                  return false;
               }
            } else if(var2.b != null) {
               return false;
            }

            return true;
         }
      }
   }

   public int hashCode() {
      int var1 = this.a != null?this.a.hashCode():0;
      var1 = 31 * var1 + (this.b != null?this.b.hashCode():0);
      return var1;
   }
}
