package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import java.util.*;

public class FunctionDiffContainerNodePopupMenu extends JPopupMenu
{
    public FunctionDiffContainerNodePopupMenu(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.add(GuiUtils.buildMenuItem("Open Function Diffs", new LoadFunctionDiffsAction(workspaceTabPanelFunctions), this.isOpenDiffsEnabled(workspaceTabPanelFunctions)));
        this.add(GuiUtils.buildMenuItem("Close Function Diffs", new CloseFunctionDiffsAction(workspaceTabPanelFunctions), this.isCloseDiffsEnabled(workspaceTabPanelFunctions)));
        this.add(new JSeparator());
        this.add(GuiUtils.buildMenuItem("Close Function Diff Views", new CloseFunctionDiffsViewsAction(workspaceTabPanelFunctions), this.isCloseViewsEnabled(workspaceTabPanelFunctions)));
    }
    
    private boolean isCloseDiffsEnabled(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        final Iterator<Diff> iterator = workspaceTabPanelFunctions.getWorkspace().getDiffList(true).iterator();
        while (iterator.hasNext()) {
            if (iterator.next().isLoaded()) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isCloseViewsEnabled(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        return workspaceTabPanelFunctions.getMainWindow().getController().getTabPanelManager().getViewTabPanels(true).size() > 0;
    }
    
    private boolean isOpenDiffsEnabled(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        final Iterator<Diff> iterator = workspaceTabPanelFunctions.getWorkspace().getDiffList(true).iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().isLoaded()) {
                return true;
            }
        }
        return false;
    }
}
