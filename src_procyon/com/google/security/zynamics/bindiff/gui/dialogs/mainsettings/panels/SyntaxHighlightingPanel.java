package com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels;

import com.google.security.zynamics.zylib.gui.ColorPanel.*;
import java.util.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.config.*;
import javax.swing.*;
import java.awt.*;

public class SyntaxHighlightingPanel extends JPanel
{
    private static int COLORPANEL_WIDTH;
    private static int COLORPANEL_HEIGHT;
    private static int NUMMBER_OF_ROWS;
    private ColorPanel defaultColor;
    private ColorPanel addressColor;
    private ColorPanel mnemonicColor;
    private ColorPanel symbolColor;
    private ColorPanel immediateColor;
    private ColorPanel operatorColor;
    private ColorPanel registerColor;
    private ColorPanel sizePrefixColor;
    private ColorPanel dereferenceColor;
    private ColorPanel operandSeparatorColor;
    private ColorPanel stackVariableColor;
    private ColorPanel globalVariableColor;
    private ColorPanel jumpLabelColor;
    private ColorPanel functionColor;
    private ColorPanel commentColor;
    Set defaultColors;
    
    public SyntaxHighlightingPanel() {
        super(new BorderLayout());
        this.defaultColors = new HashSet();
        this.init();
    }
    
    private JPanel createInstructionColorsPanel() {
        final ColorsConfigItem colorSettings = BinDiffConfigFile.getInstance().getColorSettings();
        final JPanel panel = new JPanel(new GridLayout(SyntaxHighlightingPanel.NUMMBER_OF_ROWS, 1, 5, 5));
        panel.setBorder(new TitledBorder("Syntax Highlighting"));
        this.defaultColors.add(colorSettings.getDefaultColor());
        this.defaultColors.add(colorSettings.getAddressColor());
        this.defaultColors.add(colorSettings.getMnemonicColor());
        this.defaultColors.add(colorSettings.getRegisterColor());
        this.defaultColors.add(colorSettings.getFunctionColor());
        this.defaultColors.add(colorSettings.getImmediateColor());
        this.defaultColors.add(colorSettings.getGlobalVariableColor());
        this.defaultColors.add(colorSettings.getStackVariableColor());
        this.defaultColors.add(colorSettings.getJumpLabelColor());
        this.defaultColors.add(colorSettings.getDereferenceColor());
        this.defaultColors.add(colorSettings.getOperatorSeparatorColor());
        this.defaultColors.add(colorSettings.getSymbolColor());
        this.defaultColors.add(colorSettings.getSizePrefixColor());
        this.defaultColors.add(colorSettings.getDefaultColor());
        this.defaultColors.add(colorSettings.getDefaultColor());
        this.defaultColors.add(colorSettings.getCommentColor());
        this.defaultColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(panel, "Default color:", new ColorPanel(colorSettings.getDefaultColor(), true, true, this.defaultColors), SyntaxHighlightingPanel.COLORPANEL_WIDTH, SyntaxHighlightingPanel.COLORPANEL_HEIGHT, false);
        this.addressColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(panel, "Address color:", new ColorPanel(colorSettings.getAddressColor(), true, true, this.defaultColors), SyntaxHighlightingPanel.COLORPANEL_WIDTH, SyntaxHighlightingPanel.COLORPANEL_HEIGHT, false);
        this.mnemonicColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(panel, "Mnemonic color:", new ColorPanel(colorSettings.getMnemonicColor(), true, true, this.defaultColors), SyntaxHighlightingPanel.COLORPANEL_WIDTH, SyntaxHighlightingPanel.COLORPANEL_HEIGHT, false);
        this.registerColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(panel, "Register color:", new ColorPanel(colorSettings.getRegisterColor(), true, true, this.defaultColors), SyntaxHighlightingPanel.COLORPANEL_WIDTH, SyntaxHighlightingPanel.COLORPANEL_HEIGHT, false);
        this.functionColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(panel, "Function color:", new ColorPanel(colorSettings.getFunctionColor(), true, true, this.defaultColors), SyntaxHighlightingPanel.COLORPANEL_WIDTH, SyntaxHighlightingPanel.COLORPANEL_HEIGHT, false);
        this.immediateColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(panel, "Integer immediate color:", new ColorPanel(colorSettings.getImmediateColor(), true, true, this.defaultColors), SyntaxHighlightingPanel.COLORPANEL_WIDTH, SyntaxHighlightingPanel.COLORPANEL_HEIGHT, false);
        this.globalVariableColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(panel, "Global variable color:", new ColorPanel(colorSettings.getGlobalVariableColor(), true, true, this.defaultColors), SyntaxHighlightingPanel.COLORPANEL_WIDTH, SyntaxHighlightingPanel.COLORPANEL_HEIGHT, false);
        this.stackVariableColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(panel, "Stack variable color:", new ColorPanel(colorSettings.getStackVariableColor(), true, true, this.defaultColors), SyntaxHighlightingPanel.COLORPANEL_WIDTH, SyntaxHighlightingPanel.COLORPANEL_HEIGHT, false);
        this.jumpLabelColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(panel, "Jump label color:", new ColorPanel(colorSettings.getJumpLabelColor(), true, true, this.defaultColors), SyntaxHighlightingPanel.COLORPANEL_WIDTH, SyntaxHighlightingPanel.COLORPANEL_HEIGHT, false);
        this.operatorColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(panel, "Operator color:", new ColorPanel(colorSettings.getOperatorColor(), true, true, this.defaultColors), SyntaxHighlightingPanel.COLORPANEL_WIDTH, SyntaxHighlightingPanel.COLORPANEL_HEIGHT, false);
        this.dereferenceColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(panel, "Dereference color:", new ColorPanel(colorSettings.getDereferenceColor(), true, true, this.defaultColors), SyntaxHighlightingPanel.COLORPANEL_WIDTH, SyntaxHighlightingPanel.COLORPANEL_HEIGHT, false);
        this.operandSeparatorColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(panel, "Operand separator color:", new ColorPanel(colorSettings.getOperatorSeparatorColor(), true, true, this.defaultColors), SyntaxHighlightingPanel.COLORPANEL_WIDTH, SyntaxHighlightingPanel.COLORPANEL_HEIGHT, false);
        this.symbolColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(panel, "Symbol color:", new ColorPanel(colorSettings.getSymbolColor(), true, true, this.defaultColors), SyntaxHighlightingPanel.COLORPANEL_WIDTH, SyntaxHighlightingPanel.COLORPANEL_HEIGHT, false);
        this.sizePrefixColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(panel, "Size prefix color:", new ColorPanel(colorSettings.getSizePrefixColor(), true, true, this.defaultColors), SyntaxHighlightingPanel.COLORPANEL_WIDTH, SyntaxHighlightingPanel.COLORPANEL_HEIGHT, false);
        this.commentColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(panel, "Comment color:", new ColorPanel(colorSettings.getCommentColor(), true, true, this.defaultColors), SyntaxHighlightingPanel.COLORPANEL_WIDTH, SyntaxHighlightingPanel.COLORPANEL_HEIGHT, false);
        return panel;
    }
    
    private void init() {
        final JPanel panel = new JPanel(new BorderLayout());
        final JPanel panel2 = new JPanel(new GridBagLayout());
        final GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = 23;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.fill = 2;
        panel2.add(this.createInstructionColorsPanel(), gridBagConstraints);
        panel.add(panel2, "North");
        this.add(new JScrollPane(panel));
    }
    
    public Color getAddressColor() {
        return this.addressColor.getColor();
    }
    
    public Color getCommentColor() {
        return this.commentColor.getColor();
    }
    
    public Color getDefaultColor() {
        return this.defaultColor.getColor();
    }
    
    public Color getDereferenceColor() {
        return this.dereferenceColor.getColor();
    }
    
    public Color getFunctionColor() {
        return this.functionColor.getColor();
    }
    
    public Color getGlobalVariableColor() {
        return this.globalVariableColor.getColor();
    }
    
    public Color getImmediateColor() {
        return this.immediateColor.getColor();
    }
    
    public Color getJumpLabelColor() {
        return this.jumpLabelColor.getColor();
    }
    
    public Color getMnemonicColor() {
        return this.mnemonicColor.getColor();
    }
    
    public Color getOperandSeparatorColor() {
        return this.operandSeparatorColor.getColor();
    }
    
    public Color getOperatorColor() {
        return this.operatorColor.getColor();
    }
    
    public Color getRegisterColor() {
        return this.registerColor.getColor();
    }
    
    public Color getSizePrefixColor() {
        return this.sizePrefixColor.getColor();
    }
    
    public Color getStackVariableColor() {
        return this.stackVariableColor.getColor();
    }
    
    public Color getSymbolColor() {
        return this.symbolColor.getColor();
    }
    
    public void setCurrentValues() {
        final ColorsConfigItem colorSettings = BinDiffConfigFile.getInstance().getColorSettings();
        this.defaultColor.setColor(colorSettings.getDefaultColor());
        this.addressColor.setColor(colorSettings.getAddressColor());
        this.mnemonicColor.setColor(colorSettings.getMnemonicColor());
        this.registerColor.setColor(colorSettings.getRegisterColor());
        this.functionColor.setColor(colorSettings.getFunctionColor());
        this.immediateColor.setColor(colorSettings.getImmediateColor());
        this.globalVariableColor.setColor(colorSettings.getGlobalVariableColor());
        this.stackVariableColor.setColor(colorSettings.getStackVariableColor());
        this.jumpLabelColor.setColor(colorSettings.getJumpLabelColor());
        this.operatorColor.setColor(colorSettings.getOperatorColor());
        this.dereferenceColor.setColor(colorSettings.getDereferenceColor());
        this.operandSeparatorColor.setColor(colorSettings.getOperatorSeparatorColor());
        this.symbolColor.setColor(colorSettings.getSymbolColor());
        this.sizePrefixColor.setColor(colorSettings.getSizePrefixColor());
        this.commentColor.setColor(colorSettings.getCommentColor());
    }
    
    static {
        SyntaxHighlightingPanel.COLORPANEL_WIDTH = 200;
        SyntaxHighlightingPanel.COLORPANEL_HEIGHT = 25;
        SyntaxHighlightingPanel.NUMMBER_OF_ROWS = 15;
    }
}
