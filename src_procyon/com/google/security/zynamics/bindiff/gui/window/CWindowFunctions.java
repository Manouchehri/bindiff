package com.google.security.zynamics.bindiff.gui.window;

import com.google.security.zynamics.bindiff.project.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.zylib.gui.*;
import java.io.*;
import com.google.security.zynamics.bindiff.config.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import javax.swing.*;

public class CWindowFunctions
{
    private final TabPanelManager tabPanelManager;
    private final MainWindow window;
    
    public CWindowFunctions(final MainWindow window, final Workspace workspace) {
        Preconditions.checkNotNull(window);
        Preconditions.checkNotNull(workspace);
        (this.tabPanelManager = new TabPanelManager(window, workspace)).addTab(new WorkspaceTabPanel(window, workspace));
        this.window = window;
    }
    
    private void saveConfigFile() {
        final GeneralSettingsConfigItem mainSettings = BinDiffConfigFile.getInstance().getMainSettings();
        final Point location = this.window.getLocation();
        mainSettings.setWindowXPos((int)location.getX());
        mainSettings.setWindowYPos((int)location.getY());
        mainSettings.setWindowWidth(this.window.getWidth());
        mainSettings.setWindowHeight(this.window.getHeight());
        mainSettings.setWindowStateWasMaximized(this.window.getExtendedState() == 6);
        mainSettings.setWorkspaceTreeDividerPosition(this.tabPanelManager.getWorkspaceTabPanel().getDividerLocation());
        mainSettings.setScreenWidth(Toolkit.getDefaultToolkit().getScreenSize().width);
        mainSettings.setScreenHeight(Toolkit.getDefaultToolkit().getScreenSize().height);
        final String[] recentWorkspaces = ((WorkspaceMenuBar)this.tabPanelManager.getWorkspaceTabPanel().getMenuBar()).getRecentWorkspaces();
        mainSettings.setLastWorkspaceDirectory1(new File(recentWorkspaces[0]).exists() ? recentWorkspaces[0] : "");
        mainSettings.setLastWorkspaceDirectory2(new File(recentWorkspaces[1]).exists() ? recentWorkspaces[1] : "");
        mainSettings.setLastWorkspaceDirectory3(new File(recentWorkspaces[2]).exists() ? recentWorkspaces[2] : "");
        mainSettings.setLastWorkspaceDirectory4(new File(recentWorkspaces[3]).exists() ? recentWorkspaces[3] : "");
        try {
            BinDiffConfigFile.getInstance().write();
        }
        catch (IOException ex) {
            Logger.logException(ex, "Couldn't save configuration file.");
            CMessageBox.showError(this.window, "Couldn't save configuration file.");
        }
    }
    
    public void exitBinDiff() {
        final WorkspaceTabPanelFunctions controller = this.tabPanelManager.getWorkspaceTabPanel().getController();
        if (this.tabPanelManager.getWorkspaceTabPanel().getController().closeWorkspace()) {
            controller.closeDialogs();
            this.saveConfigFile();
            Logger.logInfo("BinDiff closed normally.", new Object[0]);
        }
        System.exit(0);
    }
    
    public JTabbedPane getTabbedPanel() {
        return this.tabPanelManager.getTabbedPane();
    }
    
    public TabPanelManager getTabPanelManager() {
        return this.tabPanelManager;
    }
}
