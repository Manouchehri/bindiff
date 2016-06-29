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

   public static int convertExporterOrdinal(int var0) {
      switch(var0) {
      case 0:
         return getOrdinal(TYPE_MNEMONIC);
      case 1:
         return getOrdinal(TYPE_SYMBOL);
      case 2:
         return getOrdinal(TYPE_IMMEDIATE);
      case 3:
         return getOrdinal(TYPE_IMMEDIATE);
      case 4:
         return getOrdinal(TYPE_OPERATOR);
      case 5:
         return getOrdinal(TYPE_REGISTER);
      case 6:
         return getOrdinal(TYPE_SIZEPREFIX);
      case 7:
         return getOrdinal(TYPE_DEREFERENCE);
      case 8:
         return getOrdinal(TYPE_NEWOPERAND_COMMA);
      case 9:
         return getOrdinal(TYPE_STACKVARIABLE);
      case 10:
         return getOrdinal(TYPE_GLOBALVARIABLE);
      case 11:
         return getOrdinal(TYPE_JUMPLABEL);
      case 12:
         return getOrdinal(TYPE_FUNCTION);
      default:
         return getOrdinal(TYPE_DEFAULT);
      }
   }

   public static Color getColor(EInstructionHighlighting var0) {
      BinDiffConfigFile var1 = BinDiffConfigFile.getInstance();
      ColorsConfigItem var2 = var1.getColorSettings();
      switch(EInstructionHighlighting$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EInstructionHighlighting[var0.ordinal()]) {
      case 1:
         return var2.getDefaultColor();
      case 2:
         return var2.getAddressColor();
      case 3:
         return var2.getMnemonicColor();
      case 4:
         return var2.getSymbolColor();
      case 5:
         return var2.getImmediateColor();
      case 6:
         return var2.getOperatorColor();
      case 7:
         return var2.getRegisterColor();
      case 8:
         return var2.getSizePrefixColor();
      case 9:
         return var2.getDereferenceColor();
      case 10:
         return var2.getOperatorSeparatorColor();
      case 11:
         return var2.getStackVariableColor();
      case 12:
         return var2.getGlobalVariableColor();
      case 13:
         return var2.getJumpLabelColor();
      case 14:
         return var2.getFunctionColor();
      case 15:
         return var2.getCommentColor();
      default:
         return var1.getColorSettings().getDefaultColor();
      }
   }

   public static Color getColor(int var0) {
      return getColor(getEnum(var0));
   }

   public static EInstructionHighlighting getEnum(int var0) {
      switch(var0) {
      case 0:
         return TYPE_DEFAULT;
      case 1:
         return TYPE_ADDRESS;
      case 2:
         return TYPE_MNEMONIC;
      case 3:
         return TYPE_SYMBOL;
      case 4:
         return TYPE_IMMEDIATE;
      case 5:
         return TYPE_OPERATOR;
      case 6:
         return TYPE_REGISTER;
      case 7:
         return TYPE_SIZEPREFIX;
      case 8:
         return TYPE_DEREFERENCE;
      case 9:
         return TYPE_NEWOPERAND_COMMA;
      case 10:
         return TYPE_STACKVARIABLE;
      case 11:
         return TYPE_GLOBALVARIABLE;
      case 12:
         return TYPE_JUMPLABEL;
      case 13:
         return TYPE_FUNCTION;
      case 14:
         return TYPE_COMMENT;
      default:
         throw new IllegalStateException("Unknown operand highlighting type.");
      }
   }

   public static int getOrdinal(EInstructionHighlighting var0) {
      switch(EInstructionHighlighting$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EInstructionHighlighting[var0.ordinal()]) {
      case 1:
         return 0;
      case 2:
         return 1;
      case 3:
         return 2;
      case 4:
         return 3;
      case 5:
         return 4;
      case 6:
         return 5;
      case 7:
         return 6;
      case 8:
         return 7;
      case 9:
         return 8;
      case 10:
         return 9;
      case 11:
         return 10;
      case 12:
         return 11;
      case 13:
         return 12;
      case 14:
         return 13;
      case 15:
         return 14;
      default:
         throw new IllegalStateException("Unknown operand highlighting type.");
      }
   }

   public static int getSize() {
      return ENUM_ENTRY_COUNT;
   }

   static {
      ENUM_ENTRY_COUNT = 15;
   }
}
