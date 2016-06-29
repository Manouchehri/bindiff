package com.google.security.zynamics.bindiff.gui.dialogs.mainsettings;

import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.zylib.gui.*;
import java.io.*;
import com.google.security.zynamics.bindiff.config.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class MainSettingsDialog extends BaseDialog
{
    private static final int DIALOG_WIDTH = 600;
    private static final int DIALOG_HEIGHT = 430;
    private final GeneralPanel generalPanel;
    private final LoggingPanel loggingPanel;
    private final SyntaxHighlightingPanel syntaxHighlightingPanel;
    private final CPanelTwoButtons buttons;
    
    public MainSettingsDialog(final Window window) {
        super(window, "Main Settings");
        this.generalPanel = new GeneralPanel();
        this.loggingPanel = new LoggingPanel();
        this.syntaxHighlightingPanel = new SyntaxHighlightingPanel();
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
        }
        catch (SecurityException ex) {
            Logger.logException(ex, "Couldn't create file logger.");
            CMessageBox.showError(this, "Couldn't create file logger.");
        }
        catch (IOException ex2) {
            Logger.logException(ex2, "Couldn't create file logger.");
            CMessageBox.showError(this, "Couldn't create file logger.");
        }
    }
    
    private void save() {
        final BinDiffConfigFile instance = BinDiffConfigFile.getInstance();
        final GeneralSettingsConfigItem mainSettings = instance.getMainSettings();
        final ColorsConfigItem colorSettings = instance.getColorSettings();
        mainSettings.setIdaDirectory(this.generalPanel.getIDADirectory());
        mainSettings.setWorkspaceDirectory(this.generalPanel.getWorkspaceDirectory());
        mainSettings.setConsoleLogging(this.loggingPanel.getConsoleLogging());
        mainSettings.setFileLogging(this.loggingPanel.getFileLogging());
        mainSettings.setLogFileLocation(this.loggingPanel.getLogFileLocation());
        mainSettings.setLogVerbose(this.loggingPanel.getLogVerbose());
        mainSettings.setLogInfo(this.loggingPanel.getLogInfo());
        mainSettings.setLogWarning(this.loggingPanel.getLogWarning());
        mainSettings.setLogSevere(this.loggingPanel.getLogSevere());
        mainSettings.setLogException(this.loggingPanel.getLogException());
        mainSettings.setLogStacktrace(this.loggingPanel.getLogStacktrace());
        colorSettings.setAddressColor(this.syntaxHighlightingPanel.getAddressColor());
        colorSettings.setMnemonicColor(this.syntaxHighlightingPanel.getMnemonicColor());
        colorSettings.setRegisterColor(this.syntaxHighlightingPanel.getRegisterColor());
        colorSettings.setOperatorColor(this.syntaxHighlightingPanel.getOperatorColor());
        colorSettings.setSizePrefixColor(this.syntaxHighlightingPanel.getSizePrefixColor());
        colorSettings.setDereferenceColor(this.syntaxHighlightingPanel.getDereferenceColor());
        colorSettings.setImmediateColor(this.syntaxHighlightingPanel.getImmediateColor());
        colorSettings.setOperatorSeparatorColor(this.syntaxHighlightingPanel.getOperandSeparatorColor());
        colorSettings.setCommentColor(this.syntaxHighlightingPanel.getCommentColor());
        colorSettings.setDefaultColor(this.syntaxHighlightingPanel.getDefaultColor());
        colorSettings.setSymbolColor(this.syntaxHighlightingPanel.getSymbolColor());
        colorSettings.setStackVariableColor(this.syntaxHighlightingPanel.getStackVariableColor());
        colorSettings.setGlobalVariableColor(this.syntaxHighlightingPanel.getGlobalVariableColor());
        colorSettings.setJumpLabelColor(this.syntaxHighlightingPanel.getJumpLabelColor());
        colorSettings.setFunctionColor(this.syntaxHighlightingPanel.getFunctionColor());
        this.adoptChanges();
        instance.write();
    }
    
    private void init() {
        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("General", this.generalPanel);
        tabbedPane.addTab("Logging", this.loggingPanel);
        tabbedPane.addTab("Syntax Highlighting", this.syntaxHighlightingPanel);
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(1, 1, 1, 1));
        panel.add(tabbedPane, "Center");
        panel.add(this.buttons, "South");
        this.add(panel, "Center");
    }
    
    @Override
    public void setVisible(final boolean visible) {
        this.generalPanel.setCurrentValues();
        this.loggingPanel.setCurrentValues();
        this.syntaxHighlightingPanel.setCurrentValues();
        super.setVisible(visible);
    }
}
