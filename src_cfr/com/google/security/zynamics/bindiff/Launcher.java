/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff;

import com.google.security.zynamics.bindiff.Launcher$1;
import com.google.security.zynamics.bindiff.Launcher$2;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.license.CExpiryDialog;
import com.google.security.zynamics.zylib.gui.license.CLicenseFile;
import com.google.security.zynamics.zylib.gui.license.CLicenseFileHelpers;
import com.google.security.zynamics.zylib.io.FileUtils;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;

public class Launcher {
    private static String workspaceFileName = null;

    private static void initializeConfigFile() {
        try {
            BinDiffConfigFile.getInstance().read();
            if (BinDiffConfigFile.getInstance().getMainSettings().getVersion() == 1) return;
            int n2 = CMessageBox.showYesNoWarning(null, "Your configuration file is obsolete. Do you want to overwrite it with a new default configuration file?");
            try {
                if (n2 != 0) return;
                BinDiffConfigFile.delete();
                return;
            }
            catch (IOException var1_2) {
                CMessageBox.showError(null, "Couldn't delete configuration file.");
                System.exit(0);
                return;
            }
        }
        catch (IOException var0_1) {
            Logger.logException(var0_1, "Error while parsing configuration file.");
            CMessageBox.showError(null, var0_1.getMessage());
            System.exit(0);
        }
    }

    private static void initializeFont() {
        String[] arrstring;
        Logger.logInfo("Initializing fonts...", new Object[0]);
        Font font = GuiHelper.DEFAULT_FONT;
        Font font2 = GuiHelper.MONOSPACED_FONT;
        Logger.logInfo(" - Using default font: %s", font.getPSName());
        Logger.logInfo(" - Using monospaced font: %s", font2.getPSName());
        String[] arrstring2 = arrstring = new String[]{"Button.font", "CheckBox.font", "CheckBoxMenuItem.font", "ColorChooser.font", "ComboBox.font", "DesktopIcon.font", "InternalFrame.font", "InternalFrame.titleFont", "Label.font", "List.font", "Menu.font", "MenuBar.font", "MenuItem.font", "OptionPane.font", "Panel.font", "PasswordField.font", "PopupMenu.font", "ProgressBar.font", "RadioButton.font", "RadioButtonMenuItem.font", "ScrollPane.font", "TabbedPane.font", "Table.font", "TableHeader.font", "Text.font", "TextArea.font", "TextField.font", "TitledBorder.font", "ToggleButton.font", "ToolBar.font", "ToolTip.font", "Tree.font", "Viewport.font"};
        int n2 = arrstring2.length;
        int n3 = 0;
        while (n3 < n2) {
            String string = arrstring2[n3];
            UIManager.put(string, font);
            ++n3;
        }
    }

    private static void initializeGlobalTooltipDelays() {
        Logger.logInfo("Initializing global tooltip delays...", new Object[0]);
        ToolTipManager toolTipManager = ToolTipManager.sharedInstance();
        toolTipManager.setDismissDelay(60000);
        toolTipManager.setInitialDelay(1250);
        toolTipManager.setReshowDelay(500);
    }

    private static void initializeLogger() {
        GeneralSettingsConfigItem generalSettingsConfigItem = BinDiffConfigFile.getInstance().getMainSettings();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler(Logger.getLoggingFilePath(generalSettingsConfigItem.getLogFileLocation()));
            Logger.addFileLogger(fileHandler);
        }
        catch (IOException | SecurityException var2_2) {
            CMessageBox.showWarning(null, "Failed to initialize file logger. Could not create file handle.");
        }
        Logger.enableConsoleLogger(generalSettingsConfigItem.getConsoleLogging());
        Logger.enableFileLogger(generalSettingsConfigItem.getFileLogging());
        Logger.setLogVerboseInfos(generalSettingsConfigItem.getLogVerbose());
        Logger.setLogInfos(generalSettingsConfigItem.getLogInfo());
        Logger.setLogWarnings(generalSettingsConfigItem.getLogWarning());
        Logger.setLogSevere(generalSettingsConfigItem.getLogSevere());
        Logger.setLogExceptions(generalSettingsConfigItem.getLogException());
    }

    private static void initializeStandardHotKeys() {
        InputMap inputMap = (InputMap)UIManager.get("SplitPane.ancestorInputMap");
        int n2 = 112;
        while (n2 <= 123) {
            inputMap.remove(KeyStroke.getKeyStroke(n2, 0));
            ++n2;
        }
    }

    private static void parseCommandLine(String[] arrstring) {
        String[] arrstring2 = arrstring;
        int n2 = arrstring2.length;
        int n3 = 0;
        while (n3 < n2) {
            block20 : {
                String string = arrstring2[n3];
                if (string.equals("-c")) {
                    Logger.enableConsoleLogger(true);
                } else if (string.equals("-f")) {
                    FileHandler fileHandler;
                    try {
                        fileHandler = new FileHandler(Logger.getDefaultLoggingDirectoryPath());
                    }
                    catch (IOException var6_6) {
                        Logger.logInfo("Could not create FileHandler", new Object[0]);
                        break block20;
                    }
                    Logger.addFileLogger(fileHandler);
                } else if (string.equals("-v")) {
                    Logger.setLogVerboseInfos(true);
                } else if (string.equals("-vv")) {
                    Logger.setVeryVerboseLogging(true);
                } else if (string.equals("-info")) {
                    Logger.setLogInfos(true);
                } else if (string.equals("-warning")) {
                    Logger.setLogWarnings(true);
                } else if (string.equals("-severe")) {
                    Logger.setLogSevere(true);
                } else if (string.equals("-exception")) {
                    Logger.setLogExceptions(true);
                } else if (workspaceFileName == null && !string.startsWith("-")) {
                    workspaceFileName = string;
                }
            }
            ++n3;
        }
    }

    private static void showLicenseDialog(MainWindow mainWindow) {
        BinDiffConfigFile binDiffConfigFile = BinDiffConfigFile.getInstance();
        GeneralSettingsConfigItem generalSettingsConfigItem = binDiffConfigFile.getMainSettings();
        boolean bl2 = generalSettingsConfigItem.getHideLicenseInfoDialog();
        boolean bl3 = binDiffConfigFile.getMainSettings().getHideLicenseInfoDialogWithExpiryWarning();
        String string = String.valueOf(FileUtils.ensureTrailingSlash(FileUtils.findLocalRootPath(Launcher.class)));
        String string2 = String.valueOf("zynamics BinDiff License Key.txt");
        String string3 = string2.length() != 0 ? string.concat(string2) : new String(string);
        CLicenseFile cLicenseFile = CLicenseFile.parse(string3);
        if (bl2) {
            if (bl3) return;
        }
        CExpiryDialog cExpiryDialog = new CExpiryDialog(mainWindow, "License Information", ImageUtils.getImageIcon("data/appicons/bindiff-16x16-rgba.png").getImage(), ImageUtils.getImageIcon("data/appicons/bindiff-48x48-rgba.png").getImage(), "BinDiff 4.2", cLicenseFile, 45, true);
        if (!CLicenseFileHelpers.isExpiring(cLicenseFile, 45)) {
            if (bl2) return;
            cExpiryDialog.setVisible(true);
            generalSettingsConfigItem.setHideLicenseInfoDialogWithExpiryWarning(false);
            generalSettingsConfigItem.setHideLicenseInfoDialog(cExpiryDialog.getCheckboxSelection());
            return;
        }
        if (!bl3) {
            cExpiryDialog.setVisible(true);
            generalSettingsConfigItem.setHideLicenseInfoDialogWithExpiryWarning(cExpiryDialog.getCheckboxSelection());
        }
        generalSettingsConfigItem.setHideLicenseInfoDialog(false);
    }

    public static void applyLoggerChanges() {
        File file;
        char c2;
        Logger.logInfo("Applying logger changes...", new Object[0]);
        GeneralSettingsConfigItem generalSettingsConfigItem = BinDiffConfigFile.getInstance().getMainSettings();
        Logger.enableConsoleLogger(generalSettingsConfigItem.getConsoleLogging());
        String string = generalSettingsConfigItem.getLogFileLocation();
        if (string != null && string.length() > 1 && !File.separator.equals(new Character(c2 = string.charAt(string.length() - 1)).toString())) {
            String string2 = String.valueOf(string);
            String string3 = String.valueOf(File.separator);
            String string4 = string = string3.length() != 0 ? string2.concat(string3) : new String(string2);
        }
        if (!(file = new File(string)).exists()) {
            throw new IOException();
        }
        String string5 = String.valueOf(string);
        String string6 = String.valueOf("bindiff_ui.log");
        FileHandler fileHandler = new FileHandler(string6.length() != 0 ? string5.concat(string6) : new String(string5));
        Logger.addFileLogger(fileHandler);
        Logger.setLogVerboseInfos(generalSettingsConfigItem.getLogVerbose());
        Logger.setLogInfos(generalSettingsConfigItem.getLogInfo());
        Logger.setLogWarnings(generalSettingsConfigItem.getLogWarning());
        Logger.setLogSevere(generalSettingsConfigItem.getLogSevere());
        Logger.setLogExceptions(generalSettingsConfigItem.getLogException());
    }

    private static void initializeSocketServer(MainWindow mainWindow) {
        SwingUtilities.invokeLater(new Launcher$1(mainWindow));
    }

    public static void main(String[] arrstring) {
        SwingUtilities.invokeLater(new Launcher$2(arrstring));
    }

    static /* synthetic */ void access$000() {
        Launcher.initializeConfigFile();
    }

    static /* synthetic */ void access$100() {
        Launcher.initializeLogger();
    }

    static /* synthetic */ void access$200() {
        Launcher.initializeFont();
    }

    static /* synthetic */ void access$300(String[] arrstring) {
        Launcher.parseCommandLine(arrstring);
    }

    static /* synthetic */ void access$400() {
        Launcher.initializeGlobalTooltipDelays();
    }

    static /* synthetic */ void access$500() {
        Launcher.initializeStandardHotKeys();
    }

    static /* synthetic */ void access$600(MainWindow mainWindow) {
        Launcher.initializeSocketServer(mainWindow);
    }

    static /* synthetic */ void access$700(MainWindow mainWindow) {
        Launcher.showLicenseDialog(mainWindow);
    }

    static /* synthetic */ String access$800() {
        return workspaceFileName;
    }

    static {
        try {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }
        catch (Exception var0) {
            System.setProperty("com.apple.macos.useScreenMenuBar", "true");
        }
        System.setProperty("com.apple.mrj.application.apple.menu.about.name", "BinDiff");
    }
}

