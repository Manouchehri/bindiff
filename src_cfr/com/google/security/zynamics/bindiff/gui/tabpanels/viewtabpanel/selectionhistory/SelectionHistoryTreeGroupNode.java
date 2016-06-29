/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.AbstractSelectionHistoryTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.ISnapshotListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryRootNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$2;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$3;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$4;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$5;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$6;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$7;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$8;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$9;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$InternalSnapshotListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeNodeWrapper;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionSnapshot;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.Collection;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class SelectionHistoryTreeGroupNode
extends AbstractSelectionHistoryTreeNode {
    private static final Icon ICON_ALL_UNSELECTED_GRAPHNODES = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-all-unselected.png");
    private static final Icon ICON_ALL_SELECTED_GRAPHNODES = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-open.png");
    private static final Icon ICON_ALL_UNVISIBLE_GRAPHNODES = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-all-unselected-gray.png");
    private static final Icon ICON_ALL_UNSELECTED_SOME_VISIBLE_SOME_INVISIBLE_GRAPHNODES = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-all-unselected-halfgray.png");
    private static final Icon ICON_ALL_VISIBLE_SOME_SELECTED_SOME_UNSELECTED_GRAPHNODES = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-some-unselected.png");
    private static final Icon ICON_SOME_SELECTED_SOME_VISIBLE_SOME_INVISIBLE_GRAPHNODES = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-some-unselected-halfgray.png");
    private static final Icon ICON_EMPTY_FOLDER = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-empty.png");
    private static final Icon ICON_DUMMY = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-closed.png");
    private final ISnapshotListener snapshotListener;
    private final SelectionSnapshot snapshot;
    private final int snapshotCount;

    public SelectionHistoryTreeGroupNode(SelectionSnapshot selectionSnapshot, int n2) {
        super(new SelectionHistoryTreeNodeWrapper(selectionSnapshot, n2).toString());
        this.snapshotListener = new SelectionHistoryTreeGroupNode$InternalSnapshotListener(this, null);
        this.snapshot = selectionSnapshot;
        selectionSnapshot.addListener(this.snapshotListener);
        this.snapshotCount = n2;
    }

    public void dispose() {
        this.snapshot.removeListener(this.snapshotListener);
    }

    @Override
    public Icon getIcon() {
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        Collection collection = this.snapshot.getSelection();
        for (ZyGraphNode zyGraphNode : collection) {
            if (zyGraphNode.isSelected()) {
                ++n3;
            } else {
                ++n4;
            }
            if (!zyGraphNode.isVisible()) {
                ++n5;
            }
            ++n2;
        }
        if (n2 == 0) {
            return ICON_EMPTY_FOLDER;
        }
        if (n5 == n2) {
            return ICON_ALL_UNVISIBLE_GRAPHNODES;
        }
        if (n3 == n2) {
            return ICON_ALL_SELECTED_GRAPHNODES;
        }
        if (n4 == n2 && n5 == 0) {
            return ICON_ALL_UNSELECTED_GRAPHNODES;
        }
        if (n3 == 0) {
            return ICON_ALL_UNSELECTED_SOME_VISIBLE_SOME_INVISIBLE_GRAPHNODES;
        }
        if (n5 == 0) {
            return ICON_ALL_VISIBLE_SOME_SELECTED_SOME_UNSELECTED_GRAPHNODES;
        }
        if (n5 == 0) return ICON_DUMMY;
        if (n3 == 0) return ICON_DUMMY;
        return ICON_SOME_SELECTED_SOME_VISIBLE_SOME_INVISIBLE_GRAPHNODES;
    }

    @Override
    public JPopupMenu getPopupMenu() {
        JPopupMenu jPopupMenu = new JPopupMenu();
        BinDiffGraph binDiffGraph = this.getRootNode().getGraph();
        if (binDiffGraph instanceof SingleGraph) {
            if (binDiffGraph.getGraphType() == EGraphType.CALLGRAPH) {
                JMenuItem jMenuItem = new JMenuItem(new SelectionHistoryTreeGroupNode$1(this, "Copy Function Addresses"));
                JMenuItem jMenuItem2 = new JMenuItem(new SelectionHistoryTreeGroupNode$2(this, "Copy Function Names"));
                jPopupMenu.add(jMenuItem);
                jPopupMenu.add(jMenuItem2);
                return jPopupMenu;
            }
            if (binDiffGraph.getGraphType() != EGraphType.FLOWGRAPH) return jPopupMenu;
            JMenuItem jMenuItem = new JMenuItem(new SelectionHistoryTreeGroupNode$3(this, "Copy Basic Block Addresses"));
            jPopupMenu.add(jMenuItem);
            return jPopupMenu;
        }
        if (!(this.getRootNode().getGraph() instanceof CombinedGraph)) return jPopupMenu;
        if (binDiffGraph.getGraphType() == EGraphType.CALLGRAPH) {
            JMenuItem jMenuItem = new JMenuItem(new SelectionHistoryTreeGroupNode$4(this, "Copy Primary Function Addresses"));
            JMenuItem jMenuItem3 = new JMenuItem(new SelectionHistoryTreeGroupNode$5(this, "Copy Secondary Function Addresses"));
            JMenuItem jMenuItem4 = new JMenuItem(new SelectionHistoryTreeGroupNode$6(this, "Copy Primary Function Names"));
            JMenuItem jMenuItem5 = new JMenuItem(new SelectionHistoryTreeGroupNode$7(this, "Copy Secondary Function Names"));
            jPopupMenu.add(jMenuItem);
            jPopupMenu.add(jMenuItem4);
            jPopupMenu.add(jMenuItem3);
            jPopupMenu.add(jMenuItem5);
            return jPopupMenu;
        }
        if (binDiffGraph.getGraphType() != EGraphType.FLOWGRAPH) return jPopupMenu;
        JMenuItem jMenuItem = new JMenuItem(new SelectionHistoryTreeGroupNode$8(this, "Copy Primary Basic Block Addresses"));
        JMenuItem jMenuItem6 = new JMenuItem(new SelectionHistoryTreeGroupNode$9(this, "Copy Secondary Basic Block Addresses"));
        jPopupMenu.add(jMenuItem);
        jPopupMenu.add(jMenuItem6);
        return jPopupMenu;
    }

    public SelectionSnapshot getSnapshot() {
        return this.snapshot;
    }

    static /* synthetic */ SelectionSnapshot access$100(SelectionHistoryTreeGroupNode selectionHistoryTreeGroupNode) {
        return selectionHistoryTreeGroupNode.snapshot;
    }

    static /* synthetic */ int access$200(SelectionHistoryTreeGroupNode selectionHistoryTreeGroupNode) {
        return selectionHistoryTreeGroupNode.snapshotCount;
    }
}

