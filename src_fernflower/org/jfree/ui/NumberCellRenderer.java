package org.jfree.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.NumberFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class NumberCellRenderer extends DefaultTableCellRenderer {
   public NumberCellRenderer() {
      this.setHorizontalAlignment(4);
   }

   public Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6) {
      this.setFont((Font)null);
      NumberFormat var7 = NumberFormat.getNumberInstance();
      if(var2 != null) {
         this.setText(var7.format(var2));
      } else {
         this.setText("");
      }

      if(var3) {
         this.setBackground(var1.getSelectionBackground());
      } else {
         this.setBackground((Color)null);
      }

      return this;
   }
}
