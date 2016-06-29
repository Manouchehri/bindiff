package y.h;

import y.h.fB;
import y.h.fj;

final class fC {
   final fB a;
   final fB b;
   private boolean c;

   fC(y.d.t var1, double var2, double var4) {
      this.a = new fB(this, var1.a(), var2);
      this.b = new fB(this, var1.b(), var4);
      this.c = true;
   }

   boolean a() {
      return this.c;
   }

   void b() {
      this.c = false;
   }

   void a(double var1, double var3, byte var5) {
      switch(var5) {
      case 0:
         this.b.b(var3);
         if(!fj.z) {
            break;
         }
      case 1:
         this.a.b(var1);
      }

   }
}
