package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.helper;

import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.*;
import com.google.security.zynamics.bindiff.graph.*;
import java.util.*;
import java.awt.event.*;

public final class MouseTreeNodeSelectionHandlerSingleBasicBlock
{
    private static void selectGraphNode(final SingleFlowGraphBasicBlockTreeNode singleFlowGraphBasicBlockTreeNode) {
        final SingleFlowGraphRootTreeNode rootNode = singleFlowGraphBasicBlockTreeNode.getRootNode();
        final SingleFlowGraphBaseTreeNode singleFlowGraphBaseTreeNode = (SingleFlowGraphBaseTreeNode)singleFlowGraphBasicBlockTreeNode.getParent();
        final SingleGraph graph = rootNode.getGraph();
        final SingleDiffNode singleDiffNode = singleFlowGraphBasicBlockTreeNode.getSingleDiffNode();
        final ArrayList<SingleDiffNode> list = new ArrayList<SingleDiffNode>();
        final ArrayList<SingleDiffNode> list2 = new ArrayList<SingleDiffNode>();
        final Iterator iterator = graph.getNodes().iterator();
        while (iterator.hasNext()) {
            list2.add(iterator.next());
        }
        if (!singleDiffNode.isSelected()) {
            singleFlowGraphBaseTreeNode.setLastSelectedGraphNode(singleDiffNode);
            list2.remove(singleDiffNode);
            list.add(singleDiffNode);
        }
        else {
            singleFlowGraphBaseTreeNode.setLastSelectedGraphNode(null);
        }
        graph.selectNodes(list, list2);
    }
    
    private static void selectGraphNodeCtrl(final SingleFlowGraphBasicBlockTreeNode singleFlowGraphBasicBlockTreeNode) {
        final SingleFlowGraphRootTreeNode rootNode = singleFlowGraphBasicBlockTreeNode.getRootNode();
        final SingleFlowGraphBaseTreeNode singleFlowGraphBaseTreeNode = (SingleFlowGraphBaseTreeNode)singleFlowGraphBasicBlockTreeNode.getParent();
        final SingleGraph graph = rootNode.getGraph();
        final SingleDiffNode singleDiffNode = singleFlowGraphBasicBlockTreeNode.getSingleDiffNode();
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
            singleFlowGraphBaseTreeNode.setLastSelectedGraphNode(singleDiffNode);
            list.add(singleDiffNode);
            list2.remove(singleDiffNode);
        }
        else {
            singleFlowGraphBaseTreeNode.setLastSelectedGraphNode(null);
            list2.add(singleDiffNode);
            list.remove(singleDiffNode);
        }
        graph.selectNodes(list, list2);
    }
    
    private static void selectGraphNodeCtrlShift(final SingleFlowGraphBasicBlockTreeNode singleFlowGraphBasicBlockTreeNode) {
        final SingleFlowGraphRootTreeNode rootNode = singleFlowGraphBasicBlockTreeNode.getRootNode();
        final SingleFlowGraphBaseTreeNode singleFlowGraphBaseTreeNode = (SingleFlowGraphBaseTreeNode)singleFlowGraphBasicBlockTreeNode.getParent();
        final SingleGraph graph = rootNode.getGraph();
        final SingleDiffNode singleDiffNode = singleFlowGraphBasicBlockTreeNode.getSingleDiffNode();
        final ArrayList<SingleDiffNode> list = new ArrayList<SingleDiffNode>();
        final ArrayList<SingleDiffNode> list2 = new ArrayList<SingleDiffNode>();
        final SingleDiffNode lastSelectedGraphNode = singleFlowGraphBaseTreeNode.getLastSelectedGraphNode();
        if (lastSelectedGraphNode == null) {
            selectGraphNode(singleFlowGraphBasicBlockTreeNode);
        }
        else if (singleDiffNode.equals(lastSelectedGraphNode)) {
            selectGraphNodeCtrl(singleFlowGraphBasicBlockTreeNode);
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
            for (int i = 1; i < singleFlowGraphBaseTreeNode.getChildCount(); ++i) {
                final SingleFlowGraphBasicBlockTreeNode singleFlowGraphBasicBlockTreeNode2 = (SingleFlowGraphBasicBlockTreeNode)singleFlowGraphBaseTreeNode.getChildAt(i);
                final SingleDiffNode singleDiffNode3 = singleFlowGraphBasicBlockTreeNode2.getSingleDiffNode();
                if (singleDiffNode3.equals(lastSelectedGraphNode)) {
                    b = true;
                    if (list3.size() != 0) {
                        list3.add(singleFlowGraphBasicBlockTreeNode2.getSingleDiffNode());
                        break;
                    }
                }
                if (singleDiffNode3.equals(singleDiffNode)) {
                    b = true;
                    if (list3.size() != 0) {
                        list3.add(singleFlowGraphBasicBlockTreeNode2.getSingleDiffNode());
                        break;
                    }
                }
                if (b) {
                    list3.add(singleFlowGraphBasicBlockTreeNode2.getSingleDiffNode());
                }
            }
            for (final SingleDiffNode singleDiffNode4 : list3) {
                list.add(singleDiffNode4);
                list2.remove(singleDiffNode4);
            }
            graph.selectNodes(list, list2);
        }
    }
    
    private static void selectGraphNodeShift(final SingleFlowGraphBasicBlockTreeNode singleFlowGraphBasicBlockTreeNode) {
        final SingleFlowGraphRootTreeNode rootNode = singleFlowGraphBasicBlockTreeNode.getRootNode();
        final SingleFlowGraphBaseTreeNode singleFlowGraphBaseTreeNode = (SingleFlowGraphBaseTreeNode)singleFlowGraphBasicBlockTreeNode.getParent();
        final SingleGraph graph = rootNode.getGraph();
        final SingleDiffNode singleDiffNode = singleFlowGraphBasicBlockTreeNode.getSingleDiffNode();
        final ArrayList<SingleDiffNode> list = new ArrayList<SingleDiffNode>();
        final ArrayList<SingleDiffNode> list2 = new ArrayList<SingleDiffNode>();
        final SingleDiffNode lastSelectedGraphNode = singleFlowGraphBaseTreeNode.getLastSelectedGraphNode();
        list.clear();
        list2.clear();
        if (lastSelectedGraphNode == null || singleDiffNode.equals(lastSelectedGraphNode)) {
            selectGraphNode(singleFlowGraphBasicBlockTreeNode);
        }
        else {
            final Iterator iterator = graph.getNodes().iterator();
            while (iterator.hasNext()) {
                list2.add(iterator.next());
            }
            final ArrayList<SingleDiffNode> list3 = new ArrayList<SingleDiffNode>();
            boolean b = false;
            for (int i = 1; i < singleFlowGraphBaseTreeNode.getChildCount(); ++i) {
                final SingleFlowGraphBasicBlockTreeNode singleFlowGraphBasicBlockTreeNode2 = (SingleFlowGraphBasicBlockTreeNode)singleFlowGraphBaseTreeNode.getChildAt(i);
                final SingleDiffNode singleDiffNode2 = singleFlowGraphBasicBlockTreeNode2.getSingleDiffNode();
                if (singleDiffNode2.equals(lastSelectedGraphNode)) {
                    b = true;
                    if (list3.size() != 0) {
                        list3.add(singleFlowGraphBasicBlockTreeNode2.getSingleDiffNode());
                        break;
                    }
                }
                if (singleDiffNode2.equals(singleDiffNode)) {
                    b = true;
                    if (list3.size() != 0) {
                        list3.add(singleFlowGraphBasicBlockTreeNode2.getSingleDiffNode());
                        break;
                    }
                }
                if (b) {
                    list3.add(singleFlowGraphBasicBlockTreeNode2.getSingleDiffNode());
                }
            }
            for (final SingleDiffNode singleDiffNode3 : list3) {
                list.add(singleDiffNode3);
                list2.remove(singleDiffNode3);
            }
            graph.selectNodes(list, list2);
        }
    }
    
    public static void handleMouseSelectionEvent(final MouseEvent mouseEvent, final SingleFlowGraphBasicBlockTreeNode singleFlowGraphBasicBlockTreeNode) {
        final boolean shiftDown = mouseEvent.isShiftDown();
        final boolean controlDown = mouseEvent.isControlDown();
        final boolean b = mouseEvent.getID() == 501;
        final boolean b2 = mouseEvent.getID() == 502;
        if (b && controlDown && shiftDown) {
            selectGraphNodeCtrlShift(singleFlowGraphBasicBlockTreeNode);
        }
        else if (b2 && controlDown && !shiftDown) {
            selectGraphNodeCtrl(singleFlowGraphBasicBlockTreeNode);
        }
        else if (b && !controlDown && shiftDown) {
            selectGraphNodeShift(singleFlowGraphBasicBlockTreeNode);
        }
        else if (b && !controlDown && !shiftDown) {
            selectGraphNode(singleFlowGraphBasicBlockTreeNode);
        }
    }
}
