package y.f.i.a;

import y.f.i.a.aI;
import y.f.i.a.aJ;
import y.f.i.a.aK;
import y.f.i.a.aL;
import y.f.i.a.ab;
import y.f.i.a.x;

class aH extends y.f.a {
   public static final Object a = "y.layout.router.polyline.SelfCrossingRemovalStage.LAYOUT_DESCRIPTOR_DPKEY";
   private final boolean b;

   aH(boolean var1) {
      this.b = var1;
   }

   public void c(y.f.X var1) {
      int var4 = ab.a;
      if(this.a() != null) {
         this.a().c(var1);
      }

      y.c.e var2 = var1.p();

      while(var2.f()) {
         y.c.d var3 = var2.a();

         while(this.b(var3, var1)) {
            ;
         }

         if(this.b) {
            this.a(var3, var1);
         }

         var2.g();
         if(var4 != 0) {
            break;
         }
      }

   }

   private void a(y.c.d var1, y.f.X var2) {
      int var24 = ab.a;
      y.d.t[] var3 = var2.l(var1).f();
      int var4 = 0;

      while(true) {
         if(var4 <= var3.length - 4) {
            y.d.m var5 = new y.d.m(var3[var4], var3[var4 + 1]);
            y.d.m var6 = new y.d.m(var3[var4 + 2], var3[var4 + 3]);
            y.d.m var7 = var5.a()?var5:(var6.a()?var6:null);
            y.d.m var8 = var5.b()?var5:(var6.b()?var6:null);
            if(var7 != null && var8 != null) {
               double var9 = Math.min(var7.c().b, var7.d().b);
               double var11 = Math.max(var7.c().b, var7.d().b);
               double var13 = var7.c().a;
               double var15 = Math.min(var8.c().a, var8.d().a);
               double var17 = Math.max(var8.c().a, var8.d().a);
               double var19 = var8.c().b;
               if(var9 < var19 && var11 > var19 || var15 < var13 && var17 > var13) {
                  y.c.D var21 = new y.c.D();
                  int var22 = 0;

                  while(var22 <= var4) {
                     var21.add(var3[var22]);
                     ++var22;
                     if(var24 != 0) {
                        break;
                     }
                  }

                  y.d.t var25 = new y.d.t(var13, var19);
                  var21.add(var25);
                  int var23 = var4 + 3;

                  while(true) {
                     if(var23 < var3.length) {
                        var21.add(var3[var23]);
                        ++var23;
                        if(var24 != 0) {
                           break;
                        }

                        if(var24 == 0) {
                           continue;
                        }
                     }

                     var2.a(var1, var21);
                     break;
                  }

                  return;
               }
            }

            ++var4;
            if(var24 == 0) {
               continue;
            }
         }

         return;
      }
   }

   private boolean b(y.c.d var1, y.f.X var2) {
      int var14 = ab.a;
      y.d.v var3 = y.f.ae.c(var2, var1);
      int var4 = var3.h() - 1;
      if(var4 < 4) {
         return false;
      } else {
         y.c.c var5 = var2.c(a);
         x var6 = var5 == null?null:(x)var5.b(var1);
         y.c.D var7 = new y.c.D();
         int var8 = 1;
         y.d.s var9 = var3.j();

         while(var9.f()) {
            label88: {
               y.d.m var10 = var9.a();
               y.d.z var11;
               y.d.t var12;
               if(var8 == 1 && var6 != null && var6.a() > 0.0D) {
                  if(var6.a() >= var10.g()) {
                     break label88;
                  }

                  var11 = var10.i();
                  var11.c();
                  var11.b(var6.a());
                  var12 = y.d.z.a(var10.c(), var11);
                  var7.add(new aJ(var12, var10.d(), var8, (aI)null));
                  if(var14 == 0) {
                     break label88;
                  }
               }

               if(var8 == var4 && var6 != null && var6.b() > 0.0D) {
                  if(var6.b() >= var10.g()) {
                     break label88;
                  }

                  var11 = new y.d.z(var10.c(), var10.d());
                  var11.c();
                  var11.b(var6.b());
                  var12 = y.d.z.a(var10.d(), var11);
                  var7.add(new aJ(var10.c(), var12, var8, (aI)null));
                  if(var14 == 0) {
                     break label88;
                  }
               }

               var7.add(new aJ(var10, var8, (aI)null));
            }

            ++var8;
            var9.g();
            if(var14 != 0) {
               break;
            }
         }

         aL var15 = new aL((aI)null);
         y.d.f.a(var7, var15);
         aK var16 = aL.a(var15);
         if(var16 != null) {
            y.d.t[] var17 = var3.f();
            y.c.D var18 = new y.c.D();
            int var13 = 0;

            label57: {
               while(var13 < var16.a()) {
                  var18.add(var17[var13]);
                  ++var13;
                  if(var14 != 0) {
                     break label57;
                  }

                  if(var14 != 0) {
                     break;
                  }
               }

               var18.add(var16.c);
            }

            var13 = var16.b();

            while(var13 < var17.length) {
               var18.add(var17[var13]);
               ++var13;
               if(var14 != 0) {
                  return aL.b(var15);
               }

               if(var14 != 0) {
                  break;
               }
            }

            var2.a(var1, var18);
         }

         return aL.b(var15);
      }
   }
}
