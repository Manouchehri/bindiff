package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper;

import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.*;
import com.google.security.zynamics.bindiff.graph.*;
import java.util.*;
import java.awt.event.*;

public class MouseTreeNodeSelectionHandlerSingleFunction
{
    private static void selectGraphNode(final SingleCallGraphFunctionTreeNode singleCallGraphFunctionTreeNode) {
        final SingleCallGraphRootTreeNode rootNode = singleCallGraphFunctionTreeNode.getRootNode();
        final SingleCallGraphBaseTreeNode singleCallGraphBaseTreeNode = (SingleCallGraphBaseTreeNode)singleCallGraphFunctionTreeNode.getParent();
        final SingleGraph graph = rootNode.getGraph();
        final SingleDiffNode singleDiffNode = singleCallGraphFunctionTreeNode.getSingleDiffNode();
        final ArrayList<SingleDiffNode> list = new ArrayList<SingleDiffNode>();
        final ArrayList<SingleDiffNode> list2 = new ArrayList<SingleDiffNode>();
        final Iterator iterator = graph.getNodes().iterator();
        while (iterator.hasNext()) {
            list2.add(iterator.next());
        }
        if (!singleDiffNode.isSelected()) {
            singleCallGraphBaseTreeNode.setLastSelectedGraphNode(singleDiffNode);
            list2.remove(singleDiffNode);
            list.add(singleDiffNode);
        }
        else {
            singleCallGraphBaseTreeNode.setLastSelectedGraphNode(null);
        }
        graph.selectNodes(list, list2);
    }
    
    private static void selectGraphNodeCtrl(final SingleCallGraphFunctionTreeNode singleCallGraphFunctionTreeNode) {
        final SingleCallGraphRootTreeNode rootNode = singleCallGraphFunctionTreeNode.getRootNode();
        final SingleCallGraphBaseTreeNode singleCallGraphBaseTreeNode = (SingleCallGraphBaseTreeNode)singleCallGraphFunctionTreeNode.getParent();
        final SingleGraph graph = rootNode.getGraph();
        final SingleDiffNode singleDiffNode = singleCallGraphFunctionTreeNode.getSingleDiffNode();
        final ArrayList<SingleDiffNode> list = new ArrayList<SingleDiffNode>();
        final ArrayList<SingleDiffNode> list2 = new ArrayList<SingleDiffNode>();
        for (final SingleDiffNode singleDiffNode2 : graph.getNodes()) {
            if (singleDiffNode2.isSelected()) {
                list.add(singleDiffNode2);
            }
            else {
                list2.add(singleDiffNode2);
            }
        }
        if (!singleDiffNode.isSelected()) {
            singleCallGraphBaseTreeNode.setLastSelectedGraphNode(singleDiffNode);
            list.add(singleDiffNode);
            list2.remove(singleDiffNode);
        }
        else {
            singleCallGraphBaseTreeNode.setLastSelectedGraphNode(null);
            list2.add(singleDiffNode);
            list.remove(singleDiffNode);
        }
        graph.selectNodes(list, list2);
    }
    
    private static void selectGraphNodeCtrlShift(final SingleCallGraphFunctionTreeNode singleCallGraphFunctionTreeNode) {
        final SingleCallGraphRootTreeNode rootNode = singleCallGraphFunctionTreeNode.getRootNode();
        final SingleCallGraphBaseTreeNode singleCallGraphBaseTreeNode = (SingleCallGraphBaseTreeNode)singleCallGraphFunctionTreeNode.getParent();
        final SingleGraph graph = rootNode.getGraph();
        final SingleDiffNode singleDiffNode = singleCallGraphFunctionTreeNode.getSingleDiffNode();
        final ArrayList<SingleDiffNode> list = new ArrayList<SingleDiffNode>();
        final ArrayList<SingleDiffNode> list2 = new ArrayList<SingleDiffNode>();
        final SingleDiffNode lastSelectedGraphNode = singleCallGraphBaseTreeNode.getLastSelectedGraphNode();
        if (lastSelectedGraphNode == null) {
            selectGraphNode(singleCallGraphFunctionTreeNode);
        }
        else if (singleDiffNode.equals(lastSelectedGraphNode)) {
            selectGraphNodeCtrl(singleCallGraphFunctionTreeNode);
        }
        else {
            for (final SingleDiffNode singleDiffNode2 : graph.getNodes()) {
                if (singleDiffNode2.isSelected()) {
                    list.add(singleDiffNode2);
                }
                else {
                    list2.add(singleDiffNode2);
                }
            }
            final ArrayList<SingleDiffNode> list3 = new ArrayList<SingleDiffNode>();
            boolean b = false;
            for (int i = 1; i < singleCallGraphBaseTreeNode.getChildCount(); ++i) {
                final SingleCallGraphFunctionTreeNode singleCallGraphFunctionTreeNode2 = (SingleCallGraphFunctionTreeNode)singleCallGraphBaseTreeNode.getChildAt(i);
                final SingleDiffNode singleDiffNode3 = singleCallGraphFunctionTreeNode2.getSingleDiffNode();
                if (singleDiffNode3.equals(lastSelectedGraphNode)) {
                    b = true;
                    if (list3.size() != 0) {
                        list3.add(singleCallGraphFunctionTreeNode2.getSingleDiffNode());
                        break;
                    }
                }
                if (singleDiffNode3.equals(singleDiffNode)) {
                    b = true;
                    if (list3.size() != 0) {
                        list3.add(singleCallGraphFunctionTreeNode2.getSingleDiffNode());
                        break;
                    }
                }
                if (b) {
                    list3.add(singleCallGraphFunctionTreeNode2.getSingleDiffNode());
                }
            }
            for (final SingleDiffNode singleDiffNode4 : list3) {
                list.add(singleDiffNode4);
                list2.remove(singleDiffNode4);
            }
            graph.selectNodes(list, list2);
        }
    }
    
    private static void selectGraphNodeShift(final SingleCallGraphFunctionTreeNode singleCallGraphFunctionTreeNode) {
        final SingleCallGraphRootTreeNode rootNode = singleCallGraphFunctionTreeNode.getRootNode();
        final SingleCallGraphBaseTreeNode singleCallGraphBaseTreeNode = (SingleCallGraphBaseTreeNode)singleCallGraphFunctionTreeNode.getParent();
        final SingleGraph graph = rootNode.getGraph();
        final SingleDiffNode singleDiffNode = singleCallGraphFunctionTreeNode.getSingleDiffNode();
        final ArrayList<SingleDiffNode> list = new ArrayList<SingleDiffNode>();
        final ArrayList<SingleDiffNode> list2 = new ArrayList<SingleDiffNode>();
        final SingleDiffNode lastSelectedGraphNode = singleCallGraphBaseTreeNode.getLastSelectedGraphNode();
        list.clear();
        list2.clear();
        if (lastSelectedGraphNode == null || singleDiffNode.equals(lastSelectedGraphNode)) {
            selectGraphNode(singleCallGraphFunctionTreeNode);
        }
        else {
            final Iterator iterator = graph.getNodes().iterator();
            while (iterator.hasNext()) {
                list2.add(iterator.next());
            }
            final ArrayList<SingleDiffNode> list3 = new ArrayList<SingleDiffNode>();
            boolean b = false;
            for (int i = 1; i < singleCallGraphBaseTreeNode.getChildCount(); ++i) {
                final SingleCallGraphFunctionTreeNode singleCallGraphFunctionTreeNode2 = (SingleCallGraphFunctionTreeNode)singleCallGraphBaseTreeNode.getChildAt(i);
                final SingleDiffNode singleDiffNode2 = singleCallGraphFunctionTreeNode2.getSingleDiffNode();
                if (singleDiffNode2.equals(lastSelectedGraphNode)) {
                    b = true;
                    if (list3.size() != 0) {
                        list3.add(singleCallGraphFunctionTreeNode2.getSingleDiffNode());
                        break;
                    }
                }
                if (singleDiffNode2.equals(singleDiffNode)) {
                    b = true;
                    if (list3.size() != 0) {
                        list3.add(singleCallGraphFunctionTreeNode2.getSingleDiffNode());
                        break;
                    }
                }
                if (b) {
                    list3.add(singleCallGraphFunctionTreeNode2.getSingleDiffNode());
                }
            }
            for (final SingleDiffNode singleDiffNode3 : list3) {
                list.add(singleDiffNode3);
                list2.remove(singleDiffNode3);
            }
            graph.selectNodes(list, list2);
        }
    }
    
    public static void handleMouseSelectionEvent(final MouseEvent mouseEvent, final SingleCallGraphFunctionTreeNode singleCallGraphFunctionTreeNode) {
        final boolean shiftDown = mouseEvent.isShiftDown();
        final boolean controlDown = mouseEvent.isControlDown();
        final boolean b = mouseEvent.getID() == 501;
        final boolean b2 = mouseEvent.getID() == 502;
        if (b && shiftDown && controlDown) {
            selectGraphNodeCtrlShift(singleCallGraphFunctionTreeNode);
        }
        else if (b2 && controlDown && !shiftDown) {
            selectGraphNodeCtrl(singleCallGraphFunctionTreeNode);
        }
        else if (b && !controlDown && shiftDown) {
            selectGraphNodeShift(singleCallGraphFunctionTreeNode);
        }
        else if (b && !controlDown && !shiftDown) {
            selectGraphNode(singleCallGraphFunctionTreeNode);
        }
    }
}
