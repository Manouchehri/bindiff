package y.h;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Point2D;
import y.h.bw;
import y.h.ch;
import y.h.fD;
import y.h.fj;

class hF implements MouseWheelListener {
   fD a;

   public hF(fD var1) {
      this.a = var1;
      var1.getCanvasComponent().addMouseWheelListener(this);
   }

   public void mouseWheelMoved(MouseWheelEvent var1) {
      boolean var18 = fj.z;
      ch var2 = this.a.tc;
      Object var3 = var1.getSource();
      if(var3 instanceof bw) {
         bw var4 = (bw)var3;
         ch var5 = (ch)var4.getParent();
         if(Boolean.TRUE.equals(var5.getClientProperty("Overview.AllowZooming"))) {
            double var6;
            double var8;
            double var10;
            int var12;
            label26: {
               var6 = var4.c((double)var1.getX());
               var8 = var4.d((double)var1.getY());
               var10 = var2.getZoom();
               var12 = 0;
               if(var1.getScrollType() == 1) {
                  var12 = var1.getWheelRotation();
                  if(!var18) {
                     break label26;
                  }
               }

               if(var1.getScrollType() == 0) {
                  var12 = var1.getUnitsToScroll();
               }
            }

            if(var12 != 0) {
               Point2D var13;
               label20: {
                  var13 = var2.getCenter();
                  if(var12 > 0) {
                     var2.setZoom(var10 / 1.25D);
                     if(!var18) {
                        break label20;
                     }
                  }

                  var2.setZoom(var10 * 1.25D);
               }

               double var14 = var4.c((double)var1.getX());
               double var16 = var4.d((double)var1.getY());
               var6 = var13.getX() + var6 - var14;
               var8 = var13.getY() + var8 - var16;
               var2.setCenter(var6, var8);
               this.a.adjustWorldRect(var2);
               var2.updateView();
            }
         }
      }

   }
}
