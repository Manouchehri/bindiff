package y.f.c.a;

import y.f.c.a.aM;
import y.f.c.a.aQ;
import y.f.c.a.aY;
import y.f.c.a.bK;

class ar extends aM {
   y.c.D a;
   private final y.c.q b;
   private final y.c.d c;

   public y.c.p d() {
      return this.a != null?this.a.k():null;
   }

   public y.c.p a(y.c.d var1) {
      if(this.a == null) {
         this.a = new y.c.D();
      }

      return this.a.b((Object)var1);
   }

   public void a(y.c.p var1) {
      this.a.h(var1);
      if(this.a.isEmpty()) {
         this.a = null;
      }

   }

   public int e() {
      return this.a != null?this.a.size():0;
   }

   ar(bK var1, y.c.q var2, aQ var3, y.c.d var4) {
      super((aY)null, var1);
      this.b = var2;
      this.c = var4;
      this.a((y.c.q)var2);
      this.a((aQ)var3);
   }

   public y.c.d g() {
      return this.c;
   }

   public y.c.q f() {
      return this.b;
   }

   public byte b() {
      return (byte)15;
   }
}
