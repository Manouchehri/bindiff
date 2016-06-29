package y.a;

import y.a.ag;
import y.a.ai;
import y.a.h;

class ah extends ai {
   final y.c.y a;
   final y.c.f b;
   y.c.A c;
   final y.c.h d;
   private final ag j;

   ah(ag var1, y.c.i var2) {
      super(var1, var2);
      this.j = var1;
      this.d = var2.u();
      this.a = new y.c.y();
      this.b = new y.c.f();
   }

   void a() {
      this.e.a(this.d);
      this.a.clear();
      this.b.clear();
      this.c = null;
      super.a();
   }

   y.c.y[] a(y.c.y var1, y.c.A var2) {
      boolean var4 = h.a;
      ag.a(this.j).a(this.e, var1, this.c, this.d);
      ag.a(this.b.a(), (y.c.b)this.f, (y.c.c)this.d);
      y.c.e var3 = this.b.a();

      ah var10000;
      while(true) {
         if(var3.f()) {
            var10000 = this;
            if(var4) {
               break;
            }

            super.a(var3.a());
            var3.g();
            if(!var4) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      return var10000.a(var1, var2);
   }

   void a(y.c.y var1) {
   }

   y.c.d b() {
      y.c.d var1 = super.b();
      this.a.clear();
      this.b.clear();
      this.c = y.g.M.a(new int[this.e.e()]);
      ag.a(var1, ag.a(this.j).b(), this.a, this.b, this.c);
      ag.a(this.j).a(this.e, this.a, this.c, this.d);
      ag.b(this.b.a(), this.f, this.d);
      this.b.remove(var1);
      return var1;
   }
}
