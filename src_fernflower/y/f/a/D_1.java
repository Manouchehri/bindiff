package y.f.a;

import y.f.a.B;
import y.f.a.z;

class D {
   B a;
   B b;
   private final z c;

   public D(z var1, B var2, B var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof D)) {
         return false;
      } else {
         D var2 = (D)var1;
         return B.a(this.a) == B.a(var2.a) && B.a(this.b) == B.a(var2.b) || B.a(this.a) == B.a(var2.b) && B.a(this.b) == B.a(var2.a);
      }
   }

   public int hashCode() {
      int var1 = this.a.hashCode();
      int var2 = this.b.hashCode();
      return var1 ^ var2;
   }
}
