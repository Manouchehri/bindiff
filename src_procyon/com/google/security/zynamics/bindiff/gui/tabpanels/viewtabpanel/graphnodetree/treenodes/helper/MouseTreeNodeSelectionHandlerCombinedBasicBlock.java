package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper;

import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.*;
import com.google.security.zynamics.bindiff.graph.*;
import java.util.*;
import java.awt.event.*;

public class MouseTreeNodeSelectionHandlerCombinedBasicBlock
{
    private static void selectGraphNode(final CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode) {
        final CombinedFlowGraphRootTreeNode rootNode = combinedFlowGraphBasicBlockTreeNode.getRootNode();
        final CombinedFlowGraphBaseTreeNode combinedFlowGraphBaseTreeNode = (CombinedFlowGraphBaseTreeNode)combinedFlowGraphBasicBlockTreeNode.getParent();
        final CombinedGraph graph = rootNode.getGraph();
        final CombinedDiffNode combinedDiffNode = combinedFlowGraphBasicBlockTreeNode.getCombinedDiffNode();
        final ArrayList<CombinedDiffNode> list = new ArrayList<CombinedDiffNode>();
        final ArrayList<CombinedDiffNode> list2 = new ArrayList<CombinedDiffNode>();
        final Iterator iterator = graph.getNodes().iterator();
        while (iterator.hasNext()) {
            list2.add(iterator.next());
        }
        if (!combinedDiffNode.isSelected()) {
            combinedFlowGraphBaseTreeNode.setLastSelectedGraphNode(combinedDiffNode);
            list2.remove(combinedDiffNode);
            list.add(combinedDiffNode);
        }
        else {
            combinedFlowGraphBaseTreeNode.setLastSelectedGraphNode(null);
        }
        graph.selectNodes(list, list2);
    }
    
    private static void selectGraphNodeCtrl(final CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode) {
        final CombinedFlowGraphRootTreeNode rootNode = combinedFlowGraphBasicBlockTreeNode.getRootNode();
        final CombinedFlowGraphBaseTreeNode combinedFlowGraphBaseTreeNode = (CombinedFlowGraphBaseTreeNode)combinedFlowGraphBasicBlockTreeNode.getParent();
        final CombinedGraph graph = rootNode.getGraph();
        final CombinedDiffNode combinedDiffNode = combinedFlowGraphBasicBlockTreeNode.getCombinedDiffNode();
        final ArrayList<CombinedDiffNode> list = new ArrayList<CombinedDiffNode>();
        final ArrayList<CombinedDiffNode> list2 = new ArrayList<CombinedDiffNode>();
        for (final CombinedDiffNode combinedDiffNode2 : graph.getNodes()) {
            if (combinedDiffNode2.isSelected()) {
                list.add(combinedDiffNode2);
            }
            else {
                list2.add(combinedDiffNode2);
            }
        }
        if (!combinedDiffNode.isSelected()) {
            combinedFlowGraphBaseTreeNode.setLastSelectedGraphNode(combinedDiffNode);
            list.add(combinedDiffNode);
            list2.remove(combinedDiffNode);
        }
        else {
            combinedFlowGraphBaseTreeNode.setLastSelectedGraphNode(null);
            list2.add(combinedDiffNode);
            list.remove(combinedDiffNode);
        }
        graph.selectNodes(list, list2);
    }
    
    private static void selectGraphNodeCtrlShift(final CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode) {
        final CombinedFlowGraphRootTreeNode rootNode = combinedFlowGraphBasicBlockTreeNode.getRootNode();
        final CombinedFlowGraphBaseTreeNode combinedFlowGraphBaseTreeNode = (CombinedFlowGraphBaseTreeNode)combinedFlowGraphBasicBlockTreeNode.getParent();
        final CombinedGraph graph = rootNode.getGraph();
        final CombinedDiffNode combinedDiffNode = combinedFlowGraphBasicBlockTreeNode.getCombinedDiffNode();
        final ArrayList<CombinedDiffNode> list = new ArrayList<CombinedDiffNode>();
        final ArrayList<CombinedDiffNode> list2 = new ArrayList<CombinedDiffNode>();
        final CombinedDiffNode lastSelectedGraphNode = combinedFlowGraphBaseTreeNode.getLastSelectedGraphNode();
        if (lastSelectedGraphNode == null) {
            selectGraphNode(combinedFlowGraphBasicBlockTreeNode);
        }
        else if (combinedDiffNode.equals(lastSelectedGraphNode)) {
            selectGraphNodeCtrl(combinedFlowGraphBasicBlockTreeNode);
        }
        else {
            for (final CombinedDiffNode combinedDiffNode2 : graph.getNodes()) {
                if (combinedDiffNode2.isSelected()) {
                    list.add(combinedDiffNode2);
                }
                else {
                    list2.add(combinedDiffNode2);
                }
            }
            final ArrayList<CombinedDiffNode> list3 = new ArrayList<CombinedDiffNode>();
            boolean b = false;
            for (int i = 1; i < combinedFlowGraphBaseTreeNode.getChildCount(); ++i) {
                final CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode2 = (CombinedFlowGraphBasicBlockTreeNode)combinedFlowGraphBaseTreeNode.getChildAt(i);
                final CombinedDiffNode combinedDiffNode3 = combinedFlowGraphBasicBlockTreeNode2.getCombinedDiffNode();
                if (combinedDiffNode3.equals(lastSelectedGraphNode)) {
                    b = true;
                    if (list3.size() != 0) {
                        list3.add(combinedFlowGraphBasicBlockTreeNode2.getCombinedDiffNode());
                        break;
                    }
                }
                if (combinedDiffNode3.equals(combinedDiffNode)) {
                    b = true;
                    if (list3.size() != 0) {
                        list3.add(combinedFlowGraphBasicBlockTreeNode2.getCombinedDiffNode());
                        break;
                    }
                }
                if (b) {
                    list3.add(combinedFlowGraphBasicBlockTreeNode2.getCombinedDiffNode());
                }
            }
            for (final CombinedDiffNode combinedDiffNode4 : list3) {
                list.add(combinedDiffNode4);
                list2.remove(combinedDiffNode4);
            }
            graph.selectNodes(list, list2);
        }
    }
    
    private static void selectGraphNodeShift(final CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode) {
        final CombinedFlowGraphRootTreeNode rootNode = combinedFlowGraphBasicBlockTreeNode.getRootNode();
        final CombinedFlowGraphBaseTreeNode combinedFlowGraphBaseTreeNode = (CombinedFlowGraphBaseTreeNode)combinedFlowGraphBasicBlockTreeNode.getParent();
        final CombinedGraph graph = rootNode.getGraph();
        final CombinedDiffNode combinedDiffNode = combinedFlowGraphBasicBlockTreeNode.getCombinedDiffNode();
        final ArrayList<CombinedDiffNode> list = new ArrayList<CombinedDiffNode>();
        final ArrayList<CombinedDiffNode> list2 = new ArrayList<CombinedDiffNode>();
        final CombinedDiffNode lastSelectedGraphNode = combinedFlowGraphBaseTreeNode.getLastSelectedGraphNode();
        list.clear();
        list2.clear();
        if (lastSelectedGraphNode == null || combinedDiffNode.equals(lastSelectedGraphNode)) {
            selectGraphNode(combinedFlowGraphBasicBlockTreeNode);
        }
        else {
            final Iterator iterator = graph.getNodes().iterator();
            while (iterator.hasNext()) {
                list2.add(iterator.next());
            }
            final ArrayList<CombinedDiffNode> list3 = new ArrayList<CombinedDiffNode>();
            boolean b = false;
            for (int i = 1; i < combinedFlowGraphBaseTreeNode.getChildCount(); ++i) {
                final CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode2 = (CombinedFlowGraphBasicBlockTreeNode)combinedFlowGraphBaseTreeNode.getChildAt(i);
                final CombinedDiffNode combinedDiffNode2 = combinedFlowGraphBasicBlockTreeNode2.getCombinedDiffNode();
                if (combinedDiffNode2.equals(lastSelectedGraphNode)) {
                    b = true;
                    if (list3.size() != 0) {
                        list3.add(combinedFlowGraphBasicBlockTreeNode2.getCombinedDiffNode());
                        break;
                    }
                }
                if (combinedDiffNode2.equals(combinedDiffNode)) {
                    b = true;
                    if (list3.size() != 0) {
                        list3.add(combinedFlowGraphBasicBlockTreeNode2.getCombinedDiffNode());
                        break;
                    }
                }
                if (b) {
                    list3.add(combinedFlowGraphBasicBlockTreeNode2.getCombinedDiffNode());
                }
            }
            for (final CombinedDiffNode combinedDiffNode3 : list3) {
                list.add(combinedDiffNode3);
                list2.remove(combinedDiffNode3);
            }
            graph.selectNodes(list, list2);
        }
    }
    
    public static void handleMouseSelectionEvent(final MouseEvent mouseEvent, final CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode) {
        final boolean shiftDown = mouseEvent.isShiftDown();
        final boolean controlDown = mouseEvent.isControlDown();
        final boolean b = mouseEvent.getID() == 501;
        final boolean b2 = mouseEvent.getID() == 502;
        if (b && shiftDown && controlDown) {
            selectGraphNodeCtrlShift(combinedFlowGraphBasicBlockTreeNode);
        }
        else if (b2 && controlDown && !shiftDown) {
            selectGraphNodeCtrl(combinedFlowGraphBasicBlockTreeNode);
        }
        else if (b && !controlDown && shiftDown) {
            selectGraphNodeShift(combinedFlowGraphBasicBlockTreeNode);
        }
        else if (b && !controlDown && !shiftDown) {
            selectGraphNode(combinedFlowGraphBasicBlockTreeNode);
        }
    }
}
