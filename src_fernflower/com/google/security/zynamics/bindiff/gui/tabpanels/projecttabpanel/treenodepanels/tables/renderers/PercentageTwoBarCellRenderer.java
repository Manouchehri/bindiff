package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarIcon;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.AbstractTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;

public class PercentageTwoBarCellRenderer extends AbstractTableCellRenderer {
   private final Color leftBarColor;
   private final Color rightBarColor;
   private final Color emptyBarColor;
   private final Color leftTextColor;
   private final Color totalTextColor;
   private final Color rightTextColor;

   public PercentageTwoBarCellRenderer(Color var1, Color var2, Color var3, Color var4, Color var5, Color var6) {
      this.leftBarColor = var1;
      this.rightBarColor = var2;
      this.emptyBarColor = var3;
      this.leftTextColor = var4;
      this.totalTextColor = var5;
      this.rightTextColor = var6;
   }

   public Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6) {
      this.buildAndSetToolTip(var1, var5);
      this.setFont(!this.isBoldFont(var1, var5)?NORMAL_FONT:BOLD_FONT);
      if(var2 instanceof PercentageTwoBarCellData) {
         this.setIcon(new PercentageTwoBarIcon((PercentageTwoBarCellData)var2, this.leftBarColor, this.rightBarColor, this.emptyBarColor, this.leftTextColor, this.totalTextColor, this.rightTextColor, var1.getSelectionBackground(), var3, -1, 0, var1.getColumnModel().getColumn(var6).getWidth() - 2, var1.getRowHeight() - 2));
      }

      return this;
   }
}
