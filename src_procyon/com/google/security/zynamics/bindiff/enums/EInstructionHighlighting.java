package com.google.security.zynamics.bindiff.enums;

import java.awt.*;
import com.google.security.zynamics.bindiff.config.*;

public enum EInstructionHighlighting
{
    TYPE_DEFAULT("TYPE_DEFAULT", 0), 
    TYPE_ADDRESS("TYPE_ADDRESS", 1), 
    TYPE_MNEMONIC("TYPE_MNEMONIC", 2), 
    TYPE_SYMBOL("TYPE_SYMBOL", 3), 
    TYPE_IMMEDIATE("TYPE_IMMEDIATE", 4), 
    TYPE_OPERATOR("TYPE_OPERATOR", 5), 
    TYPE_REGISTER("TYPE_REGISTER", 6), 
    TYPE_SIZEPREFIX("TYPE_SIZEPREFIX", 7), 
    TYPE_DEREFERENCE("TYPE_DEREFERENCE", 8), 
    TYPE_NEWOPERAND_COMMA("TYPE_NEWOPERAND_COMMA", 9), 
    TYPE_STACKVARIABLE("TYPE_STACKVARIABLE", 10), 
    TYPE_GLOBALVARIABLE("TYPE_GLOBALVARIABLE", 11), 
    TYPE_JUMPLABEL("TYPE_JUMPLABEL", 12), 
    TYPE_FUNCTION("TYPE_FUNCTION", 13), 
    TYPE_COMMENT("TYPE_COMMENT", 14);
    
    public static int ENUM_ENTRY_COUNT;
    
    private EInstructionHighlighting(final String s, final int n) {
    }
    
    public static int convertExporterOrdinal(final int n) {
        switch (n) {
            case 0: {
                return getOrdinal(EInstructionHighlighting.TYPE_MNEMONIC);
            }
            case 1: {
                return getOrdinal(EInstructionHighlighting.TYPE_SYMBOL);
            }
            case 2: {
                return getOrdinal(EInstructionHighlighting.TYPE_IMMEDIATE);
            }
            case 3: {
                return getOrdinal(EInstructionHighlighting.TYPE_IMMEDIATE);
            }
            case 4: {
                return getOrdinal(EInstructionHighlighting.TYPE_OPERATOR);
            }
            case 5: {
                return getOrdinal(EInstructionHighlighting.TYPE_REGISTER);
            }
            case 6: {
                return getOrdinal(EInstructionHighlighting.TYPE_SIZEPREFIX);
            }
            case 7: {
                return getOrdinal(EInstructionHighlighting.TYPE_DEREFERENCE);
            }
            case 8: {
                return getOrdinal(EInstructionHighlighting.TYPE_NEWOPERAND_COMMA);
            }
            case 9: {
                return getOrdinal(EInstructionHighlighting.TYPE_STACKVARIABLE);
            }
            case 10: {
                return getOrdinal(EInstructionHighlighting.TYPE_GLOBALVARIABLE);
            }
            case 11: {
                return getOrdinal(EInstructionHighlighting.TYPE_JUMPLABEL);
            }
            case 12: {
                return getOrdinal(EInstructionHighlighting.TYPE_FUNCTION);
            }
            default: {
                return getOrdinal(EInstructionHighlighting.TYPE_DEFAULT);
            }
        }
    }
    
    public static Color getColor(final EInstructionHighlighting eInstructionHighlighting) {
        final BinDiffConfigFile instance = BinDiffConfigFile.getInstance();
        final ColorsConfigItem colorSettings = instance.getColorSettings();
        switch (EInstructionHighlighting$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EInstructionHighlighting[eInstructionHighlighting.ordinal()]) {
            case 1: {
                return colorSettings.getDefaultColor();
            }
            case 2: {
                return colorSettings.getAddressColor();
            }
            case 3: {
                return colorSettings.getMnemonicColor();
            }
            case 4: {
                return colorSettings.getSymbolColor();
            }
            case 5: {
                return colorSettings.getImmediateColor();
            }
            case 6: {
                return colorSettings.getOperatorColor();
            }
            case 7: {
                return colorSettings.getRegisterColor();
            }
            case 8: {
                return colorSettings.getSizePrefixColor();
            }
            case 9: {
                return colorSettings.getDereferenceColor();
            }
            case 10: {
                return colorSettings.getOperatorSeparatorColor();
            }
            case 11: {
                return colorSettings.getStackVariableColor();
            }
            case 12: {
                return colorSettings.getGlobalVariableColor();
            }
            case 13: {
                return colorSettings.getJumpLabelColor();
            }
            case 14: {
                return colorSettings.getFunctionColor();
            }
            case 15: {
                return colorSettings.getCommentColor();
            }
            default: {
                return instance.getColorSettings().getDefaultColor();
            }
        }
    }
    
    public static Color getColor(final int n) {
        return getColor(getEnum(n));
    }
    
    public static EInstructionHighlighting getEnum(final int n) {
        switch (n) {
            case 0: {
                return EInstructionHighlighting.TYPE_DEFAULT;
            }
            case 1: {
                return EInstructionHighlighting.TYPE_ADDRESS;
            }
            case 2: {
                return EInstructionHighlighting.TYPE_MNEMONIC;
            }
            case 3: {
                return EInstructionHighlighting.TYPE_SYMBOL;
            }
            case 4: {
                return EInstructionHighlighting.TYPE_IMMEDIATE;
            }
            case 5: {
                return EInstructionHighlighting.TYPE_OPERATOR;
            }
            case 6: {
                return EInstructionHighlighting.TYPE_REGISTER;
            }
            case 7: {
                return EInstructionHighlighting.TYPE_SIZEPREFIX;
            }
            case 8: {
                return EInstructionHighlighting.TYPE_DEREFERENCE;
            }
            case 9: {
                return EInstructionHighlighting.TYPE_NEWOPERAND_COMMA;
            }
            case 10: {
                return EInstructionHighlighting.TYPE_STACKVARIABLE;
            }
            case 11: {
                return EInstructionHighlighting.TYPE_GLOBALVARIABLE;
            }
            case 12: {
                return EInstructionHighlighting.TYPE_JUMPLABEL;
            }
            case 13: {
                return EInstructionHighlighting.TYPE_FUNCTION;
            }
            case 14: {
                return EInstructionHighlighting.TYPE_COMMENT;
            }
            default: {
                throw new IllegalStateException("Unknown operand highlighting type.");
            }
        }
    }
    
    public static int getOrdinal(final EInstructionHighlighting eInstructionHighlighting) {
        switch (EInstructionHighlighting$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EInstructionHighlighting[eInstructionHighlighting.ordinal()]) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 4: {
                return 3;
            }
            case 5: {
                return 4;
            }
            case 6: {
                return 5;
            }
            case 7: {
                return 6;
            }
            case 8: {
                return 7;
            }
            case 9: {
                return 8;
            }
            case 10: {
                return 9;
            }
            case 11: {
                return 10;
            }
            case 12: {
                return 11;
            }
            case 13: {
                return 12;
            }
            case 14: {
                return 13;
            }
            case 15: {
                return 14;
            }
            default: {
                throw new IllegalStateException("Unknown operand highlighting type.");
            }
        }
    }
    
    public static int getSize() {
        return EInstructionHighlighting.ENUM_ENTRY_COUNT;
    }
    
    static {
        EInstructionHighlighting.ENUM_ENTRY_COUNT = 15;
    }
}
