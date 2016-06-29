/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.CallGraphNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.DiffNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.DiffNode$InternalDiffModelListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.MatchedFunctionViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.UnmatchedFunctionViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.IDiffListener;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.awt.Component;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import javax.swing.tree.MutableTreeNode;

public final class DiffNode
extends AbstractTreeNode {
    private static final ImageIcon ICON_UNLOADED = ImageUtils.getImageIcon("data/treeicons/diff-unloaded.png");
    private static final ImageIcon ICON_LOADED = ImageUtils.getImageIcon("data/treeicons/diff.png");
    private static final ImageIcon ICON_MISSING_DIFF_BINARAY = ImageUtils.getImageIcon("data/treeicons/missing-diff-db.png");
    private final DiffNode$InternalDiffModelListener diffModelListener;
    private final WorkspaceTabPanelFunctions controller;
    private final NodePopupMenu popupMenu;
    private final DiffTreeNodeContextPanel component;

    public DiffNode(Diff diff, WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super(workspaceTabPanelFunctions, diff);
        this.diffModelListener = new DiffNode$InternalDiffModelListener(this, null);
        this.controller = workspaceTabPanelFunctions;
        this.popupMenu = new NodePopupMenu(workspaceTabPanelFunctions);
        this.component = new DiffTreeNodeContextPanel(diff, workspaceTabPanelFunctions);
        diff.addListener(this.diffModelListener);
    }

    @Override
    protected void createChildren() {
        this.add(new CallGraphNode(this.getController(), this.getDiff()));
        this.add(new MatchedFunctionViewsNode(this.getController(), this.getDiff()));
        this.add(new UnmatchedFunctionViewsNode(this.getController(), this.getDiff(), ESide.PRIMARY));
        this.add(new UnmatchedFunctionViewsNode(this.getController(), this.getDiff(), ESide.SECONDARY));
    }

    @Override
    protected void delete() {
        this.getDiff().removeListener(this.diffModelListener);
        this.popupMenu.dispose();
        this.deleteChildren();
    }

    @Override
    public void doubleClicked() {
        this.controller.loadDiff(this.getDiff());
    }

    @Override
    public Component getComponent() {
        return this.component;
    }

    @Override
    public Icon getIcon() {
        ImageIcon imageIcon;
        if (!this.getDiff().getMatchesDatabase().exists()) return ICON_MISSING_DIFF_BINARAY;
        if (!this.getDiff().getExportFile(ESide.PRIMARY).exists()) return ICON_MISSING_DIFF_BINARAY;
        if (!this.getDiff().getExportFile(ESide.SECONDARY).exists()) {
            return ICON_MISSING_DIFF_BINARAY;
        }
        if (this.getDiff().isLoaded()) {
            imageIcon = ICON_LOADED;
            return imageIcon;
        }
        imageIcon = ICON_UNLOADED;
        return imageIcon;
    }

    @Override
    public JPopupMenu getPopupMenu() {
        return this.popupMenu;
    }

    @Override
    public String toString() {
        return this.getDiff().getMatchesDatabase().getParentFile().getName();
    }
}

