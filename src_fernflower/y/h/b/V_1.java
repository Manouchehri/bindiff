package y.h.b;

import y.h.b.T;
import y.h.b.W;
import y.h.b.a;
import y.h.b.c;
import y.h.b.d;
import y.h.b.i;

final class V implements W {
   private final c a;
   private final T b;

   V(T var1, c var2) {
      this.b = var1;
      this.a = var2;
   }

   public boolean a() {
      return this.a.e();
   }

   public void a(boolean var1) {
      this.b.a(this.a, var1);
   }

   public boolean a(i var1) {
      return var1.b().isEmpty();
   }

   public a b() {
      int var2 = a.H;
      d var1 = this.a.a();

      while(true) {
         if(var1 instanceof c) {
            var1 = ((c)var1).a();
            if(var2 != 0) {
               break;
            }

            if(var2 == 0) {
               continue;
            }
         }

         if(var1 instanceof i) {
            return ((i)var1).a();
         }
         break;
      }

      return null;
   }
}
