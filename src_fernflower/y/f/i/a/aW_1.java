package y.f.i.a;

import y.f.i.a.ah;

class aW {
   private ah a;
   private ah b;

   aW(ah var1, ah var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof aW)) {
         return false;
      } else {
         aW var2 = (aW)var1;
         return this.a != null && this.b != null && var2.a != null && var2.b != null && this.a.equals(var2.a) && this.b.equals(var2.b);
      }
   }

   public int hashCode() {
      int var1 = this.a != null?this.a.hashCode():super.hashCode();
      var1 = 31 * var1 + (this.b != null?this.b.hashCode():super.hashCode());
      return var1;
   }
}
