package y.h;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import y.h.aB;
import y.h.fL;
import y.h.fj;
import y.h.ij;
import y.h.x;
import y.h.y;

public class B extends aB {
   private final GeneralPath a = new GeneralPath();

   public B() {
   }

   public B(aB var1) {
      super(var1);
   }

   public aB createCopy(aB var1) {
      return new B(var1);
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
      int var5 = this.a(var1, var3);
      return var5 >= 0?this.createBend(var1, var3, (x)this.bends.a(var5), 1):null;
   }

   public boolean contains(double var1, double var3) {
      return !this.isSelected()?super.contains(var1, var3):this.a(var1, var3) >= 0;
   }

   public x removeBend(x var1) {
      this.bends.remove(var1);
      this.setDirty();
      return var1;
   }

   private int a(double var1, double var3) {
      boolean var16 = fj.z;
      double var5 = this.getSourcePort().a(this.getSourceRealizer());
      double var7 = this.getSourcePort().b(this.getSourceRealizer());
      int var13 = 0;
      y.c.p var14 = this.bends.k();

      int var10000;
      while(true) {
         double var9;
         double var11;
         if(var14 != null) {
            x var15 = (x)var14.c();
            var9 = var15.b();
            var11 = var15.c();
            double var17;
            var10000 = (var17 = Line2D.ptSegDist(var5, var7, var9, var11, var1, var3) - 5.0D) == 0.0D?0:(var17 < 0.0D?-1:1);
            if(var16) {
               break;
            }

            if(var10000 < 0) {
               return var13;
            }

            var5 = var9;
            var7 = var11;
            var14 = var14.a();
            ++var13;
            if(!var16) {
               continue;
            }
         }

         var9 = this.getTargetPort().a(this.getTargetRealizer());
         var11 = this.getTargetPort().b(this.getTargetRealizer());
         double var18;
         var10000 = (var18 = Line2D.ptSegDist(var5, var7, var9, var11, var1, var3) - 5.0D) == 0.0D?0:(var18 < 0.0D?-1:1);
         break;
      }

      return var10000 < 0?var13:-1;
   }

   protected byte calculatePath(Point2D var1, Point2D var2) {
      boolean var11 = fj.z;
      if(this.bendCount() == 0) {
         return ij.a(this, this.path, var1, var2);
      } else {
         int var3;
         label50: {
            var3 = 2;
            if((this.bendCount() & 1) == 1) {
               var3 += 3 * this.bendCount() + 1 >> 1;
               if(!var11) {
                  break label50;
               }
            }

            var3 += 3 * (this.bendCount() >> 1) - 1;
         }

         float[] var4 = new float[var3];
         float[] var5 = new float[var3];
         fj var6 = this.getSourceRealizer();
         fL var7 = this.getSourcePort();
         var4[0] = (float)var7.a(var6);
         var5[0] = (float)var7.b(var6);
         int var8 = 1;
         y var9 = this.bends();

         int var10000;
         while(true) {
            if(var9.f()) {
               x var10 = var9.a();
               var10000 = var8 % 3;
               if(var11) {
                  break;
               }

               if(var10000 == 0) {
                  var4[var8] = (float)(var10.b() + (double)var4[var8 - 1]) / 2.0F;
                  var5[var8] = (float)(var10.c() + (double)var5[var8 - 1]) / 2.0F;
                  ++var8;
               }

               var4[var8] = (float)var10.b();
               var5[var8] = (float)var10.c();
               var9.g();
               ++var8;
               if(!var11) {
                  continue;
               }
            }

            var10000 = var8 % 3;
            break;
         }

         if(var10000 == 2) {
            var4[var8] = var4[var8 - 1];
            var5[var8] = var5[var8 - 1];
         }

         var6 = this.getTargetRealizer();
         var7 = this.getTargetPort();
         var4[var3 - 1] = (float)var7.a(var6);
         var5[var3 - 1] = (float)var7.b(var6);
         this.path.reset();
         this.a.reset();
         this.a.moveTo(var4[0], var5[0]);
         int var12 = 0;

         while(true) {
            if(var12 < var3 - 3) {
               this.a.curveTo(var4[var12 + 1], var5[var12 + 1], var4[var12 + 2], var5[var12 + 2], var4[var12 + 3], var5[var12 + 3]);
               var12 += 3;
               if(var11) {
                  break;
               }

               if(!var11) {
                  continue;
               }
            }

            this.path.append(this.a.getPathIterator((AffineTransform)null, 0.75D), false);
            break;
         }

         return ij.a(this, this.path, this.path = new GeneralPath(1, this.bendCount() + 4), var1, var2);
      }
   }

   public void calcUnionRect(Rectangle2D var1) {
      boolean var4 = fj.z;
      super.calcUnionRect(var1);
      y.c.p var2;
      x var3;
      if(this.isSelected()) {
         var2 = this.bends.k();

         while(var2 != null) {
            var3 = (x)var2.c();
            var1.add(var3.b(), var3.c());
            var2 = var2.a();
            if(var4) {
               return;
            }

            if(var4) {
               break;
            }
         }

         fj var5 = this.getSourceRealizer();
         fL var6 = this.getSourcePort();
         var1.add(var6.a(var5), var6.b(var5));
         var5 = this.getTargetRealizer();
         var6 = this.getTargetPort();
         var1.add(var6.a(var5), var6.b(var5));
         if(!var4) {
            return;
         }
      }

      var2 = this.bends.k();

      while(var2 != null) {
         var3 = (x)var2.c();
         if(var3.d()) {
            var1.add(var3.b(), var3.c());
         }

         var2 = var2.a();
         if(var4) {
            break;
         }
      }

   }

   public boolean intersects(Rectangle2D var1) {
      boolean var5 = fj.z;
      boolean var2 = super.intersects(var1);
      if(var2) {
         return true;
      } else {
         boolean var10000;
         y.c.p var3;
         x var4;
         if(this.isSelected()) {
            var3 = this.bends.k();

            while(var3 != null) {
               var4 = (x)var3.c();
               var10000 = var1.contains(var4.b(), var4.c());
               if(var5) {
                  return var10000;
               }

               if(var10000) {
                  return true;
               }

               var3 = var3.a();
               if(var5) {
                  break;
               }
            }

            fj var6 = this.getSourceRealizer();
            fL var7 = this.getSourcePort();
            if(var1.contains(var7.a(var6), var7.b(var6))) {
               return true;
            }

            var6 = this.getTargetRealizer();
            var7 = this.getTargetPort();
            if(var1.contains(var7.a(var6), var7.b(var6))) {
               return true;
            }
         } else {
            var3 = this.bends.k();

            while(var3 != null) {
               var4 = (x)var3.c();
               var10000 = var4.d();
               if(var5) {
                  return var10000;
               }

               if(var10000 && var1.contains(var4.b(), var4.c())) {
                  return true;
               }

               var3 = var3.a();
               if(var5) {
                  break;
               }
            }
         }

         var10000 = false;
         return var10000;
      }
   }

   protected void paintHighlightedBends(Graphics2D var1) {
      super.c(var1);
      super.paintHighlightedBends(var1);
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
}
