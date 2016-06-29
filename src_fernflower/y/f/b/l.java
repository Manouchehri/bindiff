package y.f.b;

import y.c.q;
import y.c.y;
import y.f.b.c;
import y.f.b.j;
import y.g.I;

class l {
   private c a;
   private I b;
   private final j c;

   l(j var1, y.c.i var2, c var3) {
      this.c = var1;
      this.a = var3;
      this.b = new I(var2);
   }

   public void a(q var1) {
      int var5 = c.a;
      this.b.a();
      if(var1 == null || j.a(this.c, var1)) {
         y var2 = new y();
         y var3 = new y(this.a.b(var1));

         do {
            if(var3.isEmpty()) {
               return;
            }

            q var4 = var3.d();
            var2.add(var4);
            if(j.a(this.c, var4, this.a) && !j.a(this.c, var4)) {
               var3.addAll(this.a.b(var4));
            }

            this.b.a(var2, true);
         } while(var5 == 0);
      }

      this.b.a(var1, false);
   }

   public void a() {
      this.b.f();
   }
}
