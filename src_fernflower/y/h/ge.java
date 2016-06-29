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

public class ge extends aB {
   private final GeneralPath a = new GeneralPath();
   private double b = 0.1D;

   public ge() {
   }

   public ge(aB var1) {
      super(var1);
      if(var1 instanceof ge) {
         this.a(((ge)var1).a());
      }

   }

   public aB createCopy(aB var1) {
      return new ge(var1);
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
      y var14 = this.bends();

      int var10000;
      while(true) {
         double var9;
         double var11;
         if(var14.f()) {
            x var15 = var14.a();
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
            var14.g();
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
      boolean var19 = fj.z;
      if(this.bendCount() != 0 && this.b < 1.0D) {
         int var3 = this.bendCount();
         float var4 = this.b == 0.0D?0.0F:(float)(1.0D - this.b) * 0.5F;
         float var5 = 1.0F - var4;
         this.path.reset();
         this.a.reset();
         fj var6 = this.getSourceRealizer();
         fL var7 = this.getSourcePort();
         float var8;
         float var9;
         this.a.moveTo(var8 = (float)var7.a(var6), var9 = (float)var7.b(var6));
         byte var12 = 0;
         float var10 = var8;
         float var11 = var9;
         y var13 = this.bends();
         x var14 = var13.a();
         var8 = (float)var14.b();
         var9 = (float)var14.c();
         var13.g();
         int var20 = var12 + 1;

         float var15;
         float var16;
         float var10000;
         float var17;
         while(true) {
            if(var20 < var3) {
               var14 = var13.a();
               var15 = (float)var14.b();
               var16 = (float)var14.c();
               var10000 = var4;
               if(var19) {
                  break;
               }

               label35: {
                  if(var4 > 0.0F) {
                     var17 = var5 * var8 + var10 * var4;
                     float var18 = var5 * var9 + var11 * var4;
                     this.a.lineTo(var17, var18);
                     var17 = var4 * var15 + var8 * var5;
                     var18 = var4 * var16 + var9 * var5;
                     this.a.quadTo(var8, var9, var17, var18);
                     var10 = var8;
                     var11 = var9;
                     var8 = var15;
                     var9 = var16;
                     if(!var19) {
                        break label35;
                     }
                  }

                  this.a.quadTo(var8, var9, (var8 + var15) * 0.5F, (var9 + var16) * 0.5F);
                  var8 = var15;
                  var9 = var16;
               }

               var13.g();
               ++var20;
               if(!var19) {
                  continue;
               }
            }

            var6 = this.getTargetRealizer();
            var7 = this.getTargetPort();
            var10000 = (float)var7.a(var6);
            break;
         }

         label27: {
            float var21 = var10000;
            var15 = (float)var7.b(var6);
            if(var4 > 0.0F) {
               var16 = var5 * var8 + var10 * var4;
               var17 = var5 * var9 + var11 * var4;
               this.a.lineTo(var16, var17);
               var16 = var4 * var21 + var8 * var5;
               var17 = var4 * var15 + var9 * var5;
               this.a.quadTo(var8, var9, var16, var17);
               this.a.lineTo(var21, var15);
               if(!var19) {
                  break label27;
               }
            }

            this.a.quadTo(var8, var9, var21, var15);
         }

         this.path.append(this.a.getPathIterator((AffineTransform)null, 0.5D), false);
         return ij.a(this, this.path, this.path = new GeneralPath(1, this.bendCount() + 4), var1, var2);
      } else {
         return ij.a(this, this.path, var1, var2);
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

   protected void paintHighlightedBends(Graphics2D var1) {
      super.c(var1);
      super.paintHighlightedBends(var1);
   }

   public void write(ObjectOutputStream var1) {
      var1.writeByte(0);
      super.write(var1);
      var1.writeDouble(this.a());
   }

   public void read(ObjectInputStream var1) {
      switch(var1.readByte()) {
      case 0:
         super.read(var1);
         this.a(var1.readDouble());
         if(!fj.z) {
            return;
         }
      default:
         throw new y.e.a();
      }
   }

   public double a() {
      return this.b;
   }

   public void a(double var1) {
      if(var1 >= 0.0D && var1 <= 1.0D) {
         if(this.b != var1) {
            this.b = var1;
            this.setDirty();
         }

      } else {
         throw new IllegalArgumentException();
      }
   }
}
