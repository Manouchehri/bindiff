package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.Iterator;
import y.h.C;
import y.h.R;
import y.h.S;
import y.h.T;
import y.h.aB;
import y.h.bu;
import y.h.cg;
import y.h.fj;
import y.h.ft;
import y.h.hC;

public class O implements ft {
   private final R d = new R(this);
   private final R e = new R(this);
   private int g = 10;
   private C f;

   public cg getPaintOrder() {
      return this.d;
   }

   public cg getSloppyPaintOrder() {
      return this.e;
   }

   public boolean isLayeredPainting() {
      return this.d.a();
   }

   public void setLayeredPainting(boolean var1) {
      this.d.a(var1);
      this.e.a(var1);
   }

   public void setNestedEdgeDrawingOrderEnabled(boolean var1) {
      this.d.c(var1);
   }

   public boolean isNestedEdgeDrawingOrderEnabled() {
      return this.d.c();
   }

   public C getBridgeCalculator() {
      return this.f;
   }

   public void setBridgeCalculator(C var1) {
      this.f = var1;
   }

   public void setDrawEdgesFirst(boolean var1) {
      this.d.d(var1);
      this.e.d(var1);
   }

   public boolean getDrawEdgesFirst() {
      return this.d.d();
   }

   public void setDrawSelectionOnTop(boolean var1) {
      this.d.e(var1);
      this.e.e(var1);
   }

   public boolean isDrawSelectionOnTop() {
      return this.d.e();
   }

   public void setClipEnlargementValue(int var1) {
      this.g = var1;
   }

   public int getClipEnlargementValue() {
      return this.g;
   }

   public void setHierarchicSloppyPaintOrderEnabled(boolean var1) {
      this.e.b(var1);
   }

   public boolean isHierarchicSloppyPaintOrderEnabled() {
      return this.e.b();
   }

   public void paint(Graphics2D var1, bu var2) {
      Object var3 = null;
      Rectangle var4 = var1.getClipBounds();
      if(var4 == null) {
         var4 = var2.a();
      }

      var4.x -= this.g;
      var4.y -= this.g;
      var4.width += 2 * this.g;
      var4.height += 2 * this.g;
      C var5 = this.f;
      if(var5 != null) {
         this.prepareBridgeCalculator(var5, var2, var4);
         var3 = var1.getRenderingHint(S.a);
         var1.setRenderingHint(S.a, S.a(var2, var5));
      }

      this.b(var2, var1, var4, false);
      if(var5 != null) {
         var1.setRenderingHint(S.a, var3);
      }

   }

   private void b(bu var1, Graphics2D var2, Rectangle var3, boolean var4) {
      boolean var12 = fj.z;
      if(!this.isLayeredPainting()) {
         Iterator var6;
         Object var7;
         aB var8;
         fj var15;
         if(var4) {
            var6 = this.e.a(var1, 3);

            while(true) {
               while(true) {
                  if(!var6.hasNext()) {
                     return;
                  }

                  var7 = var6.next();
                  if(!(var7 instanceof y.c.d)) {
                     break;
                  }

                  var8 = var1.i((y.c.d)var7);
                  if(this.intersects((aB)var8, var3)) {
                     this.paintSloppy(var2, var8);
                     if(var12) {
                        break;
                     }
                  }
               }

               if(var7 instanceof y.c.q) {
                  var15 = var1.t((y.c.q)var7);
                  if(this.intersects((fj)var15, var3)) {
                     this.paintSloppy(var2, var15);
                     if(var12) {
                        break;
                     }
                  }
               }
            }
         }

         var6 = this.d.a(var1, 3);

         while(true) {
            while(true) {
               if(!var6.hasNext()) {
                  return;
               }

               var7 = var6.next();
               if(!(var7 instanceof y.c.d)) {
                  break;
               }

               var8 = var1.i((y.c.d)var7);
               if(this.intersects((aB)var8, var3)) {
                  this.paint(var2, var8);
                  if(var12) {
                     break;
                  }
               }
            }

            if(var7 instanceof y.c.q) {
               var15 = var1.t((y.c.q)var7);
               if(this.intersects((fj)var15, var3)) {
                  this.paint(var2, var15);
                  if(var12) {
                     break;
                  }
               }
            }
         }
      }

      y.c.d var9;
      aB var10;
      int var11;
      int var13;
      Iterator var14;
      Object var16;
      int var10000;
      y.c.q var17;
      fj var18;
      if(var4) {
         var13 = -1;
         var14 = this.e.a(var1, 3);

         label122: {
            while(var14.hasNext()) {
               var16 = var14.next();
               if(var16 instanceof y.c.d) {
                  var9 = (y.c.d)var16;
                  var10 = var1.i(var9);
                  if(!this.intersects((aB)var10, var3)) {
                     continue;
                  }

                  var11 = this.getLayer(var1, var9);
                  if(var11 != var13) {
                     if(var13 > -1) {
                        this.endLayerPainting(var2, var13, var4);
                     }

                     this.beginLayerPainting(var2, var11, var4);
                  }

                  this.paintSloppyLayered(var2, var11, var10);
                  var13 = var11;
                  if(!var12) {
                     continue;
                  }
               }

               if(var16 instanceof y.c.q) {
                  var17 = (y.c.q)var16;
                  var18 = var1.t(var17);
                  var10000 = this.intersects((fj)var18, var3);
                  if(var12) {
                     break label122;
                  }

                  if(var10000 != 0) {
                     var11 = this.getLayer(var1, var17);
                     if(var11 != var13) {
                        if(var13 > -1) {
                           this.endLayerPainting(var2, var13, var4);
                        }

                        this.beginLayerPainting(var2, var11, var4);
                     }

                     this.paintSloppyLayered(var2, var11, var18);
                     var13 = var11;
                     if(var12) {
                        break;
                     }
                  }
               }
            }

            var10000 = var13;
         }

         if(var10000 <= -1) {
            return;
         }

         this.endLayerPainting(var2, var13, var4);
         if(!var12) {
            return;
         }
      }

      var13 = -1;
      var14 = this.d.a(var1, 3);

      label96: {
         while(var14.hasNext()) {
            var16 = var14.next();
            if(var16 instanceof y.c.d) {
               var9 = (y.c.d)var16;
               var10 = var1.i(var9);
               if(!this.intersects((aB)var10, var3)) {
                  continue;
               }

               var11 = this.getLayer(var1, var9);
               if(var11 != var13) {
                  if(var13 > -1) {
                     this.endLayerPainting(var2, var13, var4);
                  }

                  this.beginLayerPainting(var2, var11, var4);
               }

               this.paintLayered(var2, var11, var10);
               var13 = var11;
               if(!var12) {
                  continue;
               }
            }

            if(var16 instanceof y.c.q) {
               var17 = (y.c.q)var16;
               var18 = var1.t(var17);
               var10000 = this.intersects((fj)var18, var3);
               if(var12) {
                  break label96;
               }

               if(var10000 != 0) {
                  var11 = this.getLayer(var1, var17);
                  if(var11 != var13) {
                     if(var13 > -1) {
                        this.endLayerPainting(var2, var13, var4);
                     }

                     this.beginLayerPainting(var2, var11, var4);
                  }

                  this.paintLayered(var2, var11, var18);
                  var13 = var11;
                  if(var12) {
                     break;
                  }
               }
            }
         }

         var10000 = var13;
      }

      if(var10000 > -1) {
         this.endLayerPainting(var2, var13, var4);
      }

   }

   protected void beginLayerPainting(Graphics2D var1, int var2, boolean var3) {
   }

   protected void endLayerPainting(Graphics2D var1, int var2, boolean var3) {
   }

   protected void paintLayered(Graphics2D var1, int var2, fj var3) {
      this.paint(var1, var3);
   }

   protected void paintLayered(Graphics2D var1, int var2, aB var3) {
      this.paint(var1, var3);
   }

   protected void paintSloppyLayered(Graphics2D var1, int var2, fj var3) {
      this.paintSloppy(var1, var3);
   }

   protected void paintSloppyLayered(Graphics2D var1, int var2, aB var3) {
      this.paintSloppy(var1, var3);
   }

   protected int getLayer(bu var1, y.c.d var2) {
      return Math.max(this.getLayer(var1, var2.c()), this.getLayer(var1, var2.d()));
   }

   protected int getLayer(bu var1, y.c.q var2) {
      boolean var6 = fj.z;
      y.h.a.v var3 = var1.C();
      int var4 = 0;
      if(var3 == null) {
         return var4;
      } else {
         while(var2 != null) {
            y.c.q var5 = var3.n(var2);
            if(var5 != null && var5.e() != var2.e()) {
               return var4;
            }

            var2 = var5;
            ++var4;
            if(var6) {
               break;
            }
         }

         return var4;
      }
   }

   protected void prepareBridgeCalculator(C var1, bu var2, Rectangle2D var3) {
      boolean var7 = fj.z;
      var1.a();
      var1.a(var3.getMinX() - (double)this.g, var3.getMinY() - (double)this.g, var3.getMaxX() + (double)this.g, var3.getMaxY() + (double)this.g);
      if(var1.b() != 0) {
         y.c.e var4 = var2.p();

         while(var4.f()) {
            y.c.d var5 = var4.a();
            aB var6 = var2.i(var5);
            if(this.intersects(var6, var3)) {
               var6.registerObstacles(var1);
            }

            var4.g();
            if(var7) {
               break;
            }
         }
      }

   }

   public static C getBridgeCalculator(aB var0, Graphics2D var1) {
      if(var0 != null && var0.getEdge() != null) {
         T var2 = (T)var1.getRenderingHint(S.a);
         if(var2 != null && var2.a() == var0.getEdge().a()) {
            return var2.b();
         }
      }

      return null;
   }

   public void setSloppyNestedEdgeDrawingOrderEnabled(boolean var1) {
      this.e.c(var1);
   }

   public boolean isSloppyNestedEdgeDrawingOrderEnabled() {
      return this.e.c();
   }

   protected boolean intersects(fj var1, Rectangle2D var2) {
      Double var3 = hC.a().j;
      var3.width = var3.height = -1.0D;
      var1.calcUnionRect(var3);
      return var3.intersects(var2.getX(), var2.getY(), var2.getWidth(), var2.getHeight());
   }

   protected boolean intersects(aB var1, Rectangle2D var2) {
      return var1.intersects(var2);
   }

   public void paintSloppy(Graphics2D var1, bu var2) {
      Rectangle var3 = var1.getClipBounds();
      if(var3 == null) {
         var3 = var2.a();
      }

      var3.x -= this.g;
      var3.y -= this.g;
      var3.width += 2 * this.g;
      var3.height += 2 * this.g;
      this.b(var2, var1, var3, true);
   }

   protected void paint(Graphics2D var1, fj var2) {
      var2.paint(var1);
   }

   protected void paint(Graphics2D var1, aB var2) {
      var2.paint(var1);
   }

   protected void paintSloppy(Graphics2D var1, fj var2) {
      var2.paintSloppy(var1);
   }

   protected void paintSloppy(Graphics2D var1, aB var2) {
      var2.paintSloppy(var1);
   }
}
