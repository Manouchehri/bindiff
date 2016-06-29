/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper;

import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphFunctionTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphRootTreeNode;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.tree.TreeNode;

public class MouseTreeNodeSelectionHandlerCombinedFunction {
    private static void selectGraphNode(CombinedCallGraphFunctionTreeNode combinedCallGraphFunctionTreeNode) {
        CombinedCallGraphRootTreeNode combinedCallGraphRootTreeNode = combinedCallGraphFunctionTreeNode.getRootNode();
        CombinedCallGraphBaseTreeNode combinedCallGraphBaseTreeNode = (CombinedCallGraphBaseTreeNode)combinedCallGraphFunctionTreeNode.getParent();
        CombinedGraph combinedGraph = combinedCallGraphRootTreeNode.getGraph();
        CombinedDiffNode combinedDiffNode = combinedCallGraphFunctionTreeNode.getCombinedDiffNode();
        ArrayList<CombinedDiffNode> arrayList = new ArrayList<CombinedDiffNode>();
        ArrayList<CombinedDiffNode> arrayList2 = new ArrayList<CombinedDiffNode>();
        for (CombinedDiffNode combinedDiffNode2 : combinedGraph.getNodes()) {
            arrayList2.add(combinedDiffNode2);
        }
        if (!combinedDiffNode.isSelected()) {
            combinedCallGraphBaseTreeNode.setLastSelectedGraphNode(combinedDiffNode);
            arrayList2.remove(combinedDiffNode);
            arrayList.add(combinedDiffNode);
        } else {
            combinedCallGraphBaseTreeNode.setLastSelectedGraphNode(null);
        }
        combinedGraph.selectNodes(arrayList, arrayList2);
    }

    private static void selectGraphNodeCtrl(CombinedCallGraphFunctionTreeNode combinedCallGraphFunctionTreeNode) {
        CombinedCallGraphRootTreeNode combinedCallGraphRootTreeNode = combinedCallGraphFunctionTreeNode.getRootNode();
        CombinedCallGraphBaseTreeNode combinedCallGraphBaseTreeNode = (CombinedCallGraphBaseTreeNode)combinedCallGraphFunctionTreeNode.getParent();
        CombinedGraph combinedGraph = combinedCallGraphRootTreeNode.getGraph();
        CombinedDiffNode combinedDiffNode = combinedCallGraphFunctionTreeNode.getCombinedDiffNode();
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
            combinedCallGraphBaseTreeNode.setLastSelectedGraphNode(combinedDiffNode);
            arrayList.add(combinedDiffNode);
            arrayList2.remove(combinedDiffNode);
        } else {
            combinedCallGraphBaseTreeNode.setLastSelectedGraphNode(null);
            arrayList2.add(combinedDiffNode);
            arrayList.remove(combinedDiffNode);
        }
        combinedGraph.selectNodes(arrayList, arrayList2);
    }

    private static void selectGraphNodeCtrlShift(CombinedCallGraphFunctionTreeNode combinedCallGraphFunctionTreeNode) {
        Object object;
        CombinedCallGraphRootTreeNode combinedCallGraphRootTreeNode = combinedCallGraphFunctionTreeNode.getRootNode();
        CombinedCallGraphBaseTreeNode combinedCallGraphBaseTreeNode = (CombinedCallGraphBaseTreeNode)combinedCallGraphFunctionTreeNode.getParent();
        CombinedGraph combinedGraph = combinedCallGraphRootTreeNode.getGraph();
        CombinedDiffNode combinedDiffNode = combinedCallGraphFunctionTreeNode.getCombinedDiffNode();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ArrayList<CombinedDiffNode> arrayList2 = new ArrayList<CombinedDiffNode>();
        CombinedDiffNode combinedDiffNode2 = combinedCallGraphBaseTreeNode.getLastSelectedGraphNode();
        if (combinedDiffNode2 == null) {
            MouseTreeNodeSelectionHandlerCombinedFunction.selectGraphNode(combinedCallGraphFunctionTreeNode);
            return;
        }
        if (combinedDiffNode.equals(combinedDiffNode2)) {
            MouseTreeNodeSelectionHandlerCombinedFunction.selectGraphNodeCtrl(combinedCallGraphFunctionTreeNode);
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
        for (int i2 = 1; i2 < combinedCallGraphBaseTreeNode.getChildCount(); ++i2) {
            object = (CombinedCallGraphFunctionTreeNode)combinedCallGraphBaseTreeNode.getChildAt(i2);
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

    private static void selectGraphNodeShift(CombinedCallGraphFunctionTreeNode combinedCallGraphFunctionTreeNode) {
        Object object;
        CombinedCallGraphRootTreeNode combinedCallGraphRootTreeNode = combinedCallGraphFunctionTreeNode.getRootNode();
        CombinedCallGraphBaseTreeNode combinedCallGraphBaseTreeNode = (CombinedCallGraphBaseTreeNode)combinedCallGraphFunctionTreeNode.getParent();
        CombinedGraph combinedGraph = combinedCallGraphRootTreeNode.getGraph();
        CombinedDiffNode combinedDiffNode = combinedCallGraphFunctionTreeNode.getCombinedDiffNode();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ArrayList<CombinedDiffNode> arrayList2 = new ArrayList<CombinedDiffNode>();
        CombinedDiffNode combinedDiffNode2 = combinedCallGraphBaseTreeNode.getLastSelectedGraphNode();
        arrayList.clear();
        arrayList2.clear();
        if (combinedDiffNode2 == null || combinedDiffNode.equals(combinedDiffNode2)) {
            MouseTreeNodeSelectionHandlerCombinedFunction.selectGraphNode(combinedCallGraphFunctionTreeNode);
            return;
        }
        for (CombinedDiffNode combinedDiffNode3 : combinedGraph.getNodes()) {
            arrayList2.add(combinedDiffNode3);
        }
        ArrayList arrayList3 = new ArrayList();
        boolean bl2 = false;
        for (int i2 = 1; i2 < combinedCallGraphBaseTreeNode.getChildCount(); ++i2) {
            object = (CombinedCallGraphFunctionTreeNode)combinedCallGraphBaseTreeNode.getChildAt(i2);
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
    public static void handleMouseSelectionEvent(MouseEvent var0, CombinedCallGraphFunctionTreeNode var1_1) {
        var2_2 = var0.isShiftDown();
        var3_3 = var0.isControlDown();
        var4_4 = var0.getID() == 501;
        if (var0.getID() != 502) return;
        v0 = var5_5 = true;
        if (!var4_4) ** GOTO lbl-1000
        if (var2_2 && var3_3) {
            MouseTreeNodeSelectionHandlerCombinedFunction.selectGraphNodeCtrlShift(var1_1);
            return;
        }
        if (var5_5) lbl-1000: // 2 sources:
        {
            if (var3_3 && !var2_2) {
                MouseTreeNodeSelectionHandlerCombinedFunction.selectGraphNodeCtrl(var1_1);
                return;
            }
        }
        if (var4_4 && !var3_3 && var2_2) {
            MouseTreeNodeSelectionHandlerCombinedFunction.selectGraphNodeShift(var1_1);
            return;
        }
        if (var4_4 == false) return;
        if (var3_3 != false) return;
        if (var2_2 != false) return;
        MouseTreeNodeSelectionHandlerCombinedFunction.selectGraphNode(var1_1);
    }
}

