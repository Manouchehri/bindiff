package com.google.security.zynamics.zylib.gui.jtree;

import javax.swing.*;
import javax.swing.tree.*;
import java.util.*;

public class TreeHelpers
{
    private static void expandAll(final JTree tree, final TreePath treePath, final boolean b) {
        final TreeNode treeNode = (TreeNode)treePath.getLastPathComponent();
        if (treeNode.getChildCount() >= 0) {
            final Enumeration children = treeNode.children();
            while (children.hasMoreElements()) {
                expandAll(tree, treePath.pathByAddingChild(children.nextElement()), b);
            }
        }
        if (b) {
            tree.expandPath(treePath);
        }
        else {
            tree.collapsePath(treePath);
        }
    }
    
    private static boolean isDescendant(TreePath parentPath, final TreePath treePath) {
        int i = parentPath.getPathCount();
        final int pathCount = treePath.getPathCount();
        if (i <= pathCount) {
            return false;
        }
        while (i != pathCount) {
            parentPath = parentPath.getParentPath();
            --i;
        }
        return parentPath.equals(treePath);
    }
    
    public static boolean contains(final JTree tree, final TreeNode treeNode) {
        return isAncestor(treeNode, (TreeNode)tree.getModel().getRoot());
    }
    
    public static void expandAll(final JTree tree, final boolean b) {
        expandAll(tree, new TreePath(tree.getModel().getRoot()), b);
    }
    
    public static String getExpansionState(final JTree tree, final int n) {
        final TreePath pathForRow = tree.getPathForRow(n);
        final StringBuffer sb = new StringBuffer();
        for (int rowCount = tree.getRowCount(), i = n; i < rowCount; ++i) {
            final TreePath pathForRow2 = tree.getPathForRow(i);
            if (i != n && !isDescendant(pathForRow2, pathForRow)) {
                break;
            }
            if (tree.isExpanded(pathForRow2)) {
                sb.append(",");
                sb.append(String.valueOf(i - n));
            }
        }
        return sb.toString();
    }
    
    public static List getLastExpandedNodes(final JTree tree) {
        final ArrayList<DefaultMutableTreeNode> list = new ArrayList<DefaultMutableTreeNode>();
        for (int rowCount = tree.getRowCount(), i = 0; i < rowCount; ++i) {
            final TreePath pathForRow = tree.getPathForRow(i);
            DefaultMutableTreeNode defaultMutableTreeNode;
            try {
                defaultMutableTreeNode = (DefaultMutableTreeNode)pathForRow.getLastPathComponent();
            }
            catch (Exception ex) {
                throw new IllegalArgumentException("Cast failed! JTree must contain DefaultMuteableTreeNode or derived instances.");
            }
            if (defaultMutableTreeNode.isLeaf() || !tree.isExpanded(pathForRow)) {
                list.add((DefaultMutableTreeNode)defaultMutableTreeNode.getParent());
            }
        }
        return list;
    }
    
    public static Object getNodeAt(final JTree tree, final int n, final int n2) {
        final TreePath pathForLocation = tree.getPathForLocation(n, n2);
        return (pathForLocation != null) ? pathForLocation.getLastPathComponent() : null;
    }
    
    public static boolean isAncestor(final TreeNode treeNode, final TreeNode treeNode2) {
        if (treeNode2 == treeNode) {
            return true;
        }
        for (int i = 0; i < treeNode2.getChildCount(); ++i) {
            if (isAncestor(treeNode, treeNode2.getChildAt(i))) {
                return true;
            }
        }
        return false;
    }
    
    public static void restoreExpansionState(final JTree tree, final int n, final String s) {
        final StringTokenizer stringTokenizer = new StringTokenizer(s, ",");
        while (stringTokenizer.hasMoreTokens()) {
            tree.expandRow(n + Integer.parseInt(stringTokenizer.nextToken()));
        }
    }
}
