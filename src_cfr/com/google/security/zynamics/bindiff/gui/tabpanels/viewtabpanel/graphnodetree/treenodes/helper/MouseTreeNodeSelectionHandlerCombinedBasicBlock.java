/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper;

import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBasicBlockTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphRootTreeNode;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.tree.TreeNode;

public class MouseTreeNodeSelectionHandlerCombinedBasicBlock {
    private static void selectGraphNode(CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode) {
        CombinedFlowGraphRootTreeNode combinedFlowGraphRootTreeNode = combinedFlowGraphBasicBlockTreeNode.getRootNode();
        CombinedFlowGraphBaseTreeNode combinedFlowGraphBaseTreeNode = (CombinedFlowGraphBaseTreeNode)combinedFlowGraphBasicBlockTreeNode.getParent();
        CombinedGraph combinedGraph = combinedFlowGraphRootTreeNode.getGraph();
        CombinedDiffNode combinedDiffNode = combinedFlowGraphBasicBlockTreeNode.getCombinedDiffNode();
        ArrayList<CombinedDiffNode> arrayList = new ArrayList<CombinedDiffNode>();
        ArrayList<CombinedDiffNode> arrayList2 = new ArrayList<CombinedDiffNode>();
        for (CombinedDiffNode combinedDiffNode2 : combinedGraph.getNodes()) {
            arrayList2.add(combinedDiffNode2);
        }
        if (!combinedDiffNode.isSelected()) {
            combinedFlowGraphBaseTreeNode.setLastSelectedGraphNode(combinedDiffNode);
            arrayList2.remove(combinedDiffNode);
            arrayList.add(combinedDiffNode);
        } else {
            combinedFlowGraphBaseTreeNode.setLastSelectedGraphNode(null);
        }
        combinedGraph.selectNodes(arrayList, arrayList2);
    }

    private static void selectGraphNodeCtrl(CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode) {
        CombinedFlowGraphRootTreeNode combinedFlowGraphRootTreeNode = combinedFlowGraphBasicBlockTreeNode.getRootNode();
        CombinedFlowGraphBaseTreeNode combinedFlowGraphBaseTreeNode = (CombinedFlowGraphBaseTreeNode)combinedFlowGraphBasicBlockTreeNode.getParent();
        CombinedGraph combinedGraph = combinedFlowGraphRootTreeNode.getGraph();
        CombinedDiffNode combinedDiffNode = combinedFlowGraphBasicBlockTreeNode.getCombinedDiffNode();
        ArrayList<CombinedDiffNode> arrayList = new ArrayList<CombinedDiffNode>();
        ArrayList<CombinedDiffNode> arrayList2 = new ArrayList<CombinedDiffNode>();
        for (CombinedDiffNode combinedDiffNode2 : combinedGraph.getNodes()) {
            if (combinedDiffNode2.isSelected()) {
                arrayList.add(combinedDiffNode2);
                continue;
            }
            arrayList2.add(combinedDiffNode2);
        }
        if (!combinedDiffNode.isSelected()) {
            combinedFlowGraphBaseTreeNode.setLastSelectedGraphNode(combinedDiffNode);
            arrayList.add(combinedDiffNode);
            arrayList2.remove(combinedDiffNode);
        } else {
            combinedFlowGraphBaseTreeNode.setLastSelectedGraphNode(null);
            arrayList2.add(combinedDiffNode);
            arrayList.remove(combinedDiffNode);
        }
        combinedGraph.selectNodes(arrayList, arrayList2);
    }

    private static void selectGraphNodeCtrlShift(CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode) {
        Object object;
        CombinedFlowGraphRootTreeNode combinedFlowGraphRootTreeNode = combinedFlowGraphBasicBlockTreeNode.getRootNode();
        CombinedFlowGraphBaseTreeNode combinedFlowGraphBaseTreeNode = (CombinedFlowGraphBaseTreeNode)combinedFlowGraphBasicBlockTreeNode.getParent();
        CombinedGraph combinedGraph = combinedFlowGraphRootTreeNode.getGraph();
        CombinedDiffNode combinedDiffNode = combinedFlowGraphBasicBlockTreeNode.getCombinedDiffNode();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ArrayList<CombinedDiffNode> arrayList2 = new ArrayList<CombinedDiffNode>();
        CombinedDiffNode combinedDiffNode2 = combinedFlowGraphBaseTreeNode.getLastSelectedGraphNode();
        if (combinedDiffNode2 == null) {
            MouseTreeNodeSelectionHandlerCombinedBasicBlock.selectGraphNode(combinedFlowGraphBasicBlockTreeNode);
            return;
        }
        if (combinedDiffNode.equals(combinedDiffNode2)) {
            MouseTreeNodeSelectionHandlerCombinedBasicBlock.selectGraphNodeCtrl(combinedFlowGraphBasicBlockTreeNode);
            return;
        }
        for (CombinedDiffNode combinedDiffNode3 : combinedGraph.getNodes()) {
            if (combinedDiffNode3.isSelected()) {
                arrayList.add(combinedDiffNode3);
                continue;
            }
            arrayList2.add(combinedDiffNode3);
        }
        ArrayList arrayList3 = new ArrayList();
        boolean bl2 = false;
        for (int i2 = 1; i2 < combinedFlowGraphBaseTreeNode.getChildCount(); ++i2) {
            object = (CombinedFlowGraphBasicBlockTreeNode)combinedFlowGraphBaseTreeNode.getChildAt(i2);
            CombinedDiffNode combinedDiffNode4 = object.getCombinedDiffNode();
            if (combinedDiffNode4.equals(combinedDiffNode2)) {
                bl2 = true;
                if (arrayList3.size() != 0) {
                    arrayList3.add(object.getCombinedDiffNode());
                    break;
                }
            }
            if (combinedDiffNode4.equals(combinedDiffNode)) {
                bl2 = true;
                if (arrayList3.size() != 0) {
                    arrayList3.add(object.getCombinedDiffNode());
                    break;
                }
            } else if (!bl2) continue;
            arrayList3.add(object.getCombinedDiffNode());
        }
        Iterator iterator = arrayList3.iterator();
        do {
            if (!iterator.hasNext()) {
                combinedGraph.selectNodes(arrayList, arrayList2);
                return;
            }
            object = (CombinedDiffNode)iterator.next();
            arrayList.add(object);
            arrayList2.remove(object);
        } while (true);
    }

    private static void selectGraphNodeShift(CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode) {
        Object object;
        CombinedFlowGraphRootTreeNode combinedFlowGraphRootTreeNode = combinedFlowGraphBasicBlockTreeNode.getRootNode();
        CombinedFlowGraphBaseTreeNode combinedFlowGraphBaseTreeNode = (CombinedFlowGraphBaseTreeNode)combinedFlowGraphBasicBlockTreeNode.getParent();
        CombinedGraph combinedGraph = combinedFlowGraphRootTreeNode.getGraph();
        CombinedDiffNode combinedDiffNode = combinedFlowGraphBasicBlockTreeNode.getCombinedDiffNode();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ArrayList<CombinedDiffNode> arrayList2 = new ArrayList<CombinedDiffNode>();
        CombinedDiffNode combinedDiffNode2 = combinedFlowGraphBaseTreeNode.getLastSelectedGraphNode();
        arrayList.clear();
        arrayList2.clear();
        if (combinedDiffNode2 == null || combinedDiffNode.equals(combinedDiffNode2)) {
            MouseTreeNodeSelectionHandlerCombinedBasicBlock.selectGraphNode(combinedFlowGraphBasicBlockTreeNode);
            return;
        }
        for (CombinedDiffNode combinedDiffNode3 : combinedGraph.getNodes()) {
            arrayList2.add(combinedDiffNode3);
        }
        ArrayList arrayList3 = new ArrayList();
        boolean bl2 = false;
        for (int i2 = 1; i2 < combinedFlowGraphBaseTreeNode.getChildCount(); ++i2) {
            object = (CombinedFlowGraphBasicBlockTreeNode)combinedFlowGraphBaseTreeNode.getChildAt(i2);
            CombinedDiffNode combinedDiffNode4 = object.getCombinedDiffNode();
            if (combinedDiffNode4.equals(combinedDiffNode2)) {
                bl2 = true;
                if (arrayList3.size() != 0) {
                    arrayList3.add(object.getCombinedDiffNode());
                    break;
                }
            }
            if (combinedDiffNode4.equals(combinedDiffNode)) {
                bl2 = true;
                if (arrayList3.size() != 0) {
                    arrayList3.add(object.getCombinedDiffNode());
                    break;
                }
            } else if (!bl2) continue;
            arrayList3.add(object.getCombinedDiffNode());
        }
        Iterator iterator = arrayList3.iterator();
        do {
            if (!iterator.hasNext()) {
                combinedGraph.selectNodes(arrayList, arrayList2);
                return;
            }
            object = (CombinedDiffNode)iterator.next();
            arrayList.add(object);
            arrayList2.remove(object);
        } while (true);
    }

    /*
     * Unable to fully structure code
     */
    public static void handleMouseSelectionEvent(MouseEvent var0, CombinedFlowGraphBasicBlockTreeNode var1_1) {
        var2_2 = var0.isShiftDown();
        var3_3 = var0.isControlDown();
        var4_4 = var0.getID() == 501;
        if (var0.getID() != 502) return;
        v0 = var5_5 = true;
        if (!var4_4) ** GOTO lbl-1000
        if (var2_2 && var3_3) {
            MouseTreeNodeSelectionHandlerCombinedBasicBlock.selectGraphNodeCtrlShift(var1_1);
            return;
        }
        if (var5_5) lbl-1000: // 2 sources:
        {
            if (var3_3 && !var2_2) {
                MouseTreeNodeSelectionHandlerCombinedBasicBlock.selectGraphNodeCtrl(var1_1);
                return;
            }
        }
        if (var4_4 && !var3_3 && var2_2) {
            MouseTreeNodeSelectionHandlerCombinedBasicBlock.selectGraphNodeShift(var1_1);
            return;
        }
        if (var4_4 == false) return;
        if (var3_3 != false) return;
        if (var2_2 != false) return;
        MouseTreeNodeSelectionHandlerCombinedBasicBlock.selectGraphNode(var1_1);
    }
}

