/*
 * Decompiled with CFR 0_115.
 */
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
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class MainSettingsDialog
extends BaseDialog {
    private static final int DIALOG_WIDTH = 600;
    private static final int DIALOG_HEIGHT = 430;
    private final GeneralPanel generalPanel = new GeneralPanel();
    private final LoggingPanel loggingPanel = new LoggingPanel();
    private final SyntaxHighlightingPanel syntaxHighlightingPanel = new SyntaxHighlightingPanel();
    private final CPanelTwoButtons buttons;

    public MainSettingsDialog(Window window) {
        super(window, "Main Settings");
        this.buttons = new CPanelTwoButtons(new MainSettingsDialog$InternalButtonListener(this, null), "Ok", "Cancel");
        this.init();
        this.pack();
        this.setSize(600, 430);
        this.setMinimumSize(new Dimension(600, 430));
        GuiHelper.centerChildToParent(window, this, true);
    }

    private void adoptChanges() {
        try {
            Launcher.applyLoggerChanges();
            return;
        }
        catch (SecurityException var1_1) {
            Logger.logException(var1_1, "Couldn't create file logger.");
            CMessageBox.showError(this, "Couldn't create file logger.");
            return;
        }
        catch (IOException var1_2) {
            Logger.logException(var1_2, "Couldn't create file logger.");
            CMessageBox.showError(this, "Couldn't create file logger.");
        }
    }

    private void save() {
        BinDiffConfigFile binDiffConfigFile = BinDiffConfigFile.getInstance();
        GeneralSettingsConfigItem generalSettingsConfigItem = binDiffConfigFile.getMainSettings();
        ColorsConfigItem colorsConfigItem = binDiffConfigFile.getColorSettings();
        generalSettingsConfigItem.setIdaDirectory(this.generalPanel.getIDADirectory());
        generalSettingsConfigItem.setWorkspaceDirectory(this.generalPanel.getWorkspaceDirectory());
        generalSettingsConfigItem.setConsoleLogging(this.loggingPanel.getConsoleLogging());
        generalSettingsConfigItem.setFileLogging(this.loggingPanel.getFileLogging());
        generalSettingsConfigItem.setLogFileLocation(this.loggingPanel.getLogFileLocation());
        generalSettingsConfigItem.setLogVerbose(this.loggingPanel.getLogVerbose());
        generalSettingsConfigItem.setLogInfo(this.loggingPanel.getLogInfo());
        generalSettingsConfigItem.setLogWarning(this.loggingPanel.getLogWarning());
        generalSettingsConfigItem.setLogSevere(this.loggingPanel.getLogSevere());
        generalSettingsConfigItem.setLogException(this.loggingPanel.getLogException());
        generalSettingsConfigItem.setLogStacktrace(this.loggingPanel.getLogStacktrace());
        colorsConfigItem.setAddressColor(this.syntaxHighlightingPanel.getAddressColor());
        colorsConfigItem.setMnemonicColor(this.syntaxHighlightingPanel.getMnemonicColor());
        colorsConfigItem.setRegisterColor(this.syntaxHighlightingPanel.getRegisterColor());
        colorsConfigItem.setOperatorColor(this.syntaxHighlightingPanel.getOperatorColor());
        colorsConfigItem.setSizePrefixColor(this.syntaxHighlightingPanel.getSizePrefixColor());
        colorsConfigItem.setDereferenceColor(this.syntaxHighlightingPanel.getDereferenceColor());
        colorsConfigItem.setImmediateColor(this.syntaxHighlightingPanel.getImmediateColor());
        colorsConfigItem.setOperatorSeparatorColor(this.syntaxHighlightingPanel.getOperandSeparatorColor());
        colorsConfigItem.setCommentColor(this.syntaxHighlightingPanel.getCommentColor());
        colorsConfigItem.setDefaultColor(this.syntaxHighlightingPanel.getDefaultColor());
        colorsConfigItem.setSymbolColor(this.syntaxHighlightingPanel.getSymbolColor());
        colorsConfigItem.setStackVariableColor(this.syntaxHighlightingPanel.getStackVariableColor());
        colorsConfigItem.setGlobalVariableColor(this.syntaxHighlightingPanel.getGlobalVariableColor());
        colorsConfigItem.setJumpLabelColor(this.syntaxHighlightingPanel.getJumpLabelColor());
        colorsConfigItem.setFunctionColor(this.syntaxHighlightingPanel.getFunctionColor());
        this.adoptChanges();
        binDiffConfigFile.write();
    }

    private void init() {
        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.addTab("General", this.generalPanel);
        jTabbedPane.addTab("Logging", this.loggingPanel);
        jTabbedPane.addTab("Syntax Highlighting", this.syntaxHighlightingPanel);
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(1, 1, 1, 1));
        jPanel.add((Component)jTabbedPane, "Center");
        jPanel.add((Component)this.buttons, "South");
        this.add((Component)jPanel, "Center");
    }

    @Override
    public void setVisible(boolean bl2) {
        this.generalPanel.setCurrentValues();
        this.loggingPanel.setCurrentValues();
        this.syntaxHighlightingPanel.setCurrentValues();
        super.setVisible(bl2);
    }

    static /* synthetic */ CPanelTwoButtons access$100(MainSettingsDialog mainSettingsDialog) {
        return mainSettingsDialog.buttons;
    }

    static /* synthetic */ void access$200(MainSettingsDialog mainSettingsDialog) {
        mainSettingsDialog.save();
    }
}

