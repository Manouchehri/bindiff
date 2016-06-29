package y.f.i.a;

import y.f.i.a.P;
import y.f.i.a.S;
import y.f.i.a.aU;
import y.f.i.a.aZ;
import y.f.i.a.ab;

class ba {
   final P[] a;
   final y.f.y[] b;
   private final aZ c;

   ba(aZ var1, y.f.ax var2, aU var3) {
      this.c = var1;
      y.d.t var4 = var2.b()?var3.a(var2, false):null;
      if(var2.a() == 255) {
         this.a = new P[4];
         this.b = new y.f.y[4];
         this.a[0] = this.a(1, var2.b(), var4);
         this.b[0] = y.f.y.c;
         this.a[1] = this.a(2, var2.b(), var4);
         this.b[1] = y.f.y.a;
         this.a[2] = this.a(4, var2.b(), var4);
         this.b[2] = y.f.y.d;
         this.a[3] = this.a(8, var2.b(), var4);
         this.b[3] = y.f.y.b;
         if(ab.a == 0) {
            return;
         }
      }

      this.a = new P[]{this.a(var2.a(), var2.b(), var4)};
      this.b = new y.f.y[]{aZ.a(var2.e().b())};
   }

   private P a(int var1, boolean var2, y.d.t var3) {
      if(var2) {
         if(var1 == 1) {
            return new P(var3.a(), var3.a(), aZ.a(this.c).i(), false);
         }

         if(var1 == 2) {
            return new P(var3.a(), var3.a(), aZ.a(this.c).k(), false);
         }

         if(var1 == 4) {
            return new P(var3.b(), var3.b(), aZ.a(this.c).j(), true);
         }

         if(var1 == 8) {
            return new P(var3.b(), var3.b(), aZ.a(this.c).h(), true);
         }
      } else {
         if(var1 == 1) {
            return aZ.a(this.c).a(S.a);
         }

         if(var1 == 2) {
            return aZ.a(this.c).a(S.b);
         }

         if(var1 == 4) {
            return aZ.a(this.c).a(S.c);
         }

         if(var1 == 8) {
            return aZ.a(this.c).a(S.d);
         }
      }

      return null;
   }
}
