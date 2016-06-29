package y.f.f.a.b;

import y.f.f.a.b.E;
import y.f.f.a.b.F;
import y.f.f.a.b.n;

class G implements y.f.f.a.a.h {
   n a;
   boolean b;
   private final E c;

   private G(E var1) {
      this.c = var1;
      this.b = true;
   }

   public void a(y.f.f.a.a.e var1) {
      this.a = (n)var1;
      if(!this.a.d()) {
         this.a.b(E.a(this.c));
         if(!y.a.h.c(E.a(this.c))) {
            this.b = false;
         }

         this.a.a(E.a(this.c));
      }
   }

   G(E var1, F var2) {
      this(var1);
   }
}
