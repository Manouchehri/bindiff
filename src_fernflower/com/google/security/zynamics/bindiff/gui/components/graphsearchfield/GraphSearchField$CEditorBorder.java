package com.google.security.zynamics.bindiff.gui.components.graphsearchfield;

import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField$1;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.AbstractBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;

final class GraphSearchField$CEditorBorder extends AbstractBorder {
   // $FF: synthetic field
   final GraphSearchField this$0;

   private GraphSearchField$CEditorBorder(GraphSearchField var1) {
      this.this$0 = var1;
   }

   public Insets getBorderInsets(Component var1) {
      return GraphSearchField.access$800();
   }

   public void paintBorder(Component var1, Graphics var2, int var3, int var4, int var5, int var6) {
      var2.translate(var3, var4);
      GraphSearchField.access$900(this.this$0).paintIcon(var1, var2, var3 + 4, var4 + 5);
      var2.setColor(MetalLookAndFeel.getControlDarkShadow());
      var2.drawRect(0, 0, var5, var6 - 1);
      var2.setColor(MetalLookAndFeel.getControlShadow());
      var2.drawRect(1, 1, var5 - 2, var6 - 3);
      var2.translate(-var3, -var4);
   }

   // $FF: synthetic method
   GraphSearchField$CEditorBorder(GraphSearchField var1, GraphSearchField$1 var2) {
      this(var1);
   }
}
