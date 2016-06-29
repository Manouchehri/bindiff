package y.h;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import y.h.ch;
import y.h.fj;
import y.h.gX;
import y.h.hA;
import y.h.hx;
import y.h.hy;
import y.h.hz;

final class hw extends gX implements MouseWheelListener {
   private int b;
   private Cursor c;
   private hx d;
   private hx e;
   private gX f;
   private hA g;
   private List h;
   private boolean i;
   static Class a;

   public hw() {
      this((gX)null);
   }

   public hw(gX var1) {
      this.h = new ArrayList();
      this.f = var1;
      if(this.f != null) {
         this.f.setGrabFocusEnabled(false);
      }

      this.setGrabFocusEnabled(false);
   }

   public void a(JComponent var1, AffineTransform var2) {
      this.h.add(new hz(var1, var2));
   }

   public void activate(boolean var1) {
      super.activate(var1);
      if(var1) {
         this.g = hA.a(this.view.getCanvasComponent());
         if(!fj.z) {
            return;
         }
      }

      this.d = null;
      this.e = null;
      this.c = null;
      this.b = 0;
      if(this.g != null) {
         this.g.b(this.view.getCanvasComponent());
         this.g = null;
      }

   }

   public void mouseMoved(MouseEvent var1) {
      this.a(var1);
      if(this.d != null) {
         this.d.a(var1);
      }

      this.a();
      if(this.f != null && !var1.isConsumed()) {
         this.f.mouseMoved(var1);
      }

   }

   public void mouseReleased(MouseEvent var1) {
      this.a(var1);
      if(this.b > 0) {
         if(this.e != null) {
            this.e.a(var1);
         }

         --this.b;
         if(this.b == 0) {
            this.e = null;
         }
      }

      this.a();
      if(this.f != null && !var1.isConsumed()) {
         this.f.mouseReleased(var1);
      }

   }

   public void mouseDragged(MouseEvent var1) {
      this.a(var1);
      if(this.e != null) {
         this.e.a(var1);
      }

      this.a();
      if(this.f != null && !var1.isConsumed()) {
         this.f.mouseDragged(var1);
      }

   }

   public void mousePressed(MouseEvent var1) {
      this.a(var1);
      if(this.d != null) {
         if(this.b == 0) {
            this.e = this.d;
         }

         ++this.b;
         this.e.a(var1);
      }

      this.a();
      if(this.f != null && !var1.isConsumed()) {
         this.f.mousePressed(var1);
      }

   }

   public void mouseClicked(MouseEvent var1) {
      label19: {
         this.a(var1);
         if(this.e != null) {
            this.e.a(var1);
            if(!fj.z) {
               break label19;
            }
         }

         if(this.d != null) {
            this.d.a(var1);
         }
      }

      this.a();
      if(this.f != null && !var1.isConsumed()) {
         this.f.mouseClicked(var1);
      }

   }

   public void mouseEntered(MouseEvent var1) {
      this.a(var1);
      this.a();
      if(this.f != null) {
         this.f.mouseEntered(var1);
      }

   }

   public void mouseExited(MouseEvent var1) {
      if(!this.i) {
         if(this.d != null) {
            this.d.a(var1);
            this.view.setToolTipText((String)null);
            this.d = null;
         }

         this.a();
         if(this.f != null) {
            this.f.mouseExited(var1);
         }
      }

   }

   private void a() {
      Cursor var1;
      label24: {
         boolean var2 = fj.z;
         if(this.e != null) {
            var1 = this.e.b();
            if(!var2) {
               break label24;
            }
         }

         if(this.d != null) {
            var1 = this.d.b();
            if(!var2) {
               break label24;
            }
         }

         var1 = null;
      }

      if(var1 != this.c) {
         this.view.setViewCursor(var1);
         this.c = var1;
      }

   }

   private hx a(MouseEvent var1, hx var2) {
      boolean var6 = fj.z;
      if(!this.h.isEmpty()) {
         int var3 = 0;

         while(var3 < this.h.size()) {
            hz var4 = (hz)this.h.get(var3);
            JComponent var5 = var4.a(this.translateX(var1.getX()), this.translateY(var1.getY()));
            if(var5 != null) {
               if(var2 instanceof hy && var2.a() == var5) {
                  return var2;
               }

               return new hy(this, var4, var5);
            }

            ++var3;
            if(var6) {
               break;
            }
         }
      }

      return null;
   }

   static final JComponent a(JComponent var0, int var1, int var2) {
      boolean var5 = fj.z;
      Object var3 = var0;

      while(true) {
         Component var4 = ((Component)var3).getComponentAt(var1, var2);
         int var10000;
         if(var3 == var4) {
            var10000 = var3 instanceof JComponent;
            if(!var5) {
               if(var10000 != 0) {
                  return (JComponent)var3;
               }

               return null;
            }
         } else {
            if(var4 == null) {
               return null;
            }

            var1 -= var4.getX();
            var10000 = var2 - var4.getY();
         }

         var2 = var10000;
         var3 = var4;
      }
   }

   private void a(MouseEvent var1) {
      hx var2 = this.a(var1, this.d);
      if(var2 != this.d) {
         if(this.d != null) {
            this.d.a(var1, 505);
         }

         this.view.setToolTipText((String)null);
         this.d = var2;
         if(this.d != null) {
            this.d.a(var1, 504);
         }
      }

   }

   public void mouseWheelMoved(MouseWheelEvent var1) {
      if(!this.i && this.d != null) {
         this.d.a(var1);
      }

   }

   public void setActiveView(ch var1) {
      super.setActiveView(var1);
      if(this.f != null) {
         this.f.setActiveView(var1);
      }

   }

   protected void a(Component var1, MouseEvent var2, int var3, int var4, int var5) {
      boolean var6 = this.i;
      this.i = true;

      try {
         Object var7;
         label63: {
            if(var2 instanceof MouseWheelEvent) {
               MouseWheelEvent var8 = (MouseWheelEvent)var2;
               var7 = new MouseWheelEvent(var1, var5, var2.getWhen(), var2.getModifiers(), var3, var4, var2.getClickCount(), var2.isPopupTrigger(), var8.getScrollType(), var8.getScrollAmount(), var8.getWheelRotation());
               if(!fj.z) {
                  break label63;
               }
            }

            var7 = new MouseEvent(var1, var5, var2.getWhen(), var2.getModifiers(), var3, var4, var2.getClickCount(), var2.isPopupTrigger());
         }

         var1.dispatchEvent((AWTEvent)var7);
         if((var5 == 503 || var5 == 504) && var1 instanceof JComponent) {
            String var12 = ((JComponent)var1).getToolTipText((MouseEvent)var7);
            this.view.setToolTipText(var12);
         }

         if(((MouseEvent)var7).isConsumed() && !var2.isConsumed()) {
            var2.consume();
         }
      } finally {
         this.i = var6;
      }

   }

   static Class a(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
