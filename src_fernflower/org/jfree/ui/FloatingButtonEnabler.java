package org.jfree.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractButton;

public final class FloatingButtonEnabler extends MouseAdapter {
   private static FloatingButtonEnabler singleton;

   public static FloatingButtonEnabler getInstance() {
      if(singleton == null) {
         singleton = new FloatingButtonEnabler();
      }

      return singleton;
   }

   public void addButton(AbstractButton var1) {
      var1.addMouseListener(this);
      var1.setBorderPainted(false);
   }

   public void removeButton(AbstractButton var1) {
      var1.addMouseListener(this);
      var1.setBorderPainted(true);
   }

   public void mouseEntered(MouseEvent var1) {
      if(var1.getSource() instanceof AbstractButton) {
         AbstractButton var2 = (AbstractButton)var1.getSource();
         if(var2.isEnabled()) {
            var2.setBorderPainted(true);
         }
      }

   }

   public void mouseExited(MouseEvent var1) {
      if(var1.getSource() instanceof AbstractButton) {
         AbstractButton var2 = (AbstractButton)var1.getSource();
         var2.setBorderPainted(false);
         if(var2.getParent() != null) {
            var2.getParent().repaint();
         }
      }

   }
}
