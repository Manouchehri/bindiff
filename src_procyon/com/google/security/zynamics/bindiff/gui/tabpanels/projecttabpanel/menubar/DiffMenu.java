package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.*;
import com.google.security.zynamics.bindiff.project.diff.*;

public class DiffMenu extends JMenu
{
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
    
    public DiffMenu(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        super("Diffs");
        this.workspaceTreeListener = new DiffMenu$InternalWorkspaceTreeListener(this, null);
        this.workspaceListener = new DiffMenu$InternalWorkspaceListener(this, null);
        this.diffListener = new DiffMenu$InternalDiffListener(this, null);
        this.lastSelectedDiff = null;
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.setMnemonic('D');
        this.setEnabled(false);
        final int menuShortcutKeyMask = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        this.newDiff = GuiUtils.buildMenuItem("New Diff...", 'N', 78, menuShortcutKeyMask, new NewDiffAction(workspaceTabPanelFunctions));
        this.addDiff = GuiUtils.buildMenuItem("Add Existing Diff...", 'A', 65, menuShortcutKeyMask, new AddDiffAction(workspaceTabPanelFunctions));
        this.dirDiff = GuiUtils.buildMenuItem("New Directory Diff...", 'N', new DirectoryDiffAction(workspaceTabPanelFunctions));
        this.openDiff = GuiUtils.buildMenuItem("Open Diff", 'O', new LoadDiffAction(workspaceTabPanelFunctions));
        this.closeDiff = GuiUtils.buildMenuItem("Close Diff", 'C', new CloseDiffAction(workspaceTabPanelFunctions));
        this.deleteDiff = GuiUtils.buildMenuItem("Delete Diff", 'D', new DeleteDiffAction(workspaceTabPanelFunctions));
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
    
    private void registerCurrentDiffListener(final Diff lastSelectedDiff) {
        this.unregisterCurrentDiffListener();
        (this.lastSelectedDiff = lastSelectedDiff).addListener(this.diffListener);
        this.unregisterCurrentDiffListener();
    }
    
    private void unregisterCurrentDiffListener() {
        if (this.lastSelectedDiff != null) {
            this.lastSelectedDiff.removeListener(this.diffListener);
            this.lastSelectedDiff = null;
        }
    }
}
