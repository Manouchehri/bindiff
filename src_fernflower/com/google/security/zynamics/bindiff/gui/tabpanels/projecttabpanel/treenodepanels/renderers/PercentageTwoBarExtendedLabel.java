package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarExtendedCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarExtendedIcon;
import com.google.security.zynamics.bindiff.resources.Colors;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class PercentageTwoBarExtendedLabel extends JLabel {
   private final PercentageTwoBarExtendedIcon matchBarIcon;

   public PercentageTwoBarExtendedLabel(PercentageTwoBarExtendedCellData var1, Color var2, Color var3, Color var4, int var5) {
      this.matchBarIcon = new PercentageTwoBarExtendedIcon(var1, var2, var3, var4, Colors.GRAY160, Colors.GRAY32, -2, 0, 1, var5 - 1);
      this.setIcon(this.matchBarIcon);
      this.setBorder(new LineBorder(Color.black));
   }

   public void paint(Graphics var1) {
      this.matchBarIcon.setWidth(this.getWidth() + 1);
      super.paint(var1);
   }

   public void updateData(int var1, int var2, int var3) {
      this.matchBarIcon.updateData(var1, var2, var3);
      this.updateUI();
   }
}
