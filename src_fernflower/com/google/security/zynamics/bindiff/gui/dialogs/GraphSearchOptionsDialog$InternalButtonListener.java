package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.GraphSearchOptionsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.GraphSearchOptionsDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GraphSearchOptionsDialog$InternalButtonListener implements ActionListener {
   // $FF: synthetic field
   final GraphSearchOptionsDialog this$0;

   private GraphSearchOptionsDialog$InternalButtonListener(GraphSearchOptionsDialog var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if(var1.getSource().equals(GraphSearchOptionsDialog.access$100(this.this$0))) {
         GraphSearchOptionsDialog.access$200(this.this$0).setRegEx(false);
         GraphSearchOptionsDialog.access$200(this.this$0).setCaseSensitive(false);
         GraphSearchOptionsDialog.access$200(this.this$0).setOnlySelected(false);
         GraphSearchOptionsDialog.access$200(this.this$0).setOnlyVisible(false);
         GraphSearchOptionsDialog.access$300(this.this$0).setSelected(false);
         GraphSearchOptionsDialog.access$400(this.this$0).setSelected(false);
         GraphSearchOptionsDialog.access$500(this.this$0).setSelected(false);
         GraphSearchOptionsDialog.access$600(this.this$0).setSelected(false);
      } else {
         if(var1.getSource().equals(GraphSearchOptionsDialog.access$700(this.this$0))) {
            GraphSearchOptionsDialog.access$200(this.this$0).setRegEx(GraphSearchOptionsDialog.access$300(this.this$0).isSelected());
            GraphSearchOptionsDialog.access$200(this.this$0).setCaseSensitive(GraphSearchOptionsDialog.access$400(this.this$0).isSelected());
            GraphSearchOptionsDialog.access$200(this.this$0).setOnlySelected(GraphSearchOptionsDialog.access$500(this.this$0).isSelected());
            GraphSearchOptionsDialog.access$200(this.this$0).setOnlyVisible(GraphSearchOptionsDialog.access$600(this.this$0).isSelected());
         }

         if(var1.getSource().equals(GraphSearchOptionsDialog.access$800(this.this$0))) {
            GraphSearchOptionsDialog.access$300(this.this$0).setSelected(GraphSearchOptionsDialog.access$900(this.this$0));
            GraphSearchOptionsDialog.access$400(this.this$0).setSelected(GraphSearchOptionsDialog.access$1000(this.this$0));
            GraphSearchOptionsDialog.access$600(this.this$0).setSelected(GraphSearchOptionsDialog.access$1100(this.this$0));
            GraphSearchOptionsDialog.access$500(this.this$0).setSelected(GraphSearchOptionsDialog.access$1200(this.this$0));
         }

         this.this$0.setVisible(false);
      }
   }

   // $FF: synthetic method
   GraphSearchOptionsDialog$InternalButtonListener(GraphSearchOptionsDialog var1, GraphSearchOptionsDialog$1 var2) {
      this(var1);
   }
}
