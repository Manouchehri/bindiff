package y.f.i.a;

import y.f.i.a.M;
import y.f.i.a.ab;
import y.f.i.a.bD;
import y.f.i.a.bE;
import y.f.i.a.v;

class bC {
   private v c;
   private static final Object d = "LEFT_SIDE";
   private static final Object e = "RIGHT_SIDE";
   private static final Object f = "BOTH_SIDES";
   private boolean g;
   private Object[] h;
   private M[] i;
   boolean a;
   private M[] j;
   boolean b;

   public bC(v var1) {
      int var14 = ab.a;
      super();
      this.h = new Object[4];
      this.i = new M[4];
      this.j = new M[4];
      this.c = var1;
      y.f.y var2 = var1.k();
      y.f.y var3 = var1.l();
      if(var2 != null && var3 != null) {
         int var4 = var2.f();
         int var5 = var3.c().f();
         if(var4 == var5) {
            M var6 = this.c.i().e();
            M var7 = this.c.j().e();
            if(var6.a(var7, Math.min(1.0E-6D, Math.min(var6.d(), var7.d())))) {
               this.g = true;
               if(var14 == 0) {
                  return;
               }
            }

            boolean var8 = var2 == y.f.y.b || var2 == y.f.y.a;
            boolean var9 = var8 && var6.a() < var7.a() || !var8 && var6.b() > var7.b();
            Object var10 = var9?d:e;
            int var11 = 0;

            do {
               if(var11 >= 4) {
                  return;
               }

               label144: {
                  if(var4 != var11) {
                     this.h[var11] = var10;
                     if(var14 == 0) {
                        break label144;
                     }
                  }

                  M var12 = M.c(var6, var7);
                  M var13 = M.b(var6, var7);
                  if(var9) {
                     this.a = true;
                     this.i[var11] = var12;
                     this.j[var11] = var13;
                     if(var14 == 0) {
                        break label144;
                     }
                  }

                  this.b = true;
                  this.j[var11] = var12;
                  this.i[var11] = var13;
               }

               ++var11;
            } while(var14 == 0);
         }

         int var15 = var5 < var4?var5 + 4:var5;
         int var16 = var4 + 1;

         int var10000;
         label96: {
            while(true) {
               if(var16 < var15) {
                  this.h[var16 % 4] = d;
                  ++var16;
                  if(var14 != 0) {
                     break;
                  }

                  if(var14 == 0) {
                     continue;
                  }
               }

               if(var4 < var5) {
                  var10000 = var4 + 4;
                  break label96;
               }
               break;
            }

            var10000 = var4;
         }

         var16 = var10000;
         int var17 = var5 + 1;

         while(var17 < var16) {
            this.h[var17 % 4] = e;
            ++var17;
            if(var14 != 0) {
               return;
            }

            if(var14 != 0) {
               break;
            }
         }

         y.d.y var18 = this.c.h().g();
         M var19;
         M var20;
         switch(var4) {
         case 0:
            var19 = new M(var18.c(), this.c.i().c());
            var20 = new M(this.c.i().b(), var18.c() + var18.a());
            if(var14 == 0) {
               break;
            }
         case 1:
            var19 = new M(var18.d(), this.c.i().c());
            var20 = new M(this.c.i().b(), var18.d() + var18.b());
            if(var14 == 0) {
               break;
            }
         case 2:
            var19 = new M(this.c.i().b(), var18.c() + var18.a());
            var20 = new M(var18.c(), this.c.i().c());
            if(var14 == 0) {
               break;
            }
         case 3:
            var19 = new M(this.c.i().b(), var18.d() + var18.b());
            var20 = new M(var18.d(), this.c.i().c());
            if(var14 == 0) {
               break;
            }
         default:
            var19 = null;
            var20 = null;
         }

         this.i[var4] = var19;
         this.j[var4] = var20;
         switch(var5) {
         case 0:
            var20 = new M(var18.c(), this.c.j().c());
            var19 = new M(this.c.j().b(), var18.c() + var18.a());
            if(var14 == 0) {
               break;
            }
         case 1:
            var20 = new M(var18.d(), this.c.j().c());
            var19 = new M(this.c.j().b(), var18.d() + var18.b());
            if(var14 == 0) {
               break;
            }
         case 2:
            var20 = new M(this.c.j().b(), var18.c() + var18.a());
            var19 = new M(var18.c(), this.c.j().c());
            if(var14 == 0) {
               break;
            }
         case 3:
            var20 = new M(this.c.j().b(), var18.d() + var18.b());
            var19 = new M(var18.d(), this.c.j().c());
            if(var14 == 0) {
               break;
            }
         default:
            var19 = null;
            var20 = null;
         }

         this.i[var5] = var19;
         this.j[var5] = var20;
      } else {
         this.g = true;
      }
   }

   private int a(y.f.y var1, boolean var2) {
      return var2?var1.f():(var1.f() + 2) % 4;
   }

   public bE a(v var1, bD var2) {
      int var15 = ab.a;
      if(!this.g && var1.k() != null) {
         M var3;
         int var4;
         Object var5;
         label194: {
            var3 = null;
            var4 = this.a(var1.k(), true);
            if(this.h[var4] != null) {
               var5 = this.h[var4];
               if(var15 == 0) {
                  break label194;
               }
            }

            M var6;
            label183: {
               if(var1.c() != 0) {
                  var6 = var1.i().e();
                  if(var15 == 0) {
                     break label183;
                  }
               }

               var6 = var3 = M.a(var1.i().e(), var1.j().e());
            }

            double var7 = var6.d() > 1.0E-6D?1.0E-6D:0.0D;
            boolean var9 = this.i[var4].a(var6, var7);
            var9 = this.a?!var9:var9;
            boolean var10 = this.j[var4].a(var6, var7);
            var10 = this.b?!var10:var10;
            var5 = var9?(var10?f:d):(var10?e:null);
         }

         int var16;
         Object var17;
         double var20;
         label195: {
            var16 = this.a(var1.l(), false);
            if(this.h[var16] != null) {
               var17 = this.h[var16];
               if(var15 == 0) {
                  break label195;
               }
            }

            M var8;
            label196: {
               if(var1.c() != 0) {
                  var8 = var1.j().e();
                  if(var15 == 0) {
                     break label196;
                  }
               }

               var8 = var3 != null?var3:M.a(var1.i().e(), var1.j().e());
            }

            var20 = var8.d() > 1.0E-6D?1.0E-6D:0.0D;
            boolean var11 = this.i[var16].a(var8, var20);
            var11 = this.a?!var11:var11;
            boolean var12 = this.j[var16].a(var8, var20);
            var12 = this.b?!var12:var12;
            var17 = var11?(var12?f:d):(var12?e:null);
         }

         if(var5 != null && var17 != null) {
            if(var5 == f && var17 == f) {
               return new bE(0, var2);
            } else if(var5 != f && var17 != f) {
               int var19;
               if(var5 == var17) {
                  var19 = var2 != null && !bD.b(var2).equals(var5)?var2.c():0;
                  if(this.c.c() == 2 && var1.c() == 2 && this.h[var4] != null && this.h[var16] != null) {
                     int var13;
                     int var14;
                     double var23;
                     label144: {
                        if(var1.k().d()) {
                           var20 = var1.j().e().c(var1.i().f());
                           var23 = var1.i().e().c(var1.j().f());
                           var14 = var1.k().c().f();
                           var13 = var1.l().f();
                           if(var15 == 0) {
                              break label144;
                           }
                        }

                        var20 = var1.i().e().c(var1.j().f());
                        var23 = var1.j().e().c(var1.i().f());
                        var13 = var1.k().c().f();
                        var14 = var1.l().f();
                     }

                     if(var5 == d && !this.i[var14].a(var23) && !this.i[var13].a(var20) || var5 == e && !this.j[var14].a(var23) && !this.j[var13].a(var20)) {
                        var19 += 2;
                     }
                  }

                  return new bE(var19);
               } else {
                  var19 = var2 != null && !bD.b(var2).equals(var5)?var2.c():0;
                  return new bE(1 + var19);
               }
            } else {
               Object var18 = var5 != f?var5:var17;
               bD var21 = new bD(var1.g(), this.c.g(), var18, 1);
               bE var22 = new bE(0, var21);
               var22.a(var2);
               return var22;
            }
         } else {
            return new bE(0);
         }
      } else {
         return new bE(0);
      }
   }
}
