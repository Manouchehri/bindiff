package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class DefaultCellRenderer extends DefaultTableCellRenderer {
   public Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6) {
      return super.getTableCellRendererComponent(var1, var2, false, false, var5, var6);
   }
}
