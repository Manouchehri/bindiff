/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper;

import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphFunctionTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphRootTreeNode;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.tree.TreeNode;

public class MouseTreeNodeSelectionHandlerSingleFunction {
    private static void selectGraphNode(SingleCallGraphFunctionTreeNode singleCallGraphFunctionTreeNode) {
        SingleCallGraphRootTreeNode singleCallGraphRootTreeNode = singleCallGraphFunctionTreeNode.getRootNode();
        SingleCallGraphBaseTreeNode singleCallGraphBaseTreeNode = (SingleCallGraphBaseTreeNode)singleCallGraphFunctionTreeNode.getParent();
        SingleGraph singleGraph = singleCallGraphRootTreeNode.getGraph();
        SingleDiffNode singleDiffNode = singleCallGraphFunctionTreeNode.getSingleDiffNode();
        ArrayList<SingleDiffNode> arrayList = new ArrayList<SingleDiffNode>();
        ArrayList<SingleDiffNode> arrayList2 = new ArrayList<SingleDiffNode>();
        for (SingleDiffNode singleDiffNode2 : singleGraph.getNodes()) {
            arrayList2.add(singleDiffNode2);
        }
        if (!singleDiffNode.isSelected()) {
            singleCallGraphBaseTreeNode.setLastSelectedGraphNode(singleDiffNode);
            arrayList2.remove(singleDiffNode);
            arrayList.add(singleDiffNode);
        } else {
            singleCallGraphBaseTreeNode.setLastSelectedGraphNode(null);
        }
        singleGraph.selectNodes(arrayList, arrayList2);
    }

    private static void selectGraphNodeCtrl(SingleCallGraphFunctionTreeNode singleCallGraphFunctionTreeNode) {
        SingleCallGraphRootTreeNode singleCallGraphRootTreeNode = singleCallGraphFunctionTreeNode.getRootNode();
        SingleCallGraphBaseTreeNode singleCallGraphBaseTreeNode = (SingleCallGraphBaseTreeNode)singleCallGraphFunctionTreeNode.getParent();
        SingleGraph singleGraph = singleCallGraphRootTreeNode.getGraph();
        SingleDiffNode singleDiffNode = singleCallGraphFunctionTreeNode.getSingleDiffNode();
        ArrayList<SingleDiffNode> arrayList = new ArrayList<SingleDiffNode>();
        ArrayList<SingleDiffNode> arrayList2 = new ArrayList<SingleDiffNode>();
        for (SingleDiffNode singleDiffNode2 : singleGraph.getNodes()) {
            if (singleDiffNode2.isSelected()) {
                arrayList.add(singleDiffNode2);
                continue;
            }
            arrayList2.add(singleDiffNode2);
        }
        if (!singleDiffNode.isSelected()) {
            singleCallGraphBaseTreeNode.setLastSelectedGraphNode(singleDiffNode);
            arrayList.add(singleDiffNode);
            arrayList2.remove(singleDiffNode);
        } else {
            singleCallGraphBaseTreeNode.setLastSelectedGraphNode(null);
            arrayList2.add(singleDiffNode);
            arrayList.remove(singleDiffNode);
        }
        singleGraph.selectNodes(arrayList, arrayList2);
    }

    private static void selectGraphNodeCtrlShift(SingleCallGraphFunctionTreeNode singleCallGraphFunctionTreeNode) {
        Object object;
        SingleCallGraphRootTreeNode singleCallGraphRootTreeNode = singleCallGraphFunctionTreeNode.getRootNode();
        SingleCallGraphBaseTreeNode singleCallGraphBaseTreeNode = (SingleCallGraphBaseTreeNode)singleCallGraphFunctionTreeNode.getParent();
        SingleGraph singleGraph = singleCallGraphRootTreeNode.getGraph();
        SingleDiffNode singleDiffNode = singleCallGraphFunctionTreeNode.getSingleDiffNode();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ArrayList<SingleDiffNode> arrayList2 = new ArrayList<SingleDiffNode>();
        SingleDiffNode singleDiffNode2 = singleCallGraphBaseTreeNode.getLastSelectedGraphNode();
        if (singleDiffNode2 == null) {
            MouseTreeNodeSelectionHandlerSingleFunction.selectGraphNode(singleCallGraphFunctionTreeNode);
            return;
        }
        if (singleDiffNode.equals(singleDiffNode2)) {
            MouseTreeNodeSelectionHandlerSingleFunction.selectGraphNodeCtrl(singleCallGraphFunctionTreeNode);
            return;
        }
        for (SingleDiffNode singleDiffNode3 : singleGraph.getNodes()) {
            if (singleDiffNode3.isSelected()) {
                arrayList.add(singleDiffNode3);
                continue;
            }
            arrayList2.add(singleDiffNode3);
        }
        ArrayList arrayList3 = new ArrayList();
        boolean bl2 = false;
        for (int i2 = 1; i2 < singleCallGraphBaseTreeNode.getChildCount(); ++i2) {
            object = (SingleCallGraphFunctionTreeNode)singleCallGraphBaseTreeNode.getChildAt(i2);
            SingleDiffNode singleDiffNode4 = object.getSingleDiffNode();
            if (singleDiffNode4.equals(singleDiffNode2)) {
                bl2 = true;
                if (arrayList3.size() != 0) {
                    arrayList3.add(object.getSingleDiffNode());
                    break;
                }
            }
            if (singleDiffNode4.equals(singleDiffNode)) {
                bl2 = true;
                if (arrayList3.size() != 0) {
                    arrayList3.add(object.getSingleDiffNode());
                    break;
                }
            } else if (!bl2) continue;
            arrayList3.add(object.getSingleDiffNode());
        }
        Iterator iterator = arrayList3.iterator();
        do {
            if (!iterator.hasNext()) {
                singleGraph.selectNodes(arrayList, arrayList2);
                return;
            }
            object = (SingleDiffNode)iterator.next();
            arrayList.add(object);
            arrayList2.remove(object);
        } while (true);
    }

    private static void selectGraphNodeShift(SingleCallGraphFunctionTreeNode singleCallGraphFunctionTreeNode) {
        Object object;
        SingleCallGraphRootTreeNode singleCallGraphRootTreeNode = singleCallGraphFunctionTreeNode.getRootNode();
        SingleCallGraphBaseTreeNode singleCallGraphBaseTreeNode = (SingleCallGraphBaseTreeNode)singleCallGraphFunctionTreeNode.getParent();
        SingleGraph singleGraph = singleCallGraphRootTreeNode.getGraph();
        SingleDiffNode singleDiffNode = singleCallGraphFunctionTreeNode.getSingleDiffNode();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ArrayList<SingleDiffNode> arrayList2 = new ArrayList<SingleDiffNode>();
        SingleDiffNode singleDiffNode2 = singleCallGraphBaseTreeNode.getLastSelectedGraphNode();
        arrayList.clear();
        arrayList2.clear();
        if (singleDiffNode2 == null || singleDiffNode.equals(singleDiffNode2)) {
            MouseTreeNodeSelectionHandlerSingleFunction.selectGraphNode(singleCallGraphFunctionTreeNode);
            return;
        }
        for (SingleDiffNode singleDiffNode3 : singleGraph.getNodes()) {
            arrayList2.add(singleDiffNode3);
        }
        ArrayList arrayList3 = new ArrayList();
        boolean bl2 = false;
        for (int i2 = 1; i2 < singleCallGraphBaseTreeNode.getChildCount(); ++i2) {
            object = (SingleCallGraphFunctionTreeNode)singleCallGraphBaseTreeNode.getChildAt(i2);
            SingleDiffNode singleDiffNode4 = object.getSingleDiffNode();
            if (singleDiffNode4.equals(singleDiffNode2)) {
                bl2 = true;
                if (arrayList3.size() != 0) {
                    arrayList3.add(object.getSingleDiffNode());
                    break;
                }
            }
            if (singleDiffNode4.equals(singleDiffNode)) {
                bl2 = true;
                if (arrayList3.size() != 0) {
                    arrayList3.add(object.getSingleDiffNode());
                    break;
                }
            } else if (!bl2) continue;
            arrayList3.add(object.getSingleDiffNode());
        }
        Iterator iterator = arrayList3.iterator();
        do {
            if (!iterator.hasNext()) {
                singleGraph.selectNodes(arrayList, arrayList2);
                return;
            }
            object = (SingleDiffNode)iterator.next();
            arrayList.add(object);
            arrayList2.remove(object);
        } while (true);
    }

    /*
     * Unable to fully structure code
     */
    public static void handleMouseSelectionEvent(MouseEvent var0, SingleCallGraphFunctionTreeNode var1_1) {
        var2_2 = var0.isShiftDown();
        var3_3 = var0.isControlDown();
        var4_4 = var0.getID() == 501;
        if (var0.getID() != 502) return;
        v0 = var5_5 = true;
        if (!var4_4) ** GOTO lbl-1000
        if (var2_2 && var3_3) {
            MouseTreeNodeSelectionHandlerSingleFunction.selectGraphNodeCtrlShift(var1_1);
            return;
        }
        if (var5_5) lbl-1000: // 2 sources:
        {
            if (var3_3 && !var2_2) {
                MouseTreeNodeSelectionHandlerSingleFunction.selectGraphNodeCtrl(var1_1);
                return;
            }
        }
        if (var4_4 && !var3_3 && var2_2) {
            MouseTreeNodeSelectionHandlerSingleFunction.selectGraphNodeShift(var1_1);
            return;
        }
        if (var4_4 == false) return;
        if (var3_3 != false) return;
        if (var2_2 != false) return;
        MouseTreeNodeSelectionHandlerSingleFunction.selectGraphNode(var1_1);
    }
}

