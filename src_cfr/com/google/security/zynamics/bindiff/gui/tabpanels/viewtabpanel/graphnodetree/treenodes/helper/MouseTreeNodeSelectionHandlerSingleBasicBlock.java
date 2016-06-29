/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper;

import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBasicBlockTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphRootTreeNode;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.tree.TreeNode;

public final class MouseTreeNodeSelectionHandlerSingleBasicBlock {
    private static void selectGraphNode(SingleFlowGraphBasicBlockTreeNode singleFlowGraphBasicBlockTreeNode) {
        SingleFlowGraphRootTreeNode singleFlowGraphRootTreeNode = singleFlowGraphBasicBlockTreeNode.getRootNode();
        SingleFlowGraphBaseTreeNode singleFlowGraphBaseTreeNode = (SingleFlowGraphBaseTreeNode)singleFlowGraphBasicBlockTreeNode.getParent();
        SingleGraph singleGraph = singleFlowGraphRootTreeNode.getGraph();
        SingleDiffNode singleDiffNode = singleFlowGraphBasicBlockTreeNode.getSingleDiffNode();
        ArrayList<SingleDiffNode> arrayList = new ArrayList<SingleDiffNode>();
        ArrayList<SingleDiffNode> arrayList2 = new ArrayList<SingleDiffNode>();
        for (SingleDiffNode singleDiffNode2 : singleGraph.getNodes()) {
            arrayList2.add(singleDiffNode2);
        }
        if (!singleDiffNode.isSelected()) {
            singleFlowGraphBaseTreeNode.setLastSelectedGraphNode(singleDiffNode);
            arrayList2.remove(singleDiffNode);
            arrayList.add(singleDiffNode);
        } else {
            singleFlowGraphBaseTreeNode.setLastSelectedGraphNode(null);
        }
        singleGraph.selectNodes(arrayList, arrayList2);
    }

    private static void selectGraphNodeCtrl(SingleFlowGraphBasicBlockTreeNode singleFlowGraphBasicBlockTreeNode) {
        SingleFlowGraphRootTreeNode singleFlowGraphRootTreeNode = singleFlowGraphBasicBlockTreeNode.getRootNode();
        SingleFlowGraphBaseTreeNode singleFlowGraphBaseTreeNode = (SingleFlowGraphBaseTreeNode)singleFlowGraphBasicBlockTreeNode.getParent();
        SingleGraph singleGraph = singleFlowGraphRootTreeNode.getGraph();
        SingleDiffNode singleDiffNode = singleFlowGraphBasicBlockTreeNode.getSingleDiffNode();
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
            singleFlowGraphBaseTreeNode.setLastSelectedGraphNode(singleDiffNode);
            arrayList.add(singleDiffNode);
            arrayList2.remove(singleDiffNode);
        } else {
            singleFlowGraphBaseTreeNode.setLastSelectedGraphNode(null);
            arrayList2.add(singleDiffNode);
            arrayList.remove(singleDiffNode);
        }
        singleGraph.selectNodes(arrayList, arrayList2);
    }

    private static void selectGraphNodeCtrlShift(SingleFlowGraphBasicBlockTreeNode singleFlowGraphBasicBlockTreeNode) {
        Object object;
        SingleFlowGraphRootTreeNode singleFlowGraphRootTreeNode = singleFlowGraphBasicBlockTreeNode.getRootNode();
        SingleFlowGraphBaseTreeNode singleFlowGraphBaseTreeNode = (SingleFlowGraphBaseTreeNode)singleFlowGraphBasicBlockTreeNode.getParent();
        SingleGraph singleGraph = singleFlowGraphRootTreeNode.getGraph();
        SingleDiffNode singleDiffNode = singleFlowGraphBasicBlockTreeNode.getSingleDiffNode();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ArrayList<SingleDiffNode> arrayList2 = new ArrayList<SingleDiffNode>();
        SingleDiffNode singleDiffNode2 = singleFlowGraphBaseTreeNode.getLastSelectedGraphNode();
        if (singleDiffNode2 == null) {
            MouseTreeNodeSelectionHandlerSingleBasicBlock.selectGraphNode(singleFlowGraphBasicBlockTreeNode);
            return;
        }
        if (singleDiffNode.equals(singleDiffNode2)) {
            MouseTreeNodeSelectionHandlerSingleBasicBlock.selectGraphNodeCtrl(singleFlowGraphBasicBlockTreeNode);
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
        for (int i2 = 1; i2 < singleFlowGraphBaseTreeNode.getChildCount(); ++i2) {
            object = (SingleFlowGraphBasicBlockTreeNode)singleFlowGraphBaseTreeNode.getChildAt(i2);
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

    private static void selectGraphNodeShift(SingleFlowGraphBasicBlockTreeNode singleFlowGraphBasicBlockTreeNode) {
        Object object;
        SingleFlowGraphRootTreeNode singleFlowGraphRootTreeNode = singleFlowGraphBasicBlockTreeNode.getRootNode();
        SingleFlowGraphBaseTreeNode singleFlowGraphBaseTreeNode = (SingleFlowGraphBaseTreeNode)singleFlowGraphBasicBlockTreeNode.getParent();
        SingleGraph singleGraph = singleFlowGraphRootTreeNode.getGraph();
        SingleDiffNode singleDiffNode = singleFlowGraphBasicBlockTreeNode.getSingleDiffNode();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ArrayList<SingleDiffNode> arrayList2 = new ArrayList<SingleDiffNode>();
        SingleDiffNode singleDiffNode2 = singleFlowGraphBaseTreeNode.getLastSelectedGraphNode();
        arrayList.clear();
        arrayList2.clear();
        if (singleDiffNode2 == null || singleDiffNode.equals(singleDiffNode2)) {
            MouseTreeNodeSelectionHandlerSingleBasicBlock.selectGraphNode(singleFlowGraphBasicBlockTreeNode);
            return;
        }
        for (SingleDiffNode singleDiffNode3 : singleGraph.getNodes()) {
            arrayList2.add(singleDiffNode3);
        }
        ArrayList arrayList3 = new ArrayList();
        boolean bl2 = false;
        for (int i2 = 1; i2 < singleFlowGraphBaseTreeNode.getChildCount(); ++i2) {
            object = (SingleFlowGraphBasicBlockTreeNode)singleFlowGraphBaseTreeNode.getChildAt(i2);
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
    public static void handleMouseSelectionEvent(MouseEvent var0, SingleFlowGraphBasicBlockTreeNode var1_1) {
        var2_2 = var0.isShiftDown();
        var3_3 = var0.isControlDown();
        var4_4 = var0.getID() == 501;
        if (var0.getID() != 502) return;
        v0 = var5_5 = true;
        if (!var4_4) ** GOTO lbl-1000
        if (var3_3 && var2_2) {
            MouseTreeNodeSelectionHandlerSingleBasicBlock.selectGraphNodeCtrlShift(var1_1);
            return;
        }
        if (var5_5) lbl-1000: // 2 sources:
        {
            if (var3_3 && !var2_2) {
                MouseTreeNodeSelectionHandlerSingleBasicBlock.selectGraphNodeCtrl(var1_1);
                return;
            }
        }
        if (var4_4 && !var3_3 && var2_2) {
            MouseTreeNodeSelectionHandlerSingleBasicBlock.selectGraphNodeShift(var1_1);
            return;
        }
        if (var4_4 == false) return;
        if (var3_3 != false) return;
        if (var2_2 != false) return;
        MouseTreeNodeSelectionHandlerSingleBasicBlock.selectGraphNode(var1_1);
    }
}

