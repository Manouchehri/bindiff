/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.Launcher;
import com.google.security.zynamics.bindiff.gui.window.CWindowFunctions;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.resources.Constants;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.CDialogAboutEx;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.license.CExpiryDialog;
import com.google.security.zynamics.zylib.gui.license.CLicenseFile;
import com.google.security.zynamics.zylib.gui.license.CLicenseFileException;
import com.google.security.zynamics.zylib.gui.license.UpdateCheckHelper;
import com.google.security.zynamics.zylib.io.FileUtils;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TabPanelFunctions {
    private static final ImageIcon BINDIFF_ABOUT_IMAGE = ImageUtils.getImageIcon("data/appimages/bindiff-about-image.png");
    private static final ImageIcon BINDIFF_APPIMAGE_16x16 = ImageUtils.getImageIcon("data/appicons/bindiff-16x16-rgba.png");
    private static final ImageIcon BINDIFF_APPIMAGE_48x48 = ImageUtils.getImageIcon("data/appicons/bindiff-48x48-rgba.png");
    private final Workspace workspace;
    private final MainWindow window;

    public TabPanelFunctions(MainWindow mainWindow, Workspace workspace) {
        this.window = (MainWindow)Preconditions.checkNotNull(mainWindow);
        this.workspace = (Workspace)Preconditions.checkNotNull(workspace);
    }

    public MainWindow getMainWindow() {
        return this.window;
    }

    public void checkForUpdates() {
        UpdateCheckHelper.checkForUpdatesWithUi(this.window, "BinDiff", "4.2.0");
    }

    public void exitBinDiff() {
        this.window.getController().exitBinDiff();
    }

    public Workspace getWorkspace() {
        return this.workspace;
    }

    public void reportABug() {
        try {
            Desktop.getDesktop().browse(new URL("http://bugs.zynamics.com/BinDiff").toURI());
            return;
        }
        catch (MalformedURLException var1_1) {
            assert (false);
            return;
        }
        catch (URISyntaxException var1_2) {
            assert (false);
            return;
        }
        catch (IOException var1_3) {
            JOptionPane.showMessageDialog(this.window, "Couldn' open URL \"http://bugs.zynamics.com/BinDiff\"!", "BinDiff", 0);
        }
    }

    public void showAboutDialog() {
        ArrayList<Pair> arrayList;
        block2 : {
            arrayList = new ArrayList<Pair>();
            try {
                arrayList.add(new Pair("zynamics Website", new URL("http://www.zynamics.com")));
                arrayList.add(new Pair("BinDiff Product Site", new URL("http://www.zynamics.com/bindiff.html")));
                arrayList.add(new Pair("Report Bugs", new URL("mailto:zynamics-support@google.com")));
            }
            catch (MalformedURLException var2_2) {
                if ($assertionsDisabled) break block2;
                throw new AssertionError((Object)"Malformed URL in About dialog.");
            }
        }
        String string = "BinDiff 4.2\n\nCopyright \u00a92004-2011 zynamics GmbH\nCopyright \u00a92011-2015 Google Inc.\n";
        String string2 = "\nParts of this software were created by third parties and have different licensing requirements.\nPlease see the manual file for a complete list.\n";
        Image image = BINDIFF_ABOUT_IMAGE.getImage();
        CDialogAboutEx cDialogAboutEx = new CDialogAboutEx(this.window, new ImageIcon(image), "BinDiff 4.2", "BinDiff 4.2\n\nCopyright \u00a92004-2011 zynamics GmbH\nCopyright \u00a92011-2015 Google Inc.\n", "\nParts of this software were created by third parties and have different licensing requirements.\nPlease see the manual file for a complete list.\n", arrayList);
        cDialogAboutEx.setIconImage(ImageUtils.getImageIcon("data/appicons/bindiff-16x16-rgba.png").getImage());
        cDialogAboutEx.setSize(cDialogAboutEx.getWidth() - 8, cDialogAboutEx.getHeight());
        GuiHelper.centerChildToParent(this.window, cDialogAboutEx, true);
        cDialogAboutEx.setVisible(true);
    }

    public void showHelp() {
        try {
            String string = String.valueOf(FileUtils.findLocalRootPath(TabPanelFunctions.class));
            char c2 = File.separatorChar;
            String string2 = Constants.MANUAL_FILE;
            String string3 = new StringBuilder(1 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(c2).append(string2).toString();
            Desktop.getDesktop().browse(new File(string3).getCanonicalFile().toURI());
            return;
        }
        catch (MalformedURLException var1_5) {
            assert (false);
            return;
        }
        catch (IOException var1_6) {
            Logger.logException(var1_6, "Couldn't open help content.");
            CMessageBox.showError(this.window, "Couldn't open help content.");
        }
    }

    public void showLicenseDialog() {
        try {
            String string = String.valueOf(FileUtils.ensureTrailingSlash(FileUtils.findLocalRootPath(Launcher.class)));
            String string2 = String.valueOf("zynamics BinDiff License Key.txt");
            String string3 = string2.length() != 0 ? string.concat(string2) : new String(string);
            CLicenseFile cLicenseFile = CLicenseFile.parse(string3);
            CExpiryDialog cExpiryDialog = new CExpiryDialog(this.window, "License Information", BINDIFF_APPIMAGE_16x16.getImage(), BINDIFF_APPIMAGE_48x48.getImage(), "BinDiff 4.2", cLicenseFile, 45, false);
            cExpiryDialog.setVisible(true);
            return;
        }
        catch (CLicenseFileException var1_2) {
            CMessageBox.showWarning(this.window, "Couldn't read the license file.");
            Logger.logException(var1_2, "Error while reading license file.");
        }
    }
}

