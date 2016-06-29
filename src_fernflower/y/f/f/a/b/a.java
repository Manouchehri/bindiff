package y.f.f.a.b;

import java.util.Comparator;
import y.f.X;
import y.f.f.a.b.b;
import y.f.f.a.b.c;
import y.f.f.a.b.d;
import y.f.f.a.b.e;

public class a {
   y.c.i a;
   y.f.h.D b;
   private y.f.f.a.a.p d;
   private y.c.A e;
   private y.c.h f;
   private final y.f.h.l g = new b(this);
   public static boolean c;

   public a(X var1, y.f.f.a.a.p var2) {
      this.a = var1;
      this.d = var2;
      this.e = var1.t();
      this.f = var1.u();
   }

   public void a(y.f.h.D var1) {
      this.b = var1;
   }

   public void a() {
      this.a.a(this.e);
      this.a.a(this.f);
   }

   public y.f.f.a.a.p b() {
      return this.d;
   }

   public y.f.h.D c() {
      return this.b;
   }

   public y.c.i d() {
      return this.a;
   }

   public boolean a(y.c.d var1) {
      return this.b.n(var1);
   }

   public void a(y.c.d var1, boolean var2) {
      this.b.a(var1, var2);
   }

   public y.f.h.p b(y.c.d var1) {
      return this.b.i(var1);
   }

   public y.c.d c(y.c.d var1) {
      return this.b.h(var1);
   }

   public void a(y.c.d var1, y.c.d var2) {
      this.b.b(var1, var2);
   }

   public y.f.h.q e() {
      return this.b.h();
   }

   public void f() {
      this.b.a((y.f.h.l)this.g);
   }

   public void a(y.c.d var1, y.c.f var2) {
      label11: {
         if(var2 == null) {
            this.b(var1, false);
            if(!c) {
               break label11;
            }
         }

         this.b(var1, true);
      }

      this.B(var1).a = var2;
   }

   public y.c.f d(y.c.d var1) {
      if(this.b.n(var1)) {
         var1 = this.b.h(var1);
      }

      return !this.v(var1)?null:(y.c.f)this.B(var1).a;
   }

   public void b(y.c.d var1, y.c.d var2) {
      this.B(var1).b = var2;
   }

   public y.c.d e(y.c.d var1) {
      if(this.b.n(var1)) {
         var1 = this.b.h(var1);
      }

      return this.B(var1).b;
   }

   public y.c.f f(y.c.d var1) {
      if(this.b.n(var1)) {
         var1 = this.b.h(var1);
      }

      y.c.d var2 = this.e(var1);
      return var2 != null?this.d(var2):null;
   }

   public y.c.d g(y.c.d var1) {
      if(this.b.n(var1)) {
         var1 = this.b.h(var1);
      }

      y.c.p var2 = this.B(var1).d;
      if(var2 == null) {
         return null;
      } else {
         var2 = var2.b();
         return var2 == null?null:(y.c.d)var2.c();
      }
   }

   public y.c.d h(y.c.d var1) {
      if(this.b.n(var1)) {
         var1 = this.b.h(var1);
      }

      y.c.p var2 = this.B(var1).d;
      if(var2 == null) {
         return null;
      } else {
         var2 = var2.a();
         return var2 == null?null:(y.c.d)var2.c();
      }
   }

   public void c(y.c.d var1, y.c.d var2) {
      this.B(var1).c = var2;
   }

   public y.c.d i(y.c.d var1) {
      if(this.b.n(var1)) {
         var1 = this.b.h(var1);
      }

      return this.B(var1).c;
   }

   public void a(y.c.d var1, y.c.p var2) {
      this.B(var1).d = var2;
   }

   public y.c.p j(y.c.d var1) {
      return this.B(var1).d;
   }

   public y.c.d k(y.c.d var1) {
      this.b.h(var1);
      y.c.d var2 = this.a.a(var1.d(), var1.c());
      this.b.b(var1, var2);
      this.b.m(var2);
      return var2;
   }

   public y.c.d l(y.c.d var1) {
      y.c.d var4;
      y.c.f var5;
      label11: {
         y.f.f.a.a.b var2 = this.d.a(var1.d());
         y.f.f.a.a.b var3 = this.d.a(var1.c());
         var4 = this.b.h(var1);
         if(var2 == var3.c()) {
            var5 = this.b(var1.d());
            if(!c) {
               break label11;
            }
         }

         var5 = this.a(var1.d());
      }

      y.c.d var6 = (y.c.d)var5.e(var5.d(var4)).c();
      return var6;
   }

   public void m(y.c.d var1) {
      this.B(var1).e = true;
   }

   public boolean n(y.c.d var1) {
      return this.B(var1).e;
   }

   public void o(y.c.d var1) {
      this.B(var1).f = true;
   }

   public boolean p(y.c.d var1) {
      return this.B(var1).f;
   }

   public void q(y.c.d var1) {
      this.B(var1).g = true;
   }

   public boolean r(y.c.d var1) {
      return this.B(var1).g;
   }

   public void s(y.c.d var1) {
      this.B(var1).h = true;
   }

   public boolean t(y.c.d var1) {
      return this.B(var1).h;
   }

   public void u(y.c.d var1) {
      this.B(var1).i = true;
   }

   public void b(y.c.d var1, boolean var2) {
      this.B(var1).j = var2;
   }

   public boolean v(y.c.d var1) {
      return this.B(var1).j;
   }

   public void d(y.c.d var1, y.c.d var2) {
      label11: {
         if(var2 == null) {
            this.B(var1).k = false;
            if(!c) {
               break label11;
            }
         }

         this.B(var1).k = true;
      }

      this.B(var1).a = var2;
   }

   public y.c.d w(y.c.d var1) {
      return !this.B(var1).k?null:(y.c.d)this.B(var1).a;
   }

   public void b(y.c.d var1, y.c.f var2) {
      label11: {
         if(var2 == null) {
            this.B(var1).l = false;
            if(!c) {
               break label11;
            }
         }

         this.B(var1).l = true;
      }

      this.B(var1).a = var2;
   }

   public y.c.f x(y.c.d var1) {
      return !this.B(var1).l?null:(y.c.f)this.B(var1).a;
   }

   public void y(y.c.d var1) {
      ++this.B(var1).m;
   }

   public void z(y.c.d var1) {
      --this.B(var1).m;
   }

   public int A(y.c.d var1) {
      return this.B(var1).m;
   }

   private d B(y.c.d var1) {
      d var2 = (d)this.f.b(var1);
      if(var2 == null) {
         var2 = this.i();
         this.f.a(var1, var2);
      }

      return var2;
   }

   private d i() {
      return new d((b)null);
   }

   public y.c.f a(y.c.q var1) {
      return this.j(var1).b;
   }

   public void a(y.c.q var1, y.c.f var2) {
      this.j(var1).b = var2;
   }

   public void a(y.c.q var1, y.c.d var2) {
      y.c.f var3 = this.a(var1);
      var3.remove(var2);
   }

   public void a(y.c.q var1, y.c.d var2, y.c.d var3) {
      y.c.f var4 = this.a(var1);
      var4.b(var3, var4.d(var2));
   }

   public void b(y.c.q var1, y.c.d var2, y.c.d var3) {
      y.c.f var4 = this.a(var1);
      var4.a(var3, var4.d(var2));
   }

   public void c(y.c.q var1, y.c.d var2, y.c.d var3) {
      y.c.f var4 = this.a(var1);
      var4.b(var3, var4.d(var2));
      var4.remove(var2);
   }

   public y.c.f b(y.c.q var1) {
      return this.j(var1).c;
   }

   public void b(y.c.q var1, y.c.f var2) {
      this.j(var1).c = var2;
   }

   public void b(y.c.q var1, y.c.d var2) {
      y.c.f var3 = this.b(var1);
      var3.remove(var2);
   }

   public void d(y.c.q var1, y.c.d var2, y.c.d var3) {
      y.c.f var4 = this.b(var1);
      var4.a(var3, var4.d(var2));
   }

   public void e(y.c.q var1, y.c.d var2, y.c.d var3) {
      y.c.f var4 = this.b(var1);
      var4.b(var3, var4.d(var2));
      var4.remove(var2);
   }

   public void c(y.c.q var1) {
      this.j(var1).a = 1;
   }

   public boolean d(y.c.q var1) {
      return this.j(var1).a == 1;
   }

   public void e(y.c.q var1) {
      this.j(var1).a = 2;
   }

   public boolean f(y.c.q var1) {
      return this.j(var1).a == 2;
   }

   public void c(y.c.q var1, y.c.f var2) {
      this.j(var1).d = var2;
   }

   public y.c.f g(y.c.q var1) {
      return this.j(var1).d;
   }

   private c j(y.c.q var1) {
      c var2 = (c)this.e.b(var1);
      if(var2 == null) {
         var2 = new c((b)null);
         var2.c = new y.c.f();
         var2.b = new y.c.f();
         var2.a = 0;
         var2.d = null;
         this.e.a(var1, var2);
      }

      return var2;
   }

   public void g() {
      boolean var2 = c;
      y.c.x var1 = this.a.o();

      while(var1.f()) {
         this.h(var1.e());
         var1.g();
         if(var2) {
            break;
         }
      }

   }

   public void h(y.c.q var1) {
      boolean var8 = c;
      y.c.f var2 = this.a(var1);
      var2.clear();
      y.c.f var3 = this.b(var1);
      var3.clear();
      y.c.e var4 = var1.l();

      while(var4.f()) {
         label17: {
            y.c.q var5 = var4.a().d();
            y.f.f.a.a.b var6 = this.d.a(var5);
            y.f.f.a.a.b var7 = this.d.a(var1);
            if(var7 != var6.c()) {
               var2.b(var4.a());
               if(!var8) {
                  break label17;
               }
            }

            var3.b(var4.a());
         }

         var4.g();
         if(var8) {
            break;
         }
      }

   }

   public void h() {
      boolean var2 = c;
      y.c.x var1 = this.a.o();

      while(var1.f()) {
         this.i(var1.e());
         var1.g();
         if(var2) {
            break;
         }
      }

   }

   public void i(y.c.q var1) {
      y.c.f var2 = new y.c.f();
      var2.a(this.b(var1).a());
      var2.a(this.a(var1).a());
      var1.b((Comparator)(new e(var2)));
   }

   public y.f.h.p[] a(y.f.h.p var1, y.c.d var2) {
      this.b.b.remove(var1);
      y.f.h.p[] var3 = new y.f.h.p[2];
      boolean[] var4 = new boolean[this.a.g()];
      var3[0] = this.b.a(var2, (y.f.h.l)this.g, (boolean[])var4);
      var3[1] = this.b.a(this.c(var2), (y.f.h.l)this.g, (boolean[])var4);
      return var3;
   }

   public y.f.h.p[] a(y.f.h.p var1, y.c.d var2, y.c.q var3) {
      boolean var11 = c;
      y.c.d var4 = var2;
      if(var2.d() == var3) {
         var4 = this.c(var2);
      }

      y.c.f var5 = this.a(var3);
      y.c.p var6 = var5.d(var4);
      var6 = var5.e(var6);
      y.c.d var7 = this.c((y.c.d)var6.c());
      var6 = var5.e(var5.e(var6));
      y.c.d var8 = (y.c.d)var6.c();
      y.c.d var9 = null;
      y.c.e var10 = var1.a();

      y.c.d var10000;
      while(true) {
         if(var10.f()) {
            var9 = var10.a();
            var10000 = var9;
            if(var11) {
               break;
            }

            if(var9.c() != var8.d() || var9.d() != var7.c()) {
               var10.g();
               if(!var11) {
                  continue;
               }
            }
         }

         var10000 = var9;
         break;
      }

      if(var10000 == null) {
         System.out.println("Error in splitFace!");
      }

      var9 = this.c(var9);
      y.f.h.p var12 = this.b(var9);
      var12.a(var9, var7, var8);
      this.b.a((y.c.d)var7, (y.f.h.p)var12);
      this.b.a((y.c.d)var8, (y.f.h.p)var12);
      y.f.h.p[] var13 = this.a(var1, var2);
      if(y.c.i.g) {
         c = !var11;
      }

      return var13;
   }
}
