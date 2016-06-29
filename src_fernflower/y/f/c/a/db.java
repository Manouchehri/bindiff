package y.f.c.a;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import y.f.c.a.N;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.bK;
import y.f.c.a.dc;

class db {
   private boolean a = false;
   private bK[] b = null;

   public void a(y.f.X var1, aU var2, aV var3) {
      boolean var16 = N.x;
      if(this.a) {
         int[] var4 = new int[var1.e()];
         dc var5 = new dc(this, var4);
         y.c.x var6 = var1.o();

         while(var6.f()) {
            label106: {
               y.c.q var7 = var6.e();
               aX var8 = var3.a(var7);
               bK var9 = var8.h();
               if(var9 != null) {
                  var4[var7.d()] = var9.j();
                  if(!var16) {
                     break label106;
                  }
               }

               var4[var7.d()] = -1;
            }

            var6.g();
            if(var16) {
               break;
            }
         }

         y.c.q[] var17 = null;
         int var18 = 0;

         label97:
         do {
            int var10000 = var18;

            y.c.p var10;
            int var12;
            aQ var19;
            label94:
            while(true) {
               if(var10000 >= var2.b()) {
                  return;
               }

               var19 = var2.a(var18);
               y.c.p var20 = var19.d().l();
               var10 = null;
               y.c.p var11 = var19.d().k();

               while(true) {
                  if(var11 == var20) {
                     break label94;
                  }

                  var12 = ((y.c.q)var11.c()).d();
                  int var13 = ((y.c.q)var11.a().c()).d();
                  var10000 = var4[var12];
                  if(var16) {
                     break;
                  }

                  if(var10000 >= 0 && var4[var13] >= 0 && var4[var12] > var4[var13]) {
                     var10 = var11;
                     break label94;
                  }

                  var11 = var11.a();
               }
            }

            if(var10 != null) {
               int var21 = -1;
               if(var17 == null || var17.length < var19.d().size()) {
                  var17 = new y.c.q[var19.d().size()];
               }

               var12 = 0;
               y.c.p var22 = var19.d().k();

               label72: {
                  while(var22 != null) {
                     int var14 = ((y.c.q)var22.c()).d();
                     int var15 = var4[var14];
                     var10000 = var15;
                     if(var16) {
                        break label72;
                     }

                     label68: {
                        if(var15 < 0) {
                           var4[var14] = var21;
                           if(!var16) {
                              break label68;
                           }
                        }

                        var21 = var15;
                     }

                     var17[var12] = (y.c.q)var22.c();
                     var22 = var22.a();
                     ++var12;
                     if(var16) {
                        break;
                     }
                  }

                  y.g.e.a(var17, 0, var12, var5);
                  var10000 = 0;
               }

               var12 = var10000;
               var22 = var19.d().k();

               while(var22 != null) {
                  var22.a(var17[var12]);
                  var22 = var22.a();
                  ++var12;
                  if(var16) {
                     continue label97;
                  }

                  if(var16) {
                     break;
                  }
               }

               var19.a((y.c.D)var19.d());
            }

            ++var18;
         } while(!var16);

      }
   }

   public void b(y.f.X var1, aU var2, aV var3) {
      boolean var11 = N.x;
      ArrayList var4 = new ArrayList();
      int var5 = 0;

      while(true) {
         if(var5 < var2.b()) {
            aQ var6 = var2.a(var5);
            if(var11) {
               break;
            }

            y.c.p var7 = var6.d().k();

            label53: {
               while(var7 != null) {
                  y.c.q var8 = (y.c.q)var7.c();
                  aX var9 = var3.a(var8);
                  bK var10 = var9.h();
                  if(var11) {
                     break label53;
                  }

                  if(var10 != null) {
                     var4.add(var10);
                  }

                  var7 = var7.a();
                  if(var11) {
                     break;
                  }
               }

               ++var5;
            }

            if(!var11) {
               continue;
            }
         }

         if(var4.size() > 0) {
            bK[] var12 = new bK[var4.size()];
            this.a = true;
            y.g.e.a((List)var4, (Comparator)null);
            int var13 = 0;
            bK var14 = (bK)var4.get(0);
            var12[var13] = var14;
            var14.a(var13);
            int var15 = 1;

            label36: {
               while(var15 < var4.size()) {
                  bK var16 = (bK)var4.get(var15);
                  if(var11) {
                     break label36;
                  }

                  if(var16.compareTo(var14) > 0) {
                     ++var13;
                     var12[var13] = var16;
                  }

                  var16.a(var13);
                  var14 = var16;
                  ++var15;
                  if(var11) {
                     break;
                  }
               }

               this.b = new bK[var13 + 1];
            }

            System.arraycopy(var12, 0, this.b, 0, this.b.length);
         }
         break;
      }

   }

   bK a(int var1) {
      return this.b != null && var1 >= 0 && var1 < this.b.length?this.b[var1]:null;
   }
}
