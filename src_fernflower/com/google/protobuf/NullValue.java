package com.google.protobuf;

import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.NullValue$1;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.StructProto;

public enum NullValue implements ProtocolMessageEnum {
   NULL_VALUE(0, 0),
   UNRECOGNIZED(-1, -1);

   public static final int NULL_VALUE_VALUE = 0;
   private static Internal$EnumLiteMap internalValueMap;
   private static final NullValue[] VALUES;
   private final int index;
   private final int value;

   public final int getNumber() {
      if(this.index == -1) {
         throw new IllegalArgumentException("Can\'t get the number of an unknown enum value.");
      } else {
         return this.value;
      }
   }

   public static NullValue valueOf(int var0) {
      switch(var0) {
      case 0:
         return NULL_VALUE;
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
      return (Descriptors$EnumDescriptor)StructProto.getDescriptor().getEnumTypes().get(0);
   }

   public static NullValue valueOf(Descriptors$EnumValueDescriptor var0) {
      if(var0.getType() != getDescriptor()) {
         throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
      } else {
         return var0.getIndex() == -1?UNRECOGNIZED:VALUES[var0.getIndex()];
      }
   }

   private NullValue(int var3, int var4) {
      this.index = var3;
      this.value = var4;
   }

   static {
      internalValueMap = new NullValue$1();
      VALUES = values();
   }
}
