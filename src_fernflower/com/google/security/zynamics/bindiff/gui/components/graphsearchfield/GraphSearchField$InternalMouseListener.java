package com.google.security.zynamics.bindiff.gui.components.graphsearchfield;

import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField$1;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JPopupMenu;

final class GraphSearchField$InternalMouseListener extends MouseAdapter {
   private final JPopupMenu popupMenu;
   // $FF: synthetic field
   final GraphSearchField this$0;

   private GraphSearchField$InternalMouseListener(GraphSearchField var1) {
      this.this$0 = var1;
      this.popupMenu = GraphSearchField.access$2200(this.this$0);
   }

   public void mousePressed(MouseEvent var1) {
      if(var1.getX() >= 0 && var1.getX() <= 38 && !this.popupMenu.isVisible()) {
         this.popupMenu.show(this.this$0, this.this$0.getX() - 1, this.this$0.getY() + this.this$0.getHeight() - 2);
      }

   }

   public void mouseReleased(MouseEvent var1) {
      if(this.popupMenu.isVisible() && var1.getX() > 38 && var1.getSource() instanceof JComponent && var1.getY() >= 0 && var1.getY() <= ((JComponent)var1.getSource()).getHeight()) {
         this.popupMenu.setVisible(false);
      }

   }

   // $FF: synthetic method
   GraphSearchField$InternalMouseListener(GraphSearchField var1, GraphSearchField$1 var2) {
      this(var1);
   }
}
