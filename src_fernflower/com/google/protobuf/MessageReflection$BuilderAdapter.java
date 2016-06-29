package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistry$ExtensionInfo;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageReflection$MergeTarget;
import com.google.protobuf.MessageReflection$MergeTarget$ContainerType;
import com.google.protobuf.WireFormat$Utf8Validation;

class MessageReflection$BuilderAdapter implements MessageReflection$MergeTarget {
   private final Message$Builder builder;

   public Descriptors$Descriptor getDescriptorForType() {
      return this.builder.getDescriptorForType();
   }

   public MessageReflection$BuilderAdapter(Message$Builder var1) {
      this.builder = var1;
   }

   public Object getField(Descriptors$FieldDescriptor var1) {
      return this.builder.getField(var1);
   }

   public boolean hasField(Descriptors$FieldDescriptor var1) {
      return this.builder.hasField(var1);
   }

   public MessageReflection$MergeTarget setField(Descriptors$FieldDescriptor var1, Object var2) {
      this.builder.setField(var1, var2);
      return this;
   }

   public MessageReflection$MergeTarget clearField(Descriptors$FieldDescriptor var1) {
      this.builder.clearField(var1);
      return this;
   }

   public MessageReflection$MergeTarget setRepeatedField(Descriptors$FieldDescriptor var1, int var2, Object var3) {
      this.builder.setRepeatedField(var1, var2, var3);
      return this;
   }

   public MessageReflection$MergeTarget addRepeatedField(Descriptors$FieldDescriptor var1, Object var2) {
      this.builder.addRepeatedField(var1, var2);
      return this;
   }

   public boolean hasOneof(Descriptors$OneofDescriptor var1) {
      return this.builder.hasOneof(var1);
   }

   public MessageReflection$MergeTarget clearOneof(Descriptors$OneofDescriptor var1) {
      this.builder.clearOneof(var1);
      return this;
   }

   public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor var1) {
      return this.builder.getOneofFieldDescriptor(var1);
   }

   public MessageReflection$MergeTarget$ContainerType getContainerType() {
      return MessageReflection$MergeTarget$ContainerType.MESSAGE;
   }

   public ExtensionRegistry$ExtensionInfo findExtensionByName(ExtensionRegistry var1, String var2) {
      return var1.findImmutableExtensionByName(var2);
   }

   public ExtensionRegistry$ExtensionInfo findExtensionByNumber(ExtensionRegistry var1, Descriptors$Descriptor var2, int var3) {
      return var1.findImmutableExtensionByNumber(var2, var3);
   }

   public Object parseGroup(CodedInputStream var1, ExtensionRegistryLite var2, Descriptors$FieldDescriptor var3, Message var4) {
      Message$Builder var5;
      if(var4 != null) {
         var5 = var4.newBuilderForType();
      } else {
         var5 = this.builder.newBuilderForField(var3);
      }

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
      Message$Builder var5;
      if(var4 != null) {
         var5 = var4.newBuilderForType();
      } else {
         var5 = this.builder.newBuilderForField(var3);
      }

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
      Message$Builder var5;
      if(var4 != null) {
         var5 = var4.newBuilderForType();
      } else {
         var5 = this.builder.newBuilderForField(var3);
      }

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
      return var2 != null?new MessageReflection$BuilderAdapter(var2.newBuilderForType()):new MessageReflection$BuilderAdapter(this.builder.newBuilderForField(var1));
   }

   public WireFormat$Utf8Validation getUtf8Validation(Descriptors$FieldDescriptor var1) {
      return var1.needsUtf8Check()?WireFormat$Utf8Validation.STRICT:(!var1.isRepeated() && this.builder instanceof GeneratedMessage$Builder?WireFormat$Utf8Validation.LAZY:WireFormat$Utf8Validation.LOOSE);
   }

   public Object finish() {
      return this.builder.buildPartial();
   }
}
