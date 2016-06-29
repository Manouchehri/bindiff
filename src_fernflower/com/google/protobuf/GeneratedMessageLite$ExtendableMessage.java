package com.google.protobuf;

import com.google.protobuf.ExtensionLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$1;
import com.google.protobuf.GeneratedMessageLite$ExtendableMessage$ExtensionWriter;
import com.google.protobuf.GeneratedMessageLite$ExtendableMessageOrBuilder;
import com.google.protobuf.GeneratedMessageLite$GeneratedExtension;

public abstract class GeneratedMessageLite$ExtendableMessage extends GeneratedMessageLite implements GeneratedMessageLite$ExtendableMessageOrBuilder {
   protected FieldSet extensions = FieldSet.newFieldSet();

   protected final void mergeExtensionFields(GeneratedMessageLite$ExtendableMessage var1) {
      if(this.extensions.isImmutable()) {
         this.extensions = this.extensions.clone();
      }

      this.extensions.mergeFrom(var1.extensions);
   }

   private void verifyExtensionContainingType(GeneratedMessageLite$GeneratedExtension var1) {
      if(var1.getContainingTypeDefaultInstance() != this.getDefaultInstanceForType()) {
         throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
      }
   }

   public final boolean hasExtension(ExtensionLite var1) {
      GeneratedMessageLite$GeneratedExtension var2 = GeneratedMessageLite.access$000(var1);
      this.verifyExtensionContainingType(var2);
      return this.extensions.hasField(var2.descriptor);
   }

   public final int getExtensionCount(ExtensionLite var1) {
      GeneratedMessageLite$GeneratedExtension var2 = GeneratedMessageLite.access$000(var1);
      this.verifyExtensionContainingType(var2);
      return this.extensions.getRepeatedFieldCount(var2.descriptor);
   }

   public final Object getExtension(ExtensionLite var1) {
      GeneratedMessageLite$GeneratedExtension var2 = GeneratedMessageLite.access$000(var1);
      this.verifyExtensionContainingType(var2);
      Object var3 = this.extensions.getField(var2.descriptor);
      return var3 == null?var2.defaultValue:var2.fromFieldSetType(var3);
   }

   public final Object getExtension(ExtensionLite var1, int var2) {
      GeneratedMessageLite$GeneratedExtension var3 = GeneratedMessageLite.access$000(var1);
      this.verifyExtensionContainingType(var3);
      return var3.singularFromFieldSetType(this.extensions.getRepeatedField(var3.descriptor, var2));
   }

   protected boolean extensionsAreInitialized() {
      return this.extensions.isInitialized();
   }

   protected static void makeExtensionsImmutable(FieldSet var0) {
      var0.makeImmutable();
   }

   protected GeneratedMessageLite$ExtendableMessage$ExtensionWriter newExtensionWriter() {
      return new GeneratedMessageLite$ExtendableMessage$ExtensionWriter(this, false, (GeneratedMessageLite$1)null);
   }

   protected GeneratedMessageLite$ExtendableMessage$ExtensionWriter newMessageSetExtensionWriter() {
      return new GeneratedMessageLite$ExtendableMessage$ExtensionWriter(this, true, (GeneratedMessageLite$1)null);
   }

   protected int extensionsSerializedSize() {
      return this.extensions.getSerializedSize();
   }

   protected int extensionsSerializedSizeAsMessageSet() {
      return this.extensions.getMessageSetSerializedSize();
   }
}
