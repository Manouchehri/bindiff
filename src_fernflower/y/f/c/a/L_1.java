package y.f.c.a;

import y.f.c.a.E;

class L {
   final Object a;
   final Object b;
   private final E c;

   L(E var1, Object var2, Object var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         L var2 = (L)var1;
         if(this.a != null) {
            if(!this.a.equals(var2.a)) {
               return false;
            }
         } else if(var2.a != null) {
            return false;
         }

         boolean var10000;
         label51: {
            if(this.b != null) {
               if(!this.b.equals(var2.b)) {
                  break label51;
               }
            } else if(var2.b != null) {
               break label51;
            }

            var10000 = true;
            return var10000;
         }

         var10000 = false;
         return var10000;
      } else {
         return false;
      }
   }

   public int hashCode() {
      int var1 = this.a != null?this.a.hashCode():0;
      var1 = 31 * var1 + (this.b != null?this.b.hashCode():0);
      return var1;
   }
}
