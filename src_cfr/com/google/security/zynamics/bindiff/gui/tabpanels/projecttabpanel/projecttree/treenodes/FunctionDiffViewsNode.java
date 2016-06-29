/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.FunctionDiffNodePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.awt.Component;
import java.io.File;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

public class FunctionDiffViewsNode
extends AbstractTreeNode {
    private static final ImageIcon ICON = ImageUtils.getImageIcon("data/treeicons/function-diff-views.png");
    private final FunctionDiffViewsNodeContextPanel component;
    private final File viewDirectory;

    public FunctionDiffViewsNode(WorkspaceTabPanelFunctions workspaceTabPanelFunctions, File file, List list) {
        super(workspaceTabPanelFunctions, null);
        this.viewDirectory = (File)Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(list);
        this.component = new FunctionDiffViewsNodeContextPanel(this.getController(), list);
    }

    @Override
    protected void createChildren() {
    }

    @Override
    public void delete() {
        this.component.dispose();
    }

    @Override
    public void doubleClicked() {
    }

    @Override
    public FunctionDiffViewsNodeContextPanel getComponent() {
        return this.component;
    }

    @Override
    public Icon getIcon() {
        return ICON;
    }

    @Override
    public JPopupMenu getPopupMenu() {
        return new FunctionDiffNodePopupMenu(this);
    }

    public File getViewDirectory() {
        return this.viewDirectory;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", this.viewDirectory.getName(), this.component.getFunctionViewsTableModel().getRowCount());
    }
}

