package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarIcon;
import com.google.security.zynamics.bindiff.resources.Colors;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class PercentageTwoBarLabel extends JLabel {
   private final PercentageTwoBarIcon matchBarIcon;

   public PercentageTwoBarLabel(PercentageTwoBarCellData var1, Color var2, Color var3, int var4) {
      this.matchBarIcon = new PercentageTwoBarIcon(var1, var2, var3, Colors.GRAY160, Colors.GRAY32, Colors.GRAY32, Colors.GRAY32, Colors.GRAY32, false, -2, 0, 1, var4 - 1);
      this.matchBarIcon.showAdditionalPercetageValues(true);
      this.setIcon(this.matchBarIcon);
      this.setBorder(new LineBorder(Color.black));
   }

   public void paint(Graphics var1) {
      this.matchBarIcon.setWidth(this.getWidth() + 1);
      super.paint(var1);
   }

   public void updateData(int var1, int var2) {
      this.matchBarIcon.updateData(var1, var2);
      this.updateUI();
   }
}
