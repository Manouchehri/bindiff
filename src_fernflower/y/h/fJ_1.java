package y.h;

import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import y.h.C;
import y.h.aA;
import y.h.aB;
import y.h.fL;
import y.h.fj;
import y.h.ij;
import y.h.x;

public class fJ extends aB {
   private boolean ic;

   public fJ() {
      this.ic = false;
   }

   public fJ(aB var1) {
      super(var1);
      if(var1 instanceof fJ) {
         this.ic = ((fJ)var1).getSmoothedBends();
         if(!fj.z) {
            return;
         }
      }

      this.ic = false;
   }

   public aB createCopy(aB var1) {
      fJ var2 = new fJ(var1);
      return var2;
   }

   public void setSmoothedBends(boolean var1) {
      if(var1 != this.ic) {
         this.ic = var1;
         this.setDirty();
      }

   }

   public boolean getSmoothedBends() {
      return this.ic;
   }

   public x createBend(double var1, double var3, x var5, int var6) {
      x var7 = new x(this, var1, var3);
      this.reInsertBend(var7, var5, var6);
      return var7;
   }

   public void reInsertBend(x var1, x var2, int var3) {
      label28: {
         boolean var4 = fj.z;
         if(var3 == 0) {
            if(this.bends.size() > 0 && var2 == this.bends.i()) {
               this.bends.b(var1, this.bends.l());
               if(!var4) {
                  break label28;
               }
            }

            this.bends.b(var1, this.bends.d(var2));
            if(!var4) {
               break label28;
            }
         }

         if(this.bends.size() > 0 && var2 == this.bends.f()) {
            this.bends.a(var1, this.bends.k());
            if(!var4) {
               break label28;
            }
         }

         this.bends.a(var1, this.bends.d(var2));
      }

      this.setDirty();
   }

   public x insertBend(double var1, double var3) {
      int var5 = this.containsSeg(var1, var3);
      return var5 > 0 && var5 <= this.bends.size()?this.createBend(var1, var3, (x)this.bends.a(var5 - 1), 1):this.appendBend(var1, var3);
   }

   public x removeBend(x var1) {
      this.bends.remove(var1);
      this.setDirty();
      return var1;
   }

   public int containsSeg(double var1, double var3) {
      boolean var17 = fj.z;
      if(this.getEdge().e() && this.bendCount() < 2) {
         return super.containsSeg(var1, var3);
      } else {
         if(this.isDirty()) {
            this.recalculateFeatures();
         }

         Point2D var13 = this.getSourceIntersection();
         double var5 = var13.getX();
         double var7 = var13.getY();
         int var14 = 1;
         y.c.p var15 = this.bends.k();

         int var10000;
         while(true) {
            double var9;
            double var11;
            if(var15 != null) {
               x var16 = (x)var15.c();
               var9 = var16.b();
               var11 = var16.c();
               double var18;
               var10000 = (var18 = Line2D.ptSegDistSq(var5, var7, var9, var11, var1, var3) - 25.0D) == 0.0D?0:(var18 < 0.0D?-1:1);
               if(var17) {
                  break;
               }

               if(var10000 < 0) {
                  return var14;
               }

               var5 = var9;
               var7 = var11;
               var15 = var15.a();
               ++var14;
               if(!var17) {
                  continue;
               }
            }

            var13 = this.getTargetIntersection();
            var9 = var13.getX();
            var11 = var13.getY();
            double var19;
            var10000 = (var19 = Line2D.ptSegDistSq(var5, var7, var9, var11, var1, var3) - 25.0D) == 0.0D?0:(var19 < 0.0D?-1:1);
            break;
         }

         return var10000 < 0?var14:0;
      }
   }

   Float b(Float var1) {
      boolean var16 = fj.z;
      if(this.getEdge().e() && this.bendCount() < 2) {
         var1 = super.b(var1);
         if(this.bendCount() == 1) {
            x var17 = this.bends.a();
            var1.add(var17.b(), var17.c());
         }

         return var1;
      } else {
         label55: {
            Point2D var2 = this.getTargetIntersection();
            if(var1 != null) {
               var1.setFrame(var2.getX(), var2.getY(), 1.0D, 1.0D);
               if(!var16) {
                  break label55;
               }
            }

            var1 = new Float((float)var2.getX(), (float)var2.getY(), 1.0F, 1.0F);
         }

         y.c.p var3 = this.bends.k();

         while(var3 != null) {
            x var4 = (x)var3.c();
            var1.add(var4.b(), var4.c());
            var3 = var3.a();
            if(var16) {
               break;
            }
         }

         fL var18 = this.getSourcePort();
         fL var19 = this.getTargetPort();
         var18.a((Rectangle2D)var1, this.getSourceRealizer());
         var19.a((Rectangle2D)var1, this.getTargetRealizer());
         double var5 = var1.getX();
         double var7 = var5 + var1.getWidth();
         double var9 = var1.getY();
         double var11 = var9 + var1.getHeight();
         int var13 = this.labelCount() - 1;

         while(true) {
            if(var13 >= 0) {
               aA var14 = this.getLabel(var13);
               if(var16) {
                  break;
               }

               if(var14.isVisible() && (var14.getText().length() != 0 || var14.getIcon() != null)) {
                  y.d.y var15 = var14.getBox();
                  var7 = Math.max(var15.c + var15.a, var7);
                  var5 = Math.min(var15.c, var5);
                  var11 = Math.max(var15.d + var15.b, var11);
                  var9 = Math.min(var15.d, var9);
               }

               --var13;
               if(!var16) {
                  continue;
               }
            }

            var1.setFrame(var5, var9, var7 - var5, var11 - var9);
            break;
         }

         return var1;
      }
   }

   public boolean pathIntersects(Rectangle2D var1, boolean var2) {
      boolean var11 = fj.z;
      if(!this.isDirty() && this.nb != null && !this.nb.intersects(var1)) {
         return false;
      } else {
         if(this.bends.size() > 0) {
            y.c.p var3 = this.bends.k();

            while(var3 != null) {
               x var4 = (x)var3.c();
               if(var1.contains(var4.b(), var4.c())) {
                  return true;
               }

               var3 = var3.a();
               if(var11) {
                  break;
               }
            }
         }

         Point2D var12 = this.getTargetIntersection();
         if(var1.contains(var12)) {
            return true;
         } else {
            Point2D var13 = this.getSourceIntersection();
            if(var1.contains(var13)) {
               return true;
            } else {
               if(var2) {
                  int var5 = this.labelCount() - 1;

                  while(var5 >= 0) {
                     aA var6 = this.getLabel(var5);
                     if(var6.isVisible() && (var6.getText().length() != 0 || var6.getIcon() != null)) {
                        y.d.y var7 = var6.getBox();
                        if(var1.intersects(var7.c, var7.d, var7.a, var7.b)) {
                           return true;
                        }
                     }

                     --var5;
                     if(var11) {
                        break;
                     }
                  }
               }

               double var14 = var13.getX();
               double var15 = var13.getY();
               boolean var10000;
               if(this.bends.size() > 0) {
                  y.c.p var9 = this.bends.k();

                  while(var9 != null) {
                     x var10 = (x)var9.c();
                     var10000 = var1.intersectsLine(var14, var15, var10.b(), var10.c());
                     if(var11) {
                        return var10000;
                     }

                     if(var10000) {
                        return true;
                     }

                     var14 = var10.b();
                     var15 = var10.c();
                     var9 = var9.a();
                     if(var11) {
                        break;
                     }
                  }
               }

               var10000 = var1.intersectsLine(var14, var15, var12.getX(), var12.getY());
               return var10000;
            }
         }
      }
   }

   protected byte calculatePath(Point2D var1, Point2D var2) {
      boolean var3 = false;
      if(this.getEdge().e()) {
         if(this.bendCount() == 0) {
            fj var4 = this.getSourceRealizer();
            this.appendBend(this.getSourcePort().a(var4), this.getSourcePort().b(var4) - 10.0D - var4.getHeight());
            var3 = true;
            if(!fj.z) {
               return var3?ij.b(this, this.path, var1, var2):(this.ic?ij.c(this, this.path, var1, var2):ij.a(this, this.path, var1, var2));
            }
         }

         if(this.bendCount() == 1) {
            var3 = true;
         }
      }

      return var3?ij.b(this, this.path, var1, var2):(this.ic?ij.c(this, this.path, var1, var2):ij.a(this, this.path, var1, var2));
   }

   public void registerObstacles(C var1) {
      var1.b(this.getPath().getPathIterator((AffineTransform)null));
   }

   public void write(ObjectOutputStream var1) {
      var1.writeByte(1);
      super.write(var1);
      var1.writeBoolean(this.ic);
   }

   public void read(ObjectInputStream var1) {
      boolean var2 = fj.z;
      switch(var1.readByte()) {
      case 0:
         super.read(var1);
         this.ic = false;
         if(!var2) {
            break;
         }
      case 1:
         super.read(var1);
         this.ic = var1.readBoolean();
         if(var2) {
            throw new y.e.a();
         }
         break;
      default:
         throw new y.e.a();
      }

   }
}
