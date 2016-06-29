package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ResetDefaultPerspectiveAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ToggleGraphsPerspectiveAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.TogglePrimaryPerspectiveAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ToggleSecondaryPerspectiveAction;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class WindowMenu extends JMenu {
   private JMenuItem togglePrimaryPerspective;
   private JMenuItem toggleSecondaryPerspective;
   private JMenuItem toogleGraphsPerspective;
   private JMenuItem resetDefaultPerspective;

   public WindowMenu(ViewTabPanelFunctions var1) {
      super("Window");
      this.setMnemonic('W');
      Preconditions.checkNotNull(var1);
      this.togglePrimaryPerspective = GuiUtils.buildMenuItem("Show/Hide Primary", 'P', 120, 0, new TogglePrimaryPerspectiveAction(var1));
      this.toggleSecondaryPerspective = GuiUtils.buildMenuItem("Show/Hide Secondary", 'S', 121, 0, new ToggleSecondaryPerspectiveAction(var1));
      this.toogleGraphsPerspective = GuiUtils.buildMenuItem("Show/Hide Overviews", 'G', 122, 0, new ToggleGraphsPerspectiveAction(var1));
      this.resetDefaultPerspective = GuiUtils.buildMenuItem("Reset Window Layout", 'R', 123, 0, new ResetDefaultPerspectiveAction(var1));
      this.add(this.togglePrimaryPerspective);
      this.add(this.toggleSecondaryPerspective);
      this.add(this.toogleGraphsPerspective);
      this.add(new JSeparator());
      this.add(this.resetDefaultPerspective);
   }

   public void dispose() {
      this.togglePrimaryPerspective = null;
      this.toggleSecondaryPerspective = null;
      this.toogleGraphsPerspective = null;
      this.resetDefaultPerspective = null;
   }
}
