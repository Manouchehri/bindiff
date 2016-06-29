package org.jfree.ui;

import java.awt.Insets;
import java.util.ResourceBundle;
import javax.swing.JTextField;

public class InsetsTextField extends JTextField {
   protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.ui.LocalizationBundle");

   public InsetsTextField(Insets var1) {
      this.setInsets(var1);
      this.setEnabled(false);
   }

   public String formatInsetsString(Insets var1) {
      var1 = var1 == null?new Insets(0, 0, 0, 0):var1;
      return localizationResources.getString("T") + var1.top + ", " + localizationResources.getString("L") + var1.left + ", " + localizationResources.getString("B") + var1.bottom + ", " + localizationResources.getString("R") + var1.right;
   }

   public void setInsets(Insets var1) {
      this.setText(this.formatInsetsString(var1));
   }
}
