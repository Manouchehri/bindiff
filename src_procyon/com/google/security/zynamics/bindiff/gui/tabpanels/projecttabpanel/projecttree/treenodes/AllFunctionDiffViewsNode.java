package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.*;
import java.io.*;
import java.util.*;
import javax.swing.tree.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.utils.*;

public class AllFunctionDiffViewsNode extends AbstractTreeNode
{
    private static final ImageIcon ICON;
    private final FunctionDiffViewsContainerNodeContextPanel component;
    
    public AllFunctionDiffViewsNode(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super(workspaceTabPanelFunctions, null);
        this.component = new FunctionDiffViewsContainerNodeContextPanel(this.getController());
    }
    
    private Map fillImageDiffViewsListMap() {
        final Workspace workspace = this.getController().getWorkspace();
        final HashMap<File, List<Diff>> hashMap = (HashMap<File, List<Diff>>)new HashMap<Object, List<Diff>>();
        for (final Diff diff : workspace.getDiffList(true)) {
            final File parentFile = diff.getMatchesDatabase().getParentFile();
            List<Diff> list = hashMap.get(parentFile);
            if (list == null) {
                list = new ArrayList<Diff>();
            }
            list.add(diff);
            hashMap.put(parentFile, list);
        }
        return hashMap;
    }
    
    @Override
    protected void createChildren() {
        final Map fillImageDiffViewsListMap = this.fillImageDiffViewsListMap();
        final HashMap<Object, FunctionDiffViewsNode> hashMap = new HashMap<Object, FunctionDiffViewsNode>();
        for (int i = 0; i < this.getChildCount(); ++i) {
            final FunctionDiffViewsNode functionDiffViewsNode = (FunctionDiffViewsNode)this.getChildAt(i);
            hashMap.put(functionDiffViewsNode.getViewDirectory(), functionDiffViewsNode);
        }
        for (final Map.Entry<Object, V> entry : fillImageDiffViewsListMap.entrySet()) {
            final FunctionDiffViewsNode functionDiffViewsNode2 = hashMap.get(entry.getKey());
            if (functionDiffViewsNode2 != null) {
                final FunctionDiffViewsNodeContextPanel component = functionDiffViewsNode2.getComponent();
                component.getFunctionViewsTableModel().setFunctionDiffList((List)entry.getValue());
                component.updateUI();
            }
            else {
                this.add(new FunctionDiffViewsNode(this.getController(), entry.getKey(), (List)entry.getValue()));
            }
        }
    }
    
    @Override
    protected void delete() {
        this.component.dispose();
    }
    
    public void addDiff(final Diff diff) {
        if (diff.isFunctionDiff() && !WorkspaceTree.hasFunctionDiffRelatives(this.getTree(), diff) && !this.isLeaf()) {
            this.add(new FunctionDiffViewsNode(this.getController(), new File(diff.getMatchesDatabase().getParent()), new ArrayList()));
        }
    }
    
    @Override
    public void doubleClicked() {
        if (this.getController().getWorkspace().getDiffList(true).size() > 0) {
            this.getController().loadFunctionDiffs();
            this.createChildren();
        }
    }
    
    @Override
    public FunctionDiffViewsContainerNodeContextPanel getComponent() {
        return this.component;
    }
    
    @Override
    public Icon getIcon() {
        return AllFunctionDiffViewsNode.ICON;
    }
    
    @Override
    public JPopupMenu getPopupMenu() {
        return new FunctionDiffContainerNodePopupMenu(this.getController());
    }
    
    @Override
    public String toString() {
        return String.format("Single Function Diff Views (%d)", this.getController().getWorkspace().getDiffList(true).size());
    }
    
    static {
        ICON = ImageUtils.getImageIcon("data/treeicons/function-diffs-container.png");
    }
}
