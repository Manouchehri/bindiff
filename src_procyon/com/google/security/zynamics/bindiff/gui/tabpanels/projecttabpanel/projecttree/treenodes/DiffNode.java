package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import javax.swing.tree.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.awt.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.utils.*;

public final class DiffNode extends AbstractTreeNode
{
    private static final ImageIcon ICON_UNLOADED;
    private static final ImageIcon ICON_LOADED;
    private static final ImageIcon ICON_MISSING_DIFF_BINARAY;
    private final DiffNode$InternalDiffModelListener diffModelListener;
    private final WorkspaceTabPanelFunctions controller;
    private final NodePopupMenu popupMenu;
    private final DiffTreeNodeContextPanel component;
    
    public DiffNode(final Diff diff, final WorkspaceTabPanelFunctions controller) {
        super(controller, diff);
        this.diffModelListener = new DiffNode$InternalDiffModelListener(this, null);
        this.controller = controller;
        this.popupMenu = new NodePopupMenu(controller);
        this.component = new DiffTreeNodeContextPanel(diff, controller);
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
        if (!this.getDiff().getMatchesDatabase().exists() || !this.getDiff().getExportFile(ESide.PRIMARY).exists() || !this.getDiff().getExportFile(ESide.SECONDARY).exists()) {
            return DiffNode.ICON_MISSING_DIFF_BINARAY;
        }
        return this.getDiff().isLoaded() ? DiffNode.ICON_LOADED : DiffNode.ICON_UNLOADED;
    }
    
    @Override
    public JPopupMenu getPopupMenu() {
        return this.popupMenu;
    }
    
    @Override
    public String toString() {
        return this.getDiff().getMatchesDatabase().getParentFile().getName();
    }
    
    static {
        ICON_UNLOADED = ImageUtils.getImageIcon("data/treeicons/diff-unloaded.png");
        ICON_LOADED = ImageUtils.getImageIcon("data/treeicons/diff.png");
        ICON_MISSING_DIFF_BINARAY = ImageUtils.getImageIcon("data/treeicons/missing-diff-db.png");
    }
}
