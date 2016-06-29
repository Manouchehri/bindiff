package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.DescriptorProtos$FieldOptions$CType$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;

public enum DescriptorProtos$FieldOptions$CType implements ProtocolMessageEnum {
   STRING(0, 0),
   CORD(1, 1),
   STRING_PIECE(2, 2);

   public static final int STRING_VALUE = 0;
   public static final int CORD_VALUE = 1;
   public static final int STRING_PIECE_VALUE = 2;
   private static Internal$EnumLiteMap internalValueMap;
   private static final DescriptorProtos$FieldOptions$CType[] VALUES;
   private final int index;
   private final int value;

   public final int getNumber() {
      return this.value;
   }

   public static DescriptorProtos$FieldOptions$CType valueOf(int var0) {
      switch(var0) {
      case 0:
         return STRING;
      case 1:
         return CORD;
      case 2:
         return STRING_PIECE;
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
      return (Descriptors$EnumDescriptor)DescriptorProtos$FieldOptions.getDescriptor().getEnumTypes().get(0);
   }

   public static DescriptorProtos$FieldOptions$CType valueOf(Descriptors$EnumValueDescriptor var0) {
      if(var0.getType() != getDescriptor()) {
         throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
      } else {
         return VALUES[var0.getIndex()];
      }
   }

   private DescriptorProtos$FieldOptions$CType(int var3, int var4) {
      this.index = var3;
      this.value = var4;
   }

   static {
      internalValueMap = new DescriptorProtos$FieldOptions$CType$1();
      VALUES = values();
   }
}
