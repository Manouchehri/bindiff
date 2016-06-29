package y.f.f.b;

import y.c.q;
import y.c.x;
import y.f.X;
import y.f.f.b.h;
import y.f.f.b.o;
import y.f.h.D;
import y.f.k.L;
import y.g.I;

public class k {
   private h a;
   private y.c.f b;
   private I c;
   private double d = -1.0D;

   public void a(double var1) {
      this.d = var1;
   }

   public void a(h var1) {
      this.a = var1;
   }

   public void a(y.c.i var1) {
      int var5 = h.a;
      y.c.c var2 = var1.c(L.a);
      this.b = new y.c.f();
      this.c = new I(var1);
      x var3 = var1.o();

      while(var3.f()) {
         q var4 = var3.e();
         if(var2 != null && var2.d(var4)) {
            label20: {
               if(var4.b() > 0) {
                  this.b.add(var4.g());
                  if(var5 == 0) {
                     break label20;
                  }
               }

               this.b.add(var4.f());
            }

            this.c.a(var4);
         }

         var3.g();
         if(var5 != 0) {
            break;
         }
      }

   }

   public void a() {
      int var15 = h.a;
      X var1 = (X)this.a.a();
      D var2 = (D)this.a.b();
      double var3 = 0.0D;
      y.c.e var5 = this.b.a();

      while(var5.f()) {
         y.c.d var6 = var5.a();
         q var7 = var6.d();
         q var8 = var6.c();
         var1.d(var7);
         y.c.e var9 = var8.l();

         int var10000;
         label60: {
            while(true) {
               if(var9.f()) {
                  label68: {
                     y.c.d var10 = var9.a();
                     o var11 = this.a.h(var10);
                     int var12 = this.a.d(var10);
                     var10000 = var12;
                     if(var15 != 0) {
                        break label60;
                     }

                     if(var12 > 0) {
                        label69: {
                           y.c.d var13 = var2.h(var2.k(var10));
                           var1.e(var6);
                           var2.a(var6, (y.c.d)var13, (y.c.d)null);
                           var1.a(var6, var10, (y.c.d)null, 1, 1);
                           y.c.d var14 = var2.h(var6);
                           var2.e(var6);
                           var2.m(var14);
                           if(var11.a(o.a)) {
                              this.a.a(var6, "<^");
                              this.a.a((y.c.d)var10, (int)1);
                              this.a.a(var6, var12 - 1);
                              this.a.a((y.c.d)var14, (int)4);
                              var3 = var1.p(var7) * 0.5D;
                              if(var15 == 0) {
                                 break label69;
                              }
                           }

                           if(var11.a(o.c)) {
                              this.a.a(var6, ">_");
                              this.a.a((y.c.d)var10, (int)1);
                              this.a.a(var6, var12 - 1);
                              this.a.a((y.c.d)var14, (int)4);
                              var3 = var1.p(var7) * 0.5D;
                              if(var15 == 0) {
                                 break label69;
                              }
                           }

                           if(var11.a(o.b)) {
                              this.a.a(var6, "^>");
                              this.a.a((y.c.d)var10, (int)1);
                              this.a.a(var6, var12 - 1);
                              this.a.a((y.c.d)var14, (int)4);
                              var3 = var1.q(var7) * 0.5D;
                              if(var15 == 0) {
                                 break label69;
                              }
                           }

                           if(!var11.a(o.d)) {
                              break;
                           }

                           this.a.a(var6, "_<");
                           this.a.a((y.c.d)var10, (int)1);
                           this.a.a(var6, var12 - 1);
                           this.a.a((y.c.d)var14, (int)4);
                           var3 = var1.q(var7) * 0.5D;
                           if(var15 != 0) {
                              break;
                           }
                        }

                        this.a.f(var6);
                        if(var15 == 0) {
                           break label68;
                        }
                     }

                     var9.g();
                     if(var15 == 0) {
                        continue;
                     }
                  }
               }

               double var18;
               var10000 = (var18 = this.d - 0.0D) == 0.0D?0:(var18 < 0.0D?-1:1);
               break label60;
            }

            throw new IllegalStateException("Unknown direction!");
         }

         if(var10000 > 0) {
            this.a.n(var6);
            y.c.d var16 = var7.f().d().b(var8);
            int var17 = (int)Math.ceil(var3 / this.d);
            this.a.b(var16, var17);
            this.a.b(var2.h(var16), var17);
         }

         var5.g();
         if(var15 != 0) {
            break;
         }
      }

   }
}
