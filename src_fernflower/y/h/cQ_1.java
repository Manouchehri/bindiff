package y.h;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import y.h.bw;
import y.h.cR;
import y.h.cS;
import y.h.ch;
import y.h.dr;
import y.h.fj;

public class cQ implements MouseWheelListener {
   private boolean g = false;
   private boolean j = true;
   private double e = Double.MIN_VALUE;
   private double c = Double.MAX_VALUE;
   private boolean f = false;
   private boolean d = false;
   private Color h;
   protected MouseWheelEvent lastMouseWheelEvent;
   private cS k;
   private boolean b = false;
   private y.b.e i;

   public cQ() {
      this.setZoomIndicatorColor(new Color(60, 60, 60));
   }

   public void addToCanvas(ch var1) {
      var1.getCanvasComponent().addMouseWheelListener(this);
   }

   public void removeFromCanvas(ch var1) {
      var1.getCanvasComponent().removeMouseWheelListener(this);
   }

   public void setLimitMinimumZoomByContentSize(boolean var1) {
      this.d = var1;
   }

   public boolean isLimitMinimumZoomByContentSize() {
      return this.d;
   }

   public void mouseWheelMoved(MouseWheelEvent var1) {
      boolean var29 = fj.z;
      this.lastMouseWheelEvent = var1;
      Object var2 = var1.getSource();
      if(var2 instanceof bw) {
         bw var3;
         ch var4;
         double var5;
         double var7;
         double var9;
         int var11;
         label39: {
            var3 = (bw)var2;
            var4 = (ch)var3.getParent();
            var5 = var3.c((double)var1.getX());
            var7 = var3.d((double)var1.getY());
            var9 = var3.h();
            var11 = 0;
            if(var1.getScrollType() == 1) {
               var11 = var1.getWheelRotation();
               if(!var29) {
                  break label39;
               }
            }

            if(var1.getScrollType() == 0) {
               var11 = var1.getUnitsToScroll();
            }
         }

         if(var11 != 0) {
            Point2D var12 = var3.g();
            double var13 = this.calcZoom(var9, var11);
            var13 = Math.min(var13, this.getMaximumZoom());
            var13 = Math.max(var13, this.getMinimumZoom());
            double var17;
            if(this.isLimitMinimumZoomByContentSize()) {
               Rectangle var15 = var4.getGraph2D().a();
               Dimension var16 = var4.getViewSize();
               var17 = (double)var15.width * var13;
               double var19 = (double)var15.height * var13;
               double var21 = (double)Math.max(10, var16.width - 10);
               double var23 = (double)Math.max(10, var16.height - 10);
               if(var11 > 0 && var21 > var17 && var23 > var19) {
                  double var25 = var21 / (double)var15.width;
                  double var27 = var23 / (double)var15.height;
                  var13 = Math.min(var25, var27);
               }
            }

            if(var13 != var9) {
               label31: {
                  var4.setZoom(var13);
                  if(this.isCenterZoomEvent(var1)) {
                     var4.setCenter(var12.getX(), var12.getY());
                     if(!var29) {
                        break label31;
                     }
                  }

                  double var30 = var3.c((double)var1.getX());
                  var17 = var3.d((double)var1.getY());
                  var5 = var12.getX() + var5 - var30;
                  var7 = var12.getY() + var7 - var17;
                  var4.setCenter(var5, var7);
               }

               this.adjustWorldRect(var4);
               var4.updateView();
               if(this.isZoomIndicatorShowing()) {
                  this.b((double)var11, var9, var13);
               }
            }
         }
      }

   }

   protected double calcZoom(double var1, int var3) {
      if(var3 == 0) {
         return var1;
      } else {
         if(this.g) {
            var3 *= -1;
         }

         return var3 > 0?var1 / 1.25D:var1 * 1.25D;
      }
   }

   protected void adjustWorldRect(ch var1) {
      Rectangle var2 = var1.getGraph2D().a();
      var1.setWorldRect(var2.x - 20, var2.y - 20, var2.width + 40, var2.height + 40);
   }

   protected boolean isCenterZoomEvent(MouseWheelEvent var1) {
      return this.isCenterZooming() && (var1.getModifiers() & 2) == 0;
   }

   public boolean isCenterZooming() {
      return this.j;
   }

   public void setCenterZooming(boolean var1) {
      this.j = var1;
   }

   public double getMaximumZoom() {
      return this.c;
   }

   public void setMaximumZoom(double var1) {
      this.c = var1;
   }

   public double getMinimumZoom() {
      return this.e;
   }

   public void setMinimumZoom(double var1) {
      this.e = var1;
   }

   public boolean isDownInZooming() {
      return this.g;
   }

   public void setDownInZooming(boolean var1) {
      this.g = var1;
   }

   void b(double var1, double var3, double var5) {
      if(this.lastMouseWheelEvent != null && this.lastMouseWheelEvent.getSource() instanceof bw) {
         ch var7 = (ch)((bw)this.lastMouseWheelEvent.getSource()).getParent();
         if(this.k == null) {
            this.k = new cS(this, var7, true);
            this.i = new y.b.e(false);
            this.i.a((y.b.c)(new cR(this)));
            this.i.a((y.b.c)var7);
         }

         if(!this.b) {
            this.k.d = var1 > 0.0D;
            this.k.a = (double)this.lastMouseWheelEvent.getX();
            this.k.b = (double)this.lastMouseWheelEvent.getY();
            this.i.a((y.b.d)this.k);
         }
      }

   }

   public void setZoomIndicatorShowing(boolean var1) {
      this.f = var1;
   }

   public boolean isZoomIndicatorShowing() {
      return this.f;
   }

   protected void paintZoomIndicator(Graphics2D var1, int var2, int var3, int var4, int var5, double var6, MouseWheelEvent var8) {
      int var9 = (int)(255.0D * (1.0D - 0.8D * var6));
      Color var10 = new Color(this.getZoomIndicatorColor().getRed(), this.getZoomIndicatorColor().getGreen(), this.getZoomIndicatorColor().getBlue(), var9);
      var1.setStroke(dr.b);
      var1.setColor(var10);
      byte var11 = 15;
      GeneralPath var12;
      AffineTransform var13;
      if(this.lastMouseWheelEvent.getWheelRotation() < 0) {
         var12 = new GeneralPath(0, 5);
         var12.moveTo((float)var2, (float)(var3 + var11));
         var12.curveTo((float)var2, (float)var3, (float)var2, (float)var3, (float)(var2 + var11), (float)var3);
         var1.draw(var12);
         var13 = AffineTransform.getScaleInstance(-1.0D, 1.0D);
         var13.translate((double)(-2 * var2 - var4), 1.0D);
         var1.draw(var13.createTransformedShape(var12));
         var13 = AffineTransform.getScaleInstance(1.0D, -1.0D);
         var13.translate(1.0D, (double)(-2 * var3 - var5));
         var1.draw(var13.createTransformedShape(var12));
         var13 = AffineTransform.getScaleInstance(-1.0D, -1.0D);
         var13.translate((double)(-2 * var2 - var4), (double)(-2 * var3 - var5));
         var1.draw(var13.createTransformedShape(var12));
         if(!fj.z) {
            return;
         }
      }

      var12 = new GeneralPath(0, 5);
      var12.moveTo((float)var2, (float)(var3 + var11));
      var12.curveTo((float)(var2 + var11), (float)(var3 + var11), (float)(var2 + var11), (float)(var3 + var11), (float)(var2 + var11), (float)var3);
      var1.draw(var12);
      var13 = AffineTransform.getScaleInstance(-1.0D, 1.0D);
      var13.translate((double)(-2 * var2 - var4), 1.0D);
      var1.draw(var13.createTransformedShape(var12));
      var13 = AffineTransform.getScaleInstance(1.0D, -1.0D);
      var13.translate(1.0D, (double)(-2 * var3 - var5));
      var1.draw(var13.createTransformedShape(var12));
      var13 = AffineTransform.getScaleInstance(-1.0D, -1.0D);
      var13.translate((double)(-2 * var2 - var4), (double)(-2 * var3 - var5));
      var1.draw(var13.createTransformedShape(var12));
   }

   public void setZoomIndicatorColor(Color var1) {
      this.h = var1;
   }

   public Color getZoomIndicatorColor() {
      return this.h;
   }

   static boolean access$002(cQ var0, boolean var1) {
      return var0.b = var1;
   }

   static cS access$202(cQ var0, cS var1) {
      return var0.k = var1;
   }
}
