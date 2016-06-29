package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper;

import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.*;
import com.google.security.zynamics.bindiff.graph.*;
import java.util.*;
import java.awt.event.*;

public class MouseTreeNodeSelectionHandlerCombinedFunction
{
    private static void selectGraphNode(final CombinedCallGraphFunctionTreeNode combinedCallGraphFunctionTreeNode) {
        final CombinedCallGraphRootTreeNode rootNode = combinedCallGraphFunctionTreeNode.getRootNode();
        final CombinedCallGraphBaseTreeNode combinedCallGraphBaseTreeNode = (CombinedCallGraphBaseTreeNode)combinedCallGraphFunctionTreeNode.getParent();
        final CombinedGraph graph = rootNode.getGraph();
        final CombinedDiffNode combinedDiffNode = combinedCallGraphFunctionTreeNode.getCombinedDiffNode();
        final ArrayList<CombinedDiffNode> list = new ArrayList<CombinedDiffNode>();
        final ArrayList<CombinedDiffNode> list2 = new ArrayList<CombinedDiffNode>();
        final Iterator iterator = graph.getNodes().iterator();
        while (iterator.hasNext()) {
            list2.add(iterator.next());
        }
        if (!combinedDiffNode.isSelected()) {
            combinedCallGraphBaseTreeNode.setLastSelectedGraphNode(combinedDiffNode);
            list2.remove(combinedDiffNode);
            list.add(combinedDiffNode);
        }
        else {
            combinedCallGraphBaseTreeNode.setLastSelectedGraphNode(null);
        }
        graph.selectNodes(list, list2);
    }
    
    private static void selectGraphNodeCtrl(final CombinedCallGraphFunctionTreeNode combinedCallGraphFunctionTreeNode) {
        final CombinedCallGraphRootTreeNode rootNode = combinedCallGraphFunctionTreeNode.getRootNode();
        final CombinedCallGraphBaseTreeNode combinedCallGraphBaseTreeNode = (CombinedCallGraphBaseTreeNode)combinedCallGraphFunctionTreeNode.getParent();
        final CombinedGraph graph = rootNode.getGraph();
        final CombinedDiffNode combinedDiffNode = combinedCallGraphFunctionTreeNode.getCombinedDiffNode();
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
            combinedCallGraphBaseTreeNode.setLastSelectedGraphNode(combinedDiffNode);
            list.add(combinedDiffNode);
            list2.remove(combinedDiffNode);
        }
        else {
            combinedCallGraphBaseTreeNode.setLastSelectedGraphNode(null);
            list2.add(combinedDiffNode);
            list.remove(combinedDiffNode);
        }
        graph.selectNodes(list, list2);
    }
    
    private static void selectGraphNodeCtrlShift(final CombinedCallGraphFunctionTreeNode combinedCallGraphFunctionTreeNode) {
        final CombinedCallGraphRootTreeNode rootNode = combinedCallGraphFunctionTreeNode.getRootNode();
        final CombinedCallGraphBaseTreeNode combinedCallGraphBaseTreeNode = (CombinedCallGraphBaseTreeNode)combinedCallGraphFunctionTreeNode.getParent();
        final CombinedGraph graph = rootNode.getGraph();
        final CombinedDiffNode combinedDiffNode = combinedCallGraphFunctionTreeNode.getCombinedDiffNode();
        final ArrayList<CombinedDiffNode> list = new ArrayList<CombinedDiffNode>();
        final ArrayList<CombinedDiffNode> list2 = new ArrayList<CombinedDiffNode>();
        final CombinedDiffNode lastSelectedGraphNode = combinedCallGraphBaseTreeNode.getLastSelectedGraphNode();
        if (lastSelectedGraphNode == null) {
            selectGraphNode(combinedCallGraphFunctionTreeNode);
        }
        else if (combinedDiffNode.equals(lastSelectedGraphNode)) {
            selectGraphNodeCtrl(combinedCallGraphFunctionTreeNode);
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
            for (int i = 1; i < combinedCallGraphBaseTreeNode.getChildCount(); ++i) {
                final CombinedCallGraphFunctionTreeNode combinedCallGraphFunctionTreeNode2 = (CombinedCallGraphFunctionTreeNode)combinedCallGraphBaseTreeNode.getChildAt(i);
                final CombinedDiffNode combinedDiffNode3 = combinedCallGraphFunctionTreeNode2.getCombinedDiffNode();
                if (combinedDiffNode3.equals(lastSelectedGraphNode)) {
                    b = true;
                    if (list3.size() != 0) {
                        list3.add(combinedCallGraphFunctionTreeNode2.getCombinedDiffNode());
                        break;
                    }
                }
                if (combinedDiffNode3.equals(combinedDiffNode)) {
                    b = true;
                    if (list3.size() != 0) {
                        list3.add(combinedCallGraphFunctionTreeNode2.getCombinedDiffNode());
                        break;
                    }
                }
                if (b) {
                    list3.add(combinedCallGraphFunctionTreeNode2.getCombinedDiffNode());
                }
            }
            for (final CombinedDiffNode combinedDiffNode4 : list3) {
                list.add(combinedDiffNode4);
                list2.remove(combinedDiffNode4);
            }
            graph.selectNodes(list, list2);
        }
    }
    
    private static void selectGraphNodeShift(final CombinedCallGraphFunctionTreeNode combinedCallGraphFunctionTreeNode) {
        final CombinedCallGraphRootTreeNode rootNode = combinedCallGraphFunctionTreeNode.getRootNode();
        final CombinedCallGraphBaseTreeNode combinedCallGraphBaseTreeNode = (CombinedCallGraphBaseTreeNode)combinedCallGraphFunctionTreeNode.getParent();
        final CombinedGraph graph = rootNode.getGraph();
        final CombinedDiffNode combinedDiffNode = combinedCallGraphFunctionTreeNode.getCombinedDiffNode();
        final ArrayList<CombinedDiffNode> list = new ArrayList<CombinedDiffNode>();
        final ArrayList<CombinedDiffNode> list2 = new ArrayList<CombinedDiffNode>();
        final CombinedDiffNode lastSelectedGraphNode = combinedCallGraphBaseTreeNode.getLastSelectedGraphNode();
        list.clear();
        list2.clear();
        if (lastSelectedGraphNode == null || combinedDiffNode.equals(lastSelectedGraphNode)) {
            selectGraphNode(combinedCallGraphFunctionTreeNode);
        }
        else {
            final Iterator iterator = graph.getNodes().iterator();
            while (iterator.hasNext()) {
                list2.add(iterator.next());
            }
            final ArrayList<CombinedDiffNode> list3 = new ArrayList<CombinedDiffNode>();
            boolean b = false;
            for (int i = 1; i < combinedCallGraphBaseTreeNode.getChildCount(); ++i) {
                final CombinedCallGraphFunctionTreeNode combinedCallGraphFunctionTreeNode2 = (CombinedCallGraphFunctionTreeNode)combinedCallGraphBaseTreeNode.getChildAt(i);
                final CombinedDiffNode combinedDiffNode2 = combinedCallGraphFunctionTreeNode2.getCombinedDiffNode();
                if (combinedDiffNode2.equals(lastSelectedGraphNode)) {
                    b = true;
                    if (list3.size() != 0) {
                        list3.add(combinedCallGraphFunctionTreeNode2.getCombinedDiffNode());
                        break;
                    }
                }
                if (combinedDiffNode2.equals(combinedDiffNode)) {
                    b = true;
                    if (list3.size() != 0) {
                        list3.add(combinedCallGraphFunctionTreeNode2.getCombinedDiffNode());
                        break;
                    }
                }
                if (b) {
                    list3.add(combinedCallGraphFunctionTreeNode2.getCombinedDiffNode());
                }
            }
            for (final CombinedDiffNode combinedDiffNode3 : list3) {
                list.add(combinedDiffNode3);
                list2.remove(combinedDiffNode3);
            }
            graph.selectNodes(list, list2);
        }
    }
    
    public static void handleMouseSelectionEvent(final MouseEvent mouseEvent, final CombinedCallGraphFunctionTreeNode combinedCallGraphFunctionTreeNode) {
        final boolean shiftDown = mouseEvent.isShiftDown();
        final boolean controlDown = mouseEvent.isControlDown();
        final boolean b = mouseEvent.getID() == 501;
        final boolean b2 = mouseEvent.getID() == 502;
        if (b && shiftDown && controlDown) {
            selectGraphNodeCtrlShift(combinedCallGraphFunctionTreeNode);
        }
        else if (b2 && controlDown && !shiftDown) {
            selectGraphNodeCtrl(combinedCallGraphFunctionTreeNode);
        }
        else if (b && !controlDown && shiftDown) {
            selectGraphNodeShift(combinedCallGraphFunctionTreeNode);
        }
        else if (b && !controlDown && !shiftDown) {
            selectGraphNode(combinedCallGraphFunctionTreeNode);
        }
    }
}
