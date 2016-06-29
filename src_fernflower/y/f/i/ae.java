package y.f.i;

import java.util.Collection;
import y.f.i.v;

class ae {
   private boolean b;
   private boolean c;
   private Collection d;
   private Collection e;
   private boolean f;
   private boolean g;
   private y.c.D h;
   private y.c.D i;
   private y.c.q j;
   private y.c.D k;
   private boolean l;
   private y.c.d m;
   private boolean n = false;
   private boolean o = false;
   int a;

   public ae(y.c.d var1) {
      this.m = var1;
   }

   public y.c.d a() {
      return this.m;
   }

   public boolean a(boolean var1) {
      return var1?this.n:this.o;
   }

   public void a(boolean var1, boolean var2) {
      if(var2) {
         this.n = var1;
         if(v.f == 0) {
            return;
         }
      }

      this.o = var1;
   }

   public boolean b(boolean var1) {
      return var1?this.b:this.c;
   }

   public Collection c(boolean var1) {
      return var1?this.d:this.e;
   }

   public boolean d(boolean var1) {
      return var1?this.f:this.g;
   }

   public y.c.D e(boolean var1) {
      return var1?this.h:this.i;
   }

   public y.c.C b() {
      return this.k != null?this.k.m():null;
   }

   public boolean c() {
      return this.l;
   }

   public void a(boolean var1, Collection var2) {
      if(var1) {
         this.d = var2;
         if(v.f == 0) {
            return;
         }
      }

      this.e = var2;
   }

   public void b(boolean var1, boolean var2) {
      if(var1) {
         this.b = var2;
         if(v.f == 0) {
            return;
         }
      }

      this.c = var2;
   }

   public void c(boolean var1, boolean var2) {
      if(var1) {
         this.f = var2;
         if(v.f == 0) {
            return;
         }
      }

      this.g = var2;
   }

   public void a(boolean var1, y.c.D var2) {
      if(var1) {
         this.h = var2;
         if(v.f == 0) {
            return;
         }
      }

      this.i = var2;
   }

   public void a(y.c.q var1) {
      this.j = var1;
   }

   public void f(boolean var1) {
      this.l = var1;
   }

   public void a(y.d.m var1) {
      if(this.k == null) {
         this.k = new y.c.D();
      }

      this.k.add(var1);
   }

   public void a(boolean var1, y.d.m var2) {
      if(this.k != null) {
         y.c.p var3 = var1?this.k.k():this.k.l();
         var3.a(var2);
      }
   }

   public void a(y.c.D var1) {
      this.k = var1;
   }
}
