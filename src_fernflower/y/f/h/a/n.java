package y.f.h.a;

import java.util.Iterator;
import y.c.D;
import y.f.h.a.b;
import y.f.h.a.h;
import y.f.h.a.i;
import y.f.h.a.m;
import y.f.h.a.p;
import y.f.h.a.r;

class n extends r {
   private y.c.q b = null;
   private int c = -1;
   private int d = Integer.MAX_VALUE;
   private int e = Integer.MAX_VALUE;
   private p f = new p();
   private D g;
   private m h;
   private D i = new D();
   private D j = new D();
   private D k = null;

   n(y.c.q var1, int var2, m var3) {
      this.b = var1;
      this.c = var2;
      this.e = var2;
      this.d = var2;
      this.h = var3;
   }

   public String toString() {
      return this.a != null?Integer.toString(this.f()) + ": " + this.a.toString():Integer.toString(this.f());
   }

   String a() {
      return Integer.toString(this.f());
   }

   n b() {
      return this;
   }

   h a(i var1) {
      return this.f.a(var1);
   }

   p c() {
      return this.f;
   }

   D d() {
      return this.i;
   }

   m a(i var1, int var2, int var3) {
      boolean var12 = b.g;
      m var4 = var1.f(var2);
      if(var4 == null) {
         System.out.println("Error!");
      }

      r var5 = var4.a((r)var1);
      int var6 = var5.a(var4, var2 ^ 1);
      m var7 = this.f(var3);
      r var8 = var7.a((r)this);
      m var9 = var8.t();
      int var10 = var8.a(var7, var3 ^ 1);
      m var11 = b.b(var5, var8, var6, var10, var4.a() + var7.a());
      if(var9 != null) {
         label36: {
            if(var10 == 0) {
               var8.e(var9);
               if(!var12) {
                  break label36;
               }

               y.c.i.g = !y.c.i.g;
            }

            if(var10 == 1) {
               var8.d(var9);
            }
         }
      }

      var1.e();
      if(var2 == var3) {
         var1.d();
      }

      if(var3 == 0) {
         this.a.b(var1.r());
         if(!var12) {
            return var11;
         }
      }

      this.a.a(var1.r());
      return var11;
   }

   void b(i var1) {
      if(this.g == null) {
         this.g = new D();
      }

      this.g.add(var1);
   }

   void e() {
      boolean var3 = b.g;
      if(this.g != null) {
         Iterator var1 = this.g.iterator();

         while(var1.hasNext()) {
            i var2 = (i)var1.next();
            this.a.a(var2.r());
            var2.e();
            if(var3) {
               break;
            }
         }
      }

   }

   D h() {
      return this.g;
   }

   int f() {
      return this.c;
   }

   void a(int var1, m var2) {
      this.c = var1;
      this.d = var1;
      this.e = var1;
      this.h = var2;
   }

   y.c.q i() {
      return this.b;
   }

   m j() {
      return this.h;
   }

   int k() {
      return this.h == null?-1:this.h.a((r)this).f();
   }

   void a(int var1) {
      this.d = Math.min(this.d, var1);
      this.e = Math.min(this.d, this.e);
   }

   void b(int var1) {
      this.e = Math.min(this.e, var1);
   }

   int l() {
      return this.e;
   }

   void a(m var1) {
      this.i.b((Object)var1);
   }

   D m() {
      return this.j;
   }

   void b(m var1) {
      this.j.b((Object)var1);
   }

   int n() {
      return this.j.isEmpty()?-1:((m)this.j.i()).e().f();
   }

   m o() {
      if(this.j.isEmpty()) {
         return null;
      } else {
         m var1 = (m)this.j.j();
         return var1;
      }
   }

   m p() {
      return this.j.isEmpty()?null:(m)this.j.i();
   }

   boolean c(int var1) {
      return this.d < var1 || this.f.b() != null && this.f.b().a(var1);
   }

   boolean d(int var1) {
      return this.f.c() != null && this.f.c().b(var1);
   }

   boolean e(int var1) {
      return this.d(var1) || this.n() == var1;
   }

   void a(y.c.d var1) {
      if(this.k == null) {
         this.k = new D();
      }

      this.k.add(var1);
   }

   D q() {
      return this.k;
   }

   void a(D var1) {
      this.k = var1;
   }
}
