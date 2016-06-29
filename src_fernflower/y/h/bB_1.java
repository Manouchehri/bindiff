package y.h;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import javax.swing.JComponent;
import y.h.bC;
import y.h.fj;

final class bB extends JComponent {
   final bC a = new bC(this);

   public bB() {
      this.addContainerListener(this.a);
      this.setSize(0, 0);
      this.setLayout((LayoutManager)null);
      this.setVisible(true);
      this.setOpaque(true);
      this.setDoubleBuffered(false);
      this.putClientProperty("JCOMPONENT_PARENT_KEY", this);
   }

   public boolean isValidateRoot() {
      return true;
   }

   public Rectangle getBounds() {
      return new Rectangle(0, 0, this.getParent().getWidth(), this.getParent().getHeight());
   }

   public void paint(Graphics var1) {
   }

   final void a(Component var1) {
      boolean var4 = fj.z;
      if(var1 instanceof JComponent) {
         JComponent var2 = (JComponent)var1;
         if(var2.getClientProperty("JCOMPONENT_PARENT_KEY") != this) {
            var2.addContainerListener(this.a);
            if(var2.isDoubleBuffered()) {
               var2.putClientProperty("Graph2DView.WAS_DOUBLE_BUFFERED", Boolean.TRUE);
               var2.setDoubleBuffered(false);
            }

            var2.putClientProperty("JCOMPONENT_PARENT_KEY", this);
            int var3 = var2.getComponentCount() - 1;

            while(var3 >= 0) {
               this.a(var2.getComponent(var3));
               --var3;
               if(var4) {
                  break;
               }
            }
         }
      }

   }

   final void b(Component var1) {
      boolean var4 = fj.z;
      if(var1 instanceof JComponent) {
         JComponent var2 = (JComponent)var1;
         if(var2.getClientProperty("JCOMPONENT_PARENT_KEY") == this) {
            var2.removeContainerListener(this.a);
            if(var2.getClientProperty("Graph2DView.WAS_DOUBLE_BUFFERED") == Boolean.TRUE) {
               var2.setDoubleBuffered(true);
               var2.putClientProperty("Graph2DView.WAS_DOUBLE_BUFFERED", (Object)null);
            }

            var2.putClientProperty("JCOMPONENT_PARENT_KEY", (Object)null);
         }

         int var3 = var2.getComponentCount() - 1;

         while(var3 >= 0) {
            this.b(var2.getComponent(var3));
            --var3;
            if(var4) {
               break;
            }
         }
      }

   }

   public void paintImmediately(Rectangle var1) {
   }

   protected void printComponent(Graphics var1) {
   }

   protected void printChildren(Graphics var1) {
   }

   protected void printBorder(Graphics var1) {
   }

   public void printAll(Graphics var1) {
   }

   public void print(Graphics var1) {
   }

   public void paintImmediately(int var1, int var2, int var3, int var4) {
   }

   protected void paintComponent(Graphics var1) {
   }

   protected void paintChildren(Graphics var1) {
   }

   protected void paintBorder(Graphics var1) {
   }

   public Cursor getCursor() {
      return Cursor.getDefaultCursor();
   }
}
