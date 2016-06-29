package y.f.h.a;

import y.f.h.a.i;

class h {
   i a;
   h b;
   h c;

   h(i var1, h var2, h var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   i a() {
      return this.a;
   }

   void a(h var1) {
      this.b = var1;
   }

   void b(h var1) {
      this.c = var1;
   }

   void b() {
      this.b.b(this.c);
      this.c.a(this.b);
   }

   h a(i var1) {
      h var2 = new h(var1, this.b, this);
      this.b.b(var2);
      this.a(var2);
      return var2;
   }
}
