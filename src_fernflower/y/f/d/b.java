package y.f.d;

import y.f.Q;
import y.f.X;
import y.f.aF;
import y.f.d.a;
import y.f.d.e;

class b implements y.d.g {
   X a;
   boolean b;

   b(X var1, boolean var2) {
      this.b = var2;
      this.a = var1;
   }

   public void a(Object var1, Object var2) {
      Q var3 = null;
      e var4 = null;
      if(var1 instanceof Q) {
         var3 = (Q)var1;
      } else if(var1 instanceof e) {
         var4 = (e)var1;
      }

      label53: {
         if(var2 instanceof Q) {
            var3 = (Q)var2;
            if(a.f == 0) {
               break label53;
            }
         }

         if(var2 instanceof e) {
            var4 = (e)var2;
         }
      }

      if(var3 != null && var4 != null) {
         if(this.b && var4.l() instanceof y.c.d) {
            y.c.d var5 = var4.l();
            y.c.c var6 = this.a.c(aF.c);
            Object var7 = var6.b(var5);
            if(var7 != null && var7.equals(var6.b(this.a.a((y.f.C)var3.e())))) {
               return;
            }

            var6 = this.a.c(aF.d);
            var7 = var6.b(var5);
            if(var7 != null && var7.equals(var6.b(this.a.a((y.f.C)var3.e())))) {
               return;
            }
         }

         if(!var3.f() || !(var3.e() instanceof y.f.C) || this.a.a((y.f.C)var3.e()) != var4.l()) {
            if(y.d.n.a(var3.d(), (y.d.m)var4, 0.001D)) {
               var3.c(1.0D);
            }

         }
      }
   }
}
