package y.h;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import y.h.fD;
import y.h.fj;

class fE implements KeyListener {
   private final fD a;

   fE(fD var1) {
      this.a = var1;
   }

   public void keyTyped(KeyEvent var1) {
   }

   public void keyReleased(KeyEvent var1) {
   }

   public void keyPressed(KeyEvent var1) {
      boolean var3 = fj.z;
      if(Boolean.TRUE.equals(this.a.getClientProperty("Overview.AllowKeyboardNavigation"))) {
         Point2D var2;
         switch(var1.getKeyCode()) {
         case 109:
            this.a.tc.setZoom(this.a.tc.getZoom() / 1.25D);
            this.a.tc.updateView();
            if(!var3) {
               break;
            }
         case 107:
            this.a.tc.setZoom(this.a.tc.getZoom() * 1.25D);
            this.a.tc.updateView();
            if(!var3) {
               break;
            }
         case 37:
            var2 = this.a.tc.getCenter();
            this.a.b(var2.getX() - (double)this.a.tc.getCanvasComponent().getWidth() * 0.5D / this.a.tc.getZoom(), var2.getY(), 0.5D);
            if(!var3) {
               break;
            }
         case 39:
            var2 = this.a.tc.getCenter();
            this.a.b(var2.getX() + (double)this.a.tc.getCanvasComponent().getWidth() * 0.5D / this.a.tc.getZoom(), var2.getY(), 0.5D);
            if(!var3) {
               break;
            }
         case 38:
            var2 = this.a.tc.getCenter();
            this.a.b(var2.getX(), var2.getY() - (double)this.a.tc.getCanvasComponent().getHeight() * 0.5D / this.a.tc.getZoom(), 0.5D);
            if(!var3) {
               break;
            }
         case 40:
            var2 = this.a.tc.getCenter();
            this.a.b(var2.getX(), var2.getY() + (double)this.a.tc.getCanvasComponent().getHeight() * 0.5D / this.a.tc.getZoom(), 0.5D);
         }

      }
   }
}
