package com.google.security.zynamics.bindiff.gui.dialogs.mainsettings;

import com.google.security.zynamics.bindiff.Launcher;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.ColorsConfigItem;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.MainSettingsDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.MainSettingsDialog$InternalButtonListener;
import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels.GeneralPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels.LoggingPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels.SyntaxHighlightingPanel;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.CPanelTwoButtons;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Window;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class MainSettingsDialog extends BaseDialog {
   private static final int DIALOG_WIDTH = 600;
   private static final int DIALOG_HEIGHT = 430;
   private final GeneralPanel generalPanel = new GeneralPanel();
   private final LoggingPanel loggingPanel = new LoggingPanel();
   private final SyntaxHighlightingPanel syntaxHighlightingPanel = new SyntaxHighlightingPanel();
   private final CPanelTwoButtons buttons = new CPanelTwoButtons(new MainSettingsDialog$InternalButtonListener(this, (MainSettingsDialog$1)null), "Ok", "Cancel");

   public MainSettingsDialog(Window var1) {
      super(var1, "Main Settings");
      this.init();
      this.pack();
      this.setSize(600, 430);
      this.setMinimumSize(new Dimension(600, 430));
      GuiHelper.centerChildToParent(var1, this, true);
   }

   private void adoptChanges() {
      try {
         Launcher.applyLoggerChanges();
      } catch (SecurityException var2) {
         Logger.logException(var2, "Couldn\'t create file logger.");
         CMessageBox.showError(this, "Couldn\'t create file logger.");
      } catch (IOException var3) {
         Logger.logException(var3, "Couldn\'t create file logger.");
         CMessageBox.showError(this, "Couldn\'t create file logger.");
      }

   }

   private void save() {
      BinDiffConfigFile var1 = BinDiffConfigFile.getInstance();
      GeneralSettingsConfigItem var2 = var1.getMainSettings();
      ColorsConfigItem var3 = var1.getColorSettings();
      var2.setIdaDirectory(this.generalPanel.getIDADirectory());
      var2.setWorkspaceDirectory(this.generalPanel.getWorkspaceDirectory());
      var2.setConsoleLogging(this.loggingPanel.getConsoleLogging());
      var2.setFileLogging(this.loggingPanel.getFileLogging());
      var2.setLogFileLocation(this.loggingPanel.getLogFileLocation());
      var2.setLogVerbose(this.loggingPanel.getLogVerbose());
      var2.setLogInfo(this.loggingPanel.getLogInfo());
      var2.setLogWarning(this.loggingPanel.getLogWarning());
      var2.setLogSevere(this.loggingPanel.getLogSevere());
      var2.setLogException(this.loggingPanel.getLogException());
      var2.setLogStacktrace(this.loggingPanel.getLogStacktrace());
      var3.setAddressColor(this.syntaxHighlightingPanel.getAddressColor());
      var3.setMnemonicColor(this.syntaxHighlightingPanel.getMnemonicColor());
      var3.setRegisterColor(this.syntaxHighlightingPanel.getRegisterColor());
      var3.setOperatorColor(this.syntaxHighlightingPanel.getOperatorColor());
      var3.setSizePrefixColor(this.syntaxHighlightingPanel.getSizePrefixColor());
      var3.setDereferenceColor(this.syntaxHighlightingPanel.getDereferenceColor());
      var3.setImmediateColor(this.syntaxHighlightingPanel.getImmediateColor());
      var3.setOperatorSeparatorColor(this.syntaxHighlightingPanel.getOperandSeparatorColor());
      var3.setCommentColor(this.syntaxHighlightingPanel.getCommentColor());
      var3.setDefaultColor(this.syntaxHighlightingPanel.getDefaultColor());
      var3.setSymbolColor(this.syntaxHighlightingPanel.getSymbolColor());
      var3.setStackVariableColor(this.syntaxHighlightingPanel.getStackVariableColor());
      var3.setGlobalVariableColor(this.syntaxHighlightingPanel.getGlobalVariableColor());
      var3.setJumpLabelColor(this.syntaxHighlightingPanel.getJumpLabelColor());
      var3.setFunctionColor(this.syntaxHighlightingPanel.getFunctionColor());
      this.adoptChanges();
      var1.write();
   }

   private void init() {
      JTabbedPane var1 = new JTabbedPane();
      var1.addTab("General", this.generalPanel);
      var1.addTab("Logging", this.loggingPanel);
      var1.addTab("Syntax Highlighting", this.syntaxHighlightingPanel);
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(new EmptyBorder(1, 1, 1, 1));
      var2.add(var1, "Center");
      var2.add(this.buttons, "South");
      this.add(var2, "Center");
   }

   public void setVisible(boolean var1) {
      this.generalPanel.setCurrentValues();
      this.loggingPanel.setCurrentValues();
      this.syntaxHighlightingPanel.setCurrentValues();
      super.setVisible(var1);
   }

   // $FF: synthetic method
   static CPanelTwoButtons access$100(MainSettingsDialog var0) {
      return var0.buttons;
   }

   // $FF: synthetic method
   static void access$200(MainSettingsDialog var0) {
      var0.save();
   }
}
