package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.BytesValue$1;
import com.google.protobuf.BytesValueOrBuilder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;

public final class BytesValue$Builder extends GeneratedMessage$Builder implements BytesValueOrBuilder {
   private ByteString value_;

   public static final Descriptors$Descriptor getDescriptor() {
      return WrappersProto.internal_static_google_protobuf_BytesValue_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return WrappersProto.internal_static_google_protobuf_BytesValue_fieldAccessorTable.ensureFieldAccessorsInitialized(BytesValue.class, BytesValue$Builder.class);
   }

   private BytesValue$Builder() {
      this.value_ = ByteString.EMPTY;
      this.maybeForceBuilderInitialization();
   }

   private BytesValue$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.value_ = ByteString.EMPTY;
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public BytesValue$Builder clear() {
      super.clear();
      this.value_ = ByteString.EMPTY;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return WrappersProto.internal_static_google_protobuf_BytesValue_descriptor;
   }

   public BytesValue getDefaultInstanceForType() {
      return BytesValue.getDefaultInstance();
   }

   public BytesValue build() {
      BytesValue var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public BytesValue buildPartial() {
      BytesValue var1 = new BytesValue(this, (BytesValue$1)null);
      BytesValue.access$302(var1, this.value_);
      this.onBuilt();
      return var1;
   }

   public BytesValue$Builder mergeFrom(Message var1) {
      if(var1 instanceof BytesValue) {
         return this.mergeFrom((BytesValue)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public BytesValue$Builder mergeFrom(BytesValue var1) {
      if(var1 == BytesValue.getDefaultInstance()) {
         return this;
      } else {
         if(var1.getValue() != ByteString.EMPTY) {
            this.setValue(var1.getValue());
         }

         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public BytesValue$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      BytesValue var3 = null;

      try {
         var3 = (BytesValue)BytesValue.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (BytesValue)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public ByteString getValue() {
      return this.value_;
   }

   public BytesValue$Builder setValue(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.value_ = var1;
         this.onChanged();
         return this;
      }
   }

   public BytesValue$Builder clearValue() {
      this.value_ = BytesValue.getDefaultInstance().getValue();
      this.onChanged();
      return this;
   }

   public final BytesValue$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final BytesValue$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   BytesValue$Builder(BytesValue$1 var1) {
      this();
   }

   // $FF: synthetic method
   BytesValue$Builder(GeneratedMessage$BuilderParent var1, BytesValue$1 var2) {
      this(var1);
   }
}
