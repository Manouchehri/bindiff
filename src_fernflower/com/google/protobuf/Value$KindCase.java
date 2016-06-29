package com.google.protobuf;

import com.google.protobuf.Internal$EnumLite;

public enum Value$KindCase implements Internal$EnumLite {
   NULL_VALUE(1),
   NUMBER_VALUE(2),
   STRING_VALUE(3),
   BOOL_VALUE(4),
   STRUCT_VALUE(5),
   LIST_VALUE(6),
   KIND_NOT_SET(0);

   private int value = 0;

   private Value$KindCase(int var3) {
      this.value = var3;
   }

   public static Value$KindCase valueOf(int var0) {
      switch(var0) {
      case 0:
         return KIND_NOT_SET;
      case 1:
         return NULL_VALUE;
      case 2:
         return NUMBER_VALUE;
      case 3:
         return STRING_VALUE;
      case 4:
         return BOOL_VALUE;
      case 5:
         return STRUCT_VALUE;
      case 6:
         return LIST_VALUE;
      default:
         throw new IllegalArgumentException("Value is undefined for this oneof enum.");
      }
   }

   public int getNumber() {
      return this.value;
   }
}
