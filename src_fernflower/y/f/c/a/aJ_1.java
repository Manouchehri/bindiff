package y.f.c.a;

import y.f.c.a.Z;
import y.f.c.a.aM;
import y.f.c.a.aY;
import y.f.c.a.as;
import y.f.c.a.bK;

class aJ extends aM implements as {
   final byte d;
   final Z e;

   aJ(byte var1, aY var2, bK var3, Z var4) {
      super(var2, var3);
      this.d = var1;
      this.e = var4 == null?Z.a:var4;
   }

   public Z c() {
      return this.e;
   }

   public byte b() {
      return this.d;
   }
}
