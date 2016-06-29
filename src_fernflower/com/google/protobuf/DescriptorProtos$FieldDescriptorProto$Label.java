package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Label$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;

public enum DescriptorProtos$FieldDescriptorProto$Label implements ProtocolMessageEnum {
   LABEL_OPTIONAL(0, 1),
   LABEL_REQUIRED(1, 2),
   LABEL_REPEATED(2, 3);

   public static final int LABEL_OPTIONAL_VALUE = 1;
   public static final int LABEL_REQUIRED_VALUE = 2;
   public static final int LABEL_REPEATED_VALUE = 3;
   private static Internal$EnumLiteMap internalValueMap;
   private static final DescriptorProtos$FieldDescriptorProto$Label[] VALUES;
   private final int index;
   private final int value;

   public final int getNumber() {
      return this.value;
   }

   public static DescriptorProtos$FieldDescriptorProto$Label valueOf(int var0) {
      switch(var0) {
      case 1:
         return LABEL_OPTIONAL;
      case 2:
         return LABEL_REQUIRED;
      case 3:
         return LABEL_REPEATED;
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
      return (Descriptors$EnumDescriptor)DescriptorProtos$FieldDescriptorProto.getDescriptor().getEnumTypes().get(1);
   }

   public static DescriptorProtos$FieldDescriptorProto$Label valueOf(Descriptors$EnumValueDescriptor var0) {
      if(var0.getType() != getDescriptor()) {
         throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
      } else {
         return VALUES[var0.getIndex()];
      }
   }

   private DescriptorProtos$FieldDescriptorProto$Label(int var3, int var4) {
      this.index = var3;
      this.value = var4;
   }

   static {
      internalValueMap = new DescriptorProtos$FieldDescriptorProto$Label$1();
      VALUES = values();
   }
}
