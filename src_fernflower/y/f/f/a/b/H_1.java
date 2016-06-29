package y.f.f.a.b;

import y.f.f.a.b.E;
import y.f.f.a.b.F;
import y.f.f.a.b.a;
import y.f.f.a.b.n;

class H implements y.f.f.a.a.h {
   n a;
   y.c.f b;
   private final E c;

   private H(E var1) {
      this.c = var1;
   }

   public void a(y.f.f.a.a.e var1) {
      boolean var3 = a.c;
      this.a = (n)var1;
      if(!this.a.d()) {
         label41: {
            this.a.b(E.a(this.c));
            if(E.b(this.c) == 0) {
               this.b = y.a.h.b(E.a(this.c));
               if(!var3) {
                  break label41;
               }
            }

            if(E.b(this.c) != 1) {
               throw new RuntimeException("Bad connection mode!");
            }

            this.b = y.a.h.e(E.a(this.c));
            if(var3) {
               throw new RuntimeException("Bad connection mode!");
            }
         }

         y.c.e var2 = this.b.a();

         while(true) {
            if(var2.f()) {
               E.c(this.c).add(var2.a());
               this.a.a(var2.a());
               var2.g();
               if(var3) {
                  break;
               }

               if(!var3) {
                  continue;
               }
            }

            this.a.a(E.a(this.c));
            break;
         }

      }
   }

   H(E var1, F var2) {
      this(var1);
   }
}
