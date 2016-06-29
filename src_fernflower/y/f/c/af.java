package y.f.c;

import java.util.Arrays;
import y.f.c.R;
import y.f.c.a;
import y.f.c.w;
import y.f.c.a.aT;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.ba;

public class af implements R, aT {
   byte a;

   public void a(byte var1) {
      this.a = var1;
   }

   public int a(y.f.X var1, y.c.A var2, y.c.f var3) {
      boolean var10 = a.i;
      y.g.o.a(this, "Topological layering ...");
      if(var1.i()) {
         return 0;
      } else {
         y.c.A var4 = var1.t();
         int var5 = y.a.h.a(var1, (y.c.A)var4);
         y.g.J var6 = new y.g.J(var1, var4);
         int var7 = 0;
         int var8 = 0;

         int var10000;
         while(true) {
            if(var8 < var5) {
               var6.c(new Integer(var8));
               int var9 = this.a(var1, var2);
               y.g.o.a(this, "Reverse edges ...");
               this.a((y.c.i)var1, (y.c.A)var2, (y.c.f)var3);
               var10000 = this.a;
               if(var10) {
                  break;
               }

               switch(var10000) {
               case 1:
                  y.g.o.a(this, "Downshift nodes ...");
                  this.a(var1, var2, var9);
                  if(!var10) {
                     break;
                  }
               case 2:
                  y.g.o.a(this, "doGanserStuff");
                  this.a(var1, var2, var9);
                  var9 = this.b(var1, var2);
               }

               var7 = Math.max(var7, var9);
               ++var8;
               if(!var10) {
                  continue;
               }
            }

            var6.b();
            var1.a((y.c.A)var4);
            var10000 = var7;
            break;
         }

         return var10000;
      }
   }

   int a(y.c.i var1, y.c.A var2) {
      boolean var10 = a.i;
      y.c.y var3 = y.a.m.b(var1);
      var3.n();
      boolean var4 = false;
      int var5 = 0;
      y.c.x var6 = var3.a();

      while(true) {
         if(var6.f()) {
            var2.a(var6.e(), -1);
            var6.g();
            if(var10) {
               break;
            }

            if(!var10) {
               continue;
            }
         }

         var6 = var3.a();
         break;
      }

      int var10000;
      while(true) {
         if(var6.f()) {
            y.c.q var7 = var6.e();
            var10000 = -1;
            if(var10) {
               break;
            }

            int var8 = -1;
            y.c.x var9 = var7.n();

            label31: {
               while(var9.f()) {
                  var8 = Math.max(var8, var2.a(var9.e()));
                  var9.g();
                  if(var10) {
                     break label31;
                  }

                  if(var10) {
                     break;
                  }
               }

               var2.a(var7, var8 + 1);
               var5 = Math.max(var5, var8 + 1);
               var6.g();
            }

            if(!var10) {
               continue;
            }
         }

         var10000 = var5 + 1;
         break;
      }

      return var10000;
   }

   private void a(y.c.i var1, y.c.A var2, y.c.f var3) {
      var3.a(w.a(var1, var2));
   }

   private void a(y.c.i var1, y.c.A var2, int var3) {
      boolean var12 = a.i;
      y.c.D[] var4 = new y.c.D[var3 + 1];
      int var5 = 0;

      while(true) {
         if(var5 <= var3) {
            var4[var5] = new y.c.D();
            ++var5;
            if(var12) {
               break;
            }

            if(!var12) {
               continue;
            }
         }

         y.c.x var13 = var1.o();

         while(var13.f()) {
            var4[var2.a(var13.e())].b((Object)var13.e());
            var13.g();
            if(var12) {
               break;
            }
         }

         var5 = var3 - 1;
         break;
      }

      do {
         int var10000 = var5;

         label57:
         while(true) {
            if(var10000 < 0) {
               return;
            }

            y.c.D var6 = var4[var5];
            y.c.C var7 = var6.m();

            while(true) {
               if(!var7.f()) {
                  break label57;
               }

               y.c.q var8 = (y.c.q)var7.d();
               var10000 = var8.c();
               if(var12) {
                  break;
               }

               label52: {
                  if(var10000 != 0) {
                     boolean var9 = false;
                     int var10 = var3;
                     y.c.x var11 = var8.o();

                     while(var11.f()) {
                        var10 = Math.min(var10, var2.a(var11.e()));
                        var11.g();
                        if(var12) {
                           break label52;
                        }

                        if(var12) {
                           break;
                        }
                     }

                     if(var10 > var2.a(var8) + 1 && var8.c() >= var8.b()) {
                        var2.a(var8, var10 - 1);
                     }
                  }

                  var7.g();
               }

               if(var12) {
                  break label57;
               }
            }
         }

         --var5;
      } while(!var12);

   }

   private int b(y.c.i var1, y.c.A var2) {
      boolean var8 = a.i;
      int[] var3 = new int[var1.e()];
      y.c.x var4 = var1.o();

      int[] var10000;
      while(true) {
         if(var4.f()) {
            y.c.q var5 = var4.e();
            var10000 = var3;
            if(var8) {
               break;
            }

            var3[var5.d()] = var2.a(var5);
            var4.g();
            if(!var8) {
               continue;
            }
         }

         var10000 = new int[var1.g()];
         break;
      }

      int[] var9 = var10000;
      Arrays.fill(var9, 1);
      int var10 = y.a.u.a(var1, var3, var9);
      y.c.x var6 = var1.o();

      while(var6.f()) {
         y.c.q var7 = var6.e();
         var2.a(var7, var3[var7.d()]);
         var6.g();
         if(var8) {
            break;
         }
      }

      return var10;
   }

   public void a(y.f.X var1, aU var2, aV var3) {
      (new ba(this)).a(var1, var2, var3);
   }
}
