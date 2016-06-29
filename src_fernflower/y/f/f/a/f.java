package y.f.f.a;

import y.c.q;
import y.c.x;
import y.f.f.a.g;
import y.f.f.a.h;
import y.f.f.a.i;
import y.f.f.a.j;
import y.f.f.a.k;
import y.f.f.a.a.p;
import y.f.f.a.b.z;
import y.f.h.D;
import y.f.h.Q;

public class f implements y.f.f.b.d {
   private y.f.f.a.b.a b;
   private y.c.i c;
   private p d;
   private y.c.f e;
   private D f;
   private y.c.c g;
   private y.c.h h;
   private y.c.h i;
   private Q j;
   public static boolean a;

   public f(y.f.f.a.b.a var1, y.c.f var2) {
      this.b = var1;
      this.e = var2;
      this.c = var1.d();
      this.g = this.c.c(y.f.b.f.e);
      if(this.g != null) {
         this.h = this.c.u();
         this.c.a((Object)"y.layout.orthogonal.cluster.NodeSplitter.INSETS_KEY", (y.c.c)this.h);
      }

      this.i = this.c.u();
      this.c.a((Object)"y.layout.orthogonal.cluster.NodeSplitter.BORDER_INFO_KEY", (y.c.c)this.i);
      this.d = var1.b();
   }

   public void a(D var1) {
   }

   public void a(int var1) {
   }

   public void a() {
      boolean var4 = a;
      z.a(this.b, this.e);
      this.b.g();
      y.f.f.a.a.m.a(new j(this, (g)null), (y.f.f.a.a.g)this.d);
      this.b.h();
      this.f = new D(this.b.d());
      y.c.e var1 = this.b.d().p();

      f var10000;
      y.c.d var2;
      while(true) {
         if(var1.f()) {
            var2 = var1.a();
            y.c.d var3 = this.b.c(var2);
            this.f.b(var2, var3);
            var10000 = this;
            if(var4) {
               break;
            }

            if(this.b.a(var2)) {
               this.f.m(var2);
            }

            var1.g();
            if(!var4) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      x var5 = var10000.c.o();

      Object var8;
      while(true) {
         if(var5.f()) {
            q var7 = var5.e();
            var8 = this.b;
            if(var4) {
               break;
            }

            if(((y.f.f.a.b.a)var8).f(var7) || this.b.d(var7)) {
               this.f.c(var7);
            }

            var5.g();
            if(!var4) {
               continue;
            }
         }

         this.f.l();
         if(this.h != null) {
            this.j = new i(this.h);
            this.f.a(this.j);
         }

         this.f.a((Q)(new h(this.i)));
         var8 = this.d.a().a().d();
         break;
      }

      y.f.f.a.a.b var6 = (y.f.f.a.a.b)var8;
      var2 = this.b.a(var6.b_()).a().a();
      this.f.b((y.f.h.p)this.f.i(var2));
      if(y.c.i.g) {
         a = !var4;
      }

   }

   public D b() {
      return this.f;
   }

   public void c() {
      if(this.h != null) {
         this.c.a(this.h);
      }

      if(this.j != null) {
         this.f.b(this.j);
      }

      this.c.a(this.i);
      this.f.b();
      k.a(this.b, this.e);
   }

   static y.f.f.a.b.a a(f var0) {
      return var0.b;
   }

   static y.c.i b(f var0) {
      return var0.c;
   }

   static y.c.c c(f var0) {
      return var0.g;
   }

   static y.c.h d(f var0) {
      return var0.h;
   }

   static y.c.h e(f var0) {
      return var0.i;
   }
}
