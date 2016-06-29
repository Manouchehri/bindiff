package y.f.i;

import y.f.i.v;

class aQ {
   y.c.d[] a;
   y.c.q[] b;
   int c;
   int d;
   private y.c.i e;

   public aQ(y.c.i var1) {
      this.e = var1;
      this.a = new y.c.d[200];
      this.c = 0;
      this.b = new y.c.q[200];
      this.d = 0;
   }

   public y.c.d a(y.c.q var1, y.c.q var2) {
      if(this.c == 0) {
         return this.e.a(var1, var2);
      } else {
         y.c.d var3 = this.a[--this.c];
         this.e.a(var3, var1, var2);
         this.e.b(var3);
         return var3;
      }
   }

   public void a(y.c.d var1) {
      this.e.a(var1);
      if(this.c >= this.a.length) {
         y.c.d[] var2 = new y.c.d[2 * this.c];
         System.arraycopy(this.a, 0, var2, 0, this.a.length);
         this.a = var2;
      }

      this.a[this.c++] = var1;
   }

   public y.c.q a() {
      if(this.d == 0) {
         return this.e.d();
      } else {
         y.c.q var1 = this.b[--this.d];
         this.e.b(var1);
         return var1;
      }
   }

   public void a(y.c.q var1) {
      int var3 = v.f;

      label31:
      while(true) {
         if(var1.b() > 0) {
            this.a(var1.g());
            if(var3 != 0) {
               break;
            }

            if(var3 == 0) {
               continue;
            }
         }

         while(var1.c() > 0) {
            this.a(var1.f());
            if(var3 != 0) {
               break label31;
            }

            if(var3 != 0) {
               break;
            }
         }

         this.e.a(var1);
         break;
      }

      if(this.d >= this.b.length) {
         y.c.q[] var2 = new y.c.q[2 * this.d];
         System.arraycopy(this.b, 0, var2, 0, this.b.length);
         this.b = var2;
      }

      this.b[this.d++] = var1;
   }
}
