package org.jfree.ui;

import java.awt.Font;
import java.util.ResourceBundle;
import javax.swing.JTextField;

public class FontDisplayField extends JTextField {
   private Font displayFont;
   protected static final ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.ui.LocalizationBundle");

   public FontDisplayField(Font var1) {
      super("");
      this.setDisplayFont(var1);
      this.setEnabled(false);
   }

   public Font getDisplayFont() {
      return this.displayFont;
   }

   public void setDisplayFont(Font var1) {
      this.displayFont = var1;
      this.setText(this.fontToString(this.displayFont));
   }

   private String fontToString(Font var1) {
      return var1 != null?var1.getFontName() + ", " + var1.getSize():localizationResources.getString("No_Font_Selected");
   }
}
