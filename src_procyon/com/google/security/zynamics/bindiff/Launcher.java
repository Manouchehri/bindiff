package com.google.security.zynamics.bindiff;

import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import java.util.logging.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.zylib.io.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.zylib.gui.license.*;
import java.io.*;
import javax.swing.*;

public class Launcher
{
    private static String workspaceFileName;
    
    private static void initializeConfigFile() {
        try {
            BinDiffConfigFile.getInstance().read();
            if (BinDiffConfigFile.getInstance().getMainSettings().getVersion() != 1) {
                final int showYesNoWarning = CMessageBox.showYesNoWarning(null, "Your configuration file is obsolete. Do you want to overwrite it with a new default configuration file?");
                try {
                    if (showYesNoWarning == 0) {
                        BinDiffConfigFile.delete();
                    }
                }
                catch (IOException ex2) {
                    CMessageBox.showError(null, "Couldn't delete configuration file.");
                    System.exit(0);
                }
            }
        }
        catch (IOException ex) {
            Logger.logException(ex, "Error while parsing configuration file.");
            CMessageBox.showError(null, ex.getMessage());
            System.exit(0);
        }
    }
    
    private static void initializeFont() {
        Logger.logInfo("Initializing fonts...", new Object[0]);
        final Font default_FONT = GuiHelper.DEFAULT_FONT;
        final Font monospaced_FONT = GuiHelper.MONOSPACED_FONT;
        Logger.logInfo(" - Using default font: %s", default_FONT.getPSName());
        Logger.logInfo(" - Using monospaced font: %s", monospaced_FONT.getPSName());
        final String[] array = { "Button.font", "CheckBox.font", "CheckBoxMenuItem.font", "ColorChooser.font", "ComboBox.font", "DesktopIcon.font", "InternalFrame.font", "InternalFrame.titleFont", "Label.font", "List.font", "Menu.font", "MenuBar.font", "MenuItem.font", "OptionPane.font", "Panel.font", "PasswordField.font", "PopupMenu.font", "ProgressBar.font", "RadioButton.font", "RadioButtonMenuItem.font", "ScrollPane.font", "TabbedPane.font", "Table.font", "TableHeader.font", "Text.font", "TextArea.font", "TextField.font", "TitledBorder.font", "ToggleButton.font", "ToolBar.font", "ToolTip.font", "Tree.font", "Viewport.font" };
        for (int length = array.length, i = 0; i < length; ++i) {
            UIManager.put(array[i], default_FONT);
        }
    }
    
    private static void initializeGlobalTooltipDelays() {
        Logger.logInfo("Initializing global tooltip delays...", new Object[0]);
        final ToolTipManager sharedInstance = ToolTipManager.sharedInstance();
        sharedInstance.setDismissDelay(60000);
        sharedInstance.setInitialDelay(1250);
        sharedInstance.setReshowDelay(500);
    }
    
    private static void initializeLogger() {
        final GeneralSettingsConfigItem mainSettings = BinDiffConfigFile.getInstance().getMainSettings();
        try {
            Logger.addFileLogger(new FileHandler(Logger.getLoggingFilePath(mainSettings.getLogFileLocation())));
        }
        catch (IOException | SecurityException ex) {
            CMessageBox.showWarning(null, "Failed to initialize file logger. Could not create file handle.");
        }
        Logger.enableConsoleLogger(mainSettings.getConsoleLogging());
        Logger.enableFileLogger(mainSettings.getFileLogging());
        Logger.setLogVerboseInfos(mainSettings.getLogVerbose());
        Logger.setLogInfos(mainSettings.getLogInfo());
        Logger.setLogWarnings(mainSettings.getLogWarning());
        Logger.setLogSevere(mainSettings.getLogSevere());
        Logger.setLogExceptions(mainSettings.getLogException());
    }
    
    private static void initializeStandardHotKeys() {
        final InputMap inputMap = (InputMap)UIManager.get("SplitPane.ancestorInputMap");
        for (int i = 112; i <= 123; ++i) {
            inputMap.remove(KeyStroke.getKeyStroke(i, 0));
        }
    }
    
    private static void parseCommandLine(final String[] array) {
        for (final String workspaceFileName : array) {
            Label_0214: {
                if (workspaceFileName.equals("-c")) {
                    Logger.enableConsoleLogger(true);
                }
                else if (workspaceFileName.equals("-f")) {
                    FileHandler fileHandler;
                    try {
                        fileHandler = new FileHandler(Logger.getDefaultLoggingDirectoryPath());
                    }
                    catch (IOException ex) {
                        Logger.logInfo("Could not create FileHandler", new Object[0]);
                        break Label_0214;
                    }
                    Logger.addFileLogger(fileHandler);
                }
                else if (workspaceFileName.equals("-v")) {
                    Logger.setLogVerboseInfos(true);
                }
                else if (workspaceFileName.equals("-vv")) {
                    Logger.setVeryVerboseLogging(true);
                }
                else if (workspaceFileName.equals("-info")) {
                    Logger.setLogInfos(true);
                }
                else if (workspaceFileName.equals("-warning")) {
                    Logger.setLogWarnings(true);
                }
                else if (workspaceFileName.equals("-severe")) {
                    Logger.setLogSevere(true);
                }
                else if (workspaceFileName.equals("-exception")) {
                    Logger.setLogExceptions(true);
                }
                else if (Launcher.workspaceFileName == null && !workspaceFileName.startsWith("-")) {
                    Launcher.workspaceFileName = workspaceFileName;
                }
            }
        }
    }
    
    private static void showLicenseDialog(final MainWindow mainWindow) {
        final BinDiffConfigFile instance = BinDiffConfigFile.getInstance();
        final GeneralSettingsConfigItem mainSettings = instance.getMainSettings();
        final boolean hideLicenseInfoDialog = mainSettings.getHideLicenseInfoDialog();
        final boolean hideLicenseInfoDialogWithExpiryWarning = instance.getMainSettings().getHideLicenseInfoDialogWithExpiryWarning();
        final String value = String.valueOf(FileUtils.ensureTrailingSlash(FileUtils.findLocalRootPath(Launcher.class)));
        final String value2 = String.valueOf("zynamics BinDiff License Key.txt");
        final CLicenseFile parse = CLicenseFile.parse((value2.length() != 0) ? value.concat(value2) : new String(value));
        if (!hideLicenseInfoDialog || !hideLicenseInfoDialogWithExpiryWarning) {
            final CExpiryDialog cExpiryDialog = new CExpiryDialog(mainWindow, "License Information", ImageUtils.getImageIcon("data/appicons/bindiff-16x16-rgba.png").getImage(), ImageUtils.getImageIcon("data/appicons/bindiff-48x48-rgba.png").getImage(), "BinDiff 4.2", parse, 45, true);
            if (CLicenseFileHelpers.isExpiring(parse, 45)) {
                if (!hideLicenseInfoDialogWithExpiryWarning) {
                    cExpiryDialog.setVisible(true);
                    mainSettings.setHideLicenseInfoDialogWithExpiryWarning(cExpiryDialog.getCheckboxSelection());
                }
                mainSettings.setHideLicenseInfoDialog(false);
            }
            else if (!hideLicenseInfoDialog) {
                cExpiryDialog.setVisible(true);
                mainSettings.setHideLicenseInfoDialogWithExpiryWarning(false);
                mainSettings.setHideLicenseInfoDialog(cExpiryDialog.getCheckboxSelection());
            }
        }
    }
    
    public static void applyLoggerChanges() {
        Logger.logInfo("Applying logger changes...", new Object[0]);
        final GeneralSettingsConfigItem mainSettings = BinDiffConfigFile.getInstance().getMainSettings();
        Logger.enableConsoleLogger(mainSettings.getConsoleLogging());
        String logFileLocation = mainSettings.getLogFileLocation();
        if (logFileLocation != null && logFileLocation.length() > 1 && !File.separator.equals(new Character(logFileLocation.charAt(logFileLocation.length() - 1)).toString())) {
            final String value = String.valueOf(logFileLocation);
            final String value2 = String.valueOf(File.separator);
            logFileLocation = ((value2.length() != 0) ? value.concat(value2) : new String(value));
        }
        if (!new File(logFileLocation).exists()) {
            throw new IOException();
        }
        final String value3 = String.valueOf(logFileLocation);
        final String value4 = String.valueOf("bindiff_ui.log");
        Logger.addFileLogger(new FileHandler((value4.length() != 0) ? value3.concat(value4) : new String(value3)));
        Logger.setLogVerboseInfos(mainSettings.getLogVerbose());
        Logger.setLogInfos(mainSettings.getLogInfo());
        Logger.setLogWarnings(mainSettings.getLogWarning());
        Logger.setLogSevere(mainSettings.getLogSevere());
        Logger.setLogExceptions(mainSettings.getLogException());
    }
    
    private static void initializeSocketServer(final MainWindow mainWindow) {
        SwingUtilities.invokeLater(new Launcher$1(mainWindow));
    }
    
    public static void main(final String[] array) {
        SwingUtilities.invokeLater(new Launcher$2(array));
    }
    
    static {
        Launcher.workspaceFileName = null;
        try {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }
        catch (Exception ex) {
            System.setProperty("com.apple.macos.useScreenMenuBar", "true");
        }
        System.setProperty("com.apple.mrj.application.apple.menu.about.name", "BinDiff");
    }
}
