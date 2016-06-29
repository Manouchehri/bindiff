package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.CloseViewAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ExportViewAsImageAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.PrintViewAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.SaveViewAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.ViewMenu$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.ViewMenu$InternalViewListener;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.Toolkit;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class ViewMenu extends JMenu {
   private final ViewMenu$InternalViewListener viewListener = new ViewMenu$InternalViewListener(this, (ViewMenu$1)null);
   private ViewTabPanelFunctions viewTabPanelController;
   private JMenuItem saveView;
   private JMenuItem printPrimaryGraph;
   private JMenuItem printSecondaryGraph;
   private JMenuItem printCombinedGraph;
   private JMenuItem exportViewAsPng;
   private JMenuItem closeView;

   public ViewMenu(ViewTabPanelFunctions var1) {
      super("View");
      this.setMnemonic('V');
      this.viewTabPanelController = (ViewTabPanelFunctions)Preconditions.checkNotNull(var1);
      Diff var2 = var1.getGraphs().getDiff();
      int var3 = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
      this.saveView = GuiUtils.buildMenuItem("Save View", 'S', 83, var3, new SaveViewAction(var1));
      this.printPrimaryGraph = GuiUtils.buildMenuItem("Print Primary Graph...", 'P', new PrintViewAction(var1, var1.getGraphs().getPrimaryGraph()));
      this.printSecondaryGraph = GuiUtils.buildMenuItem("Print Secondary Graph...", 'S', new PrintViewAction(var1, var1.getGraphs().getSecondaryGraph()));
      this.printCombinedGraph = GuiUtils.buildMenuItem("Print Combined Graph...", 'C', new PrintViewAction(var1, var1.getGraphs().getCombinedGraph()));
      this.exportViewAsPng = GuiUtils.buildMenuItem("Export View as Image...", 'E', new ExportViewAsImageAction(var1));
      this.closeView = GuiUtils.buildMenuItem("Close View", 'C', new CloseViewAction(var1));
      this.saveView.setEnabled(var2.isFunctionDiff());
      this.add(this.saveView);
      this.add(new JSeparator());
      this.add(this.printPrimaryGraph);
      this.add(this.printSecondaryGraph);
      this.add(this.printCombinedGraph);
      this.add(new JSeparator());
      this.add(this.exportViewAsPng);
      this.add(new JSeparator());
      this.add(this.closeView);
      this.viewTabPanelController.addListener(this.viewListener);
   }

   public void dispose() {
      this.viewTabPanelController.removeListener(this.viewListener);
      this.viewTabPanelController = null;
      this.saveView = null;
      this.printPrimaryGraph = null;
      this.printSecondaryGraph = null;
      this.printCombinedGraph = null;
      this.exportViewAsPng = null;
      this.closeView = null;
   }

   // $FF: synthetic method
   static ViewTabPanelFunctions access$100(ViewMenu var0) {
      return var0.viewTabPanelController;
   }

   // $FF: synthetic method
   static JMenuItem access$200(ViewMenu var0) {
      return var0.saveView;
   }
}
