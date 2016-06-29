package com.google.security.zynamics.bindiff.gui.tabpanels;

import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.common.base.*;
import java.net.*;
import java.awt.*;
import com.google.security.zynamics.zylib.general.*;
import java.util.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.zylib.io.*;
import java.io.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.bindiff.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.gui.license.*;

public class TabPanelFunctions
{
    private static final ImageIcon BINDIFF_ABOUT_IMAGE;
    private static final ImageIcon BINDIFF_APPIMAGE_16x16;
    private static final ImageIcon BINDIFF_APPIMAGE_48x48;
    private final Workspace workspace;
    private final MainWindow window;
    
    public TabPanelFunctions(final MainWindow mainWindow, final Workspace workspace) {
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
        }
        catch (MalformedURLException ex) {
            assert false : "Malformed URL";
        }
        catch (URISyntaxException ex2) {
            assert false : "URL could not be converted to URI";
        }
        catch (IOException ex3) {
            JOptionPane.showMessageDialog(this.window, "Couldn' open URL \"http://bugs.zynamics.com/BinDiff\"!", "BinDiff", 0);
        }
    }
    
    public void showAboutDialog() {
        final ArrayList<Pair> list = new ArrayList<Pair>();
        try {
            list.add(new Pair("zynamics Website", new URL("http://www.zynamics.com")));
            list.add(new Pair("BinDiff Product Site", new URL("http://www.zynamics.com/bindiff.html")));
            list.add(new Pair("Report Bugs", new URL("mailto:zynamics-support@google.com")));
        }
        catch (MalformedURLException ex) {
            assert false : "Malformed URL in About dialog.";
        }
        final CDialogAboutEx cDialogAboutEx = new CDialogAboutEx(this.window, new ImageIcon(TabPanelFunctions.BINDIFF_ABOUT_IMAGE.getImage()), "BinDiff 4.2", "BinDiff 4.2\n\nCopyright ©2004-2011 zynamics GmbH\nCopyright ©2011-2015 Google Inc.\n", "\nParts of this software were created by third parties and have different licensing requirements.\nPlease see the manual file for a complete list.\n", list);
        cDialogAboutEx.setIconImage(ImageUtils.getImageIcon("data/appicons/bindiff-16x16-rgba.png").getImage());
        cDialogAboutEx.setSize(cDialogAboutEx.getWidth() - 8, cDialogAboutEx.getHeight());
        GuiHelper.centerChildToParent(this.window, cDialogAboutEx, true);
        cDialogAboutEx.setVisible(true);
    }
    
    public void showHelp() {
        try {
            final String value = String.valueOf(FileUtils.findLocalRootPath(TabPanelFunctions.class));
            final char separatorChar = File.separatorChar;
            final String manual_FILE = Constants.MANUAL_FILE;
            Desktop.getDesktop().browse(new File(new StringBuilder(1 + String.valueOf(value).length() + String.valueOf(manual_FILE).length()).append(value).append(separatorChar).append(manual_FILE).toString()).getCanonicalFile().toURI());
        }
        catch (MalformedURLException ex2) {
            assert false : "Malformed URL";
        }
        catch (IOException ex) {
            Logger.logException(ex, "Couldn't open help content.");
            CMessageBox.showError(this.window, "Couldn't open help content.");
        }
    }
    
    public void showLicenseDialog() {
        try {
            final String value = String.valueOf(FileUtils.ensureTrailingSlash(FileUtils.findLocalRootPath(Launcher.class)));
            final String value2 = String.valueOf("zynamics BinDiff License Key.txt");
            new CExpiryDialog(this.window, "License Information", TabPanelFunctions.BINDIFF_APPIMAGE_16x16.getImage(), TabPanelFunctions.BINDIFF_APPIMAGE_48x48.getImage(), "BinDiff 4.2", CLicenseFile.parse((value2.length() != 0) ? value.concat(value2) : new String(value)), 45, false).setVisible(true);
        }
        catch (CLicenseFileException ex) {
            CMessageBox.showWarning(this.window, "Couldn't read the license file.");
            Logger.logException(ex, "Error while reading license file.");
        }
    }
    
    static {
        BINDIFF_ABOUT_IMAGE = ImageUtils.getImageIcon("data/appimages/bindiff-about-image.png");
        BINDIFF_APPIMAGE_16x16 = ImageUtils.getImageIcon("data/appicons/bindiff-16x16-rgba.png");
        BINDIFF_APPIMAGE_48x48 = ImageUtils.getImageIcon("data/appicons/bindiff-48x48-rgba.png");
    }
}
