package y.f.c.a;

import y.f.c.a.aM;
import y.f.c.a.aY;
import y.f.c.a.as;
import y.f.c.a.bK;

class aq extends aM implements as {
   y.c.p a;
   private y.c.q b;
   private y.c.d c;

   aq(y.c.d var1, y.c.d var2, y.c.q var3, bK var4) {
      super((aY)null, var4);
      this.c = var1;
      this.b = var3;
   }

   public byte b() {
      return (byte)8;
   }

   public y.c.p d() {
      return this.a;
   }

   public y.c.p a(y.c.d var1) {
      if(this.a == null) {
         this.a = (new y.c.D()).b((Object)var1);
         return this.a;
      } else {
         throw new UnsupportedOperationException();
      }
   }

   public int e() {
      return this.a != null?1:0;
   }

   public y.c.q f() {
      return this.b;
   }

   public y.c.d g() {
      return this.c;
   }
}
