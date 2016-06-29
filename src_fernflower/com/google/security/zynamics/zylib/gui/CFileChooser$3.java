package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CFileChooser;
import com.google.security.zynamics.zylib.gui.GuiHelper$ComponentFilter;
import javax.swing.JButton;
import javax.swing.JComponent;

class CFileChooser$3 implements GuiHelper$ComponentFilter {
   // $FF: synthetic field
   final String val$approve;
   // $FF: synthetic field
   final CFileChooser this$0;

   CFileChooser$3(CFileChooser var1, String var2) {
      this.this$0 = var1;
      this.val$approve = var2;
   }

   public boolean accept(JComponent var1) {
      if(!(var1 instanceof JButton)) {
         return false;
      } else {
         String var2 = ((JButton)var1).getText();
         return var2 == null?this.val$approve == null:(this.val$approve == null?var2 == null:((JButton)var1).getText().equals(this.val$approve));
      }
   }
}
