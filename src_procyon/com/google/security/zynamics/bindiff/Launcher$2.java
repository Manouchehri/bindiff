package com.google.security.zynamics.bindiff;

import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.common.config.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import java.util.logging.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.zylib.io.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.zylib.gui.license.*;
import java.io.*;
import javax.swing.*;

final class Launcher$2 implements Runnable
{
    final /* synthetic */ String[] val$args;
    
    Launcher$2(final String[] val$args) {
        this.val$args = val$args;
    }
    
    @Override
    public void run() {
        System.setProperty(CMessageBox.DEFAULT_WINDOW_TITLE_PROPERTY, "BinDiff");
        initializeConfigFile();
        initializeLogger();
        Logger.logInfo("Starting %s", "4.2.0");
        final String value = String.valueOf(ConfigHelper.getConfigFileName("zynamics", "BinDiff", "config.xml"));
        Logger.logInfo(new StringBuilder(15 + String.valueOf(value).length()).append("Initialized ").append(value).append("...").toString(), new Object[0]);
        initializeFont();
        parseCommandLine(this.val$args);
        initializeGlobalTooltipDelays();
        initializeStandardHotKeys();
        final Workspace workspace = new Workspace();
        final MainWindow parentWindow = new MainWindow(workspace);
        workspace.setParentWindow(parentWindow);
        parentWindow.setVisible(true);
        GuiHelper.applyWindowFix(parentWindow);
        initializeSocketServer(parentWindow);
        try {
            showLicenseDialog(parentWindow);
        }
        catch (CLicenseFileException ex) {
            Logger.logException(ex, "Error while reading license file.");
        }
        if (Launcher.workspaceFileName != null) {
            parentWindow.getController().getTabPanelManager().getWorkspaceTabPanel().getController().loadWorkspace(Launcher.workspaceFileName);
        }
    }
}
