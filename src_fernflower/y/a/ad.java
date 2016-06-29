package y.a;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import y.a.Z;
import y.a.ae;
import y.a.af;
import y.a.h;

class ad {
   private static void a(List var0, y.c.h var1) {
      boolean var4 = h.a;
      ListIterator var2 = var0.listIterator();

      while(var2.hasNext()) {
         y.c.d var3 = (y.c.d)var2.next();
         if(var3.c().a() == 1 || var3.d().a() == 1) {
            var1.a(var3, 0.0D);
            if(var4) {
               break;
            }
         }
      }

   }

   private void a(y.c.i var1, y.c.d[] var2) {
      boolean var4 = h.a;
      int var3 = var2.length - 1;

      while(var3 >= 0) {
         if(!var1.f(var2[var3])) {
            var1.e(var2[var3]);
         }

         --var3;
         if(var4) {
            break;
         }
      }

   }

   private void a(y.c.i var1, y.c.A var2, y.c.A var3) {
      boolean var5 = h.a;
      y.c.x var4 = var1.o();

      while(var4.f()) {
         var3.a(var4.e(), var2.a(var4.e()));
         var4.g();
         if(var5) {
            break;
         }
      }

   }

   private static ArrayList a(List var0) {
      boolean var5 = h.a;
      ArrayList var1 = new ArrayList();
      ListIterator var2 = var0.listIterator();

      label26:
      while(true) {
         ArrayList var10000;
         if(var2.hasNext()) {
            y.c.q var3 = (y.c.q)var2.next();
            y.c.d var4 = var3.f();

            do {
               if(var4 == null) {
                  continue label26;
               }

               var10000 = var1;
               if(var5) {
                  return var10000;
               }

               var1.add(var4);
               var4 = var4.g();
            } while(!var5 && !var5);
         }

         var10000 = var1;
         return var10000;
      }
   }

   private void b(List var1, y.c.h var2) {
      boolean var4 = h.a;
      ListIterator var3 = var1.listIterator();

      while(var3.hasNext()) {
         var2.a(var3.next(), 0.0D);
         if(var4) {
            break;
         }
      }

   }

   private ArrayList a(ArrayList var1) {
      boolean var4 = h.a;
      ArrayList var2 = new ArrayList();
      ListIterator var3 = var1.listIterator();

      ArrayList var10000;
      while(true) {
         if(var3.hasNext()) {
            var10000 = var2;
            if(var4) {
               break;
            }

            var2.add(var3.next());
            if(!var4) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   private List a(y.c.i var1, y.c.A var2, int var3) {
      boolean var6 = h.a;
      ArrayList var4 = new ArrayList();
      int var5 = 0;

      ArrayList var10000;
      y.c.x var7;
      while(true) {
         if(var5 < var3) {
            var4.add(new ArrayList());
            ++var5;
            if(var6) {
               break;
            }

            if(!var6) {
               continue;
            }
         }

         if(var3 == 1) {
            var7 = var1.o();

            while(true) {
               if(var7.f()) {
                  var10000 = (ArrayList)var4.get(0);
                  if(var6) {
                     break;
                  }

                  var10000.add(var7.e());
                  var7.g();
                  if(!var6) {
                     continue;
                  }
               }

               var10000 = var4;
               break;
            }

            return var10000;
         }
         break;
      }

      var7 = var1.o();

      while(true) {
         if(var7.f()) {
            var10000 = (ArrayList)var4.get(var2.a(var7.e()));
            if(var6) {
               break;
            }

            var10000.add(var7.e());
            var7.g();
            if(!var6) {
               continue;
            }
         }

         var10000 = var4;
         break;
      }

      return var10000;
   }

   private double a(y.c.d[] var1, y.c.A var2, int var3, boolean var4) {
      double[][] var5;
      int var6;
      boolean var17;
      label73: {
         var17 = h.a;
         var5 = new double[var3][var3];
         var6 = var1.length;
         int var7;
         int var8;
         int var9;
         if(var4) {
            var7 = var6 - 1;

            do {
               if(var7 < 0) {
                  break label73;
               }

               var8 = var2.a(var1[var7].c());
               var9 = var2.a(var1[var7].d());
               ++var5[var8][var9];
               --var7;
            } while(!var17);
         }

         var7 = var6 - 1;

         label54: {
            while(var7 >= 0) {
               var8 = var2.a(var1[var7].c());
               var9 = var2.a(var1[var7].d());
               ++var5[var8][var9];
               ++var5[var9][var8];
               --var7;
               if(var17) {
                  break label54;
               }

               if(var17) {
                  break;
               }
            }

            var7 = var3 - 1;
         }

         while(var7 >= 0) {
            var5[var7][var7] /= 2.0D;
            --var7;
            if(var17) {
               break;
            }
         }
      }

      double var18 = 0.0D;
      double var19 = 0.0D;
      int var11 = var3 - 1;

      while(true) {
         if(var11 >= 0) {
            var18 += var5[var11][var11];
            double var12 = 0.0D;
            double var14 = 0.0D;
            if(var17) {
               break;
            }

            int var16 = var3 - 1;

            label38: {
               while(var16 >= 0) {
                  var12 += var5[var11][var16];
                  var14 += var5[var16][var11];
                  --var16;
                  if(var17) {
                     break label38;
                  }

                  if(var17) {
                     break;
                  }
               }

               var19 += var12 * var14;
               --var11;
            }

            if(!var17) {
               continue;
            }
         }

         var18 /= (double)var6;
         var19 /= (double)(var6 * var6);
         break;
      }

      return var18 - var19;
   }

   private int a(y.c.i var1, List var2, y.c.A var3, List var4, int var5) {
      boolean var13 = h.a;
      boolean[] var6 = new boolean[var1.e()];
      h.a(var1, (y.c.q)var2.get(0), false, var6);
      ListIterator var7 = var2.listIterator();

      do {
         if(!var7.hasNext()) {
            return var5;
         }
      } while(var6[((y.c.q)var7.next()).d()]);

      ArrayList var8 = new ArrayList();
      ArrayList var9 = (ArrayList)var4.get(var3.a((y.c.q)var2.get(0)));
      ListIterator var10 = var2.listIterator();

      int var10000;
      while(true) {
         if(var10.hasNext()) {
            y.c.q var11 = (y.c.q)var10.next();
            if(var6[var11.d()]) {
               continue;
            }

            var3.a(var11, var5);
            var8.add(var11);
            int var12 = var9.indexOf(var11);
            var10000 = var12;
            if(var13) {
               break;
            }

            if(var12 < 0) {
               continue;
            }

            var9.remove(var12);
            if(!var13) {
               continue;
            }
         }

         var4.add(var8);
         var10000 = var5 + 1;
         break;
      }

      return var10000;
   }

   private af c(List var1, y.c.h var2) {
      boolean var8 = h.a;
      double var3 = -1.7976931348623157E308D;
      af var5 = new af((ae)null);
      var5.a = -1.0D;
      ListIterator var6 = var1.listIterator();

      af var10000;
      while(true) {
         if(var6.hasNext()) {
            y.c.d var7 = (y.c.d)var6.next();
            if(var2.c(var7) <= var3) {
               continue;
            }

            var3 = var2.c(var7);
            var5.a = var2.c(var7);
            var10000 = var5;
            if(var8) {
               break;
            }

            var5.b = var7;
            if(!var8) {
               continue;
            }
         }

         var10000 = var5;
         break;
      }

      return var10000;
   }

   private y.c.d a(List var1, List var2, y.c.h var3, y.c.A var4, boolean var5, int var6) {
      boolean var16 = h.a;
      y.c.d var7 = null;
      ListIterator var11;
      if(var6 != -1) {
         label79: {
            double var8;
            if(!var5) {
               var8 = -1.7976931348623157E308D;
               af var10 = new af((ae)null);
               var10.a = -1.0D;
               var11 = var2.listIterator();

               label71: {
                  while(var11.hasNext()) {
                     y.c.d var12 = (y.c.d)var11.next();
                     if(var3.c(var12) > var8) {
                        var8 = var3.c(var12);
                        var10.a = var8;
                        var10.b = var12;
                        if(var16) {
                           break label71;
                        }

                        if(var16) {
                           break;
                        }
                     }
                  }

                  var1.set(var6, var10);
               }

               if(!var16) {
                  break label79;
               }
            }

            var8 = -1.7976931348623157E308D;
            double var18 = -1.7976931348623157E308D;
            af var19 = new af((ae)null);
            af var13 = new af((ae)null);
            var19.a = -1.0D;
            var13.a = -1.0D;
            ListIterator var14 = var2.listIterator();

            label56: {
               while(var14.hasNext()) {
                  y.c.d var15 = (y.c.d)var14.next();
                  if(var4.a(var15.c()) == var6) {
                     if(var3.c(var15) <= var8) {
                        continue;
                     }

                     var8 = var3.c(var15);
                     var19.b = var15;
                     var19.a = var8;
                     if(!var16) {
                        continue;
                     }
                  }

                  if(var3.c(var15) > var18) {
                     var18 = var3.c(var15);
                     var13.b = var15;
                     var13.a = var18;
                     if(var16) {
                        break label56;
                     }

                     if(var16) {
                        break;
                     }
                  }
               }

               var1.set(var6, var19);
            }

            var1.add(var13);
         }
      }

      double var9 = -1.7976931348623157E308D;
      var11 = var1.listIterator();

      y.c.d var10000;
      while(true) {
         if(var11.hasNext()) {
            af var17 = (af)var11.next();
            if(var17.a <= var9) {
               continue;
            }

            var9 = var17.a;
            var10000 = var17.b;
            if(var16) {
               break;
            }

            var7 = var10000;
            if(!var16) {
               continue;
            }
         }

         var10000 = var7;
         break;
      }

      return var10000;
   }

   int a(y.c.i var1, y.c.A var2, int var3, int var4, boolean var5, y.c.c var6) {
      boolean var24 = h.a;
      if(var1.g() == 0) {
         return h.a(var1, var2);
      } else {
         y.c.d[] var7 = var1.n();
         int var8 = h.a(var1, var2);
         List var10 = this.a(var1, var2, var8);
         ArrayList var11 = new ArrayList();
         double var12 = -1.7976931348623157E308D;
         y.c.A var14 = y.g.M.a(new int[var1.e()]);
         int var15 = 0;
         if(var8 >= var3) {
            var12 = this.a(var7, var2, var8, var5);
            this.a(var1, var2, var14);
            var15 = var8;
         }

         y.c.h var16 = var1.u();
         ArrayList var18 = null;
         y.c.d var19 = null;
         int var20 = -1;
         int var21 = 0;
         ListIterator var22 = var10.listIterator();

         while(var22.hasNext()) {
            label65: {
               ArrayList var23 = (ArrayList)var22.next();
               var18 = a((List)var23);
               if(var6 == null) {
                  Z.a(var1, var23, var18, var16, var5);
                  if(!var24) {
                     break label65;
                  }
               }

               Z.a(var1, var23, var18, var16, var5, var6);
            }

            a((List)var18, (y.c.h)var16);
            var11.add(this.c(var18, var16));
         }

         while(true) {
            var19 = this.a(var11, var18, var16, var2, (boolean)var21, var20);
            var1.d(var19);
            var20 = var2.a(var19.c());
            ArrayList var17 = this.a((ArrayList)var10.get(var20));
            int var9 = this.a(var1, var17, var2, var10, var8);
            if(var9 > var8) {
               var21 = 1;
               if(var9 >= var3 && var9 <= var4) {
                  double var25 = this.a(var7, var2, var9, var5);
                  if(var25 > var12) {
                     var12 = var25;
                     var15 = var9;
                     this.a(var1, var2, var14);
                  }
               }

               var8 = var9;
               if(var24) {
                  var21 = 0;
               }
            } else {
               var21 = 0;
            }

            while(true) {
               label56: {
                  var18 = a((List)var17);
                  this.b(var18, var16);
                  if(var6 == null) {
                     Z.a(var1, var17, var18, var16, var5);
                     if(!var24) {
                        break label56;
                     }
                  }

                  Z.a(var1, var17, var18, var16, var5, var6);
               }

               a((List)var18, (y.c.h)var16);
               if(var9 < var4 && var1.g() != 0) {
                  break;
               }

               this.a(var1, var7);
               this.a(var1, var14, var2);
               var1.a(var16);
               if(!var24) {
                  return var15;
               }

               var21 = var15;
            }
         }
      }
   }
}
