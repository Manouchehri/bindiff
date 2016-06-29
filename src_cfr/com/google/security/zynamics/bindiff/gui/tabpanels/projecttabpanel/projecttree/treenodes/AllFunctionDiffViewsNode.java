/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.FunctionDiffContainerNodePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.FunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsContainerNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTableModel;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class AllFunctionDiffViewsNode
extends AbstractTreeNode {
    private static final ImageIcon ICON = ImageUtils.getImageIcon("data/treeicons/function-diffs-container.png");
    private final FunctionDiffViewsContainerNodeContextPanel component;

    public AllFunctionDiffViewsNode(WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super(workspaceTabPanelFunctions, null);
        this.component = new FunctionDiffViewsContainerNodeContextPanel(this.getController());
    }

    private Map fillImageDiffViewsListMap() {
        Workspace workspace = this.getController().getWorkspace();
        HashMap<File, ArrayList<Diff>> hashMap = new HashMap<File, ArrayList<Diff>>();
        Iterator iterator = workspace.getDiffList(true).iterator();
        while (iterator.hasNext()) {
            Diff diff = (Diff)iterator.next();
            File file = diff.getMatchesDatabase().getParentFile();
            ArrayList<Diff> arrayList = (ArrayList<Diff>)hashMap.get(file);
            if (arrayList == null) {
                arrayList = new ArrayList<Diff>();
            }
            arrayList.add(diff);
            hashMap.put(file, arrayList);
        }
        return hashMap;
    }

    @Override
    protected void createChildren() {
        Map.Entry entry;
        Map map = this.fillImageDiffViewsListMap();
        HashMap<File, FunctionDiffViewsNode> hashMap = new HashMap<File, FunctionDiffViewsNode>();
        for (int i2 = 0; i2 < this.getChildCount(); ++i2) {
            entry = (FunctionDiffViewsNode)this.getChildAt(i2);
            hashMap.put(entry.getViewDirectory(), (FunctionDiffViewsNode)((Object)entry));
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            entry = iterator.next();
            FunctionDiffViewsNode functionDiffViewsNode = (FunctionDiffViewsNode)hashMap.get(entry.getKey());
            if (functionDiffViewsNode != null) {
                FunctionDiffViewsNodeContextPanel functionDiffViewsNodeContextPanel = functionDiffViewsNode.getComponent();
                functionDiffViewsNodeContextPanel.getFunctionViewsTableModel().setFunctionDiffList((List)entry.getValue());
                functionDiffViewsNodeContextPanel.updateUI();
                continue;
            }
            this.add(new FunctionDiffViewsNode(this.getController(), (File)entry.getKey(), (List)entry.getValue()));
        }
    }

    @Override
    protected void delete() {
        this.component.dispose();
    }

    public void addDiff(Diff diff) {
        if (!diff.isFunctionDiff()) return;
        if (WorkspaceTree.hasFunctionDiffRelatives(this.getTree(), diff)) return;
        if (this.isLeaf()) return;
        File file = new File(diff.getMatchesDatabase().getParent());
        this.add(new FunctionDiffViewsNode(this.getController(), file, new ArrayList()));
    }

    @Override
    public void doubleClicked() {
        if (this.getController().getWorkspace().getDiffList(true).size() <= 0) return;
        this.getController().loadFunctionDiffs();
        this.createChildren();
    }

    @Override
    public FunctionDiffViewsContainerNodeContextPanel getComponent() {
        return this.component;
    }

    @Override
    public Icon getIcon() {
        return ICON;
    }

    @Override
    public JPopupMenu getPopupMenu() {
        return new FunctionDiffContainerNodePopupMenu(this.getController());
    }

    @Override
    public String toString() {
        return String.format("Single Function Diff Views (%d)", this.getController().getWorkspace().getDiffList(true).size());
    }
}

