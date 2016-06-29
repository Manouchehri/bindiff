/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.IWorkspaceTreeListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree$InternalMouseListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree$InternalTreeSelectionListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree$InternalWorkspaceModelListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTreeModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NoNodePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AllFunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.FunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.NodeRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.RootNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTable;
import com.google.security.zynamics.bindiff.project.IWorkspaceListener;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.jtree.TreeHelpers;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.List;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class WorkspaceTree
extends JTree {
    private final JPopupMenu popup;
    private final WorkspaceTreeModel workspaceTreeModel;
    private final RootNode rootNode;
    private final WorkspaceTabPanelFunctions controller;
    private final WorkspaceTree$InternalTreeSelectionListener treeSelectionListener;
    private final WorkspaceTree$InternalMouseListener mouseListener;
    private final WorkspaceTree$InternalWorkspaceModelListener mainWindowModelListener;
    private final ListenerProvider listeners;

    public WorkspaceTree(WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.treeSelectionListener = new WorkspaceTree$InternalTreeSelectionListener(this, null);
        this.mouseListener = new WorkspaceTree$InternalMouseListener(this, null);
        this.mainWindowModelListener = new WorkspaceTree$InternalWorkspaceModelListener(this, null);
        this.listeners = new ListenerProvider();
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.controller.setWorkspaceTree(this);
        this.rootNode = new RootNode(this, this.controller);
        this.popup = new NoNodePopupMenu(this.controller);
        this.setRootVisible(false);
        this.workspaceTreeModel = new WorkspaceTreeModel(this, this.rootNode);
        this.setModel(this.workspaceTreeModel);
        this.setCellRenderer(new NodeRenderer());
        DefaultTreeSelectionModel defaultTreeSelectionModel = new DefaultTreeSelectionModel();
        defaultTreeSelectionModel.setSelectionMode(1);
        this.setSelectionModel(defaultTreeSelectionModel);
        this.setBorder(new EmptyBorder(2, 4, 2, 2));
        this.addTreeSelectionListener(this.treeSelectionListener);
        this.addMouseListener(this.mouseListener);
        this.controller.getWorkspace().addListener(this.mainWindowModelListener);
    }

    public static boolean hasFunctionDiffRelatives(WorkspaceTree workspaceTree, Diff diff) {
        if (!diff.isFunctionDiff()) {
            return false;
        }
        TreeNode treeNode = workspaceTree.getModel().getRoot().getChildAt(0);
        if (treeNode.isLeaf()) {
            return false;
        }
        File file = diff.getMatchesDatabase().getParentFile();
        int n2 = 0;
        while (n2 < treeNode.getChildCount()) {
            FunctionDiffViewsNode functionDiffViewsNode = (FunctionDiffViewsNode)treeNode.getChildAt(n2);
            FunctionDiffViewsNodeContextPanel functionDiffViewsNodeContextPanel = functionDiffViewsNode.getComponent();
            FunctionDiffViewsTable functionDiffViewsTable = (FunctionDiffViewsTable)functionDiffViewsNodeContextPanel.getTables().get(0);
            if (functionDiffViewsTable.getRowCount() > 0 && file.equals(AbstractTable.getRowDiff(functionDiffViewsTable, 0).getMatchesDatabase().getParentFile())) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    private void handleDoubleClick(MouseEvent mouseEvent) {
        AbstractTreeNode abstractTreeNode = (AbstractTreeNode)TreeHelpers.getNodeAt(this, mouseEvent.getX(), mouseEvent.getY());
        if (abstractTreeNode == null) {
            return;
        }
        abstractTreeNode.doubleClicked();
    }

    private void nodeSelected(AbstractTreeNode abstractTreeNode) {
        this.controller.setTreeNodeContextComponent(abstractTreeNode.getComponent());
    }

    private void showPopupMenu(MouseEvent mouseEvent) {
        AbstractTreeNode abstractTreeNode = (AbstractTreeNode)TreeHelpers.getNodeAt(this, mouseEvent.getX(), mouseEvent.getY());
        if (abstractTreeNode != null) {
            this.setSelectionPath(new TreePath(abstractTreeNode.getPath()));
            JPopupMenu jPopupMenu = abstractTreeNode.getPopupMenu();
            if (jPopupMenu == null) return;
            jPopupMenu.show(this, mouseEvent.getX(), mouseEvent.getY());
            return;
        }
        this.popup.show(this, mouseEvent.getX(), mouseEvent.getY());
    }

    public void addListener(IWorkspaceTreeListener iWorkspaceTreeListener) {
        this.listeners.addListener(iWorkspaceTreeListener);
    }

    public void closeFunctionDiffs() {
        AllFunctionDiffViewsNode allFunctionDiffViewsNode = (AllFunctionDiffViewsNode)this.rootNode.getFirstChild();
        allFunctionDiffViewsNode.deleteChildren();
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

    public void removeListener(IWorkspaceTreeListener iWorkspaceTreeListener) {
        this.listeners.removeListener(iWorkspaceTreeListener);
    }

    public void updateTree() {
        this.getModel().nodeStructureChanged(this.rootNode);
    }

    static /* synthetic */ void access$300(WorkspaceTree workspaceTree, MouseEvent mouseEvent) {
        workspaceTree.showPopupMenu(mouseEvent);
    }

    static /* synthetic */ void access$400(WorkspaceTree workspaceTree, MouseEvent mouseEvent) {
        workspaceTree.handleDoubleClick(mouseEvent);
    }

    static /* synthetic */ void access$500(WorkspaceTree workspaceTree, AbstractTreeNode abstractTreeNode) {
        workspaceTree.nodeSelected(abstractTreeNode);
    }

    static /* synthetic */ RootNode access$600(WorkspaceTree workspaceTree) {
        return workspaceTree.rootNode;
    }

    static /* synthetic */ ListenerProvider access$700(WorkspaceTree workspaceTree) {
        return workspaceTree.listeners;
    }
}

