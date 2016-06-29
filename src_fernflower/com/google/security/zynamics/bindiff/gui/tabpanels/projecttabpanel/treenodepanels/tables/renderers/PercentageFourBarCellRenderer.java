package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageThreeBarExtendedBarIcon;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageThreeBarExtendedCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.AbstractTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;

public class PercentageFourBarCellRenderer extends AbstractTableCellRenderer {
   private final Color leftBarColor;
   private final Color centerLeftBarColor;
   private final Color centerRightBarColor;
   private final Color rightBarColor;
   private final Color emptyBarColor;
   private final Color textColor;

   public PercentageFourBarCellRenderer(Color var1, Color var2, Color var3, Color var4, Color var5, Color var6) {
      this.leftBarColor = var1;
      this.centerLeftBarColor = var2;
      this.centerRightBarColor = var3;
      this.rightBarColor = var4;
      this.emptyBarColor = var5;
      this.textColor = var6;
   }

   public Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6) {
      this.buildAndSetToolTip(var1, var5);
      this.setFont(!this.isBoldFont(var1, var5)?NORMAL_FONT:BOLD_FONT);
      if(var2 instanceof PercentageThreeBarExtendedCellData) {
         this.setIcon(new PercentageThreeBarExtendedBarIcon((PercentageThreeBarExtendedCellData)var2, this.leftBarColor, this.centerLeftBarColor, this.centerRightBarColor, this.rightBarColor, this.emptyBarColor, this.textColor, var1.getSelectionBackground(), var3, -1, 0, var1.getColumnModel().getColumn(var6).getWidth() - 2, var1.getRowHeight() - 2));
      }

      return this;
   }
}
