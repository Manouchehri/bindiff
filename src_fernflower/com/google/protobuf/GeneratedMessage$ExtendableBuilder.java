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
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$ExtendableMessage;
import com.google.protobuf.GeneratedMessage$ExtendableMessageOrBuilder;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.MessageReflection$BuilderAdapter;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.util.Collections;
import java.util.Map;

public abstract class GeneratedMessage$ExtendableBuilder extends GeneratedMessage$Builder implements GeneratedMessage$ExtendableMessageOrBuilder {
   private FieldSet extensions = FieldSet.emptySet();

   protected GeneratedMessage$ExtendableBuilder() {
   }

   protected GeneratedMessage$ExtendableBuilder(GeneratedMessage$BuilderParent var1) {
      super(var1);
   }

   void internalSetExtensionSet(FieldSet var1) {
      this.extensions = var1;
   }

   public GeneratedMessage$ExtendableBuilder clear() {
      this.extensions = FieldSet.emptySet();
      return (GeneratedMessage$ExtendableBuilder)super.clear();
   }

   public GeneratedMessage$ExtendableBuilder clone() {
      return (GeneratedMessage$ExtendableBuilder)super.clone();
   }

   private void ensureExtensionsIsMutable() {
      if(this.extensions.isImmutable()) {
         this.extensions = this.extensions.clone();
      }

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

   public final GeneratedMessage$ExtendableBuilder setExtension(ExtensionLite var1, Object var2) {
      Extension var3 = GeneratedMessage.access$500(var1);
      this.verifyExtensionContainingType(var3);
      this.ensureExtensionsIsMutable();
      Descriptors$FieldDescriptor var4 = var3.getDescriptor();
      this.extensions.setField(var4, var3.toReflectionType(var2));
      this.onChanged();
      return this;
   }

   public final GeneratedMessage$ExtendableBuilder setExtension(ExtensionLite var1, int var2, Object var3) {
      Extension var4 = GeneratedMessage.access$500(var1);
      this.verifyExtensionContainingType(var4);
      this.ensureExtensionsIsMutable();
      Descriptors$FieldDescriptor var5 = var4.getDescriptor();
      this.extensions.setRepeatedField(var5, var2, var4.singularToReflectionType(var3));
      this.onChanged();
      return this;
   }

   public final GeneratedMessage$ExtendableBuilder addExtension(ExtensionLite var1, Object var2) {
      Extension var3 = GeneratedMessage.access$500(var1);
      this.verifyExtensionContainingType(var3);
      this.ensureExtensionsIsMutable();
      Descriptors$FieldDescriptor var4 = var3.getDescriptor();
      this.extensions.addRepeatedField(var4, var3.singularToReflectionType(var2));
      this.onChanged();
      return this;
   }

   public final GeneratedMessage$ExtendableBuilder clearExtension(ExtensionLite var1) {
      Extension var2 = GeneratedMessage.access$500(var1);
      this.verifyExtensionContainingType(var2);
      this.ensureExtensionsIsMutable();
      this.extensions.clearField(var2.getDescriptor());
      this.onChanged();
      return this;
   }

   protected boolean extensionsAreInitialized() {
      return this.extensions.isInitialized();
   }

   private FieldSet buildExtensions() {
      this.extensions.makeImmutable();
      return this.extensions;
   }

   public boolean isInitialized() {
      return super.isInitialized() && this.extensionsAreInitialized();
   }

   protected boolean parseUnknownField(CodedInputStream var1, UnknownFieldSet$Builder var2, ExtensionRegistryLite var3, int var4) {
      return MessageReflection.mergeFieldFrom(var1, var2, var3, this.getDescriptorForType(), new MessageReflection$BuilderAdapter(this), var4);
   }

   public Map getAllFields() {
      Map var1 = GeneratedMessage$Builder.access$900(this);
      var1.putAll(this.extensions.getAllFields());
      return Collections.unmodifiableMap(var1);
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

   public boolean hasField(Descriptors$FieldDescriptor var1) {
      if(var1.isExtension()) {
         this.verifyContainingType(var1);
         return this.extensions.hasField(var1);
      } else {
         return super.hasField(var1);
      }
   }

   public GeneratedMessage$ExtendableBuilder setField(Descriptors$FieldDescriptor var1, Object var2) {
      if(var1.isExtension()) {
         this.verifyContainingType(var1);
         this.ensureExtensionsIsMutable();
         this.extensions.setField(var1, var2);
         this.onChanged();
         return this;
      } else {
         return (GeneratedMessage$ExtendableBuilder)super.setField(var1, var2);
      }
   }

   public GeneratedMessage$ExtendableBuilder clearField(Descriptors$FieldDescriptor var1) {
      if(var1.isExtension()) {
         this.verifyContainingType(var1);
         this.ensureExtensionsIsMutable();
         this.extensions.clearField(var1);
         this.onChanged();
         return this;
      } else {
         return (GeneratedMessage$ExtendableBuilder)super.clearField(var1);
      }
   }

   public GeneratedMessage$ExtendableBuilder setRepeatedField(Descriptors$FieldDescriptor var1, int var2, Object var3) {
      if(var1.isExtension()) {
         this.verifyContainingType(var1);
         this.ensureExtensionsIsMutable();
         this.extensions.setRepeatedField(var1, var2, var3);
         this.onChanged();
         return this;
      } else {
         return (GeneratedMessage$ExtendableBuilder)super.setRepeatedField(var1, var2, var3);
      }
   }

   public GeneratedMessage$ExtendableBuilder addRepeatedField(Descriptors$FieldDescriptor var1, Object var2) {
      if(var1.isExtension()) {
         this.verifyContainingType(var1);
         this.ensureExtensionsIsMutable();
         this.extensions.addRepeatedField(var1, var2);
         this.onChanged();
         return this;
      } else {
         return (GeneratedMessage$ExtendableBuilder)super.addRepeatedField(var1, var2);
      }
   }

   protected final void mergeExtensionFields(GeneratedMessage$ExtendableMessage var1) {
      this.ensureExtensionsIsMutable();
      this.extensions.mergeFrom(GeneratedMessage$ExtendableMessage.access$600(var1));
      this.onChanged();
   }

   private void verifyContainingType(Descriptors$FieldDescriptor var1) {
      if(var1.getContainingType() != this.getDescriptorForType()) {
         throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      }
   }

   // $FF: synthetic method
   static FieldSet access$400(GeneratedMessage$ExtendableBuilder var0) {
      return var0.buildExtensions();
   }
}
