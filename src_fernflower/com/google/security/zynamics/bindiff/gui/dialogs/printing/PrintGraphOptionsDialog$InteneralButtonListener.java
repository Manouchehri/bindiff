package com.google.security.zynamics.bindiff.gui.dialogs.printing;

import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphOptionsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphOptionsDialog$1;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import y.h.bZ;

final class PrintGraphOptionsDialog$InteneralButtonListener implements ActionListener {
   // $FF: synthetic field
   final PrintGraphOptionsDialog this$0;

   private PrintGraphOptionsDialog$InteneralButtonListener(PrintGraphOptionsDialog var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if(var1.getSource() == PrintGraphOptionsDialog.access$100(this.this$0)) {
         if(Integer.parseInt(PrintGraphOptionsDialog.access$200(this.this$0).getText()) < 0) {
            CMessageBox.showInformation(this.this$0, "Poster rows value must be greater than 0.");
            return;
         }

         if(Integer.parseInt(PrintGraphOptionsDialog.access$300(this.this$0).getText()) < 0) {
            CMessageBox.showInformation(this.this$0, "Poster columns value must be greater than 0.");
            return;
         }

         if(Integer.parseInt(PrintGraphOptionsDialog.access$400(this.this$0).getText()) < 0) {
            CMessageBox.showInformation(this.this$0, "Font size value must be greater than 0.");
            return;
         }

         PrintGraphOptionsDialog.access$502(this.this$0, true);
         PrintGraphOptionsDialog.access$600(this.this$0).a(Integer.parseInt(PrintGraphOptionsDialog.access$200(this.this$0).getText()));
         PrintGraphOptionsDialog.access$600(this.this$0).b(Integer.parseInt(PrintGraphOptionsDialog.access$300(this.this$0).getText()));
         PrintGraphOptionsDialog.access$600(this.this$0).a((byte)(PrintGraphOptionsDialog.access$700(this.this$0).getSelectedIndex() == 0?1:0));
         PrintGraphOptionsDialog.access$600(this.this$0).a(PrintGraphOptionsDialog.access$800(this.this$0).getSelectedIndex() == 0);
         bZ var2 = new bZ();
         var2.a(PrintGraphOptionsDialog.access$900(this.this$0).getText());
         var2.b(PrintGraphOptionsDialog.access$1000(this.this$0).getColor());
         var2.a(PrintGraphOptionsDialog.access$1100(this.this$0).getColor());
         var2.a(new Font("Dialog", 0, Integer.parseInt(PrintGraphOptionsDialog.access$400(this.this$0).getText())));
         PrintGraphOptionsDialog.access$600(this.this$0).a(var2);
      }

      this.this$0.dispose();
   }

   // $FF: synthetic method
   PrintGraphOptionsDialog$InteneralButtonListener(PrintGraphOptionsDialog var1, PrintGraphOptionsDialog$1 var2) {
      this(var1);
   }
}
