package y.f.c.a;

import y.f.c.a.dq;

class dr {
   private final y.d.t a;
   private final y.c.d b;

   private dr(y.c.d var1, y.d.t var2) {
      this.b = var1;
      this.a = var2;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         dr var2 = (dr)var1;
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

   dr(y.c.d var1, y.d.t var2, dq var3) {
      this(var1, var2);
   }
}
