package com.google.security.zynamics.zylib.gui.imagecombobox;

import com.google.security.zynamics.zylib.gui.imagecombobox.ImageElement;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

class JImageComboBox$ComboBoxRenderer extends JLabel implements ListCellRenderer {
   private static final long serialVersionUID = 2728401247866641230L;
   private Font uhOhFont;

   public JImageComboBox$ComboBoxRenderer(int var1) {
      this.setOpaque(true);
      this.setHorizontalAlignment(var1);
      this.setVerticalAlignment(0);
      if(var1 == 2) {
         this.setBorder(new EmptyBorder(0, 5, 0, 0));
      }

   }

   protected void setUhOhText(String var1, Font var2) {
      if(this.uhOhFont == null) {
         this.uhOhFont = var2.deriveFont(2);
      }

      this.setFont(this.uhOhFont);
      this.setText(var1);
   }

   public Component getListCellRendererComponent(JList var1, Object var2, int var3, boolean var4, boolean var5) {
      ImageElement var6 = (ImageElement)var2;
      if(var4) {
         this.setBackground(var1.getSelectionBackground());
         this.setForeground(var1.getSelectionForeground());
      } else {
         this.setBackground(var1.getBackground());
         this.setForeground(var1.getForeground());
      }

      if(var6 == null) {
         return this;
      } else {
         ImageIcon var7 = var6.getIcon();
         String var8 = var6.getObject().toString();
         this.setIcon(var7);
         if(var7 != null) {
            this.setText(var8);
            this.setFont(var1.getFont());
         } else {
            this.setUhOhText(String.valueOf(var8).concat(" (no image available)"), var1.getFont());
         }

         return this;
      }
   }
}
