package y.f.c.a;

import y.f.c.a.aM;
import y.f.c.a.aQ;
import y.f.c.a.aY;
import y.f.c.a.as;
import y.f.c.a.bK;

class aC extends aM implements as {
   byte a;
   private y.c.D b;

   aC(bK var1, y.c.q var2, aQ var3, byte var4) {
      super((aY)null, var1);
      this.a = var4;
      this.a((y.c.q)var2);
      this.a((aQ)var3);
   }

   public byte b() {
      return this.a;
   }

   public y.c.q f() {
      return this.l();
   }

   public y.c.p d() {
      return this.b != null?this.b.k():null;
   }

   public y.c.p a(y.c.d var1) {
      if(this.b == null) {
         this.b = new y.c.D();
      }

      return this.b.b((Object)var1);
   }

   public void a(y.c.p var1) {
      this.b.h(var1);
      if(this.b.isEmpty()) {
         this.b = null;
      }

   }

   public int e() {
      return this.b != null?this.b.size():0;
   }
}
