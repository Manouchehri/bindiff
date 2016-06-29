package y.h;

import java.applet.Applet;
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.beans.PropertyChangeListener;
import java.util.EventObject;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.event.CellEditorListener;
import y.h.E;
import y.h.cW;
import y.h.eQ;
import y.h.fj;
import y.h.gX;
import y.h.hw;
import y.h.ia;

public class D extends gX {
   private final y.c.c a;
   private final y.c.b b;
   private eQ c;
   private fj d;
   private JComponent e;
   private final CellEditorListener f;
   private hw g;
   private ia h;
   private PropertyChangeListener i;

   public boolean a(y.c.q var1, EventObject var2) {
      if(this.a(var1) && (!this.a() || this.e())) {
         fj var3 = this.getGraph2D().t(var1);
         eQ var4 = this.c(var1);
         if(var4 == null || var2 != null && !var4.isCellEditable(var2)) {
            return false;
         } else {
            this.a(var3, var4);
            if(var2 instanceof MouseEvent && ((MouseEvent)var2).getID() == 500 && this.g != null && this.a()) {
               this.g.mouseClicked((MouseEvent)var2);
            }

            return true;
         }
      } else {
         return false;
      }
   }

   public boolean a(y.c.q var1) {
      return this.c(var1) != null;
   }

   private void b(MouseEvent var1) {
      cW var2;
      if(!this.a()) {
         if(!this.a(var1)) {
            return;
         }

         var2 = this.getHitInfo(var1);
         if(var2.i() == null) {
            return;
         }

         this.a((y.c.q)var2.i(), (EventObject)var1);
         if(!fj.z) {
            return;
         }
      }

      this.a(KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner());
      if(this.a() && var1.getID() == 501) {
         var2 = this.getHitInfo(var1);
         y.c.q var3 = var2.i();
         if((var3 == null || var3 != this.d.getNode()) && !this.e()) {
            this.c();
         }
      }

   }

   public Object b(y.c.q var1) {
      return this.b.b(this.d.getNode());
   }

   protected boolean a(MouseEvent var1) {
      return var1.getID() == 500 && var1.getClickCount() == 2;
   }

   public eQ c(y.c.q var1) {
      Object var2 = this.a != null?this.a.b(var1):null;
      return var2 instanceof eQ?(eQ)var2:null;
   }

   public boolean a() {
      return this.c != null;
   }

   public void a(fj var1, eQ var2) {
      if(this.a() && !this.e()) {
         this.c();
      }

      if(!this.a()) {
         this.c = var2;
         this.d = var1;
         var2.addCellEditorListener(this.f);
         this.a(var2.a(this.view, var1, this.b(var1.getNode()), var1.isSelected()), var1);
      }

   }

   public void c() {
      if(this.c != null) {
         this.c.cancelCellEditing();
      }

   }

   public boolean e() {
      return this.c != null?this.c.stopCellEditing():true;
   }

   public void mouseMoved(MouseEvent var1) {
      if(this.g != null) {
         this.g.mouseMoved(var1);
      }

   }

   private void c(MouseEvent var1) {
      if(var1.getID() == 501) {
         y.c.q var2 = this.getHitInfo(var1).i();
         if((var2 == null || var2 != this.d.getNode()) && !this.e()) {
            this.c();
         }
      }

   }

   public void mouseReleased(MouseEvent var1) {
      if(this.g != null) {
         this.g.mouseReleased(var1);
         this.c(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b(var1);
   }

   public void mouseDragged(MouseEvent var1) {
      if(this.g != null) {
         this.g.mouseDragged(var1);
         this.c(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b(var1);
   }

   public void mousePressed(MouseEvent var1) {
      if(this.g != null) {
         this.g.mousePressed(var1);
         this.c(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b(var1);
   }

   public void mouseClicked(MouseEvent var1) {
      if(this.g != null) {
         this.g.mouseClicked(var1);
         this.c(var1);
         if(!fj.z) {
            return;
         }
      }

      this.b(var1);
   }

   protected void a(JComponent var1, fj var2) {
      if(var1.getNextFocusableComponent() == null) {
         var1.setNextFocusableComponent(this.view.getCanvasComponent());
      }

      this.view.s().add(var1);
      this.e = var1;
      hw var3 = new hw();
      this.setChild(var3, (MouseEvent)null, (MouseEvent)null, (MouseEvent)null);
      this.g = var3;
      AffineTransform var4 = AffineTransform.getTranslateInstance(var2.getX(), var2.getY());
      var3.a(var1, var4);
      this.h = new ia(this.view, var1, var4);
      this.view.addDrawable(this.h);
      var1.setBounds(0, 0, (int)var2.getWidth(), (int)var2.getHeight());
      var1.validate();
      var1.requestFocusInWindow();
      var1.repaint();
      if(this.i == null) {
         KeyboardFocusManager var5 = KeyboardFocusManager.getCurrentKeyboardFocusManager();
         this.i = new E(this, var5);
         var5.addPropertyChangeListener("permanentFocusOwner", this.i);
      }

   }

   private void a(Component var1) {
      boolean var3 = fj.z;
      if(this.a()) {
         Object var2 = var1;

         while(var2 != null) {
            if(var2 == this.view.s()) {
               return;
            }

            if(var2 instanceof Window || var2 instanceof Applet && ((Component)var2).getParent() == null) {
               if(var2 != SwingUtilities.getRoot(this.view) || this.e()) {
                  break;
               }

               this.c();
               if(!var3) {
                  break;
               }
            }

            var2 = ((Component)var2).getParent();
            if(var3) {
               break;
            }
         }

      }
   }

   static void a(D var0, Component var1) {
      var0.a(var1);
   }
}
