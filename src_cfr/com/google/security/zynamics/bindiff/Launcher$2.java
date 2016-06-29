/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff;

import com.google.security.zynamics.bindiff.Launcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.window.CWindowFunctions;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.common.config.ConfigHelper;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.license.CLicenseFileException;

final class Launcher$2
implements Runnable {
    final /* synthetic */ String[] val$args;

    Launcher$2(String[] arrstring) {
        this.val$args = arrstring;
    }

    @Override
    public void run() {
        System.setProperty(CMessageBox.DEFAULT_WINDOW_TITLE_PROPERTY, "BinDiff");
        Launcher.access$000();
        Launcher.access$100();
        Logger.logInfo("Starting %s", "4.2.0");
        Object object = String.valueOf(ConfigHelper.getConfigFileName("zynamics", "BinDiff", "config.xml"));
        Logger.logInfo(new StringBuilder(15 + String.valueOf(object).length()).append("Initialized ").append((String)object).append("...").toString(), new Object[0]);
        Launcher.access$200();
        Launcher.access$300(this.val$args);
        Launcher.access$400();
        Launcher.access$500();
        object = new Workspace();
        MainWindow mainWindow = new MainWindow((Workspace)object);
        object.setParentWindow(mainWindow);
        mainWindow.setVisible(true);
        GuiHelper.applyWindowFix(mainWindow);
        Launcher.access$600(mainWindow);
        try {
            Launcher.access$700(mainWindow);
        }
        catch (CLicenseFileException var3_3) {
            Logger.logException(var3_3, "Error while reading license file.");
        }
        if (Launcher.access$800() == null) return;
        mainWindow.getController().getTabPanelManager().getWorkspaceTabPanel().getController().loadWorkspace(Launcher.access$800());
    }
}

