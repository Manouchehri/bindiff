package y.h;

import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D.Double;
import java.util.Arrays;
import y.h.eH;
import y.h.eI;
import y.h.fj;

public class C {
   private double[] b;
   private int c;
   private double d;
   private double e;
   private short f;
   private short g;
   private short h;
   private Double i;
   private final eH j;
   private final double[] k;
   double[] a;

   public void a() {
      this.c = 0;
   }

   public short b() {
      return this.h;
   }

   public short c() {
      return this.g;
   }

   public short d() {
      return this.f;
   }

   public void a(double var1, double var3, double var5, double var7) {
      double var9 = 2.0D * this.d;
      double var11 = var1 - var9;
      double var13 = var3 - var9;
      double var15 = var5 + var9;
      double var17 = var7 + var9;
      this.i.setFrame(var11, var13, var15 - var11, var17 - var13);
   }

   public PathIterator a(PathIterator var1) {
      boolean var9 = fj.z;
      eH var2 = this.j;
      double[] var3 = this.k;
      var2.c();
      var2.a(var1);
      double var4 = 0.0D;
      double var6 = 0.0D;
      eI var8 = var2.a();

      while(var8 != null) {
         switch(var8.a()) {
         case 4:
            if(!var9) {
               break;
            }
         case 3:
            var8.a(var3);
            var4 = var3[4];
            var6 = var3[5];
            if(!var9) {
               break;
            }
         case 1:
            var8.a(var3);
            this.a(var2, var8, var4, var6, var3[0], var3[1]);
            var4 = var3[0];
            var6 = var3[1];
            if(!var9) {
               break;
            }
         case 0:
            var8.a(var3);
            var4 = var3[0];
            var6 = var3[1];
            if(!var9) {
               break;
            }
         case 2:
            var8.a(var3);
            var4 = var3[2];
            var6 = var3[3];
         }

         var8 = var8.b();
         if(var9) {
            break;
         }
      }

      return var2.getPathIterator((AffineTransform)null);
   }

   public void b(PathIterator var1) {
      boolean var8 = fj.z;
      double[] var2 = this.k;
      double var3 = 0.0D;
      double var5 = 0.0D;

      while(!var1.isDone()) {
         int var7 = var1.currentSegment(var2);
         switch(var7) {
         case 4:
            if(!var8) {
               break;
            }
         case 3:
            var3 = var2[4];
            var5 = var2[5];
            if(!var8) {
               break;
            }
         case 1:
            this.b(var3, var5, var2[0], var2[1]);
            var3 = var2[0];
            var5 = var2[1];
            if(!var8) {
               break;
            }
         case 0:
            var3 = var2[0];
            var5 = var2[1];
            if(!var8) {
               break;
            }
         case 2:
            var3 = var2[2];
            var5 = var2[3];
         }

         var1.next();
         if(var8) {
            break;
         }
      }

   }

   public void b(double var1, double var3, double var5, double var7) {
      if(this.i.intersectsLine(var1, var3, var5, var7)) {
         this.c(var1, var3, var5, var7);
      }
   }

   private void a(eH var1, eI var2, double var3, double var5, double var7, double var9) {
      boolean var40 = fj.z;
      if(this.i.intersectsLine(var3, var5, var7, var9)) {
         if(this.c > 0) {
            double var11 = var7 - var3;
            double var13 = var9 - var5;
            if(this.h != 0) {
               switch(this.h) {
               case 1:
                  if(Math.abs(var11) < Math.abs(var13)) {
                     return;
                  }
                  break;
               case 2:
                  if(Math.abs(var11) > Math.abs(var13)) {
                     return;
                  }
               }
            }

            double var15 = Math.sqrt(var11 * var11 + var13 * var13);
            if(var15 > 0.0D) {
               double var17 = var11 / var15;
               double var19 = var13 / var15;
               int var21 = 0;
               int var22 = 0;

               int var10000;
               label62: {
                  while(var22 < this.c) {
                     var10000 = Line2D.linesIntersect(var3, var5, var7, var9, this.b[var22], this.b[var22 + 1], this.b[var22 + 2], this.b[var22 + 3]);
                     if(var40) {
                        break label62;
                     }

                     if(var10000 != 0) {
                        double var23 = this.b[var22];
                        double var25 = this.b[var22 + 1];
                        double var27 = this.b[var22 + 2] - var23;
                        double var29 = this.b[var22 + 3] - var25;
                        double var31 = var29 * var11 - var27 * var13;
                        double var33 = (var27 * (var5 - var25) - var29 * (var3 - var23)) / var31;
                        if(var33 > 0.0D && var33 < 1.0D) {
                           double var35 = (var11 * (var5 - var25) - var13 * (var3 - var23)) / var31;
                           if(var35 > 0.0D && var35 < 1.0D) {
                              double var37 = var33 * var15;
                              if(var37 > 0.1D && var37 < var15 - 0.1D) {
                                 if(var21 == this.a.length) {
                                    double[] var39 = new double[this.a.length * 2];
                                    System.arraycopy(this.a, 0, var39, 0, this.a.length);
                                    this.a = var39;
                                 }

                                 this.a[var21++] = var37;
                              }
                           }
                        }
                     }

                     var22 += 4;
                     if(var40) {
                        break;
                     }
                  }

                  var10000 = var21;
               }

               if(var10000 > 0) {
                  Arrays.sort(this.a, 0, var21);
                  this.a(var1, var2, var3, var5, var7, var9, var11, var13, var17, var19, var15, this.a, var21);
               }
            }
         }

         if(this.h == 0) {
            this.c(var3, var5, var7, var9);
         }

      }
   }

   private void c(double var1, double var3, double var5, double var7) {
      if(this.h != 0) {
         switch(this.h) {
         case 1:
            if(Math.abs(var5 - var1) > Math.abs(var7 - var3)) {
               return;
            }
            break;
         case 2:
            if(Math.abs(var5 - var1) < Math.abs(var7 - var3)) {
               return;
            }
         }
      }

      if(this.c == this.b.length) {
         double[] var9 = new double[this.b.length * 2];
         System.arraycopy(this.b, 0, var9, 0, this.b.length);
         this.b = var9;
      }

      this.b[this.c++] = var1;
      this.b[this.c++] = var3;
      this.b[this.c++] = var5;
      this.b[this.c++] = var7;
   }

   private void a(eH var1, eI var2, double var3, double var5, double var7, double var9, double var11, double var13, double var15, double var17, double var19, double[] var21, int var22) {
      boolean var40 = fj.z;
      double var23 = this.d * 0.5D;
      double var25 = Math.max(0.0D, var21[0] - var23);
      double var27 = Math.min(var19, var21[0] + var23);
      int var29 = 1;

      int var10000;
      while(true) {
         if(var29 < var22) {
            double var30 = var21[var29];
            double var32 = Math.max(0.0D, var30 - var23);
            double var34 = Math.min(var19, var30 + var23);
            double var42;
            var10000 = (var42 = var32 - var27) == 0.0D?0:(var42 < 0.0D?-1:1);
            if(var40) {
               break;
            }

            label23: {
               if(var10000 > 0) {
                  double var36 = var3 + var25 / var19 * var11;
                  double var38 = var5 + var25 / var19 * var13;
                  var1.b(var36, var38, var2);
                  this.a(var1, var2, var25, var36, var38, var27, var3 + var27 / var19 * var11, var5 + var27 / var19 * var13, var15, var17);
                  var25 = var32;
                  var27 = var34;
                  if(!var40) {
                     break label23;
                  }
               }

               var27 = var34;
            }

            ++var29;
            if(!var40) {
               continue;
            }
         }

         double var43;
         var10000 = (var43 = var27 - var25) == 0.0D?0:(var43 < 0.0D?-1:1);
         break;
      }

      if(var10000 > 0) {
         double var41 = var3 + var25 / var19 * var11;
         double var31 = var5 + var25 / var19 * var13;
         var1.b(var41, var31, var2);
         this.a(var1, var2, var25, var41, var31, var27, var3 + var27 / var19 * var11, var5 + var27 / var19 * var13, var15, var17);
      }

   }

   private void a(eH var1, eI var2, double var3, double var5, double var7, double var9, double var11, double var13, double var15, double var17) {
      boolean var27 = fj.z;
      short var19 = this.d();
      boolean var20 = this.a(var15, var17);
      double var21;
      double var23;
      switch(var19) {
      case 4:
         var21 = var11 - var5;
         var23 = var13 - var7;
         if(var20) {
            var1.a(var5 + var23 * 0.5D, var7 - var21 * 0.5D, var5 + (var23 + var21) * 0.5D, var7 + (var23 - var21) * 0.5D, var2);
            var1.a(var11 + var23 * 0.5D, var13 - var21 * 0.5D, var11, var13, var2);
            if(!var27) {
               break;
            }
         }

         var1.a(var5 - var23 * 0.5D, var7 + var21 * 0.5D, var5 + (var21 - var23) * 0.5D, var7 + (var21 + var23) * 0.5D, var2);
         var1.a(var11 - var23 * 0.5D, var13 + var21 * 0.5D, var11, var13, var2);
         if(!var27) {
            break;
         }
      case 1:
         var21 = var20?-this.e:this.e;
         var23 = (var9 - var3) * 0.5D;
         if(this.e < var23) {
            double var25 = this.e;
            var1.a(var5 - var17 * var21, var7 + var15 * var21, var5 - var17 * var21 + var15 * var25, var7 + var15 * var21 + var17 * var25, var2);
            var1.b(var11 - var17 * var21 - var15 * var25, var13 + var15 * var21 - var17 * var25, var2);
            var1.a(var11 - var17 * var21, var13 + var15 * var21, var11, var13, var2);
            if(!var27) {
               break;
            }
         }

         var1.a(var5 - var17 * var21, var7 + var15 * var21, var5 - var17 * var21 + var15 * var23, var7 + var15 * var21 + var17 * var23, var2);
         var1.a(var11 - var17 * var21, var13 + var15 * var21, var11, var13, var2);
         if(!var27) {
            break;
         }
      case 127:
         this.a(var1, var2, var3, var5, var7, var9, var11, var13);
         if(!var27) {
            break;
         }
      case 0:
      default:
         var1.a(var11, var13, var2);
         if(!var27) {
            break;
         }
      case 5:
         var21 = var11 - var5;
         var23 = var13 - var7;
         if(var20) {
            var1.b(var5 + var23 * 0.5D, var7 - var21 * 0.5D, var2);
            var1.b(var11 + var23 * 0.5D, var13 - var21 * 0.5D, var2);
            var1.b(var11, var13, var2);
            if(!var27) {
               break;
            }
         }

         var1.b(var5 - var23 * 0.5D, var7 + var21 * 0.5D, var2);
         var1.b(var11 - var23 * 0.5D, var13 + var21 * 0.5D, var2);
         var1.b(var11, var13, var2);
         if(!var27) {
            break;
         }
      case 2:
         var21 = var20?-this.e:this.e;
         var1.b(var5 - var17 * var21, var7 + var15 * var21, var2);
         var1.b(var11 - var17 * var21, var13 + var15 * var21, var2);
         var1.b(var11, var13, var2);
         if(!var27) {
            break;
         }
      case 3:
         var21 = var20?-this.e:this.e;
         var23 = this.e;
         var1.b(var5 - var17 * var21 + var15 * var23, var7 + var15 * var21 + var17 * var23, var2);
         var1.b(var11 - var17 * var21 - var15 * var23, var13 + var15 * var21 - var17 * var23, var2);
         var1.b(var11, var13, var2);
         if(!var27) {
            break;
         }
      case 6:
         var21 = var11 - var5;
         var23 = var13 - var7;
         if(var20) {
            var1.b(var5 + (var23 + var21) * 0.5D, var7 + (var23 - var21) * 0.5D, var2);
            var1.b(var11, var13, var2);
            if(!var27) {
               return;
            }
         }

         var1.b(var5 + (var21 - var23) * 0.5D, var7 + (var21 + var23) * 0.5D, var2);
         var1.b(var11, var13, var2);
      }

   }

   protected void a(eH var1, eI var2, double var3, double var5, double var7, double var9, double var11, double var13) {
   }

   private boolean a(double var1, double var3) {
      switch(this.c()) {
      case 1:
         return var1 > 0.0D || var1 == 0.0D && var3 > 0.0D;
      case 2:
         return var1 < 0.0D || var1 == 0.0D && var3 > 0.0D;
      case 3:
         return var3 < 0.0D || var3 == 0.0D && var1 > 0.0D;
      case 4:
         return var3 > 0.0D || var3 == 0.0D && var1 > 0.0D;
      case 5:
      default:
         if(Math.abs(var1) > Math.abs(var3)) {
            return var1 >= 0.0D;
         }

         return var3 >= 0.0D;
      case 6:
         if(Math.abs(var1) > Math.abs(var3)) {
            return var1 <= 0.0D;
         }

         return var3 <= 0.0D;
      case 7:
         return true;
      case 8:
         return false;
      }
   }
}
