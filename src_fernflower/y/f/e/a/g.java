package y.f.e.a;

import y.f.e.a.Z;
import y.f.e.a.a;
import y.f.e.a.af;
import y.f.e.a.ag;
import y.f.e.a.ax;
import y.f.e.a.l;
import y.f.e.a.m;
import y.f.e.a.q;

class g extends q {
   private y.c.q[] d;
   private int e;
   private boolean f;
   private int g;
   private double h;
   private a i;
   private a j;

   g() {
      this(false);
   }

   g(boolean var1) {
      this.h = 0.25D;
      this.i = new Z();
      this.j = new Z();
      this.f = var1;
   }

   public void a() {
      this.d = null;
      this.e = -1;
   }

   public void a(l var1) {
      boolean var5 = af.b;
      af var2 = var1.f();
      if(this.d == null || this.e != var2.g()) {
         this.d = this.a(var2);
      }

      int var3 = 0;

      while(var3 < this.d.length) {
         label20: {
            ag var4 = var2.c(this.d[var3]);
            if(var4.g() == 1.0D) {
               var4.p();
               var4.c(this.c.a(var4, var1));
               if(!var5) {
                  break label20;
               }
            }

            this.a(var4, var1);
            this.a(var3, var4, var1);
         }

         ++var3;
         if(var5) {
            break;
         }
      }

   }

   private void a(int var1, m var2, l var3) {
      double var4 = var3.b().c();
      double var6 = var2.e();
      if(this.f) {
         if(var6 > var4 * (2.0D - this.h)) {
            this.a(var1, (var1 + this.g + 1) % this.d.length);
         }

         if(this.d.length <= 2 || var3.d().a(0, 2) != 1) {
            return;
         }

         this.a(var3.d().a(var1 + 1, var1 + this.g) % this.d.length, var3.d().a(var1 + 1, var1 + this.g) % this.d.length);
         if(!af.b) {
            return;
         }
      }

      this.a(var1, var3.d().nextInt(var1 + 1));
   }

   protected void a(ag var1, l var2) {
      boolean var5 = af.b;
      var1.p();
      int var3 = 0;

      while(true) {
         if(var3 < this.a.size()) {
            ax var4 = (ax)this.a.get(var3);
            this.j.a();
            this.a(var1);
            var1.a(var4.a(var1, var2, this.j));
            this.a(var4);
            ++var3;
            if(var5) {
               break;
            }

            if(!var5) {
               continue;
            }
         }

         var1.c(this.c.a(var1, var2));
         this.i.a();
         this.b.a(var1, var2, this.i);
         break;
      }

   }

   private y.c.q[] a(af var1) {
      this.e = var1.g();
      this.g = var1.f().e() / 3 + 1;
      return var1.f().m();
   }

   protected void a(ag var1) {
   }

   protected void a(ax var1) {
   }

   private void a(int var1, int var2) {
      if(var1 != var2) {
         y.c.q var3 = this.d[var2];
         this.d[var2] = this.d[var1];
         this.d[var1] = var3;
      }

   }
}
