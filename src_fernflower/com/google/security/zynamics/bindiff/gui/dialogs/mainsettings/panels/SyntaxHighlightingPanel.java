package com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.ColorsConfigItem;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.gui.ColorPanel.ColorPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class SyntaxHighlightingPanel extends JPanel {
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
      ColorsConfigItem var1 = BinDiffConfigFile.getInstance().getColorSettings();
      JPanel var2 = new JPanel(new GridLayout(NUMMBER_OF_ROWS, 1, 5, 5));
      var2.setBorder(new TitledBorder("Syntax Highlighting"));
      this.defaultColors.add(var1.getDefaultColor());
      this.defaultColors.add(var1.getAddressColor());
      this.defaultColors.add(var1.getMnemonicColor());
      this.defaultColors.add(var1.getRegisterColor());
      this.defaultColors.add(var1.getFunctionColor());
      this.defaultColors.add(var1.getImmediateColor());
      this.defaultColors.add(var1.getGlobalVariableColor());
      this.defaultColors.add(var1.getStackVariableColor());
      this.defaultColors.add(var1.getJumpLabelColor());
      this.defaultColors.add(var1.getDereferenceColor());
      this.defaultColors.add(var1.getOperatorSeparatorColor());
      this.defaultColors.add(var1.getSymbolColor());
      this.defaultColors.add(var1.getSizePrefixColor());
      this.defaultColors.add(var1.getDefaultColor());
      this.defaultColors.add(var1.getDefaultColor());
      this.defaultColors.add(var1.getCommentColor());
      this.defaultColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(var2, "Default color:", new ColorPanel(var1.getDefaultColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
      this.addressColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(var2, "Address color:", new ColorPanel(var1.getAddressColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
      this.mnemonicColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(var2, "Mnemonic color:", new ColorPanel(var1.getMnemonicColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
      this.registerColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(var2, "Register color:", new ColorPanel(var1.getRegisterColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
      this.functionColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(var2, "Function color:", new ColorPanel(var1.getFunctionColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
      this.immediateColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(var2, "Integer immediate color:", new ColorPanel(var1.getImmediateColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
      this.globalVariableColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(var2, "Global variable color:", new ColorPanel(var1.getGlobalVariableColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
      this.stackVariableColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(var2, "Stack variable color:", new ColorPanel(var1.getStackVariableColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
      this.jumpLabelColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(var2, "Jump label color:", new ColorPanel(var1.getJumpLabelColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
      this.operatorColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(var2, "Operator color:", new ColorPanel(var1.getOperatorColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
      this.dereferenceColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(var2, "Dereference color:", new ColorPanel(var1.getDereferenceColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
      this.operandSeparatorColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(var2, "Operand separator color:", new ColorPanel(var1.getOperatorSeparatorColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
      this.symbolColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(var2, "Symbol color:", new ColorPanel(var1.getSymbolColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
      this.sizePrefixColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(var2, "Size prefix color:", new ColorPanel(var1.getSizePrefixColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
      this.commentColor = (ColorPanel)GuiUtils.createHorizontalNamedComponent(var2, "Comment color:", new ColorPanel(var1.getCommentColor(), true, true, this.defaultColors), COLORPANEL_WIDTH, COLORPANEL_HEIGHT, false);
      return var2;
   }

   private void init() {
      JPanel var1 = new JPanel(new BorderLayout());
      JPanel var2 = new JPanel(new GridBagLayout());
      GridBagConstraints var3 = new GridBagConstraints();
      var3.gridx = 0;
      var3.gridy = 0;
      var3.anchor = 23;
      var3.weightx = 1.0D;
      var3.fill = 2;
      var2.add(this.createInstructionColorsPanel(), var3);
      var1.add(var2, "North");
      this.add(new JScrollPane(var1));
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
      ColorsConfigItem var1 = BinDiffConfigFile.getInstance().getColorSettings();
      this.defaultColor.setColor(var1.getDefaultColor());
      this.addressColor.setColor(var1.getAddressColor());
      this.mnemonicColor.setColor(var1.getMnemonicColor());
      this.registerColor.setColor(var1.getRegisterColor());
      this.functionColor.setColor(var1.getFunctionColor());
      this.immediateColor.setColor(var1.getImmediateColor());
      this.globalVariableColor.setColor(var1.getGlobalVariableColor());
      this.stackVariableColor.setColor(var1.getStackVariableColor());
      this.jumpLabelColor.setColor(var1.getJumpLabelColor());
      this.operatorColor.setColor(var1.getOperatorColor());
      this.dereferenceColor.setColor(var1.getDereferenceColor());
      this.operandSeparatorColor.setColor(var1.getOperatorSeparatorColor());
      this.symbolColor.setColor(var1.getSymbolColor());
      this.sizePrefixColor.setColor(var1.getSizePrefixColor());
      this.commentColor.setColor(var1.getCommentColor());
   }
}
