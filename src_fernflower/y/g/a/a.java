package y.g.a;

import y.c.A;
import y.c.C;
import y.c.D;
import y.c.x;
import y.g.a.b;
import y.g.a.d;
import y.g.a.g;

public class a implements g {
   private A a = null;
   private boolean b = false;
   private D[] c = null;
   private D d = null;
   private b[] e = null;
   private y.c.q f = null;
   private int g = 0;
   private y.c.i h;

   public a(y.c.i var1, int var2) {
      A var3 = var1.t();
      this.a(var1, var3, var2);
      this.b = true;
   }

   private void a(y.c.i var1, A var2, int var3) {
      boolean var7 = d.a;
      this.h = var1;
      this.a = var2;
      this.c = new D[var3 + 1];
      this.f = null;
      this.d = new D();
      this.e = new b[this.h.f()];
      int var4 = 0;
      D var5 = new D();
      x var6 = this.h.o();

      while(var6.f()) {
         this.e[var4] = new b(var6.e(), var5);
         ++var4;
         var6.g();
         if(var7) {
            break;
         }
      }

   }

   public void d() {
      boolean var3 = d.a;
      C var1 = this.d.m();

      while(true) {
         if(var1.f()) {
            y.c.q var2 = (y.c.q)var1.d();
            this.c[this.a.a(var2)].clear();
            this.e[var2.d()].c = false;
            var1.g();
            if(var3) {
               break;
            }

            if(!var3) {
               continue;
            }
         }

         this.d.clear();
         this.f = null;
         break;
      }

   }

   public boolean a() {
      return this.d.size() == 0;
   }

   public boolean a(y.c.q var1) {
      return this.e[var1.d()].c;
   }

   public void a(y.c.q var1, int var2) {
      int var3 = var1.d();
      this.a.a(var1, var2);
      this.e[var3].c = true;
      D var4 = this.a(var2);
      var4.a(this.e[var3].a);
      this.d.a(this.e[var3].b);
      if(this.f == null || var2 < this.g) {
         this.f = var1;
         this.g = var2;
      }

   }

   public void c(y.c.q var1) {
      boolean var4 = d.a;
      int var2 = var1.d();
      this.e[var2].c = false;
      D var3 = this.c[this.a.a(var1)];
      var3.h(this.e[var2].a);
      this.d.h(this.e[var2].b);
      if(this.d.size() <= 0) {
         this.f = null;
      } else {
         a var10000;
         while(true) {
            if(this.g < this.c.length) {
               var10000 = this;
               if(var4) {
                  break;
               }

               if(this.c[this.g] == null || this.c[this.g].size() <= 0) {
                  ++this.g;
                  if(!var4) {
                     continue;
                  }
               }
            }

            this.f = (y.c.q)this.c[this.g].f();
            var10000 = this;
            break;
         }

         if(!var10000.e[this.f.d()].c) {
            throw new RuntimeException("Consistency check failed: Tried to make " + this.f + " with " + this.g + " to new minimal node which is not part of the actual list !");
         }
      }

   }

   public void b(y.c.q var1, int var2) {
      D var3 = this.c[this.a.a(var1)];
      y.c.p var4 = this.e[var1.d()].a;
      var3.h(var4);
      this.a(var2).a(var4);
      this.a.a(var1, var2);
      if(var2 < this.g) {
         this.f = var1;
         this.g = var2;
      }

   }

   public y.c.q c() {
      y.c.q var1 = this.f;
      this.c(var1);
      return var1;
   }

   public int b(y.c.q var1) {
      return this.a.a(var1);
   }

   public void b() {
      if(this.b) {
         this.h.a(this.a);
      }

   }

   protected D a(int var1) {
      if(this.c[var1] == null) {
         this.c[var1] = new D();
      }

      return this.c[var1];
   }
}
