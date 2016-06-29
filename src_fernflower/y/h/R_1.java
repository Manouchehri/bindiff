package y.h;

import java.util.Iterator;
import y.h.O;
import y.h.P;
import y.h.Q;
import y.h.U;
import y.h.bu;
import y.h.cg;
import y.h.fj;
import y.h.hP;

final class R implements cg {
   boolean a;
   boolean b;
   boolean c;
   boolean d;
   boolean e;
   private cg f;
   private final O g;

   R(O var1) {
      this.g = var1;
      this.c = true;
      U var2 = new U();
      var2.a(this.a);
      var2.b(this.c);
      var2.c(this.d);
      this.f = var2;
   }

   public Iterator a(bu var1, int var2) {
      Object var3 = this.e()?new hP(this.f, this.c()):this.f;
      return ((cg)var3).a(var1, var2);
   }

   public Iterator b(bu var1, int var2) {
      Object var3 = this.e()?new hP(this.f, this.c()):this.f;
      return ((cg)var3).b(var1, var2);
   }

   boolean a() {
      return this.b;
   }

   void a(boolean var1) {
      if(this.b != var1) {
         this.b = var1;
         if(this.b) {
            Q var2 = new Q(this.g, (P)null);
            var2.a = this.a;
            this.f = var2;
            if(!fj.z) {
               return;
            }
         }

         U var3 = new U();
         var3.a(this.a);
         var3.b(this.c);
         var3.c(this.d);
         this.f = var3;
      }

   }

   boolean b() {
      return this.c;
   }

   void b(boolean var1) {
      this.c = var1;
      if(!this.b) {
         ((U)this.f).b(var1);
      }

   }

   boolean c() {
      return this.d;
   }

   void c(boolean var1) {
      this.d = var1;
      if(!this.b) {
         ((U)this.f).c(var1);
      }

   }

   boolean d() {
      return this.a;
   }

   void d(boolean var1) {
      this.a = var1;
      if(!this.b) {
         ((U)this.f).a(var1);
         if(!fj.z) {
            return;
         }
      }

      ((Q)this.f).a = var1;
   }

   public boolean e() {
      return this.e;
   }

   public void e(boolean var1) {
      this.e = var1;
   }
}
