package y.h;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import y.h.ch;
import y.h.dt;
import y.h.du;
import y.h.dv;
import y.h.fj;
import y.h.gX;

public class ds extends gX {
   private dv a;
   private double b = 2.0D;
   private int c = 100;
   private MouseWheelListener[] d;
   private MouseWheelListener e;
   private boolean f = true;
   private ch g;

   public ds() {
      this.setName("NAVIGATION_MAGNIFIER");
   }

   public void mouseMoved(double var1, double var3) {
      this.a(var1, var3);
   }

   public void mouseDraggedLeft(double var1, double var3) {
      this.a(var1, var3);
   }

   public void mouseDraggedRight(double var1, double var3) {
      this.a(var1, var3);
   }

   public void mouseExited(MouseEvent var1) {
      super.mouseExited(var1);
      if(this.a != null) {
         this.view.removeDrawable(this.a);
         this.a = null;
         this.view.updateView();
      }

   }

   protected ch a() {
      ch var1 = new ch(this.getGraph2D());
      var1.setAntialiasedPainting(this.view.isAntialiasedPainting());
      var1.setGridVisible(this.view.isGridVisible());
      var1.setGridResolution(this.view.getGridResolution());
      var1.setGridColor(this.view.getGridColor());
      var1.setGridType(this.view.getGridType());
      var1.setGraph2DRenderer(this.view.getGraph2DRenderer());
      var1.setPaintDetailThreshold(0.0D);
      var1.setBackgroundRenderer(new du(var1, this.view));
      return var1;
   }

   public void activate(boolean var1) {
      boolean var4 = fj.z;
      JComponent var2;
      int var3;
      if(var1) {
         var2 = this.view.getCanvasComponent();
         if(this.f) {
            this.d = var2.getMouseWheelListeners();
            var3 = 0;

            while(true) {
               if(var3 < this.d.length) {
                  var2.removeMouseWheelListener(this.d[var3]);
                  ++var3;
                  if(var4) {
                     break;
                  }

                  if(!var4) {
                     continue;
                  }
               }

               this.e = new dt(this);
               break;
            }

            var2.addMouseWheelListener(this.e);
         }

         this.setEditing(true);
         if(!var4) {
            return;
         }
      }

      this.setEditing(false);
      this.view.removeDrawable(this.a);
      this.a = null;
      this.getGraph2D().c(this.g);
      this.g = null;
      var2 = this.view.getCanvasComponent();
      if(this.f) {
         if(this.e != null) {
            var2.removeMouseWheelListener(this.e);
            this.e = null;
         }

         var3 = 0;

         while(var3 < this.d.length) {
            var2.addMouseWheelListener(this.d[var3]);
            ++var3;
            if(var4) {
               return;
            }

            if(var4) {
               break;
            }
         }
      }

      this.view.updateView();
   }

   private void a(double var1, double var3) {
      if(!this.isEditing()) {
         this.setEditing(true);
      }

      if(this.a == null) {
         this.g = this.a();
         this.a = new dv(this, this.g);
         this.a.a(this.b);
         this.a.a(this.c);
         this.view.addDrawable(this.a);
         this.a.a(new y.d.t(var1, var3));
      }

      Rectangle2D var5 = this.a.a();
      this.a.a(new y.d.t(var1, var3));
      var5.add(this.a.a());
      double var6 = 5.0D / this.view.getZoom();
      var5.setFrame(var5.getX() - var6, var5.getY() - var6, var5.getWidth() + 2.0D * var6, var5.getHeight() + 2.0D * var6);
      this.view.updateView(var5);
   }

   public void a(double var1) {
      if(this.b != var1) {
         this.b = var1;
         if(this.a != null) {
            this.a.a(var1);
            this.view.updateView();
         }
      }

   }

   public void a(int var1) {
      if(var1 != this.c) {
         this.c = var1;
         if(this.a != null) {
            this.a.a(this.c);
            this.view.updateView();
         }
      }

   }

   public void a(MouseWheelEvent var1) {
      int var2;
      boolean var5;
      label23: {
         var5 = fj.z;
         var2 = 0;
         if(var1.getScrollType() == 1) {
            var2 = var1.getWheelRotation();
            if(!var5) {
               break label23;
            }
         }

         if(var1.getScrollType() == 0) {
            var2 = var1.getUnitsToScroll();
         }
      }

      if(var2 != 0) {
         if((var1.getModifiers() & 2) == 0) {
            double var3 = this.a(this.b, var2);
            this.a(var3);
            if(!var5) {
               return;
            }
         }

         int var6 = this.a(this.c, var2);
         this.a(var6);
      }

   }

   protected int a(int var1, int var2) {
      byte var3 = 10;
      return var2 == 0?var1:Math.max(var3, var1 + var2 * var3);
   }

   protected double a(double var1, int var3) {
      if(var3 == 0) {
         return var1;
      } else {
         double var4 = var3 > 0?var1 / 1.25D:var1 * 1.25D;
         return Math.max(1.0D, var4);
      }
   }

   static dv a(ds var0) {
      return var0.a;
   }
}
