package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.menubar.HelpMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.GraphsMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.ModesMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.SearchMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.SelectionMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.ViewMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.WindowMenu;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;

public class ViewMenuBar extends JMenuBar {
   private final JMenu viewMenu;
   private final JMenu modeMenu;
   private final JMenu graphsMenu;
   private final JMenu selectionMenu;
   private final JMenu searchMenu;
   private final JMenu windowMenu;
   private final JMenu helpMenu;

   public ViewMenuBar(ViewTabPanelFunctions var1) {
      this.viewMenu = new ViewMenu(var1);
      this.modeMenu = new ModesMenu(var1);
      this.graphsMenu = new GraphsMenu(var1);
      this.selectionMenu = new SelectionMenu(var1);
      this.searchMenu = new SearchMenu(var1);
      this.windowMenu = new WindowMenu(var1);
      this.helpMenu = new HelpMenu(var1);
      this.add(this.viewMenu);
      this.add(this.modeMenu);
      this.add(this.graphsMenu);
      this.add(this.selectionMenu);
      this.add(this.searchMenu);
      this.add(this.windowMenu);
      this.add(this.helpMenu);
      this.removeKeyBindings();
   }

   private void removeKeyBindings() {
      InputMap var1 = this.getInputMap(2);
      if(var1 != null) {
         Object var2 = var1.get(KeyStroke.getKeyStroke("F10"));
         ActionMap var3 = this.getActionMap();
         if(var3 != null && var3.getParent() != null) {
            var3.getParent().remove(var2);
         }
      }
   }

   public void dispose() {
      ((ViewMenu)this.viewMenu).dispose();
      ((ModesMenu)this.modeMenu).dispose();
      ((GraphsMenu)this.graphsMenu).dispose();
      ((SelectionMenu)this.selectionMenu).dispose();
      ((SearchMenu)this.searchMenu).dispose();
      ((WindowMenu)this.windowMenu).dispose();
   }
}
