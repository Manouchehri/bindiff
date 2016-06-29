package y.f.e.a;

import y.f.e.a.G;
import y.f.e.a.a;
import y.f.e.a.ag;
import y.f.e.a.k;
import y.f.e.a.l;

class b implements G {
   private double a;

   b() {
      this(100.0D);
   }

   b(double var1) {
      this.a = var1;
   }

   public void a(ag var1, l var2, a var3) {
      if(var1.e() != 0.0D) {
         if(var1.g() != 1.0D) {
            double var4 = Math.sqrt(var1.e());
            if(var4 != 0.0D) {
               k var6 = var1.f();
               if(!var6.g()) {
                  var3.b(var6.d(), var6.e(), var6.f());
                  var3.b();
                  var3.d((1.0D - var1.g()) * var4 * this.a);
                  var1.b(var3);
               }
            }
         }
      }
   }
}
