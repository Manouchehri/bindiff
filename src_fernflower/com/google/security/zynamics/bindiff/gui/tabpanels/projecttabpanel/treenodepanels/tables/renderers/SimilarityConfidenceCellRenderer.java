package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.BackgroundIcon;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.AbstractTableCellRenderer;
import com.google.security.zynamics.bindiff.resources.Colors;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;

public class SimilarityConfidenceCellRenderer extends AbstractTableCellRenderer {
   public static Color calcColor(double var0) {
      return var0 >= 0.0D && var0 <= 1.0D?Color.getHSBColor(0.31F * (float)var0, 0.3F, 0.9F):Colors.GRAY192;
   }

   public Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6) {
      this.buildAndSetToolTip(var1, var5);
      this.setFont(!this.isBoldFont(var1, var5)?NORMAL_FONT:BOLD_FONT);
      if(var2 instanceof Double) {
         double var7 = ((Double)var2).doubleValue();
         this.setIcon(new BackgroundIcon(var7 == -1.0D?NOT_ACCESSABLE_TEXT:String.format("%.2f", new Object[]{Double.valueOf(var7)}), 0, Colors.GRAY32, var7 == -1.0D?NOT_ACCESSABLE_COLOR:calcColor(((Double)var2).doubleValue()), var1.getSelectionBackground(), var3, -1, 0, var1.getColumnModel().getColumn(var6).getWidth() - 1, var1.getRowHeight() - 1));
      }

      return this;
   }
}
