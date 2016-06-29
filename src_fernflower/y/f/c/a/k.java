package y.f.c.a;

import y.f.c.a.N;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.f;
import y.f.c.a.i;

class k {
   private double[][] a;
   private int b;
   private int c;
   private y.c.q d;
   private double e;
   private double f;
   private y.c.D g;
   private y.f.b.c h;
   private int i;
   private final f j;

   public k(f var1, y.c.q var2, y.f.b.c var3) {
      this.j = var1;
      this.d = var2;
      this.h = var3;
      this.i = var3.c(var2).size();
      this.g = new y.c.D();
   }

   public void a(i var1) {
      this.g.add(var1);
   }

   private void b(y.c.A var1, y.c.A var2) {
      boolean var6 = N.x;
      this.b = Integer.MAX_VALUE;
      this.c = 0;
      y.c.x var3 = this.h.b(this.d).a();

      while(var3.f()) {
         label17: {
            y.c.q var4 = var3.e();
            if(this.h.d(var4)) {
               k var5 = (k)var2.b(var4);
               this.b = Math.min(this.b, var5.b);
               this.c = Math.max(this.c, var5.c);
               if(!var6) {
                  break label17;
               }
            }

            int var7 = var1.a(var4);
            this.b = Math.min(this.b, var7);
            this.c = Math.max(this.c, var7);
         }

         var3.g();
         if(var6) {
            break;
         }
      }

   }

   private void a(y.c.A var1, y.c.A var2, y.c.A var3) {
      boolean var16 = N.x;
      int var4 = f.a(this.j).f() + 1;
      this.a = new double[var4][2];
      y.c.x var5 = this.h.b(this.d).a();

      byte var21;
      label76:
      while(true) {
         int var10000 = var5.f();

         label73:
         while(var10000 != 0) {
            y.c.q var6 = var5.e();
            var21 = var2.d(var6);
            if(var16) {
               break label76;
            }

            if(var21 == 0) {
               label82: {
                  if(this.h.d(var6)) {
                     k var7 = (k)var3.b(var6);
                     int var8 = var7.b - this.b;
                     int var9 = 0;

                     do {
                        if(var9 >= var7.c + 1 - var7.b) {
                           break label82;
                        }

                        int var10 = var9 + var8;
                        double var11 = this.a[var10][0];
                        double var13 = var7.a[var9][0];
                        this.a[var10][0] = Math.max(var11, var13);
                        double var22;
                        var10000 = (var22 = this.a[var10][1] - 0.0D) == 0.0D?0:(var22 < 0.0D?-1:1);
                        if(var16) {
                           continue label73;
                        }

                        boolean var15 = var10000 == 0;
                        this.a[var10][1] += var7.f + (var15?0.0D:30.0D);
                        ++var9;
                     } while(!var16);
                  }

                  int var18 = var1.a(var6) - this.b;
                  double var19 = this.a[var18][0];
                  this.a[var18][0] = Math.max(var19, f.a(this.j, var6));
                  boolean var20 = this.a[var18][1] == 0.0D;
                  this.a[var18][1] += f.b(this.j, var6) + (var20?0.0D:30.0D);
               }
            }

            var5.g();
            if(!var16) {
               continue label76;
            }
            break;
         }

         var21 = 0;
         break;
      }

      int var17 = var21;

      while(var17 < this.c + 1 - this.b) {
         this.f = Math.max(this.f, this.a[var17][1]);
         this.e += this.a[var17][0] + (var17 == 0?0.0D:30.0D);
         ++var17;
         if(var16) {
            break;
         }
      }

   }

   private void a(y.c.A var1) {
      boolean var6 = N.x;
      y.c.C var2 = this.g.m();

      while(var2.f()) {
         i var3 = (i)var2.d();
         y.c.x var4 = var3.c().a();

         while(true) {
            if(var4.f()) {
               y.c.q var5 = var4.e();
               var1.a(var5, true);
               var4.g();
               if(var6) {
                  break;
               }

               if(!var6) {
                  continue;
               }
            }

            var2.g();
            break;
         }

         if(var6) {
            break;
         }
      }

   }

   public void a(y.c.A var1, y.c.A var2) {
      boolean var14 = N.x;
      y.c.A var3 = y.g.M.a();
      this.a(var3);
      this.b(var1, var2);
      this.a(var1, var3, var2);
      if(!this.g.isEmpty()) {
         label58: {
            y.c.C var4 = this.g.m();

            while(var4.f()) {
               Object var10000 = var4.d();

               i var5;
               int var6;
               label50:
               while(true) {
                  var5 = (i)var10000;
                  var6 = 0;
                  double var7 = 0.0D;
                  int var9 = this.c + 2 - this.b;
                  if(var14) {
                     break label58;
                  }

                  int var10 = 0;

                  while(true) {
                     if(var10 >= var9) {
                        break label50;
                     }

                     y.d.q var11 = this.a(var5, var10);
                     var10000 = var11;
                     if(var14) {
                        break;
                     }

                     if(var11 == null) {
                        break label50;
                     }

                     if(var11.a <= this.f && var11.b <= this.e) {
                        var6 = var10;
                        if(!var14) {
                           break label50;
                        }
                     }

                     double var12 = var11.a / var11.b;
                     if(var10 == 0 || f.a(this.j, var12, var7)) {
                        var6 = var10;
                        var7 = var12;
                     }

                     ++var10;
                     if(var14) {
                        break label50;
                     }
                  }
               }

               this.a(var5, var6, var1);
               var4.g();
               if(var14) {
                  break;
               }
            }

            this.b(var1, var2);
         }
      }

      y.d.r var15 = f.c(this.j, this.d);
      this.f += var15.b + var15.d;
      this.e += var15.a + var15.c;
      this.a[0][0] += var15.a;
      this.a[this.c - this.b][0] += var15.c;
   }

   private void a(i var1, int var2, y.c.A var3) {
      boolean var11 = N.x;
      int var4 = this.c - this.b;
      double[][] var5 = var1.e();
      int var6 = 0;

      int var7;
      while(var6 < var5.length) {
         var7 = var6 + var2;
         boolean var8 = this.a[var7][1] == 0.0D;
         this.a[var7][1] += var5[var6][1] + (var8?0.0D:30.0D);
         this.f = Math.max(this.f, this.a[var7][1]);
         double var9 = var5[var6][0] - this.a[var7][0];
         if(var9 > 0.0D) {
            this.e += var9;
            this.a[var7][0] += var9;
         }

         if(var7 > var4) {
            this.e += 30.0D;
            ++this.c;
            ++var4;
         }

         ++var6;
         if(var11) {
            break;
         }
      }

      aU var12 = var1.b();
      var7 = 0;

      while(var7 < var12.b()) {
         aQ var13 = var12.a(var7);
         y.c.x var14 = var13.d().a();

         while(true) {
            if(var14.f()) {
               var3.a(var14.e(), this.b + var2 + var7);
               var14.g();
               if(var11) {
                  break;
               }

               if(!var11) {
                  continue;
               }
            }

            ++var7;
            break;
         }

         if(var11) {
            break;
         }
      }

   }

   private y.d.q a(i var1, int var2) {
      boolean var16 = N.x;
      int var3 = this.c - this.b;
      double var4 = this.e;
      double var6 = this.f;
      double[][] var8 = var1.e();
      int var9 = 0;

      while(true) {
         if(var9 < var8.length) {
            int var10 = var9 + var2;
            if(var10 >= this.a.length) {
               return null;
            }

            boolean var11 = this.a[var10][1] == 0.0D;
            double var12 = this.a[var10][1] + var8[var9][1] + (var11?0.0D:30.0D);
            var6 = Math.max(var6, var12);
            double var14 = var8[var9][0] - this.a[var10][0];
            if(var14 > 0.0D) {
               var4 += var14;
            }

            if(var10 > var3) {
               var4 += 30.0D;
               ++var3;
            }

            ++var9;
            if(!var16) {
               continue;
            }
         }

         return new y.d.q(var6, var4);
      }
   }
}
