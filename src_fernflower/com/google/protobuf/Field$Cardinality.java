package com.google.protobuf;

import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Field;
import com.google.protobuf.Field$Cardinality$1;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;

public enum Field$Cardinality implements ProtocolMessageEnum {
   CARDINALITY_UNKNOWN(0, 0),
   CARDINALITY_OPTIONAL(1, 1),
   CARDINALITY_REQUIRED(2, 2),
   CARDINALITY_REPEATED(3, 3),
   UNRECOGNIZED(-1, -1);

   public static final int CARDINALITY_UNKNOWN_VALUE = 0;
   public static final int CARDINALITY_OPTIONAL_VALUE = 1;
   public static final int CARDINALITY_REQUIRED_VALUE = 2;
   public static final int CARDINALITY_REPEATED_VALUE = 3;
   private static Internal$EnumLiteMap internalValueMap;
   private static final Field$Cardinality[] VALUES;
   private final int index;
   private final int value;

   public final int getNumber() {
      if(this.index == -1) {
         throw new IllegalArgumentException("Can\'t get the number of an unknown enum value.");
      } else {
         return this.value;
      }
   }

   public static Field$Cardinality valueOf(int var0) {
      switch(var0) {
      case 0:
         return CARDINALITY_UNKNOWN;
      case 1:
         return CARDINALITY_OPTIONAL;
      case 2:
         return CARDINALITY_REQUIRED;
      case 3:
         return CARDINALITY_REPEATED;
      default:
         return null;
      }
   }

   public static Internal$EnumLiteMap internalGetValueMap() {
      return internalValueMap;
   }

   public final Descriptors$EnumValueDescriptor getValueDescriptor() {
      return (Descriptors$EnumValueDescriptor)getDescriptor().getValues().get(this.index);
   }

   public final Descriptors$EnumDescriptor getDescriptorForType() {
      return getDescriptor();
   }

   public static final Descriptors$EnumDescriptor getDescriptor() {
      return (Descriptors$EnumDescriptor)Field.getDescriptor().getEnumTypes().get(1);
   }

   public static Field$Cardinality valueOf(Descriptors$EnumValueDescriptor var0) {
      if(var0.getType() != getDescriptor()) {
         throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
      } else {
         return var0.getIndex() == -1?UNRECOGNIZED:VALUES[var0.getIndex()];
      }
   }

   private Field$Cardinality(int var3, int var4) {
      this.index = var3;
      this.value = var4;
   }

   static {
      internalValueMap = new Field$Cardinality$1();
      VALUES = values();
   }
}
