package y.f.g;

import y.f.g.d;
import y.f.g.e;

class j {
   private final Object a;
   private final Object b;
   private final d c;

   private j(d var1, Object var2, Object var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         j var2 = (j)var1;
         if(this.b != null) {
            if(!this.b.equals(var2.b)) {
               return false;
            }
         } else if(var2.b != null) {
            return false;
         }

         if(this.a != null) {
            if(this.a.equals(var2.a)) {
               return true;
            }
         } else if(var2.a == null) {
            return true;
         }

         return false;
      } else {
         return false;
      }
   }

   public int hashCode() {
      int var1 = this.a != null?this.a.hashCode():0;
      var1 = 31 * var1 + (this.b != null?this.b.hashCode():0);
      return var1;
   }

   j(d var1, Object var2, Object var3, e var4) {
      this(var1, var2, var3);
   }
}
