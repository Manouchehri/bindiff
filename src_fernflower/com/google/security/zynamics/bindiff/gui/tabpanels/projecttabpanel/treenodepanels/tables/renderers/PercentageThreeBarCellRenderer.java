package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageThreeBarCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageThreeBarIcon;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.AbstractTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;

public class PercentageThreeBarCellRenderer extends AbstractTableCellRenderer {
   private final Color leftBarColor;
   private final Color centerBarColor;
   private final Color rightBarColor;
   private final Color emptyBarColor;
   private final Color textColor;

   public PercentageThreeBarCellRenderer(Color var1, Color var2, Color var3, Color var4, Color var5) {
      this.leftBarColor = var1;
      this.centerBarColor = var2;
      this.rightBarColor = var3;
      this.emptyBarColor = var4;
      this.textColor = var5;
   }

   public Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6) {
      this.buildAndSetToolTip(var1, var5);
      this.setFont(!this.isBoldFont(var1, var5)?NORMAL_FONT:BOLD_FONT);
      if(var2 instanceof PercentageThreeBarCellData) {
         this.setIcon(new PercentageThreeBarIcon((PercentageThreeBarCellData)var2, this.leftBarColor, this.centerBarColor, this.rightBarColor, this.emptyBarColor, this.textColor, var1.getSelectionBackground(), var3, -1, 0, var1.getColumnModel().getColumn(var6).getWidth() - 2, var1.getRowHeight() - 2));
      }

      return this;
   }
}
