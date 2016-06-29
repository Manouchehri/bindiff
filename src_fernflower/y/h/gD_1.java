package y.h;

import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import y.h.aB;
import y.h.fL;
import y.h.fj;
import y.h.gE;
import y.h.hC;
import y.h.ij;
import y.h.x;
import y.h.y;

public class gD extends aB {
   public gD() {
   }

   public gD(aB var1) {
      super(var1);
   }

   public aB createCopy(aB var1) {
      return new gD(var1);
   }

   public x createBend(double var1, double var3, x var5, int var6) {
      x var7 = new x(this, var1, var3);
      this.reInsertBend(var7, var5, var6);
      return var7;
   }

   public void reInsertBend(x var1, x var2, int var3) {
      label11: {
         if(var3 == 0) {
            this.bends.b(var1, this.bends.d(var2));
            if(!fj.z) {
               break label11;
            }
         }

         this.bends.a(var1, this.bends.d(var2));
      }

      this.setDirty();
   }

   public x insertBend(double var1, double var3) {
      int var5 = this.containsSeg(var1, var3);
      return var5 > 0?this.createBend(var1, var3, (x)this.bends.a(var5 - 1), 1):null;
   }

   public x removeBend(x var1) {
      this.bends.remove(var1);
      this.setDirty();
      return var1;
   }

   protected byte calculatePath(Point2D var1, Point2D var2) {
      boolean var15 = fj.z;
      if(this.bendCount() == 0) {
         return ij.a(this, this.path, var1, var2);
      } else {
         int var3 = this.bendCount() + 2;
         int[] var4 = new int[var3];
         int[] var5 = new int[var3];
         fj var6 = this.getSourceRealizer();
         fj var7 = this.getTargetRealizer();
         fL var8 = this.getSourcePort();
         fL var9 = this.getTargetPort();
         byte var10 = 0;
         var4[var10] = (int)var8.a(var6);
         var5[var10] = (int)var8.b(var6);
         int var16 = var10 + 1;
         y var11 = this.bends();

         while(true) {
            if(var11.f()) {
               x var12 = var11.a();
               var4[var16] = (int)var12.b();
               var5[var16] = (int)var12.c();
               var11.g();
               ++var16;
               if(var15) {
                  break;
               }

               if(!var15) {
                  continue;
               }
            }

            var4[var16] = (int)var9.a(var7);
            var5[var16] = (int)var9.b(var7);
            break;
         }

         gE[] var17 = this.a(var3 - 1, var4);
         gE[] var18 = this.a(var3 - 1, var5);
         this.path.reset();
         this.path.moveTo(var17[0].a(0.0F), var18[0].a(0.0F));
         var16 = 0;

         byte var10000;
         while(true) {
            if(var16 < var17.length) {
               var10000 = 1;
               if(var15) {
                  break;
               }

               int var13 = 1;

               label36: {
                  while(var13 <= 12) {
                     float var14 = (float)var13 / 12.0F;
                     this.path.lineTo(var17[var16].a(var14), var18[var16].a(var14));
                     ++var13;
                     if(var15) {
                        break label36;
                     }

                     if(var15) {
                        break;
                     }
                  }

                  ++var16;
               }

               if(!var15) {
                  continue;
               }
            }

            var10000 = ij.a(this, this.path, this.path = new GeneralPath(1, this.bendCount() + 4), var1, var2);
            break;
         }

         return var10000;
      }
   }

   public int containsSeg(double var1, double var3) {
      boolean var15 = fj.z;
      if(this.bendCount() == 0) {
         return super.containsSeg(var1, var3);
      } else {
         int var7 = 1;
         if(this.isDirty()) {
            this.recalculateFeatures();
         }

         y var8 = this.bends();
         double var9 = var8.a().b();
         double var11 = var8.a().c();
         PathIterator var13 = this.path.getPathIterator((AffineTransform)null);
         if(var13.isDone()) {
            return 0;
         } else {
            float[] var14 = hC.a().c;
            var13.currentSegment(var14);
            var13.next();
            float var5 = var14[0];
            float var6 = var14[1];

            int var10000;
            while(true) {
               if(!var13.isDone()) {
                  var13.currentSegment(var14);
                  double var16;
                  var10000 = (var16 = Line2D.ptSegDist((double)var5, (double)var6, (double)var14[0], (double)var14[1], var1, var3) - 5.0D) == 0.0D?0:(var16 < 0.0D?-1:1);
                  if(var15) {
                     break;
                  }

                  if(var10000 < 0) {
                     return var7;
                  }

                  if(Line2D.ptSegDist((double)var5, (double)var6, (double)var14[0], (double)var14[1], var9, var11) < 5.0D && var8.f()) {
                     ++var7;
                     var8.g();
                     if(var8.f()) {
                        var9 = var8.a().b();
                        var11 = var8.a().c();
                     }
                  }

                  var13.next();
                  var5 = var14[0];
                  var6 = var14[1];
                  if(!var15) {
                     continue;
                  }
               }

               var10000 = 0;
               break;
            }

            return var10000;
         }
      }
   }

   public void write(ObjectOutputStream var1) {
      var1.writeByte(0);
      super.write(var1);
   }

   public void read(ObjectInputStream var1) {
      switch(var1.readByte()) {
      case 0:
         super.read(var1);
         if(!fj.z) {
            return;
         }
      default:
         throw new y.e.a();
      }
   }

   private gE[] a(int var1, int[] var2) {
      boolean var8 = fj.z;
      float[] var3 = new float[var1 + 1];
      float[] var4 = new float[var1 + 1];
      float[] var5 = new float[var1 + 1];
      var3[0] = 0.5F;
      int var6 = 1;

      while(true) {
         if(var6 < var1) {
            var3[var6] = 1.0F / (4.0F - var3[var6 - 1]);
            ++var6;
            if(var8) {
               break;
            }

            if(!var8) {
               continue;
            }
         }

         var3[var1] = 1.0F / (2.0F - var3[var1 - 1]);
         var4[0] = (float)(3 * (var2[1] - var2[0])) * var3[0];
         break;
      }

      var6 = 1;

      while(true) {
         if(var6 < var1) {
            var4[var6] = ((float)(3 * (var2[var6 + 1] - var2[var6 - 1])) - var4[var6 - 1]) * var3[var6];
            ++var6;
            if(var8) {
               break;
            }

            if(!var8) {
               continue;
            }
         }

         var4[var1] = ((float)(3 * (var2[var1] - var2[var1 - 1])) - var4[var1 - 1]) * var3[var1];
         var5[var1] = var4[var1];
         break;
      }

      var6 = var1 - 1;

      while(var6 >= 0) {
         var5[var6] = var4[var6] - var3[var6] * var5[var6 + 1];
         --var6;
         if(var8) {
            break;
         }
      }

      gE[] var7 = new gE[var1];
      var6 = 0;

      gE[] var10000;
      while(true) {
         if(var6 < var1) {
            var10000 = var7;
            if(var8) {
               break;
            }

            var7[var6] = new gE((float)var2[var6], var5[var6], (float)(3 * (var2[var6 + 1] - var2[var6])) - 2.0F * var5[var6] - var5[var6 + 1], (float)(2 * (var2[var6] - var2[var6 + 1])) + var5[var6] + var5[var6 + 1]);
            ++var6;
            if(!var8) {
               continue;
            }
         }

         var10000 = var7;
         break;
      }

      return var10000;
   }
}
