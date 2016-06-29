package y.f.h;

import y.f.h.D;
import y.f.h.N;
import y.f.h.p;

public class k {
   private D a;
   private y.c.i b;

   public k(D var1) {
      this.a = var1;
      this.b = var1.g();
   }

   public y.c.f a(y.c.f var1, y.c.d var2) {
      return this.a(var1, (y.c.d)null, (y.c.d)null, var2);
   }

   public y.c.f a(y.c.f var1, y.c.d var2, y.c.d var3, y.c.d var4) {
      boolean var21 = N.d;
      if(var4.c() == var4.d()) {
         this.b.e(var4);
         this.a.a((y.c.d)null, (y.c.d)var4);
         this.a.k();
         y.c.f var22 = new y.c.f();
         var22.add(var4);
         return var22;
      } else if(var1 == null) {
         return this.a(var2, var3, var4);
      } else if(var1.size() == 0) {
         return this.b(var2, var3, var4);
      } else {
         y.c.q var5 = var4.c();
         y.c.q var6 = var4.d();
         y.c.d var7 = var2;
         y.c.d var8 = var3;
         p var9 = null;
         y.c.d var10 = null;
         y.c.f var11 = new y.c.f();
         y.c.q var12 = var5;
         if(var2 != null) {
            var9 = this.a.i(var2);
         } else {
            y.c.d var13 = var1.b();
            if(this.a.i(var13).a(var5)) {
               var9 = this.a.i(var13);
            } else {
               var9 = this.a.i(this.a.h(var13));
            }
         }

         y.c.e var23 = var1.a();

         int var10000;
         while(true) {
            if(var23.f()) {
               y.c.d var14 = var23.a();
               var10000 = this.a.n(var14);
               if(var21) {
                  break;
               }

               if(var10000 != 0) {
                  var14 = this.a.h(var14);
               }

               y.c.q var15 = this.a.b(var14);
               y.c.f var16 = new y.c.f(var15.k());
               y.c.f var17 = new y.c.f(var15.l());
               y.c.d var25 = var14;
               y.c.d var10001 = var7;

               label93:
               while(true) {
                  label72: {
                     if(var25 == var10001) {
                        var7 = var17.b();
                        if(!var21) {
                           break label72;
                        }
                     }

                     if(this.a.h(var14) == var7) {
                        var7 = var17.c();
                     }
                  }

                  label76: {
                     if(var14 == var8) {
                        var8 = var17.b();
                        if(!var21) {
                           break label76;
                        }
                     }

                     if(this.a.h(var14) == var8) {
                        var8 = var17.c();
                     }
                  }

                  var10 = this.b.a(var12, var15);
                  var11.add(var10);
                  this.a.a(var9, var10, var7, (y.c.d)null);
                  var7 = null;
                  var9 = null;
                  y.c.e var18 = var16.a();

                  while(true) {
                     if(!var18.f() || var9 != null) {
                        break label93;
                     }

                     p var19 = this.a.i(var18.a());
                     y.c.e var20 = var19.a();

                     while(var20.f()) {
                        var25 = var20.a();
                        var10001 = var18.a();
                        if(var21) {
                           continue label93;
                        }

                        if(var25 == var10001) {
                           break;
                        }

                        var20.g();
                        if(var21) {
                           break;
                        }
                     }

                     var20.b();
                     if(var17.contains(var20.a())) {
                        var7 = var18.a();
                        var9 = var19;
                     }

                     var18.g();
                     if(var21) {
                        break label93;
                     }
                  }
               }

               var12 = var15;
               var23.g();
               if(!var21) {
                  continue;
               }
            }

            var10 = this.b.a(var12, var6);
            var11.add(var10);
            this.a.a(var9, var10, var7, var8);
            var10000 = var11.size();
            break;
         }

         y.c.d[] var24 = new y.c.d[var10000];
         this.a.a(var4, (y.c.d[])var11.toArray(var24));
         this.a.a(var4, var11, 0);
         return var11;
      }
   }

   protected y.c.f a(y.c.d var1, y.c.d var2, y.c.d var3) {
      y.c.f var4 = new y.c.f();
      this.b.e(var3);
      this.a.a(var3, var1, var2);
      var4.add(var3);
      return var4;
   }

   protected y.c.f b(y.c.d var1, y.c.d var2, y.c.d var3) {
      y.c.f var4;
      p var9;
      p var16;
      label86: {
         boolean var15 = N.d;
         var4 = new y.c.f();
         y.c.e var5 = null;
         y.c.q var6 = var3.c();
         y.c.q var7 = var3.d();
         this.b.e(var3);
         y.c.D var8 = new y.c.D();
         var9 = null;
         if(var1 == null && var2 == null) {
            y.c.q var10 = var7;
            y.c.q var11 = var6;
            if(var6.c() < var7.c()) {
               var10 = var6;
               var11 = var7;
            }

            y.c.e var12 = var10.l();

            Object var10000;
            label71: {
               while(var12.f()) {
                  var10000 = var12;
                  if(var15) {
                     break label71;
                  }

                  if(var12.a() != var3) {
                     var8.add(this.a.i(var12.a()));
                  }

                  var12.g();
                  if(var15) {
                     break;
                  }
               }

               var10000 = var8.m();
            }

            Object var13 = var10000;

            while(((y.c.C)var13).f()) {
               var10000 = ((y.c.C)var13).d();

               label57:
               while(true) {
                  p var14 = (p)var10000;
                  var16 = var14;
                  if(var15) {
                     break label86;
                  }

                  var5 = var14.a();

                  while(true) {
                     if(!var5.f()) {
                        break label57;
                     }

                     var10000 = var5.a().d();
                     if(var15) {
                        break;
                     }

                     if(var10000 == var11) {
                        var9 = this.a.i(var5.a());
                     }

                     var5.g();
                     if(var15) {
                        break label57;
                     }
                  }
               }

               ((y.c.C)var13).g();
               if(var15) {
                  break;
               }
            }
         } else if(var1 != null) {
            var9 = this.a.i(var1);
         } else {
            var9 = this.a.i(var2);
         }

         var16 = var9;
      }

      if(var16 == null) {
         this.b.d(var3);
         throw new RuntimeException("No common face found !");
      } else {
         this.a.a(var9, var3, var1, var2);
         var4.add(var3);
         return var4;
      }
   }
}
