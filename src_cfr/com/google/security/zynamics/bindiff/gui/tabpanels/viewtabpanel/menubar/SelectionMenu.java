/*
 * Decompiled with CFR 0_115.
 */
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
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class SelectionMenu
extends JMenu {
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

    public SelectionMenu(ViewTabPanelFunctions viewTabPanelFunctions) {
        super("Selection");
        this.setMnemonic('S');
        int n2 = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        Preconditions.checkNotNull(viewTabPanelFunctions);
        this.undoLastSelection = GuiUtils.buildMenuItem("Undo Selection", 'U', 90, n2, new UndoLastSelectionAction(viewTabPanelFunctions));
        this.redoLastSelection = GuiUtils.buildMenuItem("Redo Selection", 'R', 89, n2, new RedoLastSelectionAction(viewTabPanelFunctions));
        this.selectAncestors = GuiUtils.buildMenuItem("Select Ancestors", 'A', (AbstractAction)new SelectAncestorsAction(viewTabPanelFunctions));
        this.selectSuccessors = GuiUtils.buildMenuItem("Select Successors", 'S', (AbstractAction)new SelectSuccessorsAction(viewTabPanelFunctions));
        this.inverseSelection = GuiUtils.buildMenuItem("Invert Selection", 'I', 73, n2 | 64, new InverseSelectionAction(viewTabPanelFunctions));
        this.selectNeighbours = GuiUtils.buildMenuItem("Select Neighbors", 'N', (AbstractAction)new SelectNeighboursAction(viewTabPanelFunctions));
        this.deselectPeriphery = GuiUtils.buildMenuItem("Deselect Periphery", 'D', (AbstractAction)new DeselectPeripheryAction(viewTabPanelFunctions));
        this.selectParents = GuiUtils.buildMenuItem("Select Parents", 'P', (AbstractAction)new SelectParentsAction(viewTabPanelFunctions));
        this.selectChildren = GuiUtils.buildMenuItem("Select Children", 'C', (AbstractAction)new SelectChildrenAction(viewTabPanelFunctions));
        this.deselectRoots = GuiUtils.buildMenuItem("Deselect Roots", 'R', (AbstractAction)new DeselectRootsAction(viewTabPanelFunctions));
        this.deselectLeafs = GuiUtils.buildMenuItem("Deselect Leafs", 'L', (AbstractAction)new DeselectLeafsAction(viewTabPanelFunctions));
        this.selectByCriteria = GuiUtils.buildMenuItem("Select by Criteria...", 'I', 114, 0, new SelectByCriteriaAction(viewTabPanelFunctions));
        this.colorSelectedNodes = GuiUtils.buildMenuItem("Color selected Nodes", 'S', (AbstractAction)new ColorSelectedNodesAction(viewTabPanelFunctions));
        this.colorUnselectedNodes = GuiUtils.buildMenuItem("Color unselected Nodes", 'U', (AbstractAction)new ColorUnselectedNodesAction(viewTabPanelFunctions));
        this.colorInvisibleNodes = GuiUtils.buildMenuItem("Color invisible Nodes", 'N', (AbstractAction)new ColorInvisibleNodeAction(viewTabPanelFunctions));
        this.resetDefaultNodeColors = GuiUtils.buildMenuItem("Reset default Node Colors", 'R', (AbstractAction)new ResetDefaultNodeColorsAction(viewTabPanelFunctions));
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

