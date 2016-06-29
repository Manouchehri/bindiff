/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.enums;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.ColorsConfigItem;
import com.google.security.zynamics.bindiff.enums.EInstructionHighlighting$1;
import java.awt.Color;

public enum EInstructionHighlighting {
    TYPE_DEFAULT,
    TYPE_ADDRESS,
    TYPE_MNEMONIC,
    TYPE_SYMBOL,
    TYPE_IMMEDIATE,
    TYPE_OPERATOR,
    TYPE_REGISTER,
    TYPE_SIZEPREFIX,
    TYPE_DEREFERENCE,
    TYPE_NEWOPERAND_COMMA,
    TYPE_STACKVARIABLE,
    TYPE_GLOBALVARIABLE,
    TYPE_JUMPLABEL,
    TYPE_FUNCTION,
    TYPE_COMMENT;
    
    public static int ENUM_ENTRY_COUNT;

    private EInstructionHighlighting() {
    }

    public static int convertExporterOrdinal(int n2) {
        switch (n2) {
            case 0: {
                return EInstructionHighlighting.getOrdinal(TYPE_MNEMONIC);
            }
            case 1: {
                return EInstructionHighlighting.getOrdinal(TYPE_SYMBOL);
            }
            case 2: {
                return EInstructionHighlighting.getOrdinal(TYPE_IMMEDIATE);
            }
            case 3: {
                return EInstructionHighlighting.getOrdinal(TYPE_IMMEDIATE);
            }
            case 4: {
                return EInstructionHighlighting.getOrdinal(TYPE_OPERATOR);
            }
            case 5: {
                return EInstructionHighlighting.getOrdinal(TYPE_REGISTER);
            }
            case 6: {
                return EInstructionHighlighting.getOrdinal(TYPE_SIZEPREFIX);
            }
            case 7: {
                return EInstructionHighlighting.getOrdinal(TYPE_DEREFERENCE);
            }
            case 8: {
                return EInstructionHighlighting.getOrdinal(TYPE_NEWOPERAND_COMMA);
            }
            case 9: {
                return EInstructionHighlighting.getOrdinal(TYPE_STACKVARIABLE);
            }
            case 10: {
                return EInstructionHighlighting.getOrdinal(TYPE_GLOBALVARIABLE);
            }
            case 11: {
                return EInstructionHighlighting.getOrdinal(TYPE_JUMPLABEL);
            }
            case 12: {
                return EInstructionHighlighting.getOrdinal(TYPE_FUNCTION);
            }
        }
        return EInstructionHighlighting.getOrdinal(TYPE_DEFAULT);
    }

    public static Color getColor(EInstructionHighlighting eInstructionHighlighting) {
        BinDiffConfigFile binDiffConfigFile = BinDiffConfigFile.getInstance();
        ColorsConfigItem colorsConfigItem = binDiffConfigFile.getColorSettings();
        switch (EInstructionHighlighting$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EInstructionHighlighting[eInstructionHighlighting.ordinal()]) {
            case 1: {
                return colorsConfigItem.getDefaultColor();
            }
            case 2: {
                return colorsConfigItem.getAddressColor();
            }
            case 3: {
                return colorsConfigItem.getMnemonicColor();
            }
            case 4: {
                return colorsConfigItem.getSymbolColor();
            }
            case 5: {
                return colorsConfigItem.getImmediateColor();
            }
            case 6: {
                return colorsConfigItem.getOperatorColor();
            }
            case 7: {
                return colorsConfigItem.getRegisterColor();
            }
            case 8: {
                return colorsConfigItem.getSizePrefixColor();
            }
            case 9: {
                return colorsConfigItem.getDereferenceColor();
            }
            case 10: {
                return colorsConfigItem.getOperatorSeparatorColor();
            }
            case 11: {
                return colorsConfigItem.getStackVariableColor();
            }
            case 12: {
                return colorsConfigItem.getGlobalVariableColor();
            }
            case 13: {
                return colorsConfigItem.getJumpLabelColor();
            }
            case 14: {
                return colorsConfigItem.getFunctionColor();
            }
            case 15: {
                return colorsConfigItem.getCommentColor();
            }
        }
        return binDiffConfigFile.getColorSettings().getDefaultColor();
    }

    public static Color getColor(int n2) {
        return EInstructionHighlighting.getColor(EInstructionHighlighting.getEnum(n2));
    }

    public static EInstructionHighlighting getEnum(int n2) {
        switch (n2) {
            case 0: {
                return TYPE_DEFAULT;
            }
            case 1: {
                return TYPE_ADDRESS;
            }
            case 2: {
                return TYPE_MNEMONIC;
            }
            case 3: {
                return TYPE_SYMBOL;
            }
            case 4: {
                return TYPE_IMMEDIATE;
            }
            case 5: {
                return TYPE_OPERATOR;
            }
            case 6: {
                return TYPE_REGISTER;
            }
            case 7: {
                return TYPE_SIZEPREFIX;
            }
            case 8: {
                return TYPE_DEREFERENCE;
            }
            case 9: {
                return TYPE_NEWOPERAND_COMMA;
            }
            case 10: {
                return TYPE_STACKVARIABLE;
            }
            case 11: {
                return TYPE_GLOBALVARIABLE;
            }
            case 12: {
                return TYPE_JUMPLABEL;
            }
            case 13: {
                return TYPE_FUNCTION;
            }
            case 14: {
                return TYPE_COMMENT;
            }
        }
        throw new IllegalStateException("Unknown operand highlighting type.");
    }

    public static int getOrdinal(EInstructionHighlighting eInstructionHighlighting) {
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
        }
        throw new IllegalStateException("Unknown operand highlighting type.");
    }

    public static int getSize() {
        return ENUM_ENTRY_COUNT;
    }

    static {
        ENUM_ENTRY_COUNT = 15;
    }
}

