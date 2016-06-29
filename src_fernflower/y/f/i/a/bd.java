package y.f.i.a;

import y.f.i.a.M;
import y.f.i.a.P;
import y.f.i.a.bc;
import y.f.i.a.g;

class bd {
   y.c.D a;
   M b;
   double c;
   double d;
   private final bc e;

   bd(bc var1, g var2) {
      this.e = var1;
      this.b = bc.f(var1) != null && bc.f(var1).a(var2.c(), var2.g())?bc.f(var1).b(var2.c(), var2.g()):var2.c();
      this.a = new y.c.D();
      this.a.add(var2);
   }

   bd(bc var1, P var2) {
      this.e = var1;
      M var3 = var2.e();
      this.b = bc.f(var1) != null && bc.f(var1).a(var3, !var2.a())?bc.f(var1).b(var3, !var2.a()):var3;
   }
}
