package org.jfree.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.DateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class DateCellRenderer extends DefaultTableCellRenderer {
   private DateFormat formatter;

   public DateCellRenderer() {
      this(DateFormat.getDateTimeInstance());
   }

   public DateCellRenderer(DateFormat var1) {
      this.formatter = var1;
      this.setHorizontalAlignment(0);
   }

   public Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6) {
      this.setFont((Font)null);
      if(var2 != null) {
         this.setText(this.formatter.format(var2));
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
