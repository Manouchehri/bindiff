package y.f.i;

import y.f.i.n;

class o extends y.g.p {
   private final byte a;
   private final y.c.c b;
   private final y.c.c d;
   private final y.c.A e;
   private final n f;

   o(n var1, byte var2, y.c.c var3, y.c.c var4, y.c.A var5) {
      this.f = var1;
      this.a = var2;
      this.b = var3;
      this.d = var4;
      this.e = var5;
   }

   public boolean d(Object var1) {
      y.c.d var2 = (y.c.d)var1;
      if(this.a == 2 && !this.b.d(var2)) {
         return false;
      } else {
         if(this.a == 4) {
            if(!this.d.d(var2.c()) && !this.d.d(var2.d())) {
               return false;
            }
         } else if(this.e.d(var2.c())) {
            return false;
         }

         return true;
      }
   }
}
