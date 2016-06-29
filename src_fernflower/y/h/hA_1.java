package y.h;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D.Double;
import javax.swing.JComponent;
import javax.swing.RepaintManager;
import y.h.bB;
import y.h.ch;
import y.h.fj;
import y.h.hw;
import y.h.hz;

final class hA extends RepaintManager {
   private final RepaintManager a;

   protected hA(RepaintManager var1) {
      this.a = var1;
   }

   public static hA a(JComponent var0) {
      RepaintManager var1 = RepaintManager.currentManager(var0);
      if(var1.getClass() != (hw.a == null?(hw.a = hw.a("y.h.hA")):hw.a)) {
         hA var2 = new hA(var1);
         var0.putClientProperty("CustomRepaintManager.Instance", var2);
         RepaintManager.setCurrentManager(var2);
         return var2;
      } else {
         return (hA)var1;
      }
   }

   public void b(JComponent var1) {
      if(RepaintManager.currentManager(var1) == this) {
         var1.putClientProperty("CustomRepaintManager.Instance", (Object)null);
         RepaintManager.setCurrentManager(this.a);
      }

   }

   public Image getOffscreenBuffer(Component var1, int var2, int var3) {
      Image var4 = this.a.getOffscreenBuffer(var1, var2, var3);
      return var4;
   }

   public Image getVolatileOffscreenBuffer(Component var1, int var2, int var3) {
      return this.a.getVolatileOffscreenBuffer(var1, var2, var3);
   }

   public void setDoubleBufferingEnabled(boolean var1) {
      this.a.setDoubleBufferingEnabled(var1);
   }

   public void setDoubleBufferMaximumSize(Dimension var1) {
      this.a.setDoubleBufferMaximumSize(var1);
   }

   public void removeInvalidComponent(JComponent var1) {
      this.a.removeInvalidComponent(var1);
   }

   public void markCompletelyDirty(JComponent var1) {
      bB var2 = (bB)var1.getClientProperty("JCOMPONENT_PARENT_KEY");
      if(var2 != null) {
         this.addDirtyRegion(var1, 0, 0, var1.getWidth(), var1.getHeight());
         if(!fj.z) {
            return;
         }
      }

      this.a.markCompletelyDirty(var1);
   }

   public void addInvalidComponent(JComponent var1) {
      boolean var3 = fj.z;
      bB var2 = (bB)var1.getClientProperty("JCOMPONENT_PARENT_KEY");
      if(var2 != null) {
         while(true) {
            if(var1.getParent() != var2 && !var1.isValidateRoot()) {
               var1 = (JComponent)var1.getParent();
               if(!var3) {
                  continue;
               }
            }

            this.a.addInvalidComponent(var2);
            if(!var3) {
               return;
            }
            break;
         }
      }

      this.a.addInvalidComponent(var1);
   }

   public Rectangle getDirtyRegion(JComponent var1) {
      bB var2 = (bB)var1.getClientProperty("JCOMPONENT_PARENT_KEY");
      if(var2 != null) {
         return new Rectangle();
      } else {
         Rectangle var3 = this.a.getDirtyRegion(var1);
         return var3;
      }
   }

   public boolean isCompletelyDirty(JComponent var1) {
      bB var3 = (bB)var1.getClientProperty("JCOMPONENT_PARENT_KEY");
      boolean var2;
      if(var3 != null) {
         var2 = false;
         if(!fj.z) {
            return var2;
         }
      }

      var2 = this.a.isCompletelyDirty(var1);
      return var2;
   }

   public void markCompletelyClean(JComponent var1) {
      bB var2 = (bB)var1.getClientProperty("JCOMPONENT_PARENT_KEY");
      if(var2 == null) {
         this.a.markCompletelyClean(var1);
      }

   }

   public void addDirtyRegion(JComponent var1, int var2, int var3, int var4, int var5) {
      boolean var11 = fj.z;
      if(var4 >= 1 && var5 >= 1) {
         if(!(var1 instanceof bB)) {
            bB var6 = (bB)var1.getClientProperty("JCOMPONENT_PARENT_KEY");
            if(var6 != null) {
               hz var7 = (hz)var1.getClientProperty("FloatingJComponent.Instance");

               while(var7 == null && var1 != var6) {
                  var2 += var1.getX();
                  var3 += var1.getY();
                  var1 = (JComponent)var1.getParent();
                  var7 = (hz)var1.getClientProperty("FloatingJComponent.Instance");
                  if(var11) {
                     break;
                  }
               }

               if(var7 == null) {
                  return;
               }

               Double var8 = new Double();
               var7.a(new Rectangle(var2, var3, var4, var5), var8);
               JComponent var9 = (JComponent)var6.getParent();
               ch var10 = (ch)var9.getParent();
               var2 = var10.toViewCoordX(var8.x);
               var3 = var10.toViewCoordY(var8.y);
               var4 = (int)Math.ceil(var8.width * var10.getZoom());
               var5 = (int)Math.ceil(var8.height * var10.getZoom());
               if(var2 < 1) {
                  var4 += var2;
                  var2 = 1;
               }

               if(var3 < 1) {
                  var5 += var3;
                  var3 = 1;
               }

               this.a.addDirtyRegion(var9, var2 - 1, var3 - 1, var4 + 2, var5 + 2);
               if(!var11) {
                  return;
               }
            }

            this.a.addDirtyRegion(var1, var2, var3, var4, var5);
         }
      }
   }

   public void validateInvalidComponents() {
      this.a.validateInvalidComponents();
   }

   public String toString() {
      String var1 = "Wrapped : " + this.a.toString();
      return var1;
   }

   public void paintDirtyRegions() {
      this.a.paintDirtyRegions();
   }

   public Dimension getDoubleBufferMaximumSize() {
      return this.a.getDoubleBufferMaximumSize();
   }

   public boolean isDoubleBufferingEnabled() {
      return this.a.isDoubleBufferingEnabled();
   }
}
