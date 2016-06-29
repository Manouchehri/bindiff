package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FileOptions;
import com.google.protobuf.DescriptorProtos$FileOptions$OptimizeMode$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;

public enum DescriptorProtos$FileOptions$OptimizeMode implements ProtocolMessageEnum {
   SPEED(0, 1),
   CODE_SIZE(1, 2),
   LITE_RUNTIME(2, 3);

   public static final int SPEED_VALUE = 1;
   public static final int CODE_SIZE_VALUE = 2;
   public static final int LITE_RUNTIME_VALUE = 3;
   private static Internal$EnumLiteMap internalValueMap;
   private static final DescriptorProtos$FileOptions$OptimizeMode[] VALUES;
   private final int index;
   private final int value;

   public final int getNumber() {
      return this.value;
   }

   public static DescriptorProtos$FileOptions$OptimizeMode valueOf(int var0) {
      switch(var0) {
      case 1:
         return SPEED;
      case 2:
         return CODE_SIZE;
      case 3:
         return LITE_RUNTIME;
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
      return (Descriptors$EnumDescriptor)DescriptorProtos$FileOptions.getDescriptor().getEnumTypes().get(0);
   }

   public static DescriptorProtos$FileOptions$OptimizeMode valueOf(Descriptors$EnumValueDescriptor var0) {
      if(var0.getType() != getDescriptor()) {
         throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
      } else {
         return VALUES[var0.getIndex()];
      }
   }

   private DescriptorProtos$FileOptions$OptimizeMode(int var3, int var4) {
      this.index = var3;
      this.value = var4;
   }

   static {
      internalValueMap = new DescriptorProtos$FileOptions$OptimizeMode$1();
      VALUES = values();
   }
}
