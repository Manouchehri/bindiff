package com.google.security.zynamics.bindiff.config;

import java.awt.*;
import com.google.security.zynamics.common.config.*;

public class ColorsConfigItem extends AbstractConfigItem
{
    private static final String DEFAULT_COLOR = "DefaultColor";
    private static final Color DEFAULT_COLOR_DEFAULT;
    private Color defaultColor;
    private static final String ADDRESS_COLOR = "AddressColor";
    private static final Color ADDRESS_COLOR_DEFAULT;
    private Color addressColor;
    private static final String MNEMONIC_COLOR = "MnemonicColor";
    private static final Color MNEMONIC_COLOR_DEFAULT;
    private Color mnemonicColor;
    private static final String SYMBOL_COLOR = "SymbolColor";
    private static final Color SYMBOL_COLOR_DEFAULT;
    private Color symbolColor;
    private static final String IMMEDIATE_COLOR = "ImmediateColor";
    private static final Color IMMEDIATE_COLOR_DEFAULT;
    private Color immediateColor;
    private static final String OPERATOR_COLOR = "OperatorColor";
    private static final Color OPERATOR_COLOR_DEFAULT;
    private Color operatorColor;
    private static final String REGISTER_COLOR = "RegisterColor";
    private static final Color REGISTER_COLOR_DEFAULT;
    private Color registerColor;
    private static final String SIZE_PREFIX_COLOR = "SizePrefixColor";
    private static final Color SIZE_PREFIX_COLOR_DEFAULT;
    private Color sizePrefixColor;
    private static final String DEREFERENCE_COLOR = "DereferenceColor";
    private static final Color DEREFERENCE_COLOR_DEFAULT;
    private Color dereferenceColor;
    private static final String OPERATOR_SEPARATOR_COLOR = "OperatorSeparatorColor";
    private static final Color OPERATOR_SEPARATOR_COLOR_DEFAULT;
    private Color operatorSeparatorColor;
    private static final String STACK_VARIABLE_COLOR = "StackVariableColor";
    private static final Color STACK_VARIABLE_COLOR_DEFAULT;
    private Color stackVariableColor;
    private static final String GLOBAL_VARIABLE_COLOR = "GlobalVariableColor";
    private static final Color GLOBAL_VARIABLE_COLOR_DEFAULT;
    private Color globalVariableColor;
    private static final String JUMP_LABEL_COLOR = "JumpLabelColor";
    private static final Color JUMP_LABEL_COLOR_DEFAULT;
    private Color jumpLabelColor;
    private static final String FUNCTION_COLOR = "FunctionColor";
    private static final Color FUNCTION_COLOR_DEFAULT;
    private Color functionColor;
    private static final String COMMENT_COLOR = "CommentColor";
    private static final Color COMMENT_COLOR_DEFAULT;
    private Color commentColor;
    
    public ColorsConfigItem() {
        this.defaultColor = ColorsConfigItem.DEFAULT_COLOR_DEFAULT;
        this.addressColor = ColorsConfigItem.ADDRESS_COLOR_DEFAULT;
        this.mnemonicColor = ColorsConfigItem.MNEMONIC_COLOR_DEFAULT;
        this.symbolColor = ColorsConfigItem.SYMBOL_COLOR_DEFAULT;
        this.immediateColor = ColorsConfigItem.IMMEDIATE_COLOR_DEFAULT;
        this.operatorColor = ColorsConfigItem.OPERATOR_COLOR_DEFAULT;
        this.registerColor = ColorsConfigItem.REGISTER_COLOR_DEFAULT;
        this.sizePrefixColor = ColorsConfigItem.SIZE_PREFIX_COLOR_DEFAULT;
        this.dereferenceColor = ColorsConfigItem.DEREFERENCE_COLOR_DEFAULT;
        this.operatorSeparatorColor = ColorsConfigItem.OPERATOR_SEPARATOR_COLOR_DEFAULT;
        this.stackVariableColor = ColorsConfigItem.STACK_VARIABLE_COLOR_DEFAULT;
        this.globalVariableColor = ColorsConfigItem.GLOBAL_VARIABLE_COLOR_DEFAULT;
        this.jumpLabelColor = ColorsConfigItem.JUMP_LABEL_COLOR_DEFAULT;
        this.functionColor = ColorsConfigItem.FUNCTION_COLOR_DEFAULT;
        this.commentColor = ColorsConfigItem.COMMENT_COLOR_DEFAULT;
    }
    
    @Override
    public void load(final TypedPropertiesWrapper typedPropertiesWrapper) {
        this.defaultColor = typedPropertiesWrapper.getColor("DefaultColor", ColorsConfigItem.DEFAULT_COLOR_DEFAULT);
        this.addressColor = typedPropertiesWrapper.getColor("AddressColor", ColorsConfigItem.ADDRESS_COLOR_DEFAULT);
        this.mnemonicColor = typedPropertiesWrapper.getColor("MnemonicColor", ColorsConfigItem.MNEMONIC_COLOR_DEFAULT);
        this.symbolColor = typedPropertiesWrapper.getColor("SymbolColor", ColorsConfigItem.SYMBOL_COLOR_DEFAULT);
        this.immediateColor = typedPropertiesWrapper.getColor("ImmediateColor", ColorsConfigItem.IMMEDIATE_COLOR_DEFAULT);
        this.operatorColor = typedPropertiesWrapper.getColor("OperatorColor", ColorsConfigItem.OPERATOR_COLOR_DEFAULT);
        this.registerColor = typedPropertiesWrapper.getColor("RegisterColor", ColorsConfigItem.REGISTER_COLOR_DEFAULT);
        this.sizePrefixColor = typedPropertiesWrapper.getColor("SizePrefixColor", ColorsConfigItem.SIZE_PREFIX_COLOR_DEFAULT);
        this.dereferenceColor = typedPropertiesWrapper.getColor("DereferenceColor", ColorsConfigItem.DEREFERENCE_COLOR_DEFAULT);
        this.operatorSeparatorColor = typedPropertiesWrapper.getColor("OperatorSeparatorColor", ColorsConfigItem.OPERATOR_SEPARATOR_COLOR_DEFAULT);
        this.stackVariableColor = typedPropertiesWrapper.getColor("StackVariableColor", ColorsConfigItem.STACK_VARIABLE_COLOR_DEFAULT);
        this.globalVariableColor = typedPropertiesWrapper.getColor("GlobalVariableColor", ColorsConfigItem.GLOBAL_VARIABLE_COLOR_DEFAULT);
        this.jumpLabelColor = typedPropertiesWrapper.getColor("JumpLabelColor", ColorsConfigItem.JUMP_LABEL_COLOR_DEFAULT);
        this.functionColor = typedPropertiesWrapper.getColor("FunctionColor", ColorsConfigItem.FUNCTION_COLOR_DEFAULT);
        this.commentColor = typedPropertiesWrapper.getColor("CommentColor", ColorsConfigItem.COMMENT_COLOR_DEFAULT);
    }
    
    @Override
    public void store(final TypedPropertiesWrapper typedPropertiesWrapper) {
        typedPropertiesWrapper.setColor("DefaultColor", this.defaultColor);
        typedPropertiesWrapper.setColor("AddressColor", this.addressColor);
        typedPropertiesWrapper.setColor("MnemonicColor", this.mnemonicColor);
        typedPropertiesWrapper.setColor("SymbolColor", this.symbolColor);
        typedPropertiesWrapper.setColor("ImmediateColor", this.immediateColor);
        typedPropertiesWrapper.setColor("OperatorColor", this.operatorColor);
        typedPropertiesWrapper.setColor("RegisterColor", this.registerColor);
        typedPropertiesWrapper.setColor("SizePrefixColor", this.sizePrefixColor);
        typedPropertiesWrapper.setColor("DereferenceColor", this.dereferenceColor);
        typedPropertiesWrapper.setColor("OperatorSeparatorColor", this.operatorSeparatorColor);
        typedPropertiesWrapper.setColor("StackVariableColor", this.stackVariableColor);
        typedPropertiesWrapper.setColor("GlobalVariableColor", this.globalVariableColor);
        typedPropertiesWrapper.setColor("JumpLabelColor", this.jumpLabelColor);
        typedPropertiesWrapper.setColor("FunctionColor", this.functionColor);
        typedPropertiesWrapper.setColor("CommentColor", this.commentColor);
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
    
    public final void setDefaultColor(final Color defaultColor) {
        this.defaultColor = defaultColor;
    }
    
    public final void setAddressColor(final Color addressColor) {
        this.addressColor = addressColor;
    }
    
    public final void setMnemonicColor(final Color mnemonicColor) {
        this.mnemonicColor = mnemonicColor;
    }
    
    public final void setSymbolColor(final Color symbolColor) {
        this.symbolColor = symbolColor;
    }
    
    public final void setImmediateColor(final Color immediateColor) {
        this.immediateColor = immediateColor;
    }
    
    public final void setOperatorColor(final Color operatorColor) {
        this.operatorColor = operatorColor;
    }
    
    public final void setRegisterColor(final Color registerColor) {
        this.registerColor = registerColor;
    }
    
    public final void setSizePrefixColor(final Color sizePrefixColor) {
        this.sizePrefixColor = sizePrefixColor;
    }
    
    public final void setDereferenceColor(final Color dereferenceColor) {
        this.dereferenceColor = dereferenceColor;
    }
    
    public final void setOperatorSeparatorColor(final Color operatorSeparatorColor) {
        this.operatorSeparatorColor = operatorSeparatorColor;
    }
    
    public final void setStackVariableColor(final Color stackVariableColor) {
        this.stackVariableColor = stackVariableColor;
    }
    
    public final void setGlobalVariableColor(final Color globalVariableColor) {
        this.globalVariableColor = globalVariableColor;
    }
    
    public final void setJumpLabelColor(final Color jumpLabelColor) {
        this.jumpLabelColor = jumpLabelColor;
    }
    
    public final void setFunctionColor(final Color functionColor) {
        this.functionColor = functionColor;
    }
    
    public final void setCommentColor(final Color commentColor) {
        this.commentColor = commentColor;
    }
    
    static {
        DEFAULT_COLOR_DEFAULT = new Color(-16777216);
        ADDRESS_COLOR_DEFAULT = new Color(-16777216);
        MNEMONIC_COLOR_DEFAULT = new Color(-16777088);
        SYMBOL_COLOR_DEFAULT = new Color(-7076089);
        IMMEDIATE_COLOR_DEFAULT = new Color(-7602176);
        OPERATOR_COLOR_DEFAULT = new Color(-16711423);
        REGISTER_COLOR_DEFAULT = new Color(-16750615);
        SIZE_PREFIX_COLOR_DEFAULT = new Color(-6316386);
        DEREFERENCE_COLOR_DEFAULT = new Color(-16711423);
        OPERATOR_SEPARATOR_COLOR_DEFAULT = new Color(-16777216);
        STACK_VARIABLE_COLOR_DEFAULT = new Color(-7602176);
        GLOBAL_VARIABLE_COLOR_DEFAULT = new Color(-7602176);
        JUMP_LABEL_COLOR_DEFAULT = new Color(-6291296);
        FUNCTION_COLOR_DEFAULT = new Color(-7602176);
        COMMENT_COLOR_DEFAULT = new Color(-10197916);
    }
}
