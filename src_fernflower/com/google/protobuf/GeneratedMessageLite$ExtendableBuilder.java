package com.google.protobuf;

import com.google.protobuf.ExtensionLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$Builder;
import com.google.protobuf.GeneratedMessageLite$ExtendableMessage;
import com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder;
import com.google.protobuf.GeneratedMessageLite$GeneratedExtension;

public abstract class GeneratedMessageLite$ExtendableBuilder extends GeneratedMessageLite$Builder implements GeneratedMessageLite$ExtendableMessageOrBuilder {
   protected GeneratedMessageLite$ExtendableBuilder(GeneratedMessageLite$ExtendableMessage var1) {
      super(var1);
      ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions = ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions.clone();
   }

   void internalSetExtensionSet(FieldSet var1) {
      this.copyOnWrite();
      ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions = var1;
   }

   protected void copyOnWrite() {
      if(this.isBuilt) {
         super.copyOnWrite();
         ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions = ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions.clone();
      }
   }

   public final GeneratedMessageLite$ExtendableMessage buildPartial() {
      if(this.isBuilt) {
         return (GeneratedMessageLite$ExtendableMessage)this.instance;
      } else {
         ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions.makeImmutable();
         return (GeneratedMessageLite$ExtendableMessage)super.buildPartial();
      }
   }

   private void verifyExtensionContainingType(GeneratedMessageLite$GeneratedExtension var1) {
      if(var1.getContainingTypeDefaultInstance() != this.getDefaultInstanceForType()) {
         throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
      }
   }

   public final boolean hasExtension(ExtensionLite var1) {
      return ((GeneratedMessageLite$ExtendableMessage)this.instance).hasExtension(var1);
   }

   public final int getExtensionCount(ExtensionLite var1) {
      return ((GeneratedMessageLite$ExtendableMessage)this.instance).getExtensionCount(var1);
   }

   public final Object getExtension(ExtensionLite var1) {
      return ((GeneratedMessageLite$ExtendableMessage)this.instance).getExtension(var1);
   }

   public final Object getExtension(ExtensionLite var1, int var2) {
      return ((GeneratedMessageLite$ExtendableMessage)this.instance).getExtension(var1, var2);
   }

   public GeneratedMessageLite$ExtendableBuilder clone() {
      return (GeneratedMessageLite$ExtendableBuilder)super.clone();
   }

   public final GeneratedMessageLite$ExtendableBuilder setExtension(ExtensionLite var1, Object var2) {
      GeneratedMessageLite$GeneratedExtension var3 = GeneratedMessageLite.access$000(var1);
      this.verifyExtensionContainingType(var3);
      this.copyOnWrite();
      ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions.setField(var3.descriptor, var3.toFieldSetType(var2));
      return this;
   }

   public final GeneratedMessageLite$ExtendableBuilder setExtension(ExtensionLite var1, int var2, Object var3) {
      GeneratedMessageLite$GeneratedExtension var4 = GeneratedMessageLite.access$000(var1);
      this.verifyExtensionContainingType(var4);
      this.copyOnWrite();
      ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions.setRepeatedField(var4.descriptor, var2, var4.singularToFieldSetType(var3));
      return this;
   }

   public final GeneratedMessageLite$ExtendableBuilder addExtension(ExtensionLite var1, Object var2) {
      GeneratedMessageLite$GeneratedExtension var3 = GeneratedMessageLite.access$000(var1);
      this.verifyExtensionContainingType(var3);
      this.copyOnWrite();
      ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions.addRepeatedField(var3.descriptor, var3.singularToFieldSetType(var2));
      return this;
   }

   public final GeneratedMessageLite$ExtendableBuilder clearExtension(ExtensionLite var1) {
      GeneratedMessageLite$GeneratedExtension var2 = GeneratedMessageLite.access$000(var1);
      this.verifyExtensionContainingType(var2);
      this.copyOnWrite();
      ((GeneratedMessageLite$ExtendableMessage)this.instance).extensions.clearField(var2.descriptor);
      return this;
   }
}
