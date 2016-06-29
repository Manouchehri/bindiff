/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.ColorsConfigItem;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.gui.ColorPanel.ColorPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class SyntaxHighlightingPanel
extends JPanel {
    private static int COLORPANEL_WIDTH = 200;
    private static int COLORPANEL_HEIGHT = 25;
    private static int NUMMBER_OF_ROWS = 15;
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
    Set defaultColors = new HashSet();

    public SyntaxHighlightingPanel() {
        super(new BorderLayout());
        this.init();
    }

    private JPanel createInstructionColorsPanel() {
        ColorsConfigItem colorsConfigItem = BinDiffConfigFile.getInstance().getColorSettings();
        JPanel jPanel = new JPanel(new GridLayout(NUMMBER_OF_ROWS, 1, 5, 5));
        jPanel.setBorder(new TitledBorder("Syntax Highlighting"));
        this.defaultColors.add(colorsConfigItem.getDefaultColor());
        this.defaultColors.add(colorsConfigItem.getAddressColor());
        this.defaultColors.add(colorsConfigItem.getMnemonicColor());
        this.defaultColors.add(colorsConfigItem.getRegisterColor());
        this.defaultColors.add(colorsConfigItem.getFunctionColor());
        this.defaultColors.add(colorsConfigItem.getImmediateColor());
        this.defaultColors.add(colorsConfigItem.getGlobalVariableColor());
        this.defaultColors.add(colorsConfigItem.getStackVariableColor());
        this.defaultColors.add(colorsConfigItem.getJumpLabelColor());
        this.defaultColors.add(colorsConfigItem.getDereferenceColor());
        this.defaultColors.add(colorsConfigItem.getOperatorSeparatorColor());
        this.defaultColors.add(colorsConfigItem.getSymbolColor());
        this.defaultColors.add(colorsConfigItem.getSizePrefixColor());
        this.defaultColors.add(colorsConfigItem.getDefaultColor());
        this.defaultColors.add(colorsConfigItem.getDefaultColor());
        this.defaultColors.add(colorsConfigItem.getCommentColor());
        this.defaultColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(jPanel, "Default color:", new ColorPanel(colorsConfigItem.getDefaultColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
        this.addressColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(jPanel, "Address color:", new ColorPanel(colorsConfigItem.getAddressColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
        this.mnemonicColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(jPanel, "Mnemonic color:", new ColorPanel(colorsConfigItem.getMnemonicColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
        this.registerColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(jPanel, "Register color:", new ColorPanel(colorsConfigItem.getRegisterColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
        this.functionColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(jPanel, "Function color:", new ColorPanel(colorsConfigItem.getFunctionColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
        this.immediateColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(jPanel, "Integer immediate color:", new ColorPanel(colorsConfigItem.getImmediateColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
        this.globalVariableColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(jPanel, "Global variable color:", new ColorPanel(colorsConfigItem.getGlobalVariableColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
        this.stackVariableColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(jPanel, "Stack variable color:", new ColorPanel(colorsConfigItem.getStackVariableColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
        this.jumpLabelColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(jPanel, "Jump label color:", new ColorPanel(colorsConfigItem.getJumpLabelColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
        this.operatorColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(jPanel, "Operator color:", new ColorPanel(colorsConfigItem.getOperatorColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
        this.dereferenceColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(jPanel, "Dereference color:", new ColorPanel(colorsConfigItem.getDereferenceColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
        this.operandSeparatorColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(jPanel, "Operand separator color:", new ColorPanel(colorsConfigItem.getOperatorSeparatorColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
        this.symbolColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(jPanel, "Symbol color:", new ColorPanel(colorsConfigItem.getSymbolColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
        this.sizePrefixColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(jPanel, "Size prefix color:", new ColorPanel(colorsConfigItem.getSizePrefixColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
        this.commentColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(jPanel, "Comment color:", new ColorPanel(colorsConfigItem.getCommentColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
        return jPanel;
    }

    private void init() {
        JPanel jPanel = new JPanel(new BorderLayout());
        JPanel jPanel2 = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = 23;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.fill = 2;
        jPanel2.add((Component)this.createInstructionColorsPanel(), gridBagConstraints);
        jPanel.add((Component)jPanel2, "North");
        this.add(new JScrollPane(jPanel));
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
        ColorsConfigItem colorsConfigItem = BinDiffConfigFile.getInstance().getColorSettings();
        this.defaultColor.setColor(colorsConfigItem.getDefaultColor());
        this.addressColor.setColor(colorsConfigItem.getAddressColor());
        this.mnemonicColor.setColor(colorsConfigItem.getMnemonicColor());
        this.registerColor.setColor(colorsConfigItem.getRegisterColor());
        this.functionColor.setColor(colorsConfigItem.getFunctionColor());
        this.immediateColor.setColor(colorsConfigItem.getImmediateColor());
        this.globalVariableColor.setColor(colorsConfigItem.getGlobalVariableColor());
        this.stackVariableColor.setColor(colorsConfigItem.getStackVariableColor());
        this.jumpLabelColor.setColor(colorsConfigItem.getJumpLabelColor());
        this.operatorColor.setColor(colorsConfigItem.getOperatorColor());
        this.dereferenceColor.setColor(colorsConfigItem.getDereferenceColor());
        this.operandSeparatorColor.setColor(colorsConfigItem.getOperatorSeparatorColor());
        this.symbolColor.setColor(colorsConfigItem.getSymbolColor());
        this.sizePrefixColor.setColor(colorsConfigItem.getSizePrefixColor());
        this.commentColor.setColor(colorsConfigItem.getCommentColor());
    }
}

