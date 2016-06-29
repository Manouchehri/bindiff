package y.f.h;

import y.f.h.D;
import y.f.h.N;
import y.f.h.p;
import y.f.h.x;

class V extends y.a.e implements x {
   private y.c.f a = new y.c.f();
   private y.c.i f = null;

   public void a(D var1) {
      boolean var3 = N.d;
      this.f = var1.g();
      this.a(this.f);
      y.g.o.a(0, "  Create reversed edges ...");
      y.c.e var2 = this.f.p();
      var2.j();

      while(true) {
         if(var2.f()) {
            var1.g(var2.a());
            var2.h();
            if(var3) {
               break;
            }

            if(!var3) {
               continue;
            }
         }

         var1.l();
         var1.b((p)var1.i(var2.a()));
         break;
      }

   }

   public y.c.f c_() {
      return this.a;
   }

   protected void a(y.c.d var1, y.c.q var2, boolean var3) {
      if(!var3) {
         this.a.add(var1);
         var2.e().d(var1);
      }

   }
}
