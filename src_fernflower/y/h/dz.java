package y.h;

import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeListener;
import y.h.aB;
import y.h.az;
import y.h.cW;
import y.h.ch;
import y.h.dA;
import y.h.dw;
import y.h.dx;
import y.h.dy;
import y.h.fj;
import y.h.gX;

public class dz extends gX {
   private dx a;
   private ChangeListener b = new dA(this);
   private List c = new ArrayList();
   private boolean d;
   private boolean e;
   private boolean f;
   private boolean g = true;

   private boolean a(MouseEvent var1) {
      if(this.a == null) {
         double var2 = this.view.toWorldCoordX(var1.getX());
         double var4 = this.view.toWorldCoordY(var1.getY());
         this.a(this.a(this.view, var2, var4, (cW)null));
      }

      if(this.a != null) {
         if(this.a.c()) {
            if(this.a.b()) {
               this.a.b(this.b(var1));
            }

            return true;
         }

         if(this.a.b()) {
            dw var6 = this.b(var1);
            if(this.a.a(var6) && this.a(this.a)) {
               this.a.b(var6);
               return true;
            }
         }
      }

      return false;
   }

   public void a() {
      dx var1 = this.a;
      if(var1 != null && var1.c()) {
         var1.e();
         var1.b(this.b);
         this.setEditing(false);
      }

   }

   public boolean a(dx var1) {
      if(this.a != null && this.a != var1) {
         this.a();
      }

      this.a = var1;
      if(this.a != null) {
         boolean var2 = this.a.c();
         if(!var2) {
            this.a.d();
         }

         var2 = this.a.c();
         if(var2) {
            this.a.a(this.b);
            this.setEditing(true);
         }

         return var2;
      } else {
         return false;
      }
   }

   protected void c() {
      this.a = null;
      this.setEditing(false);
      if(this.g) {
         this.reactivateParent();
      }

   }

   private dw b(MouseEvent var1) {
      ch var2 = this.view;
      double var3 = this.translateX(var1.getX());
      double var5 = this.translateY(var1.getY());
      return new dw(var2, this, var3, var5, var1);
   }

   public void mousePressed(MouseEvent var1) {
      this.e();
      this.lastPressEvent = var1;
      if(!this.a(var1)) {
         super.mousePressed(var1);
      }

   }

   protected void e() {
      if(this.isGrabFocusEnabled()) {
         Component var1 = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
         if(var1 != null && !SwingUtilities.isDescendingFrom(var1, this.view)) {
            this.view.getCanvasComponent().requestFocusInWindow();
         }
      }

   }

   public void mouseReleased(MouseEvent var1) {
      this.lastReleaseEvent = var1;
      if(!this.a(var1)) {
         super.mouseReleased(var1);
      }

   }

   public void mouseClicked(MouseEvent var1) {
      this.lastClickEvent = var1;
      if(!this.a(var1)) {
         super.mouseClicked(var1);
      }

   }

   public void mouseDragged(MouseEvent var1) {
      this.lastDragEvent = var1;
      if(!this.a(var1)) {
         super.mouseDragged(var1);
      }

   }

   public void mouseMoved(MouseEvent var1) {
      this.lastMoveEvent = var1;
      if(!this.a(var1)) {
         super.mouseMoved(var1);
      }

   }

   public void mouseEntered(MouseEvent var1) {
      if(!this.a(var1)) {
         super.mouseEntered(var1);
      }

   }

   public void mouseExited(MouseEvent var1) {
      if(!this.a(var1)) {
         super.mouseExited(var1);
      }

   }

   public dx a(ch var1, double var2, double var4, cW var6) {
      boolean var11 = fj.z;
      if(var6 == null) {
         var6 = this.getHitInfo(var2, var4);
      }

      int var7 = 0;

      while(true) {
         dx var9;
         if(var7 < this.c.size()) {
            dy var8 = (dy)this.c.get(var7);
            var9 = var8.a(var1, var2, var4, var6);
            if(var11) {
               break;
            }

            if(var9 != null) {
               return var9;
            }

            ++var7;
            if(!var11) {
               continue;
            }
         }

         if(var6 != null) {
            dx var10;
            dy var19;
            if(this.e) {
               y.c.q var12 = var6.i();
               if(var12 != null) {
                  fj var14 = var1.getGraph2D().t(var12);
                  var19 = var14.getMouseInputEditorProvider();
                  if(var19 != null) {
                     var10 = var19.a(var1, var2, var4, var6);
                     if(var10 != null) {
                        return var10;
                     }
                  }
               }
            }

            if(this.f) {
               y.c.d var13 = var6.k();
               if(var13 != null) {
                  aB var16 = var1.getGraph2D().i(var13);
                  var19 = var16.getMouseInputEditorProvider();
                  if(var19 != null) {
                     var10 = var19.a(var1, var2, var4, var6);
                     if(var10 != null) {
                        return var10;
                     }
                  }
               }
            }

            if(this.d) {
               y.c.C var15 = var1.getGraph2D().R();

               az var18;
               while(var15.f()) {
                  var18 = (az)var15.d();
                  if(var11) {
                     return null;
                  }

                  if(var18 instanceof dy) {
                     var9 = ((dy)var18).a(var1, var2, var4, var6);
                     if(var9 != null) {
                        return var9;
                     }
                  }

                  var15.g();
                  if(var11) {
                     break;
                  }
               }

               Iterator var17 = var1.getDrawables().iterator();

               while(true) {
                  Object var10000;
                  if(var17.hasNext()) {
                     var18 = (az)var17.next();
                     if(!(var18 instanceof dy)) {
                        continue;
                     }

                     var9 = ((dy)var18).a(var1, var2, var4, var6);
                     var10000 = var9;
                     if(!var11) {
                        if(var9 != null) {
                           return var9;
                        }
                        continue;
                     }
                  } else {
                     var17 = var1.getBackgroundDrawables().iterator();
                     if(!var17.hasNext()) {
                        return null;
                     }

                     var10000 = var17.next();
                  }

                  while(true) {
                     var18 = (az)var10000;
                     if(var18 instanceof dy) {
                        var9 = ((dy)var18).a(var1, var2, var4, var6);
                        if(var9 != null) {
                           return var9;
                        }
                     }

                     if(!var17.hasNext()) {
                        return null;
                     }

                     var10000 = var17.next();
                  }
               }
            }
         }
         break;
      }

      return null;
   }

   static dx a(dz var0) {
      return var0.a;
   }
}
