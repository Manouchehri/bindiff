/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.config;

import com.google.security.zynamics.common.config.AbstractConfigItem;
import com.google.security.zynamics.common.config.TypedPropertiesWrapper;
import java.awt.Color;

public class ColorsConfigItem
extends AbstractConfigItem {
    private static final String DEFAULT_COLOR = "DefaultColor";
    private static final Color DEFAULT_COLOR_DEFAULT = new Color(-16777216);
    private Color defaultColor = DEFAULT_COLOR_DEFAULT;
    private static final String ADDRESS_COLOR = "AddressColor";
    private static final Color ADDRESS_COLOR_DEFAULT = new Color(-16777216);
    private Color addressColor = ADDRESS_COLOR_DEFAULT;
    private static final String MNEMONIC_COLOR = "MnemonicColor";
    private static final Color MNEMONIC_COLOR_DEFAULT = new Color(-16777088);
    private Color mnemonicColor = MNEMONIC_COLOR_DEFAULT;
    private static final String SYMBOL_COLOR = "SymbolColor";
    private static final Color SYMBOL_COLOR_DEFAULT = new Color(-7076089);
    private Color symbolColor = SYMBOL_COLOR_DEFAULT;
    private static final String IMMEDIATE_COLOR = "ImmediateColor";
    private static final Color IMMEDIATE_COLOR_DEFAULT = new Color(-7602176);
    private Color immediateColor = IMMEDIATE_COLOR_DEFAULT;
    private static final String OPERATOR_COLOR = "OperatorColor";
    private static final Color OPERATOR_COLOR_DEFAULT = new Color(-16711423);
    private Color operatorColor = OPERATOR_COLOR_DEFAULT;
    private static final String REGISTER_COLOR = "RegisterColor";
    private static final Color REGISTER_COLOR_DEFAULT = new Color(-16750615);
    private Color registerColor = REGISTER_COLOR_DEFAULT;
    private static final String SIZE_PREFIX_COLOR = "SizePrefixColor";
    private static final Color SIZE_PREFIX_COLOR_DEFAULT = new Color(-6316386);
    private Color sizePrefixColor = SIZE_PREFIX_COLOR_DEFAULT;
    private static final String DEREFERENCE_COLOR = "DereferenceColor";
    private static final Color DEREFERENCE_COLOR_DEFAULT = new Color(-16711423);
    private Color dereferenceColor = DEREFERENCE_COLOR_DEFAULT;
    private static final String OPERATOR_SEPARATOR_COLOR = "OperatorSeparatorColor";
    private static final Color OPERATOR_SEPARATOR_COLOR_DEFAULT = new Color(-16777216);
    private Color operatorSeparatorColor = OPERATOR_SEPARATOR_COLOR_DEFAULT;
    private static final String STACK_VARIABLE_COLOR = "StackVariableColor";
    private static final Color STACK_VARIABLE_COLOR_DEFAULT = new Color(-7602176);
    private Color stackVariableColor = STACK_VARIABLE_COLOR_DEFAULT;
    private static final String GLOBAL_VARIABLE_COLOR = "GlobalVariableColor";
    private static final Color GLOBAL_VARIABLE_COLOR_DEFAULT = new Color(-7602176);
    private Color globalVariableColor = GLOBAL_VARIABLE_COLOR_DEFAULT;
    private static final String JUMP_LABEL_COLOR = "JumpLabelColor";
    private static final Color JUMP_LABEL_COLOR_DEFAULT = new Color(-6291296);
    private Color jumpLabelColor = JUMP_LABEL_COLOR_DEFAULT;
    private static final String FUNCTION_COLOR = "FunctionColor";
    private static final Color FUNCTION_COLOR_DEFAULT = new Color(-7602176);
    private Color functionColor = FUNCTION_COLOR_DEFAULT;
    private static final String COMMENT_COLOR = "CommentColor";
    private static final Color COMMENT_COLOR_DEFAULT = new Color(-10197916);
    private Color commentColor = COMMENT_COLOR_DEFAULT;

    @Override
    public void load(TypedPropertiesWrapper typedPropertiesWrapper) {
        this.defaultColor = typedPropertiesWrapper.getColor("DefaultColor", DEFAULT_COLOR_DEFAULT);
        this.addressColor = typedPropertiesWrapper.getColor("AddressColor", ADDRESS_COLOR_DEFAULT);
        this.mnemonicColor = typedPropertiesWrapper.getColor("MnemonicColor", MNEMONIC_COLOR_DEFAULT);
        this.symbolColor = typedPropertiesWrapper.getColor("SymbolColor", SYMBOL_COLOR_DEFAULT);
        this.immediateColor = typedPropertiesWrapper.getColor("ImmediateColor", IMMEDIATE_COLOR_DEFAULT);
        this.operatorColor = typedPropertiesWrapper.getColor("OperatorColor", OPERATOR_COLOR_DEFAULT);
        this.registerColor = typedPropertiesWrapper.getColor("RegisterColor", REGISTER_COLOR_DEFAULT);
        this.sizePrefixColor = typedPropertiesWrapper.getColor("SizePrefixColor", SIZE_PREFIX_COLOR_DEFAULT);
        this.dereferenceColor = typedPropertiesWrapper.getColor("DereferenceColor", DEREFERENCE_COLOR_DEFAULT);
        this.operatorSeparatorColor = typedPropertiesWrapper.getColor("OperatorSeparatorColor", OPERATOR_SEPARATOR_COLOR_DEFAULT);
        this.stackVariableColor = typedPropertiesWrapper.getColor("StackVariableColor", STACK_VARIABLE_COLOR_DEFAULT);
        this.globalVariableColor = typedPropertiesWrapper.getColor("GlobalVariableColor", GLOBAL_VARIABLE_COLOR_DEFAULT);
        this.jumpLabelColor = typedPropertiesWrapper.getColor("JumpLabelColor", JUMP_LABEL_COLOR_DEFAULT);
        this.functionColor = typedPropertiesWrapper.getColor("FunctionColor", FUNCTION_COLOR_DEFAULT);
        this.commentColor = typedPropertiesWrapper.getColor("CommentColor", COMMENT_COLOR_DEFAULT);
    }

    @Override
    public void store(TypedPropertiesWrapper typedPropertiesWrapper) {
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

    public final void setDefaultColor(Color color) {
        this.defaultColor = color;
    }

    public final void setAddressColor(Color color) {
        this.addressColor = color;
    }

    public final void setMnemonicColor(Color color) {
        this.mnemonicColor = color;
    }

    public final void setSymbolColor(Color color) {
        this.symbolColor = color;
    }

    public final void setImmediateColor(Color color) {
        this.immediateColor = color;
    }

    public final void setOperatorColor(Color color) {
        this.operatorColor = color;
    }

    public final void setRegisterColor(Color color) {
        this.registerColor = color;
    }

    public final void setSizePrefixColor(Color color) {
        this.sizePrefixColor = color;
    }

    public final void setDereferenceColor(Color color) {
        this.dereferenceColor = color;
    }

    public final void setOperatorSeparatorColor(Color color) {
        this.operatorSeparatorColor = color;
    }

    public final void setStackVariableColor(Color color) {
        this.stackVariableColor = color;
    }

    public final void setGlobalVariableColor(Color color) {
        this.globalVariableColor = color;
    }

    public final void setJumpLabelColor(Color color) {
        this.jumpLabelColor = color;
    }

    public final void setFunctionColor(Color color) {
        this.functionColor = color;
    }

    public final void setCommentColor(Color color) {
        this.commentColor = color;
    }
}

