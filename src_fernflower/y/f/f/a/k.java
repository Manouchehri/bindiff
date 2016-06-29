package y.f.f.a;

import y.c.D;
import y.d.t;
import y.f.X;
import y.f.f.a.f;
import y.f.f.a.l;
import y.f.f.a.m;
import y.f.f.a.a.p;

public class k {
   private y.f.f.a.b.a a;
   private X b;
   private p c;
   private y.c.f d;

   public k(y.f.f.a.b.a var1, y.c.f var2) {
      this.a = var1;
      this.b = (X)this.a.d();
      this.c = this.a.b();
      this.d = var2;
   }

   public static void a(y.f.f.a.b.a var0, y.c.f var1) {
      k var2 = new k(var0, var1);
      var2.a();
   }

   public void a() {
      this.c();
      this.b();
   }

   private void b() {
      boolean var6 = f.a;
      y.c.e var1 = this.d.a();

      while(var1.f()) {
         new y.c.f();
         D var4 = null;
         y.c.d var5 = var1.a();
         if(!this.b.f(var5)) {
            this.b.e(var5);
         }

         y.c.f var2 = this.a.x(var5);
         if(var2 != null) {
            var4 = this.a(var2.b());
            var4.addAll(this.a(var2.c()));
         } else {
            var4 = this.a(var5);
         }

         this.b.c(var5, (t)var4.f());
         this.b.d(var5, (t)var4.i());
         var4.h(var4.k());
         var4.h(var4.l());
         this.b.b(var5, var4);
         var1.g();
         if(var6) {
            break;
         }
      }

   }

   private D a(y.c.d var1) {
      D var2;
      y.c.e var5;
      y.c.d var6;
      boolean var7;
      label46: {
         var7 = f.a;
         var2 = new D();
         y.c.f var3 = null;
         y.c.d var4 = this.a.w(var1);
         if(var4 != null) {
            var3 = this.a.d(var4);

            for(var5 = var3.a(); var5.f(); var5.g()) {
               var6 = var5.a();
               boolean var10000 = this.a.p(var6);
               if(var7) {
                  break label46;
               }

               if(var10000) {
                  var3.remove(var6);
               }
            }
         } else {
            var3 = this.a.d(var1);
         }

         if(var3 == null) {
            var3 = new y.c.f(var1);
         }

         var5 = var3.a();
         var5.i();
         var2.add(this.b.p(var5.a()));
      }

      while(true) {
         if(var5.f()) {
            var6 = var5.a();
            var2.addAll(this.b.k(var6));
            var5.g();
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         var5.j();
         var2.b((Object)this.b.q(var5.a()));
         break;
      }

      return var2;
   }

   private void c() {
      y.f.f.a.a.m.a(new m(this, (l)null), (y.f.f.a.a.g)this.c);
   }

   static X a(k var0) {
      return var0.b;
   }

   static y.f.f.a.b.a b(k var0) {
      return var0.a;
   }
}
