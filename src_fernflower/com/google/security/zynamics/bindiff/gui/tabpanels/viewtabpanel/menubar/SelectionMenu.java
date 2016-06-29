package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ColorInvisibleNodeAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ColorSelectedNodesAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ColorUnselectedNodesAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.DeselectLeafsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.DeselectPeripheryAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.DeselectRootsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.InverseSelectionAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.RedoLastSelectionAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ResetDefaultNodeColorsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.SelectAncestorsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.SelectByCriteriaAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.SelectChildrenAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.SelectNeighboursAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.SelectParentsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.SelectSuccessorsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.UndoLastSelectionAction;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.Toolkit;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class SelectionMenu extends JMenu {
   private JMenuItem undoLastSelection;
   private JMenuItem redoLastSelection;
   private JMenuItem selectAncestors;
   private JMenuItem selectSuccessors;
   private JMenuItem inverseSelection;
   private JMenuItem selectParents;
   private JMenuItem selectChildren;
   private JMenuItem selectNeighbours;
   private JMenuItem deselectRoots;
   private JMenuItem deselectLeafs;
   private JMenuItem deselectPeriphery;
   private JMenuItem selectByCriteria;
   private JMenuItem colorSelectedNodes;
   private JMenuItem colorUnselectedNodes;
   private JMenuItem colorInvisibleNodes;
   private JMenuItem resetDefaultNodeColors;

   public SelectionMenu(ViewTabPanelFunctions var1) {
      super("Selection");
      this.setMnemonic('S');
      int var2 = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
      Preconditions.checkNotNull(var1);
      this.undoLastSelection = GuiUtils.buildMenuItem("Undo Selection", 'U', 90, var2, new UndoLastSelectionAction(var1));
      this.redoLastSelection = GuiUtils.buildMenuItem("Redo Selection", 'R', 89, var2, new RedoLastSelectionAction(var1));
      this.selectAncestors = GuiUtils.buildMenuItem("Select Ancestors", 'A', new SelectAncestorsAction(var1));
      this.selectSuccessors = GuiUtils.buildMenuItem("Select Successors", 'S', new SelectSuccessorsAction(var1));
      this.inverseSelection = GuiUtils.buildMenuItem("Invert Selection", 'I', 73, var2 | 64, new InverseSelectionAction(var1));
      this.selectNeighbours = GuiUtils.buildMenuItem("Select Neighbors", 'N', new SelectNeighboursAction(var1));
      this.deselectPeriphery = GuiUtils.buildMenuItem("Deselect Periphery", 'D', new DeselectPeripheryAction(var1));
      this.selectParents = GuiUtils.buildMenuItem("Select Parents", 'P', new SelectParentsAction(var1));
      this.selectChildren = GuiUtils.buildMenuItem("Select Children", 'C', new SelectChildrenAction(var1));
      this.deselectRoots = GuiUtils.buildMenuItem("Deselect Roots", 'R', new DeselectRootsAction(var1));
      this.deselectLeafs = GuiUtils.buildMenuItem("Deselect Leafs", 'L', new DeselectLeafsAction(var1));
      this.selectByCriteria = GuiUtils.buildMenuItem("Select by Criteria...", 'I', 114, 0, new SelectByCriteriaAction(var1));
      this.colorSelectedNodes = GuiUtils.buildMenuItem("Color selected Nodes", 'S', new ColorSelectedNodesAction(var1));
      this.colorUnselectedNodes = GuiUtils.buildMenuItem("Color unselected Nodes", 'U', new ColorUnselectedNodesAction(var1));
      this.colorInvisibleNodes = GuiUtils.buildMenuItem("Color invisible Nodes", 'N', new ColorInvisibleNodeAction(var1));
      this.resetDefaultNodeColors = GuiUtils.buildMenuItem("Reset default Node Colors", 'R', new ResetDefaultNodeColorsAction(var1));
      this.add(this.undoLastSelection);
      this.add(this.redoLastSelection);
      this.add(new JSeparator());
      this.add(this.selectAncestors);
      this.add(this.selectSuccessors);
      this.add(this.inverseSelection);
      this.add(new JSeparator());
      this.add(this.selectNeighbours);
      this.add(this.deselectPeriphery);
      this.add(new JSeparator());
      this.add(this.selectParents);
      this.add(this.selectChildren);
      this.add(this.deselectRoots);
      this.add(this.deselectLeafs);
      this.add(new JSeparator());
      this.add(this.selectByCriteria);
      this.add(new JSeparator());
      this.add(this.colorSelectedNodes);
      this.add(this.colorUnselectedNodes);
      this.add(this.colorInvisibleNodes);
      this.add(this.resetDefaultNodeColors);
   }

   public void dispose() {
      this.undoLastSelection = null;
      this.redoLastSelection = null;
      this.selectAncestors = null;
      this.selectSuccessors = null;
      this.inverseSelection = null;
      this.selectParents = null;
      this.selectChildren = null;
      this.selectNeighbours = null;
      this.deselectRoots = null;
      this.deselectLeafs = null;
      this.deselectPeriphery = null;
      this.selectByCriteria = null;
      this.colorSelectedNodes = null;
      this.colorUnselectedNodes = null;
      this.colorInvisibleNodes = null;
      this.resetDefaultNodeColors = null;
   }
}
