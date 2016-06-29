package y.f.d;

import y.f.Q;

class j implements y.d.o {
   private Q a;
   private Object b;
   private y.d.o c;
   private byte d;

   j(Object var1, y.d.o var2, byte var3) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.a = null;
   }

   j(Object var1, Q var2, byte var3) {
      this.b = var1;
      this.a = var2;
      this.c = var2.h();
      this.d = var3;
   }

   public Object a() {
      return this.b;
   }

   public y.d.o b() {
      return this.c;
   }

   public byte c() {
      return this.d;
   }

   public Q d() {
      return this.a;
   }

   public y.d.y h() {
      return this.c.h();
   }
}
