package com.google.security.zynamics.zylib.gui.imagecombobox;

import com.google.security.zynamics.zylib.gui.imagecombobox.ImageElement;
import com.google.security.zynamics.zylib.gui.imagecombobox.JImageComboBox$ComboBoxRenderer;
import javax.swing.JComboBox;

public class JImageComboBox extends JComboBox {
   public JImageComboBox(ImageElement[] var1) {
      super(var1);
      this.setRenderer(new JImageComboBox$ComboBoxRenderer(0));
   }

   public JImageComboBox(ImageElement[] var1, int var2) {
      super(var1);
      if(var2 != 2 && var2 != 0 && var2 != 4) {
         throw new IllegalArgumentException("Erorr: Label alignment in invalid.");
      } else {
         this.setRenderer(new JImageComboBox$ComboBoxRenderer(var2));
      }
   }
}
