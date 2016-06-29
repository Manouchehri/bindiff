package y.f.h.a;

import java.util.Iterator;
import y.f.h.a.b;
import y.f.h.a.h;
import y.f.h.a.i;
import y.f.h.a.q;

class p {
   h a = new h((i)null, (h)null, (h)null);

   p() {
      this.a.a(this.a);
      this.a.b(this.a);
   }

   public Iterator a() {
      return new q(this);
   }

   h a(i var1) {
      return this.a.c.a(var1);
   }

   i b() {
      return this.a.b.a();
   }

   i c() {
      return this.a.c.a();
   }

   public String toString() {
      boolean var3 = b.g;
      String var1 = "[";
      Iterator var2 = this.a();

      String var10000;
      while(true) {
         if(var2.hasNext()) {
            var10000 = var1;
            if(var3) {
               break;
            }

            if(var1 != "[") {
               var1 = var1 + ", ";
            }

            var1 = var1 + "(" + var2.next().toString() + ")";
            if(!var3) {
               continue;
            }
         }

         var10000 = var1 + "]";
         break;
      }

      return var10000;
   }
}
