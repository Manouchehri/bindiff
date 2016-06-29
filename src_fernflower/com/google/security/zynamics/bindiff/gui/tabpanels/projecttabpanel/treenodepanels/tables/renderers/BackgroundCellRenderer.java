package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.BackgroundIcon;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.AbstractTableCellRenderer;
import com.google.security.zynamics.zylib.date.DateHelpers;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JTable;

public class BackgroundCellRenderer extends AbstractTableCellRenderer {
   final Color backgroundColor;
   final Color textColor;
   final int horizontalAlignment;
   boolean isNotAccessable = false;

   public BackgroundCellRenderer(Color var1, Color var2, int var3) {
      this.backgroundColor = var1;
      this.textColor = var2;
      this.horizontalAlignment = var3;
   }

   public Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6) {
      this.buildAndSetToolTip(var1, var5);
      this.setFont(!this.isBoldFont(var1, var5)?NORMAL_FONT:BOLD_FONT);
      String var7;
      if(var2 instanceof String) {
         var7 = (String)var2;
         this.isNotAccessable = var7.equals("");
      } else if(var2 instanceof Double) {
         var7 = Double.toString(((Double)var2).doubleValue());
         this.isNotAccessable = ((Double)var2).doubleValue() == -1.0D;
      } else if(var2 instanceof Integer) {
         var7 = Integer.toString(((Integer)var2).intValue());
      } else if(var2 instanceof IAddress) {
         var7 = ((IAddress)var2).toHexString();
      } else {
         if(!(var2 instanceof Date)) {
            throw new IllegalArgumentException(String.format("Value must be a String, IAddress, Double Integer or Date. (%s)", new Object[]{var2.getClass().toString()}));
         }

         var7 = DateHelpers.formatDateTime((Date)var2);
      }

      this.setIcon(new BackgroundIcon(this.isNotAccessable?NOT_ACCESSABLE_TEXT:var7, this.horizontalAlignment, this.textColor, this.isNotAccessable?NOT_ACCESSABLE_COLOR:this.backgroundColor, var1.getSelectionBackground(), var3, -1, 0, var1.getColumnModel().getColumn(var6).getWidth() - 1, var1.getRowHeight() - 1));
      return this;
   }
}
