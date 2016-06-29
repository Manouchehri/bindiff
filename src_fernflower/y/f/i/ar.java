package y.f.i;

import y.f.i.as;
import y.f.i.at;
import y.f.i.v;

class ar {
   private y.f.X a;
   private v b;
   private byte c;
   private y.c.c d;
   private y.c.h e;

   public ar(y.f.X var1, v var2) {
      this.a = var1;
      this.b = var2;
   }

   y.c.h a() {
      return this.e;
   }

   public void b() {
      Object var1;
      y.c.c var2;
      if(this.b.p() == 2) {
         var1 = this.b.c();
         var2 = this.a.c(var1);
         if(var2 == null) {
            throw new IllegalStateException("No DataProvider " + var1 + " registered with graph!");
         }
      } else if(this.b.p() == 4) {
         var1 = this.b.b();
         var2 = this.a.c(var1);
         if(var2 == null) {
            throw new IllegalStateException("No DataProvider " + var1 + " registered with graph!");
         }
      }

   }

   public void c() {
      int var4 = v.f;
      this.d();
      Object var1 = this.b.c();
      y.c.c var2 = this.a.c(var1);
      if(var2 != null) {
         this.e = y.g.M.b();
         y.c.e var3 = this.a.p();

         while(var3.f()) {
            this.e.a(var3.a(), var2.d(var3.a()));
            var3.g();
            if(var4 != 0) {
               return;
            }

            if(var4 != 0) {
               break;
            }
         }

         this.a.a((Object)var1, (y.c.c)this.e);
      }

   }

   public void d() {
      this.c = this.b.p();
      this.b.b((byte)2);
      Object var1 = this.b.c();
      this.d = this.a.c(var1);
      y.c.c var2 = this.a.c(this.b.b());
      Object var3 = null;
      if(this.c == 0) {
         var3 = new as(this);
      } else if(this.c == 4) {
         var3 = new at(this, var2);
      }

      if(var3 != null) {
         this.b.b((byte)2);
         this.a.a((Object)var1, (y.c.c)var3);
      }

   }

   public void e() {
      if(this.c != 2) {
         label17: {
            Object var1 = this.b.c();
            if(this.d != null) {
               this.a.a((Object)var1, (y.c.c)this.d);
               if(v.f == 0) {
                  break label17;
               }
            }

            this.a.d_(var1);
         }

         this.b.b(this.c);
      }

      if(this.e != null) {
         this.e = null;
      }

   }
}
