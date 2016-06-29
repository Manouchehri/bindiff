package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.JumpToAddressAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.SearchAction;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.Toolkit;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class SearchMenu extends JMenu {
   private JMenuItem jumpToPrimaryAddress;
   private JMenuItem jumpToSecondaryAddress;
   private JMenuItem search;

   public SearchMenu(ViewTabPanelFunctions var1) {
      super("Search");
      this.setMnemonic('A');
      int var2 = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
      Preconditions.checkNotNull(var1);
      this.jumpToPrimaryAddress = GuiUtils.buildMenuItem("Jump to Primary Address", 'P', 74, var2, new JumpToAddressAction(var1, ESide.PRIMARY));
      this.jumpToSecondaryAddress = GuiUtils.buildMenuItem("Jump to Secondary Address", 'S', 74, var2 | 64, new JumpToAddressAction(var1, ESide.SECONDARY));
      this.search = GuiUtils.buildMenuItem("Search", 'S', 70, var2, new SearchAction(var1));
      this.add(this.search);
      this.add(new JSeparator());
      this.add(this.jumpToPrimaryAddress);
      this.add(this.jumpToSecondaryAddress);
   }

   public void dispose() {
      this.jumpToPrimaryAddress = null;
      this.jumpToSecondaryAddress = null;
      this.search = null;
   }
}
