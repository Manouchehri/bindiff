package com.google.security.zynamics.bindiff.config;

import com.google.security.zynamics.common.config.AbstractConfigItem;
import com.google.security.zynamics.common.config.TypedPropertiesWrapper;
import java.awt.Color;

public class ColorsConfigItem extends AbstractConfigItem {
   private static final String DEFAULT_COLOR = "DefaultColor";
   private static final Color DEFAULT_COLOR_DEFAULT = new Color(-16777216);
   private Color defaultColor;
   private static final String ADDRESS_COLOR = "AddressColor";
   private static final Color ADDRESS_COLOR_DEFAULT = new Color(-16777216);
   private Color addressColor;
   private static final String MNEMONIC_COLOR = "MnemonicColor";
   private static final Color MNEMONIC_COLOR_DEFAULT = new Color(-16777088);
   private Color mnemonicColor;
   private static final String SYMBOL_COLOR = "SymbolColor";
   private static final Color SYMBOL_COLOR_DEFAULT = new Color(-7076089);
   private Color symbolColor;
   private static final String IMMEDIATE_COLOR = "ImmediateColor";
   private static final Color IMMEDIATE_COLOR_DEFAULT = new Color(-7602176);
   private Color immediateColor;
   private static final String OPERATOR_COLOR = "OperatorColor";
   private static final Color OPERATOR_COLOR_DEFAULT = new Color(-16711423);
   private Color operatorColor;
   private static final String REGISTER_COLOR = "RegisterColor";
   private static final Color REGISTER_COLOR_DEFAULT = new Color(-16750615);
   private Color registerColor;
   private static final String SIZE_PREFIX_COLOR = "SizePrefixColor";
   private static final Color SIZE_PREFIX_COLOR_DEFAULT = new Color(-6316386);
   private Color sizePrefixColor;
   private static final String DEREFERENCE_COLOR = "DereferenceColor";
   private static final Color DEREFERENCE_COLOR_DEFAULT = new Color(-16711423);
   private Color dereferenceColor;
   private static final String OPERATOR_SEPARATOR_COLOR = "OperatorSeparatorColor";
   private static final Color OPERATOR_SEPARATOR_COLOR_DEFAULT = new Color(-16777216);
   private Color operatorSeparatorColor;
   private static final String STACK_VARIABLE_COLOR = "StackVariableColor";
   private static final Color STACK_VARIABLE_COLOR_DEFAULT = new Color(-7602176);
   private Color stackVariableColor;
   private static final String GLOBAL_VARIABLE_COLOR = "GlobalVariableColor";
   private static final Color GLOBAL_VARIABLE_COLOR_DEFAULT = new Color(-7602176);
   private Color globalVariableColor;
   private static final String JUMP_LABEL_COLOR = "JumpLabelColor";
   private static final Color JUMP_LABEL_COLOR_DEFAULT = new Color(-6291296);
   private Color jumpLabelColor;
   private static final String FUNCTION_COLOR = "FunctionColor";
   private static final Color FUNCTION_COLOR_DEFAULT = new Color(-7602176);
   private Color functionColor;
   private static final String COMMENT_COLOR = "CommentColor";
   private static final Color COMMENT_COLOR_DEFAULT = new Color(-10197916);
   private Color commentColor;

   public ColorsConfigItem() {
      this.defaultColor = DEFAULT_COLOR_DEFAULT;
      this.addressColor = ADDRESS_COLOR_DEFAULT;
      this.mnemonicColor = MNEMONIC_COLOR_DEFAULT;
      this.symbolColor = SYMBOL_COLOR_DEFAULT;
      this.immediateColor = IMMEDIATE_COLOR_DEFAULT;
      this.operatorColor = OPERATOR_COLOR_DEFAULT;
      this.registerColor = REGISTER_COLOR_DEFAULT;
      this.sizePrefixColor = SIZE_PREFIX_COLOR_DEFAULT;
      this.dereferenceColor = DEREFERENCE_COLOR_DEFAULT;
      this.operatorSeparatorColor = OPERATOR_SEPARATOR_COLOR_DEFAULT;
      this.stackVariableColor = STACK_VARIABLE_COLOR_DEFAULT;
      this.globalVariableColor = GLOBAL_VARIABLE_COLOR_DEFAULT;
      this.jumpLabelColor = JUMP_LABEL_COLOR_DEFAULT;
      this.functionColor = FUNCTION_COLOR_DEFAULT;
      this.commentColor = COMMENT_COLOR_DEFAULT;
   }

   public void load(TypedPropertiesWrapper var1) {
      this.defaultColor = var1.getColor("DefaultColor", DEFAULT_COLOR_DEFAULT);
      this.addressColor = var1.getColor("AddressColor", ADDRESS_COLOR_DEFAULT);
      this.mnemonicColor = var1.getColor("MnemonicColor", MNEMONIC_COLOR_DEFAULT);
      this.symbolColor = var1.getColor("SymbolColor", SYMBOL_COLOR_DEFAULT);
      this.immediateColor = var1.getColor("ImmediateColor", IMMEDIATE_COLOR_DEFAULT);
      this.operatorColor = var1.getColor("OperatorColor", OPERATOR_COLOR_DEFAULT);
      this.registerColor = var1.getColor("RegisterColor", REGISTER_COLOR_DEFAULT);
      this.sizePrefixColor = var1.getColor("SizePrefixColor", SIZE_PREFIX_COLOR_DEFAULT);
      this.dereferenceColor = var1.getColor("DereferenceColor", DEREFERENCE_COLOR_DEFAULT);
      this.operatorSeparatorColor = var1.getColor("OperatorSeparatorColor", OPERATOR_SEPARATOR_COLOR_DEFAULT);
      this.stackVariableColor = var1.getColor("StackVariableColor", STACK_VARIABLE_COLOR_DEFAULT);
      this.globalVariableColor = var1.getColor("GlobalVariableColor", GLOBAL_VARIABLE_COLOR_DEFAULT);
      this.jumpLabelColor = var1.getColor("JumpLabelColor", JUMP_LABEL_COLOR_DEFAULT);
      this.functionColor = var1.getColor("FunctionColor", FUNCTION_COLOR_DEFAULT);
      this.commentColor = var1.getColor("CommentColor", COMMENT_COLOR_DEFAULT);
   }

   public void store(TypedPropertiesWrapper var1) {
      var1.setColor("DefaultColor", this.defaultColor);
      var1.setColor("AddressColor", this.addressColor);
      var1.setColor("MnemonicColor", this.mnemonicColor);
      var1.setColor("SymbolColor", this.symbolColor);
      var1.setColor("ImmediateColor", this.immediateColor);
      var1.setColor("OperatorColor", this.operatorColor);
      var1.setColor("RegisterColor", this.registerColor);
      var1.setColor("SizePrefixColor", this.sizePrefixColor);
      var1.setColor("DereferenceColor", this.dereferenceColor);
      var1.setColor("OperatorSeparatorColor", this.operatorSeparatorColor);
      var1.setColor("StackVariableColor", this.stackVariableColor);
      var1.setColor("GlobalVariableColor", this.globalVariableColor);
      var1.setColor("JumpLabelColor", this.jumpLabelColor);
      var1.setColor("FunctionColor", this.functionColor);
      var1.setColor("CommentColor", this.commentColor);
   }

   public final Color getDefaultColor() {
      return this.defaultColor;
   }

   public final Color getAddressColor() {
      return this.addressColor;
   }

   public final Color getMnemonicColor() {
      return this.mnemonicColor;
   }

   public final Color getSymbolColor() {
      return this.symbolColor;
   }

   public final Color getImmediateColor() {
      return this.immediateColor;
   }

   public final Color getOperatorColor() {
      return this.operatorColor;
   }

   public final Color getRegisterColor() {
      return this.registerColor;
   }

   public final Color getSizePrefixColor() {
      return this.sizePrefixColor;
   }

   public final Color getDereferenceColor() {
      return this.dereferenceColor;
   }

   public final Color getOperatorSeparatorColor() {
      return this.operatorSeparatorColor;
   }

   public final Color getStackVariableColor() {
      return this.stackVariableColor;
   }

   public final Color getGlobalVariableColor() {
      return this.globalVariableColor;
   }

   public final Color getJumpLabelColor() {
      return this.jumpLabelColor;
   }

   public final Color getFunctionColor() {
      return this.functionColor;
   }

   public final Color getCommentColor() {
      return this.commentColor;
   }

   public final void setDefaultColor(Color var1) {
      this.defaultColor = var1;
   }

   public final void setAddressColor(Color var1) {
      this.addressColor = var1;
   }

   public final void setMnemonicColor(Color var1) {
      this.mnemonicColor = var1;
   }

   public final void setSymbolColor(Color var1) {
      this.symbolColor = var1;
   }

   public final void setImmediateColor(Color var1) {
      this.immediateColor = var1;
   }

   public final void setOperatorColor(Color var1) {
      this.operatorColor = var1;
   }

   public final void setRegisterColor(Color var1) {
      this.registerColor = var1;
   }

   public final void setSizePrefixColor(Color var1) {
      this.sizePrefixColor = var1;
   }

   public final void setDereferenceColor(Color var1) {
      this.dereferenceColor = var1;
   }

   public final void setOperatorSeparatorColor(Color var1) {
      this.operatorSeparatorColor = var1;
   }

   public final void setStackVariableColor(Color var1) {
      this.stackVariableColor = var1;
   }

   public final void setGlobalVariableColor(Color var1) {
      this.globalVariableColor = var1;
   }

   public final void setJumpLabelColor(Color var1) {
      this.jumpLabelColor = var1;
   }

   public final void setFunctionColor(Color var1) {
      this.functionColor = var1;
   }

   public final void setCommentColor(Color var1) {
      this.commentColor = var1;
   }
}
