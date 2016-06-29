/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTree$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTree$InternalMouseListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTreeModel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.TreeNodeRenderer;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import com.google.security.zynamics.zylib.gui.jtree.TreeHelpers;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class JCriteriumTree
extends JTree {
    private final JCriteriumTree$InternalMouseListener mouseListener;
    private final JCriteriumTreeModel model;
    private TreePath currentCriteriumPath;

    public JCriteriumTree(CriteriumTree criteriumTree, List list) {
        this.mouseListener = new JCriteriumTree$InternalMouseListener(this, null);
        this.currentCriteriumPath = null;
        this.model = new JCriteriumTreeModel(this, criteriumTree, list);
        this.setRootVisible(true);
        this.setModel(this.model);
        this.setCellRenderer(new TreeNodeRenderer());
        this.addMouseListener(this.mouseListener);
        this.updateUI();
    }

    private void showPopupMenu(MouseEvent mouseEvent) {
        AbstractCriteriumTreeNode abstractCriteriumTreeNode = (AbstractCriteriumTreeNode)TreeHelpers.getNodeAt(this, mouseEvent.getX(), mouseEvent.getY());
        if (abstractCriteriumTreeNode == null) return;
        JPopupMenu jPopupMenu = abstractCriteriumTreeNode.getPopupMenu();
        if (jPopupMenu == null) return;
        jPopupMenu.show(this, mouseEvent.getX(), mouseEvent.getY());
    }

    public void delete() {
        this.removeMouseListener(this.mouseListener);
    }

    public TreePath getCurrentCriteriumPath() {
        return this.currentCriteriumPath;
    }

    @Override
    public JCriteriumTreeModel getModel() {
        return this.model;
    }

    public void setCurrentCriteriumPath(TreePath treePath) {
        this.currentCriteriumPath = treePath;
    }

    static /* synthetic */ TreePath access$102(JCriteriumTree jCriteriumTree, TreePath treePath) {
        jCriteriumTree.currentCriteriumPath = treePath;
        return jCriteriumTree.currentCriteriumPath;
    }

    static /* synthetic */ void access$200(JCriteriumTree jCriteriumTree, MouseEvent mouseEvent) {
        jCriteriumTree.showPopupMenu(mouseEvent);
    }
}

