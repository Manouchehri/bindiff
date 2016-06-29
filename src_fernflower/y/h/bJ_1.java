package y.h;

import y.h.bI;
import y.h.bN;
import y.h.bQ;
import y.h.bS;
import y.h.bu;
import y.h.ch;
import y.h.fj;

class bJ extends bS {
   private volatile y.b.e i;
   private volatile y.b.d j;
   private final bQ k;
   private final Runnable l;
   private final bI m;

   bJ(bI var1, ch var2, bu var3, y.f.ah var4, boolean var5, bQ var6, Runnable var7) {
      super(var1, var2, var3, var4, var5);
      this.m = var1;
      this.k = var6;
      this.l = var7;
   }

   protected void a(y.f.l var1) {
      y.h.b.v var2 = (y.h.b.v)this.h.get(bI.b == null?(bI.b = bI.a("y.h.b.v")):bI.b);
      if(var2 != null) {
         var2.f(this.e);
      }

      this.i = this.m.k();
      this.i.b(true);
      this.j = this.m.a(this.d, this.e, var1.C());
      if(this.j != null) {
         if(this.m.e().isEasedExecution()) {
            this.j = y.b.b.a(this.j);
         }

         this.i.a((y.b.c)this.d);
         this.i.a((y.b.c)(new bN(this)));
         if(!fj.z) {
            return;
         }
      }

      this.m.a(this.e, var1.C());
   }

   protected void b(y.f.l var1) {
      if(this.i != null && this.j != null) {
         this.i.a(this.j);
      }

   }

   protected void a() {
      super.a();
      if(this.b != null && this.k != null) {
         this.k.a(this.b);
      }

      if(this.l != null) {
         this.l.run();
      }

   }
}
