package com.google.protobuf;

import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Field;
import com.google.protobuf.Field$Kind$1;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;

public enum Field$Kind implements ProtocolMessageEnum {
   TYPE_UNKNOWN(0, 0),
   TYPE_DOUBLE(1, 1),
   TYPE_FLOAT(2, 2),
   TYPE_INT64(3, 3),
   TYPE_UINT64(4, 4),
   TYPE_INT32(5, 5),
   TYPE_FIXED64(6, 6),
   TYPE_FIXED32(7, 7),
   TYPE_BOOL(8, 8),
   TYPE_STRING(9, 9),
   TYPE_MESSAGE(10, 11),
   TYPE_BYTES(11, 12),
   TYPE_UINT32(12, 13),
   TYPE_ENUM(13, 14),
   TYPE_SFIXED32(14, 15),
   TYPE_SFIXED64(15, 16),
   TYPE_SINT32(16, 17),
   TYPE_SINT64(17, 18),
   UNRECOGNIZED(-1, -1);

   public static final int TYPE_UNKNOWN_VALUE = 0;
   public static final int TYPE_DOUBLE_VALUE = 1;
   public static final int TYPE_FLOAT_VALUE = 2;
   public static final int TYPE_INT64_VALUE = 3;
   public static final int TYPE_UINT64_VALUE = 4;
   public static final int TYPE_INT32_VALUE = 5;
   public static final int TYPE_FIXED64_VALUE = 6;
   public static final int TYPE_FIXED32_VALUE = 7;
   public static final int TYPE_BOOL_VALUE = 8;
   public static final int TYPE_STRING_VALUE = 9;
   public static final int TYPE_MESSAGE_VALUE = 11;
   public static final int TYPE_BYTES_VALUE = 12;
   public static final int TYPE_UINT32_VALUE = 13;
   public static final int TYPE_ENUM_VALUE = 14;
   public static final int TYPE_SFIXED32_VALUE = 15;
   public static final int TYPE_SFIXED64_VALUE = 16;
   public static final int TYPE_SINT32_VALUE = 17;
   public static final int TYPE_SINT64_VALUE = 18;
   private static Internal$EnumLiteMap internalValueMap;
   private static final Field$Kind[] VALUES;
   private final int index;
   private final int value;

   public final int getNumber() {
      if(this.index == -1) {
         throw new IllegalArgumentException("Can\'t get the number of an unknown enum value.");
      } else {
         return this.value;
      }
   }

   public static Field$Kind valueOf(int var0) {
      switch(var0) {
      case 0:
         return TYPE_UNKNOWN;
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
      default:
         return null;
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
      return (Descriptors$EnumDescriptor)Field.getDescriptor().getEnumTypes().get(0);
   }

   public static Field$Kind valueOf(Descriptors$EnumValueDescriptor var0) {
      if(var0.getType() != getDescriptor()) {
         throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
      } else {
         return var0.getIndex() == -1?UNRECOGNIZED:VALUES[var0.getIndex()];
      }
   }

   private Field$Kind(int var3, int var4) {
      this.index = var3;
      this.value = var4;
   }

   static {
      internalValueMap = new Field$Kind$1();
      VALUES = values();
   }
}
