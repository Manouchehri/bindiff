package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.*;
import javax.swing.border.*;
import javax.swing.event.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import java.io.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.jtree.*;
import javax.swing.tree.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.*;

public class WorkspaceTree extends JTree
{
    private final JPopupMenu popup;
    private final WorkspaceTreeModel workspaceTreeModel;
    private final RootNode rootNode;
    private final WorkspaceTabPanelFunctions controller;
    private final WorkspaceTree$InternalTreeSelectionListener treeSelectionListener;
    private final WorkspaceTree$InternalMouseListener mouseListener;
    private final WorkspaceTree$InternalWorkspaceModelListener mainWindowModelListener;
    private final ListenerProvider listeners;
    
    public WorkspaceTree(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.treeSelectionListener = new WorkspaceTree$InternalTreeSelectionListener(this, null);
        this.mouseListener = new WorkspaceTree$InternalMouseListener(this, null);
        this.mainWindowModelListener = new WorkspaceTree$InternalWorkspaceModelListener(this, null);
        this.listeners = new ListenerProvider();
        (this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions)).setWorkspaceTree(this);
        this.rootNode = new RootNode(this, this.controller);
        this.popup = new NoNodePopupMenu(this.controller);
        this.setRootVisible(false);
        this.setModel(this.workspaceTreeModel = new WorkspaceTreeModel(this, this.rootNode));
        this.setCellRenderer(new NodeRenderer());
        final DefaultTreeSelectionModel selectionModel = new DefaultTreeSelectionModel();
        selectionModel.setSelectionMode(1);
        this.setSelectionModel(selectionModel);
        this.setBorder(new EmptyBorder(2, 4, 2, 2));
        this.addTreeSelectionListener(this.treeSelectionListener);
        this.addMouseListener(this.mouseListener);
        this.controller.getWorkspace().addListener(this.mainWindowModelListener);
    }
    
    public static boolean hasFunctionDiffRelatives(final WorkspaceTree workspaceTree, final Diff diff) {
        if (!diff.isFunctionDiff()) {
            return false;
        }
        final TreeNode child = workspaceTree.getModel().getRoot().getChildAt(0);
        if (child.isLeaf()) {
            return false;
        }
        final File parentFile = diff.getMatchesDatabase().getParentFile();
        for (int i = 0; i < child.getChildCount(); ++i) {
            final FunctionDiffViewsTable functionDiffViewsTable = ((FunctionDiffViewsNode)child.getChildAt(i)).getComponent().getTables().get(0);
            if (functionDiffViewsTable.getRowCount() > 0 && parentFile.equals(AbstractTable.getRowDiff(functionDiffViewsTable, 0).getMatchesDatabase().getParentFile())) {
                return true;
            }
        }
        return false;
    }
    
    private void handleDoubleClick(final MouseEvent mouseEvent) {
        final AbstractTreeNode abstractTreeNode = (AbstractTreeNode)TreeHelpers.getNodeAt(this, mouseEvent.getX(), mouseEvent.getY());
        if (abstractTreeNode == null) {
            return;
        }
        abstractTreeNode.doubleClicked();
    }
    
    private void nodeSelected(final AbstractTreeNode abstractTreeNode) {
        this.controller.setTreeNodeContextComponent(abstractTreeNode.getComponent());
    }
    
    private void showPopupMenu(final MouseEvent mouseEvent) {
        final AbstractTreeNode abstractTreeNode = (AbstractTreeNode)TreeHelpers.getNodeAt(this, mouseEvent.getX(), mouseEvent.getY());
        if (abstractTreeNode != null) {
            this.setSelectionPath(new TreePath(abstractTreeNode.getPath()));
            final JPopupMenu popupMenu = abstractTreeNode.getPopupMenu();
            if (popupMenu != null) {
                popupMenu.show(this, mouseEvent.getX(), mouseEvent.getY());
            }
        }
        else {
            this.popup.show(this, mouseEvent.getX(), mouseEvent.getY());
        }
    }
    
    public void addListener(final IWorkspaceTreeListener workspaceTreeListener) {
        this.listeners.addListener(workspaceTreeListener);
    }
    
    public void closeFunctionDiffs() {
        ((AllFunctionDiffViewsNode)this.rootNode.getFirstChild()).deleteChildren();
        this.updateTree();
    }
    
    public void dispose() {
        this.removeTreeSelectionListener(this.treeSelectionListener);
        this.removeMouseListener(this.mouseListener);
        this.controller.getWorkspace().removeListener(this.mainWindowModelListener);
    }
    
    @Override
    public WorkspaceTreeModel getModel() {
        return this.workspaceTreeModel;
    }
    
    public void removeListener(final IWorkspaceTreeListener workspaceTreeListener) {
        this.listeners.removeListener(workspaceTreeListener);
    }
    
    public void updateTree() {
        this.getModel().nodeStructureChanged(this.rootNode);
    }
}
