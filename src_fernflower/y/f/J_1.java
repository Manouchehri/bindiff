package y.f;

import y.f.X;
import y.f.ai;
import y.f.aj;
import y.f.al;
import y.f.am;

public class J implements al {
   private X a;
   private y.c.q b;
   private boolean c;

   public J(X var1, y.c.q var2) {
      this.a = var1;
      this.b = var2;
   }

   public Object c() {
      return null;
   }

   public y.d.n a(y.d.q var1, am var2, Object var3) {
      boolean var19 = X.j;
      double var4 = var2.getX() + (var2.getWidth() - var1.a()) / 2.0D;
      double var6 = var2.getY() + (var2.getHeight() - var1.b()) / 2.0D;
      y.c.q var8 = this.b;
      if(!this.c && var8 != null && var8.a() > 0) {
         this.c = true;

         y.d.n var17;
         try {
            double var9 = 0.0D;
            double var11 = 0.0D;
            y.c.e var13 = var8.j();

            label90: {
               while(var13.f()) {
                  y.c.d var14 = var13.a();
                  y.c.q var15 = var14.a(var8);
                  var9 += this.a.j(var8) - this.a.j(var15);
                  var11 += this.a.k(var8) - this.a.k(var15);
                  var13.g();
                  if(var19) {
                     break label90;
                  }

                  if(var19) {
                     break;
                  }
               }

               var9 /= (double)var8.a();
               var11 /= (double)var8.a();
            }

            if(var9 == 0.0D && var11 == 0.0D) {
               return new y.d.n(new y.d.t(var4, var6 + var1.b()), var1);
            }

            double var22 = Math.sqrt(var9 * var9 + var11 * var11);
            double var23 = Math.sqrt(this.a.q(var8) * this.a.q(var8) + this.a.p(var8) * this.a.p(var8));
            var9 = var9 * (var23 + 10.0D) / var22;
            var11 = var11 * (var23 + 10.0D) / var22;
            var17 = new y.d.n(new y.d.t(var4 + var9, var6 + var11 + var1.b()), var1);
         } finally {
            this.c = false;
         }

         return var17;
      } else {
         return new y.d.n(new y.d.t(var4, var6 + var1.b()), var1);
      }
   }

   public Object a(y.d.n var1, am var2) {
      return null;
   }

   public y.c.D a(aj var1, am var2) {
      y.c.D var3 = new y.c.D();
      y.d.n var4 = this.a(var1.getOrientedBox().d(), var2, (Object)null);
      var3.add(new ai(var4, (Object)null, var1, false));
      return var3;
   }
}
