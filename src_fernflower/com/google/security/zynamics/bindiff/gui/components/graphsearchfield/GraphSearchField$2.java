package com.google.security.zynamics.bindiff.gui.components.graphsearchfield;

import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxEditor;

class GraphSearchField$2 extends BasicComboBoxEditor {
   // $FF: synthetic field
   final GraphSearchField this$0;

   GraphSearchField$2(GraphSearchField var1) {
      this.this$0 = var1;
   }

   protected JTextField createEditorComponent() {
      return GraphSearchField.access$600(this.this$0);
   }
}
