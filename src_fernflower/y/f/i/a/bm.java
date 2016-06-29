package y.f.i.a;

import y.f.i.a.ab;
import y.f.i.a.bn;
import y.f.i.a.bo;
import y.f.i.a.y;

class bm {
   private y.f.X a;
   private y b;
   private byte c;
   private y.c.c d;
   private y.c.h e;

   public bm(y.f.X var1, y var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a() {
      Object var1;
      y.c.c var2;
      if(this.b.f() == 2) {
         var1 = this.b.h();
         var2 = this.a.c(var1);
         if(var2 == null) {
            throw new IllegalStateException("No DataProvider " + var1 + " registered with graph!");
         }
      } else if(this.b.f() == 4) {
         var1 = this.b.g();
         var2 = this.a.c(var1);
         if(var2 == null) {
            throw new IllegalStateException("No DataProvider " + var1 + " registered with graph!");
         }
      }

   }

   public void b() {
      this.c = this.b.f();
      this.b.a((byte)2);
      Object var1 = this.b.h();
      this.d = this.a.c(var1);
      y.c.c var2 = this.a.c(this.b.g());
      Object var3 = null;
      if(this.c == 0) {
         var3 = new bn(this);
      } else if(this.c == 4) {
         var3 = new bo(this, var2);
      }

      if(var3 != null) {
         this.b.a((byte)2);
         this.a.a((Object)var1, (y.c.c)var3);
      }

   }

   public void c() {
      if(this.c != 2) {
         label17: {
            Object var1 = this.b.h();
            if(this.d != null) {
               this.a.a((Object)var1, (y.c.c)this.d);
               if(ab.a == 0) {
                  break label17;
               }
            }

            this.a.d_(var1);
         }

         this.b.a(this.c);
      }

      if(this.e != null) {
         this.e = null;
      }

   }
}
