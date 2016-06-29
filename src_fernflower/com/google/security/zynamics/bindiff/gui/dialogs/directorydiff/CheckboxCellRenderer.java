package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CheckboxCellRenderer extends JCheckBox implements TableCellRenderer {
   public CheckboxCellRenderer() {
      this.setHorizontalAlignment(0);
   }

   public Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6) {
      if(var3) {
         this.setForeground(var1.getSelectionForeground());
         this.setBackground(var1.getSelectionBackground());
      } else {
         this.setForeground(var1.getForeground());
         this.setBackground(var1.getBackground());
      }

      this.setSelected(var2 != null && ((JCheckBox)var2).isSelected());
      ((JCheckBox)var2).setHorizontalAlignment(0);
      return this;
   }
}
