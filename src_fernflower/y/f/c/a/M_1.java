package y.f.c.a;

import y.f.c.a.E;
import y.f.c.a.N;

class M {
   final y.c.d a;
   final y.c.q b;
   final y.c.q c;
   private final E d;

   M(E var1, y.c.d var2, y.c.q var3, y.c.q var4) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   private void a() {
      if(this.a.c() != this.c && this.a.d() != this.c) {
         throw new RuntimeException("Edge should contain endpoint " + this.c);
      } else {
         if(!this.d.b.f(this.b)) {
            this.d.b.d(this.b);
         }

         this.d.b.a(this.b, this.d.b.r(this.c));
         this.d.b.a(this.b, this.d.b.l(this.c));
         boolean var1 = this.a.c() == this.c;
         if(var1) {
            this.d.b.a(this.a, this.b, this.a.d());
            if(!N.x) {
               return;
            }
         }

         this.d.b.a(this.a, this.a.c(), this.b);
      }
   }

   static void a(M var0) {
      var0.a();
   }
}
