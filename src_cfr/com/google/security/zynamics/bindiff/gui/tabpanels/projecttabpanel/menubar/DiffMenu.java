/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.AddDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CloseDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.DeleteDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.DirectoryDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.LoadDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.NewDiffAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu$InternalDiffListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu$InternalWorkspaceListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu$InternalWorkspaceTreeListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.IWorkspaceTreeListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.project.IWorkspaceListener;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.IDiffListener;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class DiffMenu
extends JMenu {
    private final JMenuItem newDiff;
    private final JMenuItem dirDiff;
    private final JMenuItem addDiff;
    private final JMenuItem openDiff;
    private final JMenuItem closeDiff;
    private final JMenuItem deleteDiff;
    private final DiffMenu$InternalWorkspaceTreeListener workspaceTreeListener;
    private final DiffMenu$InternalWorkspaceListener workspaceListener;
    private final DiffMenu$InternalDiffListener diffListener;
    private final WorkspaceTabPanelFunctions controller;
    private Diff lastSelectedDiff;

    public DiffMenu(WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super("Diffs");
        this.workspaceTreeListener = new DiffMenu$InternalWorkspaceTreeListener(this, null);
        this.workspaceListener = new DiffMenu$InternalWorkspaceListener(this, null);
        this.diffListener = new DiffMenu$InternalDiffListener(this, null);
        this.lastSelectedDiff = null;
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.setMnemonic('D');
        this.setEnabled(false);
        int n2 = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        this.newDiff = GuiUtils.buildMenuItem("New Diff...", 'N', 78, n2, new NewDiffAction(workspaceTabPanelFunctions));
        this.addDiff = GuiUtils.buildMenuItem("Add Existing Diff...", 'A', 65, n2, new AddDiffAction(workspaceTabPanelFunctions));
        this.dirDiff = GuiUtils.buildMenuItem("New Directory Diff...", 'N', (AbstractAction)new DirectoryDiffAction(workspaceTabPanelFunctions));
        this.openDiff = GuiUtils.buildMenuItem("Open Diff", 'O', (AbstractAction)new LoadDiffAction(workspaceTabPanelFunctions));
        this.closeDiff = GuiUtils.buildMenuItem("Close Diff", 'C', (AbstractAction)new CloseDiffAction(workspaceTabPanelFunctions));
        this.deleteDiff = GuiUtils.buildMenuItem("Delete Diff", 'D', (AbstractAction)new DeleteDiffAction(workspaceTabPanelFunctions));
        this.add(this.newDiff);
        this.add(this.addDiff);
        this.add(this.dirDiff);
        this.add(new JSeparator());
        this.add(this.openDiff);
        this.add(this.closeDiff);
        this.add(new JSeparator());
        this.add(this.deleteDiff);
        workspaceTabPanelFunctions.getWorkspace().addListener(this.workspaceListener);
        workspaceTabPanelFunctions.getWorkspaceTree().addListener(this.workspaceTreeListener);
    }

    private void registerCurrentDiffListener(Diff diff) {
        this.unregisterCurrentDiffListener();
        this.lastSelectedDiff = diff;
        this.lastSelectedDiff.addListener(this.diffListener);
        this.unregisterCurrentDiffListener();
    }

    private void unregisterCurrentDiffListener() {
        if (this.lastSelectedDiff == null) return;
        this.lastSelectedDiff.removeListener(this.diffListener);
        this.lastSelectedDiff = null;
    }

    static /* synthetic */ JMenuItem access$300(DiffMenu diffMenu) {
        return diffMenu.openDiff;
    }

    static /* synthetic */ JMenuItem access$400(DiffMenu diffMenu) {
        return diffMenu.closeDiff;
    }

    static /* synthetic */ DiffMenu$InternalWorkspaceTreeListener access$500(DiffMenu diffMenu) {
        return diffMenu.workspaceTreeListener;
    }

    static /* synthetic */ WorkspaceTabPanelFunctions access$600(DiffMenu diffMenu) {
        return diffMenu.controller;
    }

    static /* synthetic */ void access$700(DiffMenu diffMenu) {
        diffMenu.unregisterCurrentDiffListener();
    }

    static /* synthetic */ JMenuItem access$800(DiffMenu diffMenu) {
        return diffMenu.newDiff;
    }

    static /* synthetic */ JMenuItem access$900(DiffMenu diffMenu) {
        return diffMenu.addDiff;
    }

    static /* synthetic */ JMenuItem access$1000(DiffMenu diffMenu) {
        return diffMenu.deleteDiff;
    }

    static /* synthetic */ void access$1100(DiffMenu diffMenu, Diff diff) {
        diffMenu.registerCurrentDiffListener(diff);
    }
}

