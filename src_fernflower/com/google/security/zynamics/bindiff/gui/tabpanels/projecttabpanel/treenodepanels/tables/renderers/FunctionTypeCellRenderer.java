package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.BackgroundIcon;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.AbstractTableCellRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.FunctionTypeCellRenderer$1;
import com.google.security.zynamics.bindiff.resources.Colors;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;

public class FunctionTypeCellRenderer extends AbstractTableCellRenderer {
   public static Color calcColor(EFunctionType var0) {
      switch(FunctionTypeCellRenderer$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EFunctionType[var0.ordinal()]) {
      case 1:
         return Colors.GRAY250;
      case 2:
         return Colors.FUNCTION_TYPE_LIBRARY;
      case 3:
         return Colors.FUNCTION_TYPE_THUNK;
      case 4:
         return Colors.FUNCTION_TYPE_IMPORTED;
      case 5:
         return Colors.GRAY250;
      default:
         return Colors.GRAY160;
      }
   }

   public Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6) {
      this.buildAndSetToolTip(var1, var5);
      this.setFont(!this.isBoldFont(var1, var5)?NORMAL_FONT:BOLD_FONT);
      if(var2 instanceof EFunctionType) {
         boolean var7 = !var2.toString().equals(EFunctionType.UNKNOWN.toString());
         this.setIcon(new BackgroundIcon(var7?var2.toString():NOT_ACCESSABLE_TEXT, 0, Colors.GRAY32, var7?calcColor((EFunctionType)var2):NOT_ACCESSABLE_COLOR, var1.getSelectionBackground(), var3, -1, 0, var1.getColumnModel().getColumn(var6).getWidth() - 1, var1.getRowHeight() - 1));
      }

      return this;
   }
}
