package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.AbstractTableCellRenderer;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JTable;

public class IconCellRenderer extends AbstractTableCellRenderer {
   public Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6) {
      Preconditions.checkArgument(var2 instanceof Icon, "Value must be an Icon.");
      this.setHorizontalAlignment(0);
      this.setIcon((Icon)var2);
      return this;
   }
}
