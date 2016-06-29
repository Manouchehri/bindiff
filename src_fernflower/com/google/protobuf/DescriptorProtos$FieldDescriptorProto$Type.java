package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Type$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;

public enum DescriptorProtos$FieldDescriptorProto$Type implements ProtocolMessageEnum {
   TYPE_DOUBLE(0, 1),
   TYPE_FLOAT(1, 2),
   TYPE_INT64(2, 3),
   TYPE_UINT64(3, 4),
   TYPE_INT32(4, 5),
   TYPE_FIXED64(5, 6),
   TYPE_FIXED32(6, 7),
   TYPE_BOOL(7, 8),
   TYPE_STRING(8, 9),
   TYPE_GROUP(9, 10),
   TYPE_MESSAGE(10, 11),
   TYPE_BYTES(11, 12),
   TYPE_UINT32(12, 13),
   TYPE_ENUM(13, 14),
   TYPE_SFIXED32(14, 15),
   TYPE_SFIXED64(15, 16),
   TYPE_SINT32(16, 17),
   TYPE_SINT64(17, 18);

   public static final int TYPE_DOUBLE_VALUE = 1;
   public static final int TYPE_FLOAT_VALUE = 2;
   public static final int TYPE_INT64_VALUE = 3;
   public static final int TYPE_UINT64_VALUE = 4;
   public static final int TYPE_INT32_VALUE = 5;
   public static final int TYPE_FIXED64_VALUE = 6;
   public static final int TYPE_FIXED32_VALUE = 7;
   public static final int TYPE_BOOL_VALUE = 8;
   public static final int TYPE_STRING_VALUE = 9;
   public static final int TYPE_GROUP_VALUE = 10;
   public static final int TYPE_MESSAGE_VALUE = 11;
   public static final int TYPE_BYTES_VALUE = 12;
   public static final int TYPE_UINT32_VALUE = 13;
   public static final int TYPE_ENUM_VALUE = 14;
   public static final int TYPE_SFIXED32_VALUE = 15;
   public static final int TYPE_SFIXED64_VALUE = 16;
   public static final int TYPE_SINT32_VALUE = 17;
   public static final int TYPE_SINT64_VALUE = 18;
   private static Internal$EnumLiteMap internalValueMap;
   private static final DescriptorProtos$FieldDescriptorProto$Type[] VALUES;
   private final int index;
   private final int value;

   public final int getNumber() {
      return this.value;
   }

   public static DescriptorProtos$FieldDescriptorProto$Type valueOf(int var0) {
      switch(var0) {
      case 1:
         return TYPE_DOUBLE;
      case 2:
         return TYPE_FLOAT;
      case 3:
         return TYPE_INT64;
      case 4:
         return TYPE_UINT64;
      case 5:
         return TYPE_INT32;
      case 6:
         return TYPE_FIXED64;
      case 7:
         return TYPE_FIXED32;
      case 8:
         return TYPE_BOOL;
      case 9:
         return TYPE_STRING;
      case 10:
         return TYPE_GROUP;
      case 11:
         return TYPE_MESSAGE;
      case 12:
         return TYPE_BYTES;
      case 13:
         return TYPE_UINT32;
      case 14:
         return TYPE_ENUM;
      case 15:
         return TYPE_SFIXED32;
      case 16:
         return TYPE_SFIXED64;
      case 17:
         return TYPE_SINT32;
      case 18:
         return TYPE_SINT64;
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
      return (Descriptors$EnumDescriptor)DescriptorProtos$FieldDescriptorProto.getDescriptor().getEnumTypes().get(0);
   }

   public static DescriptorProtos$FieldDescriptorProto$Type valueOf(Descriptors$EnumValueDescriptor var0) {
      if(var0.getType() != getDescriptor()) {
         throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
      } else {
         return VALUES[var0.getIndex()];
      }
   }

   private DescriptorProtos$FieldDescriptorProto$Type(int var3, int var4) {
      this.index = var3;
      this.value = var4;
   }

   static {
      internalValueMap = new DescriptorProtos$FieldDescriptorProto$Type$1();
      VALUES = values();
   }
}
