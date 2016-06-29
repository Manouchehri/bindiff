package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.resources.Colors;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class DestinationCellRenderer extends DefaultTableCellRenderer {
   private final String workspacePath;

   public DestinationCellRenderer(String var1) {
      Preconditions.checkArgument((new File(var1)).exists(), "Workspace path must exist");
      this.workspacePath = (String)Preconditions.checkNotNull(var1);
   }

   public Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6) {
      Component var7 = super.getTableCellRendererComponent(var1, var2, false, false, var5, var6);
      String var8 = String.format("%s%s%s", new Object[]{this.workspacePath, File.separator, var2});
      if(var6 == 3) {
         var7.setBackground(Color.WHITE);
         File var9 = new File(var8);
         if(var9.exists()) {
            var7.setBackground(Colors.TABLE_CELL_PRIMARY_UNMATCHED_BACKGROUND);
         }
      }

      return var7;
   }
}
