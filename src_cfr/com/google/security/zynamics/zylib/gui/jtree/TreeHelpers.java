/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.jtree;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class TreeHelpers {
    private static void expandAll(JTree jTree, TreePath treePath, boolean bl2) {
        TreeNode treeNode = (TreeNode)treePath.getLastPathComponent();
        if (treeNode.getChildCount() >= 0) {
            Enumeration enumeration = treeNode.children();
            while (enumeration.hasMoreElements()) {
                TreeNode treeNode2 = (TreeNode)enumeration.nextElement();
                TreePath treePath2 = treePath.pathByAddingChild(treeNode2);
                TreeHelpers.expandAll(jTree, treePath2, bl2);
            }
        }
        if (bl2) {
            jTree.expandPath(treePath);
            return;
        }
        jTree.collapsePath(treePath);
    }

    private static boolean isDescendant(TreePath treePath, TreePath treePath2) {
        int n2;
        int n3 = treePath.getPathCount();
        if (n3 <= (n2 = treePath2.getPathCount())) {
            return false;
        }
        while (n3 != n2) {
            treePath = treePath.getParentPath();
            --n3;
        }
        return treePath.equals(treePath2);
    }

    public static boolean contains(JTree jTree, TreeNode treeNode) {
        return TreeHelpers.isAncestor(treeNode, (TreeNode)jTree.getModel().getRoot());
    }

    public static void expandAll(JTree jTree, boolean bl2) {
        TreeNode treeNode = (TreeNode)jTree.getModel().getRoot();
        TreeHelpers.expandAll(jTree, new TreePath(treeNode), bl2);
    }

    public static String getExpansionState(JTree jTree, int n2) {
        TreePath treePath = jTree.getPathForRow(n2);
        StringBuffer stringBuffer = new StringBuffer();
        int n3 = jTree.getRowCount();
        int n4 = n2;
        while (n4 < n3) {
            TreePath treePath2 = jTree.getPathForRow(n4);
            if (n4 != n2) {
                if (!TreeHelpers.isDescendant(treePath2, treePath)) return stringBuffer.toString();
            }
            if (jTree.isExpanded(treePath2)) {
                stringBuffer.append(",");
                stringBuffer.append(String.valueOf(n4 - n2));
            }
            ++n4;
        }
        return stringBuffer.toString();
    }

    public static List getLastExpandedNodes(JTree jTree) {
        ArrayList<DefaultMutableTreeNode> arrayList = new ArrayList<DefaultMutableTreeNode>();
        int n2 = jTree.getRowCount();
        int n3 = 0;
        while (n3 < n2) {
            TreePath treePath = jTree.getPathForRow(n3);
            DefaultMutableTreeNode defaultMutableTreeNode = null;
            try {
                defaultMutableTreeNode = (DefaultMutableTreeNode)treePath.getLastPathComponent();
            }
            catch (Exception var6_6) {
                throw new IllegalArgumentException("Cast failed! JTree must contain DefaultMuteableTreeNode or derived instances.");
            }
            if (defaultMutableTreeNode.isLeaf() || !jTree.isExpanded(treePath)) {
                arrayList.add((DefaultMutableTreeNode)defaultMutableTreeNode.getParent());
            }
            ++n3;
        }
        return arrayList;
    }

    public static Object getNodeAt(JTree jTree, int n2, int n3) {
        TreePath treePath = jTree.getPathForLocation(n2, n3);
        if (treePath == null) return null;
        Object object = treePath.getLastPathComponent();
        return object;
    }

    public static boolean isAncestor(TreeNode treeNode, TreeNode treeNode2) {
        if (treeNode2 == treeNode) {
            return true;
        }
        int n2 = 0;
        while (n2 < treeNode2.getChildCount()) {
            if (TreeHelpers.isAncestor(treeNode, treeNode2.getChildAt(n2))) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public static void restoreExpansionState(JTree jTree, int n2, String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
        while (stringTokenizer.hasMoreTokens()) {
            int n3 = n2 + Integer.parseInt(stringTokenizer.nextToken());
            jTree.expandRow(n3);
        }
    }
}

