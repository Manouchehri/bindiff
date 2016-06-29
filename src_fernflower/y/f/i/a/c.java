package y.f.i.a;

import y.f.i.a.b;

class c {
   private y.c.d a;
   private int b;

   private c(y.c.d var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         c var2 = (c)var1;
         if(this.b != var2.b) {
            return false;
         } else {
            if(this.a != null) {
               if(!this.a.equals(var2.a)) {
                  return false;
               }
            } else if(var2.a != null) {
               return false;
            }

            return true;
         }
      } else {
         return false;
      }
   }

   public int hashCode() {
      int var1 = this.a != null?this.a.hashCode():0;
      var1 = 31 * var1 + this.b;
      return var1;
   }

   c(y.c.d var1, int var2, b var3) {
      this(var1, var2);
   }

   static y.c.d a(c var0) {
      return var0.a;
   }

   static int b(c var0) {
      return var0.b;
   }

   static int a(c var0, int var1) {
      return var0.b = var1;
   }
}
