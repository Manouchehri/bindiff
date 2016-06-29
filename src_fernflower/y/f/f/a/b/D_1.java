package y.f.f.a.b;

import java.util.HashMap;
import java.util.Map;
import y.f.f.a.b.a;
import y.g.M;

public class D {
   protected a a;
   protected y.c.i b;
   protected y.c.i c;
   protected y.f.f.a.a.p d;
   private y.c.h e;
   private y.c.h f;
   private Map g;
   private y.c.A h;

   public D(a var1) {
      this.a = var1;
      this.b = this.a.d();
      this.d = this.a.b();
      this.c = new y.c.i();
      this.e = this.c.u();
      this.f = M.b();
      this.g = new HashMap();
      this.h = this.c.t();
   }

   public void a() {
      this.c.a(this.e);
      this.b.a(this.f);
      this.g.clear();
      this.c.a(this.h);
      this.c.j();
   }

   public y.c.d d(y.c.d var1) {
      return (y.c.d)this.e.b(var1);
   }

   public y.c.d e(y.c.d var1) {
      return (y.c.d)this.f.b(var1);
   }

   public y.c.q a(y.f.h.p var1) {
      return (y.c.q)this.g.get(var1);
   }

   public y.f.h.p a(y.c.q var1) {
      return (y.f.h.p)this.h.b(var1);
   }

   protected void a(y.c.d var1, y.c.d var2) {
      this.e.a(var2, var1);
      this.f.a(var1, var2);
   }

   protected void a(y.f.h.p var1, y.c.q var2) {
      this.g.put(var1, var2);
      this.h.a(var2, var1);
   }

   public void b() {
      boolean var9 = a.c;
      this.c.j();
      this.g.clear();
      this.a.f();
      y.f.h.q var1 = this.a.e();

      y.f.h.p var2;
      y.c.q var3;
      while(true) {
         if(var1.f()) {
            var2 = var1.a();
            var3 = this.c.d();
            this.a(var2, var3);
            var1.g();
            if(var9) {
               break;
            }

            if(!var9) {
               continue;
            }
         }

         var1 = this.a.e();
         break;
      }

      while(var1.f()) {
         var2 = var1.a();
         var3 = this.a(var2);
         y.c.e var4 = var2.a();

         while(true) {
            if(var4.f()) {
               y.c.d var5 = var4.a();
               y.c.d var6 = this.a.c(var5);
               y.c.q var7 = this.a(this.a.b(var6));
               y.c.d var8 = this.c.a(var3, var7);
               this.a(var5, var8);
               var4.g();
               if(var9) {
                  break;
               }

               if(!var9) {
                  continue;
               }
            }

            var1.g();
            break;
         }

         if(var9) {
            break;
         }
      }

   }
}
