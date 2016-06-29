package y.f.b;

import y.c.D;

class n {
   D a = null;
   D b = null;
   D c = null;
   D d = null;

   public D a() {
      D var1 = new D();
      if(this.a != null) {
         var1.addAll(this.a);
      }

      if(this.b != null) {
         var1.addAll(this.b);
      }

      if(this.c != null) {
         var1.addAll(this.c);
      }

      if(this.d != null) {
         var1.addAll(this.d);
      }

      return var1;
   }
}
