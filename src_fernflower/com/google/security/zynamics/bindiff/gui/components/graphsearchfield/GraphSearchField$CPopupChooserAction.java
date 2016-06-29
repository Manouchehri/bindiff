package com.google.security.zynamics.bindiff.gui.components.graphsearchfield;

import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField$1;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JMenuItem;

final class GraphSearchField$CPopupChooserAction extends AbstractAction {
   // $FF: synthetic field
   final GraphSearchField this$0;

   private GraphSearchField$CPopupChooserAction(GraphSearchField var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      JMenuItem var2 = (JMenuItem)var1.getSource();
      GraphSearchField.access$1000(this.this$0, var2.getIcon());
   }

   // $FF: synthetic method
   GraphSearchField$CPopupChooserAction(GraphSearchField var1, GraphSearchField$1 var2) {
      this(var1);
   }
}
