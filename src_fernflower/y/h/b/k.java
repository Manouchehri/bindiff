package y.h.b;

import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import y.h.bg;
import y.h.fj;
import y.h.b.a;
import y.h.b.b;
import y.h.b.c;
import y.h.b.f;
import y.h.b.i;
import y.h.b.q;
import y.h.b.s;

final class k implements bg {
   private k() {
   }

   public y.d.q a(fj var1) {
      return var1 instanceof a?a((a)var1):new y.d.q(0.0D, 0.0D);
   }

   private static y.d.q a(a var0) {
      if(a.e(var0) == null) {
         return new y.d.q(0.0D, 0.0D);
      } else {
         i var1 = var0.l();
         return new y.d.q(a(var1), b(var1));
      }
   }

   private static double a(i var0) {
      int var6 = a.H;
      s var1 = new s();
      a.a(var0, var1);
      double var2 = var1.b + var1.d;
      Iterator var4 = var0.l().iterator();

      double var10000;
      while(true) {
         if(var4.hasNext()) {
            c var5 = (c)var4.next();
            var10000 = var2 + a(var5);
            if(var6 != 0) {
               break;
            }

            var2 = var10000;
            if(var6 == 0) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   private static double a(c var0) {
      int var7 = a.H;
      List var1 = var0.l();
      if(var1.isEmpty()) {
         return var0.f();
      } else {
         double var2 = 0.0D;
         y.d.r var4 = var0.i();
         if(var4 != null) {
            var2 += var4.b + var4.d;
         }

         Iterator var5 = var1.iterator();

         double var10000;
         while(true) {
            if(var5.hasNext()) {
               c var6 = (c)var5.next();
               var10000 = var2 + a(var6);
               if(var7 != 0) {
                  break;
               }

               var2 = var10000;
               if(var7 == 0) {
                  continue;
               }
            }

            var10000 = var2;
            break;
         }

         return var10000;
      }
   }

   private static double b(i var0) {
      int var6 = a.H;
      s var1 = new s();
      a.b(var0, var1);
      double var2 = var1.a + var1.c;
      Iterator var4 = var0.o().iterator();

      double var10000;
      while(true) {
         if(var4.hasNext()) {
            f var5 = (f)var4.next();
            var10000 = var2 + a(var5);
            if(var6 != 0) {
               break;
            }

            var2 = var10000;
            if(var6 == 0) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   private static double a(f var0) {
      int var7 = a.H;
      List var1 = var0.o();
      if(var1.isEmpty()) {
         return var0.f();
      } else {
         double var2 = 0.0D;
         y.d.r var4 = var0.i();
         if(var4 != null) {
            var2 += var4.a + var4.c;
         }

         Iterator var5 = var1.iterator();

         double var10000;
         while(true) {
            if(var5.hasNext()) {
               f var6 = (f)var5.next();
               var10000 = var2 + a(var6);
               if(var7 != 0) {
                  break;
               }

               var2 = var10000;
               if(var7 == 0) {
                  continue;
               }
            }

            var10000 = var2;
            break;
         }

         return var10000;
      }
   }

   public y.d.q b(fj var1) {
      return new y.d.q(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
   }

   private static void b(a var0, Rectangle2D var1) {
      int var36 = a.H;
      if(a.e(var0) != null) {
         double var2 = var0.getWidth();
         double var4 = var0.getHeight();
         double var6 = var0.getX();
         double var8 = var0.getY();
         double var10 = var6 + var2;
         double var12 = var8 + var4;
         double var14 = var1.getWidth();
         double var16 = var1.getHeight();
         double var18 = var1.getX();
         double var20 = var18 + var14;
         double var22 = var1.getY();
         double var24 = var22 + var16;
         double var26 = var2 - var14;
         double var28 = var4 - var16;
         i var30 = var0.l();
         double var32;
         double var34;
         List var31;
         if(var26 != 0.0D) {
            label83: {
               var31 = var30.l();
               if(Math.abs(var18 - var6) > Math.abs(var20 - var10)) {
                  if(var26 > 0.0D) {
                     var32 = a(var30);
                     if(var32 > var14) {
                        var34 = var2 - var32;
                        if(var34 <= 0.0D) {
                           break label83;
                        }

                        a(var34, var31, true);
                        if(var36 == 0) {
                           break label83;
                        }
                     }

                     a(var26, var31, true);
                     if(var36 == 0) {
                        break label83;
                     }
                  }

                  b(-var26, var31, true);
                  if(var36 == 0) {
                     break label83;
                  }
               }

               if(var26 > 0.0D) {
                  var32 = a(var30);
                  if(var32 > var14) {
                     var34 = var2 - var32;
                     if(var34 <= 0.0D) {
                        break label83;
                     }

                     a(var34, var31, false);
                     if(var36 == 0) {
                        break label83;
                     }
                  }

                  a(var26, var31, false);
                  if(var36 == 0) {
                     break label83;
                  }
               }

               b(-var26, var31, false);
            }
         }

         if(var28 != 0.0D) {
            var31 = var30.o();
            if(Math.abs(var22 - var8) > Math.abs(var24 - var12)) {
               if(var28 > 0.0D) {
                  var32 = b(var30);
                  if(var32 > var16) {
                     var34 = var4 - var32;
                     if(var34 <= 0.0D) {
                        return;
                     }

                     a(var34, var31, true);
                     if(var36 == 0) {
                        return;
                     }
                  }

                  a(var28, var31, true);
                  if(var36 == 0) {
                     return;
                  }
               }

               b(-var28, var31, true);
               if(var36 == 0) {
                  return;
               }
            }

            if(var28 > 0.0D) {
               var32 = b(var30);
               if(var32 > var16) {
                  var34 = var4 - var32;
                  if(var34 <= 0.0D) {
                     return;
                  }

                  a(var34, var31, false);
                  if(var36 == 0) {
                     return;
                  }
               }

               a(var28, var31, false);
               if(var36 == 0) {
                  return;
               }
            }

            b(-var28, var31, false);
         }
      }

   }

   private static void a(double var0, List var2, boolean var3) {
      int var6 = a.H;
      q var4 = (q)var2.get(var3?0:var2.size() - 1);

      while(var4 != null) {
         var4.d(var4.q() + var0);
         List var5 = var4.b;
         if(var5.isEmpty()) {
            var4 = null;
         } else {
            var4 = (q)var5.get(var3?0:var5.size() - 1);
            if(var6 != 0) {
               break;
            }
         }
      }

   }

   private static double b(double var0, List var2, boolean var3) {
      double var4 = var0;
      double var6 = 0.0D;
      double var9;
      if(var3) {
         Iterator var8 = var2.iterator();

         while(var8.hasNext()) {
            var9 = a(var4, (q)var8.next(), var3);
            var4 -= var9;
            var6 += var9;
            if(var6 >= var0) {
               break;
            }
         }
      } else {
         ListIterator var11 = var2.listIterator(var2.size());

         while(var11.hasPrevious()) {
            var9 = a(var4, (q)var11.previous(), var3);
            var4 -= var9;
            var6 += var9;
            if(var6 >= var0) {
               break;
            }
         }
      }

      return Math.min(var0, var6);
   }

   private static double a(double var0, q var2, boolean var3) {
      List var4 = var2.b;
      double var5 = var4.isEmpty()?var0:b(var0, var4, var3);
      double var7 = var2.q();
      var2.d(var7 - var5);
      return var7 - var2.q();
   }

   k(b var1) {
      this();
   }

   static void a(a var0, Rectangle2D var1) {
      b(var0, var1);
   }
}
