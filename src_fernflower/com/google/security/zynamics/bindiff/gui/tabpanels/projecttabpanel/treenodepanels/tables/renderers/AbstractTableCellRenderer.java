package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewManager;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public abstract class AbstractTableCellRenderer extends DefaultTableCellRenderer {
   public static Color NOT_ACCESSABLE_COLOR;
   public static String NOT_ACCESSABLE_TEXT;
   protected static Font NORMAL_FONT;
   protected static Font BOLD_FONT;

   protected boolean isBoldFont(JTable var1, int var2) {
      if(!(var1 instanceof AbstractTable)) {
         return false;
      } else {
         AbstractTable var3 = (AbstractTable)var1;
         Diff var4 = var3.getTableModel().getDiff();
         if(var4 != null) {
            ViewManager var7 = var4.getViewManager();
            Pair var6 = AbstractTable.getViewAddressPair((AbstractTable)var1, var2);
            return var7.containsView((IAddress)var6.first(), (IAddress)var6.second());
         } else {
            Diff var5 = AbstractTable.getRowDiff(var3, var2);
            return var5 != null && var5.getViewManager().getFlowgraphViewsData().size() > 0;
         }
      }
   }

   public void buildAndSetToolTip(JTable var1, int var2) {
      if(var1 instanceof AbstractTable) {
         AbstractTable var3 = (AbstractTable)var1;
         Diff var4 = var3.getDiff();
         this.setToolTipText(var3.getToolTipForRow(var4, var2));
      }
   }

   public abstract Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6);

   static {
      NOT_ACCESSABLE_COLOR = Colors.GRAY250;
      NOT_ACCESSABLE_TEXT = "";
      NORMAL_FONT = GuiHelper.DEFAULT_FONT;
      BOLD_FONT = new Font(NORMAL_FONT.getName(), 1, NORMAL_FONT.getSize());
   }
}
