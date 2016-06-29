package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.*;
import javax.swing.*;
import java.awt.*;

public class SelectionMenu extends JMenu
{
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
    
    public SelectionMenu(final ViewTabPanelFunctions viewTabPanelFunctions) {
        super("Selection");
        this.setMnemonic('S');
        final int menuShortcutKeyMask = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        Preconditions.checkNotNull(viewTabPanelFunctions);
        this.undoLastSelection = GuiUtils.buildMenuItem("Undo Selection", 'U', 90, menuShortcutKeyMask, new UndoLastSelectionAction(viewTabPanelFunctions));
        this.redoLastSelection = GuiUtils.buildMenuItem("Redo Selection", 'R', 89, menuShortcutKeyMask, new RedoLastSelectionAction(viewTabPanelFunctions));
        this.selectAncestors = GuiUtils.buildMenuItem("Select Ancestors", 'A', new SelectAncestorsAction(viewTabPanelFunctions));
        this.selectSuccessors = GuiUtils.buildMenuItem("Select Successors", 'S', new SelectSuccessorsAction(viewTabPanelFunctions));
        this.inverseSelection = GuiUtils.buildMenuItem("Invert Selection", 'I', 73, menuShortcutKeyMask | 0x40, new InverseSelectionAction(viewTabPanelFunctions));
        this.selectNeighbours = GuiUtils.buildMenuItem("Select Neighbors", 'N', new SelectNeighboursAction(viewTabPanelFunctions));
        this.deselectPeriphery = GuiUtils.buildMenuItem("Deselect Periphery", 'D', new DeselectPeripheryAction(viewTabPanelFunctions));
        this.selectParents = GuiUtils.buildMenuItem("Select Parents", 'P', new SelectParentsAction(viewTabPanelFunctions));
        this.selectChildren = GuiUtils.buildMenuItem("Select Children", 'C', new SelectChildrenAction(viewTabPanelFunctions));
        this.deselectRoots = GuiUtils.buildMenuItem("Deselect Roots", 'R', new DeselectRootsAction(viewTabPanelFunctions));
        this.deselectLeafs = GuiUtils.buildMenuItem("Deselect Leafs", 'L', new DeselectLeafsAction(viewTabPanelFunctions));
        this.selectByCriteria = GuiUtils.buildMenuItem("Select by Criteria...", 'I', 114, 0, new SelectByCriteriaAction(viewTabPanelFunctions));
        this.colorSelectedNodes = GuiUtils.buildMenuItem("Color selected Nodes", 'S', new ColorSelectedNodesAction(viewTabPanelFunctions));
        this.colorUnselectedNodes = GuiUtils.buildMenuItem("Color unselected Nodes", 'U', new ColorUnselectedNodesAction(viewTabPanelFunctions));
        this.colorInvisibleNodes = GuiUtils.buildMenuItem("Color invisible Nodes", 'N', new ColorInvisibleNodeAction(viewTabPanelFunctions));
        this.resetDefaultNodeColors = GuiUtils.buildMenuItem("Reset default Node Colors", 'R', new ResetDefaultNodeColorsAction(viewTabPanelFunctions));
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
