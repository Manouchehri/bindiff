package y.a;

import y.a.e;
import y.a.h;

class i extends e {
   int[] a;
   int[] f;
   y.g.d g;
   y.c.h h;
   y.c.A i;
   boolean j;
   int k;

   i(y.c.h var1, y.c.A var2) {
      this.i = var2;
      this.h = var1;
      this.j = false;
   }

   public void a(y.c.i var1) {
      this.a = new int[var1.f()];
      this.f = new int[var1.f()];
      this.g = new y.g.d(var1.g());
      super.a(var1);
   }

   protected void a(y.c.q var1, int var2) {
      this.f[var1.d()] = this.a[var1.d()] = var2;
   }

   protected void a(y.c.d var1, y.c.q var2, boolean var3) {
      this.g.a(var1);
      if(!var3) {
         if(var1.e()) {
            this.h.a(var1, -1);
            this.g.b();
            if(!h.a) {
               return;
            }
         }

         y.c.q var4 = var1.a(var2);
         this.a[var4.d()] = Math.min(this.a[var4.d()], this.f[var2.d()]);
      }

   }

   protected void a(y.c.q var1) {
      this.j = false;
   }

   protected void a(y.c.d var1, y.c.q var2) {
      boolean var4 = h.a;
      y.c.q var3 = var1.a(var2);
      if(this.a[var2.d()] >= this.f[var3.d()]) {
         label36: {
            while(true) {
               if(this.g.a() != var1) {
                  this.h.a(this.g.b(), this.k);
                  if(var4) {
                     break;
                  }

                  if(!var4) {
                     continue;
                  }
               }

               this.h.a(this.g.b(), this.k);
               ++this.k;
               break;
            }

            if(this.g.c()) {
               if(this.j) {
                  this.i.a(var3, true);
                  if(!var4) {
                     break label36;
                  }
               }

               this.j = true;
               if(!var4) {
                  break label36;
               }
            }

            this.i.a(var3, true);
         }
      }

      this.a[var3.d()] = Math.min(this.a[var3.d()], this.a[var2.d()]);
   }
}
