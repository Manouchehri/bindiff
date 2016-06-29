package com.google.protos.BinExport;

import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protos.BinExport.BinExport$Callgraph$Vertex;
import com.google.protos.BinExport.BinExport$Callgraph$Vertex$FunctionType$1;

public enum BinExport$Callgraph$Vertex$FunctionType implements ProtocolMessageEnum {
   NORMAL(0, 0),
   LIBRARY(1, 1),
   IMPORTED(2, 2),
   THUNK(3, 3),
   INVALID(4, 4);

   public static final int NORMAL_VALUE = 0;
   public static final int LIBRARY_VALUE = 1;
   public static final int IMPORTED_VALUE = 2;
   public static final int THUNK_VALUE = 3;
   public static final int INVALID_VALUE = 4;
   private static Internal$EnumLiteMap internalValueMap;
   private static final BinExport$Callgraph$Vertex$FunctionType[] VALUES;
   private final int index;
   private final int value;

   public final int getNumber() {
      return this.value;
   }

   public static BinExport$Callgraph$Vertex$FunctionType valueOf(int var0) {
      switch(var0) {
      case 0:
         return NORMAL;
      case 1:
         return LIBRARY;
      case 2:
         return IMPORTED;
      case 3:
         return THUNK;
      case 4:
         return INVALID;
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
      return (Descriptors$EnumDescriptor)BinExport$Callgraph$Vertex.getDescriptor().getEnumTypes().get(0);
   }

   public static BinExport$Callgraph$Vertex$FunctionType valueOf(Descriptors$EnumValueDescriptor var0) {
      if(var0.getType() != getDescriptor()) {
         throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
      } else {
         return VALUES[var0.getIndex()];
      }
   }

   private BinExport$Callgraph$Vertex$FunctionType(int var3, int var4) {
      this.index = var3;
      this.value = var4;
   }

   static {
      internalValueMap = new BinExport$Callgraph$Vertex$FunctionType$1();
      VALUES = values();
   }
}
