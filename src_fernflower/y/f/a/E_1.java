package y.f.a;

import y.f.a.B;
import y.f.a.D;
import y.f.a.f;
import y.f.a.z;

class E implements y.d.g {
   private boolean a;
   private boolean b;
   private final z c;

   public E(z var1, boolean var2) {
      this.c = var1;
      this.b = var2;
      this.a = false;
      if(var2) {
         z.b(var1).clear();
      }

   }

   public boolean a() {
      return this.a;
   }

   private boolean a(D var1) {
      return !z.b(this.c).containsKey(var1);
   }

   public void a(Object var1, Object var2) {
      int var10 = f.u;
      B var3 = (B)var1;
      B var4 = (B)var2;
      if(y.d.y.a(var3.h(), var4.h())) {
         D var5 = new D(this.c, var3, var4);
         y.d.m var8;
         if(var3.g() || var4.g()) {
            if(var3.g() && var4.g()) {
               if(this.b) {
                  z.b(this.c).put(var5, var5);
                  if(var10 == 0) {
                     return;
                  }
               }

               if(!this.a(var5)) {
                  return;
               }

               this.a = true;
               if(var10 == 0) {
                  return;
               }
            }

            B var6;
            B var7;
            if(var3.e() || var4.e()) {
               var6 = var3.e()?var3:var4;
               var7 = var3.g()?var3:var4;
               if(!z.a(this.c, var6, var7)) {
                  return;
               }

               if(this.b) {
                  z.b(this.c).put(var5, var5);
                  if(var10 == 0) {
                     return;
                  }
               }

               if(!this.a(var5)) {
                  return;
               }

               this.a = true;
               if(var10 == 0) {
                  return;
               }
            }

            var6 = var3.g()?var3:var4;
            var7 = var3.g()?var4:var3;
            if(!z.b(this.c, var3, var4) && !this.b) {
               return;
            }

            var8 = (y.d.m)var7.j();
            if(!var8.a(var6.j().h())) {
               return;
            }

            if(this.b) {
               z.b(this.c).put(var5, var5);
               if(var10 == 0) {
                  return;
               }
            }

            if(!this.a(var5)) {
               return;
            }

            this.a = true;
            if(var10 == 0) {
               return;
            }
         }

         if(var3.e() && var4.e()) {
            if(!z.b(this.c, var3, var4) && !this.b || !z.c(this.c, var3, var4)) {
               return;
            }

            if(this.b) {
               z.b(this.c).put(var5, var5);
               if(var10 == 0) {
                  return;
               }
            }

            if(!this.a(var5)) {
               return;
            }

            this.a = true;
            if(var10 == 0) {
               return;
            }
         }

         y.c.d var13;
         if(var3.f() && var4.f()) {
            y.c.d var11 = (y.c.d)var3.i();
            var13 = (y.c.d)var4.i();
            if(var11 == var13 || !z.b(this.c, var3, var4) && !this.b) {
               return;
            }

            var8 = (y.d.m)var3.j();
            y.d.m var9 = (y.d.m)var4.j();
            if(y.d.m.a(var8, var9) == null) {
               return;
            }

            if(this.b) {
               z.b(this.c).put(var5, var5);
               if(var10 == 0) {
                  return;
               }
            }

            if(!this.a(var5)) {
               return;
            }

            this.a = true;
            if(var10 == 0) {
               return;
            }
         }

         if(var3.e() && var4.f() || var3.f() && var4.e()) {
            y.c.q var12 = (y.c.q)(var3.e()?var3.i():var4.i());
            var13 = (y.c.d)(var3.f()?var3.i():var4.i());
            if(var13.c() == var12 || var13.d() == var12 || !z.b(this.c, var3, var4) && !this.b) {
               return;
            }

            var8 = (y.d.m)(var3.f()?var3.j():var4.j());
            if(!z.a(this.c, var12, var8)) {
               return;
            }

            if(this.b) {
               z.b(this.c).put(var5, var5);
               if(var10 == 0) {
                  return;
               }
            }

            if(!this.a(var5)) {
               return;
            }

            this.a = true;
            if(var10 == 0) {
               return;
            }
         }

         System.out.println("unhandled case detected");
      }
   }
}
