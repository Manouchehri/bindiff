package y.f.k;

import y.f.k.d;

class U {
   y.f.X a;
   y.c.q b;

   public U(y.f.X var1) {
      this.a = var1;
      this.b();
   }

   public y.c.q a() {
      if(this.b == null) {
         this.b();
      }

      return this.b;
   }

   public boolean a(y.c.q var1) {
      return var1.c() == 0;
   }

   private void b() {
      int var2 = d.g;
      y.c.x var1 = this.a.o();

      while(var1.f()) {
         if(var1.e().b() == 0) {
            this.b = var1.e();
            return;
         }

         var1.g();
         if(var2 != 0) {
            break;
         }
      }

   }
}
