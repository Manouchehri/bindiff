package com.google.protobuf;

import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$Builder;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;

final class GeneratedMessageLite$ExtensionDescriptor implements FieldSet$FieldDescriptorLite {
   final Internal$EnumLiteMap enumTypeMap;
   final int number;
   final WireFormat$FieldType type;
   final boolean isRepeated;
   final boolean isPacked;

   GeneratedMessageLite$ExtensionDescriptor(Internal$EnumLiteMap var1, int var2, WireFormat$FieldType var3, boolean var4, boolean var5) {
      this.enumTypeMap = var1;
      this.number = var2;
      this.type = var3;
      this.isRepeated = var4;
      this.isPacked = var5;
   }

   public int getNumber() {
      return this.number;
   }

   public WireFormat$FieldType getLiteType() {
      return this.type;
   }

   public WireFormat$JavaType getLiteJavaType() {
      return this.type.getJavaType();
   }

   public boolean isRepeated() {
      return this.isRepeated;
   }

   public boolean isPacked() {
      return this.isPacked;
   }

   public Internal$EnumLiteMap getEnumType() {
      return this.enumTypeMap;
   }

   public MessageLite$Builder internalMergeFrom(MessageLite$Builder var1, MessageLite var2) {
      return ((GeneratedMessageLite$Builder)var1).mergeFrom((GeneratedMessageLite)var2);
   }

   public int compareTo(GeneratedMessageLite$ExtensionDescriptor var1) {
      return this.number - var1.number;
   }
}
