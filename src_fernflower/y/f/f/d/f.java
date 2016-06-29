package y.f.f.d;

import y.f.X;
import y.f.f.d.e;
import y.f.f.d.o;

class f {
   private y.c.q a;
   private int[] b;
   private y.d.q c;
   private final e d;

   public f(e var1, y.c.q var2, double var3, double var5, double var7, double var9) {
      boolean var19 = o.p;
      super();
      this.d = var1;
      this.a = var2;
      this.b = new int[4];
      int var11 = Math.max(0, (int)Math.ceil(var3));
      int var12 = Math.max(0, (int)Math.ceil(var5));
      int var13 = Math.max(0, (int)Math.ceil(var7));
      int var14 = Math.max(0, (int)Math.ceil(var9));
      int var15 = var11 % e.a(var1) == 0?0:e.a(var1) - var11 % e.a(var1);
      int var16 = var12 % e.a(var1) == 0?0:e.a(var1) - var12 % e.a(var1);
      if((var11 + var15 + var12 + var16) / e.a(var1) % 2 == 1) {
         label41: {
            if(var15 > var16) {
               var16 += e.a(var1);
               if(!var19) {
                  break label41;
               }
            }

            var15 += e.a(var1);
         }
      }

      int var17 = var13 % e.a(var1) == 0?0:e.a(var1) - var13 % e.a(var1);
      int var18 = var14 % e.a(var1) == 0?0:e.a(var1) - var14 % e.a(var1);
      if((var13 + var17 + var14 + var18) / e.a(var1) % 2 == 1) {
         label34: {
            if(var17 > var18) {
               var18 += e.a(var1);
               if(!var19) {
                  break label34;
               }
            }

            var17 += e.a(var1);
         }
      }

      this.b[0] = var11 + var15;
      this.b[1] = var12 + var16;
      this.b[2] = var13 + var17;
      this.b[3] = var14 + var18;
      this.c = e.b(var1).r(var2);
   }

   public int a() {
      return this.b[0];
   }

   public int b() {
      return this.b[1];
   }

   public int c() {
      return this.b[2];
   }

   public int d() {
      return this.b[3];
   }

   public y.d.q e() {
      boolean var7 = o.p;
      X var1 = (X)this.a.e();
      double var2 = var1.p(this.a);
      double var4 = var1.q(this.a);
      int var6 = 0;

      while(var6 < this.b.length) {
         label29: {
            if(var6 == 0 || var6 == 1) {
               var4 += (double)this.b[var6];
               if(!var7) {
                  break label29;
               }
            }

            var2 += (double)this.b[var6];
         }

         ++var6;
         if(var7) {
            break;
         }
      }

      return new y.d.q(var2, var4);
   }

   public void f() {
      boolean var7 = o.p;
      if(this.g()) {
         y.d.t var1 = e.b(this.d).o(this.a);
         y.d.t var2 = new y.d.t(var1.a() + (double)this.c(), var1.b() + (double)this.a());
         e.b(this.d).a(this.a, this.c);
         e.b(this.d).b(this.a, var2);
         y.c.e var3 = this.a.l();

         y.c.d var4;
         y.d.t var5;
         y.f.f.b.o var6;
         while(true) {
            if(var3.f()) {
               var4 = var3.a();
               var5 = (y.d.t)e.c(this.d).b(var4);
               var6 = (y.f.f.b.o)e.d(this.d).b(var4);
               boolean var10000 = var6.a(y.f.f.b.o.a);
               if(var7) {
                  if(!var10000) {
                     return;
                  }
                  break;
               }

               label86: {
                  if(var10000) {
                     e.b(this.d).c(var4, new y.d.t(var5.a(), var5.b() + (double)this.a()));
                     if(!var7) {
                        break label86;
                     }
                  }

                  if(var6.a(y.f.f.b.o.c)) {
                     e.b(this.d).c(var4, new y.d.t(var5.a(), var5.b() - (double)this.b()));
                     if(!var7) {
                        break label86;
                     }
                  }

                  if(var6.a(y.f.f.b.o.d)) {
                     e.b(this.d).c(var4, new y.d.t(var5.a() + (double)this.c(), var5.b()));
                     if(!var7) {
                        break label86;
                     }
                  }

                  if(var6.a(y.f.f.b.o.b)) {
                     e.b(this.d).c(var4, new y.d.t(var5.a() - (double)this.d(), var5.b()));
                  }
               }

               var3.g();
               if(!var7) {
                  continue;
               }
            }

            var3 = this.a.k();
            if(!var3.f()) {
               return;
            }
            break;
         }

         do {
            label88: {
               var4 = var3.a();
               var5 = (y.d.t)e.e(this.d).b(var4);
               var6 = (y.f.f.b.o)e.f(this.d).b(var4);
               if(var6.a(y.f.f.b.o.a)) {
                  e.b(this.d).d(var4, new y.d.t(var5.a(), var5.b() + (double)this.a()));
                  if(!var7) {
                     break label88;
                  }
               }

               if(var6.a(y.f.f.b.o.c)) {
                  e.b(this.d).d(var4, new y.d.t(var5.a(), var5.b() - (double)this.b()));
                  if(!var7) {
                     break label88;
                  }
               }

               if(var6.a(y.f.f.b.o.d)) {
                  e.b(this.d).d(var4, new y.d.t(var5.a() + (double)this.c(), var5.b()));
                  if(!var7) {
                     break label88;
                  }
               }

               if(var6.a(y.f.f.b.o.b)) {
                  e.b(this.d).d(var4, new y.d.t(var5.a() - (double)this.d(), var5.b()));
               }
            }

            var3.g();
         } while(!var7 && var3.f());

      }
   }

   public boolean g() {
      boolean var2 = o.p;
      int var1 = 0;

      int var10000;
      while(true) {
         if(var1 < this.b.length) {
            var10000 = this.b[var1];
            if(var2) {
               break;
            }

            if(var10000 > 0) {
               return true;
            }

            ++var1;
            if(!var2) {
               continue;
            }
         }

         var10000 = 0;
         break;
      }

      return (boolean)var10000;
   }
}
