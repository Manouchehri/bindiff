package com.google.protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.Extension;
import com.google.protobuf.ExtensionLite;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$1;
import com.google.protobuf.GeneratedMessage$ExtendableBuilder;
import com.google.protobuf.GeneratedMessage$ExtendableMessage$ExtensionWriter;
import com.google.protobuf.GeneratedMessage$ExtendableMessageOrBuilder;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.MessageReflection$ExtensionAdapter;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.util.Collections;
import java.util.Map;

public abstract class GeneratedMessage$ExtendableMessage extends GeneratedMessage implements GeneratedMessage$ExtendableMessageOrBuilder {
   private final FieldSet extensions;

   protected GeneratedMessage$ExtendableMessage() {
      this.extensions = FieldSet.newFieldSet();
   }

   protected GeneratedMessage$ExtendableMessage(GeneratedMessage$ExtendableBuilder var1) {
      super(var1);
      this.extensions = GeneratedMessage$ExtendableBuilder.access$400(var1);
   }

   private void verifyExtensionContainingType(Extension var1) {
      if(var1.getDescriptor().getContainingType() != this.getDescriptorForType()) {
         String var2 = String.valueOf(String.valueOf(var1.getDescriptor().getContainingType().getFullName()));
         String var3 = String.valueOf(String.valueOf(this.getDescriptorForType().getFullName()));
         throw new IllegalArgumentException((new StringBuilder(62 + var2.length() + var3.length())).append("Extension is for type \"").append(var2).append("\" which does not match message type \"").append(var3).append("\".").toString());
      }
   }

   public final boolean hasExtension(ExtensionLite var1) {
      Extension var2 = GeneratedMessage.access$500(var1);
      this.verifyExtensionContainingType(var2);
      return this.extensions.hasField(var2.getDescriptor());
   }

   public final int getExtensionCount(ExtensionLite var1) {
      Extension var2 = GeneratedMessage.access$500(var1);
      this.verifyExtensionContainingType(var2);
      Descriptors$FieldDescriptor var3 = var2.getDescriptor();
      return this.extensions.getRepeatedFieldCount(var3);
   }

   public final Object getExtension(ExtensionLite var1) {
      Extension var2 = GeneratedMessage.access$500(var1);
      this.verifyExtensionContainingType(var2);
      Descriptors$FieldDescriptor var3 = var2.getDescriptor();
      Object var4 = this.extensions.getField(var3);
      return var4 == null?(var3.isRepeated()?Collections.emptyList():(var3.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE?var2.getMessageDefaultInstance():var2.fromReflectionType(var3.getDefaultValue()))):var2.fromReflectionType(var4);
   }

   public final Object getExtension(ExtensionLite var1, int var2) {
      Extension var3 = GeneratedMessage.access$500(var1);
      this.verifyExtensionContainingType(var3);
      Descriptors$FieldDescriptor var4 = var3.getDescriptor();
      return var3.singularFromReflectionType(this.extensions.getRepeatedField(var4, var2));
   }

   protected boolean extensionsAreInitialized() {
      return this.extensions.isInitialized();
   }

   public boolean isInitialized() {
      return super.isInitialized() && this.extensionsAreInitialized();
   }

   protected boolean parseUnknownField(CodedInputStream var1, UnknownFieldSet$Builder var2, ExtensionRegistryLite var3, int var4) {
      return MessageReflection.mergeFieldFrom(var1, var2, var3, this.getDescriptorForType(), new MessageReflection$ExtensionAdapter(this.extensions), var4);
   }

   protected void makeExtensionsImmutable() {
      this.extensions.makeImmutable();
   }

   protected GeneratedMessage$ExtendableMessage$ExtensionWriter newExtensionWriter() {
      return new GeneratedMessage$ExtendableMessage$ExtensionWriter(this, false, (GeneratedMessage$1)null);
   }

   protected GeneratedMessage$ExtendableMessage$ExtensionWriter newMessageSetExtensionWriter() {
      return new GeneratedMessage$ExtendableMessage$ExtensionWriter(this, true, (GeneratedMessage$1)null);
   }

   protected int extensionsSerializedSize() {
      return this.extensions.getSerializedSize();
   }

   protected int extensionsSerializedSizeAsMessageSet() {
      return this.extensions.getMessageSetSerializedSize();
   }

   protected Map getExtensionFields() {
      return this.extensions.getAllFields();
   }

   public Map getAllFields() {
      Map var1 = GeneratedMessage.access$800(this, false);
      var1.putAll(this.getExtensionFields());
      return Collections.unmodifiableMap(var1);
   }

   public Map getAllFieldsRaw() {
      Map var1 = GeneratedMessage.access$800(this, false);
      var1.putAll(this.getExtensionFields());
      return Collections.unmodifiableMap(var1);
   }

   public boolean hasField(Descriptors$FieldDescriptor var1) {
      if(var1.isExtension()) {
         this.verifyContainingType(var1);
         return this.extensions.hasField(var1);
      } else {
         return super.hasField(var1);
      }
   }

   public Object getField(Descriptors$FieldDescriptor var1) {
      if(var1.isExtension()) {
         this.verifyContainingType(var1);
         Object var2 = this.extensions.getField(var1);
         return var2 == null?(var1.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE?DynamicMessage.getDefaultInstance(var1.getMessageType()):var1.getDefaultValue()):var2;
      } else {
         return super.getField(var1);
      }
   }

   public int getRepeatedFieldCount(Descriptors$FieldDescriptor var1) {
      if(var1.isExtension()) {
         this.verifyContainingType(var1);
         return this.extensions.getRepeatedFieldCount(var1);
      } else {
         return super.getRepeatedFieldCount(var1);
      }
   }

   public Object getRepeatedField(Descriptors$FieldDescriptor var1, int var2) {
      if(var1.isExtension()) {
         this.verifyContainingType(var1);
         return this.extensions.getRepeatedField(var1, var2);
      } else {
         return super.getRepeatedField(var1, var2);
      }
   }

   private void verifyContainingType(Descriptors$FieldDescriptor var1) {
      if(var1.getContainingType() != this.getDescriptorForType()) {
         throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      }
   }

   // $FF: synthetic method
   static FieldSet access$600(GeneratedMessage$ExtendableMessage var0) {
      return var0.extensions;
   }
}
