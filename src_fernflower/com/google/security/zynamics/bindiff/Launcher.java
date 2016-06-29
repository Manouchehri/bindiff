package com.google.security.zynamics.bindiff;

import com.google.security.zynamics.bindiff.Launcher$1;
import com.google.security.zynamics.bindiff.Launcher$2;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.io.FileUtils;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import javax.swing.InputMap;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;

public class Launcher {
   private static String workspaceFileName = null;

   private static void initializeConfigFile() {
      try {
         BinDiffConfigFile.getInstance().read();
         if(BinDiffConfigFile.getInstance().getMainSettings().getVersion() != 1) {
            int var0 = CMessageBox.showYesNoWarning((Component)null, "Your configuration file is obsolete. Do you want to overwrite it with a new default configuration file?");

            try {
               if(var0 == 0) {
                  BinDiffConfigFile.delete();
               }
            } catch (IOException var2) {
               CMessageBox.showError((Component)null, "Couldn\'t delete configuration file.");
               System.exit(0);
            }
         }
      } catch (IOException var3) {
         Logger.logException(var3, "Error while parsing configuration file.");
         CMessageBox.showError((Component)null, var3.getMessage());
         System.exit(0);
      }

   }

   private static void initializeFont() {
      Logger.logInfo("Initializing fonts...", new Object[0]);
      Font var0 = GuiHelper.DEFAULT_FONT;
      Font var1 = GuiHelper.MONOSPACED_FONT;
      Logger.logInfo(" - Using default font: %s", new Object[]{var0.getPSName()});
      Logger.logInfo(" - Using monospaced font: %s", new Object[]{var1.getPSName()});
      String[] var2 = new String[]{"Button.font", "CheckBox.font", "CheckBoxMenuItem.font", "ColorChooser.font", "ComboBox.font", "DesktopIcon.font", "InternalFrame.font", "InternalFrame.titleFont", "Label.font", "List.font", "Menu.font", "MenuBar.font", "MenuItem.font", "OptionPane.font", "Panel.font", "PasswordField.font", "PopupMenu.font", "ProgressBar.font", "RadioButton.font", "RadioButtonMenuItem.font", "ScrollPane.font", "TabbedPane.font", "Table.font", "TableHeader.font", "Text.font", "TextArea.font", "TextField.font", "TitledBorder.font", "ToggleButton.font", "ToolBar.font", "ToolTip.font", "Tree.font", "Viewport.font"};
      String[] var3 = var2;
      int var4 = var2.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         String var6 = var3[var5];
         UIManager.put(var6, var0);
      }

   }

   private static void initializeGlobalTooltipDelays() {
      Logger.logInfo("Initializing global tooltip delays...", new Object[0]);
      ToolTipManager var0 = ToolTipManager.sharedInstance();
      var0.setDismissDelay('\uea60');
      var0.setInitialDelay(1250);
      var0.setReshowDelay(500);
   }

   private static void initializeLogger() {
      GeneralSettingsConfigItem var0 = BinDiffConfigFile.getInstance().getMainSettings();
      FileHandler var1 = null;

      try {
         var1 = new FileHandler(Logger.getLoggingFilePath(var0.getLogFileLocation()));
         Logger.addFileLogger(var1);
      } catch (SecurityException | IOException var3) {
         CMessageBox.showWarning((Component)null, "Failed to initialize file logger. Could not create file handle.");
      }

      Logger.enableConsoleLogger(var0.getConsoleLogging());
      Logger.enableFileLogger(var0.getFileLogging());
      Logger.setLogVerboseInfos(var0.getLogVerbose());
      Logger.setLogInfos(var0.getLogInfo());
      Logger.setLogWarnings(var0.getLogWarning());
      Logger.setLogSevere(var0.getLogSevere());
      Logger.setLogExceptions(var0.getLogException());
   }

   private static void initializeStandardHotKeys() {
      InputMap var0 = (InputMap)UIManager.get("SplitPane.ancestorInputMap");

      for(int var1 = 112; var1 <= 123; ++var1) {
         var0.remove(KeyStroke.getKeyStroke(var1, 0));
      }

   }

   private static void parseCommandLine(String[] var0) {
      String[] var1 = var0;
      int var2 = var0.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         String var4 = var1[var3];
         if(var4.equals("-c")) {
            Logger.enableConsoleLogger(true);
         } else if(var4.equals("-f")) {
            FileHandler var5;
            try {
               var5 = new FileHandler(Logger.getDefaultLoggingDirectoryPath());
            } catch (IOException var7) {
               Logger.logInfo("Could not create FileHandler", new Object[0]);
               continue;
            }

            Logger.addFileLogger(var5);
         } else if(var4.equals("-v")) {
            Logger.setLogVerboseInfos(true);
         } else if(var4.equals("-vv")) {
            Logger.setVeryVerboseLogging(true);
         } else if(var4.equals("-info")) {
            Logger.setLogInfos(true);
         } else if(var4.equals("-warning")) {
            Logger.setLogWarnings(true);
         } else if(var4.equals("-severe")) {
            Logger.setLogSevere(true);
         } else if(var4.equals("-exception")) {
            Logger.setLogExceptions(true);
         } else if(workspaceFileName == null && !var4.startsWith("-")) {
            workspaceFileName = var4;
         }
      }

   }

   private static void showLicenseDialog(MainWindow var0) {
      // $FF: Couldn't be decompiled
   }

   public static void applyLoggerChanges() {
      // $FF: Couldn't be decompiled
   }

   private static void initializeSocketServer(MainWindow var0) {
      SwingUtilities.invokeLater(new Launcher$1(var0));
   }

   public static void main(String[] var0) {
      SwingUtilities.invokeLater(new Launcher$2(var0));
   }

   // $FF: synthetic method
   static void access$000() {
      initializeConfigFile();
   }

   // $FF: synthetic method
   static void access$100() {
      initializeLogger();
   }

   // $FF: synthetic method
   static void access$200() {
      initializeFont();
   }

   // $FF: synthetic method
   static void access$300(String[] var0) {
      parseCommandLine(var0);
   }

   // $FF: synthetic method
   static void access$400() {
      initializeGlobalTooltipDelays();
   }

   // $FF: synthetic method
   static void access$500() {
      initializeStandardHotKeys();
   }

   // $FF: synthetic method
   static void access$600(MainWindow var0) {
      initializeSocketServer(var0);
   }

   // $FF: synthetic method
   static void access$700(MainWindow var0) {
      showLicenseDialog(var0);
   }

   // $FF: synthetic method
   static String access$800() {
      return workspaceFileName;
   }

   static {
      try {
         System.setProperty("apple.laf.useScreenMenuBar", "true");
      } catch (Exception var1) {
         System.setProperty("com.apple.macos.useScreenMenuBar", "true");
      }

      System.setProperty("com.apple.mrj.application.apple.menu.about.name", "BinDiff");
   }
}
