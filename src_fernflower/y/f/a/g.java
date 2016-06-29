package y.f.a;

import y.f.X;
import y.f.a.a;
import y.f.a.f;

class g implements y.a.p {
   private y.d.t a;
   private final f b;

   g(f var1) {
      this.b = var1;
      this.a = new y.d.t();
   }

   public y.d.t a() {
      return this.a;
   }

   public void a(y.d.t var1) {
      this.a = var1;
   }

   public y.c.x a(y.c.i var1) {
      int var13 = f.u;
      if(!(var1 instanceof X)) {
         throw new IllegalArgumentException("This sequencer only works for LayoutGraphs");
      } else {
         X var2 = (X)var1;
         y.c.y var3 = new y.c.y(var2.o());
         y.c.A var4 = var2.t();
         double var5 = this.a.a();
         double var7 = this.a.b();
         y.c.x var9 = var2.o();

         while(true) {
            if(var9.f()) {
               y.c.q var10 = var9.e();
               double var11 = Math.atan2(var2.k(var10) - var7, var2.j(var10) - var5) - f.a(this.b);
               var11 = a.a(var11);
               var4.a(var10, var11);
               var9.g();
               if(var13 != 0) {
                  break;
               }

               if(var13 == 0) {
                  continue;
               }
            }

            var3.sort(y.g.e.c(var4));
            var2.a((y.c.A)var4);
            break;
         }

         return var3.a();
      }
   }
}
