package com.google.security.zynamics.bindiff.gui.tabpanels.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.menubar.HelpMenu$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.menubar.HelpMenu$2;
import com.google.security.zynamics.bindiff.gui.tabpanels.menubar.HelpMenu$3;
import com.google.security.zynamics.bindiff.gui.tabpanels.menubar.HelpMenu$4;
import com.google.security.zynamics.bindiff.gui.tabpanels.menubar.HelpMenu$5;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class HelpMenu extends JMenu {
   public HelpMenu(TabPanelFunctions var1) {
      super("Help");
      this.setMnemonic('H');
      JMenuItem var2 = GuiUtils.buildMenuItem("Help Contents", 'H', 112, 0, new HelpMenu$1(this, var1));
      JMenuItem var3 = GuiUtils.buildMenuItem("Report a Bug", 'R', new HelpMenu$2(this, var1));
      JMenuItem var4 = GuiUtils.buildMenuItem("Show License Information...", 'L', new HelpMenu$3(this, var1));
      JMenuItem var5 = GuiUtils.buildMenuItem("Check for Updates...", 'U', new HelpMenu$4(this, var1));
      JMenuItem var6 = GuiUtils.buildMenuItem("About", 'A', new HelpMenu$5(this, var1));
      this.add(var2);
      this.add(new JSeparator());
      this.add(var3);
      this.add(new JSeparator());
      this.add(var4);
      this.add(var5);
      this.add(new JSeparator());
      this.add(var6);
   }
}
