package y.f.i.a;

import y.f.i.a.E;
import y.f.i.a.ab;
import y.f.i.a.y;

class B implements y.d.g {
   private final y.c.h a;
   private final y.c.h b;
   private final y.c.h c;
   private final y.c.f d;
   private final y e;

   B(y var1, y.c.h var2, y.c.h var3, y.c.h var4, y.c.f var5) {
      this.e = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
   }

   public void a(Object var1, Object var2) {
      E var3 = (E)var1;
      E var4 = (E)var2;
      if(y.d.m.a(E.a(var3), E.a(var4)) != null) {
         if(E.b(var3) == E.b(var4)) {
            this.a.a(E.b(var3), this.a.a(E.b(var3)) + 1);
            if(!this.b.d(E.b(var3)) || y.a(this.e, E.b(var3)) || this.c.d(E.b(var3))) {
               return;
            }

            this.d.add(E.b(var3));
            this.c.a(E.b(var3), true);
            if(ab.a == 0) {
               return;
            }
         }

         this.a.a(E.b(var3), this.a.a(E.b(var3)) + 1);
         this.a.a(E.b(var4), this.a.a(E.b(var4)) + 1);
      }

   }
}
