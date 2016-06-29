package y.f.i.a;

import java.util.HashMap;
import java.util.List;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.S;
import y.f.i.a.aU;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.bc;
import y.f.i.a.f;
import y.f.i.a.v;

class ca extends ab {
   private int b;
   private int c;
   private int[] d;
   private int[] e;
   private int f;
   private double[] g;
   private boolean h = true;
   private boolean i;

   protected void b(aa var1) {
      super.b(var1);
      this.b = var1.d().f().i();
      this.i = this.b > 0;
   }

   double[] a(f var1, R var2, P[] var3, v[] var4, double[] var5) {
      int var17 = ab.a;
      if(this.i && var1.d() != null) {
         y.c.D var6 = null;
         y.c.D var7 = null;
         HashMap var8 = new HashMap();
         if(this.h) {
            this.a(var1, var8);
            var6 = (y.c.D)var8.get(var1.a());
            var7 = (y.c.D)var8.get(var2);
         }

         boolean[] var9;
         R var11;
         label88: {
            var9 = new boolean[var3.length];
            P var10 = var1.c();
            var11 = var1.a();
            P var12 = this.a(var11, var3[0].a());
            byte var13 = var4[0].c();
            switch(var13) {
            case 0:
            case 1:
               aU var14;
               int var15;
               int var10000;
               List var16;
               label73: {
                  var14 = this.a().a(this.b().c());
                  if(!var1.i() && var14.b(true).size() > 0) {
                     var15 = 0;

                     while(var15 < var3.length) {
                        var10000 = var4[var15].c();
                        if(var17 != 0) {
                           break label73;
                        }

                        if(var10000 == 0) {
                           var16 = var14.a(var14.a(var1.a(), var2, var3[var15], true));
                           var9[var15] = var16.size() > 0;
                        }

                        ++var15;
                        if(var17 != 0) {
                           break;
                        }
                     }
                  }

                  var10000 = var14.b(false).size();
               }

               if(var10000 > 0) {
                  var15 = 0;

                  while(var15 < var3.length) {
                     var16 = var14.a(var14.a(var1.a(), var2, var3[var15], false));
                     if(var17 != 0) {
                        return super.a(var1, var2, var3, var4, var5);
                     }

                     var9[var15] |= var16.size() > 0;
                     ++var15;
                     if(var17 != 0) {
                        break;
                     }
                  }
               }

               P[] var18 = new P[]{var12};
               this.c = this.a(var11, var18, var6, new boolean[1])[0];
               if(var17 == 0) {
                  break label88;
               }
            case 2:
               if(var17 == 0) {
                  break label88;
               }
            case 3:
               break;
            default:
               break label88;
            }

            P[] var19 = new P[]{var12};
            this.c = this.a(var11, var19, var6, new boolean[1])[0];
            if(var6 == null) {
               var6 = new y.c.D();
            }

            var6.add(var10);
         }

         this.d = this.a(var11, var3, var6, var9);
         this.e = this.a(var2, var3, var7, var9);
         this.a(var1, var3, var4, var8, var9);
         this.f = 0;
         return super.a(var1, var2, var3, var4, var5);
      } else {
         this.b("min edge dist penalty", 0.0D, false);
         return new double[var3.length];
      }
   }

   private void a(f var1, HashMap var2) {
      int var9 = ab.a;
      f var3 = var1.b();
      v var4 = var1.j();

      while(var3 != null) {
         R var5 = var3.a();
         if(var4 != null) {
            Object var6 = (List)var2.get(var5);
            if(var6 == null) {
               var6 = new y.c.D();
               var2.put(var5, var6);
            }

            ((List)var6).add(var4.j());
            byte var7 = var4.c();
            if(var7 == 1 || var7 == 2 || var7 == 3) {
               ((List)var6).add(var4.i());
               if(var7 != 2) {
                  P var8 = this.a(var5, var4.i().a());
                  ((List)var6).add(var8);
               }
            }
         }

         var4 = var3.j();
         var3 = var3.b();
         if(var9 != 0) {
            break;
         }
      }

   }

   private void a(f var1, P[] var2, v[] var3, HashMap var4, boolean[] var5) {
      int var18 = ab.a;
      if(var1.d() == var3[0].l()) {
         this.g = new double[var2.length];
         y.c.D var6 = new y.c.D();
         int[] var7 = new int[var2.length];
         int var8 = 0;

         int var10000;
         label76: {
            while(var8 < var2.length) {
               P var9 = var2[var8];
               var10000 = var3[var8].c();
               if(var18 != 0) {
                  break label76;
               }

               if(var10000 == 0 && var3[var8].i().d() > var9.d()) {
                  var7[var6.size()] = var8;
                  var6.add(var9);
               }

               ++var8;
               if(var18 != 0) {
                  break;
               }
            }

            var10000 = var6.size();
         }

         if(var10000 > 0) {
            P[] var19 = (P[])var6.toArray(new P[var6.size() + 1]);
            int var20 = var19.length - 1;
            var19[var20] = var1.c();
            int[] var10 = new int[var19.length];
            v var11 = var1.j();
            f var12 = var1.b();

            byte var23;
            label63: {
               label62:
               while(var12 != null) {
                  R var13 = var12.a();
                  List var14 = (List)var4.get(var13);
                  int[] var15 = this.a(var13, var19, var14, new boolean[var19.length]);
                  int var16 = var15[var20];
                  var23 = 0;
                  if(var18 != 0) {
                     break label63;
                  }

                  int var17 = 0;

                  while(var17 < var10.length) {
                     var10[var17] = var10[var17] - var16 + var15[var17];
                     ++var17;
                     if(var18 != 0) {
                        break label62;
                     }

                     if(var18 != 0) {
                        break;
                     }
                  }

                  if(var11 == null || var11.c() != 0) {
                     break;
                  }

                  var11 = var12.j();
                  var12 = var12.b();
                  if(var18 != 0) {
                     break;
                  }
               }

               var23 = 0;
            }

            int var21 = var23;

            while(var21 < var10.length - 1) {
               int var22 = var7[var21];
               if(!var5[var22]) {
                  this.g[var22] = (double)var10[var21];
               }

               ++var21;
               if(var18 != 0) {
                  break;
               }
            }
         }
      }

   }

   protected double a(f var1, R var2, P var3, v var4, double var5) {
      int var10 = ab.a;
      int var7 = this.f++;
      double var8 = (double)this.e[var7];
      if(var8 > var5) {
         this.a("min edge dist penalty", var8, false);
         return var8;
      } else {
         switch(var4.c()) {
         case 1:
         case 3:
            var8 += (double)this.d[var7];
            var8 += (double)this.c;
            if(var10 == 0) {
               break;
            }
         case 2:
            var8 += (double)this.d[var7];
            if(var10 == 0) {
               break;
            }
         case 0:
            var8 += this.g[var7];
         }

         this.a("min edge dist penalty", var8, false);
         return var8;
      }
   }

   protected int[] a(R var1, P[] var2, List var3, boolean[] var4) {
      int var9 = ab.a;
      bc var5 = var1.b();
      boolean[] var6 = var3 != null && !var3.isEmpty()?var5.a(var2, var3):var5.a(var2, var4);
      int[] var7 = new int[var2.length];
      int var8 = 0;

      int[] var10000;
      while(true) {
         if(var8 < var2.length) {
            var10000 = var7;
            if(var9 != 0) {
               break;
            }

            var7[var8] = var6[var8]?0:this.b;
            ++var8;
            if(var9 == 0) {
               continue;
            }
         }

         var10000 = var7;
         break;
      }

      return var10000;
   }

   private P a(R var1, boolean var2) {
      S var3 = var2?S.a:S.d;
      return var1.a(var3);
   }
}
