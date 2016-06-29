package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistry$ExtensionInfo;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageReflection$MergeTarget;
import com.google.protobuf.MessageReflection$MergeTarget$ContainerType;
import com.google.protobuf.WireFormat$Utf8Validation;

class MessageReflection$ExtensionAdapter implements MessageReflection$MergeTarget {
   private final FieldSet extensions;

   MessageReflection$ExtensionAdapter(FieldSet var1) {
      this.extensions = var1;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      throw new UnsupportedOperationException("getDescriptorForType() called on FieldSet object");
   }

   public Object getField(Descriptors$FieldDescriptor var1) {
      return this.extensions.getField(var1);
   }

   public boolean hasField(Descriptors$FieldDescriptor var1) {
      return this.extensions.hasField(var1);
   }

   public MessageReflection$MergeTarget setField(Descriptors$FieldDescriptor var1, Object var2) {
      this.extensions.setField(var1, var2);
      return this;
   }

   public MessageReflection$MergeTarget clearField(Descriptors$FieldDescriptor var1) {
      this.extensions.clearField(var1);
      return this;
   }

   public MessageReflection$MergeTarget setRepeatedField(Descriptors$FieldDescriptor var1, int var2, Object var3) {
      this.extensions.setRepeatedField(var1, var2, var3);
      return this;
   }

   public MessageReflection$MergeTarget addRepeatedField(Descriptors$FieldDescriptor var1, Object var2) {
      this.extensions.addRepeatedField(var1, var2);
      return this;
   }

   public boolean hasOneof(Descriptors$OneofDescriptor var1) {
      return false;
   }

   public MessageReflection$MergeTarget clearOneof(Descriptors$OneofDescriptor var1) {
      return this;
   }

   public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor var1) {
      return null;
   }

   public MessageReflection$MergeTarget$ContainerType getContainerType() {
      return MessageReflection$MergeTarget$ContainerType.EXTENSION_SET;
   }

   public ExtensionRegistry$ExtensionInfo findExtensionByName(ExtensionRegistry var1, String var2) {
      return var1.findImmutableExtensionByName(var2);
   }

   public ExtensionRegistry$ExtensionInfo findExtensionByNumber(ExtensionRegistry var1, Descriptors$Descriptor var2, int var3) {
      return var1.findImmutableExtensionByNumber(var2, var3);
   }

   public Object parseGroup(CodedInputStream var1, ExtensionRegistryLite var2, Descriptors$FieldDescriptor var3, Message var4) {
      Message$Builder var5 = var4.newBuilderForType();
      if(!var3.isRepeated()) {
         Message var6 = (Message)this.getField(var3);
         if(var6 != null) {
            var5.mergeFrom(var6);
         }
      }

      var1.readGroup(var3.getNumber(), (MessageLite$Builder)var5, var2);
      return var5.buildPartial();
   }

   public Object parseMessage(CodedInputStream var1, ExtensionRegistryLite var2, Descriptors$FieldDescriptor var3, Message var4) {
      Message$Builder var5 = var4.newBuilderForType();
      if(!var3.isRepeated()) {
         Message var6 = (Message)this.getField(var3);
         if(var6 != null) {
            var5.mergeFrom(var6);
         }
      }

      var1.readMessage((MessageLite$Builder)var5, var2);
      return var5.buildPartial();
   }

   public Object parseMessageFromBytes(ByteString var1, ExtensionRegistryLite var2, Descriptors$FieldDescriptor var3, Message var4) {
      Message$Builder var5 = var4.newBuilderForType();
      if(!var3.isRepeated()) {
         Message var6 = (Message)this.getField(var3);
         if(var6 != null) {
            var5.mergeFrom(var6);
         }
      }

      var5.mergeFrom(var1, var2);
      return var5.buildPartial();
   }

   public MessageReflection$MergeTarget newMergeTargetForField(Descriptors$FieldDescriptor var1, Message var2) {
      throw new UnsupportedOperationException("newMergeTargetForField() called on FieldSet object");
   }

   public WireFormat$Utf8Validation getUtf8Validation(Descriptors$FieldDescriptor var1) {
      return var1.needsUtf8Check()?WireFormat$Utf8Validation.STRICT:WireFormat$Utf8Validation.LOOSE;
   }

   public Object finish() {
      throw new UnsupportedOperationException("finish() called on FieldSet object");
   }
}
