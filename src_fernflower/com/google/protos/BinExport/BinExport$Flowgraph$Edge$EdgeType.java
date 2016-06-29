package com.google.protos.BinExport;

import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protos.BinExport.BinExport$Flowgraph$Edge;
import com.google.protos.BinExport.BinExport$Flowgraph$Edge$EdgeType$1;

public enum BinExport$Flowgraph$Edge$EdgeType implements ProtocolMessageEnum {
   CONDITION_TRUE(0, 1),
   CONDITION_FALSE(1, 2),
   UNCONDITIONAL(2, 3),
   SWITCH(3, 4);

   public static final int CONDITION_TRUE_VALUE = 1;
   public static final int CONDITION_FALSE_VALUE = 2;
   public static final int UNCONDITIONAL_VALUE = 3;
   public static final int SWITCH_VALUE = 4;
   private static Internal$EnumLiteMap internalValueMap;
   private static final BinExport$Flowgraph$Edge$EdgeType[] VALUES;
   private final int index;
   private final int value;

   public final int getNumber() {
      return this.value;
   }

   public static BinExport$Flowgraph$Edge$EdgeType valueOf(int var0) {
      switch(var0) {
      case 1:
         return CONDITION_TRUE;
      case 2:
         return CONDITION_FALSE;
      case 3:
         return UNCONDITIONAL;
      case 4:
         return SWITCH;
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
      return (Descriptors$EnumDescriptor)BinExport$Flowgraph$Edge.getDescriptor().getEnumTypes().get(0);
   }

   public static BinExport$Flowgraph$Edge$EdgeType valueOf(Descriptors$EnumValueDescriptor var0) {
      if(var0.getType() != getDescriptor()) {
         throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
      } else {
         return VALUES[var0.getIndex()];
      }
   }

   private BinExport$Flowgraph$Edge$EdgeType(int var3, int var4) {
      this.index = var3;
      this.value = var4;
   }

   static {
      internalValueMap = new BinExport$Flowgraph$Edge$EdgeType$1();
      VALUES = values();
   }
}
