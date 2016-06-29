package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.DescriptorProtos$FieldOptions$JSType$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;

public enum DescriptorProtos$FieldOptions$JSType implements ProtocolMessageEnum {
   JS_NORMAL(0, 0),
   JS_STRING(1, 1),
   JS_NUMBER(2, 2);

   public static final int JS_NORMAL_VALUE = 0;
   public static final int JS_STRING_VALUE = 1;
   public static final int JS_NUMBER_VALUE = 2;
   private static Internal$EnumLiteMap internalValueMap;
   private static final DescriptorProtos$FieldOptions$JSType[] VALUES;
   private final int index;
   private final int value;

   public final int getNumber() {
      return this.value;
   }

   public static DescriptorProtos$FieldOptions$JSType valueOf(int var0) {
      switch(var0) {
      case 0:
         return JS_NORMAL;
      case 1:
         return JS_STRING;
      case 2:
         return JS_NUMBER;
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
      return (Descriptors$EnumDescriptor)DescriptorProtos$FieldOptions.getDescriptor().getEnumTypes().get(1);
   }

   public static DescriptorProtos$FieldOptions$JSType valueOf(Descriptors$EnumValueDescriptor var0) {
      if(var0.getType() != getDescriptor()) {
         throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
      } else {
         return VALUES[var0.getIndex()];
      }
   }

   private DescriptorProtos$FieldOptions$JSType(int var3, int var4) {
      this.index = var3;
      this.value = var4;
   }

   static {
      internalValueMap = new DescriptorProtos$FieldOptions$JSType$1();
      VALUES = values();
   }
}
