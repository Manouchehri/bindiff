package y.f.c.a;

import y.f.c.a.N;
import y.f.c.a.bz;

class bG {
   private y.c.q a;
   private y.c.q b;

   private bG() {
   }

   public void a(y.c.q var1) {
      if(this.a == null) {
         this.a = var1;
         if(!N.x) {
            return;
         }
      }

      throw new RuntimeException("Proxy already set!");
   }

   public void b(y.c.q var1) {
      if(this.b == null) {
         this.b = var1;
         if(!N.x) {
            return;
         }
      }

      throw new RuntimeException("Proxy already set!");
   }

   public y.c.q a() {
      return this.a;
   }

   public y.c.q b() {
      return this.b;
   }

   bG(bz var1) {
      this();
   }
}
