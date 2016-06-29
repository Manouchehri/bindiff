package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import java.util.*;
import com.google.security.zynamics.bindiff.enums.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.utils.*;

public class SelectionHistoryTreeGroupNode extends AbstractSelectionHistoryTreeNode
{
    private static final Icon ICON_ALL_UNSELECTED_GRAPHNODES;
    private static final Icon ICON_ALL_SELECTED_GRAPHNODES;
    private static final Icon ICON_ALL_UNVISIBLE_GRAPHNODES;
    private static final Icon ICON_ALL_UNSELECTED_SOME_VISIBLE_SOME_INVISIBLE_GRAPHNODES;
    private static final Icon ICON_ALL_VISIBLE_SOME_SELECTED_SOME_UNSELECTED_GRAPHNODES;
    private static final Icon ICON_SOME_SELECTED_SOME_VISIBLE_SOME_INVISIBLE_GRAPHNODES;
    private static final Icon ICON_EMPTY_FOLDER;
    private static final Icon ICON_DUMMY;
    private final ISnapshotListener snapshotListener;
    private final SelectionSnapshot snapshot;
    private final int snapshotCount;
    
    public SelectionHistoryTreeGroupNode(final SelectionSnapshot snapshot, final int snapshotCount) {
        super(new SelectionHistoryTreeNodeWrapper(snapshot, snapshotCount).toString());
        this.snapshotListener = new SelectionHistoryTreeGroupNode$InternalSnapshotListener(this, null);
        (this.snapshot = snapshot).addListener(this.snapshotListener);
        this.snapshotCount = snapshotCount;
    }
    
    public void dispose() {
        this.snapshot.removeListener(this.snapshotListener);
    }
    
    @Override
    public Icon getIcon() {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        for (final ZyGraphNode zyGraphNode : this.snapshot.getSelection()) {
            if (zyGraphNode.isSelected()) {
                ++n2;
            }
            else {
                ++n3;
            }
            if (!zyGraphNode.isVisible()) {
                ++n4;
            }
            ++n;
        }
        if (n == 0) {
            return SelectionHistoryTreeGroupNode.ICON_EMPTY_FOLDER;
        }
        if (n4 == n) {
            return SelectionHistoryTreeGroupNode.ICON_ALL_UNVISIBLE_GRAPHNODES;
        }
        if (n2 == n) {
            return SelectionHistoryTreeGroupNode.ICON_ALL_SELECTED_GRAPHNODES;
        }
        if (n3 == n && n4 == 0) {
            return SelectionHistoryTreeGroupNode.ICON_ALL_UNSELECTED_GRAPHNODES;
        }
        if (n2 == 0) {
            return SelectionHistoryTreeGroupNode.ICON_ALL_UNSELECTED_SOME_VISIBLE_SOME_INVISIBLE_GRAPHNODES;
        }
        if (n4 == 0) {
            return SelectionHistoryTreeGroupNode.ICON_ALL_VISIBLE_SOME_SELECTED_SOME_UNSELECTED_GRAPHNODES;
        }
        if (n4 != 0 && n2 != 0) {
            return SelectionHistoryTreeGroupNode.ICON_SOME_SELECTED_SOME_VISIBLE_SOME_INVISIBLE_GRAPHNODES;
        }
        return SelectionHistoryTreeGroupNode.ICON_DUMMY;
    }
    
    @Override
    public JPopupMenu getPopupMenu() {
        final JPopupMenu popupMenu = new JPopupMenu();
        final BinDiffGraph graph = this.getRootNode().getGraph();
        if (graph instanceof SingleGraph) {
            if (graph.getGraphType() == EGraphType.CALLGRAPH) {
                final JMenuItem menuItem = new JMenuItem(new SelectionHistoryTreeGroupNode$1(this, "Copy Function Addresses"));
                final JMenuItem menuItem2 = new JMenuItem(new SelectionHistoryTreeGroupNode$2(this, "Copy Function Names"));
                popupMenu.add(menuItem);
                popupMenu.add(menuItem2);
            }
            else if (graph.getGraphType() == EGraphType.FLOWGRAPH) {
                popupMenu.add(new JMenuItem(new SelectionHistoryTreeGroupNode$3(this, "Copy Basic Block Addresses")));
            }
        }
        else if (this.getRootNode().getGraph() instanceof CombinedGraph) {
            if (graph.getGraphType() == EGraphType.CALLGRAPH) {
                final JMenuItem menuItem3 = new JMenuItem(new SelectionHistoryTreeGroupNode$4(this, "Copy Primary Function Addresses"));
                final JMenuItem menuItem4 = new JMenuItem(new SelectionHistoryTreeGroupNode$5(this, "Copy Secondary Function Addresses"));
                final JMenuItem menuItem5 = new JMenuItem(new SelectionHistoryTreeGroupNode$6(this, "Copy Primary Function Names"));
                final JMenuItem menuItem6 = new JMenuItem(new SelectionHistoryTreeGroupNode$7(this, "Copy Secondary Function Names"));
                popupMenu.add(menuItem3);
                popupMenu.add(menuItem5);
                popupMenu.add(menuItem4);
                popupMenu.add(menuItem6);
            }
            else if (graph.getGraphType() == EGraphType.FLOWGRAPH) {
                final JMenuItem menuItem7 = new JMenuItem(new SelectionHistoryTreeGroupNode$8(this, "Copy Primary Basic Block Addresses"));
                final JMenuItem menuItem8 = new JMenuItem(new SelectionHistoryTreeGroupNode$9(this, "Copy Secondary Basic Block Addresses"));
                popupMenu.add(menuItem7);
                popupMenu.add(menuItem8);
            }
        }
        return popupMenu;
    }
    
    public SelectionSnapshot getSnapshot() {
        return this.snapshot;
    }
    
    static {
        ICON_ALL_UNSELECTED_GRAPHNODES = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-all-unselected.png");
        ICON_ALL_SELECTED_GRAPHNODES = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-open.png");
        ICON_ALL_UNVISIBLE_GRAPHNODES = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-all-unselected-gray.png");
        ICON_ALL_UNSELECTED_SOME_VISIBLE_SOME_INVISIBLE_GRAPHNODES = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-all-unselected-halfgray.png");
        ICON_ALL_VISIBLE_SOME_SELECTED_SOME_UNSELECTED_GRAPHNODES = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-some-unselected.png");
        ICON_SOME_SELECTED_SOME_VISIBLE_SOME_INVISIBLE_GRAPHNODES = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-some-unselected-halfgray.png");
        ICON_EMPTY_FOLDER = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-empty.png");
        ICON_DUMMY = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-closed.png");
    }
}
