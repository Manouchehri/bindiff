package y.f.f.a.b;

import y.f.f.a.b.a;
import y.f.f.a.b.s;
import y.f.f.a.b.t;

public class r {
   private a a;
   private y.c.i b;
   private y.f.f.a.a.p c;

   public r(a var1) {
      this.a = var1;
      this.b = this.a.d();
      this.c = this.a.b();
   }

   public static void a(a var0) {
      r var1 = new r(var0);
      var1.a();
   }

   public void a() {
      this.a.g();
      y.f.f.a.a.m.b(new t(this, (s)null), (y.f.f.a.a.g)this.c);
   }

   public void a(y.c.q var1) {
      boolean var6 = a.c;
      y.c.f var2 = this.a.b(var1);
      y.c.f var3 = new y.c.f();
      y.c.d var4 = (y.c.d)var2.f();
      y.c.d var5 = this.a.l(var4);
      var3.a(var4);

      while(var4 != var5) {
         if(var5.d() == var1) {
            var5 = this.a.c(var5);
            if(!var6) {
               continue;
            }
         }

         if(var5.c() == var1) {
            var3.a(var5);
         }

         var5 = this.a.l(var5);
         if(var6) {
            break;
         }
      }

      this.a.b(var1, var3);
   }

   public void b(y.c.q var1) {
      boolean var8 = a.c;
      y.c.f var2 = this.a.b(var1);
      y.c.f var3 = this.a.a(var1);
      y.c.f var4 = new y.c.f();
      y.c.e var5 = var2.a();

      while(true) {
         if(var5.f()) {
            y.c.d var6 = var5.a();
            y.c.d var7 = this.a.i(var6);
            if(var8) {
               break;
            }

            if(var1 == var7.d()) {
               var7 = this.a.c(var7);
            }

            var4.a(var7);
            var3.remove(var7);
            var5.g();
            if(!var8) {
               continue;
            }
         }

         var4.addAll(var3);
         this.a.a(var1, var4);
         break;
      }

   }

   static a a(r var0) {
      return var0.a;
   }
}
